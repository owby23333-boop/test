package com.bytedance.sdk.openadsdk.core.fv.z;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.sdk.openadsdk.core.iq.na;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class i extends com.bytedance.sdk.component.z.gc<JSONObject, JSONObject> {
    private na g;
    private WeakReference<com.bytedance.sdk.openadsdk.core.mc> z;

    public static void z(com.bytedance.sdk.component.z.p pVar, na naVar, com.bytedance.sdk.openadsdk.core.mc mcVar) {
        pVar.z("getDeviceInfo", (com.bytedance.sdk.component.z.gc<?, ?>) new i(mcVar, naVar));
    }

    public i(com.bytedance.sdk.openadsdk.core.mc mcVar, na naVar) {
        this.z = new WeakReference<>(mcVar);
        this.g = naVar;
    }

    @Override // com.bytedance.sdk.component.z.gc
    public JSONObject z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.putOpt("safeArea", dl());
        na naVar = this.g;
        if (naVar != null) {
            jSONObject2.put("disableSafeArea", naVar.a());
        }
        return jSONObject2;
    }

    private JSONObject dl() {
        com.bytedance.sdk.openadsdk.core.mc mcVar;
        Context context;
        Window window;
        View decorView;
        WindowInsets rootWindowInsets;
        WeakReference<com.bytedance.sdk.openadsdk.core.mc> weakReference = this.z;
        if (weakReference == null || (mcVar = weakReference.get()) == null || (context = mcVar.getContext()) == null || !(context instanceof Activity) || (window = ((Activity) context).getWindow()) == null || (decorView = window.getDecorView()) == null || Build.VERSION.SDK_INT < 28 || (rootWindowInsets = decorView.getRootWindowInsets()) == null) {
            return null;
        }
        DisplayCutout displayCutout = rootWindowInsets.getDisplayCutout();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("top", displayCutout.getSafeInsetTop());
            jSONObject.put("bottom", displayCutout.getSafeInsetBottom());
            jSONObject.put(TtmlNode.LEFT, displayCutout.getSafeInsetLeft());
            jSONObject.put(TtmlNode.RIGHT, displayCutout.getSafeInsetRight());
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
