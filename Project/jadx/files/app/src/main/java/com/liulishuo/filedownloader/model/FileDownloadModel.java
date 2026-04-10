package com.liulishuo.filedownloader.model;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.liulishuo.filedownloader.h0.f;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public class FileDownloadModel implements Parcelable {
    public static final Parcelable.Creator<FileDownloadModel> CREATOR = new a();
    private String A;
    private String B;
    private int C;
    private boolean D;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f17257s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f17258t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f17259u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f17260v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f17261w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final AtomicInteger f17262x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final AtomicLong f17263y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private long f17264z;

    static class a implements Parcelable.Creator<FileDownloadModel> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileDownloadModel createFromParcel(Parcel parcel) {
            return new FileDownloadModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileDownloadModel[] newArray(int i2) {
            return new FileDownloadModel[i2];
        }
    }

    public FileDownloadModel() {
        this.f17263y = new AtomicLong();
        this.f17262x = new AtomicInteger();
    }

    public void a(String str, boolean z2) {
        this.f17259u = str;
        this.f17260v = z2;
    }

    public void b(int i2) {
        this.f17257s = i2;
    }

    public void c(long j2) {
        this.D = j2 > 2147483647L;
        this.f17264z = j2;
    }

    public void d(String str) {
        this.f17258t = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f17257s;
    }

    public String f() {
        return this.f17259u;
    }

    public long g() {
        return this.f17263y.get();
    }

    public byte h() {
        return (byte) this.f17262x.get();
    }

    public String i() {
        return f.a(f(), s(), d());
    }

    public String n() {
        if (i() == null) {
            return null;
        }
        return f.k(i());
    }

    public long o() {
        return this.f17264z;
    }

    public String p() {
        return this.f17258t;
    }

    public boolean q() {
        return this.f17264z == -1;
    }

    public boolean r() {
        return this.D;
    }

    public boolean s() {
        return this.f17260v;
    }

    public void t() {
        this.C = 1;
    }

    public String toString() {
        return f.a("id[%d], url[%s], path[%s], status[%d], sofar[%s], total[%d], etag[%s], %s", Integer.valueOf(this.f17257s), this.f17258t, this.f17259u, Integer.valueOf(this.f17262x.get()), this.f17263y, Long.valueOf(this.f17264z), this.B, super.toString());
    }

    public ContentValues u() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(e()));
        contentValues.put("url", p());
        contentValues.put("path", f());
        contentValues.put("status", Byte.valueOf(h()));
        contentValues.put("sofar", Long.valueOf(g()));
        contentValues.put("total", Long.valueOf(o()));
        contentValues.put("errMsg", c());
        contentValues.put("etag", b());
        contentValues.put("connectionCount", Integer.valueOf(a()));
        contentValues.put("pathAsDirectory", Boolean.valueOf(s()));
        if (s() && d() != null) {
            contentValues.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_FILENAME, d());
        }
        return contentValues;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f17257s);
        parcel.writeString(this.f17258t);
        parcel.writeString(this.f17259u);
        parcel.writeByte(this.f17260v ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f17261w);
        parcel.writeByte((byte) this.f17262x.get());
        parcel.writeLong(this.f17263y.get());
        parcel.writeLong(this.f17264z);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
        parcel.writeInt(this.C);
        parcel.writeByte(this.D ? (byte) 1 : (byte) 0);
    }

    public void b(long j2) {
        this.f17263y.set(j2);
    }

    public String d() {
        return this.f17261w;
    }

    public void a(byte b) {
        this.f17262x.set(b);
    }

    public String b() {
        return this.B;
    }

    public String c() {
        return this.A;
    }

    protected FileDownloadModel(Parcel parcel) {
        this.f17257s = parcel.readInt();
        this.f17258t = parcel.readString();
        this.f17259u = parcel.readString();
        this.f17260v = parcel.readByte() != 0;
        this.f17261w = parcel.readString();
        this.f17262x = new AtomicInteger(parcel.readByte());
        this.f17263y = new AtomicLong(parcel.readLong());
        this.f17264z = parcel.readLong();
        this.A = parcel.readString();
        this.B = parcel.readString();
        this.C = parcel.readInt();
        this.D = parcel.readByte() != 0;
    }

    public void a(long j2) {
        this.f17263y.addAndGet(j2);
    }

    public void b(String str) {
        this.A = str;
    }

    public void c(String str) {
        this.f17261w = str;
    }

    public void a(String str) {
        this.B = str;
    }

    public void a(int i2) {
        this.C = i2;
    }

    public int a() {
        return this.C;
    }
}
