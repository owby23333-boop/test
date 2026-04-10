package com.duokan.reader.ui.reading.tts.recommend;

import android.text.TextUtils;
import com.duokan.reader.ui.store.data.FeedItem;

/* JADX INFO: loaded from: classes5.dex */
public class CategoryTitleItem extends FeedItem {
    public final int mCategoryGroupId;
    public final String mLabel;

    public CategoryTitleItem(String str) {
        this(str, -1);
    }

    @Override // com.duokan.reader.ui.store.data.FeedItem
    public boolean areContentsTheSame(FeedItem feedItem) {
        return (feedItem instanceof CategoryTitleItem) && TextUtils.equals(this.mLabel, ((CategoryTitleItem) feedItem).mLabel);
    }

    public CategoryTitleItem(String str, int i) {
        this.mLabel = str;
        this.mCategoryGroupId = i;
    }
}
