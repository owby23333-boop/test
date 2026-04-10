package com.duokan.reader.ui.store.fiction.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.duokan.reader.ui.store.data.FeedItem;
import com.duokan.reader.ui.store.data.cms.Advertisement;

/* JADX INFO: loaded from: classes5.dex */
public class CenterTitleItem extends FeedItem {
    public String title;

    public CenterTitleItem(@NonNull Advertisement advertisement) {
        this.title = advertisement.title;
    }

    @Override // com.duokan.reader.ui.store.data.FeedItem
    public boolean areContentsTheSame(FeedItem feedItem) {
        if (super.areContentsTheSame(feedItem) && (feedItem instanceof CenterTitleItem)) {
            return TextUtils.equals(this.title, ((CenterTitleItem) feedItem).title);
        }
        return false;
    }
}
