package com.amgcyo.cuttadon.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import com.amgcyo.cuttadon.api.entity.other.LocalReadHistoryBean;
import com.amgcyo.cuttadon.app.MkApplication;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Database(entities = {LocalReadHistoryBean.class}, exportSchema = false, version = 1)
public abstract class ReadHistoryDatabase extends RoomDatabase {
    private static ReadHistoryDatabase a;

    class a implements c {
        a() {
        }

        @Override // com.amgcyo.cuttadon.database.c
        public void a(@NotNull SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        @Override // com.amgcyo.cuttadon.database.c
        public void a(@NotNull SupportSQLiteDatabase supportSQLiteDatabase, int i2, int i3) {
        }

        @Override // com.amgcyo.cuttadon.database.c
        public void b(@NotNull SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        @Override // com.amgcyo.cuttadon.database.c
        public void b(@NotNull SupportSQLiteDatabase supportSQLiteDatabase, int i2, int i3) {
        }

        @Override // com.amgcyo.cuttadon.database.c
        public void c(@NotNull SupportSQLiteDatabase supportSQLiteDatabase) {
            com.amgcyo.cuttadon.utils.otherutils.g.b(true);
        }

        @Override // com.amgcyo.cuttadon.database.c
        public void d(@NotNull SupportSQLiteDatabase supportSQLiteDatabase) {
        }
    }

    public static ReadHistoryDatabase b() {
        if (a == null) {
            a = (ReadHistoryDatabase) Room.databaseBuilder(MkApplication.getAppContext(), ReadHistoryDatabase.class, "ReadHistoryDb").allowMainThreadQueries().openHelperFactory(new e(new FrameworkSQLiteOpenHelperFactory(), new a())).build();
        }
        return a;
    }

    public abstract com.amgcyo.cuttadon.database.a a();
}
