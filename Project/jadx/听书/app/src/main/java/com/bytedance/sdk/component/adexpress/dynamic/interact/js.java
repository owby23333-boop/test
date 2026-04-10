package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView;
import com.bytedance.sdk.component.utils.tb;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class js implements e<WriggleGuideAnimationView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DynamicBaseWidget f563a;
    private Context dl;
    private com.bytedance.sdk.component.adexpress.dynamic.dl.uy e;
    private WriggleGuideAnimationView g;
    private com.bytedance.sdk.component.adexpress.dynamic.dl.e gc;
    private boolean gz;
    private String m;
    public int z;

    public js(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.dl.e eVar, String str, com.bytedance.sdk.component.adexpress.dynamic.dl.uy uyVar, boolean z, int i) {
        this.dl = context;
        this.f563a = dynamicBaseWidget;
        this.gc = eVar;
        this.m = str;
        this.e = uyVar;
        this.gz = z;
        this.z = i;
        gc();
    }

    private void gc() {
        int iVm = this.gc.vm();
        final com.bytedance.sdk.component.adexpress.dynamic.gc.z dynamicClickListener = this.f563a.getDynamicClickListener();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("convertActionType", 2);
            dynamicClickListener.z(jSONObject);
        } catch (Throwable unused) {
        }
        if ("18".equals(this.m)) {
            Context context = this.dl;
            WriggleGuideAnimationView wriggleGuideAnimationView = new WriggleGuideAnimationView(context, com.bytedance.sdk.component.adexpress.dl.z.fo(context), this.e, this.gz, this.z);
            this.g = wriggleGuideAnimationView;
            if (wriggleGuideAnimationView.getWriggleLayout() != null) {
                this.g.getWriggleLayout().setOnClickListener((View.OnClickListener) dynamicClickListener);
            }
            if (this.g.getTopTextView() != null) {
                if (TextUtils.isEmpty(this.gc.me())) {
                    this.g.getTopTextView().setText(tb.g(this.dl, "tt_splash_wriggle_top_text_style_17"));
                } else {
                    this.g.getTopTextView().setText(this.gc.me());
                }
            }
        } else {
            Context context2 = this.dl;
            this.g = new WriggleGuideAnimationView(context2, com.bytedance.sdk.component.adexpress.dl.z.fo(context2), this.e, this.gz, this.z);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        this.g.setTranslationY(-((int) com.bytedance.sdk.component.adexpress.a.gz.z(this.dl, iVm)));
        this.g.setLayoutParams(layoutParams);
        this.g.setShakeText(this.gc.gb());
        this.g.setClipChildren(false);
        final View wriggleProgressIv = this.g.getWriggleProgressIv();
        this.g.setOnShakeViewListener(new WriggleGuideAnimationView.z() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.js.1
            @Override // com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView.z
            public void z() {
                if (wriggleProgressIv != null) {
                    if (js.this.g != null) {
                        js.this.g.setOnClickListener((View.OnClickListener) dynamicClickListener);
                        js.this.g.performClick();
                    }
                    if (js.this.gc == null || !js.this.gc.f()) {
                        return;
                    }
                    js.this.g.setOnClickListener(null);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.e
    public void z() {
        this.g.z();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.e
    public void g() {
        this.g.clearAnimation();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public WriggleGuideAnimationView dl() {
        return this.g;
    }
}
