package com.kwad.framework.filedownloader.d;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.kwad.framework.filedownloader.f.f;
import com.umeng.analytics.pro.ar;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() { // from class: com.kwad.framework.filedownloader.d.c.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ c createFromParcel(Parcel parcel) {
            return c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ c[] newArray(int i) {
            return bX(i);
        }

        private static c c(Parcel parcel) {
            return new c(parcel);
        }

        private static c[] bX(int i) {
            return new c[i];
        }
    };
    private String aca;
    private boolean aoJ;
    private boolean aoW;
    private final AtomicInteger aoX;
    private final AtomicLong aoY;
    private long aoZ;
    private String apa;
    private String apb;
    private int apc;
    private String filename;
    private int id;
    private String url;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final void d(String str, boolean z) {
        this.aca = str;
        this.aoW = z;
    }

    public final void d(byte b) {
        this.aoX.set(b);
    }

    public final void Z(long j) {
        this.aoY.set(j);
    }

    public final void aa(long j) {
        this.aoY.addAndGet(j);
    }

    public final void ab(long j) {
        this.aoJ = j > 2147483647L;
        this.aoZ = j;
    }

    public final int getId() {
        return this.id;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getPath() {
        return this.aca;
    }

    public final String getTargetFilePath() {
        return f.a(getPath(), wF(), getFilename());
    }

    public final String yr() {
        if (getTargetFilePath() == null) {
            return null;
        }
        return f.bD(getTargetFilePath());
    }

    public final byte wJ() {
        return (byte) this.aoX.get();
    }

    public final long yZ() {
        return this.aoY.get();
    }

    public final long getTotal() {
        return this.aoZ;
    }

    public final boolean isChunked() {
        return this.aoZ == -1;
    }

    public final String za() {
        return this.apb;
    }

    public final void bx(String str) {
        this.apb = str;
    }

    private String zb() {
        return this.apa;
    }

    public final void by(String str) {
        this.apa = str;
    }

    public final void bz(String str) {
        this.filename = str;
    }

    public final boolean wF() {
        return this.aoW;
    }

    public final String getFilename() {
        return this.filename;
    }

    public final void bW(int i) {
        this.apc = i;
    }

    public final int zc() {
        return this.apc;
    }

    public final void zd() {
        this.apc = 1;
    }

    public final ContentValues yX() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ar.d, Integer.valueOf(getId()));
        contentValues.put("url", getUrl());
        contentValues.put("path", getPath());
        contentValues.put(NotificationCompat.CATEGORY_STATUS, Byte.valueOf(wJ()));
        contentValues.put("sofar", Long.valueOf(yZ()));
        contentValues.put("total", Long.valueOf(getTotal()));
        contentValues.put("errMsg", zb());
        contentValues.put("etag", za());
        contentValues.put("connectionCount", Integer.valueOf(zc()));
        contentValues.put("pathAsDirectory", Boolean.valueOf(wF()));
        if (wF() && getFilename() != null) {
            contentValues.put("filename", getFilename());
        }
        return contentValues;
    }

    public final boolean wP() {
        return this.aoJ;
    }

    public final String toString() {
        return f.c("id[%d], url[%s], path[%s], status[%d], sofar[%s], total[%d], etag[%s], %s", Integer.valueOf(this.id), this.url, this.aca, Integer.valueOf(this.aoX.get()), this.aoY, Long.valueOf(this.aoZ), this.apb, super.toString());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.url);
        parcel.writeString(this.aca);
        parcel.writeByte(this.aoW ? (byte) 1 : (byte) 0);
        parcel.writeString(this.filename);
        parcel.writeByte((byte) this.aoX.get());
        parcel.writeLong(this.aoY.get());
        parcel.writeLong(this.aoZ);
        parcel.writeString(this.apa);
        parcel.writeString(this.apb);
        parcel.writeInt(this.apc);
        parcel.writeByte(this.aoJ ? (byte) 1 : (byte) 0);
    }

    public c() {
        this.aoY = new AtomicLong();
        this.aoX = new AtomicInteger();
    }

    protected c(Parcel parcel) {
        this.id = parcel.readInt();
        this.url = parcel.readString();
        this.aca = parcel.readString();
        this.aoW = parcel.readByte() != 0;
        this.filename = parcel.readString();
        this.aoX = new AtomicInteger(parcel.readByte());
        this.aoY = new AtomicLong(parcel.readLong());
        this.aoZ = parcel.readLong();
        this.apa = parcel.readString();
        this.apb = parcel.readString();
        this.apc = parcel.readInt();
        this.aoJ = parcel.readByte() != 0;
    }
}
