package com.amgcyo.cuttadon.database;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.MkCommentStatus;
import com.amgcyo.cuttadon.api.entity.other.MkConfigSource;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.app.MkApplication;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Database(entities = {MkBook.class, MkConfigSource.class, MkCommentStatus.class, MkUser.class}, exportSchema = false, version = 39)
public abstract class AppDatabase extends RoomDatabase {
    private static final Migration a = new a(36, 37);
    private static final Migration b = new b(37, 38);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Migration f3619c = new c(36, 38);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Migration f3620d = new d(38, 39);

    class a extends Migration {
        a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // androidx.room.migration.Migration
        public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            AppDatabase.f(supportSQLiteDatabase);
        }
    }

    class b extends Migration {
        b(int i2, int i3) {
            super(i2, i3);
        }

        @Override // androidx.room.migration.Migration
        public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            AppDatabase.g(supportSQLiteDatabase);
        }
    }

    class c extends Migration {
        c(int i2, int i3) {
            super(i2, i3);
        }

        @Override // androidx.room.migration.Migration
        public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            AppDatabase.f(supportSQLiteDatabase);
            AppDatabase.g(supportSQLiteDatabase);
        }
    }

    class d extends Migration {
        d(int i2, int i3) {
            super(i2, i3);
        }

        @Override // androidx.room.migration.Migration
        public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            AppDatabase.h(supportSQLiteDatabase);
        }
    }

    private static class e {
        private static final AppDatabase a = (AppDatabase) Room.databaseBuilder(MkApplication.getAppContext(), AppDatabase.class, "fatCatAppDb").allowMainThreadQueries().openHelperFactory(new com.amgcyo.cuttadon.database.e(new FrameworkSQLiteOpenHelperFactory(), new a())).addMigrations(AppDatabase.a, AppDatabase.b, AppDatabase.f3619c, AppDatabase.f3620d).fallbackToDestructiveMigration().build();

        class a implements com.amgcyo.cuttadon.database.c {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(SupportSQLiteDatabase supportSQLiteDatabase) {
    }

    public static AppDatabase i() {
        return e.a;
    }

    public abstract f a();

    public abstract h b();

    public abstract j c();

    public abstract l d();

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("ALTER TABLE `ArtBook`  ADD COLUMN `refreshtime` TEXT ");
        supportSQLiteDatabase.execSQL("ALTER TABLE `ArtUser`  ADD COLUMN `ad_style` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE `ArtUser`  ADD COLUMN `master_user_id` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE `ArtUser`  ADD COLUMN `invitation_code` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE `ArtUser`  ADD COLUMN `invitation_count` INTEGER NOT NULL DEFAULT 0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("ALTER TABLE `ArtBook`  ADD COLUMN `crawl_book_id` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE `ArtBook`  ADD COLUMN `jpush_status` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE `ArtBook`  ADD COLUMN `book_int_filed_1` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE `ArtBook`  ADD COLUMN `book_int_filed_2` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE `ArtBook`  ADD COLUMN `book_int_filed_3` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE `ArtBook`  ADD COLUMN `book_int_filed_4` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE `ArtBook`  ADD COLUMN `book_int_filed_5` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE `ArtBook`  ADD COLUMN `book_int_filed_6` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE `ArtBook`  ADD COLUMN `book_text_filed_1` TEXT ");
        supportSQLiteDatabase.execSQL("ALTER TABLE `ArtBook`  ADD COLUMN `book_text_filed_2` TEXT ");
        supportSQLiteDatabase.execSQL("ALTER TABLE `ArtBook`  ADD COLUMN `book_text_filed_3` TEXT ");
        supportSQLiteDatabase.execSQL("ALTER TABLE `ArtBook`  ADD COLUMN `book_text_filed_4` TEXT ");
        supportSQLiteDatabase.execSQL("ALTER TABLE `ArtBook`  ADD COLUMN `book_text_filed_5` TEXT ");
        supportSQLiteDatabase.execSQL("ALTER TABLE `ArtBook`  ADD COLUMN `book_text_filed_6` TEXT ");
    }
}
