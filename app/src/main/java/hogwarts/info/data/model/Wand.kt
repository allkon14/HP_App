package hogwarts.info.data.model


import com.google.gson.annotations.SerializedName

data class Wand(
    @SerializedName("core")
    val core: String,
    @SerializedName("length")
    val length: Double,
    @SerializedName("wood")
    val wood: String
)