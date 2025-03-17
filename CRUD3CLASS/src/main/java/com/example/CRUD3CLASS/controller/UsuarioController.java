package com.example.CRUD3CLASS.controller;

import com.example.CRUD3CLASS.entity.Usuario;
import com.example.CRUD3CLASS.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // POST: Criar um usuário
    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.criarUsuario(usuario);
    }

    // GET: Listar todos os usuários
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    // GET: Buscar um usuário por ID
    @GetMapping("/{id}")
    public Optional<Usuario> buscarUsuarioPorId(@PathVariable Long id) {
        return usuarioService.buscarUsuarioPorId(id);
    }

    // PUT: Atualizar um usuário
    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
        return usuarioService.atualizarUsuario(id, usuarioAtualizado);
    }

    // DELETE: Excluir um usuário
    @DeleteMapping("/{id}")
    public void excluirUsuario(@PathVariable Long id) {
        usuarioService.excluirUsuario(id);
    }
}