package com.ups.group2.adapter.repository;

//import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import java.util.Optional;
import java.util.List;

import com.ups.group2.adapter.model.CelsiusSensor;

@Repository
public interface CelsiusSensorRepository extends JpaRepository<CelsiusSensor, Long> {
    List<CelsiusSensor> findByUbicacion(String localidad);
}
