package com.funny.audio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Events.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/funny/audio/RewardAdType;", "", "()V", "MEDIA_PLAYER", "", "getMEDIA_PLAYER", "()Ljava/lang/String;", "setMEDIA_PLAYER", "(Ljava/lang/String;)V", "PURE_MODE", "getPURE_MODE", "setPURE_MODE", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RewardAdType {
    public static final RewardAdType INSTANCE = new RewardAdType();
    private static String MEDIA_PLAYER = "MEDIA_PLAYER";
    private static String PURE_MODE = "PURE_MODE";

    private RewardAdType() {
    }

    public final String getMEDIA_PLAYER() {
        return MEDIA_PLAYER;
    }

    public final void setMEDIA_PLAYER(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        MEDIA_PLAYER = str;
    }

    public final String getPURE_MODE() {
        return PURE_MODE;
    }

    public final void setPURE_MODE(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        PURE_MODE = str;
    }
}
