package com.example.mar20g

data class CdDataModel(
    val cdName: String,
    val cdImage: Int,
    val cdPrice: String
) {
    companion object {
        val list = listOf(
            CdDataModel(
                cdName = "Album Name 001",
                cdImage = R.drawable.cd1,
                cdPrice = "$11.00"
            ),
            CdDataModel("Album Name 002", R.drawable.cd2, "$22.00"),
            CdDataModel("Album Name 003", R.drawable.cd3, "$33.00"),
            CdDataModel("Album Name 004", R.drawable.cd4, "$44.00"),
            CdDataModel("Album Name 005", R.drawable.cd5, "$55.00"),
            CdDataModel("Album Name 006", R.drawable.cd6, "$66.00")
        )
    }
}