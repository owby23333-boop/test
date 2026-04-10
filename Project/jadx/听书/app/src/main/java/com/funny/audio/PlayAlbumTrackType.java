package com.funny.audio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Events.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/funny/audio/PlayAlbumTrackType;", "", "()V", "BY_ALBUM_DETAIL", "", "getBY_ALBUM_DETAIL", "()Ljava/lang/String;", "setBY_ALBUM_DETAIL", "(Ljava/lang/String;)V", "BY_COLLECT", "getBY_COLLECT", "setBY_COLLECT", "BY_HISTORY", "getBY_HISTORY", "setBY_HISTORY", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PlayAlbumTrackType {
    public static final PlayAlbumTrackType INSTANCE = new PlayAlbumTrackType();
    private static String BY_ALBUM_DETAIL = "ALBUM_DETAIL";
    private static String BY_COLLECT = "COLLECT";
    private static String BY_HISTORY = "HISTORY";

    private PlayAlbumTrackType() {
    }

    public final String getBY_ALBUM_DETAIL() {
        return BY_ALBUM_DETAIL;
    }

    public final void setBY_ALBUM_DETAIL(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        BY_ALBUM_DETAIL = str;
    }

    public final String getBY_COLLECT() {
        return BY_COLLECT;
    }

    public final void setBY_COLLECT(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        BY_COLLECT = str;
    }

    public final String getBY_HISTORY() {
        return BY_HISTORY;
    }

    public final void setBY_HISTORY(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        BY_HISTORY = str;
    }
}
