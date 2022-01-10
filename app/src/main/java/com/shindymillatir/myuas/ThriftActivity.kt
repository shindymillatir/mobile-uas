package com.shindymillatir.myuas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.myuas.R
import com.shindymillatir.myuas.Adapter.Adapter
import com.shindymillatir.myuas.Model.Model
import com.shindymillatir.myuas.api.ApiRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ThriftActivity : AppCompatActivity() {

    private val api by lazy { ApiRetrofit().endpoint }
    private lateinit var hpAdapter: Adapter
    private lateinit var lisNote : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thrift)
        setupList()

//        val action = supportActionBar
//        action!!.title = "Daftar Harga"
//        action.setDisplayHomeAsUpEnabled(true)
    }

//    override fun onSupportNavigateUp(): Boolean {
//        onBackPressed()
//        return true
//    }

    private fun setupList(){
        lisNote = findViewById(R.id.list_hp)
        hpAdapter = Adapter(arrayListOf())
        lisNote.adapter = hpAdapter
    }

    override fun onStart() {
        super.onStart()
        getNote()
    }

    private fun getNote(){
        api.data().enqueue(object : Callback<Model> {
            override fun onResponse(call: Call<Model>, response: Response<Model>) {
                if (response.isSuccessful){
                    val listData = response.body()!!.handphone
                    hpAdapter.setData( listData )
//                    listData.forEach {
//                        Log.e("daftar_hadir","nama ${it.nama}")
//                    }
                }
            }

            override fun onFailure(call: Call<Model>, t: Throwable) {
                Log.e("daftar_hadir",t.toString())
            }

        })
    }
}