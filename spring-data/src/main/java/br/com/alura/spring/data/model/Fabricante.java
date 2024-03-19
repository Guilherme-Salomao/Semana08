package br.com.alura.spring.data.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fabricante")
public class Fabricante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Fabricante(){}

    public Fabricante(String nome) {
        this.nome = nome;
    }
}
