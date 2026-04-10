package com.bytedance.sdk.openadsdk;

/* JADX INFO: loaded from: classes10.dex */
public interface TTAdDislike {

    public interface DislikeInteractionCallback {
        void onCancel();

        void onSelected(int i, String str, boolean z);

        void onShow();
    }

    boolean isShow();

    void resetDislikeStatus();

    void setDislikeInteractionCallback(DislikeInteractionCallback dislikeInteractionCallback);

    void setDislikeSource(String str);

    void showDislikeDialog();
}
