package com.duokan.dkcategory.data.secondary;

/* JADX INFO: loaded from: classes13.dex */
public enum SortType {
    HOTTEST("popular", "最热"),
    LATEST("latest", "最新"),
    WORD("word_count", "字数"),
    SCORE("score", "评分");

    private final String key;
    private final String label;

    SortType(String key, String label) {
        this.key = key;
        this.label = label;
    }

    public String getKey() {
        return this.key;
    }

    public String getLabel() {
        return this.label;
    }
}
