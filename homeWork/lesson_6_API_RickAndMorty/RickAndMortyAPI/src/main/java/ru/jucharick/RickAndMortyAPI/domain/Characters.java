package ru.jucharick.RickAndMortyAPI.domain;

import lombok.Data;

import java.util.List;

@Data
public class Characters {
    Info info;
    List<Result> results;
}
