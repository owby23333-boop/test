package com.bytedance.sdk.openadsdk.core.multipro;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.wu;
import com.bytedance.sdk.component.zk.p;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes10.dex */
public class tg {
    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context) throws Throwable {
        String str;
        RandomAccessFile randomAccessFile;
        Throwable th;
        String strE = e();
        if (TextUtils.isEmpty(strE)) {
            str = "webview";
        } else {
            str = "webview_" + strE;
        }
        File file = new File(context.getDir(str, 0).getPath(), "webview_data.lock");
        wu.d("TTMultiInitHelper", file.getAbsolutePath());
        if (!file.exists()) {
            return;
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    FileLock fileLockTryLock = randomAccessFile.getChannel().tryLock();
                    if (fileLockTryLock != null) {
                        fileLockTryLock.close();
                    } else {
                        e(file, file.delete());
                    }
                    com.bytedance.sdk.component.ga.d.d.bf.e(randomAccessFile);
                } catch (Exception unused) {
                    randomAccessFile2 = randomAccessFile;
                    e(file, file.exists() ? file.delete() : false);
                    com.bytedance.sdk.component.ga.d.d.bf.e(randomAccessFile2);
                } catch (Throwable th2) {
                    th = th2;
                    com.bytedance.sdk.component.ga.d.d.bf.e(randomAccessFile);
                    throw th;
                }
            } catch (Exception unused2) {
            }
        } catch (Throwable th3) {
            randomAccessFile = null;
            th = th3;
        }
    }

    public static void e(final Context context) {
        if (context == null) {
            return;
        }
        com.bytedance.sdk.component.vn.d.e(context.getApplicationContext());
        try {
            if (l.e(context)) {
                com.bytedance.sdk.openadsdk.s.vn.e(new p("tt_webview_file_path") { // from class: com.bytedance.sdk.openadsdk.core.multipro.tg.1
                    @Override // java.lang.Runnable
                    public void run() throws Throwable {
                        tg.d(context);
                    }
                });
                return;
            }
            String strBf = l.bf(context);
            try {
                if (TextUtils.isEmpty(strBf)) {
                    strBf = context.getPackageName() + Process.myPid();
                }
                WebView.setDataDirectorySuffix(strBf);
            } catch (IllegalStateException unused) {
                e(strBf);
            } catch (Exception unused2) {
            }
        } catch (Throwable th) {
            wu.d(th.getMessage());
        }
    }

    private static void e(String str) {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke(null, "android.webkit.WebViewFactory");
            Field field = (Field) declaredMethod2.invoke(cls, "sDataDirectorySuffix");
            field.setAccessible(true);
            if (TextUtils.isEmpty((String) field.get(cls))) {
                field.set(cls, str);
            }
        } catch (Throwable unused) {
        }
    }

    private static void e(File file, boolean z) {
        if (!z || file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String e() {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke(null, "android.webkit.WebViewFactory");
            return (String) ((Field) declaredMethod2.invoke(cls, "sDataDirectorySuffix")).get(cls);
        } catch (Throwable unused) {
            return null;
        }
    }
}
