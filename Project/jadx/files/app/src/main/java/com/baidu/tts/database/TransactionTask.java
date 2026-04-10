package com.baidu.tts.database;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes2.dex */
public class TransactionTask {
    private SQLiteDatabase mDatabase;
    private OnTransactionListener mListener;

    public interface OnTransactionListener {
        boolean execute(SQLiteDatabase sQLiteDatabase);
    }

    public TransactionTask(SQLiteDatabase sQLiteDatabase, OnTransactionListener onTransactionListener) {
        this.mDatabase = sQLiteDatabase;
        this.mListener = onTransactionListener;
    }

    public boolean executeTransaction() {
        SQLiteDatabase sQLiteDatabase;
        boolean zExecute = false;
        if (this.mListener != null && (sQLiteDatabase = this.mDatabase) != null) {
            try {
                try {
                    sQLiteDatabase.beginTransaction();
                    zExecute = this.mListener.execute(this.mDatabase);
                    if (zExecute) {
                        this.mDatabase.setTransactionSuccessful();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    SQLiteDatabase sQLiteDatabase2 = this.mDatabase;
                    if (sQLiteDatabase2 != null) {
                    }
                }
            } finally {
                SQLiteDatabase sQLiteDatabase3 = this.mDatabase;
                if (sQLiteDatabase3 != null) {
                    sQLiteDatabase3.endTransaction();
                    this.mDatabase.close();
                }
            }
        }
        return zExecute;
    }
}
