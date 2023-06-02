package hogwarts.info.presentation.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hogwarts.info.data.model.Character
import hogwarts.info.data.repo.HogwartsRepository
import hogwarts.info.data.utils.Resource
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(private val hogwartsRepository: HogwartsRepository) :
    ViewModel() {
    private val _charactersLiveData: MutableLiveData<Resource<List<Character>>> = MutableLiveData()
    val charactersLiveData: LiveData<Resource<List<Character>>> = _charactersLiveData

    suspend fun getCharacters() {
        _charactersLiveData.postValue(Resource.Loading())
        try {
            _charactersLiveData.postValue(Resource.Success(hogwartsRepository.getCharacters()))
        } catch (e: Exception) {
            _charactersLiveData.postValue(
                Resource.Error(e.localizedMessage ?: "Error")
            )
        }
    }
}