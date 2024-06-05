package com.route.newsapplication.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.route.newsapplication.presentation.onboarding.common.NewsButton
import com.route.newsapplication.presentation.onboarding.common.NewsTextButton
import com.route.newsapplication.presentation.onboarding.components.OnBoardingPage
import com.route.newsapplication.presentation.onboarding.components.PageIndicator
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    event : (OnBoardingEvent) -> Unit
) {
    Column (modifier= Modifier.fillMaxSize()){
        val pagerState = rememberPagerState (0) {
            pages.size
        }

        val buttonState = remember {
            derivedStateOf {
                when(pagerState.currentPage){
                    0 -> listOf("","Next")
                    1 -> listOf("Back","Next")
                    2 -> listOf("Back","Get Started")
                    else -> listOf("","")
                }
            }
        }

        HorizontalPager(state = pagerState) { index ->
            OnBoardingPage(pages[index])
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 14.dp)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PageIndicator(
                modifier = Modifier.width(52.dp),
                pageSize = pages.size,
                selectedPage = pagerState.currentPage
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                val scope = rememberCoroutineScope()

                if (buttonState.value[0].isNotEmpty()) {
                    NewsTextButton(text = buttonState.value[0]) {
                        scope.launch {
                            pagerState.animateScrollToPage(
                                page = pagerState.currentPage - 1
                            )
                        }
                    }
                }


                NewsButton(text = buttonState.value[1]) {
                    scope.launch {
                        if (pagerState.currentPage == 2) {
                            event.invoke(OnBoardingEvent.SaveEntryEvent)
                        } else {
                            pagerState.animateScrollToPage(
                                page = pagerState.currentPage + 1
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.weight(0.5f))
    }
}