package com.bytedance.sdk.openadsdk.mediation.custom;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface MediationRewardItem {
    float getAmount();

    Map<String, Object> getCustomData();

    String getRewardName();

    boolean rewardVerify();
}
