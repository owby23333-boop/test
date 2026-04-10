package com.bytedance.msdk.dl.dl.z;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.msdk.dl.dl.z.z;
import com.bytedance.msdk.gz.h;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class e implements z.InterfaceC0102z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f446a;
    private int dl;
    private com.bytedance.msdk.dl.m.z.g g;
    private List<z> z;

    static /* synthetic */ int a(e eVar) {
        int i = eVar.dl;
        eVar.dl = i + 1;
        return i;
    }

    static /* synthetic */ int m(e eVar) {
        int i = eVar.f446a;
        eVar.f446a = i + 1;
        return i;
    }

    public e(List<z> list) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.z = copyOnWriteArrayList;
        this.dl = 0;
        this.f446a = 0;
        if (list != null) {
            copyOnWriteArrayList.addAll(list);
        }
    }

    @Override // com.bytedance.msdk.dl.dl.z.z.InterfaceC0102z
    public void z(com.bytedance.msdk.dl.m.z.g gVar) {
        if (this.g != gVar && gVar != null) {
            this.g = gVar;
        }
        if (h.z(this.z)) {
            return;
        }
        com.bytedance.msdk.z.gc.m.z(new Runnable() { // from class: com.bytedance.msdk.dl.dl.z.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dl == 0 && e.this.g != null) {
                    e.this.g.g(SystemClock.elapsedRealtime());
                }
                if (e.this.z.size() > e.this.dl) {
                    ((z) e.this.z.get(e.a(e.this))).z(e.this);
                }
            }
        });
    }

    @Override // com.bytedance.msdk.dl.dl.z.z.InterfaceC0102z
    public com.bytedance.msdk.dl.m.z.g z() {
        return this.g;
    }

    @Override // com.bytedance.msdk.dl.dl.z.z.InterfaceC0102z
    public void z(String str) {
        com.bytedance.msdk.dl.m.z.g gVar;
        if (!TextUtils.isEmpty(str) && (gVar = this.g) != null) {
            gVar.g(str);
        }
        com.bytedance.msdk.z.gc.m.z(new Runnable() { // from class: com.bytedance.msdk.dl.dl.z.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.z.size() > e.this.f446a) {
                    ((z) e.this.z.get(e.m(e.this))).g(e.this);
                }
            }
        });
    }
}
