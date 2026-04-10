package com.duokan.reader.domain.store;

import com.duokan.reader.ui.store.data.FeedItem;

/* JADX INFO: loaded from: classes3.dex */
public class SelectedSubBanner extends FeedItem {
    private final String mDescription;
    private final String mImageUrl;

    public SelectedSubBanner(String str, String str2) {
        this.mDescription = str;
        this.mImageUrl = str2;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }
}
