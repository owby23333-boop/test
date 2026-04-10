package com.kwad.sdk.utils;

import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class bb {
    private static String baj;
    private static String bak;

    public static boolean Rk() {
        return hi("EMUI");
    }

    public static boolean Rl() {
        return hi("MIUI");
    }

    public static boolean Rm() {
        return hi("FLYME");
    }

    public static String getName() {
        if (baj == null) {
            hi("");
        }
        return baj;
    }

    public static String getVersion() {
        if (bak == null) {
            hi("");
        }
        return bak;
    }

    private static boolean hi(String str) {
        String str2 = baj;
        if (str2 != null) {
            return str2.contains(str);
        }
        String str3 = bq.get("ro.build.version.opporom");
        bak = str3;
        if (!TextUtils.isEmpty(str3)) {
            baj = "OPPO";
        } else {
            String str4 = bq.get("ro.vivo.os.version");
            bak = str4;
            if (!TextUtils.isEmpty(str4)) {
                baj = "VIVO";
            } else {
                String str5 = bq.get("ro.build.version.emui");
                bak = str5;
                if (!TextUtils.isEmpty(str5)) {
                    baj = "EMUI";
                } else {
                    String str6 = bq.get("ro.miui.ui.version.name");
                    bak = str6;
                    if (!TextUtils.isEmpty(str6)) {
                        baj = "MIUI";
                    } else {
                        String str7 = bq.get("ro.product.system.manufacturer");
                        bak = str7;
                        if (!TextUtils.isEmpty(str7)) {
                            baj = "OnePlus";
                        } else {
                            String str8 = bq.get("ro.smartisan.version");
                            bak = str8;
                            if (!TextUtils.isEmpty(str8)) {
                                baj = "SMARTISAN";
                            } else if (bq.get("ro.product.manufacturer").toUpperCase().contains("SAMSUNG")) {
                                baj = "SAMSUNG";
                            } else {
                                String str9 = Build.DISPLAY;
                                bak = str9;
                                if (str9.toUpperCase().contains("FLYME")) {
                                    baj = "FLYME";
                                } else {
                                    bak = "unknown";
                                    baj = Build.MANUFACTURER.toUpperCase();
                                }
                            }
                        }
                    }
                }
            }
        }
        return baj.contains(str);
    }
}
