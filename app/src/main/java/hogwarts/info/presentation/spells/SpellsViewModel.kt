package hogwarts.info.presentation.spells

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hogwarts.info.data.model.Spell
import hogwarts.info.data.repo.HogwartsRepository
import hogwarts.info.data.utils.Resource
import javax.inject.Inject

@HiltViewModel
class SpellsViewModel @Inject constructor(private val hogwartsRepository: HogwartsRepository) :
    ViewModel() {
    private val _spellsLiveData: MutableLiveData<Resource<List<Spell>>> = MutableLiveData()
    val spellsLiveData: LiveData<Resource<List<Spell>>> = _spellsLiveData

    suspend fun getSpells() {
        _spellsLiveData.postValue(Resource.Loading())
        try {
            _spellsLiveData.postValue(Resource.Success(hogwartsRepository.getSpells()))
        } catch (e: Exception) {
            _spellsLiveData.postValue(
                Resource.Error(e.localizedMessage ?: "Error")
            )
        }
    }
}