package id.co.egifcb.jadwalbolalivetelevisi.jadwalbolalivetelevisi.api

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("bola.php")
    fun getJadwalBola(@Query("apikey") apiKey: String?): Deferred<Response<ApiResponse>>
}