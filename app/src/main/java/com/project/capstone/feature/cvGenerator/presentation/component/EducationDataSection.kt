package com.project.capstone.feature.cvGenerator.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.capstone.R
import com.project.capstone.feature.component.CustomIconTextFieldUI
import com.project.capstone.feature.component.LongTextFieldUI
import com.project.capstone.feature.component.TextFieldUI
import com.project.capstone.feature.cvGenerator.presentation.FormViewModel

@Composable
fun EducationDataSection(viewModel: FormViewModel) {
    val university = remember { mutableStateOf("") }
    val major = remember { mutableStateOf("") }
    val gpa = remember { mutableStateOf("") }
    val startEducation = remember { mutableStateOf("") }
    val endEducation = remember { mutableStateOf("") }
    val educationDescription = remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Isilah riwayat pendidikan Anda di bawah ini dengan lengkap dan benar",
                color = Color.Gray,
                fontSize = 14.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Alamat Pendidikan Terakhir",
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp)
            )

            CustomIconTextFieldUI(
                value = university.value,
                onValueChange = {
                    university.value = it
                    viewModel.updateUniversity(it)
                },
                placeholder = "Universitas Setara",
                leadingIcon = painterResource(R.drawable.ic_education),
                keyboardType = KeyboardType.Text,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Jurusan Pendidikan",
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp)
            )

            CustomIconTextFieldUI(
                value = major.value,
                onValueChange = {
                    major.value = it
                    viewModel.updateMajor(it)
                },
                placeholder = "Teknik Informatika",
                leadingIcon = painterResource(R.drawable.ic_education),
                keyboardType = KeyboardType.Text,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "IPK",
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp)
            )

            CustomIconTextFieldUI(
                value = gpa.value,
                onValueChange = {
                    gpa.value = it
                    viewModel.updateGPA(it)
                },
                placeholder = "3.9",
                leadingIcon = painterResource(R.drawable.ic_education),
                keyboardType = KeyboardType.Text,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Mulai Pendidikan",
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp)
            )

            TextFieldUI(
                value = startEducation.value,
                onValueChange = {
                    startEducation.value = it
                    viewModel.updateMasukKuliah(it)
                },
                placeholder = "Agu 2025",
                leadingIcon = Icons.Default.DateRange,
                keyboardType = KeyboardType.Text
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Lulus Pendidikan",
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp)
            )

            TextFieldUI(
                value = endEducation.value,
                onValueChange = {
                    endEducation.value = it
                    viewModel.updateLulusKuliah(it)
                },
                placeholder = "Des 2029",
                leadingIcon = Icons.Default.DateRange,
                keyboardType = KeyboardType.Text
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Deskripsi",
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp)
            )

            LongTextFieldUI(
                value = educationDescription.value,
                onValueChange = {
                    educationDescription.value = it
                    viewModel.updateEducationDescription(it)
                },
                placeholder = "Deskripsikan pendidikan Anda",
                keyboardType = KeyboardType.Text,
                visualTransformation = VisualTransformation.None,
                textColor = colorResource(id = R.color.magenta_80),
                borderColor = colorResource(id = R.color.borderPink),
                placeholderColor = colorResource(id = R.color.borderPink),
            )
        }
    }
}

@Preview
@Composable
private fun RegisterPrev() {
    EducationDataSection(
        viewModel = FormViewModel()
    )
}