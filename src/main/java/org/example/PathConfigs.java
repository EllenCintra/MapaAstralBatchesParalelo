package org.example;

import java.nio.file.Path;
import java.nio.file.Paths;

public interface PathConfigs {

    String HOME_PATH = configurarHomePath();

    static String configurarHomePath() {
        return System.getProperty("user.dir");
    }

    static Path gerarPath(String caminho) {
        return Paths.get(HOME_PATH.concat(caminho));
    }
}
