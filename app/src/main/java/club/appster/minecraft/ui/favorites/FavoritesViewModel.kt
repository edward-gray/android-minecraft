package club.appster.minecraft.ui.favorites

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import club.appster.minecraft.data.abstraction.MinecraftDaoService
import club.appster.minecraft.data.entity.MinecraftCardEntity
import club.appster.minecraft.model.MinecraftCard
import kotlinx.coroutines.launch

class FavoritesViewModel
@ViewModelInject
constructor(
    private val minecraftDaoService: MinecraftDaoService,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _minecraftCardList: MutableLiveData<List<MinecraftCard>> = MutableLiveData()
    val minecraftCardList: LiveData<List<MinecraftCard>>
        get() = _minecraftCardList

    fun getMinecraftList() {
        var cacheList: List<MinecraftCardEntity>

        viewModelScope.launch {
            cacheList = minecraftDaoService.findAll()
            _minecraftCardList.value = cacheList.map {
                val model = it.toModel()
                model.isFavorite = true
                model
            }
        }
    }

    fun handleFavorite(position: Int, isChecked: Boolean) {
        _minecraftCardList.value?.get(position)?.let {
            viewModelScope.launch {
                if (!isChecked) {
                    minecraftDaoService.delete(it.toEntity())
                    getMinecraftList()
                }
            }
        }
    }
}