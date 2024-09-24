package com.ups.group2.adapter.repository;

//import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import java.util.Optional;
import java.util.List;

import com.ups.group2.adapter.model.FahrenheitSensor;

@Repository
public interface FahrenheitSensorRepository extends JpaRepository<FahrenheitSensor, Long> {
    List<FahrenheitSensor> findByBloque(String bloque);
}
