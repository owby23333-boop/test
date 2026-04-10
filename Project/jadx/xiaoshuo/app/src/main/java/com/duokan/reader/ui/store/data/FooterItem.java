package com.duokan.reader.ui.store.data;

import com.duokan.reader.ui.store.LoadStatus;

/* JADX INFO: loaded from: classes5.dex */
public class FooterItem extends FeedItem {
    public LoadStatus loadStatus;
    public int position = 0;

    @Override // com.duokan.reader.ui.store.data.FeedItem
    public boolean areContentsTheSame(FeedItem feedItem) {
        return ((FooterItem) feedItem).loadStatus == this.loadStatus && this.uiStyle == feedItem.uiStyle;
    }
}
