package roni.putra.newsmi2b.api

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import roni.putra.newsmi2b.model.RegisterResponse

interface ApiService {

    @FormUrlEncoded
    @POST("api_basic-master/register.php")
    fun register(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("fullname") fullname: String,
        @Field("email") email: String,
    ): Call<RegisterResponse>
}