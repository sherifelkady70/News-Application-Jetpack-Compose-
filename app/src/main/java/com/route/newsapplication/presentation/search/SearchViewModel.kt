package com.route.newsapplication.presentation.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.route.newsapplication.domain.usecase.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUseCase : NewsUseCases
) : ViewModel() {

    private val _state = mutableStateOf(SearchState())
    val state : State<SearchState> = _state

    fun onEvent(event : SearchEvent){
        when(event){
            is SearchEvent.UpdateSearchQuery ->{
               _state.value = state.value.copy(search = event.search)
            }
            is SearchEvent.SearchNews -> {
                searchNews()
            }
        }
    }

    private fun searchNews(){
        val articles = searchUseCase.searchInNews(
            search = state.value.search,
            sources = listOf("bbc-news","abc-news","al-jazeera-english")
        ).cachedIn(viewModelScope)

        _state.value =  state.value.copy(articles = articles)
    }
}