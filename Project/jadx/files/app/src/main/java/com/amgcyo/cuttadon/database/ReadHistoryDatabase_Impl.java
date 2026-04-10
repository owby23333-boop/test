package com.amgcyo.cuttadon.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.anythink.expressad.foundation.d.c;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class ReadHistoryDatabase_Impl extends ReadHistoryDatabase {
    private volatile com.amgcyo.cuttadon.database.a b;

    class a extends RoomOpenHelper.Delegate {
        a(int i2) {
            super(i2);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `LocalReadHistoryBean` (`book_id` INTEGER NOT NULL, `name` TEXT, `author` TEXT, `image` TEXT, `created_at` TEXT, `ltype` TEXT, `stype` TEXT, `status` INTEGER NOT NULL, `fav_count` INTEGER NOT NULL, `comment_number` INTEGER NOT NULL, `form` INTEGER NOT NULL, `words_number` INTEGER NOT NULL, `chapter_count` INTEGER NOT NULL, `last_chapter_name` TEXT, `updated_at` TEXT, `list_reload_path` TEXT, `list_path` TEXT, `type` INTEGER NOT NULL, `needToldServer` INTEGER NOT NULL, PRIMARY KEY(`book_id`))");
            supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_LocalReadHistoryBean_book_id` ON `LocalReadHistoryBean` (`book_id`)");
            supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'b0f5b12b6750869567603a347e55d20d')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `LocalReadHistoryBean`");
            if (((RoomDatabase) ReadHistoryDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) ReadHistoryDatabase_Impl.this).mCallbacks.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) ReadHistoryDatabase_Impl.this).mCallbacks.get(i2)).onDestructiveMigration(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        protected void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (((RoomDatabase) ReadHistoryDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) ReadHistoryDatabase_Impl.this).mCallbacks.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) ReadHistoryDatabase_Impl.this).mCallbacks.get(i2)).onCreate(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            ((RoomDatabase) ReadHistoryDatabase_Impl.this).mDatabase = supportSQLiteDatabase;
            ReadHistoryDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
            if (((RoomDatabase) ReadHistoryDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) ReadHistoryDatabase_Impl.this).mCallbacks.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) ReadHistoryDatabase_Impl.this).mCallbacks.get(i2)).onOpen(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
            HashMap map = new HashMap(19);
            map.put("book_id", new TableInfo.Column("book_id", "INTEGER", true, 1, null, 1));
            map.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, 1));
            map.put("author", new TableInfo.Column("author", "TEXT", false, 0, null, 1));
            map.put(c.C0205c.f10205e, new TableInfo.Column(c.C0205c.f10205e, "TEXT", false, 0, null, 1));
            map.put("created_at", new TableInfo.Column("created_at", "TEXT", false, 0, null, 1));
            map.put("ltype", new TableInfo.Column("ltype", "TEXT", false, 0, null, 1));
            map.put("stype", new TableInfo.Column("stype", "TEXT", false, 0, null, 1));
            map.put("status", new TableInfo.Column("status", "INTEGER", true, 0, null, 1));
            map.put("fav_count", new TableInfo.Column("fav_count", "INTEGER", true, 0, null, 1));
            map.put("comment_number", new TableInfo.Column("comment_number", "INTEGER", true, 0, null, 1));
            map.put("form", new TableInfo.Column("form", "INTEGER", true, 0, null, 1));
            map.put("words_number", new TableInfo.Column("words_number", "INTEGER", true, 0, null, 1));
            map.put("chapter_count", new TableInfo.Column("chapter_count", "INTEGER", true, 0, null, 1));
            map.put("last_chapter_name", new TableInfo.Column("last_chapter_name", "TEXT", false, 0, null, 1));
            map.put("updated_at", new TableInfo.Column("updated_at", "TEXT", false, 0, null, 1));
            map.put("list_reload_path", new TableInfo.Column("list_reload_path", "TEXT", false, 0, null, 1));
            map.put("list_path", new TableInfo.Column("list_path", "TEXT", false, 0, null, 1));
            map.put("type", new TableInfo.Column("type", "INTEGER", true, 0, null, 1));
            map.put("needToldServer", new TableInfo.Column("needToldServer", "INTEGER", true, 0, null, 1));
            HashSet hashSet = new HashSet(0);
            HashSet hashSet2 = new HashSet(1);
            hashSet2.add(new TableInfo.Index("index_LocalReadHistoryBean_book_id", true, Arrays.asList("book_id")));
            TableInfo tableInfo = new TableInfo("LocalReadHistoryBean", map, hashSet, hashSet2);
            TableInfo tableInfo2 = TableInfo.read(supportSQLiteDatabase, "LocalReadHistoryBean");
            if (tableInfo.equals(tableInfo2)) {
                return new RoomOpenHelper.ValidationResult(true, null);
            }
            return new RoomOpenHelper.ValidationResult(false, "LocalReadHistoryBean(com.amgcyo.cuttadon.api.entity.other.LocalReadHistoryBean).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
        }
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `LocalReadHistoryBean`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "LocalReadHistoryBean");
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new a(1), "b0f5b12b6750869567603a347e55d20d", "2ec6ecf5c56f7119d4b4f274709ecf27")).build());
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(@NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Arrays.asList(new Migration[0]);
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(com.amgcyo.cuttadon.database.a.class, b.c());
        return map;
    }

    @Override // com.amgcyo.cuttadon.database.ReadHistoryDatabase
    public com.amgcyo.cuttadon.database.a a() {
        com.amgcyo.cuttadon.database.a aVar;
        if (this.b != null) {
            return this.b;
        }
        synchronized (this) {
            if (this.b == null) {
                this.b = new b(this);
            }
            aVar = this.b;
        }
        return aVar;
    }
}
