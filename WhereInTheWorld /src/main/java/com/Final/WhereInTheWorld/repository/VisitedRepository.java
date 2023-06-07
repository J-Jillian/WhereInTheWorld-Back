package com.Final.WhereInTheWorld.repository;

import com.Final.WhereInTheWorld.model.Visited;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VisitedRepository extends JpaRepository<Visited, Integer> {
    Optional<Visited> findByCityName(String cityName);
}
