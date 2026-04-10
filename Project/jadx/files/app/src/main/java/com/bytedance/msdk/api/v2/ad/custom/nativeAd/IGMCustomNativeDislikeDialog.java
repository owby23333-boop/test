package com.bytedance.msdk.api.v2.ad.custom.nativeAd;

import android.app.Activity;
import com.bytedance.msdk.api.v2.GMAdDislike;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IGMCustomNativeDislikeDialog {
    void dislikeClick(String str, Map<String, Object> map);

    GMAdDislike getDislikeDialog(Activity activity, Map<String, Object> map);
}
