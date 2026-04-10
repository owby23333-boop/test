package com.duokan.statistics.biz.constant;

/* JADX INFO: loaded from: classes6.dex */
public enum AppStartSource {
    UNKNOWN("", 0),
    BACKGROUND("backgroud", 1),
    DESKTOP("desktop_icon", 2),
    THIRD_PARTY("3rd_party", 3),
    NOTIFICATION("notification", 4),
    PUSH("push", 5),
    RELAY("relay", 6);

    public int level;
    public String tag;

    AppStartSource(String str, int i) {
        this.level = i;
        this.tag = str;
    }
}
