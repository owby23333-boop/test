package com.bytedance.sdk.openadsdk.core.widget;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.widget.dl;
import com.bytedance.sdk.openadsdk.core.zw;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class i extends dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ugeno.e.e f1419a;
    Window dl;
    private volatile boolean e;
    private JSONObject gc;
    private boolean gz;
    private com.bytedance.sdk.openadsdk.core.ugeno.gz m;

    @Override // com.bytedance.sdk.openadsdk.core.widget.dl
    protected void g() {
    }

    public i(Activity activity, JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.ugeno.e.e eVar) {
        super(activity);
        this.dl = activity == null ? null : activity.getWindow();
        this.gc = jSONObject;
        this.f1419a = eVar;
        this.m = new com.bytedance.sdk.openadsdk.core.ugeno.gz(activity);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.dl, android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.dl
    public void z() {
        if (this.z == null) {
            this.z = zw.getContext();
        }
        if (this.z.getResources().getConfiguration().orientation != 1) {
            this.gz = true;
            super.z();
            super.g();
            e();
            return;
        }
        gc();
        m();
    }

    private void gc() {
        if (this.dl != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1);
            this.dl.setBackgroundDrawable(gradientDrawable);
            WindowManager.LayoutParams attributes = this.dl.getAttributes();
            attributes.alpha = 1.0f;
            this.dl.setAttributes(attributes);
        }
    }

    private void m() {
        JSONObject jSONObject = this.gc;
        if (jSONObject == null || this.f1419a == null) {
            return;
        }
        JSONObject jSONObjectZ = com.bytedance.sdk.openadsdk.core.ugeno.uy.z(jSONObject.remove("ugen_url").toString(), this.gc.remove("ugen_md5").toString(), (com.bytedance.sdk.openadsdk.core.ugeno.dl) null);
        if (jSONObjectZ == null) {
            this.f1419a.z(11, "uegnTemplate is empty");
            this.e = true;
        } else {
            final FrameLayout frameLayout = new FrameLayout(this.z);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.m.z(jSONObjectZ, this.gc, new com.bytedance.sdk.openadsdk.core.ugeno.e.e() { // from class: com.bytedance.sdk.openadsdk.core.widget.i.1
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.e
                public void z(int i, String str) {
                    i.this.e = true;
                    if (i.this.f1419a != null) {
                        FrameLayout frameLayout2 = frameLayout;
                        if (frameLayout2 != null) {
                            frameLayout2.removeAllViews();
                        }
                        i.this.f1419a.z(i, str);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.e
                public void z(com.bytedance.adsdk.ugeno.g.dl<View> dlVar) {
                    i.this.e = false;
                    if (i.this.f1419a != null) {
                        i.this.f1419a.z(null);
                    }
                    frameLayout.addView(dlVar.fo(), new FrameLayout.LayoutParams(dlVar.mc(), dlVar.un()));
                    i.this.setContentView(frameLayout);
                }
            });
        }
    }

    private void e() {
        JSONObject jSONObject = this.gc;
        if (jSONObject == null) {
            return;
        }
        z(jSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.APP_NAME));
        gc(this.gc.optString("app_version"));
        m(this.gc.optString("reg_number"));
        e(this.gc.optString("reg_url"));
        g(this.gc.optString("icon_url"));
        gz(this.gc.optString("developer_name"));
        z(this.gc.optInt("score"));
        z(this.gc.optJSONArray("creative_tags"));
        a(this.gc.optString("description"));
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.dl
    protected void dl() {
        if (this.gz) {
            super.dl();
        }
    }

    public void g(dl.z zVar) {
        super.z(zVar);
        com.bytedance.sdk.openadsdk.core.ugeno.gz gzVar = this.m;
        if (gzVar != null) {
            gzVar.z(zVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.dl, android.app.Dialog
    public void show() {
        super.show();
        if (this.e) {
            hide();
            dismiss();
        }
    }
}
