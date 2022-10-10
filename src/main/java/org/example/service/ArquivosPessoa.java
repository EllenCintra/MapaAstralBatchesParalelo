package org.example.service;

import org.example.model.Pessoa;
import org.example.utils.PathConfigs;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArquivosPessoa implements PathConfigs {

    public static List<Pessoa> criarObjetosPessoa(List<String> lines) {
        List<Pessoa> pessoas = new ArrayList<>();

        lines.forEach(line -> {
            String[] campos = line.split(",");
            String nome = campos[0];
            String zona = campos[1];
            LocalDate dataNascimento = LocalDate.parse(campos[2]);

            pessoas.add(new Pessoa(nome, zona, dataNascimento));
        });

        return pessoas;
    }

    public static void criarUmArquivoPorPessoa(List<Pessoa> pessoas) {
        pessoas.parallelStream().forEach((pessoa -> {
            try {
                Files.write(PathConfigs.gerarPath("/files/" + pessoa.getNome() + ".txt"), pessoa.gerarRelatorio(), StandardCharsets.UTF_8);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }));
    }
}
