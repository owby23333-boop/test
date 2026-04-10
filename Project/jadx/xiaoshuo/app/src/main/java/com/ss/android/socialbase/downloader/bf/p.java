package com.ss.android.socialbase.downloader.bf;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.socialbase.downloader.zk.zk;

/* JADX INFO: loaded from: classes4.dex */
public class p {
    private final String bf;
    private final String[] d;
    private final SQLiteDatabase e;
    private SQLiteStatement ga;
    private SQLiteStatement p;
    private final String[] tg;
    private SQLiteStatement v;
    private SQLiteStatement vn;

    public p(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.e = sQLiteDatabase;
        this.bf = str;
        this.d = strArr;
        this.tg = strArr2;
    }

    public SQLiteStatement bf() {
        if (this.p == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.e.compileStatement(zk.e(this.bf, this.tg));
            synchronized (this) {
                if (this.p == null) {
                    this.p = sQLiteStatementCompileStatement;
                }
            }
            if (this.p != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.p;
    }

    public SQLiteStatement d() {
        if (this.vn == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.e.compileStatement(zk.e(this.bf, this.d, this.tg));
            synchronized (this) {
                if (this.vn == null) {
                    this.vn = sQLiteStatementCompileStatement;
                }
            }
            if (this.vn != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.vn;
    }

    public SQLiteStatement e() {
        if (this.ga == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.e.compileStatement(zk.e("INSERT INTO ", this.bf, this.d));
            synchronized (this) {
                if (this.ga == null) {
                    this.ga = sQLiteStatementCompileStatement;
                }
            }
            if (this.ga != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.ga;
    }

    public SQLiteStatement tg() {
        if (this.v == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.e.compileStatement(zk.bf(this.bf, this.d, this.tg));
            synchronized (this) {
                if (this.v == null) {
                    this.v = sQLiteStatementCompileStatement;
                }
            }
            if (this.v != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.v;
    }
}
