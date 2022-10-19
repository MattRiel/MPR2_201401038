package com.example.Modul3

import Car
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TEXT="extra_text"
        const val EXTRA_BOOL="extra_bool"
        const val EXTRA_CAR="extra_car"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val textView: TextView = findViewById(R.id.textView)
        val tvGetText:TextView = findViewById(R.id.tvGetText)

        val getText = intent?.getStringExtra(EXTRA_TEXT)
        textView.text = getText

        val getBool=intent?.getBooleanExtra(EXTRA_BOOL, false)
        if(getBool==true){
            val getCar = intent?.getParcelableExtra<Car>(EXTRA_CAR)
            Log.i("TAG", getCar?.name.toString())
            val carSpek="Car specification:\n"+
                    "\nName: ${getCar?.name.toString()}"+
                    "\nBrand: ${getCar?.brand.toString()}"+
                    "\nType: ${getCar?.type.toString()}"+
                    "\nYear: ${getCar?.year.toString()}"+
                    "\nPrice: ${getCar?.price.toString()}"
            tvGetText.text=carSpek;
        }
    }
}
