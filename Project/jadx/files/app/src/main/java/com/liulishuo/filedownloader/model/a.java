package com.liulishuo.filedownloader.model;

import android.content.ContentValues;
import com.liulishuo.filedownloader.h0.f;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;

/* JADX INFO: compiled from: ConnectionModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    private int a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f17268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f17269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f17270e;

    public void a(int i2) {
        this.a = i2;
    }

    public void b(int i2) {
        this.b = i2;
    }

    public int c() {
        return this.a;
    }

    public int d() {
        return this.b;
    }

    public long e() {
        return this.f17268c;
    }

    public ContentValues f() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(this.a));
        contentValues.put("connectionIndex", Integer.valueOf(this.b));
        contentValues.put(DBDefinition.START_OFFSET, Long.valueOf(this.f17268c));
        contentValues.put("currentOffset", Long.valueOf(this.f17269d));
        contentValues.put(DBDefinition.END_OFFSET, Long.valueOf(this.f17270e));
        return contentValues;
    }

    public String toString() {
        return f.a("id[%d] index[%d] range[%d, %d) current offset(%d)", Integer.valueOf(this.a), Integer.valueOf(this.b), Long.valueOf(this.f17268c), Long.valueOf(this.f17270e), Long.valueOf(this.f17269d));
    }

    public long a() {
        return this.f17269d;
    }

    public long b() {
        return this.f17270e;
    }

    public void c(long j2) {
        this.f17268c = j2;
    }

    public void a(long j2) {
        this.f17269d = j2;
    }

    public void b(long j2) {
        this.f17270e = j2;
    }

    public static long a(List<a> list) {
        long jA = 0;
        for (a aVar : list) {
            jA += aVar.a() - aVar.e();
        }
        return jA;
    }
}
