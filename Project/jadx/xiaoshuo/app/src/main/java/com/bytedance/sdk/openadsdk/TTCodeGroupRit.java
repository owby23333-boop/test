package com.bytedance.sdk.openadsdk;

/* JADX INFO: loaded from: classes10.dex */
public interface TTCodeGroupRit {

    public interface TTCodeGroupRitListener {
        void onFail(int i, String str);

        void onSuccess(TTCodeGroupRit tTCodeGroupRit);
    }

    String getRit();

    int getSlotType();
}
