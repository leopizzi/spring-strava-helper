package com.pizzi.stravaHelper.motor;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@Component
public class FileWriter {

    public void saveLikesGiven(String newCountStr) throws IOException {
        File file = new File(
                getClass().getClassLoader().getResource("db/kudosAccounting.txt").getFile()
        );
        Charset charset = StandardCharsets.UTF_8;
        int count = Integer.parseInt(Files.readString(file.toPath(), charset));

        int addCount = Integer.parseInt(newCountStr);

        count += addCount;
        Files.write(file.toPath(), Integer.toString(count).getBytes());
    }
}
