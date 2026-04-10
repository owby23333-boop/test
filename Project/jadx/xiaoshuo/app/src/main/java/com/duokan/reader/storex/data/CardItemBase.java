package com.duokan.reader.storex.data;

import com.duokan.reader.ui.store.data.FeedItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class CardItemBase<T extends FeedItem, B> extends FeedItem {
    protected final List<T> mCardList = new ArrayList();
    protected B mGroupData;

    public CardItemBase() {
        this.uiStyle = 1;
    }

    public void add(T t) {
        this.mCardList.add(t);
    }

    @Override // com.duokan.reader.ui.store.data.FeedItem
    public boolean areContentsTheSame(FeedItem feedItem) {
        if (!(feedItem instanceof CardItemBase)) {
            return false;
        }
        CardItemBase cardItemBase = (CardItemBase) feedItem;
        return Objects.equals(cardItemBase.mGroupData, this.mGroupData) && Objects.equals(cardItemBase.mCardList, this.mCardList);
    }

    public List<T> getCardList() {
        return this.mCardList;
    }

    public B getGroupData() {
        return this.mGroupData;
    }

    public boolean hasData() {
        return this.mCardList.size() > 0;
    }

    public boolean hasItem(Class<?> cls) {
        return this.mCardList.size() > 0 && cls.isInstance(this.mCardList.get(0));
    }

    public void setGroupData(B b2) {
        this.mGroupData = b2;
    }
}
