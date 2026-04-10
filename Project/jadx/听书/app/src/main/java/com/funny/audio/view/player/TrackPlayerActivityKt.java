package com.funny.audio.view.player;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: TrackPlayerActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"formatDuration", "", "durationTime", "", "app_normalRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TrackPlayerActivityKt {
    public static final String formatDuration(long j) {
        if (j <= 0) {
            return "00:00";
        }
        long hours = TimeUnit.MILLISECONDS.toHours(j);
        long j2 = 60;
        long minutes = TimeUnit.MILLISECONDS.toMinutes(j) % j2;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j) % j2;
        if (hours > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(hours), Long.valueOf(minutes), Long.valueOf(seconds)}, 3));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String str2 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(minutes), Long.valueOf(seconds)}, 2));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }
}
