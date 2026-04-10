package com.duokan.reader.ui.store.data;

import com.duokan.reader.ui.store.data.cms.Data;
import com.duokan.reader.ui.store.data.cms.Fiction;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class SearchHotItem extends Data {

    @SerializedName("items")
    private List<Item> mItems;

    public static class Item extends Fiction {
        private int mRank;

        public int getRank() {
            return this.mRank;
        }

        public void setRank(int i) {
            this.mRank = i;
        }
    }

    public List<Item> getItems() {
        return this.mItems;
    }

    public void setItems(List<Item> list) {
        this.mItems = list;
    }
}
