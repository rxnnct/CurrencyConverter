package ru.rxnnct.currencyconvertertrialproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rxnnct.currencyconvertertrialproject.domain.Calculation;

public interface CalculationRepo extends JpaRepository<Calculation, Long> {
}
