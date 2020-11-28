package ru.rxnnct.currencyconvertertrialproject.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "exchange_rate_journal")
@Data
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cbr_id")
    private String CbrId;

    @Column(name = "num_code")
    private Long NumCode;

    @Column(name = "nominal")
    private String nominal;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private Long recordDateTime; //As a number with 4 decimal places instead of a real. Example: 20,1819

    @Column(name = "date")
    private String date;
}
