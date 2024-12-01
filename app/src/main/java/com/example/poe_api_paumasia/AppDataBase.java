package com.example.poe_api_paumasia;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ObjetoPoE.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    //crear el dao y el viewModel

        private static AppDataBase INSTANCE;

        public static AppDataBase getDatabase(Context context) {
            if (INSTANCE == null){
                INSTANCE =
                        Room.databaseBuilder(
                                context.getApplicationContext(),
                                AppDataBase.class, "db"
                        ).build();
            }
            return INSTANCE;
        }

        public abstract ItemDao getItemDao();
    }
