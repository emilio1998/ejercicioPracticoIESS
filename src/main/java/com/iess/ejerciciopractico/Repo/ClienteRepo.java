package com.iess.ejerciciopractico.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iess.ejerciciopractico.Models.Cliente;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, String>{
    Optional<Cliente> findByIdentificacion(String identificacion);
}
