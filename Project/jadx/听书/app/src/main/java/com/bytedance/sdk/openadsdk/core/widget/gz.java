package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.widget.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gz extends AlertDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e.z f1418a;
    private Context dl;
    private com.bytedance.sdk.openadsdk.core.ugeno.e.e e;
    private JSONObject g;
    private String gc;
    private boolean gz;
    private com.bytedance.sdk.openadsdk.core.ugeno.z m;
    private JSONObject z;

    public gz(String str, Context context, JSONObject jSONObject, JSONObject jSONObject2, com.bytedance.sdk.openadsdk.core.ugeno.e.e eVar, na naVar) {
        super(context, tb.gz(context, "tt_dialog_full"));
        this.e = eVar;
        this.dl = context;
        this.z = jSONObject;
        this.gc = str;
        this.g = jSONObject2;
        this.m = new com.bytedance.sdk.openadsdk.core.ugeno.z(context, naVar);
    }

    public String z() {
        return this.gc;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.gz) {
            hide();
            dismiss();
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        e.z zVar = this.f1418a;
        if (zVar != null) {
            zVar.dl(this);
        }
    }

    public void z(e.z zVar) {
        this.f1418a = zVar;
        com.bytedance.sdk.openadsdk.core.ugeno.z zVar2 = this.m;
        if (zVar2 != null) {
            zVar2.z(zVar);
        }
    }

    public void z(com.bytedance.sdk.openadsdk.core.ugeno.e.e eVar) {
        this.e = eVar;
    }

    private void g() {
        if (this.z == null || this.g == null || this.m == null) {
            return;
        }
        this.gz = false;
        final FrameLayout frameLayout = new FrameLayout(this.dl);
        this.m.z(this.z, this.g, new com.bytedance.sdk.openadsdk.core.ugeno.e.e() { // from class: com.bytedance.sdk.openadsdk.core.widget.gz.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.e
            public void z(int i, String str) {
                gz.this.gz = true;
                if (gz.this.e != null) {
                    FrameLayout frameLayout2 = frameLayout;
                    if (frameLayout2 != null) {
                        frameLayout2.removeAllViews();
                    }
                    gz.this.e.z(i, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.e
            public void z(com.bytedance.adsdk.ugeno.g.dl<View> dlVar) {
                gz.this.gz = false;
                if (gz.this.e != null) {
                    gz.this.e.z(null);
                }
                frameLayout.addView(dlVar.fo(), new FrameLayout.LayoutParams(dlVar.mc(), dlVar.un()));
                gz.this.setContentView(frameLayout);
            }
        });
    }
}
