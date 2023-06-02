package hogwarts.info.data.api

import hogwarts.info.data.model.Character
import hogwarts.info.data.model.Spell
import retrofit2.http.GET

interface HogwartsApi {
    @GET("characters")
    suspend fun getCharacters(): List<Character>

    @GET("spells")
    suspend fun getSpells(): List<Spell>
}