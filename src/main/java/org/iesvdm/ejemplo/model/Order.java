package org.iesvdm.ejemplo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    // Attibutes
    private int id;
    private BigDecimal total;
    private Date date;
    private Client client;
    private Commercial commercial;
}
