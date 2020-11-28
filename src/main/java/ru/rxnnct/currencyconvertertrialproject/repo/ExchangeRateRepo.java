package ru.rxnnct.currencyconvertertrialproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rxnnct.currencyconvertertrialproject.domain.ExchangeRate;

public interface ExchangeRateRepo extends JpaRepository<ExchangeRate, Long> {
}
