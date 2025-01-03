package com.example.demo.service;


import com.example.demo.entity.Masini;
import com.example.demo.repository.MasiniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MasiniService {

@Autowired
private MasiniRepository repository;

public Masini insertMasini(Masini masini){
return repository.save(masini);
}

public Masini modifyMasini(String nr_inmatriculare,Masini update){
    Optional<Masini> masiniExistente = repository.findById(nr_inmatriculare);
    if(masiniExistente.isPresent())
    {
        Masini masiniE = masiniExistente.get();
        masiniE.setId_utilizator(update.getId_utilizator());
        masiniE.setMarca(update.getMarca());
        masiniE.setModelul(update.getModelul());
        masiniE.setCuloarea(update.getCuloarea());
        masiniE.setAn(update.getAn());
        masiniE.setCapacitate_cilindrica(update.getCapacitate_cilindrica());
        masiniE.setPret(update.getPutere());
        masiniE.setCuplu(update.getCuplu());
        masiniE.setVolum(update.getVolum());
        masiniE.setPret(update.getPret());
        return repository.save(masiniE);
    }else {
        throw new RuntimeException("Masina cu nr: "+nr_inmatriculare+ " nu exista");
    }
}

}
