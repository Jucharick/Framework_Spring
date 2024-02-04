package ru.jucharick.RickAndMortyAPI.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.jucharick.RickAndMortyAPI.domain.Characters;
import ru.jucharick.RickAndMortyAPI.domain.Result;
import ru.jucharick.RickAndMortyAPI.service.ServiceApi;

import java.util.List;

@Service
public class ServiceApiImpl implements ServiceApi {

    @Autowired
    private RestTemplate template;

    @Autowired
    private HttpHeaders headers;

    private  static final String CHARACTER_API = "https://rickandmortyapi.com/api/character";

    @Override
    public List<Result> getAllCharacters() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> response = template.exchange(CHARACTER_API, HttpMethod.GET, entity, Characters.class);
        return response.getBody().getResults();
    }

    @Override
    public Result getCharacterByID(Integer id) {
        return getAllCharacters().stream().filter(item -> item.getId() == id).findFirst().get();
    }
}
