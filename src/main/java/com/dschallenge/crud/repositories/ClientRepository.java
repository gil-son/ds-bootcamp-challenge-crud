package com.dschallenge.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dschallenge.crud.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
