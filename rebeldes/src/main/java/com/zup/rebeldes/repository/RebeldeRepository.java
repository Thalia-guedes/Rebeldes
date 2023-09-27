package com.zup.rebeldes.repository;

import com.zup.rebeldes.model.RebeldeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RebeldeRepository extends JpaRepository<RebeldeModel,Long> {
}
