package com.example.translator.presentation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.translator.R
import com.example.translator.databinding.FragmentMainBinding
import com.example.translator.presentation.mvvm.TranslateViewModel

class MainFragment: Fragment(R.layout.fragment_main) {
    private lateinit var viewModel: TranslateViewModel
    private lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[TranslateViewModel::class.java]
        viewModel.resultTranslate.observe(this) {

        }
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
            etWord.setOnEditorActionListener {_, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    //todo
                }
                true
            }
        }
    }
}