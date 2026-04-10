package com.duokan.reader.ui.reading.tts.recommend;

import androidx.annotation.StringRes;
import com.duokan.reader.ui.store.data.FeedItem;

/* JADX INFO: loaded from: classes5.dex */
public class ReloadItem extends FeedItem {

    @StringRes
    private final int mButtonTextRes;

    public ReloadItem(@StringRes int i) {
        this.mButtonTextRes = i;
    }

    @Override // com.duokan.reader.ui.store.data.FeedItem
    public boolean areContentsTheSame(FeedItem feedItem) {
        return feedItem instanceof ReloadItem;
    }

    public int getButtonTextRes() {
        return this.mButtonTextRes;
    }
}
