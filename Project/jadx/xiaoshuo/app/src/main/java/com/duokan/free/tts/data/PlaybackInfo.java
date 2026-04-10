package com.duokan.free.tts.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.yuewen.nw3;

/* JADX INFO: loaded from: classes15.dex */
public class PlaybackInfo implements Parcelable {
    public static final Parcelable.Creator<PlaybackInfo> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public TtsTone f3698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public TtsTimer f3699b;
    public float c;
    public long d;

    public class a implements Parcelable.Creator<PlaybackInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlaybackInfo createFromParcel(Parcel parcel) {
            return new PlaybackInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public PlaybackInfo[] newArray(int i) {
            return new PlaybackInfo[i];
        }
    }

    public PlaybackInfo() {
        this.f3698a = nw3.f15101a;
        this.f3699b = TtsTimer.None;
        this.c = 1.0f;
        this.d = -1L;
    }

    public long a() {
        return this.d;
    }

    public float b() {
        return this.c;
    }

    @NonNull
    public TtsTone c() {
        return this.f3698a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public TtsTimer f() {
        return this.f3699b;
    }

    public void g(float f) {
        this.c = f;
    }

    public void h(@NonNull TtsTone ttsTone) {
        this.f3698a = ttsTone;
    }

    public void i(@NonNull TtsTimer ttsTimer) {
        this.f3699b = ttsTimer;
        if (ttsTimer == TtsTimer.None || ttsTimer == TtsTimer.CurrentChapter) {
            this.d = ttsTimer.getTimeInMillisecond();
        } else {
            this.d = SystemClock.elapsedRealtime() + ttsTimer.getTimeInMillisecond();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f3698a, i);
        parcel.writeParcelable(this.f3699b, i);
        parcel.writeFloat(this.c);
        parcel.writeLong(this.d);
    }

    public PlaybackInfo(@NonNull PlaybackInfo playbackInfo) {
        this.f3698a = playbackInfo.c();
        this.f3699b = playbackInfo.f();
        this.c = playbackInfo.b();
        this.d = playbackInfo.a();
    }

    public PlaybackInfo(Parcel parcel) {
        this.f3698a = (TtsTone) parcel.readParcelable(TtsTone.class.getClassLoader());
        this.f3699b = (TtsTimer) parcel.readParcelable(TtsTimer.class.getClassLoader());
        this.c = parcel.readFloat();
        this.d = parcel.readLong();
    }
}
