package com.bytedance.sdk.openadsdk.core.dislike.d;

import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.PersonalizationPrompt;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class e implements DislikeInfo {
    private final bf e;

    public e(bf bfVar) {
        this.e = bfVar;
    }

    @Override // com.bytedance.sdk.openadsdk.DislikeInfo
    public List<FilterWord> getFilterWords() {
        bf bfVar = this.e;
        if (bfVar == null) {
            return null;
        }
        return bfVar.e();
    }

    @Override // com.bytedance.sdk.openadsdk.DislikeInfo
    public PersonalizationPrompt getPersonalizationPrompt() {
        return null;
    }
}
