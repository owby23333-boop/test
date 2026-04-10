package com.funny.audio.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchAssociateReq.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/funny/audio/models/SearchAssociateReq;", "", "()V", "key", "", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "page", "", "getPage", "()I", "setPage", "(I)V", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SearchAssociateReq {
    private String key = "";
    private int page;

    public final String getKey() {
        return this.key;
    }

    public final void setKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.key = str;
    }

    public final int getPage() {
        return this.page;
    }

    public final void setPage(int i) {
        this.page = i;
    }
}
