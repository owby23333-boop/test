package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.utils.Base64;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.g;
import com.umeng.message.common.inter.ITagManager;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public class TbsLogReport {
    private static TbsLogReport a;
    private Handler b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<EventType, Boolean> f18898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f18899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f18900e = false;

    public enum EventType {
        TYPE_DOWNLOAD(0),
        TYPE_INSTALL(1),
        TYPE_LOAD(2),
        TYPE_CDN_DOWNLOAD_STAT(3),
        TYPE_COOKIE_DB_SWITCH(4),
        TYPE_PV_UPLOAD_STAT(5),
        TYPE_CORE_LOAD_PERFORMANCE(6),
        TYPE_CORE_PROTECT_RESET(7);

        int a;

        EventType(int i2) {
            this.a = i2;
        }
    }

    public static class TbsLogInfo implements Cloneable {
        int a;
        private long b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f18901c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f18902d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f18903e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f18904f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f18905g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f18906h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f18907i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f18908j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f18909k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f18910l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private long f18911m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f18912n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private String f18913o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private String f18914p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private long f18915q;

        private TbsLogInfo() {
            resetArgs();
        }

        protected Object clone() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException unused) {
                return this;
            }
        }

        public int getDownFinalFlag() {
            return this.f18909k;
        }

        public void resetArgs() {
            this.b = 0L;
            this.f18901c = null;
            this.f18902d = null;
            this.f18903e = 0;
            this.f18904f = 0;
            this.f18905g = 0;
            this.f18906h = 2;
            this.f18907i = "unknown";
            this.f18908j = 0;
            this.f18909k = 2;
            this.f18910l = 0L;
            this.f18911m = 0L;
            this.f18912n = 1;
            this.a = 0;
            this.f18913o = null;
            this.f18914p = null;
            this.f18915q = 0L;
        }

        public void setApn(String str) {
            this.f18907i = str;
        }

        public void setCheckErrorDetail(String str) {
            setErrorCode(108);
            this.f18913o = str;
        }

        public void setDownConsumeTime(long j2) {
            this.f18911m += j2;
        }

        public void setDownFinalFlag(int i2) {
            this.f18909k = i2;
        }

        public void setDownloadCancel(int i2) {
            this.f18905g = i2;
        }

        public void setDownloadSize(long j2) {
            this.f18915q += j2;
        }

        public void setDownloadUrl(String str) {
            if (this.f18901c != null) {
                str = this.f18901c + ";" + str;
            }
            this.f18901c = str;
        }

        public void setErrorCode(int i2) {
            if (i2 != 100 && i2 != 110 && i2 != 120 && i2 != 111 && i2 < 400) {
                TbsLog.i(TbsDownloader.LOGTAG, "error occured, errorCode:" + i2, true);
            }
            if (i2 == 111) {
                TbsLog.i(TbsDownloader.LOGTAG, "you are not in wifi, downloading stoped", true);
            }
            this.a = i2;
        }

        public void setEventTime(long j2) {
            this.b = j2;
        }

        public void setFailDetail(String str) {
            if (str == null) {
                return;
            }
            if (str.length() > 1024) {
                str = str.substring(0, 1024);
            }
            this.f18914p = str;
        }

        public void setFailDetail(Throwable th) {
            if (th == null) {
                this.f18914p = "";
                return;
            }
            String stackTraceString = Log.getStackTraceString(th);
            if (stackTraceString.length() > 1024) {
                stackTraceString = stackTraceString.substring(0, 1024);
            }
            this.f18914p = stackTraceString;
        }

        public void setHttpCode(int i2) {
            this.f18903e = i2;
        }

        public void setNetworkChange(int i2) {
            this.f18912n = i2;
        }

        public void setNetworkType(int i2) {
            this.f18908j = i2;
        }

        public void setPatchUpdateFlag(int i2) {
            this.f18904f = i2;
        }

        public void setPkgSize(long j2) {
            this.f18910l = j2;
        }

        public void setResolveIp(String str) {
            this.f18902d = str;
        }

        public void setUnpkgFlag(int i2) {
            this.f18906h = i2;
        }

        public String toString() {
            return "TbsLogInfo{mEventTime=" + this.b + ", mResolveIp='" + this.f18902d + "', mHttpCode=" + this.f18903e + ", mDownloadCancel=" + this.f18905g + ", mNetworkType=" + this.f18908j + ", mDownConsumeTime=" + this.f18911m + ", mErrorCode=" + this.a + ", mCheckErrorDetail='" + this.f18913o + "', mFailDetail='" + this.f18914p + "'}";
        }
    }

    private static class a {
        private final String a;
        private final String b;

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x003e -> B:29:0x0041). Please report as a decompilation issue!!! */
        private static void a(File file) throws Throwable {
            RandomAccessFile randomAccessFile;
            RandomAccessFile randomAccessFile2 = null;
            RandomAccessFile randomAccessFile3 = null;
            randomAccessFile2 = null;
            try {
            } catch (IOException e2) {
                e2.printStackTrace();
                randomAccessFile2 = randomAccessFile2;
            }
            try {
                try {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        int i2 = Integer.parseInt("00001000", 2);
                        randomAccessFile.seek(7L);
                        int i3 = randomAccessFile.read();
                        if ((i3 & i2) > 0) {
                            randomAccessFile.seek(7L);
                            randomAccessFile.write((i2 ^ (-1)) & 255 & i3);
                        }
                        randomAccessFile.close();
                        randomAccessFile2 = i3;
                    } catch (Exception e3) {
                        e = e3;
                        randomAccessFile3 = randomAccessFile;
                        e.printStackTrace();
                        randomAccessFile2 = randomAccessFile3;
                        if (randomAccessFile3 != null) {
                            randomAccessFile3.close();
                            randomAccessFile2 = randomAccessFile3;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                }
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = randomAccessFile2;
            }
        }

        /* JADX WARN: Can't wrap try/catch for region: R(17:0|2|121|(6:105|3|130|4|5|(8:101|6|128|7|132|8|119|9))|(8:10|(1:12)(1:135)|46|109|47|51|104|86)|13|111|14|107|18|46|109|47|51|104|86|(1:(0))) */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x004d, code lost:
        
            r0.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x008d, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x008e, code lost:
        
            r0.printStackTrace();
         */
        /* JADX WARN: Removed duplicated region for block: B:102:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:124:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x00d4 -> B:104:0x00d7). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a() throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 240
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsLogReport.a.a():void");
        }
    }

    private TbsLogReport(Context context) {
        this.b = null;
        this.f18899d = context.getApplicationContext();
        this.f18898c = TbsPVConfig.getInstance(context).getLogReportSwitchMap();
        HandlerThread handlerThread = new HandlerThread("TbsLogReportThread");
        handlerThread.start();
        this.b = new Handler(handlerThread.getLooper()) { // from class: com.tencent.smtt.sdk.TbsLogReport.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i2 = message.what;
                if (i2 != 600) {
                    if (i2 == 601) {
                        TbsLogReport.this.b();
                        return;
                    }
                    return;
                }
                Object obj = message.obj;
                if (obj instanceof TbsLogInfo) {
                    try {
                        int i3 = message.arg1;
                        TbsLogReport.this.a(i3, (TbsLogInfo) obj);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        };
    }

    private String a(int i2) {
        return i2 + com.anythink.expressad.foundation.g.a.bQ;
    }

    private String a(long j2) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j2));
        } catch (Exception unused) {
            return null;
        }
    }

    private String a(String str) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        sb.append(str);
        sb.append(com.anythink.expressad.foundation.g.a.bQ);
        return sb.toString();
    }

    private JSONArray a() {
        String string = d().getString("tbs_tbslogreport_upload", null);
        if (string != null) {
            try {
                string = new String(Base64.a(string, 2));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (string == null) {
            return new JSONArray();
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() <= 5) {
                return jSONArray;
            }
            JSONArray jSONArray2 = new JSONArray();
            int length = jSONArray.length();
            while (true) {
                length--;
                if (length < jSONArray.length() - 5) {
                    return jSONArray2;
                }
                jSONArray2.put(jSONArray.get(length));
            }
        } catch (Exception unused) {
            return new JSONArray();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, TbsLogInfo tbsLogInfo) {
        Map<String, Object> map = QbSdk.f18850o;
        if (map != null && map.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && QbSdk.f18850o.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals(ITagManager.STATUS_FALSE)) {
            TbsLog.i("TbsLogReport", "[TbsLogReport.sendLogReportRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a(i2));
        sb.append(a(""));
        sb.append(a(com.tencent.smtt.utils.l.a(this.f18899d)));
        sb.append(a(o.a().h(this.f18899d)));
        sb.append(a(""));
        String packageName = this.f18899d.getPackageName();
        sb.append(a(packageName));
        sb.append("com.tencent.mm".equals(packageName) ? a(com.tencent.smtt.utils.b.a(this.f18899d, TbsDownloader.TBS_METADATA)) : a(com.tencent.smtt.utils.b.e(this.f18899d)));
        sb.append(a(a(tbsLogInfo.b)));
        sb.append(a(tbsLogInfo.f18901c));
        sb.append(a(tbsLogInfo.f18902d));
        sb.append(a(tbsLogInfo.f18903e));
        sb.append(a(tbsLogInfo.f18904f));
        sb.append(a(tbsLogInfo.f18905g));
        sb.append(a(tbsLogInfo.f18906h));
        sb.append(a(tbsLogInfo.f18907i));
        sb.append(a(tbsLogInfo.f18908j));
        sb.append(a(tbsLogInfo.f18909k));
        sb.append(b(tbsLogInfo.f18915q));
        sb.append(b(tbsLogInfo.f18910l));
        sb.append(b(tbsLogInfo.f18911m));
        sb.append(a(tbsLogInfo.f18912n));
        sb.append(a(tbsLogInfo.a));
        sb.append(a(tbsLogInfo.f18913o));
        sb.append(a(tbsLogInfo.f18914p));
        sb.append(a(TbsDownloadConfig.getInstance(this.f18899d).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0)));
        sb.append(a(com.tencent.smtt.utils.b.k(this.f18899d)));
        sb.append(a("44226"));
        sb.append(false);
        SharedPreferences sharedPreferencesD = d();
        JSONArray jSONArrayA = a();
        jSONArrayA.put(sb.toString());
        SharedPreferences.Editor editorEdit = sharedPreferencesD.edit();
        String string = jSONArrayA.toString();
        try {
            string = Base64.encodeToString(string.getBytes(), 2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        editorEdit.putString("tbs_tbslogreport_upload", string);
        editorEdit.commit();
        if (this.f18900e) {
            b();
        }
    }

    private void a(int i2, TbsLogInfo tbsLogInfo, EventType eventType) {
        tbsLogInfo.setErrorCode(i2);
        tbsLogInfo.setEventTime(System.currentTimeMillis());
        QbSdk.f18849n.onInstallFinish(i2);
        eventReport(eventType, tbsLogInfo);
    }

    private void a(int i2, String str) {
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setErrorCode(i2);
        tbsLogInfo.setEventTime(System.currentTimeMillis());
        tbsLogInfo.setFailDetail(str);
        eventReport(EventType.TYPE_LOAD, tbsLogInfo);
    }

    private String b(long j2) {
        return j2 + com.anythink.expressad.foundation.g.a.bQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        String str;
        String str2;
        Map<String, Object> map = QbSdk.f18850o;
        if (map != null && map.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && QbSdk.f18850o.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals(ITagManager.STATUS_FALSE)) {
            str = "TbsLogReport";
            str2 = "[TbsLogReport.sendLogReportRequest] -- SET_SENDREQUEST_AND_UPLOAD is false";
        } else {
            str = TbsDownloader.LOGTAG;
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat]");
            JSONArray jSONArrayA = a();
            if (jSONArrayA != null && jSONArrayA.length() != 0) {
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] jsonArray:" + jSONArrayA);
                try {
                    TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] response:" + com.tencent.smtt.utils.g.a(com.tencent.smtt.utils.o.a(this.f18899d).c(), jSONArrayA.toString().getBytes(com.anythink.expressad.foundation.g.a.bN), new g.a() { // from class: com.tencent.smtt.sdk.TbsLogReport.3
                        @Override // com.tencent.smtt.utils.g.a
                        public void a(int i2) {
                            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] onHttpResponseCode:" + i2);
                            if (i2 < 300) {
                                TbsLogReport.this.c();
                            }
                        }
                    }, true) + " testcase: -1");
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            str2 = "[TbsApkDownloadStat.reportDownloadStat] no data";
        }
        TbsLog.i(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        SharedPreferences.Editor editorEdit = d().edit();
        editorEdit.remove("tbs_tbslogreport_upload");
        editorEdit.commit();
    }

    private SharedPreferences d() {
        return this.f18899d.getSharedPreferences("tbs_event_stat", 4);
    }

    public static TbsLogReport getInstance(Context context) {
        if (a == null) {
            synchronized (TbsLogReport.class) {
                if (a == null) {
                    a = new TbsLogReport(context);
                }
            }
        }
        return a;
    }

    public void clear() {
        try {
            SharedPreferences.Editor editorEdit = d().edit();
            editorEdit.clear();
            editorEdit.commit();
        } catch (Exception unused) {
        }
    }

    public void dailyReport() {
        this.b.sendEmptyMessage(601);
    }

    public void eventReport(EventType eventType, TbsLogInfo tbsLogInfo) {
        TbsLog.i("TbsLogReport", "[TbsLogReport.eventRepost] " + eventType + ": " + tbsLogInfo);
        Boolean bool = this.f18898c.get(eventType);
        if (bool == null || !bool.booleanValue()) {
            return;
        }
        TbsLog.i("TbsLogReport", "[TbsLogReport.eventRepost] needReport!");
        try {
            TbsLogInfo tbsLogInfo2 = (TbsLogInfo) tbsLogInfo.clone();
            Message messageObtainMessage = this.b.obtainMessage();
            messageObtainMessage.what = 600;
            messageObtainMessage.arg1 = eventType.a;
            messageObtainMessage.obj = tbsLogInfo2;
            this.b.sendMessage(messageObtainMessage);
        } catch (Throwable th) {
            TbsLog.w("TbsLogReport", "[TbsLogReport.eventReport] error, message=" + th.getMessage());
        }
    }

    public boolean getShouldUploadEventReport() {
        return this.f18900e;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(21:16|(1:18)(1:19)|20|(2:86|21)|22|101|23|99|24|25|97|26|(6:80|27|(1:29)(1:103)|33|60|61)|30|88|31|84|32|33|60|61) */
    /* JADX WARN: Can't wrap try/catch for region: R(22:16|(1:18)(1:19)|20|86|21|22|101|23|99|24|25|97|26|(6:80|27|(1:29)(1:103)|33|60|61)|30|88|31|84|32|33|60|61) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x012b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0132 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x015b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0162 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void reportTbsLog() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 367
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsLogReport.reportTbsLog():void");
    }

    public void setInstallErrorCode(int i2, String str) {
        setInstallErrorCode(i2, str, EventType.TYPE_INSTALL);
    }

    public void setInstallErrorCode(int i2, String str, EventType eventType) {
        if (i2 != 200 && i2 != 220 && i2 != 221) {
            TbsLog.i(TbsDownloader.LOGTAG, "error occured in installation, errorCode:" + i2, true);
        }
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setFailDetail(str);
        a(i2, tbsLogInfo, eventType);
    }

    public void setInstallErrorCode(int i2, Throwable th) {
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setFailDetail(th);
        a(i2, tbsLogInfo, EventType.TYPE_INSTALL);
    }

    public void setLoadErrorCode(int i2, Throwable th) {
        String strSubstring;
        if (th != null) {
            strSubstring = "msg: " + th.getMessage() + "; err: " + th + "; cause: " + Log.getStackTraceString(th.getCause());
            if (strSubstring.length() > 1024) {
                strSubstring = strSubstring.substring(0, 1024);
            }
        } else {
            strSubstring = "NULL";
        }
        a(i2, strSubstring);
    }

    public void setShouldUploadEventReport(boolean z2) {
        this.f18900e = z2;
    }

    public TbsLogInfo tbsLogInfo() {
        return new TbsLogInfo();
    }
}
