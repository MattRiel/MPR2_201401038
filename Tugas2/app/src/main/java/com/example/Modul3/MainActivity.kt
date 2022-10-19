package com.example.Modul3

import Car
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TEXT="extra_text"
        const val EXTRA_BOOL="extra_bool"
        const val EXTRA_CAR="extra_car"

    }

    private lateinit var textJudul: TextView
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var objectButton: Button
    private lateinit var text: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textJudul = findViewById(R.id.judul)
        button1 = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        objectButton = findViewById(R.id.objectButton)
        text = findViewById(R.id.plainText)

        var tulis = text.text

        /*button1.setOnClickListener(){
            textJudul.text = tulis.toString()
        }*/
    }

    fun onClick(view: View){
        when(view.id){
            R.id.button -> {
                val intent = Intent(this@MainActivity, DetailActivity::class.java);
                startActivity(intent)
            }

            R.id.button2 -> {
                val text = text.text.toString()
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_TEXT, text)
                startActivity(intent)
            }

            R.id.button3 -> {
                val phoneNumber = "081234567890"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity((dialPhoneIntent))
            }

            R.id.objectButton ->{
                val carSpek=Car(
                    "Civic",
                    "Honda",
                    "Sedan",
                    1997,
                    57000000.00
                )
                val intent = Intent(this@MainActivity,DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_CAR, carSpek)
                intent.putExtra(DetailActivity.EXTRA_BOOL, true);
                startActivity(intent)
            }
        }

    }
}