package com.anythink.expressad.exoplayer.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(21)
public final class c {
    public static final c a = new c(new int[]{2}, 2);
    private final int[] b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f8525c;

    private c(int[] iArr, int i2) {
        if (iArr != null) {
            this.b = Arrays.copyOf(iArr, iArr.length);
            Arrays.sort(this.b);
        } else {
            this.b = new int[0];
        }
        this.f8525c = i2;
    }

    public static c a(Context context) {
        return a(context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Arrays.equals(this.b, cVar.b) && this.f8525c == cVar.f8525c;
    }

    public final int hashCode() {
        return this.f8525c + (Arrays.hashCode(this.b) * 31);
    }

    public final String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f8525c + ", supportedEncodings=" + Arrays.toString(this.b) + "]";
    }

    @SuppressLint({"InlinedApi"})
    static c a(Intent intent) {
        if (intent != null && intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) != 0) {
            return new c(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
        }
        return a;
    }

    public final boolean a(int i2) {
        return Arrays.binarySearch(this.b, i2) >= 0;
    }

    private int a() {
        return this.f8525c;
    }
}
