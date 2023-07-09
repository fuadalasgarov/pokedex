package com.isel.dam.tutorial3.dam_pokedex_part1.data

import android.os.Parcelable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonType(
    var id: Int,
    var name:String,
    @DrawableRes val icon: Int,
    @ColorRes val color: Int) : Parcelable