package cl.citiaps.spring.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import cl.citiaps.spring.backend.entities.Geolocation;

public interface GeolocationRepository extends PagingAndSortingRepository<Geolocation, Integer> {
	
	@Query("SELECT g FROM Geolocation g ORDER BY tweets DESC")
	List<Geolocation> findAllBytweetsDesc();
}
