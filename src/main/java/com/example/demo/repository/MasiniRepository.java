package com.example.demo.repository;

import com.example.demo.entity.Masini;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MasiniRepository extends JpaRepository<Masini, String> {
Masini removeMasiniByNrInmatriculare(String nrInmatriculare);

List<Masini> findByMarcaContainingIgnoreCaseAndCuloareaContainingIgnoreCaseAndCombustibilContainingIgnoreCase(String marca,String culoarea, String combustibil);

}
