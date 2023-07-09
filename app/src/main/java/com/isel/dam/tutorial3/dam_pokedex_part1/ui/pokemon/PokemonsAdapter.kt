package com.isel.dam.tutorial3.dam_pokedex_part1.ui.pokemon

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.isel.dam.tutorial3.dam_pokedex_part1.R
import com.isel.dam.tutorial3.dam_pokedex_part1.data.Pokemon
import com.isel.dam.tutorial3.dam_pokedex_part1.databinding.ItemPokemonBinding
import com.isel.dam.tutorial3.dam_pokedex_part1.ui.OnItemClickedListener

class PokemonsAdapter(
    pokemonList: List<Pokemon>,
    private val itemClickedListener: OnItemClickedListener? = null,
    private val context: Context
) : RecyclerView.Adapter<PokemonsAdapter.ViewHolder>() {
    private var filteredPokemons: List<Pokemon> = pokemonList

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val viewBinding = ItemPokemonBinding.bind(itemView)
        fun bindView(pokemon: Pokemon, itemClickedListener: OnItemClickedListener?) {
            viewBinding.pokemon = pokemon
            itemView.setOnClickListener {
                itemClickedListener?.invoke(pokemon)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_pokemon, parent, false)
        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = filteredPokemons[position]
        println(item)
        holder.bindView(item, itemClickedListener)
    }

    override fun getItemCount(): Int {
        return filteredPokemons.size
    }


    companion object {
        private val POKEMON_DIFF_CALLBACK = object : DiffUtil.ItemCallback<Pokemon>() {
            override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean =
                oldItem == newItem
        }
    }
}
