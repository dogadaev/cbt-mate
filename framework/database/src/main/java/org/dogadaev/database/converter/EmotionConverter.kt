package org.dogadaev.database.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.dogadaev.database.entity.DiaryDB

@ProvidedTypeConverter
class EmotionConverter(
    private val gson: Gson,
) {

    @TypeConverter
    fun fromListToJson(list: List<DiaryDB.Emotion>): String = gson.toJson(list)

    @TypeConverter
    fun fromJsonToList(jsonString: String): List<DiaryDB.Emotion> {
        val listTypeToken = object : TypeToken<List<DiaryDB.Emotion>>() {}.type

        return gson.fromJson(jsonString, listTypeToken)
    }
}