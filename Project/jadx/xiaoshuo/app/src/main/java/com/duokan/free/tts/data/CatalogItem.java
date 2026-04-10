package com.duokan.free.tts.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yuewen.q31;
import java.util.Objects;

/* JADX INFO: loaded from: classes15.dex */
public class CatalogItem implements Parcelable {
    public static final Parcelable.Creator<CatalogItem> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final String f3694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f3695b;

    @NonNull
    public final String c;

    @NonNull
    public final String d;
    public final long e;
    public final int f;
    public final boolean g;
    public final String h;
    public final int i;

    public class a implements Parcelable.Creator<CatalogItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CatalogItem createFromParcel(Parcel parcel) {
            return new CatalogItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public CatalogItem[] newArray(int i) {
            return new CatalogItem[i];
        }
    }

    public CatalogItem(@NonNull q31 q31Var, long j, @NonNull String str) {
        this.f3694a = q31Var.e();
        this.f = q31Var.c();
        this.f3695b = q31Var.d();
        this.c = q31Var.i();
        this.g = q31Var.j();
        this.e = j;
        this.d = str;
        this.h = q31Var.g();
        this.i = q31Var.h();
    }

    @NonNull
    public String a() {
        return this.c;
    }

    public int b() {
        return this.f;
    }

    public long c() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CatalogItem catalogItem = (CatalogItem) obj;
        return this.e == catalogItem.e && this.f3694a.equals(catalogItem.f3694a);
    }

    @NonNull
    public String f() {
        return this.d;
    }

    @Nullable
    public String g() {
        return this.f3695b;
    }

    @NonNull
    public String h() {
        return this.f3694a;
    }

    public int hashCode() {
        return Objects.hash(this.f3694a, Long.valueOf(this.e));
    }

    public String i() {
        return this.h;
    }

    public int j() {
        return this.i;
    }

    public boolean k() {
        return this.g;
    }

    public boolean l() {
        return this.e == 0;
    }

    public boolean n() {
        return this.e == ((long) (this.f - 1));
    }

    public String toString() {
        return "CatalogItem{mChapterId=" + this.e + ", mChapterName='" + this.d + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3694a);
        parcel.writeString(this.f3695b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeLong(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeString(this.h);
        parcel.writeInt(this.i);
    }

    public CatalogItem(@NonNull TTSIndex tTSIndex) {
        this.f3694a = tTSIndex.b();
        this.e = tTSIndex.a();
        this.f = -1;
        this.f3695b = "";
        this.c = "";
        this.g = false;
        this.d = "";
        this.h = "";
        this.i = 0;
    }

    public CatalogItem(@NonNull String str, @Nullable String str2, @NonNull String str3, @NonNull String str4, long j, int i, boolean z, String str5, int i2) {
        this.f3694a = str;
        this.f3695b = str2;
        this.c = str3;
        this.d = str4;
        this.e = j;
        this.f = i;
        this.g = z;
        this.h = str5;
        this.i = i2;
    }

    public CatalogItem(Parcel parcel) {
        this.f3694a = parcel.readString();
        this.f3695b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readLong();
        this.f = parcel.readInt();
        this.g = parcel.readInt() == 1;
        this.h = parcel.readString();
        this.i = parcel.readInt();
    }
}
