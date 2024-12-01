package com.example.poe_api_paumasia

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors

class ModelViewItem(private val app: Application) : AndroidViewModel(app) {
    private val BASE_URL = "https://paumasia.pythonanywhere.com/"

    private val appDatabase: AppDataBase = AppDataBase.getDatabase(
        this.getApplication()
    )
    private val itemDao: ItemDao
    val items: LiveData<List<ObjetoPoE>>
        get() = itemDao.items

    init {
        this.itemDao = appDatabase.itemDao
    }


    suspend fun reload() {
        val executors = Executors.newSingleThreadExecutor()
        val api = getRetrofit().create(API_Interface::class.java)
        val lista= api.getData()

        executors.execute {
            itemDao.deleteItems()
            itemDao.addItems(lista)
        }

    }
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
