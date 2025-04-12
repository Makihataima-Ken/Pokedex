package com.pokedex.pokedex_web.Pokemon;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class PokemonService {
    private final RestTemplate restTemplate = new RestTemplate();

    public Pokemon getPokemonData(String name) {
        String url = "https://pokeapi.co/api/v2/pokemon/" + name.toLowerCase();
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        Pokemon pokemon = new Pokemon();
        pokemon.setName((String) response.get("name"));
        pokemon.setHeight((Integer) response.get("height"));

        List<String> abilities = ((List<Map<String, Object>>) response.get("abilities"))
                .stream()
                .map(a -> (String) ((Map<String, Object>) a.get("ability")).get("name"))
                .toList();

        List<String> moves = ((List<Map<String, Object>>) response.get("moves"))
                .stream()
                .limit(5)
                .map(m -> (String) ((Map<String, Object>) m.get("move")).get("name"))
                .toList();

        String sprite = (String) ((Map<String, Object>) response.get("sprites")).get("front_default");

        pokemon.setAbilities(abilities);
        pokemon.setMoves(moves);
        pokemon.setSprite(sprite);

        return pokemon;
    }
}

