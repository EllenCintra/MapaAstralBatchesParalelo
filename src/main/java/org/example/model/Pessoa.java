package org.example.model;

import org.example.utils.MapaAstral;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Period;
import java.time.Year;
import java.util.Arrays;
import java.util.List;

public class Pessoa implements MapaAstral {

    private String nome;

    private String cidadeNascimento;

    private LocalDate dataNascimento;
    private String signo;

    private Integer idade;

    private String geracao;

    public String getNome() {
        return nome;
    }

    public Pessoa(String nome, String cidadeNascimento, LocalDate dataNascimento) {
        this.nome = nome;
        this.cidadeNascimento = cidadeNascimento;
        this.dataNascimento = dataNascimento;
        this.signo = MapaAstral.verificarSigno(MonthDay.from(dataNascimento));
        this.geracao = MapaAstral.definirGeracao(Year.from(dataNascimento));
        this.idade = calcularIdade(dataNascimento);
    }

    private Integer calcularIdade(LocalDate dataNascimento) {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    public List<String> gerarRelatorio() {
        return Arrays.asList(
                "Signo: " + this.signo,
                "Geração: " + this.geracao,
                "Idade: " + this.idade
        );
    }

}
