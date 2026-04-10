package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.dl.gz;
import com.bytedance.sdk.component.adexpress.dynamic.dl.m;
import com.bytedance.sdk.component.adexpress.widget.DynamicLottieView;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicLottie extends DynamicBaseWidgetImp {
    gz g;
    String z;

    public DynamicLottie(Context context, DynamicRootView dynamicRootView, gz gzVar, String str) {
        super(context, dynamicRootView, gzVar);
        this.z = str;
        this.g = gzVar;
        DynamicLottieView lottieView = getLottieView();
        if (lottieView != null) {
            addView(lottieView, getWidgetLayoutParams());
        }
    }

    private DynamicLottieView getLottieView() {
        if (this.i == null || this.i.uy() == null || this.kb == null || TextUtils.isEmpty(this.z)) {
            return null;
        }
        m mVarGc = this.i.uy().gc();
        String strTc = mVarGc != null ? mVarGc.tc() : "";
        if (TextUtils.isEmpty(strTc)) {
            return null;
        }
        String str = this.z + "static/lotties/" + strTc + ".json";
        DynamicLottieView dynamicLottieView = new DynamicLottieView(this.kb);
        dynamicLottieView.setImageLottieTosPath(str);
        dynamicLottieView.fo();
        return dynamicLottieView;
    }
}
