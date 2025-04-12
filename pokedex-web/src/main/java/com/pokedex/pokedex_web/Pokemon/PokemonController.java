package com.pokedex.pokedex_web.Pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PokemonController {

    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemon")
    public String getPokemon(@RequestParam String name, Model model) {
        try {
            Pokemon pokemon = pokemonService.getPokemonData(name);

            model.addAttribute("name", pokemon.getName());
            model.addAttribute("height", pokemon.getHeight());
            model.addAttribute("abilities", pokemon.getAbilities());
            model.addAttribute("moves", pokemon.getMoves());
            model.addAttribute("sprite", pokemon.getSprite());

            return "pokemon";
        } catch (Exception e) {
            model.addAttribute("error", "Pokémon not found");
            return "index";
        }
    }
}

