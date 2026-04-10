package com.bytedance.msdk.api.a;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    private Map<String, String> gz;
    public final String z = "TTMediationSDK";
    private String g = "";
    private String dl = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f351a = "";
    private int gc = 0;
    private String m = "";
    private String e = "";

    public void z(Map<String, String> map) {
        this.gz = new HashMap();
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                if (!m(entry.getKey())) {
                    com.bytedance.sdk.component.utils.wp.a("TTMediationSDK", "流量分组" + entry.getKey() + "字段存在不合法输入");
                } else if (!m(entry.getValue())) {
                    com.bytedance.sdk.component.utils.wp.a("TTMediationSDK", "流量分组" + entry.getKey() + "字段的值" + entry.getValue() + "存在不合法输入");
                } else {
                    this.gz.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public Map<String, String> z() {
        return this.gz;
    }

    public String g() {
        return this.g;
    }

    public void z(String str) {
        if (m(str)) {
            this.g = str;
        } else {
            com.bytedance.sdk.component.utils.wp.a("TTMediationSDK", "流量分组user_id字段存在不合法输入");
        }
    }

    public String dl() {
        return this.dl;
    }

    public void g(String str) {
        if (m(str)) {
            this.dl = str;
        } else {
            com.bytedance.sdk.component.utils.wp.a("TTMediationSDK", "流量分组channer字段存在不合法输入");
        }
    }

    public String a() {
        return this.f351a;
    }

    public void dl(String str) {
        if (m(str)) {
            this.f351a = str;
        } else {
            com.bytedance.sdk.component.utils.wp.a("TTMediationSDK", "流量分组sub_channer字段存在不合法输入");
        }
    }

    public int gc() {
        return this.gc;
    }

    public void z(int i) {
        this.gc = i;
    }

    public String m() {
        return this.m;
    }

    public void a(String str) {
        if (m(str)) {
            this.m = str;
        } else {
            com.bytedance.sdk.component.utils.wp.a("TTMediationSDK", "流量分组gender字段存在不合法输入");
        }
    }

    public String e() {
        return this.e;
    }

    public void gc(String str) {
        if (m(str)) {
            this.e = str;
        } else {
            com.bytedance.sdk.component.utils.wp.a("TTMediationSDK", "流量分组user_value_group字段存在不合法输入");
        }
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            m mVar = (m) obj;
            boolean z2 = gc() == mVar.gc() && TextUtils.equals(e(), mVar.e()) && TextUtils.equals(g(), mVar.g()) && TextUtils.equals(dl(), mVar.dl()) && TextUtils.equals(a(), mVar.a()) && TextUtils.equals(m(), mVar.m());
            Map<String, String> mapZ = mVar.z();
            Map<String, String> map = this.gz;
            if (map != null && mapZ != null) {
                if (map.size() == mapZ.size()) {
                    for (String str : this.gz.keySet()) {
                        if (TextUtils.isEmpty(str) || TextUtils.equals(this.gz.get(str), mapZ.get(str))) {
                        }
                    }
                    z = true;
                }
                z = false;
                break;
            }
            if (map != null || mapZ != null) {
                z = false;
                break;
            }
            z = true;
            if (z2 && z) {
                return true;
            }
        }
        return false;
    }

    public static boolean m(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[A-Za-z0-9-_]{1,100}");
    }
}
