package com.bytedance.sdk.openadsdk.core;

import android.os.Build;
import android.os.Environment;
import android.os.FileObserver;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    private static g m;
    public static String z = Environment.DIRECTORY_DCIM;
    private static String g = Environment.DIRECTORY_PICTURES;
    private static String dl = "Screenshots";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f1114a = false;
    private static volatile boolean gc = false;
    private static long e = 0;

    private interface z {
        void z(String str);
    }

    private static File m() {
        return null;
    }

    public static void z() {
        if (!gc || f1114a) {
            return;
        }
        try {
            g();
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.wp.a("ScreenShotObserver", "权限检查出错时,异常代码：" + e2);
        }
    }

    public static void g() {
        gc = true;
        if (!f1114a && zw.getContext().checkSelfPermission(com.kuaishou.weapon.p0.g.j) == 0) {
            com.bytedance.sdk.component.uy.e.a(new com.bytedance.sdk.component.uy.fo("sso") { // from class: com.bytedance.sdk.openadsdk.core.h.1
                @Override // java.lang.Runnable
                public void run() {
                    h.gc();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void gc() {
        File fileM;
        if (f1114a || (fileM = m()) == null) {
            return;
        }
        m = g.z(fileM, new z() { // from class: com.bytedance.sdk.openadsdk.core.h.2
            @Override // com.bytedance.sdk.openadsdk.core.h.z
            public void z(String str) {
                long unused = h.e = System.currentTimeMillis();
            }
        });
        f1114a = true;
        fileM.exists();
        g gVar = m;
        if (gVar != null) {
            gVar.startWatching();
        }
    }

    public static long dl() {
        return e;
    }

    private static final class g extends FileObserver {
        private z z;

        private g(String str, int i, z zVar) {
            super(str, i);
            this.z = zVar;
        }

        private g(File file, int i, z zVar) {
            super(file, i);
            this.z = zVar;
        }

        static g z(File file, z zVar) {
            if (file == null || zVar == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                return new g(file, 256, zVar);
            }
            return new g(file.getAbsolutePath(), 256, zVar);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i, String str) {
            z zVar = this.z;
            if (zVar != null) {
                zVar.z(str);
            }
        }
    }
}
