package id.co.egifcb.jadwalbolalivetelevisi.app.ui.main

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainPresenter(private val view: MainView) {
    fun getJadwalBola() {
        view.showLoading()

        GlobalScope.launch(Dispatchers.Main) {
            try {
                val call = async { MainRepository(view).tes() }
                call.await()
            } catch (e: Exception) {
                view.onError(e.message.toString())
                view.hideLoading()
            }
        }
    }
}