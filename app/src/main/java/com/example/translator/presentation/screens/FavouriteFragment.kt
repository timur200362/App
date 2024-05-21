package com.example.translator.presentation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.translator.R
import com.example.translator.app.App
import com.example.translator.databinding.FragmentFavouriteBinding
import com.example.translator.domain.usecase.database.GetFavouritesUseCase
import com.example.translator.presentation.model.favouritesList.WordFavouriteAdapter
import com.example.translator.presentation.mvvm.FavouriteViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavouriteFragment: Fragment(R.layout.fragment_favourite) {
    private lateinit var binding: FragmentFavouriteBinding

    @Inject
    lateinit var getFavouritesUseCase: GetFavouritesUseCase

    private val viewModel: FavouriteViewModel by viewModels {
        FavouriteViewModel.provideFactory(
            getFavouritesUseCase
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (requireActivity().application as App).appComponent.injectFavouriteComponent(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return FragmentFavouriteBinding.inflate(inflater, container, false).let {
            binding = it
            it.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavouriteBinding.bind(view)
        binding.run {
            rwFavouritesWordsList.adapter = WordFavouriteAdapter(
                mutableListOf()
            )
            lifecycleScope.launch {
                viewModel.favourites.collect {
                    (rwFavouritesWordsList.adapter as WordFavouriteAdapter).update(it)
                }
            }
        }
    }
}