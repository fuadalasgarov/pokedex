package com.isel.dam.tutorial3.dam_pokedex_part1.ui.region

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.isel.dam.tutorial3.dam_pokedex_part1.R
import com.isel.dam.tutorial3.dam_pokedex_part1.data.PokemonRegion
import com.isel.dam.tutorial3.dam_pokedex_part1.databinding.FragmentRegionBinding

class RegionFragment : Fragment() {
    private var _regionViewModel: RegionViewModel? = null
    private var _binding: FragmentRegionBinding? = null
    private val binding get() = _binding!!
    private val regionViewModel get() = _regionViewModel!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _regionViewModel =
            ViewModelProvider(this)[RegionViewModel::class.java]
        _binding = FragmentRegionBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        regionViewModel.getRegions().observe(viewLifecycleOwner) {
            val regions: List<PokemonRegion> = it
            binding?.regionsRecyclerView?.adapter = RegionAdapter(regions,
                itemClickedListener = {region->
                    val bundle = bundleOf(
                        "region" to region
                    )
                    findNavController()
                        .navigate(
                            R.id.action_nav_regions_to_pokemonsFragment,
                            bundle,
                            null
                        )
                },view.context)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}