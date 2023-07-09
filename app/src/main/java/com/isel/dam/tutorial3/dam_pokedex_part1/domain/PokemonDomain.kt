package com.isel.dam.tutorial3.dam_pokedex_part1.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.isel.dam.tutorial3.dam_pokedex_part1.data.Pokemon
import com.isel.dam.tutorial3.dam_pokedex_part1.data.PokemonDetail
import com.isel.dam.tutorial3.dam_pokedex_part1.data.PokemonRegion
import com.isel.dam.tutorial3.dam_pokedex_part1.data.PokemonType
import com.isel.dam.tutorial3.dam_pokedex_part1.data.mocks.PokemonMockData

class PokemonDomain {
    fun getAllRegions() : LiveData<List<PokemonRegion>>
    {
        return MutableLiveData<List<PokemonRegion>>(PokemonMockData.regions)
    }
    fun getAllPokemons(): LiveData<List<Pokemon>>
    {
        return MutableLiveData<List<Pokemon>>(PokemonMockData.pokemons)
    }
    fun getPokemonsByRegion(region: PokemonRegion): LiveData<List<Pokemon>>
    {
        return MutableLiveData<List<Pokemon>>(PokemonMockData.pokemons.filter { it.
        region == region })
    }
    fun getPokemonTypes(): List<PokemonType>
    {
        return ArrayList<PokemonType>(PokemonMockData.pokemonTypeMock)
    }
    fun getPokemonDetail(pokemon:Pokemon): LiveData<PokemonDetail>
    {
        return MutableLiveData(
            PokemonMockData.pokemonDetail.find { it.pokemon == pokemon })
    }
}