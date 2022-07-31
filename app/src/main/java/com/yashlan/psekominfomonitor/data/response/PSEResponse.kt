package com.yashlan.psekominfomonitor.data.response

import com.google.gson.annotations.SerializedName

data class PSEResponse(
    @SerializedName("data")
    val data: List<Data>,
    @SerializedName("meta")
    val meta: Meta
) {

    data class Meta(
        @SerializedName("page")
        val page: Page
    )

    data class Page(
        @SerializedName("lastPage")
        val lastPage: Int
    )

    data class Data(
        @SerializedName("attributes")
        val attributes: Attributes
    )

    data class Attributes(
        @SerializedName("nama")
        val nama: String,
        @SerializedName("website")
        val website: String,
        @SerializedName("sektor")
        val sektor: String,
        @SerializedName("nama_perusahaan")
        val namaPerusahaan: String,
        @SerializedName("tanggal_daftar")
        val tanggalDaftar: String,
        @SerializedName("status_id")
        val statusId: String
    )
}