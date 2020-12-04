package ru.rxnnct.currencyconvertertrialproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rxnnct.currencyconvertertrialproject.domain.ApplicationState;

public interface ApplicationStateRepo extends JpaRepository<ApplicationState, Long> {
}
