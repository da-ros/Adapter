package com.ups.group2.adapter.repository;

//import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import com.ups.group2.adapter.model.FahrenheitSensor;

@Repository
public interface FahrenheitSensorRepository extends JpaRepository<FahrenheitSensor, Long> {
    Optional<FahrenheitSensor> findByBloque(String bloque);
}
