package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.example.ArquivosPessoa.criarObjetosPessoa;
import static org.example.ArquivosPessoa.criarUmArquivoPorPessoa;

public class Main implements PathConfigs{


    public static void main(String[] args) throws IOException {

        List<String> lines = lerAquivoParticipantes();
        List<Pessoa> pessoas = criarObjetosPessoa(lines);
        criarUmArquivoPorPessoa(pessoas);
    }

    private static List<String> lerAquivoParticipantes() throws IOException {
        Path pathParticipantes = PathConfigs.gerarPath("/files/participantes.txt");
        return Files.readAllLines(pathParticipantes);
    }


}