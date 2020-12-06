package ru.rxnnct.currencyconverter.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rxnnct.currencyconverter.domain.Calculation;

public interface CalculationRepo extends JpaRepository<Calculation, Long> {
}
