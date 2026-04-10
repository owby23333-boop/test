package com.arialyy.aria.orm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DelegateWrapper {
    private static volatile DelegateWrapper INSTANCE = null;
    private static final String TAG = "DelegateWrapper";
    private DelegateManager mDManager;
    private SQLiteDatabase mDb;

    private DelegateWrapper() {
    }

    static DelegateWrapper getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        throw new NullPointerException("请在Application中调用init进行数据库工具注册注册");
    }

    public static DelegateWrapper init(Context context) {
        if (INSTANCE == null) {
            synchronized (DelegateWrapper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DelegateWrapper(context);
                }
            }
        }
        return INSTANCE;
    }

    boolean checkDataExist(Class cls, String... strArr) {
        return SqlUtil.checkDataExist(this.mDb, cls, strArr);
    }

    <T extends DbEntity> void clean(Class<T> cls) {
        SqlUtil.clean(this.mDb, cls);
    }

    <T extends DbEntity> void delData(Class<T> cls, String... strArr) {
        ((DelegateUpdate) this.mDManager.getDelegate(DelegateUpdate.class)).delData(this.mDb, cls, strArr);
    }

    void exeSql(String str) {
        this.mDb.execSQL(str);
    }

    <T extends DbEntity> List<T> findAllData(Class<T> cls) {
        return ((DelegateFind) this.mDManager.getDelegate(DelegateFind.class)).findAllData(this.mDb, cls);
    }

    <T extends DbEntity> List<T> findData(Class<T> cls, String... strArr) {
        return ((DelegateFind) this.mDManager.getDelegate(DelegateFind.class)).findData(this.mDb, cls, strArr);
    }

    <T extends DbEntity> List<T> findDataByFuzzy(Class<T> cls, String str) {
        return ((DelegateFind) this.mDManager.getDelegate(DelegateFind.class)).findDataByFuzzy(this.mDb, cls, str);
    }

    <T extends AbsDbWrapper> List<T> findRelationData(Class<T> cls, String... strArr) {
        return ((DelegateFind) this.mDManager.getDelegate(DelegateFind.class)).findRelationData(this.mDb, cls, strArr);
    }

    int[] getRowId(Class cls) {
        return ((DelegateFind) this.mDManager.getDelegate(DelegateFind.class)).getRowId(this.mDb, cls);
    }

    void insertData(DbEntity dbEntity) {
        ((DelegateUpdate) this.mDManager.getDelegate(DelegateUpdate.class)).insertData(this.mDb, dbEntity);
    }

    <T extends DbEntity> void insertManyData(List<T> list) {
        ((DelegateUpdate) this.mDManager.getDelegate(DelegateUpdate.class)).insertManyData(this.mDb, list);
    }

    <T extends DbEntity> boolean isExist(Class<T> cls, long j2) {
        return ((DelegateFind) this.mDManager.getDelegate(DelegateFind.class)).itemExist(this.mDb, cls, j2);
    }

    public boolean tableExists(Class cls) {
        return SqlUtil.tableExists(this.mDb, (Class<? extends DbEntity>) cls);
    }

    void updateData(DbEntity dbEntity) {
        ((DelegateUpdate) this.mDManager.getDelegate(DelegateUpdate.class)).updateData(this.mDb, dbEntity);
    }

    <T extends DbEntity> void updateManyData(List<T> list) {
        ((DelegateUpdate) this.mDManager.getDelegate(DelegateUpdate.class)).updateManyData(this.mDb, list);
    }

    private DelegateWrapper(Context context) {
        this.mDb = SqlHelper.init(context.getApplicationContext()).getDb();
        this.mDManager = DelegateManager.getInstance();
    }

    <T extends DbEntity> List<T> findData(Class<T> cls, int i2, int i3, String... strArr) {
        return ((DelegateFind) this.mDManager.getDelegate(DelegateFind.class)).findData(this.mDb, cls, i2, i3, strArr);
    }

    <T extends DbEntity> List<T> findDataByFuzzy(Class<T> cls, int i2, int i3, String str) {
        return ((DelegateFind) this.mDManager.getDelegate(DelegateFind.class)).findDataByFuzzy(this.mDb, cls, i2, i3, str);
    }

    <T extends AbsDbWrapper> List<T> findRelationData(Class<T> cls, int i2, int i3, String... strArr) {
        return ((DelegateFind) this.mDManager.getDelegate(DelegateFind.class)).findRelationData(this.mDb, cls, i2, i3, strArr);
    }

    int getRowId(Class cls, Object[] objArr, Object[] objArr2) {
        return ((DelegateFind) this.mDManager.getDelegate(DelegateFind.class)).getRowId(this.mDb, cls, objArr, objArr2);
    }

    boolean isExist(String str, long j2) {
        return ((DelegateFind) this.mDManager.getDelegate(DelegateFind.class)).itemExist(this.mDb, str, j2);
    }
}
