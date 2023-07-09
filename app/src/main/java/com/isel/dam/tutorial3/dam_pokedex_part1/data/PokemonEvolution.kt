package com.isel.dam.tutorial3.dam_pokedex_part1.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonEvolution(
    var id: Int,
    var pokemon: Pokemon,
    var isBaby: Boolean,
    var minLevel: Int?,
    var item: String?,
    var minHappiness: Int?,
    var time: String?
) : Parcelable