package uz.ilhomjon.recycleviewpagination.models

data class UserData(
    val `data`: List<Data>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)