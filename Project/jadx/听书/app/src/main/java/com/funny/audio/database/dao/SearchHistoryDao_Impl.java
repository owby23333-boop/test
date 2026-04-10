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
import com.funny.audio.database.entities.SearchHistoryEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class SearchHistoryDao_Impl implements SearchHistoryDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<SearchHistoryEntity> __deletionAdapterOfSearchHistoryEntity;
    private final EntityInsertionAdapter<SearchHistoryEntity> __insertionAdapterOfSearchHistoryEntity;
    private final SharedSQLiteStatement __preparedStmtOfClear;
    private final EntityDeletionOrUpdateAdapter<SearchHistoryEntity> __updateAdapterOfSearchHistoryEntity;

    public SearchHistoryDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfSearchHistoryEntity = new EntityInsertionAdapter<SearchHistoryEntity>(__db) { // from class: com.funny.audio.database.dao.SearchHistoryDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `SearchHistoryEntity` (`keyword`,`time`) VALUES (?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final SearchHistoryEntity entity) {
                if (entity.getKeyword() == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, entity.getKeyword());
                }
                statement.bindLong(2, entity.getTime());
            }
        };
        this.__deletionAdapterOfSearchHistoryEntity = new EntityDeletionOrUpdateAdapter<SearchHistoryEntity>(__db) { // from class: com.funny.audio.database.dao.SearchHistoryDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `SearchHistoryEntity` WHERE `keyword` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final SearchHistoryEntity entity) {
                if (entity.getKeyword() == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, entity.getKeyword());
                }
            }
        };
        this.__updateAdapterOfSearchHistoryEntity = new EntityDeletionOrUpdateAdapter<SearchHistoryEntity>(__db) { // from class: com.funny.audio.database.dao.SearchHistoryDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `SearchHistoryEntity` SET `keyword` = ?,`time` = ? WHERE `keyword` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final SearchHistoryEntity entity) {
                if (entity.getKeyword() == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, entity.getKeyword());
                }
                statement.bindLong(2, entity.getTime());
                if (entity.getKeyword() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getKeyword());
                }
            }
        };
        this.__preparedStmtOfClear = new SharedSQLiteStatement(__db) { // from class: com.funny.audio.database.dao.SearchHistoryDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM SearchHistoryEntity";
            }
        };
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public long add(final SearchHistoryEntity info) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfSearchHistoryEntity.insertAndReturnId(info);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public void addList(final List<? extends SearchHistoryEntity> infos) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfSearchHistoryEntity.insert(infos);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public int remove(final SearchHistoryEntity info) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfSearchHistoryEntity.handle(info) + 0;
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public int removeList(final List<? extends SearchHistoryEntity> infos) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandleMultiple = this.__deletionAdapterOfSearchHistoryEntity.handleMultiple(infos) + 0;
            this.__db.setTransactionSuccessful();
            return iHandleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public int modify(final SearchHistoryEntity info) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfSearchHistoryEntity.handle(info) + 0;
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public int modifyList(final List<? extends SearchHistoryEntity> infos) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandleMultiple = this.__updateAdapterOfSearchHistoryEntity.handleMultiple(infos) + 0;
            this.__db.setTransactionSuccessful();
            return iHandleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.SearchHistoryDao
    public void clear() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfClear.acquire();
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfClear.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.funny.audio.database.dao.SearchHistoryDao
    public List<SearchHistoryEntity> list() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM SearchHistoryEntity ORDER BY time DESC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "keyword");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                SearchHistoryEntity searchHistoryEntity = new SearchHistoryEntity();
                searchHistoryEntity.setKeyword(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                searchHistoryEntity.setTime(cursorQuery.getLong(columnIndexOrThrow2));
                arrayList.add(searchHistoryEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
