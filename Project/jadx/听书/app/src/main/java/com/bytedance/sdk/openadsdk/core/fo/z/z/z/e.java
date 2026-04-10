package com.bytedance.sdk.openadsdk.core.fo.z.z.z;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.text.TextUtils;
import androidx.media3.common.C;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tb;
import com.bytedance.sdk.openadsdk.core.uy;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e implements com.bytedance.sdk.openadsdk.core.fo.z.z.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1058a;
    private na dl;
    private Context g;
    private com.bytedance.sdk.openadsdk.core.iq.gc z;

    public e(com.bytedance.sdk.openadsdk.core.iq.gc gcVar, Context context) {
        this.z = gcVar;
        this.g = context;
    }

    public void z(na naVar) {
        this.dl = naVar;
    }

    public void z(String str) {
        this.f1058a = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.fo.z.z.z
    public boolean z(Map<String, Object> map) {
        return z();
    }

    private boolean z() {
        com.bytedance.sdk.openadsdk.core.iq.gc gcVar = this.z;
        if (gcVar == null) {
            return false;
        }
        String strZ = gcVar.z();
        if (tb.m(this.dl) != 3 || TextUtils.isEmpty(strZ)) {
            return false;
        }
        boolean zG = g(strZ);
        if (zG) {
            g();
        } else {
            z(false);
        }
        return zG;
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.bytedance.sdk.openadsdk.core.fo.z.z.z.e$1] */
    private void g() {
        new CountDownTimer(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS) { // from class: com.bytedance.sdk.openadsdk.core.fo.z.z.z.e.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (uy.ls() == null || uy.ls().z()) {
                    e.this.z(true);
                } else {
                    e.this.z(false);
                }
            }
        }.start();
    }

    public boolean g(String str) {
        if (this.g == null) {
            return false;
        }
        try {
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(268435456);
            intent.putExtra("open_url", str);
            com.bytedance.sdk.component.utils.g.startActivity(this.g, intent, TextUtils.equals("main", UMModuleRegister.INNER));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z) {
        if (z) {
            com.bytedance.sdk.openadsdk.core.i.a.g(this.dl, this.f1058a, "quickapp_success");
        } else {
            com.bytedance.sdk.openadsdk.core.i.a.g(this.dl, this.f1058a, "quickapp_fail");
        }
    }
}
