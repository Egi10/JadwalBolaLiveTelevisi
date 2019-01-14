package id.co.egifcb.jadwalbolalivetelevisi.app.ui.main

import id.co.egifcb.jadwalbolalivetelevisi.app.api.ResultItem
import id.co.egifcb.jadwalbolalivetelevisi.app.base.BaseView

interface MainView : BaseView {
    fun onSuccess(list: List<ResultItem>?)
    fun onError(message: String?)
}