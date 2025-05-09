package com.project.capstone.feature.cvGenerator.presentation

import android.widget.Toast
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.project.capstone.feature.cvGenerator.domain.PdfGenerator

@Composable
fun CvApp() {
    val navController = rememberNavController()
    val viewModel: FormViewModel = viewModel()
    var showPreview by remember { mutableStateOf(false) }
    val context = LocalContext.current

    if (showPreview) {
        val html = viewModel.generateHtmlContent()
        PreviewScreen(
            htmlContent = html,
            onDownloadClick = {
                val success = PdfGenerator.generatePdf(context, html)
                if (success) {
                    Toast.makeText(context, "PDF generated successfully!", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Toast.makeText(context, "Failed to generate PDF.", Toast.LENGTH_SHORT).show()
                }
            }
        )
    } else {
        CvGenerateFormScreen(
            viewModel = viewModel,
            navController = navController,
            onNavigateToPreview = { showPreview = true }
        )
    }
}


//@Composable
//fun AppContent() {
//    val viewModel = FormViewModel()
//    var currentScreen by remember { mutableStateOf("form") }
//    var htmlContent by remember { mutableStateOf("") }
//    val context = LocalContext.current // Get the current context
//
//    when (currentScreen) {
//        "form" -> FormScreen(viewModel) {
//            // Setelah selesai, buat HTML untuk CV
//            htmlContent = """
//                <!DOCTYPE html>
//                <html lang="en">
//                <head>
//                    <style>
//                        body { font-family: Arial, sans-serif; line-height: 1.6; margin: 40px; }
//                        .header { text-align: center; margin-bottom: 30px; }
//                        .section { margin-bottom: 25px; }
//                        h2 { color: #2c3e50; border-bottom: 2px solid #3498db; padding-bottom: 5px; }
//                        .date-range { float: right; color: #7f8c8d; }
//                        ul { margin-top: 5px; padding-left: 20px; }
//                    </style>
//                </head>
//                <body>
//                    <div class="header">
//                        <h1>${viewModel.personalData.value.fullName}</h1>
//                        <p>${viewModel.personalData.value.phone} | ${viewModel.personalData.value.email} | LinkedIn | Github | Malang, ID</p>
//                    </div>
//
//                    <div class="section">
//                        <h2>SUMMARY</h2>
//                        <p>A motivated Informatics Engineering undergraduate at Universitas Brawijaya with a strong passion for backend, frontend, and full-stack development. Skilled in <strong>HTML</strong>, <strong>CSS</strong> (Tailwind & Bootstrap), <strong>JavaScript</strong>, <strong>PHP</strong> (Laravel), <strong>SQL</strong>, and <strong>MySQL</strong>. A fast learner, communicative, and collaborative team player.</p>
//                    </div>
//
//                    <div class="section">
//                        <h2>EDUCATION</h2>
//                        <p>
//                            <strong>Universitas Brawijaya, Malang, East Java</strong><br>
//                            Bachelor of Informatics Engineering, 3.67/4.00<br>
//                            <span class="date-range">Aug 2022 - Present</span>
//                        </p>
//                        <ul>
//                            <li>Subject: Database, Web Programming, Software Engineering, Interactive Systems Programming</li>
//                        </ul>
//                    </div>
//
//                    <div class="section">
//                        <h2>EXPERIENCE</h2>
//                        <p>
//                            <strong>Student Employee | Faculty of Computer Science University of Brawijaya</strong><br>
//                            Videographer and Editor Intern<br>
//                            <span class="date-range">Mar 2024 - Jun 2024</span>
//                        </p>
//                        <ul>
//                            <li>Edit and review scientific manuscripts, ensuring language accuracy and clarity</li>
//                            <li>Oversee publication process including manuscript submission and peer review</li>
//                        </ul>
//                    </div>
//
//                    <div class="section">
//                        <h2>ORGANIZATIONS</h2>
//                        <p>
//                            <strong>Himpunan Mahasiswa Departemen Teknik Informatika FILKOM UB</strong><br>
//                            Staff of Information and Communication<br>
//                            <span class="date-range">Feb 2024 - Dec 2024</span>
//                        </p>
//                        <ul>
//                            <li>Manage and develop social media platforms for Student Association</li>
//                            <li>Create engaging content to increase student interaction</li>
//                        </ul>
//                    </div>
//
//                    <div class="section">
//                        <h2>PROJECTS</h2>
//                        <p>
//                            <strong>CalmSpace</strong><br>
//                            Mobile Developer<br>
//                            <span class="date-range">Aug 2024 - Dec 2024</span>
//                        </p>
//                        <ul>
//                            <li>Frontend development using Laravel 11 framework</li>
//                        </ul>
//                    </div>
//                </body>
//                </html>
//            """.trimIndent()
//
//            // Generate PDF setelah HTML dibuat
//            val pdfFile = GeneratePdf(context, htmlContent)
//            // Handle PDF download atau sharing
//            currentScreen = "preview" // Pindah ke layar preview
//        }
//        "preview" -> PreviewScreen(htmlContent, onDownloadClick = {
//            // Handle download atau kembali ke form
//            currentScreen = "form"
//        })
//    }
//}