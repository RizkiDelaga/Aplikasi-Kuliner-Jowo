package com.life4work.kulinerjowo

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ResepMasakanJawaTimurActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resep_masakan_jawa_timur)

        //  Membuat Tampilan Layar Selalu PORTRAIT
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        //  Menambahkan Action Bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val recyclerView = findViewById<RecyclerView>(R.id.rv_resep)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        //  Mengisi Item RecyclerView
        recyclerView.adapter = ResepAdapter(this, KumpulanResep.resepMasakanJatim){
            //  Pindah halaman dengan membawa Intent Resep yang diklik
            val intent = Intent (this, DetailResepActivity::class.java)
            intent.putExtra(HomeActivity.INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }

    //  Fungsi kembali ke halaman sebelumnya
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}