package com.orgfree.valdoneves.springwebmvc.service;

import com.orgfree.valdoneves.springwebmvc.exception.JediNotFoundException;
import com.orgfree.valdoneves.springwebmvc.model.Jedi;
import com.orgfree.valdoneves.springwebmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JediService {

    private JediRepository repository;

    public JediService(JediRepository repository) {
        this.repository = repository;
    }

    public List<Jedi> findAll(){
        return repository.findAll();
    }
    public Jedi findById(final Long id) {
        final Optional<Jedi> jedi = repository.findById(id);

        if(jedi.isPresent()){
            return jedi.get();
        }else{
            throw new JediNotFoundException();
        }
    }

    public Jedi save(final Jedi jedi) {
        return repository.save(jedi);
    }

    public Jedi update(final Long id, final Jedi dto) {
        final Optional<Jedi> jediEntity = repository.findById(id);
        final Jedi jedi;

        if (jediEntity.isPresent()) {
            jedi = jediEntity.get();
        }else {
            throw new JediNotFoundException();
        }

        jedi.setName(dto.getName());
        jedi.setLastName(dto.getLastName());

        return repository.save(jedi);
    }

    public void delete(final Long id) {
        final Jedi jedi = findById(id);

        repository.delete(jedi);
    }
}
