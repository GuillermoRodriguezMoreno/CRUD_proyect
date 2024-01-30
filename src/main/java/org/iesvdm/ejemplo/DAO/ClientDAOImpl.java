package org.iesvdm.ejemplo.DAO;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.ejemplo.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class ClientDAOImpl implements ClientDAO<Client> {

    // JDBCTemplate inyection
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Client client) {

        // SQL STRING
        String sqlInsert = """
                INSERT INTO order (name, lastname1, lastname2, city, category, email)
                    VALUES (?, ?, ?, ?, ?, ?);
                """;

        // KeyHolder
        KeyHolder keyHolder = new GeneratedKeyHolder();

        // Build and execute insert
        int rows = this.jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sqlInsert, new String[] { "id" });
            int idx = 1;
            ps.setString(idx++, client.getName());
            ps.setString(idx++, client.getLastName1());
            ps.setString(idx++, client.getLastName2());
            ps.setString(idx++, client.getCity());
            ps.setInt(idx++, client.getCategory());
            ps.setString(idx, client.getEmail());
            return ps;
        }, keyHolder);

        // Log info
        log.info("Rows inserted {}", rows);
        log.debug("Client with id = {} inserted successfully",keyHolder.getKey().intValue());

        client.setId(keyHolder.getKey().intValue());
    }

    @Override
    public List<Client> getAll() {

        // SQL String
        String sqlQuery = """
                SELECT * FROM client;
                """;

        // Execute query
        List<Client> clientList = this.jdbcTemplate.query(sqlQuery, (rs, rowNum) -> UtilDAO.newClient(rs));

        return clientList;
    }

    @Override
    public Optional<Client> find(int id) {

        // SQL String
        String sqlString = """
                SELECT * FROM client WHERE id=?;
                """;

        // Execute query
        Client client = this.jdbcTemplate.queryForObject(sqlString, (rs, rowNum) -> UtilDAO.newClient(rs), id);

        // Found
        if(client != null)
            return Optional.of(client);

        // Not found
        log.debug("Client not found", id);
        return Optional.empty();
    }

    @Override
    public void update(Client client) {

        // SQL String
        String sqlString = """
                UPDATE client SET name=?, lastname1=?, lastname2=?, city=?, category=?, email=?
                    WHERE id=?;
                """;

        // Execute update
        this.jdbcTemplate.update(sqlString,
                client.getName(),
                client.getLastName1(),
                client.getLastName2(),
                client.getCity(),
                client.getCategory(),
                client.getEmail(),
                client.getId());
    }

    @Override
    public void delete(int id) {

        // SQL String
        String sqlString = """
                DELETE FROM client WHERE id=?;
                """;

        this.jdbcTemplate.update(sqlString, id);
    }
}
