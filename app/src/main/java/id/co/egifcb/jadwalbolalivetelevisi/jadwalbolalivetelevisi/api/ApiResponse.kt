package id.co.egifcb.jadwalbolalivetelevisi.jadwalbolalivetelevisi.api

import com.google.gson.annotations.SerializedName

data class ApiResponse(

	@field:SerializedName("result")
	val result: List<ResultItem>? = null,

	@field:SerializedName("creator")
	val creator: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)