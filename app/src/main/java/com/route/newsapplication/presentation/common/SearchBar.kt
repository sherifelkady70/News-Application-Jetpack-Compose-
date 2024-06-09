package com.route.newsapplication.presentation.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun SearchBar(
    modifier : Modifier = Modifier,
    text : String,
    readOnly : Boolean,
    onClick : (() -> Unit)?=null,
    onValueChange : (String) -> Unit,
    onSearch : () -> Unit
){

}