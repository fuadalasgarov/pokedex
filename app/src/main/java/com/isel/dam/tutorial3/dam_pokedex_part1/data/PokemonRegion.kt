package com.isel.dam.tutorial3.dam_pokedex_part1.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonRegion(
    var id:Int,
    var name: String,
    @DrawableRes val bg: Int,
    @DrawableRes val starters: Int
) : Parcelable