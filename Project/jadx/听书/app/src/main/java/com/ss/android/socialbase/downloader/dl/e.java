package com.ss.android.socialbase.downloader.dl;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.socialbase.downloader.pf.fo;

/* JADX INFO: loaded from: classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String[] f2049a;
    private final String[] dl;
    private SQLiteStatement e;
    private final String g;
    private SQLiteStatement gc;
    private SQLiteStatement gz;
    private SQLiteStatement m;
    private final SQLiteDatabase z;

    public e(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.z = sQLiteDatabase;
        this.g = str;
        this.dl = strArr;
        this.f2049a = strArr2;
    }

    public SQLiteStatement z() {
        if (this.gc == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.z.compileStatement(fo.z("INSERT INTO ", this.g, this.dl));
            synchronized (this) {
                if (this.gc == null) {
                    this.gc = sQLiteStatementCompileStatement;
                }
            }
            if (this.gc != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.gc;
    }

    public SQLiteStatement g() {
        if (this.e == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.z.compileStatement(fo.z(this.g, this.f2049a));
            synchronized (this) {
                if (this.e == null) {
                    this.e = sQLiteStatementCompileStatement;
                }
            }
            if (this.e != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.e;
    }

    public SQLiteStatement dl() {
        if (this.m == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.z.compileStatement(fo.z(this.g, this.dl, this.f2049a));
            synchronized (this) {
                if (this.m == null) {
                    this.m = sQLiteStatementCompileStatement;
                }
            }
            if (this.m != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.m;
    }

    public SQLiteStatement a() {
        if (this.gz == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.z.compileStatement(fo.g(this.g, this.dl, this.f2049a));
            synchronized (this) {
                if (this.gz == null) {
                    this.gz = sQLiteStatementCompileStatement;
                }
            }
            if (this.gz != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.gz;
    }
}
