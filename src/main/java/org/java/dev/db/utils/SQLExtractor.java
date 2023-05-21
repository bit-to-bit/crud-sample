package org.java.dev.db.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SQLExtractor {
    private static final String SQL_STORAGE_PATH = "./SQL/";
    public static String read(String sqlFileName) {

        String fileName = SQL_STORAGE_PATH + sqlFileName;
        String res = "";

        Path pp = Path.of(fileName);

        try {
            res =  new String(Files.readAllBytes(Path.of(fileName)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return res;
    }


}
