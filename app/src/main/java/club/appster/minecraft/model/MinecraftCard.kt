package club.appster.minecraft.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MinecraftCard(
    var image: String,

    var file: String,

    @SerializedName("title_def")
    var titleEn: String,

    @SerializedName("title_ru")
    var titleRu: String,

    @SerializedName("desc_def")
    var descEn: String,

    @SerializedName("desc_ru")
    var descRu: String
): Parcelable {

    override fun toString(): String {
        return "MinecraftCard(image='$image', file='$file', titleEn='$titleEn', titleRu='$titleRu', descEn='$descEn', descRu='$descRu')"
    }
}