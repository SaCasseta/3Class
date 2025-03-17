package com.example.CRUD3CLASS.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ItemVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "venda_id", nullable = false)
    private Venda venda; // Relacionamento N-1 com Venda

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto; // Relacionamento N-1 com Produto

    @Column(nullable = false)
    private int quantidade; // Quantidade do produto na venda
}