package com.duokan.free.tts.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.yuewen.qt1;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public class TTSIndex implements Parcelable {
    public static final Parcelable.Creator<TTSIndex> CREATOR = new a();
    public static final String f = "TTSIndex";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final String f3702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3703b;
    public final int c;
    public final int d;
    public final float e;

    public class a implements Parcelable.Creator<TTSIndex> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TTSIndex createFromParcel(Parcel parcel) {
            return new TTSIndex(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public TTSIndex[] newArray(int i) {
            return new TTSIndex[i];
        }
    }

    public interface b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f3704a = "fictionId";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f3705b = "chapterId";
        public static final String c = "paragraphIdx";
        public static final String d = "sentenceIdx";
    }

    public TTSIndex(@NonNull String str, long j, int i, int i2) {
        this.f3702a = str;
        this.f3703b = j;
        this.c = i;
        this.d = i2;
        this.e = Float.MIN_VALUE;
    }

    @NonNull
    public static TTSIndex j(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString(b.f3704a, "");
        long jOptLong = jSONObject.optLong("chapterId", 0L);
        int iOptInt = jSONObject.optInt(b.c, 0);
        int iOptInt2 = jSONObject.optInt(b.d, 0);
        if (TextUtils.isEmpty(strOptString)) {
            throw new IllegalArgumentException("fiction id is null");
        }
        return new TTSIndex(strOptString, jOptLong, iOptInt, iOptInt2);
    }

    public long a() {
        return this.f3703b;
    }

    @NonNull
    public String b() {
        return this.f3702a;
    }

    public int c() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float f() {
        return this.e;
    }

    public int g() {
        return this.d;
    }

    public boolean h() {
        return i() ? this.e == 0.0f : this.c == 0 && this.d == 0;
    }

    public boolean i() {
        return this.e != Float.MIN_VALUE;
    }

    public String k() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt(b.f3704a, this.f3702a).putOpt("chapterId", Long.valueOf(this.f3703b)).putOpt(b.c, Integer.valueOf(this.c)).putOpt(b.d, Integer.valueOf(this.d));
            String string = jSONObject.toString();
            return !TextUtils.isEmpty(string) ? string : "{}";
        } catch (JSONException e) {
            qt1.e(f, "toJsonString() fail", e);
            return "{}";
        }
    }

    public String toString() {
        return "TTSIndex[fictionId=" + this.f3702a + ", chapterId=" + this.f3703b + ", paragraphIdx=" + this.c + ", sentenceIdx=" + this.d + ']';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3702a);
        parcel.writeLong(this.f3703b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeFloat(this.e);
    }

    public TTSIndex(@NonNull String str, long j, float f2) {
        this.f3702a = str;
        this.f3703b = j;
        this.e = f2;
        this.c = 0;
        this.d = 0;
    }

    public TTSIndex(Parcel parcel) {
        this.f3702a = parcel.readString();
        this.f3703b = parcel.readLong();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readFloat();
    }
}
