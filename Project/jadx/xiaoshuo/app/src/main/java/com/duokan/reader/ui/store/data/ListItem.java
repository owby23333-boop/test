package com.duokan.reader.ui.store.data;

import androidx.annotation.NonNull;
import com.duokan.reader.ui.store.data.FeedItem;
import com.duokan.reader.ui.store.data.cms.Advertisement;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class ListItem<T extends FeedItem> extends AdItem {
    private final int SPAN;
    private int groupIndex;
    public List<T> mItemList;

    public ListItem(@NonNull Advertisement advertisement, int i) {
        super(advertisement);
        this.mItemList = new ArrayList();
        this.SPAN = i;
    }

    public boolean addItem(T t) {
        if (this.mItemList.size() < this.SPAN) {
            return this.mItemList.add(t);
        }
        return false;
    }

    @Override // com.duokan.reader.ui.store.data.AdItem, com.duokan.reader.ui.store.data.FeedItem
    public boolean areContentsTheSame(FeedItem feedItem) {
        if (feedItem instanceof ListItem) {
            return this.mItemList.equals(((ListItem) feedItem).mItemList);
        }
        return false;
    }

    public int getGroupIndex() {
        return this.groupIndex;
    }

    public T getItem(int i) {
        if (i < this.mItemList.size()) {
            return this.mItemList.get(i);
        }
        return null;
    }

    public int getSize() {
        List<T> list = this.mItemList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void setGroupIndex(int i) {
        this.groupIndex = i;
    }

    public ListItem(@NonNull Advertisement advertisement) {
        this(advertisement, Integer.MAX_VALUE);
    }
}
