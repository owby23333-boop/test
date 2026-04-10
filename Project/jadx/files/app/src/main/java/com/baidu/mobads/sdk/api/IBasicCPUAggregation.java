package com.baidu.mobads.sdk.api;

import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface IBasicCPUAggregation {

    public interface ICpuHotNativeStatus {
        void onNotifyPerformance(String str);
    }

    String getContentId();

    List<String> getImagesList();

    String getLongTitle();

    String getShortTitle();

    String getTitle();

    void registerViewForInteraction(View view, List<View> list, ICpuHotNativeStatus iCpuHotNativeStatus);
}
