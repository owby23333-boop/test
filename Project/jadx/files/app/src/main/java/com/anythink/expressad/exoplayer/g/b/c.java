package com.anythink.expressad.exoplayer.g.b;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.k.af;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends h {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() { // from class: com.anythink.expressad.exoplayer.g.b.c.1
        private static c a(Parcel parcel) {
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ c[] newArray(int i2) {
            return new c[i2];
        }

        private static c[] a(int i2) {
            return new c[i2];
        }
    };
    public static final String a = "CHAP";
    public final String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9080c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9081d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f9082e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f9083f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final h[] f9084h;

    public c(String str, int i2, int i3, long j2, long j3, h[] hVarArr) {
        super(a);
        this.b = str;
        this.f9080c = i2;
        this.f9081d = i3;
        this.f9082e = j2;
        this.f9083f = j3;
        this.f9084h = hVarArr;
    }

    private int a() {
        return this.f9084h.length;
    }

    @Override // com.anythink.expressad.exoplayer.g.b.h, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && c.class == obj.getClass()) {
            c cVar = (c) obj;
            if (this.f9080c == cVar.f9080c && this.f9081d == cVar.f9081d && this.f9082e == cVar.f9082e && this.f9083f == cVar.f9083f && af.a((Object) this.b, (Object) cVar.b) && Arrays.equals(this.f9084h, cVar.f9084h)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = (((((((this.f9080c + 527) * 31) + this.f9081d) * 31) + ((int) this.f9082e)) * 31) + ((int) this.f9083f)) * 31;
        String str = this.b;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.b);
        parcel.writeInt(this.f9080c);
        parcel.writeInt(this.f9081d);
        parcel.writeLong(this.f9082e);
        parcel.writeLong(this.f9083f);
        parcel.writeInt(this.f9084h.length);
        for (h hVar : this.f9084h) {
            parcel.writeParcelable(hVar, 0);
        }
    }

    private h a(int i2) {
        return this.f9084h[i2];
    }

    c(Parcel parcel) {
        super(a);
        this.b = parcel.readString();
        this.f9080c = parcel.readInt();
        this.f9081d = parcel.readInt();
        this.f9082e = parcel.readLong();
        this.f9083f = parcel.readLong();
        int i2 = parcel.readInt();
        this.f9084h = new h[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            this.f9084h[i3] = (h) parcel.readParcelable(h.class.getClassLoader());
        }
    }
}
