package com.cinefolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cinefolio.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}

