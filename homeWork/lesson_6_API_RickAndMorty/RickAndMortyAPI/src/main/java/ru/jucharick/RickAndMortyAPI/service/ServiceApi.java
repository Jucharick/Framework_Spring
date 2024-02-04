package ru.jucharick.RickAndMortyAPI.service;

import ru.jucharick.RickAndMortyAPI.domain.Result;

import java.util.List;

public interface ServiceApi {
    List<Result> getAllCharacters();
    Result getCharacterByID(Integer id);
}
