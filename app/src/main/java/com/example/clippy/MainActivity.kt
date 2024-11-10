package com.example.clippy

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Get the intent data (the URL)
        val url = intent?.dataString

        // Check if there is a URL and copy it to the clipboard
        if (url != null) {
            copyToClipboard(url)
            Toast.makeText(this, "URL copied to clipboard", Toast.LENGTH_SHORT).show()
        }

        // Close the activity immediately after copying
        finish()
    }

    // Method to copy text to clipboard
    private fun copyToClipboard(text: String) {
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("URL", text)
        clipboard.setPrimaryClip(clip)
    }
}
