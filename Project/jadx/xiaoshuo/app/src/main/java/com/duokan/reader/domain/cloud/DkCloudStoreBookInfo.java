package com.duokan.reader.domain.cloud;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class DkCloudStoreBookInfo implements Serializable {
    public String[] mAuthors;
    public String mBookUuid;
    public String mCoverUri;
    public String[] mEditors;
    public boolean mIsHide;
    public String mOrderUuid;
    private long mPurchaseTime;
    public String mTitle;
    public long mUpdateTime;

    public DkCloudStoreBookInfo() {
        this.mOrderUuid = null;
        this.mBookUuid = null;
        this.mTitle = null;
        this.mCoverUri = null;
        this.mAuthors = null;
        this.mEditors = null;
        this.mIsHide = false;
    }

    public long getPurchaseTimeInSeconds() {
        return this.mPurchaseTime;
    }

    public void setPurchaseTimeInSeconds(long j) {
        this.mPurchaseTime = j;
    }

    public DkCloudStoreBookInfo(DkCloudStoreBookInfo dkCloudStoreBookInfo) {
        this.mOrderUuid = null;
        this.mBookUuid = null;
        this.mTitle = null;
        this.mCoverUri = null;
        this.mAuthors = null;
        this.mEditors = null;
        this.mIsHide = false;
        this.mOrderUuid = dkCloudStoreBookInfo.mOrderUuid;
        this.mBookUuid = dkCloudStoreBookInfo.mBookUuid;
        this.mTitle = dkCloudStoreBookInfo.mTitle;
        this.mCoverUri = dkCloudStoreBookInfo.mCoverUri;
        this.mAuthors = dkCloudStoreBookInfo.mAuthors;
        this.mEditors = dkCloudStoreBookInfo.mEditors;
        this.mPurchaseTime = dkCloudStoreBookInfo.mPurchaseTime;
        this.mUpdateTime = dkCloudStoreBookInfo.mUpdateTime;
        this.mIsHide = dkCloudStoreBookInfo.mIsHide;
    }
}
