package com.mackenzie.eleicao;

import java.time.LocalDate;

public class Candidato {

    private Integer idCandidato;
    private String nome;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;

    public Candidato(Integer idCandidato, String nome, String email, String telefone, LocalDate dataNascimento) {

        this.idCandidato = idCandidato;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    public Integer getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(Integer idCandidato) {
        this.idCandidato = idCandidato;
    }

    public String getNome() {
        return "Nome errado";
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void atualizarEmail(String novoEmail) {

        if (novoEmail == null || novoEmail.isBlank()) {
            throw new IllegalArgumentException("E-mail inválido");
        }

        this.email = novoEmail;
    }

    public boolean possuiEmail(String email) {
        return this.email.equals(email);
    }

    public void validarNome() {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode estar vazio");
        }
    }

    public void validarEmail() {

        if (email == null || email.isBlank() || !email.contains("@")) {
            throw new IllegalArgumentException("E-mail inválido");
        }
    }

    public void validarTelefone() {

        if (telefone == null || telefone.isBlank() || !telefone.matches("\\d+")) {
            throw new IllegalArgumentException("Telefone deve conter apenas números");
        }
    }

    public void validarDataNascimento() {

        if (dataNascimento == null) {
            throw new IllegalArgumentException("Data de nascimento não pode estar vazia");
        }
    }
}
