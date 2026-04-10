package com.yuewen;

import androidx.annotation.NonNull;
import com.duokan.free.tts.data.TTSIndex;
import com.duokan.free.tts.data.TtsTone;

/* JADX INFO: loaded from: classes15.dex */
public class rw3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TTSIndex f17286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TtsTone f17287b;

    @NonNull
    public final String c;
    public final int d;
    public final int e;

    public rw3(@NonNull TTSIndex tTSIndex, @NonNull TtsTone ttsTone, @NonNull String str, int i, int i2) {
        this.f17286a = tTSIndex;
        this.f17287b = ttsTone;
        this.c = str;
        this.d = i;
        this.e = i2;
    }

    @NonNull
    public String a() {
        return this.c;
    }

    public int b() {
        return this.d;
    }

    @NonNull
    public TTSIndex c() {
        return this.f17286a;
    }

    @NonNull
    public TtsTone d() {
        return this.f17287b;
    }

    public boolean e() {
        return this.e == 1;
    }
}
