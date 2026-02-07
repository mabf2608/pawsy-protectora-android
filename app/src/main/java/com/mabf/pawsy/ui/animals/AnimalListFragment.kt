package com.mabf.pawsy.ui.animals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mabf.pawsy.R
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.Lifecycle
import com.mabf.pawsy.ui.common.UiState
import kotlinx.coroutines.launch
import android.widget.TextView

@AndroidEntryPoint
class AnimalListFragment : Fragment() {

    private lateinit var viewModel: AnimalListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_animal_list, container, false)

        view.setOnClickListener {
            findNavController().navigate(R.id.action_animalListFragment_to_animalDetailFragment)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[AnimalListViewModel::class.java]

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    val tvAnimals = view.findViewById<TextView>(R.id.tvAnimals)

                    when (state) {
                        is UiState.Loading -> {
                            tvAnimals.text = "Cargando animales..."
                        }
                        is UiState.Success -> {
                            val text = state.data.joinToString(separator = "\n\n") { animal ->
                                "${animal.name} (${animal.species})\nEdad aprox: ${animal.estimatedAge}\nEstado: ${animal.adoptionStatus}\n${animal.description}"
                            }
                            tvAnimals.text = text
                        }
                        is UiState.Error -> {
                            tvAnimals.text = "Error: ${state.message}"
                        }
                    }
                }
            }
        }
    }
}