package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new a();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final int f16048s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    int f16049t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    int f16050u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    int f16051v;

    static class a implements Parcelable.Creator<TimeModel> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TimeModel createFromParcel(Parcel parcel) {
            return new TimeModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TimeModel[] newArray(int i2) {
            return new TimeModel[i2];
        }
    }

    public TimeModel() {
        this(0);
    }

    private static int a(int i2) {
        return i2 >= 12 ? 1 : 0;
    }

    public static String a(Resources resources, CharSequence charSequence) {
        return a(resources, charSequence, "%02d");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeModel)) {
            return false;
        }
        TimeModel timeModel = (TimeModel) obj;
        return this.f16049t == timeModel.f16049t && this.f16050u == timeModel.f16050u && this.f16048s == timeModel.f16048s && this.f16051v == timeModel.f16051v;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f16048s), Integer.valueOf(this.f16049t), Integer.valueOf(this.f16050u), Integer.valueOf(this.f16051v)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f16049t);
        parcel.writeInt(this.f16050u);
        parcel.writeInt(this.f16051v);
        parcel.writeInt(this.f16048s);
    }

    public TimeModel(int i2) {
        this(0, 0, 10, i2);
    }

    public static String a(Resources resources, CharSequence charSequence, String str) {
        return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
    }

    public TimeModel(int i2, int i3, int i4, int i5) {
        this.f16049t = i2;
        this.f16050u = i3;
        this.f16051v = i4;
        this.f16048s = i5;
        a(i2);
        new com.google.android.material.timepicker.a(59);
        new com.google.android.material.timepicker.a(i5 == 1 ? 24 : 12);
    }

    protected TimeModel(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}
