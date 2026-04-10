package com.funny.audio.view.bookshelf;

import kotlin.Metadata;

/* JADX INFO: compiled from: CollectFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/funny/audio/view/bookshelf/FilterCollectType;", "", "()V", "RecentlyCollect", "", "getRecentlyCollect", "()I", "setRecentlyCollect", "(I)V", "RecentlyRead", "getRecentlyRead", "setRecentlyRead", "RecentlyUpdate", "getRecentlyUpdate", "setRecentlyUpdate", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FilterCollectType {
    private static int RecentlyRead;
    public static final FilterCollectType INSTANCE = new FilterCollectType();
    private static int RecentlyCollect = 1;
    private static int RecentlyUpdate = 2;

    private FilterCollectType() {
    }

    public final int getRecentlyRead() {
        return RecentlyRead;
    }

    public final void setRecentlyRead(int i) {
        RecentlyRead = i;
    }

    public final int getRecentlyCollect() {
        return RecentlyCollect;
    }

    public final void setRecentlyCollect(int i) {
        RecentlyCollect = i;
    }

    public final int getRecentlyUpdate() {
        return RecentlyUpdate;
    }

    public final void setRecentlyUpdate(int i) {
        RecentlyUpdate = i;
    }
}
