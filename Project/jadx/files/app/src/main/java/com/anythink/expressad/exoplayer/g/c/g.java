package com.anythink.expressad.exoplayer.g.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.anythink.expressad.exoplayer.k.ac;
import com.anythink.expressad.exoplayer.k.s;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends b {
    public static final Parcelable.Creator<g> CREATOR = new Parcelable.Creator<g>() { // from class: com.anythink.expressad.exoplayer.g.c.g.1
        private static g a(Parcel parcel) {
            return new g(parcel.readLong(), parcel.readLong(), (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ g createFromParcel(Parcel parcel) {
            return new g(parcel.readLong(), parcel.readLong(), (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ g[] newArray(int i2) {
            return new g[i2];
        }

        private static g[] a(int i2) {
            return new g[i2];
        }
    };
    public final long a;
    public final long b;

    /* synthetic */ g(long j2, long j3, byte b) {
        this(j2, j3);
    }

    static g a(s sVar, long j2, ac acVar) {
        long jA = a(sVar, j2);
        return new g(jA, acVar.a(jA));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.a);
        parcel.writeLong(this.b);
    }

    private g(long j2, long j3) {
        this.a = j2;
        this.b = j3;
    }

    static long a(s sVar, long j2) {
        long jD = sVar.d();
        return (128 & jD) != 0 ? 8589934591L & ((((jD & 1) << 32) | sVar.h()) + j2) : com.anythink.expressad.exoplayer.b.b;
    }
}
