package hogwarts.info.data.model

import com.google.gson.annotations.SerializedName

data class Spell(
    @SerializedName("description")
    val description: String,
    @SerializedName("name")
    val name: String
)