package club.appster.minecraft.ui.mods

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import club.appster.minecraft.data.abstraction.ModsJson
import club.appster.minecraft.model.MinecraftCard

class ModsViewModel
@ViewModelInject
constructor(
    private val modsJson: ModsJson,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _minecraftCardList: MutableLiveData<List<MinecraftCard>> = MutableLiveData()
    val minecraftCardList: LiveData<List<MinecraftCard>>
        get() = _minecraftCardList

    fun getMinecraftList() {
        _minecraftCardList.value = modsJson.getMinecraftCardList()
    }
}