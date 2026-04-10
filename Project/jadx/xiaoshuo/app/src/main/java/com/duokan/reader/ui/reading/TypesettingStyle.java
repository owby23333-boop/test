package com.duokan.reader.ui.reading;

/* JADX INFO: loaded from: classes5.dex */
public enum TypesettingStyle {
    TIGHT("小"),
    NORMAL("中"),
    LOOSE("大"),
    ORIGINAL("无"),
    CUSTOM("自定义");

    private String style;

    TypesettingStyle(String str) {
        this.style = str;
    }

    public String getStyle() {
        return this.style;
    }
}
