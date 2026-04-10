package com.duokan.reader.ui.store.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.ui.store.GroupStyle;
import com.yuewen.we2;
import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public class FeedItem implements Serializable {
    public String pageName;
    public boolean isExposed = false;
    private GroupStyle mStyle = GroupStyle.NONE;
    public int uiStyle = 1;
    public transient boolean isSensorExposed = false;

    public FeedItem() {
    }

    public boolean areContentsTheSame(FeedItem feedItem) {
        return true;
    }

    public boolean areItemsTheSame(FeedItem feedItem) {
        return this == feedItem || (feedItem != null && feedItem.getClass() == getClass());
    }

    public boolean build(WebSession webSession) throws Exception {
        return true;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof FeedItem)) {
            return false;
        }
        FeedItem feedItem = (FeedItem) obj;
        return areItemsTheSame(feedItem) && areContentsTheSame(feedItem);
    }

    public String getClickTrack() {
        return "_r:" + this.pageName;
    }

    public GroupStyle getGroupStyle() {
        return this.mStyle;
    }

    public String getPageName() {
        return this.pageName;
    }

    public String getTrackValue() {
        return "";
    }

    public void setGroupStyle(GroupStyle groupStyle) {
        this.mStyle = groupStyle;
    }

    public void setPageName(@we2 String str) {
        this.pageName = str;
    }

    public FeedItem(@NonNull String str) {
        this.pageName = str;
    }
}
