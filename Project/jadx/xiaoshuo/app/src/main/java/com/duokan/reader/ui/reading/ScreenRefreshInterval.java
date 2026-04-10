package com.duokan.reader.ui.reading;

/* JADX INFO: loaded from: classes5.dex */
public enum ScreenRefreshInterval {
    FIVE(5, "5页"),
    TEN(10, "10页"),
    TWENTY(20, "20页"),
    NONE(0, "不全刷");

    private final String mPrefMessage;
    private final int mRefreshInterval;

    ScreenRefreshInterval(int i, String str) {
        this.mRefreshInterval = i;
        this.mPrefMessage = str;
    }

    public String getPrefMessage() {
        return this.mPrefMessage;
    }

    public int getRefreshInterval() {
        return this.mRefreshInterval;
    }
}
