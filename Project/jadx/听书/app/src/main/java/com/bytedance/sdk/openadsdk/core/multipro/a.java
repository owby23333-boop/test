package com.bytedance.sdk.openadsdk.core.multipro;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.p;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.hh.e;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileLock;
import java.util.Arrays;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static void z(final Context context) {
        if (context == null) {
            return;
        }
        SSWebView.f847a = new com.bytedance.sdk.component.widget.z() { // from class: com.bytedance.sdk.openadsdk.core.multipro.a.1
            @Override // com.bytedance.sdk.component.widget.z
            public void z(String str, Throwable th) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("threadName", str);
                    jSONObject.put("record", Arrays.toString(th.getStackTrace()));
                } catch (Exception unused) {
                }
                v.z().z("webview_init_failed", jSONObject, th);
            }
        };
        com.bytedance.sdk.component.e.dl.z(context.getApplicationContext());
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                if (p.z(context)) {
                    e.z(new fo("tt_webview_file_path") { // from class: com.bytedance.sdk.openadsdk.core.multipro.a.2
                        @Override // java.lang.Runnable
                        public void run() throws Throwable {
                            a.dl(context);
                        }
                    });
                    return;
                }
                String strG = p.g(context);
                try {
                    if (TextUtils.isEmpty(strG)) {
                        strG = context.getPackageName() + Process.myPid();
                    }
                    WebView.setDataDirectorySuffix(strG);
                } catch (IllegalStateException unused) {
                    z(strG);
                } catch (Exception unused2) {
                }
            }
        } catch (Throwable th) {
            wp.dl(th.getMessage());
        }
    }

    private static void z(String str) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static void dl(Context context) throws Throwable {
        RandomAccessFile randomAccessFile;
        Throwable th;
        String strZ = z();
        File file = new File(com.bytedance.sdk.openadsdk.api.plugin.g.z(context, TextUtils.isEmpty(strZ) ? "webview" : "webview_".concat(String.valueOf(strZ)), 0).getPath(), "webview_data.lock");
        wp.z("TTMultiInitHelper", file.getAbsolutePath());
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
                        z(file, file.delete());
                    }
                    com.bytedance.sdk.component.m.dl.dl.g.z(randomAccessFile);
                } catch (Exception unused) {
                    randomAccessFile2 = randomAccessFile;
                    z(file, file.exists() ? file.delete() : false);
                    com.bytedance.sdk.component.m.dl.dl.g.z(randomAccessFile2);
                } catch (Throwable th2) {
                    th = th2;
                    com.bytedance.sdk.component.m.dl.dl.g.z(randomAccessFile);
                    throw th;
                }
            } catch (Throwable th3) {
                randomAccessFile = randomAccessFile2;
                th = th3;
            }
        } catch (Exception unused2) {
        }
    }

    private static void z(File file, boolean z) {
        if (!z || file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            wp.z(e);
        }
    }

    private static String z() {
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
