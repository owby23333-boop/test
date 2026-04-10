package com.duokan.reader.domain.store;

import com.duokan.reader.ui.store.data.FeedItem;

/* JADX INFO: loaded from: classes3.dex */
public class SelectedSubMoreItem extends FeedItem {
    private final String mMoreUrl;
    private final String mText;

    public SelectedSubMoreItem(String str, String str2) {
        this.mText = str;
        this.mMoreUrl = str2;
    }

    public String getMoreUrl() {
        return this.mMoreUrl;
    }

    public String getText() {
        return this.mText;
    }
}
