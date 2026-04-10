package com.ss.android.downloadlib.addownload.compliance;

import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.wp;
import com.ss.android.z.z.g.q;
import com.umeng.analytics.pro.an;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class m {
    private final AtomicInteger z;

    private static class z {
        private static m z = new m();
    }

    public static m z() {
        return z.z;
    }

    private m() {
        this.z = new AtomicInteger(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String g() {
        return (this.z.get() < 3 ? "https://apps.bytesfield.com" : "https://apps.bytesfield-b.com").concat("/customer/api/app/deep_link");
    }

    public void z(final com.ss.android.downloadlib.addownload.g.gc gcVar, final gz gzVar) {
        if (wp.a() == null) {
            com.ss.android.downloadlib.gc.dl.z().z("getDownloadNetworkFactory == NULL");
            z(401, gcVar);
        } else {
            com.ss.android.downloadlib.gc.z().z(new Runnable() { // from class: com.ss.android.downloadlib.addownload.compliance.m.1
                @Override // java.lang.Runnable
                public void run() {
                    m mVar = m.this;
                    mVar.g(gcVar, mVar.g(), m.this.z(gcVar, true, 4), gzVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.ss.android.downloadlib.addownload.g.gc gcVar, String str, byte[] bArr, gz gzVar) {
        if (this.z.get() < 6) {
            this.z.incrementAndGet();
            g(gcVar, str, bArr, gzVar);
        } else {
            z("当前网络不佳，请稍后再试");
            this.z.set(0);
            z(402, gcVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(final com.ss.android.downloadlib.addownload.g.gc gcVar, final String str, final byte[] bArr, final gz gzVar) {
        wp.a().z(str, bArr, "application/json; charset=utf-8", 0, new q() { // from class: com.ss.android.downloadlib.addownload.compliance.m.2
            @Override // com.ss.android.z.z.g.q
            public void z(String str2) {
                m.this.z(gcVar, str2, gzVar);
            }

            @Override // com.ss.android.z.z.g.q
            public void z(Throwable th) {
                m.this.z(gcVar, str, bArr, gzVar);
            }
        });
    }

    private void z(final String str) {
        com.ss.android.downloadlib.gz.z().g().post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.compliance.m.3
            @Override // java.lang.Runnable
            public void run() {
                wp.dl().z(6, wp.getContext(), null, str, null, 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] z(com.ss.android.downloadlib.addownload.g.gc gcVar, boolean z2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("download_url", gcVar.z());
            jSONObject.put(an.o, gcVar.gc());
            jSONObject.put("call_scene", 50);
            if (z2) {
                jSONObject.put("sender_package_name", wp.getContext().getPackageName());
                jSONObject.put("sender_version", wp.uy().gc);
                if (i > 0) {
                    jSONObject.put("store", i);
                }
            } else {
                jSONObject.put("id", String.valueOf(gcVar.g()));
                if (gcVar.q().l() != null) {
                    if (TextUtils.isEmpty(gcVar.q().l().z())) {
                        com.ss.android.downloadlib.gc.dl.z().z("web_url is null");
                    }
                    jSONObject.put("web_url", gcVar.q().l().z());
                } else {
                    com.ss.android.downloadlib.gc.dl.z().z("deeplink is null");
                }
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.gc.dl.z().z("param build error");
        }
        return jSONObject.toString().getBytes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.ss.android.downloadlib.addownload.g.gc gcVar, String str, gz gzVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                com.ss.android.downloadlib.gc.dl.z().z("response content is null");
                z(404, gcVar);
                gzVar.z();
                return;
            }
            this.z.set(0);
            gc gcVarE = gc.e(str);
            if (gcVarE.z() != 0) {
                z(403, gcVar);
                gzVar.z();
            } else if (TextUtils.isEmpty(gcVarE.g())) {
                z(405, gcVar);
                gzVar.z();
            } else {
                gzVar.z(gcVarE.g());
            }
        } catch (Exception e) {
            com.ss.android.downloadlib.gc.dl.z().z(e, "DownloadMiuiMarketHelper parseResponse");
        }
    }

    public void z(int i, com.ss.android.downloadlib.addownload.g.gc gcVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_miui_market_fail_code", Integer.valueOf(i));
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        com.ss.android.downloadlib.a.z.z().z("get_miui_market_compliance_error", jSONObject, gcVar);
    }

    public void z(int i, com.ss.android.downloadlib.addownload.g.gc gcVar, JSONObject jSONObject) {
        try {
            jSONObject.putOpt("download_miui_market_success_result", Integer.valueOf(i));
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        com.ss.android.downloadlib.a.z.z().z("get_miui_market_compliance_success", jSONObject, gcVar);
    }
}
