package com.bytedance.sdk.component.m.a;

import com.bytedance.sdk.component.m.io;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class i<T> extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f759a;
    private boolean dl;
    private com.bytedance.sdk.component.m.e g;
    private T z;

    @Override // com.bytedance.sdk.component.m.a.fo
    public String z() {
        return "success";
    }

    public i(T t, byte[] bArr, com.bytedance.sdk.component.m.e eVar, boolean z) {
        this.z = t;
        this.g = eVar;
        this.dl = z;
        this.f759a = bArr;
    }

    @Override // com.bytedance.sdk.component.m.a.fo
    public void z(com.bytedance.sdk.component.m.dl.dl dlVar) {
        String strLs = dlVar.ls();
        Map<String, List<com.bytedance.sdk.component.m.dl.dl>> mapE = dlVar.wp().e();
        List<com.bytedance.sdk.component.m.dl.dl> list = mapE.get(strLs);
        if (list == null) {
            g(dlVar);
            return;
        }
        synchronized (list) {
            Iterator<com.bytedance.sdk.component.m.dl.dl> it = list.iterator();
            while (it.hasNext()) {
                g(it.next());
            }
            list.clear();
            mapE.remove(strLs);
        }
    }

    private Map<String, String> g() {
        com.bytedance.sdk.component.m.e eVar = this.g;
        if (eVar != null) {
            return eVar.gc();
        }
        return null;
    }

    private void g(com.bytedance.sdk.component.m.dl.dl dlVar) {
        io ioVarDl = dlVar.dl();
        int iGc = dlVar.gc();
        if (ioVarDl != null) {
            T t = this.z;
            if (iGc == 3) {
                com.bytedance.sdk.component.m.g gVarI = dlVar.i();
                if (this.f759a == null && gVarI.isRawMemoryCache()) {
                    this.f759a = dlVar.wp().g(gVarI).z(dlVar.getRawCacheKey());
                }
                T t2 = (T) this.f759a;
                if (t2 == null) {
                    t2 = this.z;
                }
                t = (T) t2;
                if (!(t instanceof byte[])) {
                    ioVarDl.onFailed(2000, "final data is not raw", new RuntimeException("final data is not raw"));
                }
            } else if (iGc == 2 && (t instanceof byte[])) {
                try {
                    t = (T) dlVar.wp().z(dlVar).z((byte[]) t);
                } catch (Throwable th) {
                    ioVarDl.onFailed(2000, "decode failed", th);
                    return;
                }
            }
            ioVarDl.onSuccess(new com.bytedance.sdk.component.m.dl.a().z(dlVar, t, g(), this.dl));
        }
    }
}
