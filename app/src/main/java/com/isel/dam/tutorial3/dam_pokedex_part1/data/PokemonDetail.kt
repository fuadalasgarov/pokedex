package com.isel.dam.tutorial3.dam_pokedex_part1.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonDetail(
    var pokemon: Pokemon,
    var description: String,
    var types:List<PokemonType>?,
    var weight:Double?,
    var height: Double?,
    var stats: PokemonStats?,
    var evolution: List<PokemonEvolution>?

) : Parcelable
