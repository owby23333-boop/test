package com.bytedance.msdk.core.fo;

import android.text.TextUtils;
import com.bytedance.msdk.gz.l;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.z.g.e;
import com.funny.audio.core.utils.FileUtils;
import com.kuaishou.weapon.p0.t;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z {
    protected final l g;
    protected final Map<String, String> z = new HashMap();

    public static String z(int i) {
        switch (i) {
            case 1:
                return MediationConstant.RIT_TYPE_BANNER;
            case 2:
                return MediationConstant.RIT_TYPE_INTERSTITIAL;
            case 3:
            case 4:
                return MediationConstant.RIT_TYPE_SPLASH;
            case 5:
                return "native";
            case 6:
            default:
                return null;
            case 7:
                return MediationConstant.RIT_TYPE_REWARD_VIDEO;
            case 8:
                return "fullscreenVideo";
            case 9:
                return MediationConstant.RIT_TYPE_DRAW;
            case 10:
                return MediationConstant.RIT_TYPE_INTERSTITIAL_FULL;
        }
    }

    protected abstract boolean g(String str, JSONObject jSONObject, Map<String, Object> map);

    protected abstract Map<String, String> z();

    protected abstract JSONObject z(com.bytedance.msdk.core.uy.dl dlVar);

    protected abstract void z(String str, int i, String str2);

    protected abstract void z(String str, String str2);

    public z(String str) {
        this.g = l.z(str, com.bytedance.msdk.core.g.getContext());
        dl();
    }

    protected void z(int i, String str, int i2, double d) {
        if (i2 == 1) {
            z(i, str, d);
        } else if (i2 == 3) {
            g(i, str, d);
        } else if (i2 == 2) {
            dl(i, str, d);
        }
    }

    protected double z(int i, String str, int i2) {
        if (i2 == 1) {
            return BigDecimal.valueOf(Double.parseDouble(z(i, str))).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        if (i2 == 3) {
            return BigDecimal.valueOf(Double.parseDouble(g(i, str))).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        if (i2 == 2) {
            return BigDecimal.valueOf(Double.parseDouble(dl(i, str))).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        return 0.0d;
    }

    public void z(double d, double d2, String str, String str2) {
        if (this.g == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        z(str, "_last_post_cpm_", str2, d);
        z(str, "_last_bidding_cpm_", str2, d2);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0142  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double[] z(int r18, double r19, double r21, java.lang.String r23, java.lang.String r24) {
        /*
            Method dump skipped, instruction units count: 356
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.fo.z.z(int, double, double, java.lang.String, java.lang.String):double[]");
    }

    protected void z(String str, String str2, String str3, double d) {
        this.g.z(str + str2, str3 + "_" + d);
    }

    protected void g() {
        Map<String, ?> mapG = this.g.g();
        if (mapG != null) {
            for (Map.Entry<String, ?> entry : mapG.entrySet()) {
                if (entry != null) {
                    z(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
                }
            }
        }
    }

    private synchronized void z(int i, String str, double d) {
        String str2 = "label_size_" + str;
        int iG = this.g.g(str2, 0) + 1;
        String strZ = z(str, iG);
        String strZ2 = z(str, d);
        z(strZ, i, strZ2);
        this.g.z(strZ, strZ2);
        this.g.z(str2, iG);
    }

    private String z(int i, String str) {
        if (TextUtils.isEmpty(str) || i != 3) {
            return "0";
        }
        double[] dArr = new double[2];
        Iterator<Map.Entry<String, String>> it = z().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if (next != null) {
                String value = next.getValue();
                if (!TextUtils.isEmpty(value) && value.contains(str)) {
                    String[] strArrSplit = value.split("_");
                    String str2 = strArrSplit[0];
                    String str3 = strArrSplit[1];
                    String str4 = strArrSplit[2];
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                        if (com.bytedance.msdk.core.g.g().z(System.currentTimeMillis() - Long.parseLong(str4))) {
                            dArr[0] = dArr[0] + 1.0d;
                            dArr[1] = dArr[1] + Double.parseDouble(str3);
                        } else {
                            it.remove();
                            this.g.m(next.getKey());
                            String str5 = "label_size_" + str;
                            l lVar = this.g;
                            lVar.z(str5, lVar.dl(str5) - 1);
                        }
                    }
                }
            }
        }
        return z(dArr);
    }

    private void g(int i, String str, double d) {
        if (TextUtils.isEmpty(str) || i != 3) {
            return;
        }
        this.g.z(str, d + "_" + System.currentTimeMillis());
        z(str);
    }

    public void z(String str) {
        for (int iDl = this.g.dl("label_size_" + str); iDl > 0; iDl--) {
            try {
                String strZ = z(str, iDl);
                this.g.m(strZ);
                z().remove(strZ);
            } catch (Throwable th) {
                com.bytedance.msdk.z.gc.dl.a("CalculateLabelValueImpl", "clearFromSpByRit,ignore:" + th.toString());
            }
        }
    }

    private String z(String str, int i) {
        return "cpm_key_" + str + "_" + i;
    }

    private String g(int i, String str) {
        if (!TextUtils.isEmpty(str) && i == 3) {
            String strG = this.g.g(str);
            if (!TextUtils.isEmpty(strG) && !"0".equals(strG)) {
                String[] strArrSplit = strG.split("_");
                String str2 = strArrSplit[0];
                String str3 = strArrSplit[1];
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    if (com.bytedance.msdk.core.g.g().z(System.currentTimeMillis() - Long.parseLong(str3))) {
                        return str2;
                    }
                    this.g.m(str);
                }
            }
        }
        return "0";
    }

    private String z(String str, double d) {
        return str + "_" + d + "_" + System.currentTimeMillis();
    }

    private void dl(int i, String str, double d) {
        if (TextUtils.isEmpty(str) || i != 3) {
            return;
        }
        this.g.z(str, d + "_" + System.currentTimeMillis());
        z(str);
    }

    private String dl(int i, String str) {
        if (!TextUtils.isEmpty(str) && i == 3) {
            String strG = this.g.g(str);
            if (!TextUtils.isEmpty(strG) && !"0".equals(strG)) {
                String[] strArrSplit = strG.split("_");
                String str2 = strArrSplit[0];
                String str3 = strArrSplit[1];
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    if (str3.matches("[0-9]+")) {
                        try {
                            if (com.bytedance.msdk.core.g.g().z(System.currentTimeMillis() - Long.parseLong(str3))) {
                                return str2;
                            }
                            this.g.m(str);
                        } catch (NumberFormatException unused) {
                            this.g.m(str);
                            e.z("自定义上报 saveTime format exception valueTimestamp " + strG);
                        }
                    } else {
                        this.g.m(str);
                        e.z("自定义上报 saveTime is not number valueTimestamp " + strG);
                    }
                }
            }
        }
        return "0";
    }

    public String z(double[] dArr) {
        double d = dArr[0];
        return d != 0.0d ? new BigDecimal(dArr[1] / d).setScale(2, RoundingMode.HALF_UP).toString() : "-1.0";
    }

    protected void dl() {
        this.z.put("0", "a");
        this.z.put("1", t.l);
        this.z.put("2", "c");
        this.z.put("3", "d");
        this.z.put("4", "e");
        this.z.put("5", "f");
        this.z.put("6", "g");
        this.z.put("7", "h");
        this.z.put(GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD, "i");
        this.z.put(GlobalSetting.UNIFIED_INTERSTITIAL_FS_AD, "j");
        this.z.put(FileUtils.FILE_EXTENSION_SEPARATOR, t.f1872a);
    }

    protected String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            sb.append(this.z.get(String.valueOf(c)));
        }
        return sb.toString();
    }

    protected void z(String str, JSONObject jSONObject, Map<String, Object> map) {
        if (!com.bytedance.msdk.core.g.g().y() || TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        if (g(str, jSONObject2, map == null ? new HashMap<>() : map)) {
            try {
                jSONObject.putOpt("label", jSONObject2);
                if (map == null || map.get("cost_time") == null) {
                    return;
                }
                jSONObject.put("uvalueExcTime", map.get("cost_time"));
            } catch (JSONException e) {
                wp.z(e);
            }
        }
    }
}
