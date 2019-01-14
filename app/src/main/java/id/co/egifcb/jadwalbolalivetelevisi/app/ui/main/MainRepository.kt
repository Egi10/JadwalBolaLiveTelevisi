package id.co.egifcb.jadwalbolalivetelevisi.app.ui.main

import id.co.egifcb.jadwalbolalivetelevisi.app.BuildConfig
import id.co.egifcb.jadwalbolalivetelevisi.app.api.ApiConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainRepository(private val view: MainView) {
    fun tes() {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val config = ApiConfig.config()
                val call = config.getJadwalBola(BuildConfig.API_KEY)
                val response = call.await()

                when(response.code()) {
                    200 -> {
                        view.onSuccess(response.body()?.result)
                    }

                    else -> {
                        view.onError(response.message())
                    }
                }
                view.hideLoading()
            } catch (e: Exception) {
                view.onError(e.message.toString())
                view.hideLoading()
            }
        }
    }
}