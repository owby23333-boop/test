package com.anythink.network.baidu.impression;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public interface BDImpressionInterface {
    int getImpressionMinPercentageViewed();

    int getImpressionMinTimeViewed();

    Integer getImpressionMinVisiblePx();

    boolean isImpressionRecorded();

    void recordImpression(View view);

    void setImpressionRecorded();
}
