package com.example.ahmarecipe.entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
//Entity annotation to specify the table name
@Entity(tableName = "Recipes")
data class Recipes(
    //PrimaryKey annotation to declare primary key with auto increment value
    //ColumnInfo annotation to specify the column name
    @PrimaryKey(autoGenerate = true)
    var id:Int,

    @ColumnInfo(name = "dishName")
    var dishName:String
) : Serializable