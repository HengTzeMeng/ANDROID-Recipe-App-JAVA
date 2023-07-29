package com.example.ahmarecipe.entities

import androidx.room.*
import com.example.ahmarecipe.entities.converter.CategoryListConverter
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
//Entity annotation to specify the table name
@Entity(tableName = "Category")
data class Category(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
//PrimaryKey annotation to declare primary key with auto increment value
    //ColumnInfo annotation to specify the column name
    @ColumnInfo(name = "categoryItems")
    @Expose
    @SerializedName("categories")
    @TypeConverters(CategoryListConverter::class)
    var categorieitems: List<CategoryItems>? = null
)
