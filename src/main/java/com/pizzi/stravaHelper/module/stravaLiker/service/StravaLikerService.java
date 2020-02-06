package com.pizzi.stravaHelper.module.stravaLiker.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pizzi.stravaHelper.module.stravaLiker.model.Likes;
import com.pizzi.stravaHelper.module.stravaLiker.repository.StravaLikerRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Log4j2
public class StravaLikerService {

    @Autowired
    private StravaLikerRepository stravaLikerRepository;

    public String sumLikes() throws IOException {
        log.info("Sumarizing likes");

        Likes likes = Likes.builder()
                .sumarizedLikes(Integer.valueOf(stravaLikerRepository.getLikesFromFile()))
                .build();

        Gson gson = new GsonBuilder().create();
        return gson.toJson(likes);
    }

}
