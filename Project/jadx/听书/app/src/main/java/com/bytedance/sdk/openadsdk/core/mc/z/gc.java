package com.bytedance.sdk.openadsdk.core.mc.z;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.tb;
import com.bytedance.sdk.openadsdk.core.un.uy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    private static final List<String> z = new ArrayList(Arrays.asList("1", "3", "2"));

    public static String z(String str) {
        str.hashCode();
        switch (str) {
            case "46000":
            case "46002":
            case "46004":
            case "46007":
            case "46008":
                return "1";
            case "46001":
            case "46006":
            case "46009":
                return "2";
            case "46003":
            case "46005":
            case "46011":
                return "3";
            default:
                return "0";
        }
    }

    public static String z() {
        String strA = uy.a();
        String strGc = uy.gc();
        String strV = tb.v();
        String strLs = tb.ls();
        if (!tb.wp()) {
            return "5";
        }
        if (TextUtils.isEmpty(strA) || TextUtils.isEmpty(strGc)) {
            return (TextUtils.isEmpty(strV) || TextUtils.isEmpty(strLs)) ? "4" : z(strV + strLs);
        }
        if (TextUtils.isEmpty(strV) || TextUtils.isEmpty(strLs)) {
            return z(strA + strGc);
        }
        String strZ = z(strA + strGc);
        String strZ2 = z(strV + strLs);
        List<String> list = z;
        return (list.contains(strZ) && list.contains(strZ2) && !strZ2.equals(strZ)) ? "6" : list.contains(strZ) ? strZ : list.contains(strZ2) ? strZ2 : "0";
    }
}
