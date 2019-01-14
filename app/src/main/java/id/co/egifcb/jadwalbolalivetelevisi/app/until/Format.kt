package id.co.egifcb.jadwalbolalivetelevisi.app.until

import java.text.SimpleDateFormat
import java.util.*

fun String.formatDate(fromDate: String = "dd/MM/yyyy", toDateFormat: String = "dd MMMM yyyy"): String? {
    val date = SimpleDateFormat(fromDate, Locale.getDefault())
    val dateFrom = date.parse(this)

    val dateFormater = SimpleDateFormat(toDateFormat, Locale.getDefault())
    return dateFormater.format(dateFrom)
}