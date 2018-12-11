package id.co.egifcb.jadwalbolalivetelevisi.jadwalbolalivetelevisi.ui.main

import id.co.egifcb.jadwalbolalivetelevisi.jadwalbolalivetelevisi.BuildConfig
import id.co.egifcb.jadwalbolalivetelevisi.jadwalbolalivetelevisi.api.ApiConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainPresenter(private val view: MainView) {
    fun getJadwalBola() {
        view.showLoading()

        GlobalScope.launch(Dispatchers.Main) {
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
        }
    }
}