package com.anythink.expressad.exoplayer.g.b;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.k.af;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends h {
    public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() { // from class: com.anythink.expressad.exoplayer.g.b.d.1
        private static d a(Parcel parcel) {
            return new d(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ d[] newArray(int i2) {
            return new d[i2];
        }

        private static d[] a(int i2) {
            return new d[i2];
        }
    };
    public static final String a = "CTOC";
    public final String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f9086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String[] f9087e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final h[] f9088f;

    public d(String str, boolean z2, boolean z3, String[] strArr, h[] hVarArr) {
        super(a);
        this.b = str;
        this.f9085c = z2;
        this.f9086d = z3;
        this.f9087e = strArr;
        this.f9088f = hVarArr;
    }

    private int a() {
        return this.f9088f.length;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            if (this.f9085c == dVar.f9085c && this.f9086d == dVar.f9086d && af.a((Object) this.b, (Object) dVar.b) && Arrays.equals(this.f9087e, dVar.f9087e) && Arrays.equals(this.f9088f, dVar.f9088f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = ((((this.f9085c ? 1 : 0) + 527) * 31) + (this.f9086d ? 1 : 0)) * 31;
        String str = this.b;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.b);
        parcel.writeByte(this.f9085c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f9086d ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.f9087e);
        parcel.writeInt(this.f9088f.length);
        for (h hVar : this.f9088f) {
            parcel.writeParcelable(hVar, 0);
        }
    }

    private h a(int i2) {
        return this.f9088f[i2];
    }

    d(Parcel parcel) {
        super(a);
        this.b = parcel.readString();
        this.f9085c = parcel.readByte() != 0;
        this.f9086d = parcel.readByte() != 0;
        this.f9087e = parcel.createStringArray();
        int i2 = parcel.readInt();
        this.f9088f = new h[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            this.f9088f[i3] = (h) parcel.readParcelable(h.class.getClassLoader());
        }
    }
}
