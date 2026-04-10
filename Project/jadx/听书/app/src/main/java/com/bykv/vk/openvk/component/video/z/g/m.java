package com.bykv.vk.openvk.component.video.z.g;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.SparseArray;
import com.bykv.vk.openvk.component.video.z.g.e;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile m f113a;
    private final AtomicInteger dl = new AtomicInteger(0);
    private volatile com.bykv.vk.openvk.component.video.z.g.z.g e;
    private final e.dl fo;
    private volatile int g;
    private volatile com.bykv.vk.openvk.component.video.z.g.g.dl gc;
    private final SparseArray<Set<e>> gz;
    private final AtomicBoolean i;
    private volatile dl kb;
    private volatile com.bykv.vk.openvk.component.video.z.g.z.dl m;
    private volatile dl uy;
    private final Runnable wp;
    private volatile ServerSocket z;

    static /* synthetic */ void z(String str, String str2) {
    }

    boolean z(int i, String str) {
        if (str == null) {
            return false;
        }
        synchronized (this.gz) {
            Set<e> set = this.gz.get(i);
            if (set != null) {
                for (e eVar : set) {
                    if (eVar != null && str.equals(eVar.gz)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static m z() {
        if (f113a == null) {
            synchronized (m.class) {
                if (f113a == null) {
                    f113a = new m();
                }
            }
        }
        return f113a;
    }

    private m() {
        SparseArray<Set<e>> sparseArray = new SparseArray<>(2);
        this.gz = sparseArray;
        this.fo = new e.dl() { // from class: com.bykv.vk.openvk.component.video.z.g.m.1
            @Override // com.bykv.vk.openvk.component.video.z.g.e.dl
            public void z(e eVar) {
                synchronized (m.this.gz) {
                    Set set = (Set) m.this.gz.get(eVar.m());
                    if (set != null) {
                        set.add(eVar);
                    }
                }
            }

            @Override // com.bykv.vk.openvk.component.video.z.g.e.dl
            public void g(e eVar) {
                boolean z2 = gc.dl;
                int iM = eVar.m();
                synchronized (m.this.gz) {
                    Set set = (Set) m.this.gz.get(iM);
                    if (set != null) {
                        set.remove(eVar);
                    }
                }
            }
        };
        this.wp = new Runnable() { // from class: com.bykv.vk.openvk.component.video.z.g.m.2
            /* JADX WARN: Removed duplicated region for block: B:33:0x0103  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instruction units count: 312
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.z.g.m.AnonymousClass2.run():void");
            }
        };
        this.i = new AtomicBoolean();
        sparseArray.put(0, new HashSet());
        sparseArray.put(1, new HashSet());
    }

    dl g() {
        return this.uy;
    }

    dl dl() {
        return this.kb;
    }

    void z(com.bykv.vk.openvk.component.video.z.g.g.dl dlVar) {
        this.gc = dlVar;
    }

    void z(com.bykv.vk.openvk.component.video.z.g.z.dl dlVar) {
        this.m = dlVar;
    }

    public String z(boolean z2, boolean z3, String str, String... strArr) {
        String str2;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return strArr[0];
        }
        if (this.gc == null) {
            return strArr[0];
        }
        if ((z2 ? this.e : this.m) == null) {
            return strArr[0];
        }
        if (this.dl.get() != 1) {
            return strArr[0];
        }
        List<String> listZ = com.bykv.vk.openvk.component.video.z.dl.z.z(strArr);
        if (listZ == null) {
            return strArr[0];
        }
        String strZ = fo.z(str, z3 ? str : com.bykv.vk.openvk.component.video.api.m.g.z(str), listZ);
        if (strZ == null) {
            return strArr[0];
        }
        if (z2) {
            str2 = "https://" + fo() + ":" + this.g + "?f=1&" + strZ;
        } else {
            str2 = "https://" + fo() + ":" + this.g + "?" + strZ;
        }
        return str2.replaceFirst("s", "");
    }

    public void a() {
        if (this.i.compareAndSet(false, true)) {
            com.bytedance.sdk.component.uy.a.dl dlVar = new com.bytedance.sdk.component.uy.a.dl(this.wp, "r/ProxyServer");
            dlVar.setName("csj_proxy_server");
            dlVar.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc() {
        if (this.dl.compareAndSet(1, 2) || this.dl.compareAndSet(0, 2)) {
            com.bykv.vk.openvk.component.video.z.dl.z.z(this.z);
            m();
        }
    }

    private void m() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.gz) {
            int size = this.gz.size();
            for (int i = 0; i < size; i++) {
                SparseArray<Set<e>> sparseArray = this.gz;
                Set<e> set = sparseArray.get(sparseArray.keyAt(i));
                if (set != null) {
                    arrayList.addAll(set);
                    set.clear();
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((e) it.next()).z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean e() {
        com.bytedance.sdk.component.uy.gz gzVar = new com.bytedance.sdk.component.uy.gz(new z(fo(), this.g), 5, 1);
        com.bytedance.sdk.component.uy.e.z().submit(gzVar);
        gz();
        try {
            if (!((Boolean) gzVar.get()).booleanValue()) {
                com.bytedance.sdk.component.utils.wp.a("ProxyServer", "Ping error");
                gc();
                return false;
            }
            com.bykv.vk.openvk.component.video.api.m.dl.z("ProxyServer", "pingTest: ");
            if (gc.dl) {
                com.bykv.vk.openvk.component.video.api.m.dl.z("ProxyServer", "Ping OK!");
            }
            return true;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
            Log.getStackTraceString(th);
            gc();
            return false;
        }
    }

    private static final class z implements Callable<Boolean> {
        private final int g;
        private final String z;

        z(String str, int i) {
            this.z = str;
            this.g = i;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            Socket socket;
            Throwable th;
            try {
                socket = new Socket(this.z, this.g);
            } catch (Throwable th2) {
                socket = null;
                th = th2;
            }
            try {
                socket.setSoTimeout(2000);
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write("Ping\n".getBytes(com.bykv.vk.openvk.component.video.z.dl.z.z));
                outputStream.flush();
                if ("OK".equals(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine())) {
                    return Boolean.TRUE;
                }
            } catch (Throwable th3) {
                th = th3;
                try {
                    com.bykv.vk.openvk.component.video.api.m.dl.z("ProxyServer", "call: ", th);
                    m.z("ping error", Log.getStackTraceString(th));
                } finally {
                    com.bykv.vk.openvk.component.video.z.dl.z.z(socket);
                }
            }
            com.bykv.vk.openvk.component.video.z.dl.z.z(socket);
            return Boolean.FALSE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    private void gz() {
        ?? r0;
        ?? Accept = 0;
        Accept = 0;
        try {
            try {
                Accept = this.z.accept();
                Accept.setSoTimeout(2000);
                boolean zEquals = "Ping".equals(new BufferedReader(new InputStreamReader(Accept.getInputStream())).readLine());
                r0 = Accept;
                if (zEquals) {
                    OutputStream outputStream = Accept.getOutputStream();
                    outputStream.write("OK\n".getBytes(com.bykv.vk.openvk.component.video.z.dl.z.z));
                    outputStream.flush();
                    r0 = Accept;
                }
            } catch (IOException e) {
                com.bytedance.sdk.component.utils.wp.z(e);
                Log.getStackTraceString(e);
                r0 = Accept;
            }
            com.bykv.vk.openvk.component.video.z.dl.z.z((Socket) r0);
            Accept = "ProxyServer";
            com.bykv.vk.openvk.component.video.api.m.dl.z("ProxyServer", "answerPing: ");
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.z.dl.z.z((Socket) Accept);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String fo() {
        return new String(Base64.decode("MTI3LjAuMC4x".getBytes(), 0));
    }
}
