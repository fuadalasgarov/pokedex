package com.isel.dam.tutorial3.dam_pokedex_part1.ui.pokemon

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.isel.dam.tutorial3.dam_pokedex_part1.data.Pokemon
import com.isel.dam.tutorial3.dam_pokedex_part1.data.PokemonRegion
import com.isel.dam.tutorial3.dam_pokedex_part1.domain.PokemonDomain

class PokemonsViewModel  : ViewModel() {
    private val pokemonDomain = PokemonDomain()
    private lateinit var listPokemons : LiveData<List<Pokemon>>
    fun getListPokemonsByRegion(region: PokemonRegion): LiveData<List<Pokemon>>
    {
        listPokemons = pokemonDomain.getPokemonsByRegion(region)
        return listPokemons
    }
    fun getAllPokemons() : LiveData<List<Pokemon>> {
        listPokemons = pokemonDomain.getAllPokemons()
        return listPokemons
    }

}