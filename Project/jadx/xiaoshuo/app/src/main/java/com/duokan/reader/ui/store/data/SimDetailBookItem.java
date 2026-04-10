package com.duokan.reader.ui.store.data;

import com.duokan.reader.ui.store.data.FictionDetailItem;
import com.duokan.reader.ui.store.data.cms.Data;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class SimDetailBookItem extends Data {
    private int count;
    private List<FictionDetailItem.Item> items;
    public int result;

    public int getCount() {
        return this.count;
    }

    public List<FictionDetailItem.Item> getItems() {
        return this.items;
    }

    public boolean isSuccess() {
        return this.result == 0;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setItems(List<FictionDetailItem.Item> list) {
        this.items = list;
    }
}
