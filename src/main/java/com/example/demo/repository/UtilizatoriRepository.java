package com.example.demo.repository;
import com.example.demo.entity.Utilizatori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilizatoriRepository  extends JpaRepository<Utilizatori, Integer> {
 Utilizatori findByUtilizator(String utilizator);
}