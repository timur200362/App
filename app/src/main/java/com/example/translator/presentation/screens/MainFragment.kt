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
import com.example.translator.databinding.FragmentMainBinding
import com.example.translator.domain.usecase.api.TranslateUseCase
import com.example.translator.presentation.mvvm.TranslateViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainFragment: Fragment(R.layout.fragment_main) {
    private lateinit var binding: FragmentMainBinding

    @Inject
    lateinit var translateUseCase: TranslateUseCase

    private val viewModel: TranslateViewModel by viewModels {
        TranslateViewModel.provideFactory(translateUseCase)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (requireActivity().application as App).appComponent.injectMainFragment(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentMainBinding.inflate(inflater,container,false).let {
            binding = it
            it.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        binding.run {
            btnTranslate.setOnClickListener {
                viewModel.translateWord(etWord.text.toString())
            }
            lifecycleScope.launch {
                viewModel.resultTranslate.collect {
                    tvResult.text = it.toString()
                }
            }
        }
    }
}