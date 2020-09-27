package club.appster.minecraft.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import club.appster.minecraft.model.MinecraftCard

@Entity(tableName = "minecraft")
data class MinecraftCardEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Int,

    var image: String,

    var file: String,

    var titleEn: String,

    var titleRu: String,

    var descEn: String,

    var descRu: String

) {
    fun toModel(): MinecraftCard {
        return MinecraftCard(
            id= id,
            image= image,
            file= file,
            titleEn= titleEn,
            titleRu= titleRu,
            descEn= descEn,
            descRu= descRu
        )
    }
}