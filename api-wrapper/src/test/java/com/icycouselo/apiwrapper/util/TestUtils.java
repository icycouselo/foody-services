package com.icycouselo.apiwrapper.util;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
public class TestUtils {


    public static String getFileContent(String uri){
        Path filePath = Path.of(getAbsolutePath() + uri);
        Path path = filePath.normalize();
        try {
            return Files.readString(path);
        } catch (IOException e) {
            log.error("Can't read file: " + path);
            throw new RuntimeException(e);
        }
    }
    private static String getAbsolutePath(){
        Path resourceDirectory = Paths.get("src","test","resources");
        return resourceDirectory.toFile().getAbsolutePath();
    }
}
