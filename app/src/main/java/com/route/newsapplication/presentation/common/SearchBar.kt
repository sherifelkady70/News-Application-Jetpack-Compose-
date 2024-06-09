package com.route.newsapplication.presentation.common

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
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
    val interactionSource = remember{
        MutableInteractionSource()
    }
    val isClicked = interactionSource.collectIsPressedAsState().value
    LaunchedEffect(key1 = isClicked) {
        if(isClicked){
            onClick?.invoke()
        }
    }

    Box(modifier = modifier){
        TextField(modifier = Modifier.fillMaxWidth()
            ,value = text
            , onValueChange = onValueChange)
    }
}