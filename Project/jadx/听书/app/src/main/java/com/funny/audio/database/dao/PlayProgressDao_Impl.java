package com.funny.audio.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.funny.audio.database.entities.PlayProgressEntity;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class PlayProgressDao_Impl implements PlayProgressDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<PlayProgressEntity> __deletionAdapterOfPlayProgressEntity;
    private final EntityInsertionAdapter<PlayProgressEntity> __insertionAdapterOfPlayProgressEntity;
    private final EntityDeletionOrUpdateAdapter<PlayProgressEntity> __updateAdapterOfPlayProgressEntity;

    public PlayProgressDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfPlayProgressEntity = new EntityInsertionAdapter<PlayProgressEntity>(__db) { // from class: com.funny.audio.database.dao.PlayProgressDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `PlayProgressEntity` (`albumId`,`trackId`,`trackIndex`,`totalDuration`,`duration`,`time`) VALUES (?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final PlayProgressEntity entity) {
                if (entity.getAlbumId() == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, entity.getAlbumId());
                }
                if (entity.getTrackId() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getTrackId());
                }
                statement.bindLong(3, entity.getTrackIndex());
                statement.bindLong(4, entity.getTotalDuration());
                statement.bindLong(5, entity.getDuration());
                statement.bindLong(6, entity.getTime());
            }
        };
        this.__deletionAdapterOfPlayProgressEntity = new EntityDeletionOrUpdateAdapter<PlayProgressEntity>(__db) { // from class: com.funny.audio.database.dao.PlayProgressDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `PlayProgressEntity` WHERE `albumId` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final PlayProgressEntity entity) {
                if (entity.getAlbumId() == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, entity.getAlbumId());
                }
            }
        };
        this.__updateAdapterOfPlayProgressEntity = new EntityDeletionOrUpdateAdapter<PlayProgressEntity>(__db) { // from class: com.funny.audio.database.dao.PlayProgressDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `PlayProgressEntity` SET `albumId` = ?,`trackId` = ?,`trackIndex` = ?,`totalDuration` = ?,`duration` = ?,`time` = ? WHERE `albumId` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final PlayProgressEntity entity) {
                if (entity.getAlbumId() == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, entity.getAlbumId());
                }
                if (entity.getTrackId() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getTrackId());
                }
                statement.bindLong(3, entity.getTrackIndex());
                statement.bindLong(4, entity.getTotalDuration());
                statement.bindLong(5, entity.getDuration());
                statement.bindLong(6, entity.getTime());
                if (entity.getAlbumId() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getAlbumId());
                }
            }
        };
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public long add(final PlayProgressEntity info) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfPlayProgressEntity.insertAndReturnId(info);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public void addList(final List<? extends PlayProgressEntity> infos) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfPlayProgressEntity.insert(infos);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public int remove(final PlayProgressEntity info) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfPlayProgressEntity.handle(info) + 0;
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public int removeList(final List<? extends PlayProgressEntity> infos) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandleMultiple = this.__deletionAdapterOfPlayProgressEntity.handleMultiple(infos) + 0;
            this.__db.setTransactionSuccessful();
            return iHandleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public int modify(final PlayProgressEntity info) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfPlayProgressEntity.handle(info) + 0;
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public int modifyList(final List<? extends PlayProgressEntity> infos) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandleMultiple = this.__updateAdapterOfPlayProgressEntity.handleMultiple(infos) + 0;
            this.__db.setTransactionSuccessful();
            return iHandleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.PlayProgressDao
    public PlayProgressEntity latest(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlayProgressEntity WHERE albumId=? ORDER BY time DESC LIMIT 1", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        PlayProgressEntity playProgressEntity = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "albumId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackIndex");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "totalDuration");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "duration");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
            if (cursorQuery.moveToFirst()) {
                PlayProgressEntity playProgressEntity2 = new PlayProgressEntity();
                playProgressEntity2.setAlbumId(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                if (!cursorQuery.isNull(columnIndexOrThrow2)) {
                    string = cursorQuery.getString(columnIndexOrThrow2);
                }
                playProgressEntity2.setTrackId(string);
                playProgressEntity2.setTrackIndex(cursorQuery.getInt(columnIndexOrThrow3));
                playProgressEntity2.setTotalDuration(cursorQuery.getLong(columnIndexOrThrow4));
                playProgressEntity2.setDuration(cursorQuery.getLong(columnIndexOrThrow5));
                playProgressEntity2.setTime(cursorQuery.getLong(columnIndexOrThrow6));
                playProgressEntity = playProgressEntity2;
            }
            return playProgressEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.funny.audio.database.dao.PlayProgressDao
    public PlayProgressEntity latest(String str, String str2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlayProgressEntity WHERE albumId=? AND trackId=? ORDER BY time DESC LIMIT 1", 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        if (str2 == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str2);
        }
        this.__db.assertNotSuspendingTransaction();
        PlayProgressEntity playProgressEntity = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "albumId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackIndex");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "totalDuration");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "duration");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
            if (cursorQuery.moveToFirst()) {
                PlayProgressEntity playProgressEntity2 = new PlayProgressEntity();
                playProgressEntity2.setAlbumId(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                if (!cursorQuery.isNull(columnIndexOrThrow2)) {
                    string = cursorQuery.getString(columnIndexOrThrow2);
                }
                playProgressEntity2.setTrackId(string);
                playProgressEntity2.setTrackIndex(cursorQuery.getInt(columnIndexOrThrow3));
                playProgressEntity2.setTotalDuration(cursorQuery.getLong(columnIndexOrThrow4));
                playProgressEntity2.setDuration(cursorQuery.getLong(columnIndexOrThrow5));
                playProgressEntity2.setTime(cursorQuery.getLong(columnIndexOrThrow6));
                playProgressEntity = playProgressEntity2;
            }
            return playProgressEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
