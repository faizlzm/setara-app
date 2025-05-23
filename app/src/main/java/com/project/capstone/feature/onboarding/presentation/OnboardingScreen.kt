package com.project.capstone.feature.onboarding.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.project.capstone.R
import com.project.capstone.feature.component.ButtonUI
import com.project.capstone.feature.onboarding.presentation.component.IndicatorUI

@Composable
fun OnboardingScreen(navController: NavController) {
    val viewModel: OnboardingViewModel = viewModel()
    val currentIndex by viewModel.currentIndex
    val onboardingItem = viewModel.onboardingItems[currentIndex]
    val onboardingPages = viewModel.onboardingItems.size

    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.onboardingPink))
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            contentAlignment = Alignment.TopEnd
        ) {
            TextButton(
                onClick = {
                    viewModel.lastPage()
                },
                colors = ButtonDefaults.textButtonColors(
                    contentColor = colorResource(id = R.color.magenta_80)
                ),
                modifier = Modifier.padding(top = 32.dp)
            ) {
                Text(
                    text = "Lewati",
                    color = colorResource(id = R.color.magenta_80),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 16.sp
                )
            }
        }
        Image(
            modifier = Modifier.weight(1f),
            painter = painterResource(id = onboardingItem.image),
            contentDescription = null,
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    shape = RoundedCornerShape(
                        topStart = 48.dp,
                        topEnd = 48.dp
                    )
                )
                .background(Color.White)
                .padding(
                    top = 30.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 36.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Spacer(modifier = Modifier.weight(1f))

                IndicatorUI(
                    pageSize = onboardingPages,
                    currentPage = currentIndex
                )

                Spacer(modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = stringResource(id = onboardingItem.title),
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
                lineHeight = 34.sp,
                color = colorResource(id = R.color.black),
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = onboardingItem.description),
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 25.sp,
                color = colorResource(id = R.color.gray_40),
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.height(32.dp))
            ButtonUI(
                text =  if (currentIndex == viewModel.onboardingItems.size - 1) "Masuk" else "Selanjutnya",
                onClick = {
                    viewModel.nextPage()
                },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(32.dp))
        }
    }


}