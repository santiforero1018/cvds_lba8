package edu.eci.cvds.servlet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.eci.cvds.servlet.model.Configuration;


public interface GuessRepository extends JpaRepository<Configuration, Long> {
    
}
