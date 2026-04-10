package com.funny.audio.view.bookshelf;

import kotlin.Metadata;

/* JADX INFO: compiled from: HistoryFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/funny/audio/view/bookshelf/FilterHistoryType;", "", "()V", "All", "", "getAll", "()I", "setAll", "(I)V", "Earlier", "getEarlier", "setEarlier", "Today", "getToday", "setToday", "Yesterday", "getYesterday", "setYesterday", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FilterHistoryType {
    private static int All;
    public static final FilterHistoryType INSTANCE = new FilterHistoryType();
    private static int Today = 1;
    private static int Yesterday = 2;
    private static int Earlier = 3;

    private FilterHistoryType() {
    }

    public final int getAll() {
        return All;
    }

    public final void setAll(int i) {
        All = i;
    }

    public final int getToday() {
        return Today;
    }

    public final void setToday(int i) {
        Today = i;
    }

    public final int getYesterday() {
        return Yesterday;
    }

    public final void setYesterday(int i) {
        Yesterday = i;
    }

    public final int getEarlier() {
        return Earlier;
    }

    public final void setEarlier(int i) {
        Earlier = i;
    }
}
