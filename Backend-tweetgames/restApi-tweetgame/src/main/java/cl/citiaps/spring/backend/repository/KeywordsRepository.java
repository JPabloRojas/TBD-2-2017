package cl.citiaps.spring.backend.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cl.citiaps.spring.backend.entities.Keywords;

public interface KeywordsRepository extends PagingAndSortingRepository<Keywords, Integer>{

}
