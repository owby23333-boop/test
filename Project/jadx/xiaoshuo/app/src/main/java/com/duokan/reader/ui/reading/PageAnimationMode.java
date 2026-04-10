package com.duokan.reader.ui.reading;

/* JADX INFO: loaded from: classes5.dex */
public enum PageAnimationMode {
    NONE("无"),
    HSCROLL("平移"),
    VSCROLL("上下"),
    OVERLAP("覆盖"),
    FADE_IN("淡入"),
    THREE_DIMEN("仿真");

    private String style;

    PageAnimationMode(String str) {
        this.style = str;
    }

    public String getStyle() {
        return this.style;
    }

    public boolean isVerticalScroll() {
        return equals(VSCROLL);
    }
}
