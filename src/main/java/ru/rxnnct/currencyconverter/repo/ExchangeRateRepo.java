package ru.rxnnct.currencyconverter.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rxnnct.currencyconverter.domain.ExchangeRate;

public interface ExchangeRateRepo extends JpaRepository<ExchangeRate, Long> {
}
