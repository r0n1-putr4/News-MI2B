package roni.putra.newsmi2b.model

data class LoginResponse(
    val success: Boolean,
    val message: String,
    val data: UserData
){
    data class UserData(
        val id: String,
        val username: String,
        val fullname: String
    )
}
