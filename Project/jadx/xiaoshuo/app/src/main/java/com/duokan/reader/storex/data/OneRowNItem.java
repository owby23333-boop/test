package com.duokan.reader.storex.data;

import com.duokan.reader.ui.store.data.FeedItem;
import com.duokan.reader.ui.store.data.GroupItem;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class OneRowNItem extends FeedItem {
    public GroupItem groupItem;
    public final List<FeedItem> itemList;

    public OneRowNItem(List<FeedItem> list) {
        ArrayList arrayList = new ArrayList();
        this.itemList = arrayList;
        this.groupItem = (GroupItem) list.get(0);
        arrayList.add(list.get(1));
        arrayList.add(list.get(2));
    }

    public FeedItem getBookItem() {
        return this.itemList.get(0);
    }

    public GroupItem getGroupData() {
        return this.groupItem;
    }

    public FeedItem getRowItem() {
        return this.itemList.get(1);
    }
}
