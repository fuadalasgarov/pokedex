package com.isel.dam.tutorial3.dam_pokedex_part1.ui.pokemon

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.isel.dam.tutorial3.dam_pokedex_part1.R
import com.isel.dam.tutorial3.dam_pokedex_part1.data.Pokemon
import com.isel.dam.tutorial3.dam_pokedex_part1.data.PokemonRegion
import com.isel.dam.tutorial3.dam_pokedex_part1.databinding.FragmentPokemonsBinding

class PokemonsFragment : Fragment() {
    private var _binding: FragmentPokemonsBinding? = null
    private val viewModel: PokemonsViewModel by viewModels()
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPokemonsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val region = checkNotNull(arguments?.getParcelable("region", PokemonRegion::
        class.java))
        println(region)


        viewModel.getListPokemonsByRegion(region).observe(viewLifecycleOwner) { pokemons ->
            val adapter = PokemonsAdapter(pokemons, itemClickedListener = { pokemon ->
                val bundle = bundleOf("pokemon" to pokemon)
                findNavController().navigate(
                    R.id.action_nav_pokemons_to_nav_pokemon_details,
                    bundle,
                    null
                )
            }, view.context)

            binding?.pokemonsRecyclerView?.adapter = adapter

            binding?.searchEditText?.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    // No action needed
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    // No action needed
                }

                override fun afterTextChanged(s: Editable?) {
                    val query = s.toString().trim()
                    val filteredPokemons = if (query.isNotEmpty()) {
                        pokemons.filter { pokemon ->
                            pokemon.name.contains(query, ignoreCase = true)
                        }
                    } else {
                        pokemons
                    }

                    val searchAdapter = PokemonsAdapter(filteredPokemons, itemClickedListener = { pokemon ->
                        val bundle = bundleOf("pokemon" to pokemon)
                        findNavController().navigate(
                            R.id.action_nav_pokemons_to_nav_pokemon_details,
                            bundle,
                            null
                        )
                    }, view.context)
                    binding?.pokemonsRecyclerView?.adapter = searchAdapter

                }
            })
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}