package com.pokedex.pokedex_web.Pokemon;

import java.util.List;

public class Pokemon {

    private String name;
    private int height;
    private List<String> abilities;
    private List<String> moves;
    private String sprite;

    public Pokemon(String name,int height, List<String> abilities, List<String> moves, String sprite)
    {
        this.name=name;
        this.height=height;
        this.abilities=abilities;
        this.moves=moves;
        this.sprite=sprite;
    }

    public Pokemon()
    {
        
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public List<String> getAbilities() { return abilities; }
    public void setAbilities(List<String> abilities) { this.abilities = abilities; }

    public List<String> getMoves() { return moves; }
    public void setMoves(List<String> moves) { this.moves = moves; }

    public String getSprite() { return sprite; }
    public void setSprite(String sprite) { this.sprite = sprite; }
}
