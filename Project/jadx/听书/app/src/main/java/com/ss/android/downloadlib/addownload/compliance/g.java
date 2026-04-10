package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.wp;
import com.ss.android.downloadlib.e.dl;
import com.ss.android.downloadlib.e.i;
import com.ss.android.z.z.g.q;
import com.umeng.analytics.pro.an;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class g {
    private SoftReference<Activity> z;

    private static class z {
        private static g z = new g();
    }

    public static g z() {
        return z.z;
    }

    private g() {
    }

    public void z(long j) {
        TTDelegateActivity.z(j);
    }

    public boolean z(com.ss.android.z.z.dl.dl dlVar) {
        if (!dlVar.io() || wp.fo().optInt("ad_lp_show_app_dialog") == 0) {
            return false;
        }
        String strZ = dlVar.l() == null ? null : dlVar.l().z();
        return (TextUtils.isEmpty(strZ) || Pattern.compile(wp.fo().optString("ad_allow_web_url_regex", ".+(www.chengzijianzhan.com|www.toutiaopage.com/tetris/page|ad.toutiao.com/tetris/page).+")).matcher(strZ).matches()) ? false : true;
    }

    public boolean z(com.ss.android.downloadlib.addownload.g.gc gcVar) {
        long jZ;
        long j;
        if (!TextUtils.isEmpty(gcVar.g.uf())) {
            try {
                jZ = i.z(new JSONObject(gcVar.g.uf()), "convert_id");
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.z(e);
                jZ = 0;
            }
            if (jZ <= 0) {
                e.z(3, gcVar);
            }
            j = jZ;
        } else {
            e.z(9, gcVar);
            com.ss.android.downloadlib.gc.dl.z().z("requestAppInfo getLogExtra null");
            j = 0;
        }
        final long j2 = gcVar.z;
        com.ss.android.downloadlib.addownload.g.g gVarZ = dl.z().z(j, j2);
        if (gVarZ != null) {
            a.z().z(gVarZ.z(), j2, gVarZ.f1986a);
            z(gVarZ.z());
            e.z("lp_app_dialog_try_show", gcVar);
            return true;
        }
        StringBuilder sb = new StringBuilder();
        if (j > 0) {
            sb.append("convert_id=").append(j);
        }
        if (!TextUtils.isEmpty(gcVar.g.sy())) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("package_name=").append(gcVar.g.sy());
        }
        if (sb.length() <= 0) {
            e.z(6, gcVar);
            return false;
        }
        final long j3 = j;
        com.ss.android.downloadlib.e.dl.z((dl.z<String, R>) new dl.z<String, Boolean>() { // from class: com.ss.android.downloadlib.addownload.compliance.g.2
            @Override // com.ss.android.downloadlib.e.dl.z
            public Boolean z(String str) {
                final boolean[] zArr = {false};
                wp.a().z("GET", str, new HashMap(), new q() { // from class: com.ss.android.downloadlib.addownload.compliance.g.2.1
                    @Override // com.ss.android.z.z.g.q
                    public void z(String str2) {
                        zArr[0] = g.this.z(j3, j2, str2);
                    }

                    @Override // com.ss.android.z.z.g.q
                    public void z(Throwable th) {
                        e.z(2, j2);
                        zArr[0] = false;
                    }
                });
                return Boolean.valueOf(zArr[0]);
            }
        }, "https://apps.oceanengine.com/customer/api/app/pkg_info?" + sb.toString()).z(new dl.z<Boolean, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.g.1
            @Override // com.ss.android.downloadlib.e.dl.z
            public Object z(Boolean bool) {
                if (bool.booleanValue()) {
                    g.this.z(com.ss.android.downloadlib.addownload.g.g.z(j3, j2));
                    e.g("lp_app_dialog_try_show", j2);
                    return null;
                }
                g.this.g(j2);
                return null;
            }
        }).z();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z(long j, long j2, String str) {
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("package");
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() != 0) {
                com.ss.android.downloadlib.addownload.g.g gVar = new com.ss.android.downloadlib.addownload.g.g();
                gVar.z = j;
                gVar.g = j2;
                gVar.f1986a = jSONObjectOptJSONObject.optString("icon_url");
                gVar.gc = jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.APP_NAME);
                gVar.dl = jSONObjectOptJSONObject.optString(an.o);
                gVar.m = jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
                gVar.e = jSONObjectOptJSONObject.optString("developer_name");
                gVar.fo = jSONObjectOptJSONObject.optString("policy_url");
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("permissions");
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObject = (JSONObject) jSONArrayOptJSONArray.get(i);
                        gVar.gz.add(new Pair<>(jSONObject.optString("permission_name"), jSONObject.optString("permission_desc")));
                    }
                }
                dl.z().z(gVar);
                a.z().z(gVar.z(), j2, gVar.f1986a);
                return true;
            }
            e.z(7, j2);
            return false;
        } catch (Exception e) {
            com.ss.android.downloadlib.gc.dl.z().z(e, "AdLpComplianceManager parseResponse");
            e.z(7, j2);
            return false;
        }
    }

    public void g(long j) {
        com.ss.android.downloadlib.addownload.gc gcVarZ = com.ss.android.downloadlib.gz.z().z(com.ss.android.downloadlib.addownload.g.m.z().gc(j).g.z());
        if (gcVarZ != null) {
            gcVarZ.z(true, true);
        } else {
            e.z(11, j);
            com.ss.android.downloadlib.gc.dl.z().g("startDownload handler null");
        }
    }

    public void z(Activity activity) {
        this.z = new SoftReference<>(activity);
    }

    public Activity g() {
        Activity activity = this.z.get();
        this.z = null;
        return activity;
    }
}
