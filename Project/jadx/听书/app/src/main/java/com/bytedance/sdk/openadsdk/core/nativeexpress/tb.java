package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.iq.f;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.oq;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class tb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1285a;
    private List<com.bytedance.sdk.openadsdk.core.iq.pf> dl;
    private boolean e = true;
    private NativeExpressView fo;
    private int g;
    private String gc;
    private int gz;
    private List<com.bytedance.adsdk.ugeno.g.dl<View>> m;
    private double z;

    public tb(na naVar, JSONObject jSONObject, NativeExpressView nativeExpressView) {
        com.bytedance.sdk.openadsdk.core.iq.pf pfVarZ;
        this.f1285a = -1;
        this.gz = -1;
        this.fo = nativeExpressView;
        this.gz = eo.z(naVar);
        if (jSONObject != null) {
            this.z = jSONObject.optDouble("slide_threshold", 0.0d);
            this.g = jSONObject.optInt("direction", 30);
            this.f1285a = jSONObject.optInt("type", -1);
            this.gc = jSONObject.optString("rgb_color");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("rects");
            if (jSONArrayOptJSONArray != null) {
                this.dl = new ArrayList();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && (pfVarZ = com.bytedance.sdk.openadsdk.core.iq.pf.z(jSONObjectOptJSONObject)) != null) {
                        this.dl.add(pfVarZ);
                    }
                }
            }
        }
        List<com.bytedance.sdk.openadsdk.core.iq.pf> list = this.dl;
        com.bytedance.sdk.component.utils.wp.z("xdy", "priority:" + this.gz + " dirction:" + this.g + " type:" + this.f1285a + " hold:" + this.z + " size:" + (list != null ? list.size() : 0));
    }

    public void z(NativeExpressView nativeExpressView) {
        if (this.dl != null) {
            Context context = nativeExpressView.getContext();
            for (com.bytedance.sdk.openadsdk.core.iq.pf pfVar : this.dl) {
                SiteGestureView siteGestureView = new SiteGestureView(context, new f(this.f1285a, this.z, this.g, this.gz), this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(oq.dl(context, (float) pfVar.dl), oq.dl(context, (float) pfVar.f1189a));
                layoutParams.leftMargin = oq.dl(context, (float) pfVar.z);
                layoutParams.topMargin = oq.dl(context, (float) pfVar.g);
                try {
                    if (!TextUtils.isEmpty(this.gc) && com.bytedance.sdk.component.utils.wp.dl()) {
                        siteGestureView.setBackgroundColor(Color.parseColor(this.gc));
                    }
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.wp.z(e);
                }
                nativeExpressView.addView(siteGestureView, layoutParams);
                com.bytedance.sdk.component.utils.wp.z("xdy", "(" + pfVar.z + "," + pfVar.g + "," + pfVar.dl + "," + pfVar.f1189a + ")");
            }
        }
    }

    public boolean z() {
        View viewFo;
        List<com.bytedance.adsdk.ugeno.g.dl<View>> list = this.m;
        if (list == null || list.size() == 0) {
            return false;
        }
        for (com.bytedance.adsdk.ugeno.g.dl<View> dlVar : this.m) {
            if (dlVar != null && (viewFo = dlVar.fo()) != null && viewFo.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void z(List<com.bytedance.adsdk.ugeno.g.dl<View>> list) {
        this.m = list;
    }

    public void z(MotionEvent motionEvent) {
        this.fo.z(motionEvent);
    }

    public void g() {
        this.fo.tb();
    }

    public void z(View view, int i, com.bytedance.sdk.component.adexpress.dl dlVar, f fVar) {
        NativeExpressView nativeExpressView = this.fo;
        if (nativeExpressView != null) {
            nativeExpressView.z(view, i, dlVar, fVar);
        }
    }

    public boolean dl() {
        return this.e;
    }

    public void a() {
        this.e = false;
    }
}
