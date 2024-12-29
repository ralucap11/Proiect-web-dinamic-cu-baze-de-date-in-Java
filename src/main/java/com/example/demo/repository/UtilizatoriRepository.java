package com.example.demo.repository;
import java.util.List;
import com.example.demo.entity.Utilizatori;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UtilizatoriRepository {
    @PersistenceContext
    EntityManager entityManager;
    public List<Utilizatori> findAll(){
        TypedQuery<Utilizatori> query=entityManager.createQuery("from Utilizatori",Utilizatori.class);
        return query.getResultList();
    }
    public Utilizatori findById(int id){
        return entityManager.find(Utilizatori.class, id);
    }
    public void deleteById(int id){
        Utilizatori utilizatori=findById(id);
        entityManager.remove(utilizatori);
    }
    public Utilizatori insert(Utilizatori utilizatori){
        return entityManager.merge(utilizatori);
    }
    public Utilizatori update(Utilizatori utilizatori){
        return entityManager.merge(utilizatori);
    }
}
