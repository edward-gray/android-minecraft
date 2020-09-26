package club.appster.minecraft.model

import com.google.gson.annotations.SerializedName


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
) {

    override fun toString(): String {
        return "MinecraftCard(image='$image', file='$file', titleEn='$titleEn', titleRu='$titleRu', descEn='$descEn', descRu='$descRu')"
    }
}