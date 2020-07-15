package com.bankwithmint.exercise.repo;

import com.bankwithmint.exercise.entity.CardHit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CardHitRepository extends PagingAndSortingRepository<CardHit,String> {

}
