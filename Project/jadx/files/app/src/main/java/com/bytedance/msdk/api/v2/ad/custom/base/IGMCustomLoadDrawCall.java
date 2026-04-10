package com.bytedance.msdk.api.v2.ad.custom.base;

import com.bytedance.msdk.api.v2.ad.custom.GMCustomAdError;
import com.bytedance.msdk.api.v2.ad.custom.draw.GMCustomDrawAd;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface IGMCustomLoadDrawCall {
    void callLoadFail(GMCustomAdError gMCustomAdError);

    void callLoadSuccess(List<? extends GMCustomDrawAd> list);
}
