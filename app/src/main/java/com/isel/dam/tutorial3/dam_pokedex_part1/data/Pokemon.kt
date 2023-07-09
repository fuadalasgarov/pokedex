package com.isel.dam.tutorial3.dam_pokedex_part1.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    var id: Int,
    var name:String,
    var imageUrl: String,
    var region: PokemonRegion?,
    var types: List<PokemonType>
) : Parcelable