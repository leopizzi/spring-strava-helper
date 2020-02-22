package com.pizzi.stravaHelper.module.stravaLiker.controller;

import com.pizzi.stravaHelper.module.stravaLiker.service.StravaLikerService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@AllArgsConstructor
@Log4j2
public class StravaLikerController {

    private StravaLikerService stravaLikerService;


    @GetMapping("/count-likes")
    public ResponseEntity requestLikes() throws IOException {
        log.info("Start requesting likes");
        return ResponseEntity.ok(stravaLikerService.sumLikes());

    }


}
