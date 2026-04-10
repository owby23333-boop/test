package me.jessyan.progressmanager.body;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class ProgressInfo implements Parcelable {
    public static final Parcelable.Creator<ProgressInfo> CREATOR = new a();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f21220s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f21221t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f21222u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f21223v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f21224w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f21225x;

    static class a implements Parcelable.Creator<ProgressInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public ProgressInfo createFromParcel(Parcel parcel) {
            return new ProgressInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ProgressInfo[] newArray(int i2) {
            return new ProgressInfo[i2];
        }
    }

    public ProgressInfo(long j2) {
        this.f21224w = j2;
    }

    void a(long j2) {
        this.f21221t = j2;
    }

    void b(long j2) {
        this.f21220s = j2;
    }

    void c(long j2) {
        this.f21223v = j2;
    }

    void d(long j2) {
        this.f21222u = j2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ProgressInfo{id=" + this.f21224w + ", currentBytes=" + this.f21220s + ", contentLength=" + this.f21221t + ", eachBytes=" + this.f21223v + ", intervalTime=" + this.f21222u + ", finish=" + this.f21225x + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f21220s);
        parcel.writeLong(this.f21221t);
        parcel.writeLong(this.f21222u);
        parcel.writeLong(this.f21223v);
        parcel.writeLong(this.f21224w);
        parcel.writeByte(this.f21225x ? (byte) 1 : (byte) 0);
    }

    void a(boolean z2) {
        this.f21225x = z2;
    }

    public long b() {
        return this.f21224w;
    }

    protected ProgressInfo(Parcel parcel) {
        this.f21220s = parcel.readLong();
        this.f21221t = parcel.readLong();
        this.f21222u = parcel.readLong();
        this.f21223v = parcel.readLong();
        this.f21224w = parcel.readLong();
        this.f21225x = parcel.readByte() != 0;
    }

    public long a() {
        return this.f21221t;
    }
}
