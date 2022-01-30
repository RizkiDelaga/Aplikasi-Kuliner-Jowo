package com.life4work.kulinerjowo

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.switchmaterial.SwitchMaterial

class HomeActivity : AppCompatActivity() {

    //  INTENT_PARCELABLE
    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //  Membuat Tampilan Layar Selalu PORTRAIT
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        //  Dark Mode Menggunakan Switch
        val switchMaterial = findViewById<SwitchMaterial>(R.id.switchMode)
        switchMaterial.setOnCheckedChangeListener { buttonView, isChacked ->
            if (isChacked)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            else
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        //  Pindah halaman
        var buttonJabar = findViewById<Button>(R.id.buttonJabar)
        buttonJabar.setOnClickListener() {
            val intent = Intent(this, ResepMasakanJawaBaratActivity::class.java)
            startActivity(intent);
        }

        //  Pindah halaman
        var buttonJateng = findViewById<Button>(R.id.buttonJateng)
        buttonJateng.setOnClickListener() {
            val intent = Intent(this, ResepMasakanJawaTengahActivity::class.java)
            startActivity(intent);
        }

        //  Pindah halaman
        var buttonJatim = findViewById<Button>(R.id.buttonJatim)
        buttonJatim.setOnClickListener() {
            val intent = Intent(this, ResepMasakanJawaTimurActivity::class.java)
            startActivity(intent);
        }
    }
}