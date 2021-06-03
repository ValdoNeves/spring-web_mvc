package com.orgfree.valdoneves.springwebmvc.repository;

import com.orgfree.valdoneves.springwebmvc.entity.SoldadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldadoRepository extends JpaRepository<SoldadoEntity, Long> {
}
