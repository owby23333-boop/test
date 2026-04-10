package com.bytedance.sdk.openadsdk.pf;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.uy;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private String dl;
    public String g;
    public String z;

    private dl() {
    }

    private static class z {
        private static dl z = new dl();
    }

    public static dl z() {
        return z.z;
    }

    public String g() {
        Map<String, Object> mapUy;
        try {
            mapUy = uy();
        } catch (Exception e) {
            wp.z(e);
        }
        if (mapUy == null) {
            dl(null);
            return null;
        }
        Object obj = mapUy.get("motion_info");
        if (obj instanceof String) {
            if (TextUtils.equals("0", (String) obj)) {
                dl("0");
                return "0";
            }
            dl("1");
            return "1";
        }
        dl(null);
        return null;
    }

    private String fo() {
        Map<String, Object> mapUy = uy();
        if (mapUy == null) {
            return null;
        }
        Object obj = mapUy.get("od");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public String dl() {
        Map<String, Object> mapUy = uy();
        if (mapUy == null) {
            return null;
        }
        Object obj = mapUy.get("blt");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public void a() {
        if (kb()) {
            String strFo = fo();
            if (TextUtils.equals(strFo, this.z)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.live.g.z().z("setOaidEnabled", z(strFo));
            this.z = strFo;
        }
    }

    public boolean gc() {
        return !TextUtils.equals(g(), "0");
    }

    public boolean m() {
        if (kb()) {
            return z(fo());
        }
        return true;
    }

    public boolean e() {
        Map<String, Object> mapUy = uy();
        if (mapUy != null) {
            Object obj = mapUy.get("mcod");
            if (obj instanceof String) {
                String str = (String) obj;
                this.g = str;
                return !TextUtils.equals(str, "0");
            }
        }
        return true;
    }

    public boolean gz() {
        return g(dl());
    }

    private Map<String, Object> uy() {
        com.bytedance.sdk.openadsdk.ls.dl.dl.a aVarP;
        if (gk.dl >= 6408 && (aVarP = uy.ls().p()) != null) {
            return aVarP.pf();
        }
        return null;
    }

    private boolean z(String str) {
        return !TextUtils.equals(str, "0");
    }

    private boolean g(String str) {
        return !TextUtils.equals(str, "0");
    }

    private void dl(String str) {
        if (!TextUtils.equals(this.dl, str)) {
            com.bytedance.sdk.openadsdk.core.live.g.z().z("setSensorEnable", !TextUtils.equals(str, "0"));
        }
        this.dl = str;
    }

    private boolean kb() {
        String strQ = uy.ls().q();
        if (TextUtils.isEmpty(strQ)) {
            return false;
        }
        strQ.hashCode();
        switch (strQ) {
        }
        return false;
    }
}
