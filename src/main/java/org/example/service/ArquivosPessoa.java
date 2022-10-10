package org.example.service;

import org.example.model.Pessoa;
import org.example.utils.PathConfigs;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.List;

public class ArquivosPessoa implements PathConfigs {

    public static void gerarArquivosPorParticipante(List<String> participantes) {
        participantes.parallelStream().forEach(participante -> {
            criarArquivoDaPessoa(criarObjetoPessoa(participante));
        });
    }

    public static Pessoa criarObjetoPessoa(String participante) {
        String[] dadosPessoa = participante.split(",");
        String nome = dadosPessoa[0];
        String zona = dadosPessoa[1];
        LocalDate dataNascimento = LocalDate.parse(dadosPessoa[2]);

        return new Pessoa(nome, zona, dataNascimento);
    }

    private static void criarArquivoDaPessoa(Pessoa pessoa) {
        try {
            Files.write(PathConfigs.gerarPath("/files/" + pessoa.getNome() + ".txt"), pessoa.gerarRelatorio(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
