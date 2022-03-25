package br.senac.tads.dsw.exemplosspringmvc;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DadosPessoais {

    private String nome;

    private LocalDate dataNascimento;

    private String email;

    private String senha;

    public DadosPessoais() {

    }

    public DadosPessoais(String nome, String dataNascimento, String email, String senha) {
        this.nome = nome;
        this.dataNascimento = LocalDate.parse(dataNascimento);
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public long getIdade() {
        if (dataNascimento != null) {
            return ChronoUnit.YEARS.between(dataNascimento, LocalDate.now());
        }

        return 0;
    }
}