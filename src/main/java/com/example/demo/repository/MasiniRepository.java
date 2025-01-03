package com.example.demo.repository;

import com.example.demo.entity.Masini;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MasiniRepository extends JpaRepository<Masini, String> {
Masini removeMasiniByNrInmatriculare(String nrInmatriculare);


}
