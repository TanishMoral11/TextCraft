package com.example.textcraft

import android.graphics.Color
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Second : AppCompatActivity() {
    private lateinit var text: TextView // Declare the TextView variable
    private lateinit var fontFamilySpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Initialize the TextView variable and set the text
        text = findViewById(R.id.textView2)
        text.text = intent.getStringExtra("randomWord")

        // Initialize the Spinner for font family
        fontFamilySpinner = findViewById(R.id.fontFamilySpinner)

        // Setup SeekBars
        setupTextSizeSeekBar()
        setupTextColorSeekBar()
    }

    private fun setupTextSizeSeekBar() {
        val seekSize = findViewById<SeekBar>(R.id.seekSize)

        seekSize.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Update the text size of the TextView based on the SeekBar progress
                text.textSize = progress.toFloat() * 0.5f + 10
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // No implementation needed
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // No implementation needed
            }
        })
    }

    private fun setupTextColorSeekBar() {
        val seekColor = findViewById<SeekBar>(R.id.seekColor)

        seekColor.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Update the text color of the TextView based on the SeekBar progress
                text.setTextColor(getColorForSeekBarProgress(progress))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // No implementation needed
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // No implementation needed
            }
        })
    }

    private fun getColorForSeekBarProgress(progress: Int): Int {
        val colors = arrayOf(
            Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.CYAN,
            Color.MAGENTA, Color.GRAY, Color.BLACK, Color.WHITE, Color.LTGRAY,
            Color.DKGRAY, Color.parseColor("#FFA500"), Color.parseColor("#800080"),
            Color.parseColor("#008000"), Color.parseColor("#FF00FF"),
            Color.parseColor("#FFFF00"), Color.parseColor("#00FFFF"),
            Color.parseColor("#800000"), Color.parseColor("#008080"),
            Color.parseColor("#800000")
        )

        // Calculate the index in the colors array based on SeekBar progress
        val index = (progress.toFloat() / 100 * (colors.size - 1)).toInt()
        return colors[index]
    }

}
