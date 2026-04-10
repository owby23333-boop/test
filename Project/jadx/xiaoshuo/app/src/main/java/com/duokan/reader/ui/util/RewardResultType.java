package com.duokan.reader.ui.util;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/duokan/reader/ui/util/RewardResultType;", "", "todayCount", "", "(Ljava/lang/String;II)V", "getTodayCount", "()I", "setTodayCount", "(I)V", "OVER_TODAY_MAX", "SUCCESS", "DkReading_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum RewardResultType {
    OVER_TODAY_MAX(0),
    SUCCESS(0);

    private int todayCount;

    RewardResultType(int i) {
        this.todayCount = i;
    }

    public final int getTodayCount() {
        return this.todayCount;
    }

    public final void setTodayCount(int i) {
        this.todayCount = i;
    }

    @NotNull
    public final RewardResultType todayCount(int todayCount) {
        this.todayCount = todayCount;
        return this;
    }
}
