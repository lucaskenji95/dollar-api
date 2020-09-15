package com.dollarapi.demo.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Dollar")
public class Dollar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "dollar_date")
    private Date dollarDate;

    private BigDecimal buy;

    private BigDecimal sell;

}
