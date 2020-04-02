package com.hrso.movienetwork

import retrofit2.Call
import retrofit2.http.GET

interface RetroftService{

    @GET("search?media=music&entity=song&term=빅뱅")
//    fun getStudentsList(): Call<ArrayList<PersonFromServer>>
    fun getBigbangList():Call<ArrayList<movieFromServer2>>

    @GET("json/students/")
    fun getStudentsList(): Call<ArrayList<PersonFromServer>>

}