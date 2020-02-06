package com.pizzi.stravaHelper.module.stravaLiker.repository;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@Repository
@Log4j2
public class StravaLikerRepository {
    private File file;

    public String getLikesFromFile() throws IOException {
        log.info("reading kudos from file");
        File file = new File(
                getClass().getClassLoader().getResource("db/kudosAccounting.txt").getFile()
        );

        Charset charset = StandardCharsets.UTF_8;
        String numberOfLikes = null;
        numberOfLikes = Files.readString(file.toPath(), charset);

        return numberOfLikes;
    }

}
