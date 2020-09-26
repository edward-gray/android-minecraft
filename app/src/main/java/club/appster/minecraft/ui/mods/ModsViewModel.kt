package club.appster.minecraft.ui.mods

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ModsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Mods"
    }
    val text: LiveData<String> = _text
}