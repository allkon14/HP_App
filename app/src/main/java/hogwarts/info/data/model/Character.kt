package hogwarts.info.data.model


import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("wand")
    val wand: Wand,
)