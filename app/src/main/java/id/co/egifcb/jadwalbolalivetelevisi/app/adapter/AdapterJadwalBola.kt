package id.co.egifcb.jadwalbolalivetelevisi.app.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.egifcb.jadwalbolalivetelevisi.app.R
import id.co.egifcb.jadwalbolalivetelevisi.app.api.ResultItem
import id.co.egifcb.jadwalbolalivetelevisi.app.until.formatDate
import kotlinx.android.synthetic.main.layout_list_jadwal_bola.view.*

class AdapterJadwalBola(private val context: Context, private val list: List<ResultItem>)
    : RecyclerView.Adapter<AdapterJadwalBola.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) =
        AdapterJadwalBola.ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_list_jadwal_bola, parent, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position], context)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(resultItem: ResultItem, context: Context) {
            itemView.tv_tv.text = resultItem.tv
            itemView.tv_event.text = resultItem.event
            itemView.tv_date.text = context.getString(R.string.date, resultItem.hari, resultItem.tanggal?.formatDate(), resultItem.kick)
            itemView.tv_match.text = resultItem.match
        }
    }
}