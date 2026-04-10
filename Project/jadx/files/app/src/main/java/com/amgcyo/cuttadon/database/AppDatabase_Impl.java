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
import cn.bmob.v3.util.BmobDbOpenHelper;
import com.anythink.expressad.foundation.d.c;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class AppDatabase_Impl extends AppDatabase {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile f f3621e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile j f3622f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile h f3623g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile l f3624h;

    class a extends RoomOpenHelper.Delegate {
        a(int i2) {
            super(i2);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `MkBook` (`art_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `book_id` INTEGER NOT NULL, `name` TEXT, `author` TEXT, `form` INTEGER NOT NULL, `image` TEXT, `ltype` TEXT, `stype` TEXT, `status` INTEGER NOT NULL, `refreshtime` TEXT, `fav_count` INTEGER NOT NULL, `comment_number` INTEGER NOT NULL, `last_chapter_name` TEXT, `last_crawler_book_id` INTEGER NOT NULL, `updated_at` TEXT, `vertical_top` INTEGER NOT NULL, `words_number` INTEGER NOT NULL, `list_path` TEXT, `list_reload_path` TEXT, `chapter_count` INTEGER NOT NULL, `reading_site_id` TEXT, `reading_site_path` TEXT, `site_path_reload` TEXT, `score` TEXT, `view_count` INTEGER NOT NULL, `score_number` INTEGER NOT NULL, `reading_site_reload_path` TEXT, `crawl_book_id` INTEGER NOT NULL, `jpush_status` INTEGER NOT NULL, `jpush_today_time` TEXT, `bg_color` INTEGER NOT NULL, `book_int_filed_1` INTEGER NOT NULL, `book_int_filed_2` INTEGER NOT NULL, `book_int_filed_3` INTEGER NOT NULL, `book_int_filed_4` INTEGER NOT NULL, `book_int_filed_5` INTEGER NOT NULL, `book_int_filed_6` INTEGER NOT NULL, `book_shelf_category` TEXT, `comic_source` TEXT, `book_text_filed_1` TEXT, `book_text_filed_2` TEXT, `book_text_filed_3` TEXT, `book_text_filed_4` TEXT, `book_text_filed_5` TEXT, `book_text_filed_6` TEXT, `siteName` TEXT, `is_top` INTEGER NOT NULL, `is_fatten` INTEGER NOT NULL, `fatten_num` INTEGER NOT NULL, `reading_datetime` INTEGER NOT NULL, `reading_chapter_key` INTEGER NOT NULL, `last_read_chapterName` TEXT, `read_begin` INTEGER NOT NULL, `reading_chapter_path` TEXT, `reload_updated_at` INTEGER NOT NULL, `updated` INTEGER NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_MkBook_book_id` ON `MkBook` (`book_id`)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `MkConfigSource` (`art_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `site_id` TEXT, `url_state` INTEGER NOT NULL, `regular_time` INTEGER NOT NULL, `regular` TEXT)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `MkCommentStatus` (`art_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `commentId` INTEGER NOT NULL, `comment_fav_status` INTEGER NOT NULL, `likeUserId` INTEGER NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_MkCommentStatus_art_id` ON `MkCommentStatus` (`art_id`)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `MkUser` (`art_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `user_id` INTEGER NOT NULL, `user` TEXT, `phone` TEXT, `token` TEXT, `nick` TEXT, `avatar` TEXT, `sex` INTEGER NOT NULL, `ad_style` INTEGER NOT NULL, `master_user_id` INTEGER NOT NULL, `invitation_code` TEXT, `invitation_count` INTEGER NOT NULL, `data` TEXT)");
            supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_MkUser_user_id` ON `MkUser` (`user_id`)");
            supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '9004af89f541ce27daf2d037dca2ea32')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `MkBook`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `MkConfigSource`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `MkCommentStatus`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `MkUser`");
            if (((RoomDatabase) AppDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) AppDatabase_Impl.this).mCallbacks.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) AppDatabase_Impl.this).mCallbacks.get(i2)).onDestructiveMigration(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        protected void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (((RoomDatabase) AppDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) AppDatabase_Impl.this).mCallbacks.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) AppDatabase_Impl.this).mCallbacks.get(i2)).onCreate(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            ((RoomDatabase) AppDatabase_Impl.this).mDatabase = supportSQLiteDatabase;
            AppDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
            if (((RoomDatabase) AppDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) AppDatabase_Impl.this).mCallbacks.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) AppDatabase_Impl.this).mCallbacks.get(i2)).onOpen(supportSQLiteDatabase);
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
            HashMap map = new HashMap(56);
            map.put("art_id", new TableInfo.Column("art_id", "INTEGER", true, 1, null, 1));
            map.put("book_id", new TableInfo.Column("book_id", "INTEGER", true, 0, null, 1));
            map.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, 1));
            map.put("author", new TableInfo.Column("author", "TEXT", false, 0, null, 1));
            map.put("form", new TableInfo.Column("form", "INTEGER", true, 0, null, 1));
            map.put(c.C0205c.f10205e, new TableInfo.Column(c.C0205c.f10205e, "TEXT", false, 0, null, 1));
            map.put("ltype", new TableInfo.Column("ltype", "TEXT", false, 0, null, 1));
            map.put("stype", new TableInfo.Column("stype", "TEXT", false, 0, null, 1));
            map.put("status", new TableInfo.Column("status", "INTEGER", true, 0, null, 1));
            map.put("refreshtime", new TableInfo.Column("refreshtime", "TEXT", false, 0, null, 1));
            map.put("fav_count", new TableInfo.Column("fav_count", "INTEGER", true, 0, null, 1));
            map.put("comment_number", new TableInfo.Column("comment_number", "INTEGER", true, 0, null, 1));
            map.put("last_chapter_name", new TableInfo.Column("last_chapter_name", "TEXT", false, 0, null, 1));
            map.put("last_crawler_book_id", new TableInfo.Column("last_crawler_book_id", "INTEGER", true, 0, null, 1));
            map.put("updated_at", new TableInfo.Column("updated_at", "TEXT", false, 0, null, 1));
            map.put("vertical_top", new TableInfo.Column("vertical_top", "INTEGER", true, 0, null, 1));
            map.put("words_number", new TableInfo.Column("words_number", "INTEGER", true, 0, null, 1));
            map.put("list_path", new TableInfo.Column("list_path", "TEXT", false, 0, null, 1));
            map.put("list_reload_path", new TableInfo.Column("list_reload_path", "TEXT", false, 0, null, 1));
            map.put("chapter_count", new TableInfo.Column("chapter_count", "INTEGER", true, 0, null, 1));
            map.put("reading_site_id", new TableInfo.Column("reading_site_id", "TEXT", false, 0, null, 1));
            map.put("reading_site_path", new TableInfo.Column("reading_site_path", "TEXT", false, 0, null, 1));
            map.put("site_path_reload", new TableInfo.Column("site_path_reload", "TEXT", false, 0, null, 1));
            map.put("score", new TableInfo.Column("score", "TEXT", false, 0, null, 1));
            map.put("view_count", new TableInfo.Column("view_count", "INTEGER", true, 0, null, 1));
            map.put("score_number", new TableInfo.Column("score_number", "INTEGER", true, 0, null, 1));
            map.put("reading_site_reload_path", new TableInfo.Column("reading_site_reload_path", "TEXT", false, 0, null, 1));
            map.put("crawl_book_id", new TableInfo.Column("crawl_book_id", "INTEGER", true, 0, null, 1));
            map.put("jpush_status", new TableInfo.Column("jpush_status", "INTEGER", true, 0, null, 1));
            map.put("jpush_today_time", new TableInfo.Column("jpush_today_time", "TEXT", false, 0, null, 1));
            map.put("bg_color", new TableInfo.Column("bg_color", "INTEGER", true, 0, null, 1));
            map.put("book_int_filed_1", new TableInfo.Column("book_int_filed_1", "INTEGER", true, 0, null, 1));
            map.put("book_int_filed_2", new TableInfo.Column("book_int_filed_2", "INTEGER", true, 0, null, 1));
            map.put("book_int_filed_3", new TableInfo.Column("book_int_filed_3", "INTEGER", true, 0, null, 1));
            map.put("book_int_filed_4", new TableInfo.Column("book_int_filed_4", "INTEGER", true, 0, null, 1));
            map.put("book_int_filed_5", new TableInfo.Column("book_int_filed_5", "INTEGER", true, 0, null, 1));
            map.put("book_int_filed_6", new TableInfo.Column("book_int_filed_6", "INTEGER", true, 0, null, 1));
            map.put("book_shelf_category", new TableInfo.Column("book_shelf_category", "TEXT", false, 0, null, 1));
            map.put("comic_source", new TableInfo.Column("comic_source", "TEXT", false, 0, null, 1));
            map.put("book_text_filed_1", new TableInfo.Column("book_text_filed_1", "TEXT", false, 0, null, 1));
            map.put("book_text_filed_2", new TableInfo.Column("book_text_filed_2", "TEXT", false, 0, null, 1));
            map.put("book_text_filed_3", new TableInfo.Column("book_text_filed_3", "TEXT", false, 0, null, 1));
            map.put("book_text_filed_4", new TableInfo.Column("book_text_filed_4", "TEXT", false, 0, null, 1));
            map.put("book_text_filed_5", new TableInfo.Column("book_text_filed_5", "TEXT", false, 0, null, 1));
            map.put("book_text_filed_6", new TableInfo.Column("book_text_filed_6", "TEXT", false, 0, null, 1));
            map.put("siteName", new TableInfo.Column("siteName", "TEXT", false, 0, null, 1));
            map.put("is_top", new TableInfo.Column("is_top", "INTEGER", true, 0, null, 1));
            map.put("is_fatten", new TableInfo.Column("is_fatten", "INTEGER", true, 0, null, 1));
            map.put("fatten_num", new TableInfo.Column("fatten_num", "INTEGER", true, 0, null, 1));
            map.put("reading_datetime", new TableInfo.Column("reading_datetime", "INTEGER", true, 0, null, 1));
            map.put("reading_chapter_key", new TableInfo.Column("reading_chapter_key", "INTEGER", true, 0, null, 1));
            map.put("last_read_chapterName", new TableInfo.Column("last_read_chapterName", "TEXT", false, 0, null, 1));
            map.put("read_begin", new TableInfo.Column("read_begin", "INTEGER", true, 0, null, 1));
            map.put("reading_chapter_path", new TableInfo.Column("reading_chapter_path", "TEXT", false, 0, null, 1));
            map.put("reload_updated_at", new TableInfo.Column("reload_updated_at", "INTEGER", true, 0, null, 1));
            map.put("updated", new TableInfo.Column("updated", "INTEGER", true, 0, null, 1));
            HashSet hashSet = new HashSet(0);
            HashSet hashSet2 = new HashSet(1);
            hashSet2.add(new TableInfo.Index("index_MkBook_book_id", true, Arrays.asList("book_id")));
            TableInfo tableInfo = new TableInfo("MkBook", map, hashSet, hashSet2);
            TableInfo tableInfo2 = TableInfo.read(supportSQLiteDatabase, "MkBook");
            if (!tableInfo.equals(tableInfo2)) {
                return new RoomOpenHelper.ValidationResult(false, "MkBook(com.amgcyo.cuttadon.api.entity.other.MkBook).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
            }
            HashMap map2 = new HashMap(5);
            map2.put("art_id", new TableInfo.Column("art_id", "INTEGER", true, 1, null, 1));
            map2.put(TTLiveConstants.APP_SITEID_KEY, new TableInfo.Column(TTLiveConstants.APP_SITEID_KEY, "TEXT", false, 0, null, 1));
            map2.put("url_state", new TableInfo.Column("url_state", "INTEGER", true, 0, null, 1));
            map2.put("regular_time", new TableInfo.Column("regular_time", "INTEGER", true, 0, null, 1));
            map2.put("regular", new TableInfo.Column("regular", "TEXT", false, 0, null, 1));
            TableInfo tableInfo3 = new TableInfo("MkConfigSource", map2, new HashSet(0), new HashSet(0));
            TableInfo tableInfo4 = TableInfo.read(supportSQLiteDatabase, "MkConfigSource");
            if (!tableInfo3.equals(tableInfo4)) {
                return new RoomOpenHelper.ValidationResult(false, "MkConfigSource(com.amgcyo.cuttadon.api.entity.other.MkConfigSource).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
            }
            HashMap map3 = new HashMap(4);
            map3.put("art_id", new TableInfo.Column("art_id", "INTEGER", true, 1, null, 1));
            map3.put("commentId", new TableInfo.Column("commentId", "INTEGER", true, 0, null, 1));
            map3.put("comment_fav_status", new TableInfo.Column("comment_fav_status", "INTEGER", true, 0, null, 1));
            map3.put("likeUserId", new TableInfo.Column("likeUserId", "INTEGER", true, 0, null, 1));
            HashSet hashSet3 = new HashSet(0);
            HashSet hashSet4 = new HashSet(1);
            hashSet4.add(new TableInfo.Index("index_MkCommentStatus_art_id", true, Arrays.asList("art_id")));
            TableInfo tableInfo5 = new TableInfo("MkCommentStatus", map3, hashSet3, hashSet4);
            TableInfo tableInfo6 = TableInfo.read(supportSQLiteDatabase, "MkCommentStatus");
            if (!tableInfo5.equals(tableInfo6)) {
                return new RoomOpenHelper.ValidationResult(false, "MkCommentStatus(com.amgcyo.cuttadon.api.entity.other.MkCommentStatus).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfo6);
            }
            HashMap map4 = new HashMap(13);
            map4.put("art_id", new TableInfo.Column("art_id", "INTEGER", true, 1, null, 1));
            map4.put("user_id", new TableInfo.Column("user_id", "INTEGER", true, 0, null, 1));
            map4.put(BmobDbOpenHelper.USER, new TableInfo.Column(BmobDbOpenHelper.USER, "TEXT", false, 0, null, 1));
            map4.put("phone", new TableInfo.Column("phone", "TEXT", false, 0, null, 1));
            map4.put("token", new TableInfo.Column("token", "TEXT", false, 0, null, 1));
            map4.put("nick", new TableInfo.Column("nick", "TEXT", false, 0, null, 1));
            map4.put("avatar", new TableInfo.Column("avatar", "TEXT", false, 0, null, 1));
            map4.put(ArticleInfo.USER_SEX, new TableInfo.Column(ArticleInfo.USER_SEX, "INTEGER", true, 0, null, 1));
            map4.put("ad_style", new TableInfo.Column("ad_style", "INTEGER", true, 0, null, 1));
            map4.put("master_user_id", new TableInfo.Column("master_user_id", "INTEGER", true, 0, null, 1));
            map4.put("invitation_code", new TableInfo.Column("invitation_code", "TEXT", false, 0, null, 1));
            map4.put("invitation_count", new TableInfo.Column("invitation_count", "INTEGER", true, 0, null, 1));
            map4.put("data", new TableInfo.Column("data", "TEXT", false, 0, null, 1));
            HashSet hashSet5 = new HashSet(0);
            HashSet hashSet6 = new HashSet(1);
            hashSet6.add(new TableInfo.Index("index_MkUser_user_id", true, Arrays.asList("user_id")));
            TableInfo tableInfo7 = new TableInfo("MkUser", map4, hashSet5, hashSet6);
            TableInfo tableInfo8 = TableInfo.read(supportSQLiteDatabase, "MkUser");
            if (tableInfo7.equals(tableInfo8)) {
                return new RoomOpenHelper.ValidationResult(true, null);
            }
            return new RoomOpenHelper.ValidationResult(false, "MkUser(com.amgcyo.cuttadon.api.entity.other.MkUser).\n Expected:\n" + tableInfo7 + "\n Found:\n" + tableInfo8);
        }
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `MkBook`");
            writableDatabase.execSQL("DELETE FROM `MkConfigSource`");
            writableDatabase.execSQL("DELETE FROM `MkCommentStatus`");
            writableDatabase.execSQL("DELETE FROM `MkUser`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "MkBook", "MkConfigSource", "MkCommentStatus", "MkUser");
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new a(39), "9004af89f541ce27daf2d037dca2ea32", "7e3a458c996ce6f713585ba8bf5b200f")).build());
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
        map.put(f.class, g.e());
        map.put(j.class, k.b());
        map.put(h.class, i.c());
        map.put(l.class, m.d());
        return map;
    }

    @Override // com.amgcyo.cuttadon.database.AppDatabase
    public j c() {
        j jVar;
        if (this.f3622f != null) {
            return this.f3622f;
        }
        synchronized (this) {
            if (this.f3622f == null) {
                this.f3622f = new k(this);
            }
            jVar = this.f3622f;
        }
        return jVar;
    }

    @Override // com.amgcyo.cuttadon.database.AppDatabase
    public l d() {
        l lVar;
        if (this.f3624h != null) {
            return this.f3624h;
        }
        synchronized (this) {
            if (this.f3624h == null) {
                this.f3624h = new m(this);
            }
            lVar = this.f3624h;
        }
        return lVar;
    }

    @Override // com.amgcyo.cuttadon.database.AppDatabase
    public f a() {
        f fVar;
        if (this.f3621e != null) {
            return this.f3621e;
        }
        synchronized (this) {
            if (this.f3621e == null) {
                this.f3621e = new g(this);
            }
            fVar = this.f3621e;
        }
        return fVar;
    }

    @Override // com.amgcyo.cuttadon.database.AppDatabase
    public h b() {
        h hVar;
        if (this.f3623g != null) {
            return this.f3623g;
        }
        synchronized (this) {
            if (this.f3623g == null) {
                this.f3623g = new i(this);
            }
            hVar = this.f3623g;
        }
        return hVar;
    }
}
