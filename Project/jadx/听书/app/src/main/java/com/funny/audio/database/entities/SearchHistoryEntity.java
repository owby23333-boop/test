package com.funny.audio.database.entities;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchHistoryEntity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/funny/audio/database/entities/SearchHistoryEntity;", "", "()V", "keyword", "", "getKeyword", "()Ljava/lang/String;", "setKeyword", "(Ljava/lang/String;)V", "time", "", "getTime", "()J", "setTime", "(J)V", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SearchHistoryEntity {
    private String keyword = "";
    private long time;

    public final String getKeyword() {
        return this.keyword;
    }

    public final void setKeyword(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.keyword = str;
    }

    public final long getTime() {
        return this.time;
    }

    public final void setTime(long j) {
        this.time = j;
    }
}
