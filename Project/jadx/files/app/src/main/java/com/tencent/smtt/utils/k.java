package com.tencent.smtt.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.sdk.TbsPrivacyAccess;
import com.tencent.smtt.sdk.c;
import com.umeng.message.proguard.ad;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public class k {
    private static SharedPreferences a;
    private static SharedPreferences.Editor b;

    private static String a() {
        return Build.FINGERPRINT + new Random().nextInt(2147483646);
    }

    public static String a(Context context) {
        if (!d(context)) {
            return "";
        }
        a = context.getApplicationContext().getSharedPreferences("tsui", 0);
        SharedPreferences sharedPreferences = a;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString("tsui", "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
        }
        StringBuilder sb = new StringBuilder();
        String strA = a();
        String strK = b.k(context);
        String strC = c(context);
        String strReplace = b(context).replace("-", "");
        if (strA != null && strA.length() > 0) {
            sb.append(strA);
            sb.append(com.anythink.expressad.foundation.g.a.bQ);
        }
        if (strK != null && strK.length() > 0) {
            sb.append(strK);
            sb.append(com.anythink.expressad.foundation.g.a.bQ);
        }
        if (strC != null && strC.length() > 0) {
            sb.append(strC);
            sb.append(com.anythink.expressad.foundation.g.a.bQ);
        }
        if (strReplace != null && strReplace.length() > 0) {
            sb.append(strReplace);
        }
        if (sb.length() > 0) {
            try {
                String strA2 = a(a(sb.toString()));
                if (strA2 != null && strA2.length() > 0) {
                    a(context, "tsui", strA2);
                    return strA2;
                }
            } catch (Exception unused) {
            }
        }
        String strReplace2 = UUID.randomUUID().toString().replace("-", "");
        a(context, "tsui", strReplace2);
        return strReplace2;
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
        }
        return sb.toString().toUpperCase(Locale.CHINA);
    }

    private static void a(Context context, String str, String str2) {
        if (a == null) {
            a = context.getApplicationContext().getSharedPreferences("tsui", 0);
        }
        b = a.edit();
        b.putString(str, str2);
        b.commit();
    }

    private static byte[] a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
            return messageDigest.digest();
        } catch (Exception unused) {
            return "".getBytes();
        }
    }

    private static String b(Context context) {
        try {
            String strC = s.c(context);
            int iNextInt = new Random().nextInt(2147483646);
            return new UUID(("" + iNextInt + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.DEVICE.length() % 10) + (Build.HARDWARE.length() % 10) + (Build.ID.length() % 10) + (strC.length() % 10) + (Build.PRODUCT.length() % 10) + (c(context).length() % 10)).hashCode(), c(context).hashCode()).toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private static String c(Context context) {
        try {
            String configurePrivacy = TbsPrivacyAccess.getConfigurePrivacy(context, TbsPrivacyAccess.ConfigurablePrivacy.SERIAL, "");
            if (!TextUtils.isEmpty(configurePrivacy) && !configurePrivacy.contains("unknown")) {
                return configurePrivacy;
            }
            return a();
        } catch (Exception unused) {
            return "unknown";
        }
    }

    private static boolean d(final Context context) {
        boolean z2 = true;
        try {
            z2 = context.getSharedPreferences("sai", 0).getBoolean("sui", true);
            TbsLog.i("SDKUID", "isSDKUIDEnable is " + z2);
            com.tencent.smtt.sdk.c.a().a(context, (Integer) 1002, new c.a() { // from class: com.tencent.smtt.utils.k.1
                @Override // com.tencent.smtt.sdk.c.a
                public void a(String str) {
                    SharedPreferences.Editor editorEdit = context.getSharedPreferences("sai", 0).edit();
                    editorEdit.putBoolean("sui", false);
                    editorEdit.commit();
                    TbsLog.e("TBSEmergency", "Execute command [1002](" + str + ad.f20406s);
                }
            });
            return z2;
        } catch (Throwable th) {
            TbsLog.i("SDKUID", "stack is " + Log.getStackTraceString(th));
            return z2;
        }
    }
}
