package com.kwai.filedownloader.c;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.kwai.filedownloader.e.f;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() { // from class: com.kwai.filedownloader.c.c.1
        private static c c(Parcel parcel) {
            return new c(parcel);
        }

        private static c[] cX(int i2) {
            return new c[i2];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ c createFromParcel(Parcel parcel) {
            return c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ c[] newArray(int i2) {
            return cX(i2);
        }
    };
    private String RY;
    private boolean aGY;
    private boolean aHl;
    private final AtomicInteger aHm;
    private final AtomicLong aHn;
    private long aHo;
    private String aHp;
    private String aHq;
    private int aHr;
    private String filename;
    private int id;
    private String url;

    public c() {
        this.aHn = new AtomicLong();
        this.aHm = new AtomicInteger();
    }

    protected c(Parcel parcel) {
        this.id = parcel.readInt();
        this.url = parcel.readString();
        this.RY = parcel.readString();
        this.aHl = parcel.readByte() != 0;
        this.filename = parcel.readString();
        this.aHm = new AtomicInteger(parcel.readByte());
        this.aHn = new AtomicLong(parcel.readLong());
        this.aHo = parcel.readLong();
        this.aHp = parcel.readString();
        this.aHq = parcel.readString();
        this.aHr = parcel.readInt();
        this.aGY = parcel.readByte() != 0;
    }

    private String At() {
        return this.aHp;
    }

    public final boolean Ga() {
        return this.aHl;
    }

    public final byte Ge() {
        return (byte) this.aHm.get();
    }

    public final boolean Gk() {
        return this.aGY;
    }

    public final String HH() {
        if (getTargetFilePath() == null) {
            return null;
        }
        return f.fk(getTargetFilePath());
    }

    public final ContentValues In() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(getId()));
        contentValues.put("url", getUrl());
        contentValues.put("path", getPath());
        contentValues.put("status", Byte.valueOf(Ge()));
        contentValues.put("sofar", Long.valueOf(Ip()));
        contentValues.put("total", Long.valueOf(getTotal()));
        contentValues.put("errMsg", At());
        contentValues.put("etag", Iq());
        contentValues.put("connectionCount", Integer.valueOf(Ir()));
        contentValues.put("pathAsDirectory", Boolean.valueOf(Ga()));
        if (Ga() && getFilename() != null) {
            contentValues.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_FILENAME, getFilename());
        }
        return contentValues;
    }

    public final long Ip() {
        return this.aHn.get();
    }

    public final String Iq() {
        return this.aHq;
    }

    public final int Ir() {
        return this.aHr;
    }

    public final void Is() {
        this.aHr = 1;
    }

    public final void ao(long j2) {
        this.aHn.set(j2);
    }

    public final void ap(long j2) {
        this.aHn.addAndGet(j2);
    }

    public final void aq(long j2) {
        this.aGY = j2 > 2147483647L;
        this.aHo = j2;
    }

    public final void cW(int i2) {
        this.aHr = i2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void e(byte b) {
        this.aHm.set(b);
    }

    public final void fe(String str) {
        this.aHq = str;
    }

    public final void ff(String str) {
        this.aHp = str;
    }

    public final void fg(String str) {
        this.filename = str;
    }

    public final void g(String str, boolean z2) {
        this.RY = str;
        this.aHl = z2;
    }

    public final String getFilename() {
        return this.filename;
    }

    public final int getId() {
        return this.id;
    }

    public final String getPath() {
        return this.RY;
    }

    public final String getTargetFilePath() {
        return f.a(getPath(), Ga(), getFilename());
    }

    public final long getTotal() {
        return this.aHo;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean isChunked() {
        return this.aHo == -1;
    }

    public final void setId(int i2) {
        this.id = i2;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String toString() {
        return f.j("id[%d], url[%s], path[%s], status[%d], sofar[%s], total[%d], etag[%s], %s", Integer.valueOf(this.id), this.url, this.RY, Integer.valueOf(this.aHm.get()), this.aHn, Long.valueOf(this.aHo), this.aHq, super.toString());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.id);
        parcel.writeString(this.url);
        parcel.writeString(this.RY);
        parcel.writeByte(this.aHl ? (byte) 1 : (byte) 0);
        parcel.writeString(this.filename);
        parcel.writeByte((byte) this.aHm.get());
        parcel.writeLong(this.aHn.get());
        parcel.writeLong(this.aHo);
        parcel.writeString(this.aHp);
        parcel.writeString(this.aHq);
        parcel.writeInt(this.aHr);
        parcel.writeByte(this.aGY ? (byte) 1 : (byte) 0);
    }
}
