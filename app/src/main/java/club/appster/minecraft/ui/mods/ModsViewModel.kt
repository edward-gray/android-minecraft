package club.appster.minecraft.ui.mods

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import club.appster.minecraft.data.abstraction.MinecraftDaoService
import club.appster.minecraft.data.abstraction.ModsJson
import club.appster.minecraft.data.entity.MinecraftCardEntity
import club.appster.minecraft.model.MinecraftCard
import kotlinx.coroutines.launch

class ModsViewModel
@ViewModelInject
constructor(
    private val modsJson: ModsJson,
    private val minecraftDaoService: MinecraftDaoService,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _minecraftCardList: MutableLiveData<List<MinecraftCard>> = MutableLiveData()
    val minecraftCardList: LiveData<List<MinecraftCard>>
        get() = _minecraftCardList

    fun getMinecraftList() {
        val defaultList = modsJson.getMinecraftCardList()
        var cacheList: List<MinecraftCardEntity>

        viewModelScope.launch {
            cacheList = minecraftDaoService.findAll()

            defaultList?.map {
                if (cacheList.contains(it.toEntity())) {
                    it.isFavorite = true
                }
            }

            _minecraftCardList.value = defaultList
        }
    }

    fun saveFavorite(position: Int, isChecked: Boolean) {
        _minecraftCardList.value?.get(position)?.let {
            viewModelScope.launch {
                if (isChecked) {
                    minecraftDaoService.save(it.toEntity())
                } else {
                    minecraftDaoService.delete(it.toEntity())
                }
            }
        }
    }

}