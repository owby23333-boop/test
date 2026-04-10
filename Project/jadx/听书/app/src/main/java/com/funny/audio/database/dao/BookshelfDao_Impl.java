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
import com.funny.audio.database.entities.BookshelfEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class BookshelfDao_Impl implements BookshelfDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<BookshelfEntity> __deletionAdapterOfBookshelfEntity;
    private final EntityInsertionAdapter<BookshelfEntity> __insertionAdapterOfBookshelfEntity;
    private final SharedSQLiteStatement __preparedStmtOfRemove;
    private final EntityDeletionOrUpdateAdapter<BookshelfEntity> __updateAdapterOfBookshelfEntity;

    public BookshelfDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfBookshelfEntity = new EntityInsertionAdapter<BookshelfEntity>(__db) { // from class: com.funny.audio.database.dao.BookshelfDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `BookshelfEntity` (`albumId`,`title`,`announcer`,`announcerId`,`categoryId`,`category`,`coverPath`,`finishStatus`,`trackCount`,`trackIndex`,`latestTrackId`,`latestTrackTitle`,`lastUpdateTime`,`lastReadTime`,`lastSyncTime`,`dataState`,`collectTime`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final BookshelfEntity entity) {
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
                if (entity.getCoverPath() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getCoverPath());
                }
                statement.bindLong(8, entity.getFinishStatus());
                statement.bindLong(9, entity.getTrackCount());
                statement.bindLong(10, entity.getTrackIndex());
                if (entity.getLatestTrackId() == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindString(11, entity.getLatestTrackId());
                }
                if (entity.getLatestTrackTitle() == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindString(12, entity.getLatestTrackTitle());
                }
                statement.bindLong(13, entity.getLastUpdateTime());
                statement.bindLong(14, entity.getLastReadTime());
                statement.bindLong(15, entity.getLastSyncTime());
                statement.bindLong(16, entity.getDataState());
                statement.bindLong(17, entity.getCollectTime());
            }
        };
        this.__deletionAdapterOfBookshelfEntity = new EntityDeletionOrUpdateAdapter<BookshelfEntity>(__db) { // from class: com.funny.audio.database.dao.BookshelfDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `BookshelfEntity` WHERE `albumId` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final BookshelfEntity entity) {
                if (entity.getAlbumId() == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, entity.getAlbumId());
                }
            }
        };
        this.__updateAdapterOfBookshelfEntity = new EntityDeletionOrUpdateAdapter<BookshelfEntity>(__db) { // from class: com.funny.audio.database.dao.BookshelfDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `BookshelfEntity` SET `albumId` = ?,`title` = ?,`announcer` = ?,`announcerId` = ?,`categoryId` = ?,`category` = ?,`coverPath` = ?,`finishStatus` = ?,`trackCount` = ?,`trackIndex` = ?,`latestTrackId` = ?,`latestTrackTitle` = ?,`lastUpdateTime` = ?,`lastReadTime` = ?,`lastSyncTime` = ?,`dataState` = ?,`collectTime` = ? WHERE `albumId` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final BookshelfEntity entity) {
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
                if (entity.getCoverPath() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getCoverPath());
                }
                statement.bindLong(8, entity.getFinishStatus());
                statement.bindLong(9, entity.getTrackCount());
                statement.bindLong(10, entity.getTrackIndex());
                if (entity.getLatestTrackId() == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindString(11, entity.getLatestTrackId());
                }
                if (entity.getLatestTrackTitle() == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindString(12, entity.getLatestTrackTitle());
                }
                statement.bindLong(13, entity.getLastUpdateTime());
                statement.bindLong(14, entity.getLastReadTime());
                statement.bindLong(15, entity.getLastSyncTime());
                statement.bindLong(16, entity.getDataState());
                statement.bindLong(17, entity.getCollectTime());
                if (entity.getAlbumId() == null) {
                    statement.bindNull(18);
                } else {
                    statement.bindString(18, entity.getAlbumId());
                }
            }
        };
        this.__preparedStmtOfRemove = new SharedSQLiteStatement(__db) { // from class: com.funny.audio.database.dao.BookshelfDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE BookshelfEntity SET dataState = -1 WHERE albumId = ?";
            }
        };
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public long add(final BookshelfEntity info) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfBookshelfEntity.insertAndReturnId(info);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public void addList(final List<? extends BookshelfEntity> infos) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfBookshelfEntity.insert(infos);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public int remove(final BookshelfEntity info) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfBookshelfEntity.handle(info) + 0;
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public int removeList(final List<? extends BookshelfEntity> infos) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandleMultiple = this.__deletionAdapterOfBookshelfEntity.handleMultiple(infos) + 0;
            this.__db.setTransactionSuccessful();
            return iHandleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public int modify(final BookshelfEntity info) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfBookshelfEntity.handle(info) + 0;
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public int modifyList(final List<? extends BookshelfEntity> infos) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandleMultiple = this.__updateAdapterOfBookshelfEntity.handleMultiple(infos) + 0;
            this.__db.setTransactionSuccessful();
            return iHandleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BookshelfDao
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

    @Override // com.funny.audio.database.dao.BookshelfDao
    public BookshelfEntity get(final String albumId) throws Throwable {
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
        BookshelfEntity bookshelfEntity;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM BookshelfEntity WHERE albumId=? AND dataState = 0", 1);
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
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverPath");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "finishStatus");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackCount");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackIndex");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestTrackId");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestTrackTitle");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUpdateTime");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastReadTime");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastSyncTime");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dataState");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "collectTime");
            if (cursorQuery.moveToFirst()) {
                BookshelfEntity bookshelfEntity2 = new BookshelfEntity();
                bookshelfEntity2.setAlbumId(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                bookshelfEntity2.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                bookshelfEntity2.setAnnouncer(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                bookshelfEntity2.setAnnouncerId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                bookshelfEntity2.setCategoryId(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                bookshelfEntity2.setCategory(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                bookshelfEntity2.setCoverPath(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                bookshelfEntity2.setFinishStatus(cursorQuery.getInt(columnIndexOrThrow8));
                bookshelfEntity2.setTrackCount(cursorQuery.getInt(columnIndexOrThrow9));
                bookshelfEntity2.setTrackIndex(cursorQuery.getInt(columnIndexOrThrow10));
                bookshelfEntity2.setLatestTrackId(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                bookshelfEntity2.setLatestTrackTitle(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                bookshelfEntity2.setLastUpdateTime(cursorQuery.getLong(columnIndexOrThrow13));
                bookshelfEntity2.setLastReadTime(cursorQuery.getLong(columnIndexOrThrow14));
                bookshelfEntity2.setLastSyncTime(cursorQuery.getLong(columnIndexOrThrow15));
                bookshelfEntity2.setDataState(cursorQuery.getInt(columnIndexOrThrow16));
                bookshelfEntity2.setCollectTime(cursorQuery.getLong(columnIndexOrThrow17));
                bookshelfEntity = bookshelfEntity2;
            } else {
                bookshelfEntity = null;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return bookshelfEntity;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // com.funny.audio.database.dao.BookshelfDao
    public List<BookshelfEntity> pageByLatestCollect(final int page, final int pageSize) throws Throwable {
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
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM BookshelfEntity WHERE dataState = 0 ORDER BY collectTime DESC LIMIT ? OFFSET (? - 1) * ?", 3);
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
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverPath");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "finishStatus");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackCount");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackIndex");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestTrackId");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestTrackTitle");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUpdateTime");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastReadTime");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastSyncTime");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dataState");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "collectTime");
            int i2 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                BookshelfEntity bookshelfEntity = new BookshelfEntity();
                if (cursorQuery.isNull(columnIndexOrThrow)) {
                    i = columnIndexOrThrow;
                    string = null;
                } else {
                    i = columnIndexOrThrow;
                    string = cursorQuery.getString(columnIndexOrThrow);
                }
                bookshelfEntity.setAlbumId(string);
                bookshelfEntity.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                bookshelfEntity.setAnnouncer(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                bookshelfEntity.setAnnouncerId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                bookshelfEntity.setCategoryId(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                bookshelfEntity.setCategory(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                bookshelfEntity.setCoverPath(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                bookshelfEntity.setFinishStatus(cursorQuery.getInt(columnIndexOrThrow8));
                bookshelfEntity.setTrackCount(cursorQuery.getInt(columnIndexOrThrow9));
                bookshelfEntity.setTrackIndex(cursorQuery.getInt(columnIndexOrThrow10));
                bookshelfEntity.setLatestTrackId(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                bookshelfEntity.setLatestTrackTitle(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                int i3 = columnIndexOrThrow2;
                int i4 = columnIndexOrThrow3;
                bookshelfEntity.setLastUpdateTime(cursorQuery.getLong(columnIndexOrThrow13));
                int i5 = i2;
                int i6 = columnIndexOrThrow4;
                bookshelfEntity.setLastReadTime(cursorQuery.getLong(i5));
                int i7 = columnIndexOrThrow15;
                int i8 = columnIndexOrThrow13;
                bookshelfEntity.setLastSyncTime(cursorQuery.getLong(i7));
                int i9 = columnIndexOrThrow16;
                bookshelfEntity.setDataState(cursorQuery.getInt(i9));
                int i10 = columnIndexOrThrow17;
                bookshelfEntity.setCollectTime(cursorQuery.getLong(i10));
                arrayList.add(bookshelfEntity);
                columnIndexOrThrow4 = i6;
                columnIndexOrThrow3 = i4;
                i2 = i5;
                columnIndexOrThrow17 = i10;
                columnIndexOrThrow2 = i3;
                columnIndexOrThrow = i;
                columnIndexOrThrow13 = i8;
                columnIndexOrThrow15 = i7;
                columnIndexOrThrow16 = i9;
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

    @Override // com.funny.audio.database.dao.BookshelfDao
    public List<BookshelfEntity> pageByLatestRead(final int page, final int pageSize) throws Throwable {
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
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM BookshelfEntity WHERE dataState = 0 ORDER BY lastReadTime DESC LIMIT ? OFFSET (? - 1) * ?", 3);
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
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverPath");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "finishStatus");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackCount");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackIndex");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestTrackId");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestTrackTitle");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUpdateTime");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastReadTime");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastSyncTime");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dataState");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "collectTime");
            int i2 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                BookshelfEntity bookshelfEntity = new BookshelfEntity();
                if (cursorQuery.isNull(columnIndexOrThrow)) {
                    i = columnIndexOrThrow;
                    string = null;
                } else {
                    i = columnIndexOrThrow;
                    string = cursorQuery.getString(columnIndexOrThrow);
                }
                bookshelfEntity.setAlbumId(string);
                bookshelfEntity.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                bookshelfEntity.setAnnouncer(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                bookshelfEntity.setAnnouncerId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                bookshelfEntity.setCategoryId(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                bookshelfEntity.setCategory(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                bookshelfEntity.setCoverPath(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                bookshelfEntity.setFinishStatus(cursorQuery.getInt(columnIndexOrThrow8));
                bookshelfEntity.setTrackCount(cursorQuery.getInt(columnIndexOrThrow9));
                bookshelfEntity.setTrackIndex(cursorQuery.getInt(columnIndexOrThrow10));
                bookshelfEntity.setLatestTrackId(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                bookshelfEntity.setLatestTrackTitle(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                int i3 = columnIndexOrThrow2;
                int i4 = columnIndexOrThrow3;
                bookshelfEntity.setLastUpdateTime(cursorQuery.getLong(columnIndexOrThrow13));
                int i5 = i2;
                int i6 = columnIndexOrThrow4;
                bookshelfEntity.setLastReadTime(cursorQuery.getLong(i5));
                int i7 = columnIndexOrThrow15;
                int i8 = columnIndexOrThrow13;
                bookshelfEntity.setLastSyncTime(cursorQuery.getLong(i7));
                int i9 = columnIndexOrThrow16;
                bookshelfEntity.setDataState(cursorQuery.getInt(i9));
                int i10 = columnIndexOrThrow17;
                bookshelfEntity.setCollectTime(cursorQuery.getLong(i10));
                arrayList.add(bookshelfEntity);
                columnIndexOrThrow4 = i6;
                columnIndexOrThrow3 = i4;
                i2 = i5;
                columnIndexOrThrow17 = i10;
                columnIndexOrThrow2 = i3;
                columnIndexOrThrow = i;
                columnIndexOrThrow13 = i8;
                columnIndexOrThrow15 = i7;
                columnIndexOrThrow16 = i9;
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

    @Override // com.funny.audio.database.dao.BookshelfDao
    public List<BookshelfEntity> pageByLatestUpdate(final int page, final int pageSize) throws Throwable {
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
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM BookshelfEntity WHERE dataState = 0 ORDER BY lastUpdateTime DESC LIMIT ? OFFSET (? - 1) * ?", 3);
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
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverPath");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "finishStatus");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackCount");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackIndex");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestTrackId");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestTrackTitle");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUpdateTime");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastReadTime");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastSyncTime");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dataState");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "collectTime");
            int i2 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                BookshelfEntity bookshelfEntity = new BookshelfEntity();
                if (cursorQuery.isNull(columnIndexOrThrow)) {
                    i = columnIndexOrThrow;
                    string = null;
                } else {
                    i = columnIndexOrThrow;
                    string = cursorQuery.getString(columnIndexOrThrow);
                }
                bookshelfEntity.setAlbumId(string);
                bookshelfEntity.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                bookshelfEntity.setAnnouncer(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                bookshelfEntity.setAnnouncerId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                bookshelfEntity.setCategoryId(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                bookshelfEntity.setCategory(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                bookshelfEntity.setCoverPath(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                bookshelfEntity.setFinishStatus(cursorQuery.getInt(columnIndexOrThrow8));
                bookshelfEntity.setTrackCount(cursorQuery.getInt(columnIndexOrThrow9));
                bookshelfEntity.setTrackIndex(cursorQuery.getInt(columnIndexOrThrow10));
                bookshelfEntity.setLatestTrackId(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                bookshelfEntity.setLatestTrackTitle(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                int i3 = columnIndexOrThrow2;
                int i4 = columnIndexOrThrow3;
                bookshelfEntity.setLastUpdateTime(cursorQuery.getLong(columnIndexOrThrow13));
                int i5 = i2;
                int i6 = columnIndexOrThrow4;
                bookshelfEntity.setLastReadTime(cursorQuery.getLong(i5));
                int i7 = columnIndexOrThrow15;
                int i8 = columnIndexOrThrow13;
                bookshelfEntity.setLastSyncTime(cursorQuery.getLong(i7));
                int i9 = columnIndexOrThrow16;
                bookshelfEntity.setDataState(cursorQuery.getInt(i9));
                int i10 = columnIndexOrThrow17;
                bookshelfEntity.setCollectTime(cursorQuery.getLong(i10));
                arrayList.add(bookshelfEntity);
                columnIndexOrThrow4 = i6;
                columnIndexOrThrow3 = i4;
                i2 = i5;
                columnIndexOrThrow17 = i10;
                columnIndexOrThrow2 = i3;
                columnIndexOrThrow = i;
                columnIndexOrThrow13 = i8;
                columnIndexOrThrow15 = i7;
                columnIndexOrThrow16 = i9;
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

    @Override // com.funny.audio.database.dao.BookshelfDao
    public List<BookshelfEntity> listByLatestCollect() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM BookshelfEntity WHERE dataState = 0 ORDER BY collectTime DESC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "albumId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "announcer");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "announcerId");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categoryId");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "category");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverPath");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "finishStatus");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackCount");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackIndex");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestTrackId");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestTrackTitle");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUpdateTime");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastReadTime");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastSyncTime");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dataState");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "collectTime");
                int i2 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    BookshelfEntity bookshelfEntity = new BookshelfEntity();
                    if (cursorQuery.isNull(columnIndexOrThrow)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = cursorQuery.getString(columnIndexOrThrow);
                    }
                    bookshelfEntity.setAlbumId(string);
                    bookshelfEntity.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    bookshelfEntity.setAnnouncer(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    bookshelfEntity.setAnnouncerId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    bookshelfEntity.setCategoryId(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    bookshelfEntity.setCategory(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    bookshelfEntity.setCoverPath(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    bookshelfEntity.setFinishStatus(cursorQuery.getInt(columnIndexOrThrow8));
                    bookshelfEntity.setTrackCount(cursorQuery.getInt(columnIndexOrThrow9));
                    bookshelfEntity.setTrackIndex(cursorQuery.getInt(columnIndexOrThrow10));
                    bookshelfEntity.setLatestTrackId(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    bookshelfEntity.setLatestTrackTitle(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    int i3 = columnIndexOrThrow2;
                    int i4 = columnIndexOrThrow3;
                    bookshelfEntity.setLastUpdateTime(cursorQuery.getLong(columnIndexOrThrow13));
                    int i5 = i2;
                    int i6 = columnIndexOrThrow4;
                    bookshelfEntity.setLastReadTime(cursorQuery.getLong(i5));
                    int i7 = columnIndexOrThrow13;
                    int i8 = columnIndexOrThrow15;
                    bookshelfEntity.setLastSyncTime(cursorQuery.getLong(i8));
                    int i9 = columnIndexOrThrow16;
                    bookshelfEntity.setDataState(cursorQuery.getInt(i9));
                    int i10 = columnIndexOrThrow17;
                    bookshelfEntity.setCollectTime(cursorQuery.getLong(i10));
                    arrayList.add(bookshelfEntity);
                    columnIndexOrThrow4 = i6;
                    columnIndexOrThrow3 = i4;
                    i2 = i5;
                    columnIndexOrThrow15 = i8;
                    columnIndexOrThrow16 = i9;
                    columnIndexOrThrow13 = i7;
                    columnIndexOrThrow17 = i10;
                    columnIndexOrThrow2 = i3;
                    columnIndexOrThrow = i;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
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

    @Override // com.funny.audio.database.dao.BookshelfDao
    public List<BookshelfEntity> listByLatestRead() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM BookshelfEntity WHERE dataState = 0 ORDER BY lastReadTime DESC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "albumId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "announcer");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "announcerId");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categoryId");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "category");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverPath");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "finishStatus");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackCount");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackIndex");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestTrackId");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestTrackTitle");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUpdateTime");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastReadTime");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastSyncTime");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dataState");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "collectTime");
                int i2 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    BookshelfEntity bookshelfEntity = new BookshelfEntity();
                    if (cursorQuery.isNull(columnIndexOrThrow)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = cursorQuery.getString(columnIndexOrThrow);
                    }
                    bookshelfEntity.setAlbumId(string);
                    bookshelfEntity.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    bookshelfEntity.setAnnouncer(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    bookshelfEntity.setAnnouncerId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    bookshelfEntity.setCategoryId(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    bookshelfEntity.setCategory(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    bookshelfEntity.setCoverPath(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    bookshelfEntity.setFinishStatus(cursorQuery.getInt(columnIndexOrThrow8));
                    bookshelfEntity.setTrackCount(cursorQuery.getInt(columnIndexOrThrow9));
                    bookshelfEntity.setTrackIndex(cursorQuery.getInt(columnIndexOrThrow10));
                    bookshelfEntity.setLatestTrackId(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    bookshelfEntity.setLatestTrackTitle(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    int i3 = columnIndexOrThrow2;
                    int i4 = columnIndexOrThrow3;
                    bookshelfEntity.setLastUpdateTime(cursorQuery.getLong(columnIndexOrThrow13));
                    int i5 = i2;
                    int i6 = columnIndexOrThrow4;
                    bookshelfEntity.setLastReadTime(cursorQuery.getLong(i5));
                    int i7 = columnIndexOrThrow13;
                    int i8 = columnIndexOrThrow15;
                    bookshelfEntity.setLastSyncTime(cursorQuery.getLong(i8));
                    int i9 = columnIndexOrThrow16;
                    bookshelfEntity.setDataState(cursorQuery.getInt(i9));
                    int i10 = columnIndexOrThrow17;
                    bookshelfEntity.setCollectTime(cursorQuery.getLong(i10));
                    arrayList.add(bookshelfEntity);
                    columnIndexOrThrow4 = i6;
                    columnIndexOrThrow3 = i4;
                    i2 = i5;
                    columnIndexOrThrow15 = i8;
                    columnIndexOrThrow16 = i9;
                    columnIndexOrThrow13 = i7;
                    columnIndexOrThrow17 = i10;
                    columnIndexOrThrow2 = i3;
                    columnIndexOrThrow = i;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
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

    @Override // com.funny.audio.database.dao.BookshelfDao
    public List<BookshelfEntity> listByLatestUpdate() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM BookshelfEntity WHERE dataState = 0 ORDER BY lastUpdateTime DESC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "albumId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "announcer");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "announcerId");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categoryId");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "category");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverPath");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "finishStatus");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackCount");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackIndex");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestTrackId");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestTrackTitle");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUpdateTime");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastReadTime");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastSyncTime");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dataState");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "collectTime");
                int i2 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    BookshelfEntity bookshelfEntity = new BookshelfEntity();
                    if (cursorQuery.isNull(columnIndexOrThrow)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = cursorQuery.getString(columnIndexOrThrow);
                    }
                    bookshelfEntity.setAlbumId(string);
                    bookshelfEntity.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    bookshelfEntity.setAnnouncer(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    bookshelfEntity.setAnnouncerId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    bookshelfEntity.setCategoryId(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    bookshelfEntity.setCategory(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    bookshelfEntity.setCoverPath(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    bookshelfEntity.setFinishStatus(cursorQuery.getInt(columnIndexOrThrow8));
                    bookshelfEntity.setTrackCount(cursorQuery.getInt(columnIndexOrThrow9));
                    bookshelfEntity.setTrackIndex(cursorQuery.getInt(columnIndexOrThrow10));
                    bookshelfEntity.setLatestTrackId(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    bookshelfEntity.setLatestTrackTitle(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    int i3 = columnIndexOrThrow2;
                    int i4 = columnIndexOrThrow3;
                    bookshelfEntity.setLastUpdateTime(cursorQuery.getLong(columnIndexOrThrow13));
                    int i5 = i2;
                    int i6 = columnIndexOrThrow4;
                    bookshelfEntity.setLastReadTime(cursorQuery.getLong(i5));
                    int i7 = columnIndexOrThrow13;
                    int i8 = columnIndexOrThrow15;
                    bookshelfEntity.setLastSyncTime(cursorQuery.getLong(i8));
                    int i9 = columnIndexOrThrow16;
                    bookshelfEntity.setDataState(cursorQuery.getInt(i9));
                    int i10 = columnIndexOrThrow17;
                    bookshelfEntity.setCollectTime(cursorQuery.getLong(i10));
                    arrayList.add(bookshelfEntity);
                    columnIndexOrThrow4 = i6;
                    columnIndexOrThrow3 = i4;
                    i2 = i5;
                    columnIndexOrThrow15 = i8;
                    columnIndexOrThrow16 = i9;
                    columnIndexOrThrow13 = i7;
                    columnIndexOrThrow17 = i10;
                    columnIndexOrThrow2 = i3;
                    columnIndexOrThrow = i;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
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

    @Override // com.funny.audio.database.dao.BookshelfDao
    public List<BookshelfEntity> listByNeedSync() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM BookshelfEntity WHERE lastReadTime != lastSyncTime", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "albumId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "announcer");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "announcerId");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categoryId");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "category");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverPath");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "finishStatus");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackCount");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackIndex");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestTrackId");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestTrackTitle");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUpdateTime");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastReadTime");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastSyncTime");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dataState");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "collectTime");
                int i2 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    BookshelfEntity bookshelfEntity = new BookshelfEntity();
                    if (cursorQuery.isNull(columnIndexOrThrow)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = cursorQuery.getString(columnIndexOrThrow);
                    }
                    bookshelfEntity.setAlbumId(string);
                    bookshelfEntity.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    bookshelfEntity.setAnnouncer(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    bookshelfEntity.setAnnouncerId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    bookshelfEntity.setCategoryId(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    bookshelfEntity.setCategory(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    bookshelfEntity.setCoverPath(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    bookshelfEntity.setFinishStatus(cursorQuery.getInt(columnIndexOrThrow8));
                    bookshelfEntity.setTrackCount(cursorQuery.getInt(columnIndexOrThrow9));
                    bookshelfEntity.setTrackIndex(cursorQuery.getInt(columnIndexOrThrow10));
                    bookshelfEntity.setLatestTrackId(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    bookshelfEntity.setLatestTrackTitle(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    int i3 = columnIndexOrThrow2;
                    int i4 = columnIndexOrThrow3;
                    bookshelfEntity.setLastUpdateTime(cursorQuery.getLong(columnIndexOrThrow13));
                    int i5 = i2;
                    int i6 = columnIndexOrThrow4;
                    bookshelfEntity.setLastReadTime(cursorQuery.getLong(i5));
                    int i7 = columnIndexOrThrow13;
                    int i8 = columnIndexOrThrow15;
                    bookshelfEntity.setLastSyncTime(cursorQuery.getLong(i8));
                    int i9 = columnIndexOrThrow16;
                    bookshelfEntity.setDataState(cursorQuery.getInt(i9));
                    int i10 = columnIndexOrThrow17;
                    bookshelfEntity.setCollectTime(cursorQuery.getLong(i10));
                    arrayList.add(bookshelfEntity);
                    columnIndexOrThrow4 = i6;
                    columnIndexOrThrow3 = i4;
                    i2 = i5;
                    columnIndexOrThrow15 = i8;
                    columnIndexOrThrow16 = i9;
                    columnIndexOrThrow13 = i7;
                    columnIndexOrThrow17 = i10;
                    columnIndexOrThrow2 = i3;
                    columnIndexOrThrow = i;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
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

    @Override // com.funny.audio.database.dao.BookshelfDao
    public List<BookshelfEntity> listByNeedRemove() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM BookshelfEntity WHERE dataState = -1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "albumId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "announcer");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "announcerId");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categoryId");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "category");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coverPath");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "finishStatus");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackCount");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackIndex");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestTrackId");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "latestTrackTitle");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastUpdateTime");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastReadTime");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastSyncTime");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dataState");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "collectTime");
                int i2 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    BookshelfEntity bookshelfEntity = new BookshelfEntity();
                    if (cursorQuery.isNull(columnIndexOrThrow)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = cursorQuery.getString(columnIndexOrThrow);
                    }
                    bookshelfEntity.setAlbumId(string);
                    bookshelfEntity.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    bookshelfEntity.setAnnouncer(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    bookshelfEntity.setAnnouncerId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    bookshelfEntity.setCategoryId(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    bookshelfEntity.setCategory(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    bookshelfEntity.setCoverPath(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    bookshelfEntity.setFinishStatus(cursorQuery.getInt(columnIndexOrThrow8));
                    bookshelfEntity.setTrackCount(cursorQuery.getInt(columnIndexOrThrow9));
                    bookshelfEntity.setTrackIndex(cursorQuery.getInt(columnIndexOrThrow10));
                    bookshelfEntity.setLatestTrackId(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    bookshelfEntity.setLatestTrackTitle(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    int i3 = columnIndexOrThrow2;
                    int i4 = columnIndexOrThrow3;
                    bookshelfEntity.setLastUpdateTime(cursorQuery.getLong(columnIndexOrThrow13));
                    int i5 = i2;
                    int i6 = columnIndexOrThrow4;
                    bookshelfEntity.setLastReadTime(cursorQuery.getLong(i5));
                    int i7 = columnIndexOrThrow13;
                    int i8 = columnIndexOrThrow15;
                    bookshelfEntity.setLastSyncTime(cursorQuery.getLong(i8));
                    int i9 = columnIndexOrThrow16;
                    bookshelfEntity.setDataState(cursorQuery.getInt(i9));
                    int i10 = columnIndexOrThrow17;
                    bookshelfEntity.setCollectTime(cursorQuery.getLong(i10));
                    arrayList.add(bookshelfEntity);
                    columnIndexOrThrow4 = i6;
                    columnIndexOrThrow3 = i4;
                    i2 = i5;
                    columnIndexOrThrow15 = i8;
                    columnIndexOrThrow16 = i9;
                    columnIndexOrThrow13 = i7;
                    columnIndexOrThrow17 = i10;
                    columnIndexOrThrow2 = i3;
                    columnIndexOrThrow = i;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
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

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
