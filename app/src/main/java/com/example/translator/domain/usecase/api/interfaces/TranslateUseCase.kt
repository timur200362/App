package com.example.translator.domain.usecase.api.interfaces

interface TranslateUseCase {
    suspend operator fun invoke(word: String): List<String>
}