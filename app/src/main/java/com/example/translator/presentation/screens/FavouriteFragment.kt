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
import com.example.translator.presentation.model.favouritesList.WordFavouriteAdapter
import com.example.translator.presentation.mvvm.favourite.FavouriteFactory
import com.example.translator.presentation.mvvm.favourite.FavouriteViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavouriteFragment: Fragment(R.layout.fragment_favourite) {
    private lateinit var binding: FragmentFavouriteBinding

    @Inject
    lateinit var favouriteFactory: FavouriteFactory

    private val viewModel: FavouriteViewModel by viewModels {
        favouriteFactory
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
        return FragmentFavouriteBinding.inflate(inflater, container, false).let {
            binding = it
            it.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavouriteBinding.bind(view)
        binding.run {
            rwFavouritesWordsList.adapter = WordFavouriteAdapter()
            lifecycleScope.launch {
                viewModel.favourites.collect {
                    (rwFavouritesWordsList.adapter as WordFavouriteAdapter).submitList(it)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            viewModel.getFavouritesWords()
        }
    }
}