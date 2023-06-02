package hogwarts.info.data.repo

import hogwarts.info.data.api.HogwartsApi
import javax.inject.Inject

class HogwartsRepository @Inject constructor(private val hogwartsApi: HogwartsApi) {
    suspend fun getCharacters() = hogwartsApi.getCharacters()

    suspend fun getSpells() = hogwartsApi.getSpells()
}