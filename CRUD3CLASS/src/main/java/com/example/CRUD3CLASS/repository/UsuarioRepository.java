package com.example.CRUD3CLASS.repository;

import com.example.CRUD3CLASS.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}