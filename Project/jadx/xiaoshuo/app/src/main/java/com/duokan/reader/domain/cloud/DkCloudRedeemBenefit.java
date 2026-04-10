package com.duokan.reader.domain.cloud;

import android.text.TextUtils;
import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.store.DkStoreRedeemBenefitInfo;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class DkCloudRedeemBenefit extends DkCloudJsonItem {
    private final DkStoreRedeemBenefitInfo mInfo;
    private final User mUser;

    public DkCloudRedeemBenefit(DkStoreRedeemBenefitInfo dkStoreRedeemBenefitInfo) {
        super(0L);
        User user = new User();
        this.mUser = user;
        this.mInfo = dkStoreRedeemBenefitInfo;
        user.mUserId = dkStoreRedeemBenefitInfo.mFromUuid;
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudItem
    public String getCloudId() {
        return null;
    }

    public User getGiver() {
        if (TextUtils.isEmpty(this.mUser.mUserId)) {
            this.mUser.mUserId = this.mInfo.mFromUuid;
        }
        return this.mUser;
    }

    public String getMessage() {
        return this.mInfo.mMessage;
    }

    public Date getWordUpdatedTime() {
        return this.mInfo.mTime;
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudItem
    public DkCloudItem merge(DkCloudItem dkCloudItem) {
        return null;
    }
}
