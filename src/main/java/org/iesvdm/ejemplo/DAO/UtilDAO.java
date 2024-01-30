package org.iesvdm.ejemplo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import org.iesvdm.ejemplo.model.*;

public class UtilDAO {

    // Methods
    public static Order newOrder(ResultSet rs) throws SQLException {
        return new Order(rs.getInt("id"),
                rs.getBigDecimal("total"),
                rs.getDate("date"),
                new Client(rs.getInt("C.id"),
                        rs.getString("C.name"),
                        rs.getString("C.lastname1"),
                        rs.getString("C.lastname2"),
                        rs.getString("C.city"),
                        rs.getInt("C.category"),
                        rs.getString("C.email")
                ),
                new Commercial(rs.getInt("CO.id"),
                        rs.getString("CO.name"),
                        rs.getString("CO.lastname1"),
                        rs.getString("CO.lastname2"),
                        rs.getBigDecimal("CO.commission")
                )
        );
    }
    public static Client newClient(ResultSet rs) throws SQLException {
        return new Client(rs.getInt("id"),
                rs.getString("name"),
                rs.getString("lastname1"),
                rs.getString("lastname2"),
                rs.getString("city"),
                rs.getInt("category"),
                rs.getString("email")
        );
    }

    public static Commercial newCommercial(ResultSet rs) throws SQLException {
        return new Commercial(rs.getInt("id")
                , rs.getString("name")
                , rs.getString("lastname1")
                , rs.getString("lastname2")
                , rs.getBigDecimal("commisson"));
    }
}
