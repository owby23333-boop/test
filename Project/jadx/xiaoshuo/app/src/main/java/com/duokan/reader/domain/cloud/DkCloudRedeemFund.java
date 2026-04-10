package com.duokan.reader.domain.cloud;

import android.text.TextUtils;
import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.store.DkStoreRedeemFundInfo;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class DkCloudRedeemFund extends DkCloudJsonItem {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final DkStoreRedeemFundInfo mInfo;
    private final User mUser;

    public DkCloudRedeemFund(DkStoreRedeemFundInfo dkStoreRedeemFundInfo) {
        super(0L);
        User user = new User();
        this.mUser = user;
        this.mInfo = dkStoreRedeemFundInfo;
        user.mUserId = dkStoreRedeemFundInfo.mReceiverId;
        user.mNickName = dkStoreRedeemFundInfo.mNickName;
        user.mIconUrl = dkStoreRedeemFundInfo.mIconUrl;
    }

    public String getBookAuthor() {
        return this.mInfo.mAuthor;
    }

    public String getBookCoverUrl() {
        return this.mInfo.mBookCover;
    }

    public String getBookEditor() {
        return this.mInfo.mEditor;
    }

    public String getBookUuid() {
        return this.mInfo.mBookUuid;
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudItem
    public String getCloudId() {
        return null;
    }

    public String getLinkUrl() {
        return this.mInfo.mLinkUrl;
    }

    public String getMessage() {
        return this.mInfo.mWords;
    }

    public String getNameLine() {
        return !TextUtils.isEmpty(getBookAuthor()) ? getBookAuthor() : getBookEditor();
    }

    public Date getReceivedTime() {
        return this.mInfo.mStatusUpdatedTime;
    }

    public User getReceivedUser() {
        return this.mUser;
    }

    public int getStatus() {
        return this.mInfo.mStatus;
    }

    public String getTitle() {
        return this.mInfo.mBookTitle;
    }

    public Date getWordUpdatedTime() {
        return this.mInfo.mWordUpdatedTime;
    }

    public boolean isUsed() {
        return this.mInfo.mStatus == 2;
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudItem
    public DkCloudItem merge(DkCloudItem dkCloudItem) {
        return null;
    }

    public void setMessage(String str) {
        this.mInfo.mWords = str;
    }
}
