package com.project.capstone.feature.cvGenerator.presentation

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun PreviewScreen(
    htmlContent: String,
    onDownloadClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        WebViewContent(
            htmlContent = htmlContent,
            modifier = Modifier.weight(1f)
        )

        DownloadButton(onClick = onDownloadClick)
    }
}

@Composable
private fun WebViewContent(
    htmlContent: String,
    modifier: Modifier = Modifier
) {
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                webViewClient = WebViewClient()
                settings.javaScriptEnabled = true
            }
        },
        update = { webView ->
            webView.loadData(htmlContent, "text/html", "UTF-8")
        },
        modifier = modifier
    )
}

@Composable
private fun DownloadButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text("Download PDF")
    }
}