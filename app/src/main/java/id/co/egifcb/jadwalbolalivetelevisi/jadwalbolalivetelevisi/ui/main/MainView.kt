package id.co.egifcb.jadwalbolalivetelevisi.jadwalbolalivetelevisi.ui.main

import id.co.egifcb.jadwalbolalivetelevisi.jadwalbolalivetelevisi.api.ResultItem
import id.co.egifcb.jadwalbolalivetelevisi.jadwalbolalivetelevisi.base.BaseView

interface MainView : BaseView {
    fun onSuccess(list: List<ResultItem>?)
    fun onError(message: String?)
}