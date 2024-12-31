package com.example.demo.repository;
import com.example.demo.entity.Utilizatori;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UtilizatoriRepository  extends JpaRepository<Utilizatori, Integer> {
 Utilizatori findUtilizatoriByNume(String nume);
}
