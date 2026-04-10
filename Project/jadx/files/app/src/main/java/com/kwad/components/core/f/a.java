package com.kwad.components.core.f;

import android.content.Context;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.utils.g;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: com.kwad.components.core.f.a$a, reason: collision with other inner class name */
    static final class C0397a {
        private static final a JH = new a(0);
    }

    private a() {
    }

    /* synthetic */ a(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, long j2) {
        File[] fileArrListFiles = aj(context).listFiles(new FileFilter() { // from class: com.kwad.components.core.f.a.2
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                String name = file.getName();
                return name.startsWith("dynamic-") && name.endsWith(com.anythink.china.common.a.a.f6395g);
            }
        });
        if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
            return;
        }
        long jMax = 0;
        for (File file : fileArrListFiles) {
            jMax = Math.max(jMax, file.lastModified());
        }
        long jMin = Math.min(j2, jMax);
        for (File file2 : fileArrListFiles) {
            if (file2.exists() && file2.lastModified() < jMin) {
                file2.delete();
            }
        }
    }

    private static File aj(Context context) {
        return new File(context.getApplicationInfo().dataDir, "ksad_dynamic");
    }

    public static a nV() {
        return C0397a.JH;
    }

    public final void ai(final Context context) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        g.schedule(new Runnable() { // from class: com.kwad.components.core.f.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.a(context, jCurrentTimeMillis);
                } catch (Throwable th) {
                    b.printStackTraceOnly(th);
                }
            }
        }, 10L, TimeUnit.SECONDS);
    }
}
