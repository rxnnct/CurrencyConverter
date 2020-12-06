package ru.rxnnct.currencyconverter.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * one row table
 */

@Entity
@Table(name = "application_state")
@Data
public class ApplicationState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "last_download_date")
    private String lastDownloadDate;
}
