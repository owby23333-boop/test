package com.bytedance.sdk.gromore.z.z.gc;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static void z(com.bytedance.msdk.api.dl.z zVar, String str) {
        com.bytedance.msdk.z.gc.dl.g("TMe_reward", "RewardUtils  ".concat(String.valueOf(str)));
        if (zVar != null) {
            com.bytedance.msdk.z.gc.dl.g("TMe_reward", "rewardItem.getRewardName " + zVar.dl());
            com.bytedance.msdk.z.gc.dl.g("TMe_reward", "rewardItem.getAmount " + zVar.g());
            com.bytedance.msdk.z.gc.dl.g("TMe_reward", "rewardItem.getCustomData() " + zVar.a());
            com.bytedance.msdk.z.gc.dl.g("TMe_reward", "rewardItem.rewardVerify() " + zVar.z());
            return;
        }
        com.bytedance.msdk.z.gc.dl.g("TMe_reward", "rewardItem is null ");
    }
}
