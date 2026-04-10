package com.umeng.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.utils.UMUtils;

/* JADX INFO: compiled from: EncryptHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static String a = null;
    private static final String b = "umeng+";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f19845c = "ek__id";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f19846d = "ek_key";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f19847e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f19848f = "umeng_subprocess_info";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f19849g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static a f19850h;

    private a() {
    }

    public static a a() {
        if (f19850h == null) {
            synchronized (a.class) {
                if (f19850h == null) {
                    f19850h = new a();
                }
            }
        }
        return f19850h;
    }

    private String c(String str) {
        String string = "";
        try {
            String strSubstring = str.substring(1, 9);
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < strSubstring.length(); i2++) {
                char cCharAt = strSubstring.charAt(i2);
                if (!Character.isDigit(cCharAt)) {
                    sb.append(cCharAt);
                } else if (Integer.parseInt(Character.toString(cCharAt)) == 0) {
                    sb.append(0);
                } else {
                    sb.append(10 - Integer.parseInt(Character.toString(cCharAt)));
                }
            }
            string = sb.toString();
            return string + new StringBuilder(string).reverse().toString();
        } catch (Throwable unused) {
            return string;
        }
    }

    public String b(String str) {
        String str2;
        String str3 = null;
        try {
            return TextUtils.isEmpty(a) ? str : new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), a.getBytes()));
        } catch (Exception unused) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败!");
            if (TextUtils.isEmpty(f19847e)) {
                return null;
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试");
            try {
                String str4 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f19847e.getBytes()));
                try {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试成功。");
                    return str4;
                } catch (Exception unused2) {
                    str3 = str4;
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试失败。换子进程备份key重试。");
                    try {
                        str2 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f19849g.getBytes()));
                    } catch (Throwable unused3) {
                    }
                    try {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试成功。");
                        return str2;
                    } catch (Throwable unused4) {
                        str3 = str2;
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试失败。");
                        return str3;
                    }
                }
            } catch (Exception unused5) {
            }
        }
    }

    public void a(Context context) {
        try {
            if (TextUtils.isEmpty(a)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(context, f19845c);
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    f19847e = c(multiProcessSP);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>> primaryKey: " + f19847e);
                }
                SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f19848f, 0);
                if (sharedPreferences != null) {
                    f19849g = sharedPreferences.getString(f19845c, null);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程备份秘钥：主进程key: " + f19849g);
                }
                a = c(UMUtils.genId());
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>> 正式秘钥：key: " + a);
            }
        } catch (Throwable unused) {
        }
    }

    public String a(String str) {
        try {
            return TextUtils.isEmpty(a) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), a.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }
}
