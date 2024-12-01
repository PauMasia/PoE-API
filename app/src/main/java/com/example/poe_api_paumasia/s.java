//package com.example.poe_api_paumasia;
//
//import android.app.Application;
//import android.content.SharedPreferences;
//import android.os.AsyncTask;
//import android.preference.PreferenceManager;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.lifecycle.AndroidViewModel;
//import androidx.lifecycle.LiveData;
//
//import com.example.poe_api_paumasia.AppDataBase;
//import com.example.poe_api_paumasia.ItemDao;
//import com.example.poe_api_paumasia.ObjetoPoE;
//
//import java.util.List;
//
//import kotlin.coroutines.Continuation;
//
//public class s extends AndroidViewModel {
//    private final Application app;
//    private final AppDataBase appDatabase;
//    private final ItemDao itemDao;
//    private LiveData<List<ObjetoPoE>> items;
//
//    public s(Application application) {
//        super(application);
//
//        this.app = application;
//        this.appDatabase = AppDataBase.getDatabase(
//                this.getApplication());
//        this.itemDao = appDatabase.getItemDao();
//    }
//
//    public LiveData<List<ObjetoPoE>> getItems() {
//        return itemDao.getItems();
//    }
//}