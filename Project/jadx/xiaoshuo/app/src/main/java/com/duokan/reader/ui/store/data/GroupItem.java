package com.duokan.reader.ui.store.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.duokan.reader.ui.store.data.cms.Advertisement;
import com.xiaomi.mipush.sdk.Constants;
import com.yuewen.d7;
import com.yuewen.yp3;

/* JADX INFO: loaded from: classes5.dex */
public class GroupItem extends AdItem {
    public String bgUrl;
    public String bgUrlDark;
    public int bookListType;
    public boolean hasMore;
    public boolean isNewUserCard;
    public int mTitleRes;
    public String moreText;
    public String moreUrl;
    public boolean showTitle;
    public boolean useType;

    public GroupItem(@NonNull Advertisement advertisement) {
        super(advertisement);
        this.mTitleRes = -1;
        this.hasMore = hasMoreData(advertisement);
        this.showTitle = advertisement.showTitle();
        this.moreText = advertisement.getMoreText();
        this.bookListType = advertisement.getBookListType();
        resolveTrack(advertisement);
    }

    private void resolveTrack(Advertisement advertisement) {
        if (advertisement == null || TextUtils.isEmpty(advertisement.track)) {
            return;
        }
        try {
            setPageName(yp3.b(Integer.parseInt(advertisement.track.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)[0].split("_")[0])));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.duokan.reader.ui.store.data.AdItem, com.duokan.reader.ui.store.data.FeedItem
    public boolean areContentsTheSame(FeedItem feedItem) {
        if (!super.areContentsTheSame(feedItem)) {
            return false;
        }
        GroupItem groupItem = (GroupItem) feedItem;
        return this.hasMore == groupItem.hasMore && this.mTitleRes == groupItem.mTitleRes && this.showTitle == groupItem.showTitle && TextUtils.equals(this.moreUrl, groupItem.moreUrl);
    }

    public boolean hasMoreData(Advertisement advertisement) {
        this.moreUrl = d7.c(advertisement);
        return !TextUtils.isEmpty(r1);
    }

    public GroupItem(@NonNull Advertisement advertisement, boolean z, String str) {
        this(advertisement);
        this.hasMore = z;
        this.moreUrl = str;
        resolveTrack(advertisement);
    }

    public GroupItem(@NonNull Advertisement advertisement, String str, boolean z, String str2) {
        this(advertisement);
        this.track = str;
        this.hasMore = z;
        this.moreUrl = str2;
        resolveTrack(advertisement);
    }
}
