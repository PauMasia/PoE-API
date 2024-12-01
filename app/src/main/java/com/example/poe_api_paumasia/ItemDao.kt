package com.example.poe_api_paumasia

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
@Dao
interface ItemDao {
    @get:Query("select * from ObjetoPoE")
    val items: LiveData<List<ObjetoPoE>>

    @Insert
    fun addItem(item: ObjetoPoE)

    @Insert
    fun addItems(items: List<ObjetoPoE>)

    @Delete
    fun deleteItems(item: ObjetoPoE)

    @Query("DELETE FROM ObjetoPoE")
    fun deleteItems()
}