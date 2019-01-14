package id.co.egifcb.jadwalbolalivetelevisi.app.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import id.co.egifcb.jadwalbolalivetelevisi.app.R
import id.co.egifcb.jadwalbolalivetelevisi.app.adapter.AdapterJadwalBola
import id.co.egifcb.jadwalbolalivetelevisi.app.api.ResultItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var mainPresenter: MainPresenter
    private var listJadwalBola: MutableList<ResultItem> = mutableListOf()
    private lateinit var adapterJadwalBola: AdapterJadwalBola

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter = MainPresenter(this)

        swipeRefreshLayout.post {
            loadData()
        }

        swipeRefreshLayout.setOnRefreshListener {
            loadData()
        }
    }

    private fun loadData() {
        mainPresenter.getJadwalBola()

        adapterJadwalBola = AdapterJadwalBola(this@MainActivity, listJadwalBola)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.adapter = adapterJadwalBola
    }

    override fun onSuccess(list: List<ResultItem>?) {
        Log.d("Sukses", list?.size.toString())

        listJadwalBola.clear()
        list?.let {
            listJadwalBola.addAll(it)
        }
        adapterJadwalBola.notifyDataSetChanged()
    }

    override fun onError(message: String?) {
        Log.d("Error", message)
        Toast.makeText(baseContext, message, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun hideLoading() {
        swipeRefreshLayout.isRefreshing = false
    }
}
