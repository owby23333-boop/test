package com.anythink.network.baidu.impression;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BDImpressionController implements BDImpressionInterface {
    private static final int a = 0;
    private static final int b = 50;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f12385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f12386d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f12387e = 50;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Integer f12388f = null;

    @Override // com.anythink.network.baidu.impression.BDImpressionInterface
    public final int getImpressionMinPercentageViewed() {
        return this.f12387e;
    }

    @Override // com.anythink.network.baidu.impression.BDImpressionInterface
    public final int getImpressionMinTimeViewed() {
        return this.f12386d;
    }

    @Override // com.anythink.network.baidu.impression.BDImpressionInterface
    public final Integer getImpressionMinVisiblePx() {
        return this.f12388f;
    }

    @Override // com.anythink.network.baidu.impression.BDImpressionInterface
    public final boolean isImpressionRecorded() {
        return this.f12385c;
    }

    @Override // com.anythink.network.baidu.impression.BDImpressionInterface
    public abstract void recordImpression(View view);

    @Override // com.anythink.network.baidu.impression.BDImpressionInterface
    public final void setImpressionRecorded() {
        this.f12385c = true;
    }
}
