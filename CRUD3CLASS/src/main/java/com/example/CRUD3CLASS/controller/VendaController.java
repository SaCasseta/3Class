package com.example.CRUD3CLASS.controller;

import com.example.CRUD3CLASS.entity.Venda;
import com.example.CRUD3CLASS.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    // POST: Criar uma venda
    @PostMapping("/usuario/{usuarioId}")
    public Venda criarVenda(@PathVariable Long usuarioId, @RequestBody Venda venda) {
        return vendaService.criarVenda(usuarioId, venda);
    }

    // Adicionar um produto a uma venda
    @PostMapping("/{vendaId}/produto/{produtoId}")
    public void adicionarProdutoAVenda(
            @PathVariable Long vendaId,
            @PathVariable Long produtoId,
            @RequestParam int quantidade) {
        vendaService.adicionarProdutoAVenda(vendaId, produtoId, quantidade);
    }

    // GET: Listar todas as vendas
    @GetMapping
    public List<Venda> listarVendas() {
        return vendaService.listarVendas();
    }

    // GET: Buscar uma venda por ID
    @GetMapping("/{id}")
    public Optional<Venda> buscarVendaPorId(@PathVariable Long id) {
        return vendaService.buscarVendaPorId(id);
    }

    // PUT: Atualizar uma venda
    @PutMapping("/{id}")
    public Venda atualizarVenda(@PathVariable Long id, @RequestBody Venda vendaAtualizada) {
        return vendaService.atualizarVenda(id, vendaAtualizada);
    }

    // DELETE: Excluir uma venda
    @DeleteMapping("/{id}")
    public void excluirVenda(@PathVariable Long id) {
        vendaService.excluirVenda(id);
    }
}