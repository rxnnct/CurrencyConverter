package ru.rxnnct.currencyconverter.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rxnnct.currencyconverter.domain.ApplicationState;

public interface ApplicationStateRepo extends JpaRepository<ApplicationState, Long> {
}
