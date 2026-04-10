package com.funny.audio.database;

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
import com.funny.audio.database.dao.AdSettingDao;
import com.funny.audio.database.dao.AdSettingDao_Impl;
import com.funny.audio.database.dao.AppSettingDao;
import com.funny.audio.database.dao.AppSettingDao_Impl;
import com.funny.audio.database.dao.BookshelfDao;
import com.funny.audio.database.dao.BookshelfDao_Impl;
import com.funny.audio.database.dao.PlayHistoryDao;
import com.funny.audio.database.dao.PlayHistoryDao_Impl;
import com.funny.audio.database.dao.PlayProgressDao;
import com.funny.audio.database.dao.PlayProgressDao_Impl;
import com.funny.audio.database.dao.PlaySettingDao;
import com.funny.audio.database.dao.PlaySettingDao_Impl;
import com.funny.audio.database.dao.SearchHistoryDao;
import com.funny.audio.database.dao.SearchHistoryDao_Impl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class DbContext_Impl extends DbContext {
    private volatile AdSettingDao _adSettingDao;
    private volatile AppSettingDao _appSettingDao;
    private volatile BookshelfDao _bookshelfDao;
    private volatile PlayHistoryDao _playHistoryDao;
    private volatile PlayProgressDao _playProgressDao;
    private volatile PlaySettingDao _playSettingDao;
    private volatile SearchHistoryDao _searchHistoryDao;

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(final DatabaseConfiguration config) {
        return config.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) { // from class: com.funny.audio.database.DbContext_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(final SupportSQLiteDatabase db) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(final SupportSQLiteDatabase db) {
                db.execSQL("CREATE TABLE IF NOT EXISTS `AppSettingEntity` (`settingKey` TEXT NOT NULL, `type` TEXT NOT NULL, `name` TEXT NOT NULL, `desc` TEXT NOT NULL, `time` INTEGER NOT NULL, `userId` TEXT NOT NULL, `value` TEXT NOT NULL, `valueBoolean` INTEGER NOT NULL, `valueInt` INTEGER NOT NULL, `valueLong` INTEGER NOT NULL, `valueFloat` REAL NOT NULL, `valueDouble` REAL NOT NULL, PRIMARY KEY(`settingKey`))");
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_AppSettingEntity_type` ON `AppSettingEntity` (`type`)");
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_AppSettingEntity_time` ON `AppSettingEntity` (`time` DESC)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `SearchHistoryEntity` (`keyword` TEXT NOT NULL, `time` INTEGER NOT NULL, PRIMARY KEY(`keyword`))");
                db.execSQL("CREATE TABLE IF NOT EXISTS `PlaySettingEntity` (`albumId` TEXT NOT NULL, `value` TEXT NOT NULL, `time` INTEGER NOT NULL, PRIMARY KEY(`albumId`))");
                db.execSQL("CREATE TABLE IF NOT EXISTS `PlayProgressEntity` (`albumId` TEXT NOT NULL, `trackId` TEXT NOT NULL, `trackIndex` INTEGER NOT NULL, `totalDuration` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `time` INTEGER NOT NULL, PRIMARY KEY(`albumId`))");
                db.execSQL("CREATE TABLE IF NOT EXISTS `BookshelfEntity` (`albumId` TEXT NOT NULL, `title` TEXT NOT NULL, `announcer` TEXT, `announcerId` TEXT, `categoryId` TEXT, `category` TEXT, `coverPath` TEXT NOT NULL, `finishStatus` INTEGER NOT NULL, `trackCount` INTEGER NOT NULL, `trackIndex` INTEGER NOT NULL, `latestTrackId` TEXT NOT NULL, `latestTrackTitle` TEXT NOT NULL, `lastUpdateTime` INTEGER NOT NULL, `lastReadTime` INTEGER NOT NULL, `lastSyncTime` INTEGER NOT NULL DEFAULT 0, `dataState` INTEGER NOT NULL DEFAULT 0, `collectTime` INTEGER NOT NULL, PRIMARY KEY(`albumId`))");
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_BookshelfEntity_announcerId` ON `BookshelfEntity` (`announcerId`)");
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_BookshelfEntity_categoryId` ON `BookshelfEntity` (`categoryId`)");
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_BookshelfEntity_lastUpdateTime` ON `BookshelfEntity` (`lastUpdateTime` DESC)");
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_BookshelfEntity_collectTime` ON `BookshelfEntity` (`collectTime` DESC)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `PlayHistoryEntity` (`albumId` TEXT NOT NULL, `title` TEXT NOT NULL, `announcer` TEXT NOT NULL, `announcerId` TEXT NOT NULL, `categoryId` TEXT NOT NULL, `category` TEXT NOT NULL, `tagId` TEXT NOT NULL, `tag` TEXT NOT NULL, `coverPath` TEXT NOT NULL, `finishStatus` INTEGER NOT NULL, `trackCount` INTEGER NOT NULL, `trackIndex` INTEGER NOT NULL, `lastTrackId` TEXT NOT NULL, `lastTrackTitle` TEXT NOT NULL, `lastUpdateTime` INTEGER NOT NULL, `time` INTEGER NOT NULL, `lastSyncTime` INTEGER NOT NULL DEFAULT 0, `dataState` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`albumId`))");
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_PlayHistoryEntity_announcerId` ON `PlayHistoryEntity` (`announcerId`)");
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_PlayHistoryEntity_categoryId` ON `PlayHistoryEntity` (`categoryId`)");
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_PlayHistoryEntity_tagId` ON `PlayHistoryEntity` (`tagId`)");
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_PlayHistoryEntity_lastUpdateTime` ON `PlayHistoryEntity` (`lastUpdateTime` DESC)");
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_PlayHistoryEntity_time` ON `PlayHistoryEntity` (`time` DESC)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `AdSettingEntity` (`id` TEXT NOT NULL, `key` TEXT NOT NULL, `name` TEXT NOT NULL, `psign` TEXT NOT NULL, `show` INTEGER NOT NULL, `freeTime` INTEGER NOT NULL, `rewardDuration` INTEGER NOT NULL DEFAULT 0, `adType` TEXT NOT NULL DEFAULT 'default', `maxShowCount` INTEGER NOT NULL, `preloadInterval` INTEGER NOT NULL, `showInterval` INTEGER NOT NULL, `codeId` TEXT NOT NULL, `description` TEXT NOT NULL DEFAULT '', `createTime` INTEGER NOT NULL, `updateTime` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_AdSettingEntity_key` ON `AdSettingEntity` (`key`)");
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_AdSettingEntity_createTime` ON `AdSettingEntity` (`createTime` ASC)");
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_AdSettingEntity_updateTime` ON `AdSettingEntity` (`updateTime` DESC)");
                db.execSQL(RoomMasterTable.CREATE_QUERY);
                db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '397be816e529f829a5f8634b79da143c')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(final SupportSQLiteDatabase db) {
                db.execSQL("DROP TABLE IF EXISTS `AppSettingEntity`");
                db.execSQL("DROP TABLE IF EXISTS `SearchHistoryEntity`");
                db.execSQL("DROP TABLE IF EXISTS `PlaySettingEntity`");
                db.execSQL("DROP TABLE IF EXISTS `PlayProgressEntity`");
                db.execSQL("DROP TABLE IF EXISTS `BookshelfEntity`");
                db.execSQL("DROP TABLE IF EXISTS `PlayHistoryEntity`");
                db.execSQL("DROP TABLE IF EXISTS `AdSettingEntity`");
                List list = DbContext_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onDestructiveMigration(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(final SupportSQLiteDatabase db) {
                List list = DbContext_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onCreate(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(final SupportSQLiteDatabase db) {
                DbContext_Impl.this.mDatabase = db;
                DbContext_Impl.this.internalInitInvalidationTracker(db);
                List list = DbContext_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onOpen(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(final SupportSQLiteDatabase db) {
                DBUtil.dropFtsSyncTriggers(db);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public RoomOpenHelper.ValidationResult onValidateSchema(final SupportSQLiteDatabase db) {
                HashMap map = new HashMap(12);
                map.put("settingKey", new TableInfo.Column("settingKey", "TEXT", true, 1, null, 1));
                map.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, 1));
                map.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                map.put("desc", new TableInfo.Column("desc", "TEXT", true, 0, null, 1));
                map.put("time", new TableInfo.Column("time", "INTEGER", true, 0, null, 1));
                map.put("userId", new TableInfo.Column("userId", "TEXT", true, 0, null, 1));
                map.put("value", new TableInfo.Column("value", "TEXT", true, 0, null, 1));
                map.put("valueBoolean", new TableInfo.Column("valueBoolean", "INTEGER", true, 0, null, 1));
                map.put("valueInt", new TableInfo.Column("valueInt", "INTEGER", true, 0, null, 1));
                map.put("valueLong", new TableInfo.Column("valueLong", "INTEGER", true, 0, null, 1));
                map.put("valueFloat", new TableInfo.Column("valueFloat", "REAL", true, 0, null, 1));
                map.put("valueDouble", new TableInfo.Column("valueDouble", "REAL", true, 0, null, 1));
                HashSet hashSet = new HashSet(0);
                HashSet hashSet2 = new HashSet(2);
                hashSet2.add(new TableInfo.Index("index_AppSettingEntity_type", false, Arrays.asList("type"), Arrays.asList("ASC")));
                hashSet2.add(new TableInfo.Index("index_AppSettingEntity_time", false, Arrays.asList("time"), Arrays.asList("DESC")));
                TableInfo tableInfo = new TableInfo("AppSettingEntity", map, hashSet, hashSet2);
                TableInfo tableInfo2 = TableInfo.read(db, "AppSettingEntity");
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenHelper.ValidationResult(false, "AppSettingEntity(com.funny.audio.settings.AppSettingEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                }
                HashMap map2 = new HashMap(2);
                map2.put("keyword", new TableInfo.Column("keyword", "TEXT", true, 1, null, 1));
                map2.put("time", new TableInfo.Column("time", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo3 = new TableInfo("SearchHistoryEntity", map2, new HashSet(0), new HashSet(0));
                TableInfo tableInfo4 = TableInfo.read(db, "SearchHistoryEntity");
                if (!tableInfo3.equals(tableInfo4)) {
                    return new RoomOpenHelper.ValidationResult(false, "SearchHistoryEntity(com.funny.audio.database.entities.SearchHistoryEntity).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
                }
                HashMap map3 = new HashMap(3);
                map3.put("albumId", new TableInfo.Column("albumId", "TEXT", true, 1, null, 1));
                map3.put("value", new TableInfo.Column("value", "TEXT", true, 0, null, 1));
                map3.put("time", new TableInfo.Column("time", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo5 = new TableInfo("PlaySettingEntity", map3, new HashSet(0), new HashSet(0));
                TableInfo tableInfo6 = TableInfo.read(db, "PlaySettingEntity");
                if (!tableInfo5.equals(tableInfo6)) {
                    return new RoomOpenHelper.ValidationResult(false, "PlaySettingEntity(com.funny.audio.database.entities.PlaySettingEntity).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfo6);
                }
                HashMap map4 = new HashMap(6);
                map4.put("albumId", new TableInfo.Column("albumId", "TEXT", true, 1, null, 1));
                map4.put("trackId", new TableInfo.Column("trackId", "TEXT", true, 0, null, 1));
                map4.put("trackIndex", new TableInfo.Column("trackIndex", "INTEGER", true, 0, null, 1));
                map4.put("totalDuration", new TableInfo.Column("totalDuration", "INTEGER", true, 0, null, 1));
                map4.put("duration", new TableInfo.Column("duration", "INTEGER", true, 0, null, 1));
                map4.put("time", new TableInfo.Column("time", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo7 = new TableInfo("PlayProgressEntity", map4, new HashSet(0), new HashSet(0));
                TableInfo tableInfo8 = TableInfo.read(db, "PlayProgressEntity");
                if (!tableInfo7.equals(tableInfo8)) {
                    return new RoomOpenHelper.ValidationResult(false, "PlayProgressEntity(com.funny.audio.database.entities.PlayProgressEntity).\n Expected:\n" + tableInfo7 + "\n Found:\n" + tableInfo8);
                }
                HashMap map5 = new HashMap(17);
                map5.put("albumId", new TableInfo.Column("albumId", "TEXT", true, 1, null, 1));
                map5.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, 1));
                map5.put("announcer", new TableInfo.Column("announcer", "TEXT", false, 0, null, 1));
                map5.put("announcerId", new TableInfo.Column("announcerId", "TEXT", false, 0, null, 1));
                map5.put("categoryId", new TableInfo.Column("categoryId", "TEXT", false, 0, null, 1));
                map5.put("category", new TableInfo.Column("category", "TEXT", false, 0, null, 1));
                map5.put("coverPath", new TableInfo.Column("coverPath", "TEXT", true, 0, null, 1));
                map5.put("finishStatus", new TableInfo.Column("finishStatus", "INTEGER", true, 0, null, 1));
                map5.put("trackCount", new TableInfo.Column("trackCount", "INTEGER", true, 0, null, 1));
                map5.put("trackIndex", new TableInfo.Column("trackIndex", "INTEGER", true, 0, null, 1));
                map5.put("latestTrackId", new TableInfo.Column("latestTrackId", "TEXT", true, 0, null, 1));
                map5.put("latestTrackTitle", new TableInfo.Column("latestTrackTitle", "TEXT", true, 0, null, 1));
                map5.put("lastUpdateTime", new TableInfo.Column("lastUpdateTime", "INTEGER", true, 0, null, 1));
                map5.put("lastReadTime", new TableInfo.Column("lastReadTime", "INTEGER", true, 0, null, 1));
                map5.put("lastSyncTime", new TableInfo.Column("lastSyncTime", "INTEGER", true, 0, "0", 1));
                map5.put("dataState", new TableInfo.Column("dataState", "INTEGER", true, 0, "0", 1));
                map5.put("collectTime", new TableInfo.Column("collectTime", "INTEGER", true, 0, null, 1));
                HashSet hashSet3 = new HashSet(0);
                HashSet hashSet4 = new HashSet(4);
                hashSet4.add(new TableInfo.Index("index_BookshelfEntity_announcerId", false, Arrays.asList("announcerId"), Arrays.asList("ASC")));
                hashSet4.add(new TableInfo.Index("index_BookshelfEntity_categoryId", false, Arrays.asList("categoryId"), Arrays.asList("ASC")));
                hashSet4.add(new TableInfo.Index("index_BookshelfEntity_lastUpdateTime", false, Arrays.asList("lastUpdateTime"), Arrays.asList("DESC")));
                hashSet4.add(new TableInfo.Index("index_BookshelfEntity_collectTime", false, Arrays.asList("collectTime"), Arrays.asList("DESC")));
                TableInfo tableInfo9 = new TableInfo("BookshelfEntity", map5, hashSet3, hashSet4);
                TableInfo tableInfo10 = TableInfo.read(db, "BookshelfEntity");
                if (!tableInfo9.equals(tableInfo10)) {
                    return new RoomOpenHelper.ValidationResult(false, "BookshelfEntity(com.funny.audio.database.entities.BookshelfEntity).\n Expected:\n" + tableInfo9 + "\n Found:\n" + tableInfo10);
                }
                HashMap map6 = new HashMap(18);
                map6.put("albumId", new TableInfo.Column("albumId", "TEXT", true, 1, null, 1));
                map6.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, 1));
                map6.put("announcer", new TableInfo.Column("announcer", "TEXT", true, 0, null, 1));
                map6.put("announcerId", new TableInfo.Column("announcerId", "TEXT", true, 0, null, 1));
                map6.put("categoryId", new TableInfo.Column("categoryId", "TEXT", true, 0, null, 1));
                map6.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, 1));
                map6.put("tagId", new TableInfo.Column("tagId", "TEXT", true, 0, null, 1));
                map6.put("tag", new TableInfo.Column("tag", "TEXT", true, 0, null, 1));
                map6.put("coverPath", new TableInfo.Column("coverPath", "TEXT", true, 0, null, 1));
                map6.put("finishStatus", new TableInfo.Column("finishStatus", "INTEGER", true, 0, null, 1));
                map6.put("trackCount", new TableInfo.Column("trackCount", "INTEGER", true, 0, null, 1));
                map6.put("trackIndex", new TableInfo.Column("trackIndex", "INTEGER", true, 0, null, 1));
                map6.put("lastTrackId", new TableInfo.Column("lastTrackId", "TEXT", true, 0, null, 1));
                map6.put("lastTrackTitle", new TableInfo.Column("lastTrackTitle", "TEXT", true, 0, null, 1));
                map6.put("lastUpdateTime", new TableInfo.Column("lastUpdateTime", "INTEGER", true, 0, null, 1));
                map6.put("time", new TableInfo.Column("time", "INTEGER", true, 0, null, 1));
                map6.put("lastSyncTime", new TableInfo.Column("lastSyncTime", "INTEGER", true, 0, "0", 1));
                map6.put("dataState", new TableInfo.Column("dataState", "INTEGER", true, 0, "0", 1));
                HashSet hashSet5 = new HashSet(0);
                HashSet hashSet6 = new HashSet(5);
                hashSet6.add(new TableInfo.Index("index_PlayHistoryEntity_announcerId", false, Arrays.asList("announcerId"), Arrays.asList("ASC")));
                hashSet6.add(new TableInfo.Index("index_PlayHistoryEntity_categoryId", false, Arrays.asList("categoryId"), Arrays.asList("ASC")));
                hashSet6.add(new TableInfo.Index("index_PlayHistoryEntity_tagId", false, Arrays.asList("tagId"), Arrays.asList("ASC")));
                hashSet6.add(new TableInfo.Index("index_PlayHistoryEntity_lastUpdateTime", false, Arrays.asList("lastUpdateTime"), Arrays.asList("DESC")));
                hashSet6.add(new TableInfo.Index("index_PlayHistoryEntity_time", false, Arrays.asList("time"), Arrays.asList("DESC")));
                TableInfo tableInfo11 = new TableInfo("PlayHistoryEntity", map6, hashSet5, hashSet6);
                TableInfo tableInfo12 = TableInfo.read(db, "PlayHistoryEntity");
                if (!tableInfo11.equals(tableInfo12)) {
                    return new RoomOpenHelper.ValidationResult(false, "PlayHistoryEntity(com.funny.audio.database.entities.PlayHistoryEntity).\n Expected:\n" + tableInfo11 + "\n Found:\n" + tableInfo12);
                }
                HashMap map7 = new HashMap(15);
                map7.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, 1));
                map7.put("key", new TableInfo.Column("key", "TEXT", true, 0, null, 1));
                map7.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                map7.put("psign", new TableInfo.Column("psign", "TEXT", true, 0, null, 1));
                map7.put("show", new TableInfo.Column("show", "INTEGER", true, 0, null, 1));
                map7.put("freeTime", new TableInfo.Column("freeTime", "INTEGER", true, 0, null, 1));
                map7.put("rewardDuration", new TableInfo.Column("rewardDuration", "INTEGER", true, 0, "0", 1));
                map7.put("adType", new TableInfo.Column("adType", "TEXT", true, 0, "'default'", 1));
                map7.put("maxShowCount", new TableInfo.Column("maxShowCount", "INTEGER", true, 0, null, 1));
                map7.put("preloadInterval", new TableInfo.Column("preloadInterval", "INTEGER", true, 0, null, 1));
                map7.put("showInterval", new TableInfo.Column("showInterval", "INTEGER", true, 0, null, 1));
                map7.put("codeId", new TableInfo.Column("codeId", "TEXT", true, 0, null, 1));
                map7.put("description", new TableInfo.Column("description", "TEXT", true, 0, "''", 1));
                map7.put("createTime", new TableInfo.Column("createTime", "INTEGER", true, 0, null, 1));
                map7.put("updateTime", new TableInfo.Column("updateTime", "INTEGER", true, 0, null, 1));
                HashSet hashSet7 = new HashSet(0);
                HashSet hashSet8 = new HashSet(3);
                hashSet8.add(new TableInfo.Index("index_AdSettingEntity_key", false, Arrays.asList("key"), Arrays.asList("ASC")));
                hashSet8.add(new TableInfo.Index("index_AdSettingEntity_createTime", false, Arrays.asList("createTime"), Arrays.asList("ASC")));
                hashSet8.add(new TableInfo.Index("index_AdSettingEntity_updateTime", false, Arrays.asList("updateTime"), Arrays.asList("DESC")));
                TableInfo tableInfo13 = new TableInfo("AdSettingEntity", map7, hashSet7, hashSet8);
                TableInfo tableInfo14 = TableInfo.read(db, "AdSettingEntity");
                if (!tableInfo13.equals(tableInfo14)) {
                    return new RoomOpenHelper.ValidationResult(false, "AdSettingEntity(com.funny.audio.database.entities.AdSettingEntity).\n Expected:\n" + tableInfo13 + "\n Found:\n" + tableInfo14);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "397be816e529f829a5f8634b79da143c", "3b6d0fc181cb325ca5cdb5719c4ea53d")).build());
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "AppSettingEntity", "SearchHistoryEntity", "PlaySettingEntity", "PlayProgressEntity", "BookshelfEntity", "PlayHistoryEntity", "AdSettingEntity");
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `AppSettingEntity`");
            writableDatabase.execSQL("DELETE FROM `SearchHistoryEntity`");
            writableDatabase.execSQL("DELETE FROM `PlaySettingEntity`");
            writableDatabase.execSQL("DELETE FROM `PlayProgressEntity`");
            writableDatabase.execSQL("DELETE FROM `BookshelfEntity`");
            writableDatabase.execSQL("DELETE FROM `PlayHistoryEntity`");
            writableDatabase.execSQL("DELETE FROM `AdSettingEntity`");
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
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(AppSettingDao.class, AppSettingDao_Impl.getRequiredConverters());
        map.put(PlaySettingDao.class, PlaySettingDao_Impl.getRequiredConverters());
        map.put(PlayProgressDao.class, PlayProgressDao_Impl.getRequiredConverters());
        map.put(PlayHistoryDao.class, PlayHistoryDao_Impl.getRequiredConverters());
        map.put(BookshelfDao.class, BookshelfDao_Impl.getRequiredConverters());
        map.put(SearchHistoryDao.class, SearchHistoryDao_Impl.getRequiredConverters());
        map.put(AdSettingDao.class, AdSettingDao_Impl.getRequiredConverters());
        return map;
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
        return new ArrayList();
    }

    @Override // com.funny.audio.database.DbContext
    public AppSettingDao appSetting() {
        AppSettingDao appSettingDao;
        if (this._appSettingDao != null) {
            return this._appSettingDao;
        }
        synchronized (this) {
            if (this._appSettingDao == null) {
                this._appSettingDao = new AppSettingDao_Impl(this);
            }
            appSettingDao = this._appSettingDao;
        }
        return appSettingDao;
    }

    @Override // com.funny.audio.database.DbContext
    public PlaySettingDao playSetting() {
        PlaySettingDao playSettingDao;
        if (this._playSettingDao != null) {
            return this._playSettingDao;
        }
        synchronized (this) {
            if (this._playSettingDao == null) {
                this._playSettingDao = new PlaySettingDao_Impl(this);
            }
            playSettingDao = this._playSettingDao;
        }
        return playSettingDao;
    }

    @Override // com.funny.audio.database.DbContext
    public PlayProgressDao playProgress() {
        PlayProgressDao playProgressDao;
        if (this._playProgressDao != null) {
            return this._playProgressDao;
        }
        synchronized (this) {
            if (this._playProgressDao == null) {
                this._playProgressDao = new PlayProgressDao_Impl(this);
            }
            playProgressDao = this._playProgressDao;
        }
        return playProgressDao;
    }

    @Override // com.funny.audio.database.DbContext
    public PlayHistoryDao playHistory() {
        PlayHistoryDao playHistoryDao;
        if (this._playHistoryDao != null) {
            return this._playHistoryDao;
        }
        synchronized (this) {
            if (this._playHistoryDao == null) {
                this._playHistoryDao = new PlayHistoryDao_Impl(this);
            }
            playHistoryDao = this._playHistoryDao;
        }
        return playHistoryDao;
    }

    @Override // com.funny.audio.database.DbContext
    public BookshelfDao bookshelf() {
        BookshelfDao bookshelfDao;
        if (this._bookshelfDao != null) {
            return this._bookshelfDao;
        }
        synchronized (this) {
            if (this._bookshelfDao == null) {
                this._bookshelfDao = new BookshelfDao_Impl(this);
            }
            bookshelfDao = this._bookshelfDao;
        }
        return bookshelfDao;
    }

    @Override // com.funny.audio.database.DbContext
    public SearchHistoryDao searchHistory() {
        SearchHistoryDao searchHistoryDao;
        if (this._searchHistoryDao != null) {
            return this._searchHistoryDao;
        }
        synchronized (this) {
            if (this._searchHistoryDao == null) {
                this._searchHistoryDao = new SearchHistoryDao_Impl(this);
            }
            searchHistoryDao = this._searchHistoryDao;
        }
        return searchHistoryDao;
    }

    @Override // com.funny.audio.database.DbContext
    public AdSettingDao adSetting() {
        AdSettingDao adSettingDao;
        if (this._adSettingDao != null) {
            return this._adSettingDao;
        }
        synchronized (this) {
            if (this._adSettingDao == null) {
                this._adSettingDao = new AdSettingDao_Impl(this);
            }
            adSettingDao = this._adSettingDao;
        }
        return adSettingDao;
    }
}
