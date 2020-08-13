package com.dollarapi.demo.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
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

    private Float buy;

    private Float sell;

}
