package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.util.ErrorConstant;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.sdk.c;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.g;
import com.umeng.message.common.inter.ITagManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TbsDownloader {
    public static final boolean DEBUG_DISABLE_DOWNLOAD = false;
    public static boolean DOWNLOAD_OVERSEA_TBS = false;
    public static final String LOGTAG = "TbsDownload";
    public static final String TBS_METADATA = "com.tencent.mm.BuildInfo.CLIENT_VERSION";
    static boolean a = false;
    private static String b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Context f18879c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Handler f18880d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f18881e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f18882f = new byte[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static l f18883g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static HandlerThread f18884h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static int f18885i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f18886j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static String f18887k = "";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static String f18888l = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static boolean f18889m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static boolean f18890n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static JSONObject f18891o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static JSONObject f18892p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static boolean f18893q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static int f18894r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static int f18895s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static JSONObject f18896t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static long f18897u = -1;

    public interface TbsDownloaderCallback {
        void onNeedDownloadFinish(boolean z2, int i2);
    }

    private static String a(String str) {
        return str == null ? "" : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x035d A[Catch: Exception -> 0x0382, TryCatch #2 {Exception -> 0x0382, blocks: (B:79:0x0213, B:81:0x024d, B:82:0x0253, B:86:0x027f, B:90:0x028b, B:93:0x0299, B:94:0x02a2, B:98:0x02e0, B:102:0x02eb, B:104:0x02f4, B:106:0x02fc, B:109:0x0306, B:111:0x030c, B:113:0x031b, B:115:0x0327, B:112:0x0311, B:103:0x02f0, B:116:0x032e, B:118:0x0343, B:120:0x034e, B:122:0x0352, B:126:0x035d, B:129:0x0363, B:130:0x0368, B:132:0x0370, B:135:0x037a), top: B:145:0x0213 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0363 A[Catch: Exception -> 0x0382, TryCatch #2 {Exception -> 0x0382, blocks: (B:79:0x0213, B:81:0x024d, B:82:0x0253, B:86:0x027f, B:90:0x028b, B:93:0x0299, B:94:0x02a2, B:98:0x02e0, B:102:0x02eb, B:104:0x02f4, B:106:0x02fc, B:109:0x0306, B:111:0x030c, B:113:0x031b, B:115:0x0327, B:112:0x0311, B:103:0x02f0, B:116:0x032e, B:118:0x0343, B:120:0x034e, B:122:0x0352, B:126:0x035d, B:129:0x0363, B:130:0x0368, B:132:0x0370, B:135:0x037a), top: B:145:0x0213 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0370 A[Catch: Exception -> 0x0382, TryCatch #2 {Exception -> 0x0382, blocks: (B:79:0x0213, B:81:0x024d, B:82:0x0253, B:86:0x027f, B:90:0x028b, B:93:0x0299, B:94:0x02a2, B:98:0x02e0, B:102:0x02eb, B:104:0x02f4, B:106:0x02fc, B:109:0x0306, B:111:0x030c, B:113:0x031b, B:115:0x0327, B:112:0x0311, B:103:0x02f0, B:116:0x032e, B:118:0x0343, B:120:0x034e, B:122:0x0352, B:126:0x035d, B:129:0x0363, B:130:0x0368, B:132:0x0370, B:135:0x037a), top: B:145:0x0213 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x037a A[Catch: Exception -> 0x0382, TRY_LEAVE, TryCatch #2 {Exception -> 0x0382, blocks: (B:79:0x0213, B:81:0x024d, B:82:0x0253, B:86:0x027f, B:90:0x028b, B:93:0x0299, B:94:0x02a2, B:98:0x02e0, B:102:0x02eb, B:104:0x02f4, B:106:0x02fc, B:109:0x0306, B:111:0x030c, B:113:0x031b, B:115:0x0327, B:112:0x0311, B:103:0x02f0, B:116:0x032e, B:118:0x0343, B:120:0x034e, B:122:0x0352, B:126:0x035d, B:129:0x0363, B:130:0x0368, B:132:0x0370, B:135:0x037a), top: B:145:0x0213 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ba A[Catch: Exception -> 0x0380, TryCatch #0 {Exception -> 0x0380, blocks: (B:17:0x0075, B:19:0x007d, B:21:0x0086, B:23:0x0097, B:24:0x009d, B:37:0x00dd, B:39:0x00ed, B:41:0x00f5, B:43:0x0102, B:64:0x018f, B:72:0x01a4, B:74:0x01c0, B:76:0x01f9, B:77:0x01ff, B:68:0x019a, B:45:0x0110, B:48:0x0127, B:50:0x0133, B:52:0x0144, B:54:0x0154, B:55:0x015e, B:57:0x017c, B:46:0x011b, B:25:0x00a2, B:27:0x00b3, B:28:0x00ba, B:30:0x00cb, B:33:0x00d4), top: B:141:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ed A[Catch: Exception -> 0x0380, TryCatch #0 {Exception -> 0x0380, blocks: (B:17:0x0075, B:19:0x007d, B:21:0x0086, B:23:0x0097, B:24:0x009d, B:37:0x00dd, B:39:0x00ed, B:41:0x00f5, B:43:0x0102, B:64:0x018f, B:72:0x01a4, B:74:0x01c0, B:76:0x01f9, B:77:0x01ff, B:68:0x019a, B:45:0x0110, B:48:0x0127, B:50:0x0133, B:52:0x0144, B:54:0x0154, B:55:0x015e, B:57:0x017c, B:46:0x011b, B:25:0x00a2, B:27:0x00b3, B:28:0x00ba, B:30:0x00cb, B:33:0x00d4), top: B:141:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0102 A[Catch: Exception -> 0x0380, TryCatch #0 {Exception -> 0x0380, blocks: (B:17:0x0075, B:19:0x007d, B:21:0x0086, B:23:0x0097, B:24:0x009d, B:37:0x00dd, B:39:0x00ed, B:41:0x00f5, B:43:0x0102, B:64:0x018f, B:72:0x01a4, B:74:0x01c0, B:76:0x01f9, B:77:0x01ff, B:68:0x019a, B:45:0x0110, B:48:0x0127, B:50:0x0133, B:52:0x0144, B:54:0x0154, B:55:0x015e, B:57:0x017c, B:46:0x011b, B:25:0x00a2, B:27:0x00b3, B:28:0x00ba, B:30:0x00cb, B:33:0x00d4), top: B:141:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c0 A[Catch: Exception -> 0x0380, TryCatch #0 {Exception -> 0x0380, blocks: (B:17:0x0075, B:19:0x007d, B:21:0x0086, B:23:0x0097, B:24:0x009d, B:37:0x00dd, B:39:0x00ed, B:41:0x00f5, B:43:0x0102, B:64:0x018f, B:72:0x01a4, B:74:0x01c0, B:76:0x01f9, B:77:0x01ff, B:68:0x019a, B:45:0x0110, B:48:0x0127, B:50:0x0133, B:52:0x0144, B:54:0x0154, B:55:0x015e, B:57:0x017c, B:46:0x011b, B:25:0x00a2, B:27:0x00b3, B:28:0x00ba, B:30:0x00cb, B:33:0x00d4), top: B:141:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x024d A[Catch: Exception -> 0x0382, TryCatch #2 {Exception -> 0x0382, blocks: (B:79:0x0213, B:81:0x024d, B:82:0x0253, B:86:0x027f, B:90:0x028b, B:93:0x0299, B:94:0x02a2, B:98:0x02e0, B:102:0x02eb, B:104:0x02f4, B:106:0x02fc, B:109:0x0306, B:111:0x030c, B:113:0x031b, B:115:0x0327, B:112:0x0311, B:103:0x02f0, B:116:0x032e, B:118:0x0343, B:120:0x034e, B:122:0x0352, B:126:0x035d, B:129:0x0363, B:130:0x0368, B:132:0x0370, B:135:0x037a), top: B:145:0x0213 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0299 A[Catch: Exception -> 0x0382, TRY_ENTER, TryCatch #2 {Exception -> 0x0382, blocks: (B:79:0x0213, B:81:0x024d, B:82:0x0253, B:86:0x027f, B:90:0x028b, B:93:0x0299, B:94:0x02a2, B:98:0x02e0, B:102:0x02eb, B:104:0x02f4, B:106:0x02fc, B:109:0x0306, B:111:0x030c, B:113:0x031b, B:115:0x0327, B:112:0x0311, B:103:0x02f0, B:116:0x032e, B:118:0x0343, B:120:0x034e, B:122:0x0352, B:126:0x035d, B:129:0x0363, B:130:0x0368, B:132:0x0370, B:135:0x037a), top: B:145:0x0213 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static org.json.JSONObject a(boolean r18, boolean r19, boolean r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 925
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloader.a(boolean, boolean, boolean):org.json.JSONObject");
    }

    private static void a(int i2) {
        String str;
        int i3;
        try {
            TbsLog.i(LOGTAG, "sendRequestForOtherStableCore cpuType is " + i2 + " mJsonDataQuery is " + f18891o + " mJsonDataDownloadUpdate is " + f18892p);
            if (!com.tencent.smtt.utils.s.b(f18879c)) {
                TbsLog.i(LOGTAG, "sendRequestForOtherStableCore isStableCoreForHostEnable is false and return ");
                return;
            }
            if (i2 < 32) {
                return;
            }
            if (f18891o == null) {
                f18891o = f18892p;
            }
            if (f18891o == null) {
                return;
            }
            if (System.currentTimeMillis() - TbsDownloadConfig.getInstance(f18879c).mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_DOWNLOAD_STABLE_CORE_OTHER_CPU, 0L) < TbsDownloadConfig.getInstance(f18879c).getRetryInterval() * 1000) {
                TbsLog.i(LOGTAG, "sendRequestForOtherStableCore less than and return ");
                return;
            }
            if (i2 == 64) {
                f18891o.put("REQUEST_64", 1);
            } else if (i2 == 32) {
                f18891o.remove("REQUEST_64");
            }
            f18891o.put("DOWNLOADDECOUPLECORE", 1);
            if (i2 == 64) {
                if (m.a(f18879c).c("stable_64_tpatch_fail") == 1) {
                    str = "sendRequestForOtherStableCore stable_64_last_tpatch_fail and set REQUEST_TPATCH  0 ";
                    TbsLog.i(LOGTAG, str);
                    i3 = 0;
                }
                i3 = 1;
            } else {
                if (m.a(f18879c).c("stable_32_tpatch_fail") == 1) {
                    str = "sendRequestForOtherStableCore stable_32_last_tpatch_fail and set REQUEST_TPATCH  0 ";
                    TbsLog.i(LOGTAG, str);
                    i3 = 0;
                }
                i3 = 1;
            }
            f18891o.put("REQUEST_TPATCH", i3);
            int tbsStableCoreVersion = TbsShareManager.getTbsStableCoreVersion(f18879c, i2);
            f18891o.put("TBSDV", o.a().h(f18879c) % 10000);
            f18891o.put("TBSBACKUPV", tbsStableCoreVersion);
            if (i3 == 0) {
                f18891o.put("TBSDV", 0);
                f18891o.put("TBSBACKUPV", 0);
            }
            if (tbsStableCoreVersion > 0) {
                f18891o.put("FUNCTION", 1);
            } else {
                f18891o.put("FUNCTION", 0);
            }
            f18891o.put("TBSV", 0);
            String strG = com.tencent.smtt.utils.o.a(f18879c).g();
            TbsLog.i(LOGTAG, "[TbsDownloader.sendRequestForOtherStableCore] postUrl=" + strG);
            TbsLog.i(LOGTAG, "[TbsDownloader.sendRequestForOtherStableCore] mJsonDataQuery=" + f18891o.toString());
            f18896t = f18891o;
            String strA = com.tencent.smtt.utils.g.a(strG, f18891o.toString().getBytes(com.anythink.expressad.foundation.g.a.bN), new g.a() { // from class: com.tencent.smtt.sdk.TbsDownloader.4
                @Override // com.tencent.smtt.utils.g.a
                public void a(int i4) {
                }
            }, false);
            TbsLog.i(LOGTAG, "[TbsDownloader.sendRequestForOtherStableCore] response=" + strA);
            JSONObject jSONObject = new JSONObject(strA);
            TbsDownloadConfig.getInstance(f18879c).mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_LAST_DOWNLOAD_STABLE_CORE_OTHER_CPU, Long.valueOf(System.currentTimeMillis()));
            TbsDownloadConfig.getInstance(f18879c).commit();
            String string = jSONObject.getString("DOWNLOADURL");
            long j2 = jSONObject.getLong("TBSAPKFILESIZE");
            String string2 = jSONObject.getString("PKGMD5");
            int i4 = jSONObject.getInt("TBSAPKSERVERVERSION");
            int i5 = jSONObject.getInt("RESPONSECODE");
            f18893q = false;
            if (com.tencent.smtt.utils.s.b(f18879c)) {
                int tbsStableCoreVersion2 = TbsShareManager.getTbsStableCoreVersion(f18879c, i2);
                if (tbsStableCoreVersion2 < i4) {
                    if (a(i4, tbsStableCoreVersion2, i2)) {
                        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(f18879c);
                        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_CPUTYPE_OTHER_STABLE_CORE, Integer.valueOf(i2));
                        tbsDownloadConfig.commit();
                        TbsLog.i(LOGTAG, "sendRequestForOtherStableCore stable core " + i4 + " copy from old backup and return ");
                        return;
                    }
                    TbsDownloadConfig tbsDownloadConfig2 = TbsDownloadConfig.getInstance(f18879c);
                    tbsDownloadConfig2.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOADURL, string);
                    tbsDownloadConfig2.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, Long.valueOf(j2));
                    tbsDownloadConfig2.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_CPUTYPE_OTHER_STABLE_CORE, Integer.valueOf(i2));
                    Map<String, Object> map = tbsDownloadConfig2.mSyncMap;
                    if (string2 == null) {
                        string2 = "";
                    }
                    map.put(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPK_MD5, string2);
                    tbsDownloadConfig2.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 1);
                    tbsDownloadConfig2.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, Integer.valueOf(i4));
                    tbsDownloadConfig2.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, Integer.valueOf(i5));
                    tbsDownloadConfig2.commit();
                    TbsLog.i(LOGTAG, "sendRequestForOtherStableCore downloadUrl is " + string, true);
                    if (!TextUtils.isEmpty(string)) {
                        f18883g.a(false, true);
                    }
                } else if (TextUtils.isEmpty(string) && i4 == 0 && j2 > 0) {
                    f18893q = true;
                }
            }
            b(i2);
            if (f18893q) {
                int tbsStableCoreVersion3 = TbsShareManager.getTbsStableCoreVersion(f18879c, i2);
                f18895s = 0;
                TbsLog.i(LOGTAG, "other cpu stable core is flowed and copyFromOldBackupDone is " + a(f18894r, tbsStableCoreVersion3, i2) + " tbsDownloadVersion is " + i4 + " oldBackupCoreVersion is " + f18895s + " localStableCore is " + tbsStableCoreVersion3 + " cpuType is " + i2);
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(boolean z2, TbsDownloaderCallback tbsDownloaderCallback, boolean z3) {
        TbsLog.i(LOGTAG, "[TbsDownloader.queryConfig]");
        f18880d.removeMessages(100);
        Message messageObtain = Message.obtain(f18880d, 100);
        if (tbsDownloaderCallback != null) {
            messageObtain.obj = tbsDownloaderCallback;
        }
        messageObtain.arg1 = 0;
        messageObtain.arg1 = z2 ? 1 : 0;
        messageObtain.arg2 = z3 ? 1 : 0;
        messageObtain.sendToTarget();
    }

    private static boolean a(int i2, int i3, int i4) {
        try {
            TbsLog.i(LOGTAG, "copyFromOldBackupDone newCoreVersion is " + i2 + " localStableCoreVersion is " + i3 + " cpuType is " + i4);
            if (i2 > 0 && i2 != i3) {
                File file = new File(FileUtil.a(f18879c, 3), getBackupFileName(false, i4));
                int iB = -1;
                if (file.exists() && file.canRead() && (iB = com.tencent.smtt.utils.a.b(file)) <= 0) {
                    iB = com.tencent.smtt.utils.a.a(f18879c, file);
                }
                f18895s = iB;
                TbsLog.i(LOGTAG, "copyFromOldBackupDone oldBackupCoreVersion is " + iB);
                if (i2 == iB) {
                    File file2 = new File(FileUtil.a(f18879c, "com.tencent.mm", 4, true));
                    boolean zB = FileUtil.b(file, new File(file2, getBackupFileName(false, i4)));
                    TbsLog.i(LOGTAG, "copyFromOldBackupDone #01 result is " + zB);
                    if (zB) {
                        File[] fileArrListFiles = file2.listFiles();
                        Pattern patternCompile = Pattern.compile(com.tencent.smtt.utils.a.a(false, i4));
                        for (File file3 : fileArrListFiles) {
                            if (patternCompile.matcher(file3.getName()).find() && file3.isFile() && file3.exists()) {
                                file3.delete();
                            }
                        }
                        File file4 = new File(file2, com.tencent.smtt.utils.a.a(false, i4) + "." + i2);
                        if (!file4.exists()) {
                            file4.createNewFile();
                        }
                    }
                    return zB;
                }
            }
        } catch (Throwable th) {
            TbsLog.i(LOGTAG, "stack is " + Log.getStackTraceString(th));
        }
        TbsLog.i(LOGTAG, "copyFromOldBackupDone result is false  #10");
        return false;
    }

    static boolean a(Context context) {
        return TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1;
    }

    static boolean a(Context context, int i2) {
        return Build.VERSION.SDK_INT > 28 && context.getApplicationInfo().targetSdkVersion > 28 && i2 > 0 && i2 < 45114;
    }

    private static boolean a(Context context, boolean z2) {
        int i2;
        int i3;
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
        if (Build.VERSION.SDK_INT < 8) {
            i2 = ErrorConstant.ERROR_PARAM_ILLEGAL;
        } else {
            if (!tbsDownloadConfig.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA)) {
                if (z2 && !"com.tencent.mm".equals(context.getApplicationInfo().packageName)) {
                    TbsLog.i(LOGTAG, "needDownload-oversea is true, but not WX");
                    z2 = false;
                }
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA, Boolean.valueOf(z2));
                tbsDownloadConfig.commit();
                f18889m = z2;
                TbsLog.i(LOGTAG, "needDownload-first-called--isoversea = " + z2);
            }
            if (!getOverSea(context) || (i3 = Build.VERSION.SDK_INT) == 16 || i3 == 17 || i3 == 18) {
                f18881e = tbsDownloadConfig.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_DEVICE_CPUABI, null);
                if (TextUtils.isEmpty(f18881e) || com.tencent.smtt.utils.b.a(f18881e)) {
                    return true;
                }
                TbsLog.e(LOGTAG, "can not support x86 devices!!");
                i2 = -104;
            } else {
                TbsLog.i(LOGTAG, "needDownload- return false,  because of  version is " + Build.VERSION.SDK_INT + ", and overea");
                i2 = ErrorConstant.ERROR_REMOTE_CALL_FAIL;
            }
        }
        tbsDownloadConfig.setDownloadInterruptCode(i2);
        return false;
    }

    private static boolean a(Context context, boolean z2, boolean z3) throws IOException {
        String str;
        boolean z4;
        boolean z5;
        String str2;
        final TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
        c.a().a(context, (Integer) 1000, new c.a() { // from class: com.tencent.smtt.sdk.TbsDownloader.1
            @Override // com.tencent.smtt.sdk.c.a
            public void a(String str3) {
                TbsLog.i(TbsDownloader.LOGTAG, "Execute command [1000](" + str3 + "), force tbs downloader request");
                SharedPreferences.Editor editorEdit = tbsDownloadConfig.mPreferences.edit();
                editorEdit.putLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK, 0L);
                editorEdit.apply();
            }
        });
        if (z2) {
            TbsLog.i(LOGTAG, "needSendRequest true download foreground, stack: " + Log.getStackTraceString(new Throwable()));
            str = null;
            z4 = true;
        } else {
            String string = tbsDownloadConfig.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, null);
            int i2 = tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, 0);
            String string2 = tbsDownloadConfig.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_METADATA, null);
            String strD = com.tencent.smtt.utils.b.d(f18879c);
            int iE = com.tencent.smtt.utils.b.e(f18879c);
            String strA = com.tencent.smtt.utils.b.a(f18879c, TBS_METADATA);
            TbsLog.i(LOGTAG, "[TbsDownloader.needSendQueryRequest] appVersionName=" + strD + " oldAppVersionName=" + string + " appVersionCode=" + iE + " oldAppVersionCode=" + i2 + " appMetadata=" + strA + " oldAppVersionMetadata=" + string2);
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j2 = tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK, 0L);
            StringBuilder sb = new StringBuilder();
            sb.append("[TbsDownloader.needSendQueryRequest] timeLastCheck=");
            sb.append(j2);
            sb.append(" timeNow=");
            sb.append(jCurrentTimeMillis);
            TbsLog.i(LOGTAG, sb.toString());
            if (z3) {
                boolean zContains = tbsDownloadConfig.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK);
                TbsLog.i(LOGTAG, "[TbsDownloader.needSendQueryRequest] hasLaskCheckKey=" + zContains);
                if (zContains && j2 == 0) {
                    j2 = jCurrentTimeMillis;
                }
            }
            long j3 = tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_REQUEST_SUCCESS, 0L);
            long j4 = tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, 0L);
            long retryInterval = tbsDownloadConfig.getRetryInterval();
            TbsLog.i(LOGTAG, "retryInterval = " + retryInterval + " s");
            TbsPVConfig.releaseInstance();
            int emergentCoreVersion = TbsPVConfig.getInstance(f18879c).getEmergentCoreVersion();
            int i3 = TbsDownloadConfig.getInstance(f18879c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
            long j5 = jCurrentTimeMillis - j2;
            long j6 = retryInterval * 1000;
            if (j5 > j6) {
                str2 = "needSendRequest  true  #1";
            } else if (emergentCoreVersion > o.a().h(f18879c) && emergentCoreVersion > i3) {
                str2 = "emergentCoreVersion is " + emergentCoreVersion + " getTbsCoreInstalledVerInNolock is " + o.a().h(f18879c) + " responseCoreVersion is " + i3;
            } else if (TbsShareManager.isThirdPartyApp(f18879c) && j3 > 0 && jCurrentTimeMillis - j3 > j6 && j4 < 11) {
                str2 = "needSendRequest  true  #3";
            } else if (TbsShareManager.isThirdPartyApp(f18879c) && QbSdk.getTbsVersion(f18879c) == 0 && !e()) {
                TbsLog.i(LOGTAG, "needSendRequest  true  #4");
                o.a().e(f18879c);
                str = null;
                z5 = true;
                z4 = z5;
            } else {
                if (strD == null || iE == 0 || strA == null) {
                    if (TbsShareManager.isThirdPartyApp(f18879c)) {
                        str = "timeNow - timeLastCheck is " + j5 + " sendRequestWithSameHostCoreVersion() is " + e() + " appVersionName is " + strD + " appVersionCode is " + iE + " appMetadata is " + strA + " oldAppVersionName is " + string + " oldAppVersionCode is " + i2 + " oldAppVersionMetadata is " + string2;
                    }
                    z5 = false;
                    z4 = z5;
                } else if (!strD.equals(string) || iE != i2 || !strA.equals(string2)) {
                    str2 = "needSendRequest  true  #5";
                }
                str = null;
                z5 = false;
                z4 = z5;
            }
            TbsLog.i(LOGTAG, str2);
            str = null;
            z5 = true;
            z4 = z5;
        }
        if (!z4 && TbsShareManager.isThirdPartyApp(f18879c)) {
            TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(f18879c).tbsLogInfo();
            tbsLogInfo.setErrorCode(-119);
            tbsLogInfo.setFailDetail(str);
            TbsLogReport.getInstance(f18879c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo);
        }
        return z4;
    }

    @TargetApi(11)
    private static boolean a(String str, int i2, boolean z2, boolean z3, boolean z4) throws Exception {
        String str2;
        JSONObject jSONObject;
        int i3;
        boolean z5;
        String str3;
        Integer num;
        String str4;
        String str5;
        int tbsVersion;
        TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] response=" + str + ";isNeedInstall=" + z4);
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(f18879c);
        if (TextUtils.isEmpty(str)) {
            tbsDownloadConfig.setDownloadInterruptCode(ErrorConstant.ERROR_GET_PROCESS_NULL);
            TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] return #1,response is empty...");
            return false;
        }
        JSONObject jSONObject2 = new JSONObject(str);
        int i4 = jSONObject2.getInt("RET");
        if (i4 != 0) {
            tbsDownloadConfig.setDownloadInterruptCode(-109);
            TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] return #2,returnCode=" + i4);
            return false;
        }
        int i5 = jSONObject2.getInt("RESPONSECODE");
        String string = jSONObject2.getString("DOWNLOADURL");
        String strOptString = jSONObject2.optString("URLLIST", "");
        int i6 = jSONObject2.getInt("TBSAPKSERVERVERSION");
        if (!QbSdk.isCoreVerEnabled(f18879c, i6)) {
            tbsDownloadConfig.setDownloadInterruptCode(-126);
            return false;
        }
        int i7 = jSONObject2.getInt("DOWNLOADMAXFLOW") * 2;
        int i8 = jSONObject2.getInt("DOWNLOAD_MIN_FREE_SPACE");
        int i9 = jSONObject2.getInt("DOWNLOAD_SUCCESS_MAX_RETRYTIMES");
        int i10 = jSONObject2.getInt("DOWNLOAD_FAILED_MAX_RETRYTIMES");
        long j2 = jSONObject2.getLong("DOWNLOAD_SINGLE_TIMEOUT");
        long j3 = jSONObject2.getLong("TBSAPKFILESIZE");
        long jOptLong = jSONObject2.optLong("RETRY_INTERVAL", 0L);
        int iOptInt = jSONObject2.optInt("FLOWCTR", -1);
        int iOptInt2 = jSONObject2.optInt("USEX5", 1);
        i();
        h();
        if (iOptInt2 == 0 && (tbsVersion = QbSdk.getTbsVersion(f18879c)) != 0) {
            c(tbsVersion);
        }
        try {
            if (TextUtils.isEmpty(string)) {
                str2 = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(i6);
                str2 = string.contains(sb.toString()) ? "B" : string;
            }
        } catch (Throwable th) {
            TbsLog.i(LOGTAG, "throwable is " + Log.getStackTraceString(th));
            str2 = "";
        }
        com.tencent.smtt.utils.s.a("6is" + str2);
        int iOptInt3 = jSONObject2.optInt("USEBBACKUPVER", 0);
        try {
            iOptInt3 = jSONObject2.getInt("USEBBACKUPVER");
        } catch (Exception unused) {
        }
        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_USE_BACKUP_VERSION, Integer.valueOf(iOptInt3));
        String strOptString2 = jSONObject2.optString("PKGMD5", null);
        int iOptInt4 = jSONObject2.optInt("RESETX5", 0);
        int iOptInt5 = jSONObject2.optInt("UPLOADLOG", 0);
        jSONObject2.optInt("RESETDECOUPLECORE", 0);
        String strOptString3 = jSONObject2.optString("SETTOKEN", "");
        boolean z6 = jSONObject2.optInt("RESETTOKEN", 0) != 0;
        boolean z7 = jSONObject2.optInt("ENABLE_LOAD_RENAME_FILE_LOCK_WAIT", 1) != 0;
        int iOptInt6 = jSONObject2.optInt("RESETTODECOUPLECORE", 0);
        synchronized (f18882f) {
            if (z6) {
                jSONObject = jSONObject2;
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DESkEY_TOKEN, "");
            } else {
                jSONObject = jSONObject2;
            }
            if (!TextUtils.isEmpty(strOptString3) && strOptString3.length() == 96) {
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DESkEY_TOKEN, strOptString3 + DispatchConstants.SIGN_SPLIT_SYMBOL + com.tencent.smtt.utils.h.c());
            }
        }
        if (iOptInt4 != 1) {
            if (!z7) {
                tbsDownloadConfig.setTbsCoreLoadRenameFileLockWaitEnable(z7);
            }
            if (iOptInt5 == 1) {
                f18880d.removeMessages(104);
                Message.obtain(f18880d, 104).sendToTarget();
            }
            if (iOptInt == 1) {
                long j4 = jOptLong <= 604800 ? jOptLong : 604800L;
                retryIntervalInSeconds = j4 > 0 ? j4 : 86400L;
                TbsLog.w(LOGTAG, "Download is Flowed, next download request is " + retryIntervalInSeconds + "s later");
                if (TbsShareManager.isThirdPartyApp(f18879c)) {
                    tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false);
                    tbsDownloadConfig.commit();
                    tbsDownloadConfig.setDownloadInterruptCode(TbsCommonCode.DOWNLOAD_FLOW_CANCEL);
                    return false;
                }
            }
            if (getRetryIntervalInSeconds() >= 0) {
                retryIntervalInSeconds = getRetryIntervalInSeconds();
            }
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_RETRY_INTERVAL, Long.valueOf(retryIntervalInSeconds));
            if (TextUtils.isEmpty(string) && TbsShareManager.isThirdPartyApp(f18879c)) {
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false);
                tbsDownloadConfig.commit();
                tbsDownloadConfig.setDownloadInterruptCode(-124);
                str4 = LOGTAG;
                str5 = "[TbsDownloader.readResponse] blank url,current app is third app...";
            } else {
                TbsLog.i(LOGTAG, "in response responseCode is " + i5);
                if (i5 == 0) {
                    tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, Integer.valueOf(i5));
                    tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false);
                    tbsDownloadConfig.setDownloadInterruptCode(-111);
                    tbsDownloadConfig.commit();
                    TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] return #5,responseCode=0");
                    return false;
                }
                int i11 = TbsDownloadConfig.getInstance(f18879c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
                if (i11 > i6) {
                    f18883g.b();
                    o.a().n(f18879c);
                }
                if (TbsShareManager.isThirdPartyApp(f18879c)) {
                    i3 = i2;
                    z5 = false;
                } else {
                    int iD = o.a().d(f18879c, 0);
                    z5 = iD >= i6;
                    TbsLog.i(LOGTAG, "tmpCoreVersion is " + iD + " tbsDownloadVersion is" + i6);
                    i3 = i2;
                }
                if (i3 >= i6 || TextUtils.isEmpty(string) || z5) {
                    tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false);
                    tbsDownloadConfig.commit();
                    tbsDownloadConfig.setDownloadInterruptCode(TextUtils.isEmpty(string) ? -124 : i6 <= 0 ? -125 : i3 >= i6 ? -127 : -112);
                    str3 = "version error or downloadUrl empty ,return ahead tbsLocalVersion=" + i3 + " tbsDownloadVersion=" + i6 + " tbsLastDownloadVersion=" + i11 + " downloadUrl=" + string;
                } else {
                    if (string.equals(tbsDownloadConfig.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOADURL, null))) {
                        num = 0;
                    } else {
                        f18883g.b();
                        num = 0;
                        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, null);
                        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, null);
                    }
                    tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, Integer.valueOf(i6));
                    TbsLog.i(LOGTAG, "put KEY_TBS_DOWNLOAD_V is " + i6);
                    if (i6 > 0) {
                        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, num);
                    }
                    tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOADURL, string);
                    tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADURL_LIST, strOptString);
                    tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, Integer.valueOf(i5));
                    tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_MAXFLOW, Integer.valueOf(i7));
                    tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_MIN_FREE_SPACE, Integer.valueOf(i8));
                    tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES, Integer.valueOf(i9));
                    tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES, Integer.valueOf(i10));
                    tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SINGLE_TIMEOUT, Long.valueOf(j2));
                    tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, Long.valueOf(j3));
                    tbsDownloadConfig.commit();
                    if (strOptString2 != null) {
                        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPK_MD5, strOptString2);
                    }
                    if (z3 || !z4 || !o.a().b(f18879c, i6)) {
                        if (!z2) {
                            tbsDownloadConfig.setDownloadInterruptCode(-216);
                        }
                        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, true);
                        TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] ##9 set needDownload=true");
                        if (jSONObject.optInt("stop_pre_oat", 0) == 1) {
                            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_STOP_PRE_OAT, true);
                        }
                        tbsDownloadConfig.commit();
                        return true;
                    }
                    tbsDownloadConfig.setDownloadInterruptCode(-213);
                    tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false);
                    str4 = LOGTAG;
                    str5 = "[TbsDownloader.readResponse] ##6 set needDownload=false";
                }
            }
            TbsLog.i(str4, str5);
            return false;
        }
        tbsDownloadConfig.setDownloadInterruptCode(-110);
        QbSdk.reset(f18879c, iOptInt6 == 1);
        str3 = "[TbsDownloader.readResponse] return #3,needResetTbs=1,isQuery=" + z2;
        TbsLog.i(LOGTAG, str3);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.lang.String b(android.content.Context r7) {
        /*
            java.lang.String r0 = "ISO8859-1"
            java.lang.String r1 = "UTF-8"
            java.lang.String r2 = com.tencent.smtt.sdk.TbsDownloader.b
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto Lf
            java.lang.String r7 = com.tencent.smtt.sdk.TbsDownloader.b
            return r7
        Lf:
            java.util.Locale r2 = java.util.Locale.getDefault()
            java.lang.StringBuffer r3 = new java.lang.StringBuffer
            r3.<init>()
            java.lang.String r4 = android.os.Build.VERSION.RELEASE
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Exception -> L25
            byte[] r6 = r4.getBytes(r1)     // Catch: java.lang.Exception -> L25
            r5.<init>(r6, r0)     // Catch: java.lang.Exception -> L25
            r4 = r5
            goto L26
        L25:
        L26:
            java.lang.String r5 = "1.0"
            if (r4 != 0) goto L2e
        L2a:
            r3.append(r5)
            goto L37
        L2e:
            int r6 = r4.length()
            if (r6 <= 0) goto L2a
            r3.append(r4)
        L37:
            java.lang.String r4 = "; "
            r3.append(r4)
            java.lang.String r5 = r2.getLanguage()
            if (r5 == 0) goto L59
            java.lang.String r5 = r5.toLowerCase()
            r3.append(r5)
            java.lang.String r2 = r2.getCountry()
            if (r2 == 0) goto L5e
            java.lang.String r5 = "-"
            r3.append(r5)
            java.lang.String r2 = r2.toLowerCase()
            goto L5b
        L59:
            java.lang.String r2 = "en"
        L5b:
            r3.append(r2)
        L5e:
            java.lang.String r2 = android.os.Build.VERSION.CODENAME
            java.lang.String r5 = "REL"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L8a
            java.lang.String r7 = com.tencent.smtt.utils.s.c(r7)
            java.lang.String r2 = new java.lang.String     // Catch: java.lang.Exception -> L77
            byte[] r1 = r7.getBytes(r1)     // Catch: java.lang.Exception -> L77
            r2.<init>(r1, r0)     // Catch: java.lang.Exception -> L77
            r7 = r2
            goto L78
        L77:
        L78:
            if (r7 != 0) goto L7e
            r3.append(r4)
            goto L8a
        L7e:
            int r0 = r7.length()
            if (r0 <= 0) goto L8a
            r3.append(r4)
            r3.append(r7)
        L8a:
            java.lang.String r7 = android.os.Build.ID
            java.lang.String r0 = ""
            if (r7 != 0) goto L91
            r7 = r0
        L91:
            java.lang.String r1 = "[一-龥]"
            java.lang.String r7 = r7.replaceAll(r1, r0)
            java.lang.String r0 = " Build/"
            if (r7 != 0) goto La4
            r3.append(r0)
            java.lang.String r7 = "00"
        La0:
            r3.append(r7)
            goto Lae
        La4:
            int r1 = r7.length()
            if (r1 <= 0) goto Lae
            r3.append(r0)
            goto La0
        Lae:
            r7 = 1
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r0 = 0
            r7[r0] = r3
            java.lang.String r0 = "Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1"
            java.lang.String r7 = java.lang.String.format(r0, r7)
            com.tencent.smtt.sdk.TbsDownloader.b = r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloader.b(android.content.Context):java.lang.String");
    }

    private static void b(int i2) {
        JSONObject jSONObject = f18896t;
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("FUNCTION", 2);
            String strG = com.tencent.smtt.utils.o.a(f18879c).g();
            TbsLog.i(LOGTAG, "[TbsDownloader.resetOtherCpuStableCore] postUrl=" + strG);
            TbsLog.i(LOGTAG, "[TbsDownloader.resetOtherCpuStableCore] mJsonDataQueryReset=" + f18896t.toString());
            String strA = com.tencent.smtt.utils.g.a(strG, f18896t.toString().getBytes(com.anythink.expressad.foundation.g.a.bN), new g.a() { // from class: com.tencent.smtt.sdk.TbsDownloader.5
                @Override // com.tencent.smtt.utils.g.a
                public void a(int i3) {
                }
            }, false);
            TbsLog.i(LOGTAG, "[TbsDownloader.resetOtherCpuStableCore] response=" + strA);
            f18894r = 0;
            JSONObject jSONObject2 = new JSONObject(strA);
            if (jSONObject2.getInt("RESETDECOUPLECORE") != 1) {
                f18894r = jSONObject2.getInt("DECOUPLECOREVERSION");
                return;
            }
            Context packageContext = TbsShareManager.getPackageContext(f18879c, "com.tencent.mm", false);
            File file = packageContext == null ? new File(FileUtil.a(f18879c, "com.tencent.mm", 4, true)) : new File(FileUtil.a(packageContext, 4));
            TbsLog.i(LOGTAG, "[TbsDownloader.resetOtherCpuStableCore] resetDecoupleCore mFilePathStable is " + file.getAbsolutePath(), true);
            File[] fileArrListFiles = file.listFiles();
            Pattern patternCompile = Pattern.compile(com.tencent.smtt.utils.a.a(false, i2));
            for (File file2 : fileArrListFiles) {
                if (patternCompile.matcher(file2.getName()).find() && file2.isFile() && file2.exists()) {
                    TbsLog.i(LOGTAG, "resetOtherCpuStableCore file is " + file2.getAbsolutePath(), true);
                    file2.delete();
                }
            }
            File file3 = new File(file, getBackupFileName(false, i2));
            TbsLog.i(LOGTAG, "resetOtherCpuStableCore file is " + file3.getAbsolutePath(), true);
            file3.delete();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(final boolean z2, boolean z3, boolean z4, boolean z5) throws Throwable {
        boolean zA;
        String strG;
        String strD;
        final TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(f18879c);
        l.b(f18879c);
        Map<String, Object> map = QbSdk.f18850o;
        if (map != null && map.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && QbSdk.f18850o.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals(ITagManager.STATUS_FALSE)) {
            TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
            tbsDownloadConfig.setDownloadInterruptCode(-131);
            return false;
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest]isQuery: " + z2 + " forDecoupleCore is " + z4);
        if (o.a().d(f18879c)) {
            TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest] -- isTbsLocalInstalled!");
            tbsDownloadConfig.setDownloadInterruptCode(-132);
            return false;
        }
        if (f18881e == null) {
            f18881e = com.tencent.smtt.utils.b.a();
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DEVICE_CPUABI, f18881e);
            tbsDownloadConfig.commit();
        }
        if (!TextUtils.isEmpty(f18881e) && !com.tencent.smtt.utils.b.a(f18881e)) {
            tbsDownloadConfig.setDownloadInterruptCode(-104);
            TbsLog.i(LOGTAG, "TbsDownloader sendRequest cpu is invalid:" + f18881e);
            return false;
        }
        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, com.tencent.smtt.utils.b.d(f18879c));
        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, Integer.valueOf(com.tencent.smtt.utils.b.e(f18879c)));
        tbsDownloadConfig.commit();
        JSONObject jSONObjectA = a(z2, z3, z4);
        int iOptInt = jSONObjectA.optInt("TBSV", -1);
        if (iOptInt != -1) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (TbsShareManager.isThirdPartyApp(f18879c)) {
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, Long.valueOf(jCurrentTimeMillis - tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_REQUEST_FAIL, 0L) < tbsDownloadConfig.getRetryInterval() * 1000 ? tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, 0L) + 1 : 1L));
            }
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_REQUEST_FAIL, Long.valueOf(jCurrentTimeMillis));
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, com.tencent.smtt.utils.b.d(f18879c));
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, Integer.valueOf(com.tencent.smtt.utils.b.e(f18879c)));
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_APP_METADATA, com.tencent.smtt.utils.b.a(f18879c, TBS_METADATA));
            tbsDownloadConfig.commit();
        }
        if (iOptInt == -1 && !z4) {
            tbsDownloadConfig.setDownloadInterruptCode(-113);
            return false;
        }
        try {
            strG = com.tencent.smtt.utils.o.a(f18879c).g();
            TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest] postUrl=" + strG);
            if (z2) {
                try {
                    f18891o = jSONObjectA;
                } catch (Throwable th) {
                    th = th;
                    zA = false;
                }
            } else {
                f18892p = jSONObjectA;
            }
            strD = null;
            if (com.tencent.smtt.utils.s.d(f18879c)) {
                try {
                    int i2 = jSONObjectA.getInt("FUNCTION");
                    if (i2 == 0 && !TextUtils.isEmpty(com.tencent.smtt.utils.o.a(f18879c).f())) {
                        strD = com.tencent.smtt.utils.o.a(f18879c).f();
                    } else if (i2 == 1 && !TextUtils.isEmpty(com.tencent.smtt.utils.o.a(f18879c).e())) {
                        strD = com.tencent.smtt.utils.o.a(f18879c).e();
                    } else if (i2 == 2 && !TextUtils.isEmpty(com.tencent.smtt.utils.o.a(f18879c).d())) {
                        strD = com.tencent.smtt.utils.o.a(f18879c).d();
                    }
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        if (strD == null) {
            if (z2) {
                return true;
            }
            strD = com.tencent.smtt.utils.g.a(strG, jSONObjectA.toString().getBytes(com.anythink.expressad.foundation.g.a.bN), new g.a() { // from class: com.tencent.smtt.sdk.TbsDownloader.3
                @Override // com.tencent.smtt.utils.g.a
                public void a(int i3) {
                    TbsDownloadConfig tbsDownloadConfig2;
                    int i4;
                    tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK, Long.valueOf(System.currentTimeMillis()));
                    tbsDownloadConfig.commit();
                    TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.sendRequest] httpResponseCode=" + i3);
                    if (TbsShareManager.isThirdPartyApp(TbsDownloader.f18879c) && i3 == 200) {
                        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_LAST_REQUEST_SUCCESS, Long.valueOf(System.currentTimeMillis()));
                        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_REQUEST_FAIL, 0L);
                        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, 0L);
                        tbsDownloadConfig.commit();
                    }
                    if (i3 >= 300) {
                        if (z2) {
                            tbsDownloadConfig2 = tbsDownloadConfig;
                            i4 = -107;
                        } else {
                            tbsDownloadConfig2 = tbsDownloadConfig;
                            i4 = -207;
                        }
                        tbsDownloadConfig2.setDownloadInterruptCode(i4);
                    }
                }
            }, false);
            if (strD != null && strD.contains("HttpError")) {
                TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(f18879c).tbsLogInfo();
                tbsLogInfo.setErrorCode(-129);
                tbsLogInfo.setFailDetail(strD);
                TbsLogReport.getInstance(f18879c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo);
            }
            zA = false;
            TbsLog.i(LOGTAG, "sendrequest return false " + Log.getStackTraceString(th));
            th.printStackTrace();
            tbsDownloadConfig.setDownloadInterruptCode(-106);
            return zA;
        }
        zA = a(strD, iOptInt, z2, z3, z5);
        try {
            TbsLog.i(LOGTAG, "sendrequest return false #2");
            return zA;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static void c(int i2) {
        File file = new File(o.r(f18879c), "tbs_switch_disable_" + i2);
        if (file.exists()) {
            return;
        }
        try {
            TbsLog.i(LOGTAG, "setTbsCoreDisabledBySwitch status: " + file.createNewFile());
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @TargetApi(11)
    static void c(Context context) {
        TbsDownloadConfig.getInstance(context).clear();
        TbsLogReport.getInstance(context).clear();
        l.e(context);
        (Build.VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_extension_config", 4) : context.getSharedPreferences("tbs_extension_config", 0)).edit().clear().commit();
        (Build.VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit().clear().commit();
    }

    private static boolean c() {
        String str;
        TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded ");
        if (TbsShareManager.isThirdPartyApp(f18879c)) {
            return false;
        }
        TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #1");
        l.a(f18879c);
        l.b(f18879c);
        if (a(f18879c) || f18880d == null) {
            return false;
        }
        TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #2");
        if (System.currentTimeMillis() - TbsDownloadConfig.getInstance(f18879c).mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, 0L) < TbsDownloadConfig.getInstance(f18879c).getRetryInterval() * 1000) {
            return false;
        }
        TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #3");
        int i2 = TbsDownloadConfig.getInstance(f18879c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
        int tbsStableCoreVersion = com.tencent.smtt.utils.s.b(f18879c) ? TbsShareManager.getTbsStableCoreVersion(f18879c, 0) : o.a().g(f18879c);
        TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded coreVersionForThirdApp is " + tbsStableCoreVersion + " deCoupleCoreVersion is " + i2);
        if (i2 <= 0 || i2 <= tbsStableCoreVersion) {
            str = "startDecoupleCoreIfNeeded no need, deCoupleCoreVersion is " + i2 + " localStableCoreVersion is " + tbsStableCoreVersion;
        } else {
            if (a(i2, tbsStableCoreVersion, 0)) {
                TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(f18879c);
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_CPUTYPE_OTHER_STABLE_CORE, 0);
                tbsDownloadConfig.commit();
                TbsLog.i(LOGTAG, "startDecoupleCoreIfNeededImpl stable core " + i2 + " copy from old backup and return ");
                return false;
            }
            if (TbsDownloadConfig.getInstance(f18879c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) != i2 || TbsDownloadConfig.getInstance(f18879c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #4");
                a = true;
                f18880d.removeMessages(108);
                Message messageObtain = Message.obtain(f18880d, 108, QbSdk.f18849n);
                messageObtain.arg1 = 0;
                messageObtain.sendToTarget();
                TbsDownloadConfig.getInstance(f18879c).mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, Long.valueOf(System.currentTimeMillis()));
                return true;
            }
            str = "startDecoupleCoreIfNeeded no need, KEY_TBS_DOWNLOAD_V is " + TbsDownloadConfig.getInstance(f18879c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) + " deCoupleCoreVersion is " + i2 + " KEY_TBS_DOWNLOAD_V_TYPE is " + TbsDownloadConfig.getInstance(f18879c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0);
        }
        TbsLog.i(LOGTAG, str);
        return false;
    }

    private static synchronized void d() {
        if (f18884h == null) {
            f18884h = n.a();
            try {
                f18883g = new l(f18879c);
                f18880d = new Handler(f18884h.getLooper()) { // from class: com.tencent.smtt.sdk.TbsDownloader.2
                    @Override // android.os.Handler
                    public void handleMessage(Message message) throws Throwable {
                        int i2 = message.what;
                        if (i2 == 109) {
                            if (TbsDownloader.f18883g != null) {
                                TbsDownloader.f18883g.e();
                                return;
                            }
                            return;
                        }
                        switch (i2) {
                            case 100:
                                boolean z2 = message.arg1 == 1;
                                boolean zB = TbsDownloader.b(true, false, false, message.arg2 == 1);
                                Object obj = message.obj;
                                if (obj != null && (obj instanceof TbsDownloaderCallback)) {
                                    TbsLog.i(TbsDownloader.LOGTAG, "needDownload-onNeedDownloadFinish needStartDownload=" + zB);
                                    String str = (TbsDownloader.f18879c == null || TbsDownloader.f18879c.getApplicationContext() == null || TbsDownloader.f18879c.getApplicationContext().getApplicationInfo() == null) ? "" : TbsDownloader.f18879c.getApplicationContext().getApplicationInfo().packageName;
                                    if (!zB || z2) {
                                        ((TbsDownloaderCallback) message.obj).onNeedDownloadFinish(zB, TbsDownloadConfig.getInstance(TbsDownloader.f18879c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                                    } else if ("com.tencent.mm".equals(str) || TbsConfig.APP_QQ.equals(str)) {
                                        TbsLog.i(TbsDownloader.LOGTAG, "needDownload-onNeedDownloadFinish in mm or QQ callback needStartDownload = " + zB);
                                        ((TbsDownloaderCallback) message.obj).onNeedDownloadFinish(zB, TbsDownloadConfig.getInstance(TbsDownloader.f18879c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                                    }
                                }
                                if (TbsShareManager.isThirdPartyApp(TbsDownloader.f18879c) && zB) {
                                    TbsDownloader.startDownload(TbsDownloader.f18879c);
                                    break;
                                }
                                break;
                            case 101:
                                TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(TbsDownloader.f18879c);
                                if (Apn.getApnType(TbsDownloader.f18879c) == 3 || QbSdk.canDownloadWithoutWifi()) {
                                    String str2 = "tbs_download_lock_file" + TbsDownloadConfig.getInstance(TbsDownloader.f18879c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) + ".txt";
                                    TbsLog.i(TbsDownloader.LOGTAG, "---getting download file lock...");
                                    FileOutputStream fileOutputStreamB = FileUtil.b(TbsDownloader.f18879c, true, str2);
                                    if (fileOutputStreamB == null) {
                                        tbsDownloadConfig.setDownloadInterruptCode(ErrorConstant.ERROR_REQUEST_CANCEL);
                                        QbSdk.f18849n.onDownloadFinish(TbsListener.ErrorCode.STARTDOWNLOAD_LOCKED_IO_FAILED);
                                        QbSdk.f18849n.onInstallFinish(243);
                                        TbsLog.w(TbsDownloader.LOGTAG, "download file-lock file io exception");
                                    } else {
                                        FileLock fileLockA = FileUtil.a(TbsDownloader.f18879c, fileOutputStreamB);
                                        if (fileLockA != null) {
                                            boolean z3 = message.arg1 == 1;
                                            if (TbsDownloader.b(false, z3, false, true)) {
                                                if (z3 && o.a().b(TbsDownloader.f18879c, TbsDownloadConfig.getInstance(TbsDownloader.f18879c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0))) {
                                                    TbsLog.i(TbsDownloader.LOGTAG, "needStartDownload, but try local install core firstly");
                                                    QbSdk.f18849n.onDownloadFinish(122);
                                                    QbSdk.f18849n.onInstallFinish(243);
                                                    tbsDownloadConfig.setDownloadInterruptCode(-213);
                                                } else if (tbsDownloadConfig.mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false)) {
                                                    TbsDownloadConfig.getInstance(TbsDownloader.f18879c).setDownloadInterruptCode(-215);
                                                    TbsLog.i(TbsDownloader.LOGTAG, "start download in apk downloader...");
                                                    TbsDownloader.f18883g.a(z3, false);
                                                } else {
                                                    tbsDownloadConfig.setDownloadInterruptCode(-133);
                                                    QbSdk.f18849n.onDownloadFinish(TbsListener.ErrorCode.STARTDOWNLOAD_NEEDDOWNLOAD_KEY_ERROR);
                                                }
                                                TbsLog.i(TbsDownloader.LOGTAG, "------freeDownloadFileLock...");
                                                FileUtil.a(fileLockA, fileOutputStreamB);
                                            } else {
                                                int currentDownloadInterruptCode = TbsDownloadConfig.getInstance(TbsDownloader.f18879c).getCurrentDownloadInterruptCode();
                                                TbsLog.i(TbsDownloader.LOGTAG, "No need to download, code is " + currentDownloadInterruptCode);
                                                QbSdk.f18849n.onDownloadFinish(currentDownloadInterruptCode);
                                            }
                                            QbSdk.f18849n.onInstallFinish(243);
                                            TbsLog.i(TbsDownloader.LOGTAG, "------freeDownloadFileLock...");
                                            FileUtil.a(fileLockA, fileOutputStreamB);
                                        } else {
                                            tbsDownloadConfig.setDownloadInterruptCode(ErrorConstant.ERROR_NO_STRATEGY);
                                            QbSdk.f18849n.onDownloadFinish(177);
                                            QbSdk.f18849n.onInstallFinish(243);
                                            TbsLog.i(TbsDownloader.LOGTAG, "download file-lock locked, core is downloading");
                                        }
                                    }
                                } else {
                                    TbsLog.i(TbsDownloader.LOGTAG, "not wifi,no need send request");
                                    tbsDownloadConfig.setDownloadInterruptCode(-220);
                                    QbSdk.f18849n.onDownloadFinish(111);
                                    QbSdk.f18849n.onInstallFinish(243);
                                }
                                break;
                            case 102:
                                TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
                                int iL = o.a().l(TbsDownloader.f18879c);
                                TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] localTbsVersion=" + iL);
                                TbsDownloader.f18883g.a(iL);
                                TbsLogReport.getInstance(TbsDownloader.f18879c).dailyReport();
                                break;
                            case 103:
                                TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
                                if (message.arg1 == 0) {
                                    o.a().a((Context) message.obj, true);
                                }
                                break;
                            case 104:
                                TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_UPLOAD_TBSLOG");
                                TbsLogReport.getInstance(TbsDownloader.f18879c).reportTbsLog();
                                break;
                        }
                    }
                };
            } catch (Exception unused) {
                f18886j = true;
                TbsLog.e(LOGTAG, "TbsApkDownloader init has Exception");
            }
        }
    }

    private static boolean e() {
        try {
            return TbsDownloadConfig.getInstance(f18879c).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION, "").equals(f().toString());
        } catch (Exception unused) {
            return false;
        }
    }

    private static JSONArray f() {
        if (!TbsShareManager.isThirdPartyApp(f18879c)) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        int tbsVersion = QbSdk.getTbsVersion(f18879c);
        if (tbsVersion > 0) {
            jSONArray.put(tbsVersion);
        }
        return jSONArray;
    }

    private static boolean g() {
        int i2;
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(f18879c);
        if (tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, 0) >= tbsDownloadConfig.getDownloadSuccessMaxRetrytimes()) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] out of success retrytimes", true);
            i2 = -115;
        } else if (tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, 0) >= tbsDownloadConfig.getDownloadFailedMaxRetrytimes()) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] out of failed retrytimes", true);
            i2 = -116;
        } else {
            if (FileUtil.b(f18879c)) {
                if (System.currentTimeMillis() - tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_STARTTIME, 0L) <= 86400000) {
                    long j2 = tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, 0L);
                    TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] downloadFlow=" + j2);
                    if (j2 >= tbsDownloadConfig.getDownloadMaxflow()) {
                        TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] failed because you exceeded max flow!", true);
                        i2 = -120;
                    }
                }
                return true;
            }
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] local rom freespace limit", true);
            i2 = -117;
        }
        tbsDownloadConfig.setDownloadInterruptCode(i2);
        return false;
    }

    public static String getBackupFileName(boolean z2) {
        return getBackupFileName(z2, 0);
    }

    public static String getBackupFileName(boolean z2, int i2) {
        boolean zC = i2 == 64 ? true : i2 == 32 ? false : com.tencent.smtt.utils.b.c();
        return z2 ? zC ? "x5.tbs.decouple.64" : "x5.tbs.decouple" : zC ? "x5.tbs.org.64" : "x5.tbs.org";
    }

    public static int getCoreShareDecoupleCoreVersion() {
        return o.a().g(f18879c);
    }

    public static int getCoreShareDecoupleCoreVersionByContext(Context context) {
        return o.a().g(context);
    }

    public static int getNextPostInterval(Context context) {
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
        long j2 = tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK, 0L);
        return Math.max((int) (((tbsDownloadConfig.getRetryInterval() * 1000) - (System.currentTimeMillis() - j2)) / 1000), 0);
    }

    public static synchronized boolean getOverSea(Context context) {
        if (!f18890n) {
            f18890n = true;
            TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
            if (tbsDownloadConfig.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA)) {
                f18889m = tbsDownloadConfig.mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA, false);
                TbsLog.i(LOGTAG, "[TbsDownloader.getOverSea]  first called. sOverSea = " + f18889m);
            }
            TbsLog.i(LOGTAG, "[TbsDownloader.getOverSea]  sOverSea = " + f18889m);
        }
        return f18889m;
    }

    public static long getRetryIntervalInSeconds() {
        return f18897u;
    }

    public static HandlerThread getsTbsHandlerThread() {
        return f18884h;
    }

    private static void h() {
        File fileR = o.r(f18879c);
        if (fileR == null) {
            return;
        }
        File[] fileArrListFiles = fileR.listFiles();
        Pattern patternCompile = Pattern.compile("tbs_switch_disable_(.*)");
        for (File file : fileArrListFiles) {
            if (patternCompile.matcher(file.getName()).find() && file.isFile() && file.exists() && file.canRead()) {
                TbsLog.i(LOGTAG, "clearTbsCoreDisableFlagFiles: " + file.getName() + "; res: " + file.delete());
            }
        }
    }

    private static void i() {
        File file = new File(o.r(f18879c), "switch_disable_check");
        if (file.exists()) {
            return;
        }
        try {
            TbsLog.i(LOGTAG, "addSwitchDisableCheckFlag status: " + file.createNewFile());
        } catch (IOException e2) {
            TbsLog.i(LOGTAG, "" + e2);
        }
    }

    public static boolean isDownloadForeground() {
        l lVar = f18883g;
        return lVar != null && lVar.c();
    }

    public static synchronized boolean isDownloading() {
        TbsLog.i(LOGTAG, "[TbsDownloader.isDownloading] is " + a);
        return a;
    }

    public static boolean isTbsCoreDisabledBySwitch(Context context, int i2) {
        return new File(o.r(context), "tbs_switch_disable_" + i2).exists();
    }

    public static boolean needDownload(Context context, boolean z2) {
        return needDownload(context, z2, false, true, null);
    }

    public static boolean needDownload(Context context, boolean z2, boolean z3, TbsDownloaderCallback tbsDownloaderCallback) {
        return needDownload(context, z2, z3, true, tbsDownloaderCallback);
    }

    public static boolean needDownload(Context context, boolean z2, boolean z3, boolean z4, TbsDownloaderCallback tbsDownloaderCallback) throws Throwable {
        int i2;
        TbsShareManager.mHasQueryed = true;
        f18879c = context.getApplicationContext();
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(f18879c);
        tbsDownloadConfig.setDownloadInterruptCode(-100);
        com.tencent.smtt.utils.s.a(context, "need_download", "");
        com.tencent.smtt.utils.s.a("1");
        TbsLog.initIfNeed(context);
        TbsLog.i(LOGTAG, "needDownload,process=" + QbSdk.getCurrentProcessName(context) + "stack=" + Log.getStackTraceString(new Throwable()));
        o.a().b(context, g.a == 0);
        int iB = o.a().b(context);
        TbsLog.i(LOGTAG, "[TbsDownloader.needDownload],renameRet=" + iB);
        if (iB != 0) {
            TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
            tbsLogInfo.a = 129;
            tbsLogInfo.setFailDetail("code=2" + iB);
        }
        if (iB < 0) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload],needReNameFile=" + iB);
            tbsDownloadConfig.setDownloadInterruptCode(-128);
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            return false;
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.needDownload] oversea=" + z2 + ",isDownloadForeground=" + z3);
        if (o.a) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#1 Static Installing, return false");
            tbsDownloadConfig.setDownloadInterruptCode(-130);
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            return false;
        }
        TbsLog.app_extra(LOGTAG, context);
        if (!a(f18879c, z2)) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#2 Not shouldDoNeedDownload, return false");
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            return false;
        }
        d();
        if (f18886j) {
            tbsDownloadConfig.setDownloadInterruptCode(ErrorConstant.ERROR_ACCS_CUSTOM_FRAME_CB_NULL);
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#3 TbsApkDownloader init Exception, return false");
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            return false;
        }
        boolean zA = a(f18879c, z3, false);
        TbsLog.i(LOGTAG, "[TbsDownloader.needDownload],needSendRequest=" + zA);
        if (zA) {
            a(z3, tbsDownloaderCallback, z4);
            i2 = -114;
        } else {
            i2 = TbsCommonCode.DOWNLOAD_NO_NEED_REQUEST;
        }
        tbsDownloadConfig.setDownloadInterruptCode(i2);
        f18880d.removeMessages(102);
        Message.obtain(f18880d, 102).sendToTarget();
        boolean zContains = tbsDownloadConfig.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD);
        TbsLog.i(LOGTAG, "[TbsDownloader.needDownload] hasNeedDownloadKey=" + zContains);
        boolean z5 = (zContains || TbsShareManager.isThirdPartyApp(context)) ? tbsDownloadConfig.mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false) : true;
        TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#4,needDownload=" + z5 + ",hasNeedDownloadKey=" + zContains);
        if (!z5) {
            int iL = o.a().l(f18879c);
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#7,tbsLocalVersion=" + iL + ",needSendRequest=" + zA);
            if (zA || iL <= 0) {
                f18880d.removeMessages(103);
                if (iL <= 0 && !zA) {
                    Message.obtain(f18880d, 103, 0, 0, f18879c).sendToTarget();
                }
            }
        } else if (g()) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload] NEEDDOWNLOAD_WILL_STARTDOWNLOAD");
        } else {
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#5,set needDownload = false");
            z5 = false;
        }
        if (!zA && tbsDownloaderCallback != null) {
            tbsDownloaderCallback.onNeedDownloadFinish(z5, 0);
        }
        return z5;
    }

    public static boolean needDownloadDecoupleCore() {
        int i2;
        if (TbsShareManager.isThirdPartyApp(f18879c) || a(f18879c)) {
            return false;
        }
        return System.currentTimeMillis() - TbsDownloadConfig.getInstance(f18879c).mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, 0L) >= TbsDownloadConfig.getInstance(f18879c).getRetryInterval() * 1000 && (i2 = TbsDownloadConfig.getInstance(f18879c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0)) > 0 && i2 != o.a().g(f18879c) && TbsDownloadConfig.getInstance(f18879c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) != i2;
    }

    public static void pauseDownload() {
        TbsLog.i(LOGTAG, "called pauseDownload,downloader=" + f18883g);
        l lVar = f18883g;
        if (lVar != null) {
            lVar.d();
        }
    }

    public static void resumeDownload() {
        TbsLog.i(LOGTAG, "called resumeDownload,downloader=" + f18883g);
        Handler handler = f18880d;
        if (handler != null) {
            handler.removeMessages(109);
            f18880d.sendEmptyMessage(109);
        }
    }

    public static void setAppContext(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return;
        }
        f18879c = context.getApplicationContext();
    }

    public static void setRetryIntervalInSeconds(Context context, long j2) {
        if (context == null) {
            return;
        }
        if (context.getApplicationInfo().packageName.equals("com.tencent.qqlive")) {
            f18897u = j2;
        }
        TbsLog.i(LOGTAG, "mRetryIntervalInSeconds is " + f18897u);
    }

    @Deprecated
    public static boolean startDecoupleCoreIfNeeded() {
        TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded closeStableCore ");
        return false;
    }

    public static void startDownload(Context context) {
        startDownload(context, false);
    }

    public static synchronized void startDownload(Context context, boolean z2) {
        int i2 = 1;
        if (TbsShareManager.isThirdPartyApp(context)) {
            f18885i++;
            if (f18885i > 1) {
                TbsLog.w(LOGTAG, "[Warning] for privacy security, TBS Only allow startDownload 1 times each process");
                QbSdk.f18849n.onDownloadFinish(127);
                return;
            }
        }
        f18879c = context.getApplicationContext();
        TbsLog.initIfNeed(f18879c);
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(f18879c);
        tbsDownloadConfig.setDownloadInterruptCode(-200);
        TbsLog.i(LOGTAG, "[TbsDownloader.startDownload] sAppContext=" + f18879c);
        if (o.a) {
            tbsDownloadConfig.setDownloadInterruptCode(-130);
            QbSdk.f18849n.onDownloadFinish(TbsListener.ErrorCode.NEEDDOWNLOAD_STATIC_INSTALLING);
            return;
        }
        o.a().b(context, g.a == 0);
        int iB = o.a().b(context);
        TbsLog.i(LOGTAG, "[TbsDownloader.needDownload],renameRet=" + iB);
        if (iB < 0) {
            tbsDownloadConfig.setDownloadInterruptCode(-128);
            QbSdk.f18849n.onDownloadFinish(TbsListener.ErrorCode.NEEDDOWNLOAD_TMPCORE_PREPARING);
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload],needReNameFile=" + iB);
            return;
        }
        a = true;
        if (Build.VERSION.SDK_INT < 8) {
            tbsDownloadConfig.setDownloadInterruptCode(ErrorConstant.ERROR_REQUEST_FAIL);
            QbSdk.f18849n.onDownloadFinish(TbsListener.ErrorCode.STARTDOWNLOAD_API_LEVEL_BELOW_FROYO);
            return;
        }
        d();
        if (f18886j) {
            tbsDownloadConfig.setDownloadInterruptCode(ErrorConstant.ERROR_REQUEST_TIME_OUT);
            QbSdk.f18849n.onDownloadFinish(121);
            return;
        }
        if (z2) {
            stopDownload();
        }
        f18880d.removeMessages(101);
        f18880d.removeMessages(100);
        Message messageObtain = Message.obtain(f18880d, 101, QbSdk.f18849n);
        if (!z2) {
            i2 = 0;
        }
        messageObtain.arg1 = i2;
        messageObtain.sendToTarget();
    }

    public static void stopDownload() {
        if (f18886j) {
            return;
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.stopDownload]");
        l lVar = f18883g;
        if (lVar != null) {
            lVar.a();
        }
        Handler handler = f18880d;
        if (handler != null) {
            handler.removeMessages(100);
            f18880d.removeMessages(101);
            f18880d.removeMessages(108);
        }
    }
}
