package com.tencent.smtt.sdk.stat;

import MTT.ThirdAppInfoNew;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.anythink.expressad.foundation.d.c;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.TbsCoreLoadStat;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.sdk.TbsPVConfig;
import com.tencent.smtt.sdk.TbsShareManager;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.h;
import com.tencent.smtt.utils.l;
import com.tencent.smtt.utils.o;
import com.tencent.smtt.utils.s;
import com.umeng.message.common.inter.ITagManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static byte[] a;
    private static ThirdAppInfoNew b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Map<String, String> f19089c;

    static {
        try {
            a = "65dRa93L".getBytes(com.anythink.expressad.foundation.g.a.bN);
        } catch (UnsupportedEncodingException unused) {
        }
    }

    private static String a(Context context) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("cpuabi", com.tencent.smtt.utils.b.c() ? "64" : "32");
                s.b();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            jSONObject = null;
        }
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public static void a(ThirdAppInfoNew thirdAppInfoNew, Context context) {
        a(thirdAppInfoNew, context, null, null);
    }

    public static void a(final ThirdAppInfoNew thirdAppInfoNew, final Context context, final String str, final String str2) {
        new Thread("HttpUtils") { // from class: com.tencent.smtt.sdk.stat.b.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                String strSubstring;
                String strSubstring2;
                String str3;
                String string;
                com.tencent.smtt.utils.b.b(context, thirdAppInfoNew.sGuid);
                thirdAppInfoNew.sCpu = com.tencent.smtt.utils.b.a();
                if (Build.VERSION.SDK_INT < 8) {
                    return;
                }
                JSONObject jSONObjectC = null;
                if (b.a == null) {
                    try {
                        b.a = "65dRa93L".getBytes(com.anythink.expressad.foundation.g.a.bN);
                    } catch (UnsupportedEncodingException unused) {
                        b.a = null;
                        TbsLog.e("sdkreport", "Post failed -- get POST_DATA_KEY failed!");
                    }
                }
                if (b.a == null) {
                    TbsLog.e("sdkreport", "Post failed -- POST_DATA_KEY is null!");
                    return;
                }
                String string2 = TbsDownloadConfig.getInstance(context).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_DESkEY_TOKEN, "");
                if (TextUtils.isEmpty(string2)) {
                    strSubstring = "";
                    strSubstring2 = strSubstring;
                } else {
                    strSubstring2 = string2.substring(0, string2.indexOf(DispatchConstants.SIGN_SPLIT_SYMBOL));
                    strSubstring = string2.substring(string2.indexOf(DispatchConstants.SIGN_SPLIT_SYMBOL) + 1, string2.length());
                }
                boolean z2 = TextUtils.isEmpty(strSubstring2) || strSubstring2.length() != 96 || TextUtils.isEmpty(strSubstring) || strSubstring.length() != 24;
                try {
                    o oVarA = o.a();
                    if (z2) {
                        str3 = oVarA.b() + h.a().b();
                    } else {
                        str3 = oVarA.i() + strSubstring2;
                    }
                    TbsLog.i("sdkreport", "Post post_url is " + str3);
                    TbsLog.i("sdkreport", "Post getDESString is " + h.c());
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str3).openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setConnectTimeout(20000);
                    if (Build.VERSION.SDK_INT > 13) {
                        httpURLConnection.setRequestProperty("Connection", c.cf);
                    }
                    try {
                        jSONObjectC = b.c(thirdAppInfoNew, context);
                    } catch (Exception e2) {
                        TbsLog.i(e2);
                    }
                    if (jSONObjectC == null) {
                        TbsLog.e("sdkreport", "post -- jsonData is null!");
                        return;
                    }
                    try {
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put(str, str2);
                                string = jSONObject.toString();
                            } catch (Throwable unused2) {
                                string = "";
                            }
                            jSONObjectC.put("EXT_INFO", string);
                            jSONObjectC.put("PV", 0);
                        }
                    } catch (Exception e3) {
                        TbsLog.i(e3);
                    }
                    try {
                        TbsLog.i("sdkreport", "Post jsonData.toString() is " + jSONObjectC.toString());
                        byte[] bytes = jSONObjectC.toString().getBytes(com.anythink.expressad.foundation.g.a.bN);
                        byte[] bArrA = z2 ? h.a().a(bytes) : h.a(bytes, strSubstring);
                        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bArrA.length));
                        try {
                            OutputStream outputStream = httpURLConnection.getOutputStream();
                            outputStream.write(bArrA);
                            outputStream.flush();
                            if (httpURLConnection.getResponseCode() == 200) {
                                TbsLog.i("SDKPVReport", "Post successful!");
                                TbsLog.i("SDKPVReport", "SIGNATURE is " + jSONObjectC.getString("SIGNATURE"));
                                b.b(context, b.b(httpURLConnection, strSubstring, z2));
                                return;
                            }
                            TbsLog.e("SDKPVReport", "Post failed -- not 200 code is " + httpURLConnection.getResponseCode());
                            TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
                            tbsLogInfo.setErrorCode(126);
                            tbsLogInfo.setFailDetail("" + httpURLConnection.getResponseCode());
                            TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_PV_UPLOAD_STAT, tbsLogInfo);
                        } catch (Throwable th) {
                            TbsLog.e("SDKPVReport", "Post failed -- exceptions:" + th.getMessage());
                            TbsLogReport.TbsLogInfo tbsLogInfo2 = TbsLogReport.getInstance(context).tbsLogInfo();
                            tbsLogInfo2.setErrorCode(126);
                            tbsLogInfo2.setFailDetail(th);
                            TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_PV_UPLOAD_STAT, tbsLogInfo2);
                        }
                    } catch (Throwable unused3) {
                    }
                } catch (IOException e4) {
                    TbsLog.e("sdkreport", "Post failed -- IOException:" + e4);
                } catch (AssertionError e5) {
                    TbsLog.e("sdkreport", "Post failed -- AssertionError:" + e5);
                } catch (Exception e6) {
                    TbsLog.e("sdkreport", "Post failed -- Exception:" + e6);
                } catch (NoClassDefFoundError e7) {
                    TbsLog.e("sdkreport", "Post failed -- NoClassDefFoundError:" + e7);
                }
            }
        }.start();
    }

    private static void a(Context context, int i2) {
        TbsLog.i("HttpUtils", "updatePVConfig command is " + i2);
        if (i2 == 1) {
            TbsPVConfig.getInstance(context).clear();
        }
        if (i2 == 2) {
            TbsPVConfig.getInstance(context).update(f19089c);
        }
    }

    public static void a(Context context, String str, String str2) {
        if (b == null) {
            ThirdAppInfoNew thirdAppInfoNew = new ThirdAppInfoNew();
            thirdAppInfoNew.sAppName = context.getApplicationContext().getApplicationInfo().packageName;
            o.a(context);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
            thirdAppInfoNew.sTime = simpleDateFormat.format(Calendar.getInstance().getTime());
            thirdAppInfoNew.sVersionCode = com.tencent.smtt.utils.b.e(context);
            String strA = com.tencent.smtt.utils.b.a(context, TbsDownloader.TBS_METADATA);
            if (!TextUtils.isEmpty(strA)) {
                thirdAppInfoNew.sMetaData = strA;
            }
            thirdAppInfoNew.sGuid = "";
            thirdAppInfoNew.sQua2 = l.a(context, "" + QbSdk.getTbsVersion(context));
            thirdAppInfoNew.sLc = "";
            String strJ = com.tencent.smtt.utils.b.j(context);
            String strH = com.tencent.smtt.utils.b.h(context);
            String strI = com.tencent.smtt.utils.b.i(context);
            String strK = com.tencent.smtt.utils.b.k(context);
            if (strH != null && !"".equals(strH)) {
                thirdAppInfoNew.sImei = strH;
            }
            if (strI != null && !"".equals(strI)) {
                thirdAppInfoNew.sImsi = strI;
            }
            if (!TextUtils.isEmpty(strK)) {
                thirdAppInfoNew.sAndroidID = strK;
            }
            if (strJ != null && !"".equals(strJ)) {
                thirdAppInfoNew.sMac = strJ;
            }
            thirdAppInfoNew.iPv = 0L;
            if (QbSdk.getTbsVersion(context) > 0) {
                thirdAppInfoNew.iCoreType = 1;
            } else {
                thirdAppInfoNew.iCoreType = 0;
                thirdAppInfoNew.localCoreVersion = QbSdk.getTbsVersion(context);
            }
            thirdAppInfoNew.sAppVersionName = context.getApplicationInfo().packageName;
            thirdAppInfoNew.sAppSignature = b(context);
            b = thirdAppInfoNew;
        }
        a(b, context, str, str2);
    }

    public static void a(Context context, String str, String str2, String str3, int i2, boolean z2, long j2, boolean z3) {
        String str4;
        if (QbSdk.getSettings() != null && QbSdk.getSettings().containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && QbSdk.getSettings().get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals(ITagManager.STATUS_FALSE)) {
            TbsLog.i("sdkreport", "[HttpUtils.doReport] -- SET_SENDREQUEST_AND_UPLOAD is false");
            return;
        }
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (TbsConfig.APP_QQ.equals(applicationInfo.packageName)) {
                str4 = context.getPackageManager().getPackageInfo(applicationInfo.packageName, 0).versionName;
                try {
                    if (!TextUtils.isEmpty(QbSdk.getQQBuildNumber())) {
                        str4 = str4 + "." + QbSdk.getQQBuildNumber();
                    }
                } catch (Exception e2) {
                    e = e2;
                    TbsLog.i(e);
                }
            } else {
                str4 = "";
            }
        } catch (Exception e3) {
            e = e3;
            str4 = "";
        }
        try {
            ThirdAppInfoNew thirdAppInfoNew = new ThirdAppInfoNew();
            thirdAppInfoNew.sAppName = context.getApplicationContext().getApplicationInfo().packageName;
            o.a(context);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
            thirdAppInfoNew.sTime = simpleDateFormat.format(Calendar.getInstance().getTime());
            thirdAppInfoNew.sVersionCode = com.tencent.smtt.utils.b.e(context);
            String strA = com.tencent.smtt.utils.b.a(context, TbsDownloader.TBS_METADATA);
            if (!TextUtils.isEmpty(strA)) {
                thirdAppInfoNew.sMetaData = strA;
            }
            thirdAppInfoNew.sGuid = str;
            if (z2) {
                thirdAppInfoNew.sQua2 = str2;
                thirdAppInfoNew.bIsSandboxMode = z3;
            } else {
                thirdAppInfoNew.sQua2 = l.a(context);
            }
            thirdAppInfoNew.sLc = str3;
            String strJ = com.tencent.smtt.utils.b.j(context);
            String strH = com.tencent.smtt.utils.b.h(context);
            TbsLog.i("sdkreport", "HttpUtils.doReport(): getImeiEnable = " + com.tencent.smtt.utils.b.g(context) + " imei is " + strH);
            String strI = com.tencent.smtt.utils.b.i(context);
            String strK = com.tencent.smtt.utils.b.k(context);
            if (strH != null && !"".equals(strH)) {
                thirdAppInfoNew.sImei = strH;
            }
            if (strI != null && !"".equals(strI)) {
                thirdAppInfoNew.sImsi = strI;
            }
            if (!TextUtils.isEmpty(strK)) {
                thirdAppInfoNew.sAndroidID = strK;
            }
            if (strJ != null && !"".equals(strJ)) {
                thirdAppInfoNew.sMac = strJ;
            }
            thirdAppInfoNew.iPv = i2;
            int i3 = 1;
            if (!TbsShareManager.isThirdPartyApp(context)) {
                if (!z2) {
                    i3 = 0;
                }
                thirdAppInfoNew.iCoreType = i3;
                if (z2 && z3) {
                    thirdAppInfoNew.iCoreType = 3;
                }
            } else if (z2) {
                if (TbsShareManager.getCoreFormOwn()) {
                    thirdAppInfoNew.iCoreType = 2;
                } else {
                    thirdAppInfoNew.iCoreType = 1;
                }
                if (z3) {
                    thirdAppInfoNew.iCoreType = 3;
                }
            } else {
                thirdAppInfoNew.iCoreType = 0;
            }
            thirdAppInfoNew.sAppVersionName = str4;
            thirdAppInfoNew.sAppSignature = b(context);
            if (!z2) {
                thirdAppInfoNew.sWifiConnectedTime = j2;
                thirdAppInfoNew.localCoreVersion = QbSdk.getTbsVersion(context);
            }
            b = thirdAppInfoNew;
            s.a(context, "pv_report", "");
            s.h(context);
            a(thirdAppInfoNew, context.getApplicationContext());
        } catch (Throwable th) {
            TbsLog.i(th);
        }
    }

    private static boolean a(Map<String, String> map, Map<String, String> map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!(entry.getValue() == null ? "" : entry.getValue()).equals(map2.get(entry.getKey()) != null ? map2.get(entry.getKey()) : "")) {
                return false;
            }
        }
        return true;
    }

    private static String b(Context context) {
        try {
            byte[] byteArray = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray();
            if (byteArray != null) {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                messageDigest.update(byteArray);
                byte[] bArrDigest = messageDigest.digest();
                if (bArrDigest != null) {
                    StringBuilder sb = new StringBuilder("");
                    if (bArrDigest != null && bArrDigest.length > 0) {
                        for (int i2 = 0; i2 < bArrDigest.length; i2++) {
                            String upperCase = Integer.toHexString(bArrDigest[i2] & 255).toUpperCase();
                            if (i2 > 0) {
                                sb.append(":");
                            }
                            if (upperCase.length() < 2) {
                                sb.append(0);
                            }
                            sb.append(upperCase);
                        }
                        return sb.toString();
                    }
                    return null;
                }
            }
        } catch (Exception e2) {
            TbsLog.i(e2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v16, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.io.InputStream] */
    public static String b(HttpURLConnection httpURLConnection, String str, boolean z2) throws Throwable {
        Throwable th;
        ?? byteArrayOutputStream;
        Exception e2;
        String str2;
        String str3 = null;
         = 0;
        ?? r1 = 0;
        try {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                String contentEncoding = httpURLConnection.getContentEncoding();
                httpURLConnection = (contentEncoding == null || !contentEncoding.equalsIgnoreCase("gzip")) ? (contentEncoding == null || !contentEncoding.equalsIgnoreCase("deflate")) ? inputStream : new InflaterInputStream(inputStream, new Inflater(true)) : new GZIPInputStream(inputStream);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[128];
                        while (true) {
                            int i2 = httpURLConnection.read(bArr);
                            if (i2 == -1) {
                                break;
                            }
                            TbsLog.i("HttpUtils", "getResponseFromConnection len is " + i2);
                            byteArrayOutputStream.write(bArr, 0, i2);
                        }
                        str2 = z2 ? new String(h.a().c(byteArrayOutputStream.toByteArray())) : new String(h.b(byteArrayOutputStream.toByteArray(), str));
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e3) {
                            TbsLog.i(e3);
                        }
                        if (httpURLConnection != 0) {
                            try {
                                httpURLConnection.close();
                            } catch (IOException e4) {
                                TbsLog.i(e4);
                            }
                        }
                    } catch (Exception e5) {
                        e2 = e5;
                        r1 = byteArrayOutputStream;
                        TbsLog.i(e2);
                        if (r1 != 0) {
                            try {
                                r1.close();
                            } catch (IOException e6) {
                                TbsLog.i(e6);
                            }
                        }
                        if (httpURLConnection != 0) {
                            try {
                                httpURLConnection.close();
                            } catch (IOException e7) {
                                TbsLog.i(e7);
                            }
                        }
                        str2 = "";
                    } catch (Throwable th2) {
                        th = th2;
                        if (byteArrayOutputStream != 0) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e8) {
                                TbsLog.i(e8);
                            }
                        }
                        if (httpURLConnection == 0) {
                            throw th;
                        }
                        try {
                            httpURLConnection.close();
                            throw th;
                        } catch (IOException e9) {
                            TbsLog.i(e9);
                            throw th;
                        }
                    }
                } catch (Exception e10) {
                    e2 = e10;
                }
            } catch (Exception e11) {
                e2 = e11;
                httpURLConnection = 0;
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = 0;
                byteArrayOutputStream = 0;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getResponseFromConnection,response=");
            sb.append(str2);
            str3 = ";isUseRSA=";
            sb.append(";isUseRSA=");
            sb.append(z2);
            httpURLConnection = sb.toString();
            TbsLog.i("HttpUtils", httpURLConnection);
            return str2;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = str3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                a(context, 1);
                return;
            }
            f19089c = new HashMap();
            for (String str2 : str.split("\\|")) {
                try {
                    String[] strArrSplit = str2.split("=");
                    if (strArrSplit.length == 2) {
                        b(context, strArrSplit[0], strArrSplit[1]);
                    }
                } catch (Exception e2) {
                    TbsLog.i(e2);
                }
            }
            int iC = c(context);
            TbsLog.i("HttpUtils", "readResponse, after processSwitchKeyValue mMapFromResponse is " + f19089c.toString() + " commandForUpdatePVC is " + iC);
            a(context, iC);
        } catch (Exception e3) {
            TbsLog.i(e3);
        }
    }

    private static void b(Context context, String str, String str2) {
        TbsLog.i("HttpUtils", "PV Config Receive. Key: " + str + ", value: " + str2);
        if ("reset".equals(str) && ITagManager.STATUS_TRUE.equals(str2)) {
            QbSdk.reset(context);
        } else if ("resetCfg24".equals(str) && ITagManager.STATUS_TRUE.equals(str2)) {
            d(context);
        } else {
            f19089c.put(str, str2);
        }
    }

    private static int c(Context context) {
        Map<String, String> map = f19089c;
        if (map == null || map.size() == 0) {
            return 1;
        }
        Map<String, String> pVCLocal = TbsPVConfig.getInstance(context).getPVCLocal();
        TbsLog.i("HttpUtils", "getCommandForUpdatePVC, mMapPVCLocal is " + pVCLocal.toString());
        return (pVCLocal == null || pVCLocal.size() == 0 || !a(f19089c, pVCLocal)) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject c(ThirdAppInfoNew thirdAppInfoNew, Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("APPNAME", thirdAppInfoNew.sAppName);
            jSONObject.put("TIME", thirdAppInfoNew.sTime);
            jSONObject.put("QUA2", thirdAppInfoNew.sQua2);
            jSONObject.put("LC", thirdAppInfoNew.sLc);
            jSONObject.put("GUID", thirdAppInfoNew.sGuid);
            jSONObject.put("IMEI", thirdAppInfoNew.sImei);
            jSONObject.put("IMSI", thirdAppInfoNew.sImsi);
            jSONObject.put("MAC", thirdAppInfoNew.sMac);
            jSONObject.put("PV", thirdAppInfoNew.iPv);
            jSONObject.put("CORETYPE", thirdAppInfoNew.iCoreType);
            jSONObject.put("APPVN", thirdAppInfoNew.sAppVersionName);
            jSONObject.put("APPMETADATA", thirdAppInfoNew.sMetaData);
            jSONObject.put("VERSION_CODE", thirdAppInfoNew.sVersionCode);
            jSONObject.put("CPU", thirdAppInfoNew.sCpu);
            jSONObject.put("SIGNATURE", thirdAppInfoNew.sAppSignature == null ? "0" : thirdAppInfoNew.sAppSignature);
            String strA = a(context);
            TbsLog.i("sdkreport", "addInfo is " + strA);
            if (!TextUtils.isEmpty(strA)) {
                jSONObject.put("EXT_INFO", strA);
            }
            jSONObject.put("PROTOCOL_VERSION", 3);
            jSONObject.put("ANDROID_ID", thirdAppInfoNew.sAndroidID);
            jSONObject.put("HOST_COREVERSION", 0);
            jSONObject.put("DECOUPLE_COREVERSION", 0);
            jSONObject.put("WIFICONNECTEDTIME", thirdAppInfoNew.sWifiConnectedTime);
            jSONObject.put("CORE_EXIST", thirdAppInfoNew.localCoreVersion);
            int loadErrorCode = TbsCoreLoadStat.getLoadErrorCode();
            if (thirdAppInfoNew.localCoreVersion <= 0) {
                jSONObject.put("TBS_ERROR_CODE", TbsDownloadConfig.getInstance(context).getDownloadInterruptCode());
            } else {
                jSONObject.put("TBS_ERROR_CODE", loadErrorCode);
            }
            if (loadErrorCode == -1) {
                TbsLog.e("sdkreport", "ATTENTION: Load errorCode missed!");
            }
            try {
                if (QbSdk.getTID() != null && (thirdAppInfoNew.sAppName.equals(TbsConfig.APP_QQ) || thirdAppInfoNew.sAppName.equals("com.tencent.mm"))) {
                    String tid = QbSdk.getTID();
                    jSONObject.put("TID", tid);
                    jSONObject.put("TIDTYPE", 0);
                }
            } catch (Exception unused) {
            }
            return jSONObject;
        } catch (Exception unused2) {
            TbsLog.e("sdkreport", "getPostData exception!");
            return null;
        }
    }

    private static void d(Context context) {
        SharedPreferences.Editor editorEdit = TbsDownloadConfig.getInstance(context).mPreferences.edit();
        editorEdit.putLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK, 0L);
        editorEdit.apply();
    }
}
