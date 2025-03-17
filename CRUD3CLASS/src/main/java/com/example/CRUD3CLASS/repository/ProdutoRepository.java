package com.example.CRUD3CLASS.repository;

import com.example.CRUD3CLASS.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}