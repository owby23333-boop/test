package com.xiaomi.ad.mediation.rewardvideoad;

/* JADX INFO: loaded from: classes5.dex */
public class MMAdReward {
    public int errorCode;
    public String errorMsg;
    public boolean isValid;
    public int rewardCount;
    public String rewardName;

    public MMAdReward(boolean z) {
        this.isValid = z;
    }

    public MMAdReward(boolean z, int i, String str) {
        this.isValid = z;
        this.rewardCount = i;
        this.rewardName = str;
    }

    public MMAdReward(boolean z, int i, String str, int i2, String str2) {
        this.isValid = z;
        this.rewardCount = i;
        this.rewardName = str;
        this.errorCode = i2;
        this.errorMsg = str2;
    }
}
