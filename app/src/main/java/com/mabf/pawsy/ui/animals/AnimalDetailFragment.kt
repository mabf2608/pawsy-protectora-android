package com.mabf.pawsy.ui.animals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.mabf.pawsy.databinding.FragmentAnimalDetailBinding
import com.mabf.pawsy.ui.common.UiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimalDetailFragment : Fragment() {

    private val viewModel: AnimalDetailViewModel by viewModels()

    private var _binding: FragmentAnimalDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnimalDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val animalId = requireArguments().getString("animalId")

        if (animalId == null) {
            binding.tvSubtitle.text = "Error: no se ha recibido el animalId"
            return
        }

        // Pedimos cargar el animal del repositorio (mock)
        viewModel.loadAnimal(animalId)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    when (state) {
                        is UiState.Loading -> {
                            binding.tvSubtitle.text = "Cargando detalle..."
                        }

                        is UiState.Success -> {
                            val animal = state.data
                            binding.tvTitle.text = animal.name
                            binding.tvSubtitle.text =
                                "Edad aprox: ${animal.estimatedAge}\n" +
                                        "Especie: ${animal.species}\n" +
                                        "Estado: ${animal.adoptionStatus}\n\n" +
                                        animal.description
                        }

                        is UiState.Error -> {
                            binding.tvSubtitle.text = "Error: ${state.message}"
                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}