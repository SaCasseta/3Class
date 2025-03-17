package com.example.CRUD3CLASS.service;

import com.example.CRUD3CLASS.entity.*;
import com.example.CRUD3CLASS.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemVendaRepository itemVendaRepository;

    // POST: Criar uma venda
    public Venda criarVenda(Long usuarioId, Venda venda) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        venda.setUsuario(usuario);
        return vendaRepository.save(venda);
    }

    // Adicionar um produto a uma venda
    public void adicionarProdutoAVenda(Long vendaId, Long produtoId, int quantidade) {
        Venda venda = vendaRepository.findById(vendaId)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada"));
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        ItemVenda itemVenda = new ItemVenda();
        itemVenda.setVenda(venda);
        itemVenda.setProduto(produto);
        itemVenda.setQuantidade(quantidade);

        itemVendaRepository.save(itemVenda);
    }

    // GET: Listar todas as vendas
    public List<Venda> listarVendas() {
        return vendaRepository.findAll();
    }

    // GET: Buscar uma venda por ID
    public Optional<Venda> buscarVendaPorId(Long id) {
        return vendaRepository.findById(id);
    }

    // PUT: Atualizar uma venda
    public Venda atualizarVenda(Long id, Venda vendaAtualizada) {
        return vendaRepository.findById(id)
                .map(venda -> {
                    venda.setDataDaVenda(vendaAtualizada.getDataDaVenda());
                    return vendaRepository.save(venda);
                })
                .orElseThrow(() -> new RuntimeException("Venda não encontrada"));
    }

    // DELETE: Excluir uma venda
    public void excluirVenda(Long id) {
        vendaRepository.deleteById(id);
    }
}