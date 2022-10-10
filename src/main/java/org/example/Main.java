package org.example;

import org.example.utils.PathConfigs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.example.service.ArquivosPessoa.gerarArquivosPorParticipante;


public class Main implements PathConfigs {

    public static void main(String[] args) throws IOException {
        List<String> participantes = lerAquivoParticipantes();
        gerarArquivosPorParticipante(participantes);
    }

    /**
     * O método retorna uma lista de strings, onde cada string representa uma linha do arquivo
     * Cada linha do arquivo representa um participante
     */
    private static List<String> lerAquivoParticipantes() throws IOException {
        Path pathParticipantes = PathConfigs.gerarPath("/files/participantes.txt");
        return Files.readAllLines(pathParticipantes);
    }

}