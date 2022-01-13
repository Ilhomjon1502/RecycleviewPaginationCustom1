package uz.ilhomjon.recycleviewpagination.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import uz.ilhomjon.recycleviewpagination.models.UserData

interface ApiService {
    @GET("users")
    fun getUser(@Query("page") page:Int):Call<UserData>
}