package club.appster.minecraft.model

import android.os.Parcelable
import club.appster.minecraft.data.entity.MinecraftCardEntity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MinecraftCard(

    val id: Int,

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

    var isFavorite : Boolean = false

    fun toEntity(): MinecraftCardEntity {
        return MinecraftCardEntity(
            id = id,
            image= image,
            file= file,
            titleEn= titleEn,
            titleRu= titleRu,
            descEn= descEn,
            descRu= descRu
        )
    }

    override fun toString(): String {
        return "MinecraftCard(image='$image', file='$file', titleEn='$titleEn', titleRu='$titleRu', descEn='$descEn', descRu='$descRu')"
    }
}