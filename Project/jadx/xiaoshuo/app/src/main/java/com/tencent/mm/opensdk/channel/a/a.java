package com.tencent.mm.opensdk.channel.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.common.base.Ascii;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: com.tencent.mm.opensdk.channel.a.a$a, reason: collision with other inner class name */
    public static class C0527a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f7234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f7235b;
        public String c;
        public long d;
        public Bundle e;
    }

    public static int a(Bundle bundle, String str, int i) {
        if (bundle == null) {
            return i;
        }
        try {
            return bundle.getInt(str, i);
        } catch (Exception e) {
            Log.e("MicroMsg.IntentUtil", "getIntExtra exception:" + e.getMessage());
            return i;
        }
    }

    public static Object a(int i, String str) {
        try {
            switch (i) {
                case 1:
                    return Integer.valueOf(str);
                case 2:
                    return Long.valueOf(str);
                case 3:
                    return str;
                case 4:
                    return Boolean.valueOf(str);
                case 5:
                    return Float.valueOf(str);
                case 6:
                    return Double.valueOf(str);
                default:
                    Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
                    return null;
            }
        } catch (Exception e) {
            Log.e("MicroMsg.SDK.PluginProvider.Resolver", "resolveObj exception:" + e.getMessage());
            return null;
        }
    }

    public static String a(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        try {
            return bundle.getString(str);
        } catch (Exception e) {
            Log.e("MicroMsg.IntentUtil", "getStringExtra exception:" + e.getMessage());
            return null;
        }
    }

    public static boolean a(Context context, C0527a c0527a) {
        String str;
        String str2;
        if (context == null || c0527a == null) {
            str = "send fail, invalid argument";
        } else {
            if (!b.b(c0527a.f7235b)) {
                if (b.b(c0527a.f7234a)) {
                    str2 = null;
                } else {
                    str2 = c0527a.f7234a + ".permission.MM_MESSAGE";
                }
                Intent intent = new Intent(c0527a.f7235b);
                Bundle bundle = c0527a.e;
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                String packageName = context.getPackageName();
                intent.putExtra(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
                intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
                intent.putExtra(ConstantsAPI.CONTENT, c0527a.c);
                intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, c0527a.d);
                intent.putExtra(ConstantsAPI.CHECK_SUM, a(c0527a.c, Build.SDK_INT, packageName));
                context.sendBroadcast(intent, str2);
                Log.d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str2);
                return true;
            }
            str = "send fail, action is null";
        }
        Log.e("MicroMsg.SDK.MMessage", str);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x014f: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:104:0x014f */
    /* JADX WARN: Removed duplicated region for block: B:132:0x015e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x011f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x00ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x00ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x00f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0154 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0115 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0159 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x011a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:177:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v34 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(java.lang.String r8, int r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.channel.a.a.a(java.lang.String, int):byte[]");
    }

    public static byte[] a(String str, int i, String str2) {
        String str3;
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        byte[] bytes = stringBuffer.toString().substring(1, 9).getBytes();
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] bArrDigest = messageDigest.digest();
            char[] cArr2 = new char[bArrDigest.length * 2];
            int i2 = 0;
            for (byte b2 : bArrDigest) {
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b2 >>> 4) & 15];
                i2 = i3 + 1;
                cArr2[i3] = cArr[b2 & Ascii.SI];
            }
            str3 = new String(cArr2);
        } catch (Exception unused) {
            str3 = null;
        }
        return str3.getBytes();
    }
}
