package com.example.ahmarecipe.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.ahmarecipe.entities.converter.MealListConverter
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
//Entity annotation to specify the table name
@Entity(tableName = "Meal")
class Meal(

    @PrimaryKey(autoGenerate = true)
    var id:Int,
//PrimaryKey annotation to declare primary key with auto increment value
    //ColumnInfo annotation to specify the column name
    @ColumnInfo(name = "meals")
    @Expose
    @SerializedName("meals")
    @TypeConverters(MealListConverter::class)
    var mealsItem: List<MealsItems>? = null

)