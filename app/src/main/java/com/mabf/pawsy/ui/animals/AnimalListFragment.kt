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
import android.util.Log

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

        val animals = viewModel.loadAnimals()
        Log.d("AnimalListFragment", "Animals loaded: ${animals.size}")
    }
}