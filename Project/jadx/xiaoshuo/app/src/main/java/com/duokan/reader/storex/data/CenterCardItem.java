package com.duokan.reader.storex.data;

import com.duokan.reader.ui.store.data.FeedItem;
import com.duokan.reader.ui.store.fiction.data.CenterTitleItem;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class CenterCardItem extends CardItemBase<FeedItem, CenterTitleItem> {
    /* JADX WARN: Multi-variable type inference failed */
    public CenterCardItem(CenterTitleItem centerTitleItem) {
        this.mGroupData = centerTitleItem;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public CenterCardItem(CenterTitleItem centerTitleItem, List<FeedItem> list) {
        this.mCardList.addAll(list);
        this.mGroupData = centerTitleItem;
    }
}
