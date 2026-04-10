package com.yuewen;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: classes12.dex */
public class yv1 implements Cursor {
    public static final /* synthetic */ boolean c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final va3 f20612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Cursor f20613b;

    public yv1(va3 va3Var, Cursor cursor) {
        this.f20612a = va3Var;
        this.f20613b = cursor;
        va3Var.a();
    }

    @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (isClosed()) {
            return;
        }
        this.f20613b.close();
        this.f20612a.b();
    }

    @Override // android.database.Cursor
    public void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
        this.f20613b.copyStringToBuffer(i, charArrayBuffer);
    }

    @Override // android.database.Cursor
    public void deactivate() {
        this.f20613b.deactivate();
    }

    public void finalize() {
        close();
    }

    @Override // android.database.Cursor
    public byte[] getBlob(int i) {
        return this.f20613b.getBlob(i);
    }

    @Override // android.database.Cursor
    public int getColumnCount() {
        return this.f20613b.getColumnCount();
    }

    @Override // android.database.Cursor
    public int getColumnIndex(String str) {
        return this.f20613b.getColumnIndex(str);
    }

    @Override // android.database.Cursor
    public int getColumnIndexOrThrow(String str) throws IllegalArgumentException {
        return this.f20613b.getColumnIndexOrThrow(str);
    }

    @Override // android.database.Cursor
    public String getColumnName(int i) {
        return this.f20613b.getColumnName(i);
    }

    @Override // android.database.Cursor
    public String[] getColumnNames() {
        return this.f20613b.getColumnNames();
    }

    @Override // android.database.Cursor
    public int getCount() {
        return this.f20613b.getCount();
    }

    @Override // android.database.Cursor
    public double getDouble(int i) {
        return this.f20613b.getDouble(i);
    }

    @Override // android.database.Cursor
    public Bundle getExtras() {
        return this.f20613b.getExtras();
    }

    @Override // android.database.Cursor
    public float getFloat(int i) {
        return this.f20613b.getFloat(i);
    }

    @Override // android.database.Cursor
    public int getInt(int i) {
        return this.f20613b.getInt(i);
    }

    @Override // android.database.Cursor
    public long getLong(int i) {
        return this.f20613b.getLong(i);
    }

    @Override // android.database.Cursor
    @TargetApi(19)
    public Uri getNotificationUri() {
        return this.f20613b.getNotificationUri();
    }

    @Override // android.database.Cursor
    public int getPosition() {
        return this.f20613b.getPosition();
    }

    @Override // android.database.Cursor
    public short getShort(int i) {
        return this.f20613b.getShort(i);
    }

    @Override // android.database.Cursor
    public String getString(int i) {
        return this.f20613b.getString(i);
    }

    @Override // android.database.Cursor
    @TargetApi(11)
    public int getType(int i) {
        return this.f20613b.getType(i);
    }

    @Override // android.database.Cursor
    public boolean getWantsAllOnMoveCalls() {
        return this.f20613b.getWantsAllOnMoveCalls();
    }

    @Override // android.database.Cursor
    public boolean isAfterLast() {
        return this.f20613b.isAfterLast();
    }

    @Override // android.database.Cursor
    public boolean isBeforeFirst() {
        return this.f20613b.isBeforeFirst();
    }

    @Override // android.database.Cursor
    public boolean isClosed() {
        return this.f20613b.isClosed();
    }

    @Override // android.database.Cursor
    public boolean isFirst() {
        return this.f20613b.isFirst();
    }

    @Override // android.database.Cursor
    public boolean isLast() {
        return this.f20613b.isLast();
    }

    @Override // android.database.Cursor
    public boolean isNull(int i) {
        return this.f20613b.isNull(i);
    }

    @Override // android.database.Cursor
    public boolean move(int i) {
        return this.f20613b.move(i);
    }

    @Override // android.database.Cursor
    public boolean moveToFirst() {
        return this.f20613b.moveToFirst();
    }

    @Override // android.database.Cursor
    public boolean moveToLast() {
        return this.f20613b.moveToLast();
    }

    @Override // android.database.Cursor
    public boolean moveToNext() {
        return this.f20613b.moveToNext();
    }

    @Override // android.database.Cursor
    public boolean moveToPosition(int i) {
        return this.f20613b.moveToPosition(i);
    }

    @Override // android.database.Cursor
    public boolean moveToPrevious() {
        return this.f20613b.moveToPrevious();
    }

    @Override // android.database.Cursor
    public void registerContentObserver(ContentObserver contentObserver) {
        this.f20613b.registerContentObserver(contentObserver);
    }

    @Override // android.database.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.f20613b.registerDataSetObserver(dataSetObserver);
    }

    @Override // android.database.Cursor
    public boolean requery() {
        return false;
    }

    @Override // android.database.Cursor
    public Bundle respond(Bundle bundle) {
        return this.f20613b.respond(bundle);
    }

    @Override // android.database.Cursor
    @TargetApi(23)
    public void setExtras(Bundle bundle) {
        this.f20613b.setExtras(bundle);
    }

    @Override // android.database.Cursor
    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        this.f20613b.setNotificationUri(contentResolver, uri);
    }

    @Override // android.database.Cursor
    public void unregisterContentObserver(ContentObserver contentObserver) {
        this.f20613b.unregisterContentObserver(contentObserver);
    }

    @Override // android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.f20613b.unregisterDataSetObserver(dataSetObserver);
    }
}
