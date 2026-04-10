package com.funny.audio.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.funny.audio.database.entities.PlayHistoryEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class PlayHistoryDao_Impl implements PlayHistoryDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<PlayHistoryEntity> __deletionAdapterOfPlayHistoryEntity;
    private final EntityInsertionAdapter<PlayHistoryEntity> __insertionAdapterOfPlayHistoryEntity;
    private final SharedSQLiteStatement __preparedStmtOfRemove;
    private final EntityDeletionOrUpdateAdapter<PlayHistoryEntity> __updateAdapterOfPlayHistoryEntity;

    public PlayHistoryDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfPlayHistoryEntity = new EntityInsertionAdapter<PlayHistoryEntity>(__db) { // from class: com.funny.audio.database.dao.PlayHistoryDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `PlayHistoryEntity` (`albumId`,`title`,`announcer`,`announcerId`,`categoryId`,`category`,`tagId`,`tag`,`coverPath`,`finishStatus`,`trackCount`,`trackIndex`,`lastTrackId`,`lastTrackTitle`,`lastUpdateTime`,`time`,`lastSyncTime`,`dataState`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final PlayHistoryEntity entity) {
                if (entity.getAlbumId() == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, entity.getAlbumId());
                }
                if (entity.getTitle() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getTitle());
                }
                if (entity.getAnnouncer() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getAnnouncer());
                }
                if (entity.getAnnouncerId() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getAnnouncerId());
                }
                if (entity.getCategoryId() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getCategoryId());
                }
                if (entity.getCategory() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getCategory());
                }
                if (entity.getTagId() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getTagId());
                }
                if (entity.getTag() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getTag());
                }
                if (entity.getCoverPath() == null) {
                    statement.bindNull(9);
                } else {
                    statement.bindString(9, entity.getCoverPath());
                }
                statement.bindLong(10, entity.getFinishStatus());
                statement.bindLong(11, entity.getTrackCount());
                statement.bindLong(12, entity.getTrackIndex());
                if (entity.getLastTrackId() == null) {
                    statement.bindNull(13);
                } else {
                    statement.bindString(13, entity.getLastTrackId());
                }
                if (entity.getLastTrackTitle() == null) {
                    statement.bindNull(14);
                } else {
                    statement.bindString(14, entity.getLastTrackTitle());
                }
                statement.bindLong(15, entity.getLastUpdateTime());
                statement.bindLong(16, entity.getTime());
                statement.bindLong(17, entity.getLastSyncTime());
                statement.bindLong(18, entity.getDataState());
            }
        };
        this.__deletionAdapterOfPlayHistoryEntity = new EntityDeletionOrUpdateAdapter<PlayHistoryEntity>(__db) { // from class: com.funny.audio.database.dao.PlayHistoryDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `PlayHistoryEntity` WHERE `albumId` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final PlayHistoryEntity entity) {
                if (entity.getAlbumId() == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, entity.getAlbumId());
                }
            }
        };
        this.__updateAdapterOfPlayHistoryEntity = new EntityDeletionOrUpdateAdapter<PlayHistoryEntity>(__db) { // from class: com.funny.audio.database.dao.PlayHistoryDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `PlayHistoryEntity` SET `albumId` = ?,`title` = ?,`announcer` = ?,`announcerId` = ?,`categoryId` = ?,`category` = ?,`tagId` = ?,`tag` = ?,`coverPath` = ?,`finishStatus` = ?,`trackCount` = ?,`trackIndex` = ?,`lastTrackId` = ?,`lastTrackTitle` = ?,`lastUpdateTime` = ?,`time` = ?,`lastSyncTime` = ?,`dataState` = ? WHERE `albumId` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final PlayHistoryEntity entity) {
                if (entity.getAlbumId() == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, entity.getAlbumId());
                }
                if (entity.getTitle() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getTitle());
                }
                if (entity.getAnnouncer() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getAnnouncer());
                }
                if (entity.getAnnouncerId() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getAnnouncerId());
                }
                if (entity.getCategoryId() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getCategoryId());
                }
                if (entity.getCategory() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getCategory());
                }
                if (entity.getTagId() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getTagId());
                }
                if (entity.getTag() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getTag());
                }
                if (entity.getCoverPath() == null) {
                    statement.bindNull(9);
                } else {
                    statement.bindString(9, entity.getCoverPath());
                }
                statement.bindLong(10, entity.getFinishStatus());
                statement.bindLong(11, entity.getTrackCount());
                statement.bindLong(12, entity.getTrackIndex());
                if (entity.getLastTrackId() == null) {
                    statement.bindNull(13);
                } else {
                    statement.bindString(13, entity.getLastTrackId());
                }
                if (entity.getLastTrackTitle() == null) {
                    statement.bindNull(14);
                } else {
                    statement.bindString(14, entity.getLastTrackTitle());
                }
                statement.bindLong(15, entity.getLastUpdateTime());
                statement.bindLong(16, entity.getTime());
                statement.bindLong(17, entity.getLastSyncTime());
                statement.bindLong(18, entity.getDataState());
                if (entity.getAlbumId() == null) {
                    statement.bindNull(19);
                } else {
                    statement.bindString(19, entity.getAlbumId());
                }
            }
        };
        this.__preparedStmtOfRemove = new SharedSQLiteStatement(__db) { // from class: com.funny.audio.database.dao.PlayHistoryDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM PlayHistoryEntity WHERE albumId = ?";
            }
        };
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public long add(final PlayHistoryEntity info) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfPlayHistoryEntity.insertAndReturnId(info);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public void addList(final List<? extends PlayHistoryEntity> infos) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfPlayHistoryEntity.insert(infos);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public int remove(final PlayHistoryEntity info) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfPlayHistoryEntity.handle(info) + 0;
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public int removeList(final List<? extends PlayHistoryEntity> infos) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandleMultiple = this.__deletionAdapterOfPlayHistoryEntity.handleMultiple(infos) + 0;
            this.__db.setTransactionSuccessful();
            return iHandleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public int modify(final PlayHistoryEntity info) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfPlayHistoryEntity.handle(info) + 0;
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public int modifyList(final List<? extends PlayHistoryEntity> infos) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandleMultiple = this.__updateAdapterOfPlayHistoryEntity.handleMultiple(infos) + 0;
            this.__db.setTransactionSuccessful();
            return iHandleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.PlayHistoryDao
    public void remove(final String albumId) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfRemove.acquire();
        if (albumId == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, albumId);
        }
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfRemove.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.funny.audio.database.dao.PlayHistoryDao
    public PlayHistoryEntity album(final String albumId) throws Throwable {
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
        PlayHistoryEntity playHistoryEntity;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlayHistoryEntity WHERE albumId=? AND dataState = 0", 1);
        if (albumId == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, albumId);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "albumId");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "announcer");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "announcerId");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categoryId");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "category");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tagId");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tag");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverPath");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "finishStatus");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackCount");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackIndex");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastTrackId");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastTrackTitle");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUpdateTime");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastSyncTime");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dataState");
            if (cursorQuery.moveToFirst()) {
                PlayHistoryEntity playHistoryEntity2 = new PlayHistoryEntity();
                playHistoryEntity2.setAlbumId(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                playHistoryEntity2.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                playHistoryEntity2.setAnnouncer(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                playHistoryEntity2.setAnnouncerId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                playHistoryEntity2.setCategoryId(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                playHistoryEntity2.setCategory(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                playHistoryEntity2.setTagId(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                playHistoryEntity2.setTag(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                playHistoryEntity2.setCoverPath(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                playHistoryEntity2.setFinishStatus(cursorQuery.getInt(columnIndexOrThrow10));
                playHistoryEntity2.setTrackCount(cursorQuery.getInt(columnIndexOrThrow11));
                playHistoryEntity2.setTrackIndex(cursorQuery.getInt(columnIndexOrThrow12));
                playHistoryEntity2.setLastTrackId(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                playHistoryEntity2.setLastTrackTitle(cursorQuery.isNull(columnIndexOrThrow14) ? null : cursorQuery.getString(columnIndexOrThrow14));
                playHistoryEntity2.setLastUpdateTime(cursorQuery.getLong(columnIndexOrThrow15));
                playHistoryEntity2.setTime(cursorQuery.getLong(columnIndexOrThrow16));
                playHistoryEntity2.setLastSyncTime(cursorQuery.getLong(columnIndexOrThrow17));
                playHistoryEntity2.setDataState(cursorQuery.getInt(columnIndexOrThrow18));
                playHistoryEntity = playHistoryEntity2;
            } else {
                playHistoryEntity = null;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return playHistoryEntity;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // com.funny.audio.database.dao.PlayHistoryDao
    public PlayHistoryEntity latest() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        PlayHistoryEntity playHistoryEntity;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlayHistoryEntity WHERE dataState = 0 ORDER BY time DESC LIMIT 1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "albumId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "announcer");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "announcerId");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categoryId");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "category");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tagId");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tag");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverPath");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "finishStatus");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackCount");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackIndex");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastTrackId");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastTrackTitle");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUpdateTime");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastSyncTime");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dataState");
                if (cursorQuery.moveToFirst()) {
                    PlayHistoryEntity playHistoryEntity2 = new PlayHistoryEntity();
                    playHistoryEntity2.setAlbumId(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                    playHistoryEntity2.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    playHistoryEntity2.setAnnouncer(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    playHistoryEntity2.setAnnouncerId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    playHistoryEntity2.setCategoryId(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    playHistoryEntity2.setCategory(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    playHistoryEntity2.setTagId(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    playHistoryEntity2.setTag(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    playHistoryEntity2.setCoverPath(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    playHistoryEntity2.setFinishStatus(cursorQuery.getInt(columnIndexOrThrow10));
                    playHistoryEntity2.setTrackCount(cursorQuery.getInt(columnIndexOrThrow11));
                    playHistoryEntity2.setTrackIndex(cursorQuery.getInt(columnIndexOrThrow12));
                    playHistoryEntity2.setLastTrackId(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    playHistoryEntity2.setLastTrackTitle(cursorQuery.isNull(columnIndexOrThrow14) ? null : cursorQuery.getString(columnIndexOrThrow14));
                    playHistoryEntity2.setLastUpdateTime(cursorQuery.getLong(columnIndexOrThrow15));
                    playHistoryEntity2.setTime(cursorQuery.getLong(columnIndexOrThrow16));
                    playHistoryEntity2.setLastSyncTime(cursorQuery.getLong(columnIndexOrThrow17));
                    playHistoryEntity2.setDataState(cursorQuery.getInt(columnIndexOrThrow18));
                    playHistoryEntity = playHistoryEntity2;
                } else {
                    playHistoryEntity = null;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return playHistoryEntity;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.funny.audio.database.dao.PlayHistoryDao
    public List<PlayHistoryEntity> pageByAll(final int page, final int pageSize) throws Throwable {
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
        int i2;
        String string2;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlayHistoryEntity WHERE dataState = 0 ORDER BY time DESC LIMIT ? OFFSET (? - 1) * ?", 3);
        long j = pageSize;
        roomSQLiteQueryAcquire.bindLong(1, j);
        roomSQLiteQueryAcquire.bindLong(2, page);
        roomSQLiteQueryAcquire.bindLong(3, j);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "albumId");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "announcer");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "announcerId");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categoryId");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "category");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tagId");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tag");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverPath");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "finishStatus");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackCount");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackIndex");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastTrackId");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastTrackTitle");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUpdateTime");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastSyncTime");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dataState");
            int i3 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                PlayHistoryEntity playHistoryEntity = new PlayHistoryEntity();
                if (cursorQuery.isNull(columnIndexOrThrow)) {
                    i = columnIndexOrThrow;
                    string = null;
                } else {
                    i = columnIndexOrThrow;
                    string = cursorQuery.getString(columnIndexOrThrow);
                }
                playHistoryEntity.setAlbumId(string);
                playHistoryEntity.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                playHistoryEntity.setAnnouncer(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                playHistoryEntity.setAnnouncerId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                playHistoryEntity.setCategoryId(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                playHistoryEntity.setCategory(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                playHistoryEntity.setTagId(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                playHistoryEntity.setTag(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                playHistoryEntity.setCoverPath(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                playHistoryEntity.setFinishStatus(cursorQuery.getInt(columnIndexOrThrow10));
                playHistoryEntity.setTrackCount(cursorQuery.getInt(columnIndexOrThrow11));
                playHistoryEntity.setTrackIndex(cursorQuery.getInt(columnIndexOrThrow12));
                playHistoryEntity.setLastTrackId(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                int i4 = i3;
                if (cursorQuery.isNull(i4)) {
                    i2 = i4;
                    string2 = null;
                } else {
                    i2 = i4;
                    string2 = cursorQuery.getString(i4);
                }
                playHistoryEntity.setLastTrackTitle(string2);
                int i5 = columnIndexOrThrow15;
                int i6 = columnIndexOrThrow13;
                int i7 = columnIndexOrThrow2;
                playHistoryEntity.setLastUpdateTime(cursorQuery.getLong(i5));
                int i8 = columnIndexOrThrow16;
                int i9 = columnIndexOrThrow3;
                playHistoryEntity.setTime(cursorQuery.getLong(i8));
                int i10 = columnIndexOrThrow17;
                int i11 = columnIndexOrThrow4;
                playHistoryEntity.setLastSyncTime(cursorQuery.getLong(i10));
                int i12 = columnIndexOrThrow18;
                playHistoryEntity.setDataState(cursorQuery.getInt(i12));
                arrayList.add(playHistoryEntity);
                columnIndexOrThrow18 = i12;
                columnIndexOrThrow3 = i9;
                columnIndexOrThrow4 = i11;
                columnIndexOrThrow16 = i8;
                columnIndexOrThrow17 = i10;
                columnIndexOrThrow13 = i6;
                i3 = i2;
                columnIndexOrThrow2 = i7;
                columnIndexOrThrow15 = i5;
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

    @Override // com.funny.audio.database.dao.PlayHistoryDao
    public List<PlayHistoryEntity> pageByTimeBefore(final long time, final int page, final int pageSize) throws Throwable {
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
        int i2;
        String string2;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlayHistoryEntity WHERE time < ? AND dataState = 0 ORDER BY time DESC LIMIT ? OFFSET (? - 1) * ?", 4);
        roomSQLiteQueryAcquire.bindLong(1, time);
        long j = pageSize;
        roomSQLiteQueryAcquire.bindLong(2, j);
        roomSQLiteQueryAcquire.bindLong(3, page);
        roomSQLiteQueryAcquire.bindLong(4, j);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "albumId");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "announcer");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "announcerId");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categoryId");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "category");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tagId");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tag");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverPath");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "finishStatus");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackCount");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackIndex");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastTrackId");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastTrackTitle");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUpdateTime");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastSyncTime");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dataState");
            int i3 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                PlayHistoryEntity playHistoryEntity = new PlayHistoryEntity();
                if (cursorQuery.isNull(columnIndexOrThrow)) {
                    i = columnIndexOrThrow;
                    string = null;
                } else {
                    i = columnIndexOrThrow;
                    string = cursorQuery.getString(columnIndexOrThrow);
                }
                playHistoryEntity.setAlbumId(string);
                playHistoryEntity.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                playHistoryEntity.setAnnouncer(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                playHistoryEntity.setAnnouncerId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                playHistoryEntity.setCategoryId(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                playHistoryEntity.setCategory(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                playHistoryEntity.setTagId(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                playHistoryEntity.setTag(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                playHistoryEntity.setCoverPath(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                playHistoryEntity.setFinishStatus(cursorQuery.getInt(columnIndexOrThrow10));
                playHistoryEntity.setTrackCount(cursorQuery.getInt(columnIndexOrThrow11));
                playHistoryEntity.setTrackIndex(cursorQuery.getInt(columnIndexOrThrow12));
                playHistoryEntity.setLastTrackId(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                int i4 = i3;
                if (cursorQuery.isNull(i4)) {
                    i2 = i4;
                    string2 = null;
                } else {
                    i2 = i4;
                    string2 = cursorQuery.getString(i4);
                }
                playHistoryEntity.setLastTrackTitle(string2);
                int i5 = columnIndexOrThrow15;
                int i6 = columnIndexOrThrow13;
                int i7 = columnIndexOrThrow2;
                playHistoryEntity.setLastUpdateTime(cursorQuery.getLong(i5));
                int i8 = columnIndexOrThrow16;
                int i9 = columnIndexOrThrow3;
                playHistoryEntity.setTime(cursorQuery.getLong(i8));
                int i10 = columnIndexOrThrow17;
                int i11 = columnIndexOrThrow4;
                playHistoryEntity.setLastSyncTime(cursorQuery.getLong(i10));
                int i12 = columnIndexOrThrow18;
                playHistoryEntity.setDataState(cursorQuery.getInt(i12));
                arrayList.add(playHistoryEntity);
                columnIndexOrThrow4 = i11;
                columnIndexOrThrow17 = i10;
                columnIndexOrThrow18 = i12;
                columnIndexOrThrow2 = i7;
                columnIndexOrThrow3 = i9;
                columnIndexOrThrow15 = i5;
                columnIndexOrThrow16 = i8;
                columnIndexOrThrow13 = i6;
                i3 = i2;
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

    @Override // com.funny.audio.database.dao.PlayHistoryDao
    public List<PlayHistoryEntity> pageByTimeFilter(final long startTime, final long endTime, final int page, final int pageSize) throws Throwable {
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
        String string2;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlayHistoryEntity WHERE time >= ? AND time < ? AND dataState = 0 ORDER BY time DESC LIMIT ? OFFSET (? - 1) * ?", 5);
        roomSQLiteQueryAcquire.bindLong(1, startTime);
        roomSQLiteQueryAcquire.bindLong(2, endTime);
        long j = pageSize;
        roomSQLiteQueryAcquire.bindLong(3, j);
        roomSQLiteQueryAcquire.bindLong(4, page);
        roomSQLiteQueryAcquire.bindLong(5, j);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "albumId");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "announcer");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "announcerId");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categoryId");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "category");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tagId");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tag");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverPath");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "finishStatus");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackCount");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackIndex");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastTrackId");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastTrackTitle");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUpdateTime");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastSyncTime");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dataState");
            int i2 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                PlayHistoryEntity playHistoryEntity = new PlayHistoryEntity();
                if (cursorQuery.isNull(columnIndexOrThrow)) {
                    i = columnIndexOrThrow;
                    string = null;
                } else {
                    i = columnIndexOrThrow;
                    string = cursorQuery.getString(columnIndexOrThrow);
                }
                playHistoryEntity.setAlbumId(string);
                playHistoryEntity.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                playHistoryEntity.setAnnouncer(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                playHistoryEntity.setAnnouncerId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                playHistoryEntity.setCategoryId(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                playHistoryEntity.setCategory(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                playHistoryEntity.setTagId(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                playHistoryEntity.setTag(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                playHistoryEntity.setCoverPath(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                playHistoryEntity.setFinishStatus(cursorQuery.getInt(columnIndexOrThrow10));
                playHistoryEntity.setTrackCount(cursorQuery.getInt(columnIndexOrThrow11));
                playHistoryEntity.setTrackIndex(cursorQuery.getInt(columnIndexOrThrow12));
                playHistoryEntity.setLastTrackId(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                int i3 = i2;
                if (cursorQuery.isNull(i3)) {
                    i2 = i3;
                    string2 = null;
                } else {
                    i2 = i3;
                    string2 = cursorQuery.getString(i3);
                }
                playHistoryEntity.setLastTrackTitle(string2);
                int i4 = columnIndexOrThrow15;
                int i5 = columnIndexOrThrow13;
                int i6 = columnIndexOrThrow2;
                playHistoryEntity.setLastUpdateTime(cursorQuery.getLong(i4));
                int i7 = columnIndexOrThrow16;
                int i8 = columnIndexOrThrow3;
                playHistoryEntity.setTime(cursorQuery.getLong(i7));
                int i9 = columnIndexOrThrow17;
                int i10 = columnIndexOrThrow4;
                playHistoryEntity.setLastSyncTime(cursorQuery.getLong(i9));
                int i11 = columnIndexOrThrow18;
                playHistoryEntity.setDataState(cursorQuery.getInt(i11));
                arrayList.add(playHistoryEntity);
                columnIndexOrThrow4 = i10;
                columnIndexOrThrow17 = i9;
                columnIndexOrThrow18 = i11;
                columnIndexOrThrow2 = i6;
                columnIndexOrThrow3 = i8;
                columnIndexOrThrow15 = i4;
                columnIndexOrThrow16 = i7;
                columnIndexOrThrow13 = i5;
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

    @Override // com.funny.audio.database.dao.PlayHistoryDao
    public List<PlayHistoryEntity> listByNeedSync(final int size) throws Throwable {
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
        int i2;
        String string2;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlayHistoryEntity WHERE time != lastSyncTime ORDER BY time DESC LIMIT ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, size);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "albumId");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "announcer");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "announcerId");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categoryId");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "category");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tagId");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tag");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverPath");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "finishStatus");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackCount");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackIndex");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastTrackId");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastTrackTitle");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUpdateTime");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastSyncTime");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dataState");
            int i3 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                PlayHistoryEntity playHistoryEntity = new PlayHistoryEntity();
                if (cursorQuery.isNull(columnIndexOrThrow)) {
                    i = columnIndexOrThrow;
                    string = null;
                } else {
                    i = columnIndexOrThrow;
                    string = cursorQuery.getString(columnIndexOrThrow);
                }
                playHistoryEntity.setAlbumId(string);
                playHistoryEntity.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                playHistoryEntity.setAnnouncer(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                playHistoryEntity.setAnnouncerId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                playHistoryEntity.setCategoryId(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                playHistoryEntity.setCategory(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                playHistoryEntity.setTagId(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                playHistoryEntity.setTag(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                playHistoryEntity.setCoverPath(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                playHistoryEntity.setFinishStatus(cursorQuery.getInt(columnIndexOrThrow10));
                playHistoryEntity.setTrackCount(cursorQuery.getInt(columnIndexOrThrow11));
                playHistoryEntity.setTrackIndex(cursorQuery.getInt(columnIndexOrThrow12));
                playHistoryEntity.setLastTrackId(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                int i4 = i3;
                if (cursorQuery.isNull(i4)) {
                    i2 = i4;
                    string2 = null;
                } else {
                    i2 = i4;
                    string2 = cursorQuery.getString(i4);
                }
                playHistoryEntity.setLastTrackTitle(string2);
                int i5 = columnIndexOrThrow13;
                int i6 = columnIndexOrThrow15;
                int i7 = columnIndexOrThrow2;
                playHistoryEntity.setLastUpdateTime(cursorQuery.getLong(i6));
                int i8 = columnIndexOrThrow16;
                int i9 = columnIndexOrThrow3;
                playHistoryEntity.setTime(cursorQuery.getLong(i8));
                int i10 = columnIndexOrThrow17;
                int i11 = columnIndexOrThrow4;
                playHistoryEntity.setLastSyncTime(cursorQuery.getLong(i10));
                int i12 = columnIndexOrThrow18;
                playHistoryEntity.setDataState(cursorQuery.getInt(i12));
                arrayList.add(playHistoryEntity);
                columnIndexOrThrow18 = i12;
                columnIndexOrThrow3 = i9;
                columnIndexOrThrow4 = i11;
                columnIndexOrThrow16 = i8;
                columnIndexOrThrow17 = i10;
                columnIndexOrThrow2 = i7;
                columnIndexOrThrow13 = i5;
                i3 = i2;
                columnIndexOrThrow15 = i6;
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
