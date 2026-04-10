package com.kwad.sdk.utils;

import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes4.dex */
public final class n {
    public static long aYW = -1;

    public static void eK(AdTemplate adTemplate) {
        if (adTemplate != null) {
            adTemplate.mVisibleTimeParam = aYW;
            adTemplate.mOutClickTimeParam = aYW;
        }
    }

    public static void eL(AdTemplate adTemplate) {
        if (adTemplate != null) {
            adTemplate.mOutClickTimeParam = System.currentTimeMillis();
        }
    }

    public static void eM(AdTemplate adTemplate) {
        if (adTemplate != null) {
            adTemplate.mVisibleTimeParam = System.currentTimeMillis();
        }
    }

    public static long eN(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return System.currentTimeMillis();
        }
        return adTemplate.mOutClickTimeParam > 0 ? adTemplate.mOutClickTimeParam : adTemplate.mVisibleTimeParam;
    }
}
