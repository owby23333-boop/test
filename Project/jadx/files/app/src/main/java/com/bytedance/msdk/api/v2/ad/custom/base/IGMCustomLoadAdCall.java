package com.bytedance.msdk.api.v2.ad.custom.base;

import com.bytedance.msdk.api.v2.ad.custom.GMCustomAdError;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IGMCustomLoadAdCall {
    void callLoadFail(GMCustomAdError gMCustomAdError);

    void callLoadSuccess();

    void callLoadSuccess(double d2);

    void callLoadSuccess(double d2, Map<String, Object> map);

    void callLoadSuccess(Map<String, Object> map);
}
