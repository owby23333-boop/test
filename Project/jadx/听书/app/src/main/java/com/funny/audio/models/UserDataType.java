package com.funny.audio.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserDataType.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/funny/audio/models/UserDataType;", "", "()V", "BOOKSHELF", "", "getBOOKSHELF", "()Ljava/lang/String;", "setBOOKSHELF", "(Ljava/lang/String;)V", "HISTORY", "getHISTORY", "setHISTORY", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UserDataType {
    public static final UserDataType INSTANCE = new UserDataType();
    private static String BOOKSHELF = "AUDIO_BOOKSHELF";
    private static String HISTORY = "AUDIO_HISTORY";

    private UserDataType() {
    }

    public final String getBOOKSHELF() {
        return BOOKSHELF;
    }

    public final void setBOOKSHELF(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        BOOKSHELF = str;
    }

    public final String getHISTORY() {
        return HISTORY;
    }

    public final void setHISTORY(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        HISTORY = str;
    }
}
