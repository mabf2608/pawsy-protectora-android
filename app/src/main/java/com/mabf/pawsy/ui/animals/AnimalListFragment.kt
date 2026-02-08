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
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.mabf.pawsy.databinding.FragmentAnimalListBinding

@AndroidEntryPoint
class AnimalListFragment : Fragment() {

    private lateinit var viewModel: AnimalListViewModel

    private var _binding: FragmentAnimalListBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: AnimalAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAnimalListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[AnimalListViewModel::class.java]

        adapter = AnimalAdapter { animal ->
            findNavController().navigate(
                R.id.action_animalListFragment_to_animalDetailFragment,
                bundleOf("animalId" to animal.id)
            )
        }

        binding.rvAnimals.layoutManager = LinearLayoutManager(requireContext())
        binding.rvAnimals.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->

                    when (state) {
                        is UiState.Loading -> {
                            binding.tvStatus.visibility = View.VISIBLE
                            binding.tvStatus.text = "Cargando animales..."
                            adapter.submitList(emptyList())
                        }
                        is UiState.Success -> {
                            binding.tvStatus.visibility = View.GONE
                            adapter.submitList(state.data)
                        }
                        is UiState.Error -> {
                            binding.tvStatus.visibility = View.VISIBLE
                            binding.tvStatus.text = "Error: ${state.message}"
                            adapter.submitList(emptyList())
                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Evita leaks del binding
    }

}