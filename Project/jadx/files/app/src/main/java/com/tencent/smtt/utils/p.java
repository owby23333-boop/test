package com.tencent.smtt.utils;

import android.content.Context;
import com.tencent.smtt.sdk.QbSdk;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/* JADX INFO: loaded from: classes3.dex */
public class p {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static p f19292e;
    public boolean a;
    private Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private File f19293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f19294d;

    public static synchronized p a() {
        return f19292e;
    }

    private File c() {
        try {
            if (this.f19293c == null) {
                this.f19293c = new File(QbSdk.getTbsFolderDir(this.b), "core_private");
                if (this.f19293c == null || !this.f19293c.isDirectory()) {
                    return null;
                }
            }
            File file = new File(this.f19293c, "debug.conf");
            if (!file.exists()) {
                file.createNewFile();
            }
            return file;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void a(boolean z2) {
        this.f19294d = z2;
        b();
    }

    public void b() {
        BufferedInputStream bufferedInputStream;
        Properties properties;
        BufferedOutputStream bufferedOutputStream;
        File fileC = c();
        if (fileC == null) {
            return;
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(fileC));
                try {
                    properties = new Properties();
                    properties.load(bufferedInputStream);
                    properties.setProperty("setting_forceUseSystemWebview", Boolean.toString(this.a));
                    properties.setProperty("result_systemWebviewForceUsed", Boolean.toString(this.f19294d));
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileC));
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    properties.store(bufferedOutputStream, (String) null);
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    bufferedOutputStream.close();
                } catch (Throwable th2) {
                    bufferedOutputStream2 = bufferedOutputStream;
                    th = th2;
                    try {
                        th.printStackTrace();
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        bufferedOutputStream2.close();
                    } finally {
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
