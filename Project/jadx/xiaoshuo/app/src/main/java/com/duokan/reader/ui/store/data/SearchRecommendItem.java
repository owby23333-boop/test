package com.duokan.reader.ui.store.data;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.duokan.reader.ui.store.data.cms.Data;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class SearchRecommendItem extends Data {

    @SerializedName("items")
    private List<Item> mItems;

    @SerializedName("result")
    private int mResult;
    private int mShowViewCount;

    public static class Item extends Data {
        public static final int CATEGORY = 2;
        public static final int FICTION = 1;
        public static final int JUMP_TYPE_CATEGORY = 1;
        public static final int JUMP_TYPE_LABEL = 2;
        public static final int LABEL = 3;
        private boolean mExposure;

        @SerializedName("item_id")
        private long mItemId;

        @SerializedName("item_type")
        private int mItemType;

        @SerializedName(TTDownloadField.TT_LABEL)
        private String mLabel;

        @SerializedName("summary")
        private String mSummary;

        public long getItemId() {
            return this.mItemId;
        }

        public int getItemType() {
            return this.mItemType;
        }

        public String getLabel() {
            return this.mLabel;
        }

        public String getSummary() {
            return this.mSummary;
        }

        public boolean isExposure() {
            return this.mExposure;
        }

        public void setExposure(boolean z) {
            this.mExposure = z;
        }

        public void setItemId(long j) {
            this.mItemId = j;
        }

        public void setItemType(int i) {
            this.mItemType = i;
        }

        public void setLabel(String str) {
            this.mLabel = str;
        }

        public void setSummary(String str) {
            this.mSummary = str;
        }
    }

    public List<Item> getItems() {
        return this.mItems;
    }

    public int getResult() {
        return this.mResult;
    }

    public int getShowViewCount() {
        return this.mShowViewCount;
    }

    public void setItems(List<Item> list) {
        this.mItems = list;
    }

    public void setResult(int i) {
        this.mResult = i;
    }

    public void setShowViewCount(int i) {
        this.mShowViewCount = i;
    }
}
