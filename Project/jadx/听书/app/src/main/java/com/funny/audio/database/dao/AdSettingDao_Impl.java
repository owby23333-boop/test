package com.funny.audio.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.funny.audio.database.entities.AdSettingEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class AdSettingDao_Impl implements AdSettingDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<AdSettingEntity> __deletionAdapterOfAdSettingEntity;
    private final EntityInsertionAdapter<AdSettingEntity> __insertionAdapterOfAdSettingEntity;
    private final EntityDeletionOrUpdateAdapter<AdSettingEntity> __updateAdapterOfAdSettingEntity;

    public AdSettingDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfAdSettingEntity = new EntityInsertionAdapter<AdSettingEntity>(__db) { // from class: com.funny.audio.database.dao.AdSettingDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `AdSettingEntity` (`id`,`key`,`name`,`psign`,`show`,`freeTime`,`rewardDuration`,`adType`,`maxShowCount`,`preloadInterval`,`showInterval`,`codeId`,`description`,`createTime`,`updateTime`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, AdSettingEntity adSettingEntity) {
                if (adSettingEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, adSettingEntity.getId());
                }
                if (adSettingEntity.getKey() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, adSettingEntity.getKey());
                }
                if (adSettingEntity.getName() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, adSettingEntity.getName());
                }
                if (adSettingEntity.getPsign() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, adSettingEntity.getPsign());
                }
                supportSQLiteStatement.bindLong(5, adSettingEntity.getShow() ? 1L : 0L);
                supportSQLiteStatement.bindLong(6, adSettingEntity.getFreeTime());
                supportSQLiteStatement.bindLong(7, adSettingEntity.getRewardDuration());
                if (adSettingEntity.getAdType() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, adSettingEntity.getAdType());
                }
                supportSQLiteStatement.bindLong(9, adSettingEntity.getMaxShowCount());
                supportSQLiteStatement.bindLong(10, adSettingEntity.getPreloadInterval());
                supportSQLiteStatement.bindLong(11, adSettingEntity.getShowInterval());
                if (adSettingEntity.getCodeId() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, adSettingEntity.getCodeId());
                }
                if (adSettingEntity.getDescription() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, adSettingEntity.getDescription());
                }
                supportSQLiteStatement.bindLong(14, adSettingEntity.getCreateTime());
                supportSQLiteStatement.bindLong(15, adSettingEntity.getUpdateTime());
            }
        };
        this.__deletionAdapterOfAdSettingEntity = new EntityDeletionOrUpdateAdapter<AdSettingEntity>(__db) { // from class: com.funny.audio.database.dao.AdSettingDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `AdSettingEntity` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final AdSettingEntity entity) {
                if (entity.getId() == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, entity.getId());
                }
            }
        };
        this.__updateAdapterOfAdSettingEntity = new EntityDeletionOrUpdateAdapter<AdSettingEntity>(__db) { // from class: com.funny.audio.database.dao.AdSettingDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `AdSettingEntity` SET `id` = ?,`key` = ?,`name` = ?,`psign` = ?,`show` = ?,`freeTime` = ?,`rewardDuration` = ?,`adType` = ?,`maxShowCount` = ?,`preloadInterval` = ?,`showInterval` = ?,`codeId` = ?,`description` = ?,`createTime` = ?,`updateTime` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, AdSettingEntity adSettingEntity) {
                if (adSettingEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, adSettingEntity.getId());
                }
                if (adSettingEntity.getKey() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, adSettingEntity.getKey());
                }
                if (adSettingEntity.getName() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, adSettingEntity.getName());
                }
                if (adSettingEntity.getPsign() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, adSettingEntity.getPsign());
                }
                supportSQLiteStatement.bindLong(5, adSettingEntity.getShow() ? 1L : 0L);
                supportSQLiteStatement.bindLong(6, adSettingEntity.getFreeTime());
                supportSQLiteStatement.bindLong(7, adSettingEntity.getRewardDuration());
                if (adSettingEntity.getAdType() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, adSettingEntity.getAdType());
                }
                supportSQLiteStatement.bindLong(9, adSettingEntity.getMaxShowCount());
                supportSQLiteStatement.bindLong(10, adSettingEntity.getPreloadInterval());
                supportSQLiteStatement.bindLong(11, adSettingEntity.getShowInterval());
                if (adSettingEntity.getCodeId() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, adSettingEntity.getCodeId());
                }
                if (adSettingEntity.getDescription() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, adSettingEntity.getDescription());
                }
                supportSQLiteStatement.bindLong(14, adSettingEntity.getCreateTime());
                supportSQLiteStatement.bindLong(15, adSettingEntity.getUpdateTime());
                if (adSettingEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, adSettingEntity.getId());
                }
            }
        };
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public long add(final AdSettingEntity info) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfAdSettingEntity.insertAndReturnId(info);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public void addList(final List<? extends AdSettingEntity> infos) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfAdSettingEntity.insert(infos);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public int remove(final AdSettingEntity info) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfAdSettingEntity.handle(info) + 0;
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public int removeList(final List<? extends AdSettingEntity> infos) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandleMultiple = this.__deletionAdapterOfAdSettingEntity.handleMultiple(infos) + 0;
            this.__db.setTransactionSuccessful();
            return iHandleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public int modify(final AdSettingEntity info) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfAdSettingEntity.handle(info) + 0;
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public int modifyList(final List<? extends AdSettingEntity> infos) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandleMultiple = this.__updateAdapterOfAdSettingEntity.handleMultiple(infos) + 0;
            this.__db.setTransactionSuccessful();
            return iHandleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.AdSettingDao
    public List<AdSettingEntity> all() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i;
        String string;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM AdSettingEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "key");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "psign");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "show");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "freeTime");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rewardDuration");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adType");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "maxShowCount");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "preloadInterval");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "showInterval");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "codeId");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createTime");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updateTime");
            int i2 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                AdSettingEntity adSettingEntity = new AdSettingEntity();
                if (cursorQuery.isNull(columnIndexOrThrow)) {
                    i = columnIndexOrThrow;
                    string = null;
                } else {
                    i = columnIndexOrThrow;
                    string = cursorQuery.getString(columnIndexOrThrow);
                }
                adSettingEntity.setId(string);
                adSettingEntity.setKey(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                adSettingEntity.setName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                adSettingEntity.setPsign(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                adSettingEntity.setShow(cursorQuery.getInt(columnIndexOrThrow5) != 0);
                int i3 = columnIndexOrThrow2;
                int i4 = columnIndexOrThrow3;
                adSettingEntity.setFreeTime(cursorQuery.getLong(columnIndexOrThrow6));
                adSettingEntity.setRewardDuration(cursorQuery.getLong(columnIndexOrThrow7));
                adSettingEntity.setAdType(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                adSettingEntity.setMaxShowCount(cursorQuery.getInt(columnIndexOrThrow9));
                adSettingEntity.setPreloadInterval(cursorQuery.getLong(columnIndexOrThrow10));
                adSettingEntity.setShowInterval(cursorQuery.getLong(columnIndexOrThrow11));
                adSettingEntity.setCodeId(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                adSettingEntity.setDescription(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                int i5 = i2;
                int i6 = columnIndexOrThrow4;
                adSettingEntity.setCreateTime(cursorQuery.getLong(i5));
                int i7 = columnIndexOrThrow15;
                int i8 = columnIndexOrThrow5;
                adSettingEntity.setUpdateTime(cursorQuery.getLong(i7));
                arrayList.add(adSettingEntity);
                columnIndexOrThrow5 = i8;
                columnIndexOrThrow4 = i6;
                i2 = i5;
                columnIndexOrThrow15 = i7;
                columnIndexOrThrow3 = i4;
                columnIndexOrThrow2 = i3;
                columnIndexOrThrow = i;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
