package com.umeng.message.proguard;

import android.content.ContentValues;
import android.database.Cursor;

/* JADX INFO: compiled from: InAppMsgLog.java */
/* JADX INFO: loaded from: classes3.dex */
public class u {
    long a;
    String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f20515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f20517e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f20518f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f20519g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f20520h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f20521i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f20522j;

    public u(String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.a = System.currentTimeMillis();
        this.b = str;
        this.f20515c = i2;
        this.f20516d = i3;
        this.f20517e = i4;
        this.f20518f = i5;
        this.f20519g = i6;
        this.f20520h = i7;
        this.f20521i = i8;
        this.f20522j = i9;
    }

    public ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ae.f20425n, Long.valueOf(this.a));
        contentValues.put(ae.f20421j, this.b);
        contentValues.put(ae.f20422k, Integer.valueOf(this.f20515c));
        contentValues.put(ae.f20431t, Integer.valueOf(this.f20516d));
        contentValues.put(ae.f20432u, Integer.valueOf(this.f20517e));
        contentValues.put(ae.f20433v, Integer.valueOf(this.f20518f));
        contentValues.put(ae.f20434w, Integer.valueOf(this.f20519g));
        contentValues.put(ae.f20435x, Integer.valueOf(this.f20520h));
        contentValues.put(ae.f20436y, Integer.valueOf(this.f20521i));
        contentValues.put(ae.f20437z, Integer.valueOf(this.f20522j));
        return contentValues;
    }

    public u(Cursor cursor) {
        this.b = cursor.getString(cursor.getColumnIndex(ae.f20421j));
        this.f20515c = cursor.getInt(cursor.getColumnIndex(ae.f20422k));
        this.f20516d = cursor.getInt(cursor.getColumnIndex(ae.f20431t));
        this.f20517e = cursor.getInt(cursor.getColumnIndex(ae.f20432u));
        this.f20518f = cursor.getInt(cursor.getColumnIndex(ae.f20433v));
        this.f20519g = cursor.getInt(cursor.getColumnIndex(ae.f20434w));
        this.f20520h = cursor.getInt(cursor.getColumnIndex(ae.f20435x));
        this.f20521i = cursor.getInt(cursor.getColumnIndex(ae.f20436y));
        this.f20522j = cursor.getInt(cursor.getColumnIndex(ae.f20437z));
    }
}
