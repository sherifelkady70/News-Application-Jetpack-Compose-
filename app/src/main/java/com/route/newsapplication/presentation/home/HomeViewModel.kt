package com.route.newsapplication.presentation.home

import androidx.lifecycle.ViewModel
import com.route.newsapplication.domain.usecase.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsUseCase : NewsUseCases
): ViewModel() {


}