package com.funny.audio.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BannerInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/funny/audio/models/BannerRelationTypes;", "", "()V", "ALBUM", "", "getALBUM", "()Ljava/lang/String;", "setALBUM", "(Ljava/lang/String;)V", "H5_IN", "getH5_IN", "setH5_IN", "H5_OUT", "getH5_OUT", "setH5_OUT", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BannerRelationTypes {
    public static final BannerRelationTypes INSTANCE = new BannerRelationTypes();
    private static String ALBUM = "album";
    private static String H5_OUT = "h5_out";
    private static String H5_IN = "h5_in";

    private BannerRelationTypes() {
    }

    public final String getALBUM() {
        return ALBUM;
    }

    public final void setALBUM(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        ALBUM = str;
    }

    public final String getH5_OUT() {
        return H5_OUT;
    }

    public final void setH5_OUT(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        H5_OUT = str;
    }

    public final String getH5_IN() {
        return H5_IN;
    }

    public final void setH5_IN(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        H5_IN = str;
    }
}
