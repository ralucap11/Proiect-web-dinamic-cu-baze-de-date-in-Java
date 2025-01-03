package com.example.demo.repository;
import com.example.demo.entity.Utilizatori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilizatoriRepository  extends JpaRepository<Utilizatori, Integer> {
 Utilizatori findByUtilizator(String utilizator);
  @Query("SELECT u FROM Utilizatori u JOIN FETCH u.masini")
 List<Utilizatori> findAllWithMasini();
}