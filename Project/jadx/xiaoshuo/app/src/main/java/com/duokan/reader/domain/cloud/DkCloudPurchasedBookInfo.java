package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.store.DkStoreBookSourceType;

/* JADX INFO: loaded from: classes3.dex */
public class DkCloudPurchasedBookInfo extends DkCloudStoreBookInfo {
    public boolean mAd;
    public String[][] mLabels;
    public DkStoreBookSourceType mType;

    public DkCloudPurchasedBookInfo() {
        this.mLabels = null;
        this.mAd = false;
    }

    public DkCloudPurchasedBookInfo(DkCloudPurchasedBookInfo dkCloudPurchasedBookInfo) {
        super(dkCloudPurchasedBookInfo);
        this.mLabels = null;
        this.mAd = false;
        this.mLabels = dkCloudPurchasedBookInfo.mLabels;
        this.mType = dkCloudPurchasedBookInfo.mType;
        this.mAd = dkCloudPurchasedBookInfo.mAd;
    }
}
