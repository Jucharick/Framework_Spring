package ru.jucharick.RickAndMortyAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.jucharick.RickAndMortyAPI.domain.Characters;
import ru.jucharick.RickAndMortyAPI.domain.Result;
import ru.jucharick.RickAndMortyAPI.service.ServiceApi;

import java.util.List;

@Controller
public class ControllerAPI {
    @Autowired
    private ServiceApi serviceApi;

    @GetMapping("/characters")
    public String getAllCharacters(Model model) {
        List<Result> allCharacters = serviceApi.getAllCharacters();
        model.addAttribute("results", allCharacters);
        return "character-list";
    }

    @GetMapping("/character/{id}")
    public String getCharacterPage(@PathVariable("id") Integer id, Model model){
        Result resultCharacter = serviceApi.getCharacterByID(id);
        model.addAttribute("result", resultCharacter);
        return "character";
    }
}
