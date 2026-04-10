package com.duokan.reader.domain.store;

/* JADX INFO: loaded from: classes3.dex */
public enum RecommendType {
    RECOMMEND_HOMEPAGE("1"),
    RECOMMEND_FICTION_BOY("2"),
    RECOMMEND_FICTION_GIRL("3");

    private String mTypeIndex;

    RecommendType(String str) {
        this.mTypeIndex = str;
    }

    public String value() {
        return this.mTypeIndex;
    }
}
