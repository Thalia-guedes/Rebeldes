package com.zup.rebeldes.repository;

import com.zup.rebeldes.model.InventarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<InventarioModel,Long> {
}
