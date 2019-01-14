package id.co.egifcb.jadwalbolalivetelevisi.app.api

import com.google.gson.annotations.SerializedName

data class ResultItem(

	@field:SerializedName("hari")
	val hari: String? = null,

	@field:SerializedName("tv")
	val tv: String? = null,

	@field:SerializedName("kick")
	val kick: String? = null,

	@field:SerializedName("match")
	val match: String? = null,

	@field:SerializedName("tanggal")
	val tanggal: String? = null,

	@field:SerializedName("event")
	val event: String? = null
)