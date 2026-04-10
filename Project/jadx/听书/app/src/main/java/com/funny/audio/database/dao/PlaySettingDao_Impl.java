package com.funny.audio.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.funny.audio.database.entities.PlaySettingEntity;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class PlaySettingDao_Impl implements PlaySettingDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<PlaySettingEntity> __deletionAdapterOfPlaySettingEntity;
    private final EntityInsertionAdapter<PlaySettingEntity> __insertionAdapterOfPlaySettingEntity;
    private final EntityDeletionOrUpdateAdapter<PlaySettingEntity> __updateAdapterOfPlaySettingEntity;

    public PlaySettingDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfPlaySettingEntity = new EntityInsertionAdapter<PlaySettingEntity>(__db) { // from class: com.funny.audio.database.dao.PlaySettingDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `PlaySettingEntity` (`albumId`,`value`,`time`) VALUES (?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final PlaySettingEntity entity) {
                if (entity.getAlbumId() == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, entity.getAlbumId());
                }
                if (entity.getValue() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getValue());
                }
                statement.bindLong(3, entity.getTime());
            }
        };
        this.__deletionAdapterOfPlaySettingEntity = new EntityDeletionOrUpdateAdapter<PlaySettingEntity>(__db) { // from class: com.funny.audio.database.dao.PlaySettingDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `PlaySettingEntity` WHERE `albumId` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final PlaySettingEntity entity) {
                if (entity.getAlbumId() == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, entity.getAlbumId());
                }
            }
        };
        this.__updateAdapterOfPlaySettingEntity = new EntityDeletionOrUpdateAdapter<PlaySettingEntity>(__db) { // from class: com.funny.audio.database.dao.PlaySettingDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `PlaySettingEntity` SET `albumId` = ?,`value` = ?,`time` = ? WHERE `albumId` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final PlaySettingEntity entity) {
                if (entity.getAlbumId() == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, entity.getAlbumId());
                }
                if (entity.getValue() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getValue());
                }
                statement.bindLong(3, entity.getTime());
                if (entity.getAlbumId() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getAlbumId());
                }
            }
        };
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public long add(final PlaySettingEntity info) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfPlaySettingEntity.insertAndReturnId(info);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public void addList(final List<? extends PlaySettingEntity> infos) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfPlaySettingEntity.insert(infos);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public int remove(final PlaySettingEntity info) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfPlaySettingEntity.handle(info) + 0;
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public int removeList(final List<? extends PlaySettingEntity> infos) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandleMultiple = this.__deletionAdapterOfPlaySettingEntity.handleMultiple(infos) + 0;
            this.__db.setTransactionSuccessful();
            return iHandleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public int modify(final PlaySettingEntity info) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfPlaySettingEntity.handle(info) + 0;
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public int modifyList(final List<? extends PlaySettingEntity> infos) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandleMultiple = this.__updateAdapterOfPlaySettingEntity.handleMultiple(infos) + 0;
            this.__db.setTransactionSuccessful();
            return iHandleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.PlaySettingDao
    public PlaySettingEntity album(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlaySettingEntity WHERE albumId=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        PlaySettingEntity playSettingEntity = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "albumId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "value");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
            if (cursorQuery.moveToFirst()) {
                PlaySettingEntity playSettingEntity2 = new PlaySettingEntity();
                playSettingEntity2.setAlbumId(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                if (!cursorQuery.isNull(columnIndexOrThrow2)) {
                    string = cursorQuery.getString(columnIndexOrThrow2);
                }
                playSettingEntity2.setValue(string);
                playSettingEntity2.setTime(cursorQuery.getLong(columnIndexOrThrow3));
                playSettingEntity = playSettingEntity2;
            }
            return playSettingEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
