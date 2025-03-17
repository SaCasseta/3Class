package com.example.CRUD3CLASS.repository;

import com.example.CRUD3CLASS.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long> {
    List<Venda> findByUsuarioId(Long usuarioId); // Busca vendas por usuário
}