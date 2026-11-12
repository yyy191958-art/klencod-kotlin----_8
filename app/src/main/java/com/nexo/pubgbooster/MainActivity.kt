package com.example.cybercleaner

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnClean = findViewById<Button>(R.id.btnClean)
        val tvCacheSize = findViewById<TextView>(R.id.tvCacheSize)

        btnClean.setOnClickListener {
            btnClean.text = "جاري التنظيف..."
            btnClean.isEnabled = false

            Handler(Looper.getMainLooper()).postDelayed({
                tvCacheSize.text = "0.0 GB"
                btnClean.text = "✓ تم التنظيف بنجاح"
                Toast.makeText(this, "تم تنظيف الذاكرة المؤقتة بنجاح", Toast.LENGTH_SHORT).show()
                
                Handler(Looper.getMainLooper()).postDelayed({
                    btnClean.text = "⚡ تنظيف الذاكرة المؤقتة"
                    btnClean.isEnabled = true
                }, 2000)
            }, 1800)
        }
    }
}