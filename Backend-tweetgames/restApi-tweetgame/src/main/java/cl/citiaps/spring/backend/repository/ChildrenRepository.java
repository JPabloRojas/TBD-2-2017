package cl.citiaps.spring.backend.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cl.citiaps.spring.backend.entities.Children;

public interface ChildrenRepository extends PagingAndSortingRepository<Children, Integer>{

}
