package com.kwad.sdk.utils;

import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class l {
    public static long ayi = -1;

    public static void cs(AdTemplate adTemplate) {
        if (adTemplate != null) {
            long j2 = ayi;
            adTemplate.mVisibleTimeParam = j2;
            adTemplate.mOutClickTimeParam = j2;
        }
    }

    public static void ct(AdTemplate adTemplate) {
        if (adTemplate != null) {
            adTemplate.mOutClickTimeParam = System.currentTimeMillis();
        }
    }

    public static void cu(AdTemplate adTemplate) {
        if (adTemplate != null) {
            adTemplate.mVisibleTimeParam = System.currentTimeMillis();
        }
    }

    public static long cv(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return System.currentTimeMillis();
        }
        long j2 = adTemplate.mOutClickTimeParam;
        return j2 > 0 ? j2 : adTemplate.mVisibleTimeParam;
    }
}
