package com.anythink.core.common.k.a;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public interface b {
    int getImpressionMinPercentageViewed();

    int getImpressionMinTimeViewed();

    Integer getImpressionMinVisiblePx();

    boolean isImpressionRecorded();

    void recordImpression(View view);

    void setImpressionRecorded();
}
