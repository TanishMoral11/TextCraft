package com.example.textcraft
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.textcraft.R


class MainActivity : AppCompatActivity() {
    private val wordlist: MutableList<String> = mutableListOf(
        "Hello", "World", "Student", "IIITL", "Prashant Sir OP", "OOPS", "rape", "tape",
        "tire", "hostile", "village", "dawn", "length", "split", "salon", "consolidate",
        "peanut", "ant", "personality", "to", "relieve", "preach", "qualified", "diplomatic",
        "pillow", "theft", "litigation", "bother", "second", "confusion", "brand", "pass",
        "reasonable", "design", "define", "pipe", "fastidious", "dressing", "bee", "contempt",
        "planet", "innocent", "faithful", "official", "beard", "cereal", "responsibility",
        "filter", "bathtub", "sight", "enthusiasm", "intelligence", "fall", "penetrate",
        "reader", "floor"
    )
    private lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        text = findViewById(R.id.word)

        generateWord()

        button.setOnClickListener {
            generateWord()
        }
    }

    private fun generateWord() {
        val r = (0 until wordlist.size).random()
        text.text = wordlist[r]
    }

    fun customiseButtonClicked(view: View) {
        val intent = Intent(this, Second::class.java)
        intent.putExtra("randomWord", text.text.toString())
        startActivity(intent)
    }
}
