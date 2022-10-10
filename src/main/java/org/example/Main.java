package org.example;

import org.example.utils.PathConfigs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.example.service.ArquivosPessoa.gerarArquivosPorParticipante;
import static org.example.service.ArquivosPessoa.gerarArquivosPorParticipanteEmParalelo;


public class Main implements PathConfigs {

    public static void main(String[] args) throws IOException {
        var time = System.currentTimeMillis();

        List<String> participantes = lerAquivoParticipantes();

        //gerarArquivosPorParticipante(participantes);
        gerarArquivosPorParticipanteEmParalelo(participantes);

        System.out.println(System.currentTimeMillis()-time);
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