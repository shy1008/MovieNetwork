package com.hrso.movienetwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        http://mellowcode.org/
//        https://itunes.apple.com/
        val retrofit = Retrofit.Builder()
            .baseUrl("https://itunes.apple.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RetroftService::class.java)


        service.getBigbangList().enqueue(object : Callback<ArrayList<movieFromServer2>>{
            override fun onFailure(call: Call<ArrayList<movieFromServer2>>, t: Throwable) {
                Log.d("ret","error")
            }

            override fun onResponse(
                call: Call<ArrayList<movieFromServer2>>,
                response: Response<ArrayList<movieFromServer2>>
            ) {
                if (response.isSuccessful){
                    val movielist = response.body()

                    Log.d("ret",""+movielist?.get(0)?.resultCount)
                }
            }
        })






    }
}
