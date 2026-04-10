package com.tencent.smtt.sdk;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TbsBaseConfig {
    public static final String TAG = "TbsBaseConfig";
    Map<String, String> a;
    private Context b;

    private static File a(Context context, String str) {
        o.a();
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

    public void clear() {
        this.a.clear();
        commit();
    }

    public synchronized void commit() {
        writeTbsDownloadInfo();
    }

    public abstract String getConfigFileName();

    public Map<String, String> getPVCLocal() {
        return this.a;
    }

    public void init(Context context) {
        this.a = new HashMap();
        this.b = context.getApplicationContext();
        if (this.b == null) {
            this.b = context;
        }
        refreshSyncMap(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void refreshSyncMap(android.content.Context r7) {
        /*
            Method dump skipped, instruction units count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsBaseConfig.refreshSyncMap(android.content.Context):void");
    }

    public void update(Map<String, String> map) {
        this.a.clear();
        this.a.putAll(map);
        commit();
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x014c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x012b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[Catch: all -> 0x01af, DONT_GENERATE, FINALLY_INSNS, SYNTHETIC, TRY_LEAVE, TryCatch #10 {, blocks: (B:3:0x0001, B:16:0x00c6, B:20:0x00e5, B:23:0x00eb, B:24:0x0102, B:19:0x00cb, B:34:0x012b, B:39:0x014c, B:42:0x0151, B:37:0x0130, B:48:0x016e, B:53:0x018f, B:57:0x01ae, B:56:0x0194, B:51:0x0173, B:32:0x010f), top: B:83:0x0001, inners: #0, #1, #2, #3, #5, #7, #9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void writeTbsDownloadInfo() {
        /*
            Method dump skipped, instruction units count: 436
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsBaseConfig.writeTbsDownloadInfo():void");
    }
}
