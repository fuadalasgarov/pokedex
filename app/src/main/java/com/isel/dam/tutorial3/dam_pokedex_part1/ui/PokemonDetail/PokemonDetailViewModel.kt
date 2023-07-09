package com.isel.dam.tutorial3.dam_pokedex_part1.ui.PokemonDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.isel.dam.tutorial3.dam_pokedex_part1.data.Pokemon
import com.isel.dam.tutorial3.dam_pokedex_part1.data.PokemonDetail
import com.isel.dam.tutorial3.dam_pokedex_part1.domain.PokemonDomain

class PokemonDetailViewModel : ViewModel() {
    private val pokemonDomain = PokemonDomain()
    private lateinit var pokemon : LiveData<Pokemon>
    private lateinit var pokemonDetail : LiveData<PokemonDetail>
    fun getPokemonDetail(pokemon: Pokemon): LiveData<PokemonDetail>
    {
        pokemonDetail = pokemonDomain.getPokemonDetail(pokemon)
        return pokemonDetail
    }
}

