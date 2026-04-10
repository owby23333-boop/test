package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class TbsDownloadUpload {
    private static TbsDownloadUpload b;
    Map<String, Object> a = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f18872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f18873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f18874e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f18875f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f18876g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f18877h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f18878i;
    public SharedPreferences mPreferences;

    public interface TbsUploadKey {
        public static final String KEY_LOCAL_CORE_VERSION = "tbs_local_core_version";
        public static final String KEY_NEEDDOWNLOAD_CODE = "tbs_needdownload_code";
        public static final String KEY_NEEDDOWNLOAD_RETURN = "tbs_needdownload_return";
        public static final String KEY_NEEDDOWNLOAD_SENT = "tbs_needdownload_sent";
        public static final String KEY_STARTDOWNLOAD_CODE = "tbs_startdownload_code";
        public static final String KEY_STARTDOWNLOAD_SENT = "tbs_startdownload_sent";
    }

    public TbsDownloadUpload(Context context) {
        this.mPreferences = context.getSharedPreferences("tbs_download_upload", 4);
        this.f18872c = context.getApplicationContext();
        if (this.f18872c == null) {
            this.f18872c = context;
        }
    }

    private static File a(Context context, String str) {
        File fileR = o.r(context);
        if (fileR == null) {
            return null;
        }
        File file = new File(fileR, str);
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static synchronized void clear() {
        b = null;
    }

    public static synchronized TbsDownloadUpload getInstance() {
        return b;
    }

    public static synchronized TbsDownloadUpload getInstance(Context context) {
        if (b == null) {
            b = new TbsDownloadUpload(context);
        }
        return b;
    }

    public void clearUploadCode() {
        this.a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, 0);
        this.a.put(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, 0);
        this.a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, 0);
        this.a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_SENT, 0);
        this.a.put(TbsUploadKey.KEY_STARTDOWNLOAD_SENT, 0);
        this.a.put(TbsUploadKey.KEY_LOCAL_CORE_VERSION, 0);
        writeTbsDownloadInfo();
    }

    public synchronized void commit() {
        writeTbsDownloadInfo();
    }

    public synchronized int getLocalCoreVersion() {
        return this.f18878i;
    }

    public synchronized int getNeedDownloadCode() {
        return this.f18873d;
    }

    public synchronized int getNeedDownloadReturn() {
        return this.f18875f;
    }

    public synchronized int getStartDownloadCode() {
        return this.f18874e;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void readTbsDownloadInfo(android.content.Context r6) {
        /*
            Method dump skipped, instruction units count: 235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloadUpload.readTbsDownloadInfo(android.content.Context):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x00c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[Catch: all -> 0x00cf, DONT_GENERATE, FINALLY_INSNS, SYNTHETIC, TRY_LEAVE, TryCatch #10 {, blocks: (B:3:0x0001, B:15:0x0088, B:19:0x0090, B:22:0x0095, B:18:0x008d, B:32:0x00a7, B:37:0x00b1, B:35:0x00ac, B:45:0x00bc, B:50:0x00c6, B:54:0x00ce, B:53:0x00cb, B:48:0x00c1, B:30:0x00a2), top: B:80:0x0001, inners: #0, #2, #3, #4, #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void writeTbsDownloadInfo() {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloadUpload.writeTbsDownloadInfo():void");
    }
}
