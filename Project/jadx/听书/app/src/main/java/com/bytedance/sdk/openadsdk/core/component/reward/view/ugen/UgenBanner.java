package com.bytedance.sdk.openadsdk.core.component.reward.view.ugen;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.media3.common.C;
import com.bytedance.adsdk.ugeno.dl.fv;
import com.bytedance.adsdk.ugeno.dl.ls;
import com.bytedance.adsdk.ugeno.dl.pf;
import com.bytedance.adsdk.ugeno.g.dl;
import com.bytedance.adsdk.ugeno.gc.m;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.g.g;
import com.bytedance.sdk.openadsdk.core.iq.js;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.ugeno.e.gc;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class UgenBanner extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f978a;
    private boolean dl;
    private View g;
    private WeakReference<ObjectAnimator> gc;
    private int m;
    private pf z;

    public UgenBanner(Context context) {
        super(context);
        this.f978a = new AtomicBoolean(false);
    }

    public void z(na naVar, g gVar) {
        if (naVar.c() == null || TextUtils.isEmpty(naVar.c().dl())) {
            return;
        }
        z(js.wp(naVar), naVar, gVar, naVar.c().dl(), naVar.li(), TextUtils.isEmpty(naVar.no()) ? "立即下载" : naVar.no(), false);
    }

    public void setTopMargin(int i) {
        this.m = i;
    }

    public void z(com.bytedance.sdk.openadsdk.core.ugeno.m.z zVar, final na naVar, final g gVar, final String str, final String str2, final String str3, final boolean z) {
        if (zVar == null || this.f978a.getAndSet(true) || naVar.kp() == null || TextUtils.isEmpty(naVar.kp().z())) {
            return;
        }
        gc.z(zVar, new gc.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.UgenBanner.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.gc.z
            public void z(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("icon", naVar.kp().z());
                    jSONObject2.put(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, str);
                    jSONObject2.put("title", str2);
                    jSONObject2.put("button_text", str3);
                } catch (JSONException e) {
                    wp.z(e);
                }
                UgenBanner ugenBanner = UgenBanner.this;
                ugenBanner.g = ugenBanner.z(jSONObject, jSONObject2, new fv() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.UgenBanner.1.1
                    @Override // com.bytedance.adsdk.ugeno.dl.fv
                    public void z(dl dlVar, String str4, m.z zVar2) {
                    }

                    @Override // com.bytedance.adsdk.ugeno.dl.fv
                    public void z(ls lsVar, fv.g gVar2, fv.z zVar2) {
                        if (lsVar.dl() != null && "banner_click".equals(lsVar.dl().optString("type"))) {
                            UgenBanner.this.g.setTag(2114387594, Boolean.TRUE);
                            gVar.z(UgenBanner.this.g, null);
                            if (z) {
                                UgenBanner.this.z();
                            }
                        }
                    }
                });
            }
        });
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.UgenBanner.2
            @Override // java.lang.Runnable
            public void run() {
                UgenBanner.this.g();
            }
        }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
    }

    public void z() {
        ObjectAnimator objectAnimator;
        this.dl = true;
        View view = this.g;
        if (view != null) {
            view.setVisibility(8);
        }
        WeakReference<ObjectAnimator> weakReference = this.gc;
        if (weakReference == null || (objectAnimator = weakReference.get()) == null) {
            return;
        }
        objectAnimator.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View z(JSONObject jSONObject, JSONObject jSONObject2, fv fvVar) {
        pf pfVar = new pf(getContext());
        this.z = pfVar;
        dl<View> dlVarZ = pfVar.z(jSONObject);
        this.z.z(fvVar);
        this.z.g(jSONObject2);
        if (dlVarZ == null) {
            return null;
        }
        View viewFo = dlVarZ.fo();
        if (viewFo != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dlVarZ.mc(), dlVarZ.un());
            layoutParams.leftMargin = oq.dl(getContext(), 16.0f);
            layoutParams.rightMargin = oq.dl(getContext(), 16.0f);
            viewFo.setLayoutParams(layoutParams);
        }
        return viewFo;
    }

    public void g() {
        View view = this.g;
        if (view == null || this.dl) {
            return;
        }
        FrameLayout.LayoutParams layoutParamsGenerateDefaultLayoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (layoutParamsGenerateDefaultLayoutParams == null) {
            layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        }
        layoutParamsGenerateDefaultLayoutParams.topMargin = this.m;
        addView(this.g, layoutParamsGenerateDefaultLayoutParams);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.g, "translationY", -400.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(600L);
        objectAnimatorOfFloat.start();
        this.gc = new WeakReference<>(objectAnimatorOfFloat);
    }
}
