package com.duokan.free.tts.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes15.dex */
public enum TtsTimer implements Parcelable {
    None(-1),
    CurrentChapter(-2),
    Minute_15(15),
    Minute_30(30),
    Minute_60(60),
    Minute_90(90);

    public static final Parcelable.Creator<TtsTimer> CREATOR = new Parcelable.Creator<TtsTimer>() { // from class: com.duokan.free.tts.data.TtsTimer.a
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TtsTimer createFromParcel(Parcel parcel) {
            return TtsTimer.valueOf(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public TtsTimer[] newArray(int i) {
            return new TtsTimer[i];
        }
    };
    private final int mTime;

    TtsTimer(int i) {
        this.mTime = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getTimeInMillisecond() {
        return TimeUnit.MINUTES.toMillis(this.mTime);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name());
    }
}
