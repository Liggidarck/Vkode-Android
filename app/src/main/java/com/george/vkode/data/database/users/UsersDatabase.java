package com.george.vkode.data.database.users;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {LocalUser.class}, version = 1)
public abstract class UsersDatabase extends RoomDatabase {
    private static UsersDatabase instance;
    public abstract UsersDao usersDao();
    public static synchronized UsersDatabase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    UsersDatabase.class, "users_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }
    private static final RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            ExecutorService service = Executors.newSingleThreadExecutor();
            service.execute(() -> instance.usersDao());
        }
    };
}
