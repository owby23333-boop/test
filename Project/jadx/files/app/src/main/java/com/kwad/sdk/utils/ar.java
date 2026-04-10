package com.kwad.sdk.utils;

import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ar {
    private static String aze;
    private static String azf;

    public static boolean DM() {
        return aL("EMUI");
    }

    public static boolean DN() {
        return aL("MIUI");
    }

    public static boolean DO() {
        return aL("FLYME");
    }

    private static boolean aL(String str) {
        String upperCase;
        String str2 = aze;
        if (str2 != null) {
            return str2.contains(str);
        }
        String str3 = bb.get("ro.build.version.opporom");
        azf = str3;
        if (TextUtils.isEmpty(str3)) {
            String str4 = bb.get("ro.vivo.os.version");
            azf = str4;
            if (TextUtils.isEmpty(str4)) {
                String str5 = bb.get("ro.build.version.emui");
                azf = str5;
                if (TextUtils.isEmpty(str5)) {
                    String str6 = bb.get("ro.miui.ui.version.name");
                    azf = str6;
                    if (TextUtils.isEmpty(str6)) {
                        String str7 = bb.get("ro.product.system.manufacturer");
                        azf = str7;
                        if (TextUtils.isEmpty(str7)) {
                            String str8 = bb.get("ro.smartisan.version");
                            azf = str8;
                            if (TextUtils.isEmpty(str8)) {
                                String str9 = "SAMSUNG";
                                if (!bb.get("ro.product.manufacturer").toUpperCase().contains("SAMSUNG")) {
                                    String str10 = Build.DISPLAY;
                                    azf = str10;
                                    str9 = "FLYME";
                                    if (!str10.toUpperCase().contains("FLYME")) {
                                        azf = "unknown";
                                        upperCase = Build.MANUFACTURER.toUpperCase();
                                    }
                                }
                                aze = str9;
                                return aze.contains(str);
                            }
                            upperCase = "SMARTISAN";
                        } else {
                            upperCase = "OnePlus";
                        }
                    } else {
                        upperCase = "MIUI";
                    }
                } else {
                    upperCase = "EMUI";
                }
            } else {
                upperCase = "VIVO";
            }
        } else {
            upperCase = "OPPO";
        }
        aze = upperCase;
        return aze.contains(str);
    }

    public static String getName() {
        if (aze == null) {
            aL("");
        }
        return aze;
    }

    public static String getVersion() {
        if (azf == null) {
            aL("");
        }
        return azf;
    }
}
