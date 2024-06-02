package com.route.newsapplication.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.route.newsapplication.presentation.onboarding.components.OnBoardingPage

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen() {
    Column (){
        val pagerState = rememberPagerState (0) {

        }

        val button = remember {
            derivedStateOf {

            }
        }

        HorizontalPager(state = pagerState) { index ->
            OnBoardingPage(pages[index])
        }

        Spacer(modifier = Modifier.height(14.dp))

        Row(){

        }
    }
}