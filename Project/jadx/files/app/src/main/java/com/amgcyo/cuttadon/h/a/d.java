package com.amgcyo.cuttadon.h.a;

import android.content.Context;
import android.text.TextUtils;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.utils.otherutils.n;

/* JADX INFO: compiled from: AdUtilsHeight.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public static final int a = n.a(60.0f);
    public static final int b = n.a(50.0f);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f3859c = n.a(400.0f);

    public static boolean a(BaseAd baseAd) {
        if (baseAd == null) {
            return false;
        }
        String platform = baseAd.getPlatform();
        int style = baseAd.getStyle();
        if (TextUtils.isEmpty(platform) || style <= 0) {
            return false;
        }
        byte b2 = -1;
        int iHashCode = platform.hashCode();
        if (iHashCode != -103418728) {
            if (iHashCode != 3302) {
                if (iHashCode != 3432) {
                    if (iHashCode != 3526476) {
                        if (iHashCode == 1061735899 && platform.equals("csj_new")) {
                            b2 = 2;
                        }
                    } else if (platform.equals("self")) {
                        b2 = 0;
                    }
                } else if (platform.equals("ks")) {
                    b2 = 1;
                }
            } else if (platform.equals("gm")) {
                b2 = 4;
            }
        } else if (platform.equals("gdt_new")) {
            b2 = 3;
        }
        if (b2 == 0) {
            return 3 == style;
        }
        if (b2 == 1) {
            return 5 == style || 8 == style;
        }
        if (b2 == 2) {
            return 5 == style || 8 == style;
        }
        if (b2 == 3) {
            return 8 == style || 9 == style;
        }
        if (b2 != 4) {
            return false;
        }
        return 5 == style || 6 == style;
    }

    public static boolean b(BaseAd baseAd) {
        if (baseAd == null) {
            return false;
        }
        return "self".equals(baseAd.getPlatform());
    }

    public static int a(Context context, String str, int i2) {
        float f2;
        float f3;
        int iA = a(context);
        if (!TextUtils.isEmpty(str) && i2 > 0) {
            if ("self".equals(str)) {
                if (2 == i2 || 7 == i2) {
                    int iA2 = g0.a().a("kloiejf", iA);
                    String str2 = "spHeight:" + iA2 + " bottom_adHeight:" + iA;
                    iA = Math.max(iA2, iA);
                }
            }
            String str3 = str + " " + i2;
            if ("gm".equals(str) || "topon_new".equals(str)) {
                int iC = n.c(context);
                if (i2 == 3) {
                    f2 = iC;
                    f3 = 5.0f;
                } else if (i2 == 4 || i2 == 6 || i2 == 7) {
                    f2 = iC;
                    f3 = 6.7f;
                }
                iA = (int) (f2 / f3);
            }
            String str4 = "最终的底部广告高度为：" + iA;
        }
        return iA;
    }

    public static int a(Context context) {
        return Math.round(n.c(context) / 5.8f);
    }
}
