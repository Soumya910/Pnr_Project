package com.pnr.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pnr.project.entity.PnrEntity;

@Repository
public interface PnrRepository extends JpaRepository<PnrEntity, Integer> {

}
