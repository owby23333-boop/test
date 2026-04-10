package com.duokan.reader.domain.bookshelf;

import com.yuewen.h60;

/* JADX INFO: loaded from: classes3.dex */
public enum BookShelfType {
    Simple("简约"),
    Tradition("经典"),
    List(h60.g);

    private final String style;

    BookShelfType(String str) {
        this.style = str;
    }

    public String getStyle() {
        return this.style;
    }
}
