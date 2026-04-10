package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

/* JADX INFO: loaded from: classes3.dex */
public class o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static o f19280c;
    private Context a;
    private File b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f19281d = "https://log.tbs.qq.com/ajax?c=pu&v=2&k=";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f19282e = "https://log.tbs.qq.com/ajax?c=pu&tk=";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f19283f = "https://log.tbs.qq.com/ajax?c=dl&k=";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f19284g = "https://cfg.imtt.qq.com/tbs?v=2&mk=";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f19285h = "https://log.tbs.qq.com/ajax?c=ul&v=2&k=";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f19286i = "https://mqqad.html5.qq.com/adjs";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f19287j = "https://log.tbs.qq.com/ajax?c=ucfu&k=";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f19288k = "";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f19289l = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f19290m = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f19291n = "https://tbsrecovery.imtt.qq.com/getconfig";

    @TargetApi(11)
    private o(Context context) {
        this.a = null;
        TbsLog.w("TbsCommonConfig", "TbsCommonConfig constructing...");
        this.a = context.getApplicationContext();
        k();
    }

    public static synchronized o a() {
        return f19280c;
    }

    public static synchronized o a(Context context) {
        if (f19280c == null) {
            f19280c = new o(context);
        }
        return f19280c;
    }

    private synchronized void k() {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        File fileL;
        try {
            fileL = l();
        } catch (Throwable th2) {
            bufferedInputStream = null;
            th = th2;
        }
        if (fileL == null) {
            TbsLog.e("TbsCommonConfig", "Config file is null, default values will be applied");
            return;
        }
        bufferedInputStream = new BufferedInputStream(new FileInputStream(fileL));
        try {
            Properties properties = new Properties();
            properties.load(bufferedInputStream);
            String property = properties.getProperty("pv_post_url", "");
            if (!"".equals(property)) {
                this.f19281d = property;
            }
            String property2 = properties.getProperty("tbs_download_stat_post_url", "");
            if (!"".equals(property2)) {
                this.f19283f = property2;
            }
            String property3 = properties.getProperty("tbs_downloader_post_url", "");
            TbsLog.i("TbsCommonConfig", "KEY_TBS_DOWNLOADER_POST_URL is " + property3);
            if (!"".equals(property3)) {
                this.f19284g = property3;
            }
            String property4 = properties.getProperty("tbs_downloader_response_query", "");
            TbsLog.i("TbsCommonConfig", "KEY_TBS_DOWNLOADER_RESPONSE_QUERY is " + property4);
            if (!"".equals(property4)) {
                this.f19288k = property4;
            }
            String property5 = properties.getProperty("tbs_downloader_response_update", "");
            TbsLog.i("TbsCommonConfig", "KEY_TBS_DOWNLOADER_RESPONSE_UPDATE is " + property5);
            if (!"".equals(property5)) {
                this.f19289l = property5;
            }
            String property6 = properties.getProperty("tbs_downloader_response_download", "");
            TbsLog.i("TbsCommonConfig", "KEY_TBS_DOWNLOADER_RESPONSE_DOWNLOAD is " + property6);
            if (!"".equals(property6)) {
                this.f19290m = property6;
            }
            String property7 = properties.getProperty("tbs_log_post_url", "");
            if (!"".equals(property7)) {
                this.f19285h = property7;
            }
            String property8 = properties.getProperty("tips_url", "");
            if (!"".equals(property8)) {
                this.f19286i = property8;
            }
            String property9 = properties.getProperty("tbs_cmd_post_url", "");
            if (!"".equals(property9)) {
                this.f19287j = property9;
            }
            String property10 = properties.getProperty("tbs_emergency_post_url", "");
            if (!"".equals(property10)) {
                this.f19291n = property10;
            }
            String property11 = properties.getProperty("pv_post_url_tk", "");
            if (!"".equals(property11)) {
                this.f19282e = property11;
            }
            try {
                bufferedInputStream.close();
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (Throwable th3) {
            th = th3;
            try {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                TbsLog.e("TbsCommonConfig", "exceptions occurred1:" + stringWriter.toString());
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e3) {
                        e = e3;
                        e.printStackTrace();
                    }
                }
            } finally {
            }
        }
    }

    private File l() {
        File file;
        File file2 = null;
        try {
            if (this.b == null) {
                if (TextUtils.isEmpty(this.a.getApplicationContext().getApplicationInfo().packageName)) {
                    file = new File(FileUtil.a(this.a, 8));
                } else {
                    this.b = new File(FileUtil.a(this.a, 8));
                    if (this.b == null || !this.b.isDirectory()) {
                        file = new File(FileUtil.a(this.a, 5));
                    }
                    if (this.b != null || !this.b.isDirectory()) {
                        return null;
                    }
                }
                this.b = file;
                if (this.b != null) {
                }
                return null;
            }
            TbsLog.i("TbsCommonConfig", "mTbsConfigDir is " + this.b.getAbsolutePath());
            File file3 = new File(this.b, "tbsnet.conf");
            if (!file3.exists()) {
                TbsLog.e("TbsCommonConfig", "Get file(" + file3.getCanonicalPath() + ") failed!");
                return null;
            }
            try {
                TbsLog.w("TbsCommonConfig", "pathc:" + file3.getCanonicalPath());
                return file3;
            } catch (Throwable th) {
                th = th;
                file2 = file3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        TbsLog.e("TbsCommonConfig", "exceptions occurred2:" + stringWriter.toString());
        return file2;
    }

    public String b() {
        return this.f19281d;
    }

    public String c() {
        return this.f19283f;
    }

    public String d() {
        return this.f19288k;
    }

    public String e() {
        return this.f19289l;
    }

    public String f() {
        return this.f19290m;
    }

    public String g() {
        return this.f19284g;
    }

    public String h() {
        return this.f19285h;
    }

    public String i() {
        return this.f19282e;
    }

    public String j() {
        return this.f19291n;
    }
}
