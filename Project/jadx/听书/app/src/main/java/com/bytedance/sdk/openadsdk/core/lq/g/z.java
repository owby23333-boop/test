package com.bytedance.sdk.openadsdk.core.lq.g;

import android.content.Context;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.bytedance.sdk.component.utils.kb;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.lq.a;
import com.bytedance.sdk.openadsdk.core.lq.g;
import com.bytedance.sdk.openadsdk.core.lq.gz;
import com.bytedance.sdk.openadsdk.core.lq.m;
import com.bytedance.sdk.openadsdk.core.mc.z.gc;
import com.bytedance.sdk.openadsdk.core.tb;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.hh.e;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1254a;
    private Context dl;
    private SSWebView g;
    na z;
    private int gc = 1;
    private int m = -3;
    private int e = -1;

    static /* synthetic */ int dl(z zVar) {
        int i = zVar.gc;
        zVar.gc = i + 1;
        return i;
    }

    public z(SSWebView sSWebView, Context context, int i, na naVar) {
        this.g = sSWebView;
        this.dl = context;
        this.f1254a = i;
        this.z = naVar;
    }

    @JavascriptInterface
    public int getNetOperatorType() {
        wp.z("transmit_TTWifiObject", "getNetOperatorType PhoneNumStatus:" + this.f1254a);
        final int iG = g();
        if (iG == -1 || iG == -2) {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            e.z(new fo("getNetOperatorType") { // from class: com.bytedance.sdk.openadsdk.core.lq.g.z.1
                @Override // java.lang.Runnable
                public void run() {
                    z.this.z(-1, System.currentTimeMillis() - jCurrentTimeMillis, false, "获取运行商类型为-1或-2,直接标记取号失败", iG, z.this.gc);
                }
            });
        }
        wp.z("transmit_TTWifiObject", "getNetOperatorType type:".concat(String.valueOf(iG)));
        return iG;
    }

    @JavascriptInterface
    public String sendNetworkSwitch(final String str) {
        Context context;
        wp.z("transmit_TTWifiObject", "send_switch PhoneNumStatus:" + this.f1254a + "  params:" + str);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.f1254a <= 0) {
            JSONObject jSONObject = new JSONObject();
            if (this.e == -1 && (context = this.dl) != null) {
                this.e = m.z(context, m.z(context));
            }
            try {
                jSONObject.put("data", "没有wifi网络下获取手机号权限");
                jSONObject.put("networkType", this.e);
            } catch (JSONException unused) {
            }
            SSWebView sSWebView = this.g;
            if (sSWebView != null) {
                kb.z(sSWebView, "javascript:receiveNetworkSwitch(" + jSONObject + ")");
            }
            z(-1, System.currentTimeMillis() - jCurrentTimeMillis, false, "没有wifi网络下获取手机号权限", -1, this.gc);
            return "";
        }
        e.z(new fo("send_network_switch") { // from class: com.bytedance.sdk.openadsdk.core.lq.g.z.2
            @Override // java.lang.Runnable
            public void run() {
                int iG;
                try {
                    iG = new JSONObject(str).optInt("operType");
                } catch (JSONException e) {
                    wp.z(e);
                    iG = -3;
                }
                if (iG != 1 && iG != 2 && iG != 3) {
                    iG = z.this.g();
                }
                final int i = iG;
                if (i != 3 || z.this.m != 3) {
                    z.this.gc = 1;
                } else {
                    z.dl(z.this);
                }
                z.this.m = i;
                if (z.this.dl == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("data", "取号失败，context is null");
                        jSONObject2.put("networkType", 0);
                    } catch (JSONException unused2) {
                    }
                    if (z.this.g != null) {
                        kb.z(z.this.g, "javascript:receiveNetworkSwitch(" + jSONObject2 + ")");
                    }
                    z.this.z(-1, System.currentTimeMillis() - jCurrentTimeMillis, false, "context is null", i, z.this.gc);
                    return;
                }
                new gz(z.this.dl, new g()).z(str, new a() { // from class: com.bytedance.sdk.openadsdk.core.lq.g.z.2.1
                    @Override // com.bytedance.sdk.openadsdk.core.lq.a
                    public void z(boolean z, int i2, int i3, String str2, Map<String, List<String>> map, String str3) {
                        wp.z("transmit_TTWifiObject", "TransmitBusiness_onResponse s : " + z + " code:" + i3 + " msg:" + str2 + "  body:" + str3);
                        if (TextUtils.isEmpty(str3)) {
                            wp.z("transmit_TTWifiObject", "TransmitBusiness_onResponse body is null and code:".concat(String.valueOf(i3)));
                        }
                        if (z) {
                            str2 = "取号成功";
                        } else if (TextUtils.isEmpty(str2)) {
                            str2 = "取号失败";
                        }
                        z.this.z(i2, System.currentTimeMillis() - jCurrentTimeMillis, z, str2, i, z.this.gc);
                        JSONObject jSONObject3 = new JSONObject();
                        if (str3 == null) {
                            str3 = "";
                        }
                        try {
                            jSONObject3.put("data", str3);
                            jSONObject3.put("networkType", i2);
                        } catch (JSONException unused3) {
                        }
                        if (z.this.g != null) {
                            kb.z(z.this.g, "javascript:receiveNetworkSwitch(" + jSONObject3 + ")");
                        }
                    }
                });
            }
        });
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final int i, final long j, final boolean z, final String str, final int i2, final int i3) {
        wp.z("transmit_TTWifiObject", "TTWifiObject sendWifiEvent duration:" + j + "  networkType:" + i + "   s:" + z + "  detailInfo:" + str + " simType:" + i2 + "  redirectTime:" + i3);
        com.bytedance.sdk.openadsdk.core.i.a.z(this.z, "wifi_auth", "click_other", new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.lq.g.z.3
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", j);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("wifi_auth_referer", "huoshan_JSSDK");
                jSONObject2.putOpt("wifi_auth_network_type", Integer.valueOf(i));
                jSONObject2.putOpt("wifi_auth_duration", Long.valueOf(j));
                jSONObject2.putOpt("wifi_auth_status", z ? "success" : "failure");
                String str2 = str;
                if (str2 == null) {
                    str2 = "";
                }
                jSONObject2.putOpt("wifi_auth_detail_info", str2);
                jSONObject2.putOpt("wifi_auth_carrier", Integer.valueOf(i2));
                jSONObject2.putOpt("wifi_auth_redirect_time", Integer.valueOf(i3));
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static String z() {
        TelephonyManager telephonyManagerZ;
        try {
            com.bytedance.sdk.openadsdk.ls.dl.dl.a aVarP = uy.ls().p();
            if ((aVarP == null || aVarP.dl()) && (telephonyManagerZ = tb.z()) != null) {
                return telephonyManagerZ.createForSubscriptionId(SubscriptionManager.getDefaultDataSubscriptionId()).getSimOperator();
            }
            return null;
        } catch (Exception e) {
            wp.a("transmit_TTWifiObject", " getActiveSimOperator error :" + e.toString());
            return null;
        }
    }

    public int g() {
        int i = this.f1254a;
        if (i <= 0) {
            return -1;
        }
        Context context = this.dl;
        if (context == null || i == 1) {
            return -3;
        }
        int iZ = m.z(context, m.z(context));
        this.e = iZ;
        if (iZ == 0 || iZ == 2) {
            return -2;
        }
        String strZ = gc.z(z());
        strZ.hashCode();
        switch (strZ) {
            case "1":
                return 1;
            case "2":
                return 3;
            case "3":
                return 2;
            default:
                return -3;
        }
    }
}
