package ru.rxnnct.currencyconvertertrialproject.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "calculation_journal")
@Data
public class Calculation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "currency_from")
    private Long currencyFrom;

    @Column(name = "currency_to")
    private Long currencyTo;

    @Column(name = "amount_from")
    private Long amountFrom;

    @Column(name = "amount_to")
    private Long amountTo;

    @Column(name = "date")
    private String date;
}
