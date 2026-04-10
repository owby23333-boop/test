package com.bytedance.sdk.openadsdk.core.dislike.e;

import android.content.Context;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTDislikeController;

/* JADX INFO: loaded from: classes10.dex */
public class bf implements TTDislikeController {
    private final com.bytedance.sdk.openadsdk.core.dislike.d.bf e;

    public bf(com.bytedance.sdk.openadsdk.core.dislike.d.bf bfVar) {
        this.e = bfVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeController
    public void onDislikeEvent(Context context, boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeController
    public void onDislikeSelected(FilterWord filterWord) {
        if (this.e == null || filterWord == null) {
            return;
        }
        e.e().e(this.e, filterWord);
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeController
    public void openWebPage(Context context, boolean z) {
    }
}
