package com.duokan.reader.domain.store;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class DkStoreLabelInfo extends DkStoreItemInfo {
    public static final String NATIVE_TAG = "native://";
    public String mLabel = "";
    public String mUrl = NATIVE_TAG;
    public boolean mDefaultActive = false;

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DkStoreLabelInfo)) {
            return false;
        }
        DkStoreLabelInfo dkStoreLabelInfo = (DkStoreLabelInfo) obj;
        return TextUtils.equals(this.mLabel, dkStoreLabelInfo.mLabel) && TextUtils.equals(this.mUrl, dkStoreLabelInfo.mUrl) && this.mDefaultActive == dkStoreLabelInfo.mDefaultActive;
    }
}
