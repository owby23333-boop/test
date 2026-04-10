package com.anythink.expressad.exoplayer.g.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.anythink.expressad.exoplayer.k.s;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends b {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.anythink.expressad.exoplayer.g.c.a.1
        private static a a(Parcel parcel) {
            return new a(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ a createFromParcel(Parcel parcel) {
            return new a(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ a[] newArray(int i2) {
            return new a[i2];
        }

        private static a[] a(int i2) {
            return new a[i2];
        }
    };
    public final long a;
    public final long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f9114c;

    /* synthetic */ a(Parcel parcel, byte b) {
        this(parcel);
    }

    static a a(s sVar, int i2, long j2) {
        long jH = sVar.h();
        byte[] bArr = new byte[i2 - 4];
        sVar.a(bArr, 0, bArr.length);
        return new a(jH, bArr, j2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.a);
        parcel.writeLong(this.b);
        parcel.writeInt(this.f9114c.length);
        parcel.writeByteArray(this.f9114c);
    }

    private a(long j2, byte[] bArr, long j3) {
        this.a = j3;
        this.b = j2;
        this.f9114c = bArr;
    }

    private a(Parcel parcel) {
        this.a = parcel.readLong();
        this.b = parcel.readLong();
        this.f9114c = new byte[parcel.readInt()];
        parcel.readByteArray(this.f9114c);
    }
}
