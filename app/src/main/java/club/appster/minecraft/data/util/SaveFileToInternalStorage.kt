package club.appster.minecraft.data.util

import android.content.Context
import java.io.File

class SaveFileToInternalStorage(private val context: Context, private val filePath: String) {

    fun saveToInternal() {
        val file = File(context.getDir("Download", Context.MODE_PRIVATE), filePath)
        file.createNewFile()
    }

}