package com.duokan.free.tts.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes15.dex */
public class Sentence implements Parcelable {
    public static final Parcelable.Creator<Sentence> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3701b;
    public final int c;
    public final String d;

    public class a implements Parcelable.Creator<Sentence> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Sentence createFromParcel(Parcel parcel) {
            return new Sentence(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Sentence[] newArray(int i) {
            return new Sentence[i];
        }
    }

    public Sentence(int i, int i2, int i3, String str) {
        this.c = i;
        this.f3700a = i2;
        this.f3701b = i3;
        this.d = str;
    }

    public String a() {
        return this.d;
    }

    public int b() {
        return Math.max(this.c, 0);
    }

    public int c() {
        return Math.max(this.f3700a, 0);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int f() {
        return Math.max(this.f3701b, 0);
    }

    public boolean g() {
        return !TextUtils.isEmpty(this.d);
    }

    public String toString() {
        return "Sentence{mParagraphIdx=" + this.f3700a + ", mParagraphOffset=" + this.f3701b + ", mGlobalIdx=" + this.c + ", mContent='" + this.d + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3700a);
        parcel.writeInt(this.f3701b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
    }

    public Sentence(Parcel parcel) {
        this.f3700a = parcel.readInt();
        this.f3701b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readString();
    }
}
