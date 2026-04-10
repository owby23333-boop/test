package com.bytedance.sdk.openadsdk.core.ugeno.gc;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.adexpress.a.uy;
import com.bytedance.sdk.component.adexpress.gc.gc;
import com.bytedance.sdk.component.adexpress.z.dl.z;
import com.bytedance.sdk.component.adexpress.z.g.a;
import com.bytedance.sdk.component.adexpress.z.g.dl;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.e;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.ugeno.m.g;
import com.bytedance.sdk.openadsdk.core.zw;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z extends dl {
    private static volatile File dl;
    private static AtomicReference<g> gc = new AtomicReference<>(null);
    private static volatile z z;
    private AtomicBoolean g = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicBoolean f1361a = new AtomicBoolean(false);

    public static z g() {
        if (z == null) {
            synchronized (z.class) {
                if (z == null) {
                    z = new z();
                }
            }
        }
        return z;
    }

    public void dl() {
        e.z(new fo("enginecache-init") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.z.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    z.this.fo();
                    z.this.e();
                    z.this.a();
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fo() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            if (gc.get() != null) {
                return;
            }
            File file = new File(z(), "package_ugen_temp.json");
            Long lValueOf = Long.valueOf(file.length());
            if (lValueOf.longValue() > 0 && file.exists() && file.isFile()) {
                byte[] bArr = new byte[lValueOf.intValue()];
                fileInputStream = new FileInputStream(file);
                try {
                    fileInputStream.read(bArr);
                    gc.set(g.g(new JSONObject(new String(bArr, "utf-8"))));
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                    return;
                } catch (IOException e) {
                    wp.z(e);
                    return;
                }
            }
            return;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
        }
        try {
            wp.dl("PlayComponentEngineCacheManager", "version init error", th);
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    wp.z(e2);
                }
            }
        } catch (Throwable th4) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    wp.z(e3);
                }
            }
            throw th4;
        }
    }

    public void a() {
        try {
            if (this.g.get()) {
                return;
            }
            boolean z2 = true;
            this.g.set(true);
            g gVar = new g(zw.z().z(2));
            g gVar2 = gc.get();
            if (!gVar.m()) {
                this.g.set(false);
                return;
            }
            if (!z(gVar2, gVar.dl())) {
                this.g.set(false);
                return;
            }
            q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.z.2
                @Override // java.lang.Runnable
                public void run() {
                    gc.z().g();
                }
            });
            List<z.C0124z> listG = g(gVar, gVar2);
            if (listG == null) {
                z2 = false;
            }
            if (listG == null) {
                this.g.set(false);
            }
            if (z2 && z(gVar.getResources())) {
                gc.set(gVar);
                z(z(), gc.get(), "package_ugen_temp.json");
                g(listG);
            }
            e();
            this.g.set(false);
        } catch (Throwable unused) {
        }
    }

    public void gc() {
        g(z(), gc.get(), "package_ugen_temp.json");
        gc.set(null);
    }

    public void m() {
        try {
            gc();
            File fileZ = z();
            if (fileZ == null || !fileZ.exists()) {
                return;
            }
            if (fileZ.getParentFile() != null) {
                m.dl(fileZ.getParentFile());
            } else {
                m.dl(fileZ);
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    public void e() {
        g gVar = gc.get();
        if (gVar == null || !gVar.m()) {
            return;
        }
        boolean z2 = z(gVar.getResources());
        if (!z2) {
            gc();
        }
        this.f1361a.set(z2);
    }

    public boolean gz() {
        AtomicBoolean atomicBoolean = this.f1361a;
        return atomicBoolean != null && atomicBoolean.get();
    }

    @Override // com.bytedance.sdk.component.adexpress.z.g.dl
    public File z() {
        if (dl == null) {
            try {
                File file = new File(new File(a.z(), "tt_ugen_pkg"), "engine");
                file.mkdirs();
                dl = file;
            } catch (Throwable th) {
                wp.dl("PlayComponentEngineCacheManager", "ge", th);
            }
        }
        return dl;
    }

    public WebResourceResponse z(WebView webView, uy.z zVar, String str) {
        File fileG;
        try {
            if (TextUtils.isEmpty(str) || zVar == uy.z.IMAGE || (fileG = g(str)) == null) {
                return null;
            }
            return new WebResourceResponse(zVar.getType(), "utf-8", new FileInputStream(fileG));
        } catch (Throwable th) {
            wp.dl("PlayComponentEngineCacheManager", "grwe", th);
            return null;
        }
    }

    private File g(String str) {
        g gVar;
        if (!gz() || (gVar = gc.get()) == null) {
            return null;
        }
        for (z.C0124z c0124z : gVar.getResources()) {
            if (c0124z.z() != null && c0124z.z().equals(str)) {
                File file = new File(z(), com.bytedance.sdk.component.utils.gc.g(c0124z.z()));
                String strZ = com.bytedance.sdk.component.utils.gc.z(file);
                if (c0124z.g() == null || !c0124z.g().equals(strZ)) {
                    return null;
                }
                return file;
            }
        }
        return null;
    }
}
