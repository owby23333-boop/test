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
import com.funny.audio.settings.AppSettingEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class AppSettingDao_Impl implements AppSettingDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<AppSettingEntity> __deletionAdapterOfAppSettingEntity;
    private final EntityInsertionAdapter<AppSettingEntity> __insertionAdapterOfAppSettingEntity;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final EntityDeletionOrUpdateAdapter<AppSettingEntity> __updateAdapterOfAppSettingEntity;

    public AppSettingDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfAppSettingEntity = new EntityInsertionAdapter<AppSettingEntity>(__db) { // from class: com.funny.audio.database.dao.AppSettingDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `AppSettingEntity` (`settingKey`,`type`,`name`,`desc`,`time`,`userId`,`value`,`valueBoolean`,`valueInt`,`valueLong`,`valueFloat`,`valueDouble`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, AppSettingEntity appSettingEntity) {
                if (appSettingEntity.getSettingKey() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, appSettingEntity.getSettingKey());
                }
                if (appSettingEntity.getType() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, appSettingEntity.getType());
                }
                if (appSettingEntity.getName() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, appSettingEntity.getName());
                }
                if (appSettingEntity.getDesc() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, appSettingEntity.getDesc());
                }
                supportSQLiteStatement.bindLong(5, appSettingEntity.getTime());
                if (appSettingEntity.getUserId() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, appSettingEntity.getUserId());
                }
                if (appSettingEntity.getValue() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, appSettingEntity.getValue());
                }
                supportSQLiteStatement.bindLong(8, appSettingEntity.getValueBoolean() ? 1L : 0L);
                supportSQLiteStatement.bindLong(9, appSettingEntity.getValueInt());
                supportSQLiteStatement.bindLong(10, appSettingEntity.getValueLong());
                supportSQLiteStatement.bindDouble(11, appSettingEntity.getValueFloat());
                supportSQLiteStatement.bindDouble(12, appSettingEntity.getValueDouble());
            }
        };
        this.__deletionAdapterOfAppSettingEntity = new EntityDeletionOrUpdateAdapter<AppSettingEntity>(__db) { // from class: com.funny.audio.database.dao.AppSettingDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `AppSettingEntity` WHERE `settingKey` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final AppSettingEntity entity) {
                if (entity.getSettingKey() == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, entity.getSettingKey());
                }
            }
        };
        this.__updateAdapterOfAppSettingEntity = new EntityDeletionOrUpdateAdapter<AppSettingEntity>(__db) { // from class: com.funny.audio.database.dao.AppSettingDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `AppSettingEntity` SET `settingKey` = ?,`type` = ?,`name` = ?,`desc` = ?,`time` = ?,`userId` = ?,`value` = ?,`valueBoolean` = ?,`valueInt` = ?,`valueLong` = ?,`valueFloat` = ?,`valueDouble` = ? WHERE `settingKey` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, AppSettingEntity appSettingEntity) {
                if (appSettingEntity.getSettingKey() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, appSettingEntity.getSettingKey());
                }
                if (appSettingEntity.getType() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, appSettingEntity.getType());
                }
                if (appSettingEntity.getName() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, appSettingEntity.getName());
                }
                if (appSettingEntity.getDesc() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, appSettingEntity.getDesc());
                }
                supportSQLiteStatement.bindLong(5, appSettingEntity.getTime());
                if (appSettingEntity.getUserId() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, appSettingEntity.getUserId());
                }
                if (appSettingEntity.getValue() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, appSettingEntity.getValue());
                }
                supportSQLiteStatement.bindLong(8, appSettingEntity.getValueBoolean() ? 1L : 0L);
                supportSQLiteStatement.bindLong(9, appSettingEntity.getValueInt());
                supportSQLiteStatement.bindLong(10, appSettingEntity.getValueLong());
                supportSQLiteStatement.bindDouble(11, appSettingEntity.getValueFloat());
                supportSQLiteStatement.bindDouble(12, appSettingEntity.getValueDouble());
                if (appSettingEntity.getSettingKey() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, appSettingEntity.getSettingKey());
                }
            }
        };
        this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) { // from class: com.funny.audio.database.dao.AppSettingDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM AppSettingEntity WHERE settingKey=?";
            }
        };
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public long add(final AppSettingEntity info) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfAppSettingEntity.insertAndReturnId(info);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public void addList(final List<? extends AppSettingEntity> infos) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfAppSettingEntity.insert(infos);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public int remove(final AppSettingEntity info) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfAppSettingEntity.handle(info) + 0;
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public int removeList(final List<? extends AppSettingEntity> infos) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandleMultiple = this.__deletionAdapterOfAppSettingEntity.handleMultiple(infos) + 0;
            this.__db.setTransactionSuccessful();
            return iHandleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public int modify(final AppSettingEntity info) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfAppSettingEntity.handle(info) + 0;
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.BaseDao
    public int modifyList(final List<? extends AppSettingEntity> infos) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandleMultiple = this.__updateAdapterOfAppSettingEntity.handleMultiple(infos) + 0;
            this.__db.setTransactionSuccessful();
            return iHandleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.funny.audio.database.dao.AppSettingDao
    public void delete(final String key) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDelete.acquire();
        if (key == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, key);
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
            this.__preparedStmtOfDelete.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.funny.audio.database.dao.AppSettingDao
    public List<AppSettingEntity> list(final String type) {
        int i;
        String string;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM AppSettingEntity WHERE type=?", 1);
        if (type == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, type);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "settingKey");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "desc");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "userId");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "value");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valueBoolean");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valueInt");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valueLong");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valueFloat");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valueDouble");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                AppSettingEntity appSettingEntity = new AppSettingEntity();
                if (cursorQuery.isNull(columnIndexOrThrow)) {
                    i = columnIndexOrThrow;
                    string = null;
                } else {
                    i = columnIndexOrThrow;
                    string = cursorQuery.getString(columnIndexOrThrow);
                }
                appSettingEntity.setSettingKey(string);
                appSettingEntity.setType(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                appSettingEntity.setName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                appSettingEntity.setDesc(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                int i2 = columnIndexOrThrow2;
                int i3 = columnIndexOrThrow3;
                appSettingEntity.setTime(cursorQuery.getLong(columnIndexOrThrow5));
                appSettingEntity.setUserId(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                appSettingEntity.setValue(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                appSettingEntity.setValueBoolean(cursorQuery.getInt(columnIndexOrThrow8) != 0);
                appSettingEntity.setValueInt(cursorQuery.getInt(columnIndexOrThrow9));
                appSettingEntity.setValueLong(cursorQuery.getLong(columnIndexOrThrow10));
                appSettingEntity.setValueFloat(cursorQuery.getFloat(columnIndexOrThrow11));
                appSettingEntity.setValueDouble(cursorQuery.getDouble(columnIndexOrThrow12));
                arrayList.add(appSettingEntity);
                columnIndexOrThrow2 = i2;
                columnIndexOrThrow3 = i3;
                columnIndexOrThrow = i;
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.funny.audio.database.dao.AppSettingDao
    public AppSettingEntity key(final String key) {
        AppSettingEntity appSettingEntity;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM AppSettingEntity WHERE settingKey=? LIMIT 1", 1);
        if (key == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, key);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "settingKey");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "desc");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "userId");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "value");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valueBoolean");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valueInt");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valueLong");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valueFloat");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valueDouble");
            if (cursorQuery.moveToFirst()) {
                appSettingEntity = new AppSettingEntity();
                appSettingEntity.setSettingKey(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                appSettingEntity.setType(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                appSettingEntity.setName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                appSettingEntity.setDesc(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                appSettingEntity.setTime(cursorQuery.getLong(columnIndexOrThrow5));
                appSettingEntity.setUserId(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                appSettingEntity.setValue(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                appSettingEntity.setValueBoolean(cursorQuery.getInt(columnIndexOrThrow8) != 0);
                appSettingEntity.setValueInt(cursorQuery.getInt(columnIndexOrThrow9));
                appSettingEntity.setValueLong(cursorQuery.getLong(columnIndexOrThrow10));
                appSettingEntity.setValueFloat(cursorQuery.getFloat(columnIndexOrThrow11));
                appSettingEntity.setValueDouble(cursorQuery.getDouble(columnIndexOrThrow12));
            } else {
                appSettingEntity = null;
            }
            return appSettingEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
