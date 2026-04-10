package com.bytedance.sdk.component.gz.g.z.z.g;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g extends com.bytedance.sdk.component.gz.g.z.z implements dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.component.gz.g.a.g.z f750a;
    private com.bytedance.sdk.component.gz.z.gc dl;
    private final Context g;
    protected final List<com.bytedance.sdk.component.gz.z.g> z = new ArrayList();
    private boolean gc = false;
    private final Runnable m = new Runnable() { // from class: com.bytedance.sdk.component.gz.g.z.z.g.g.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (g.this) {
                if (g.this.z.isEmpty()) {
                    g.this.gc = false;
                    return;
                }
                ArrayList arrayList = new ArrayList(g.this.z);
                g.this.z.clear();
                g.this.gc = false;
                g.this.g(arrayList);
            }
        }
    };

    abstract com.bytedance.sdk.component.gz.z.gc a();

    public abstract String z();

    public g(Context context, com.bytedance.sdk.component.gz.z.gc gcVar, com.bytedance.sdk.component.gz.g.a.g.z zVar) {
        this.g = context;
        this.dl = gcVar;
        this.f750a = zVar;
    }

    private void g() {
        if (this.gc) {
            return;
        }
        com.bytedance.sdk.component.gz.g.e.z.z(a()).z().postDelayed(this.m, r0.g());
        this.gc = true;
    }

    public List<com.bytedance.sdk.component.gz.z.g> z(int i, int i2, com.bytedance.sdk.component.gz.z.g gVar, boolean z) {
        int iG;
        if (this.f750a == null || gVar == null || !com.bytedance.sdk.component.gz.g.dl.z.z(i) || !z(gVar) || (iG = this.f750a.g()) <= i2) {
            return null;
        }
        return z(iG - i2, ar.d, i, z);
    }

    public com.bytedance.sdk.component.gz.g.z.g z(int i, List<com.bytedance.sdk.component.gz.z.g> list) {
        com.bytedance.sdk.component.gz.g.z.g gVar = new com.bytedance.sdk.component.gz.g.z.g();
        if (list != null && list.size() != 0 && list.get(0) != null && z(list.get(0))) {
            if (i == 200 || i == -1 || i == -3) {
                gVar.z(delete(list));
            } else {
                gVar.z("code:".concat(String.valueOf(i)));
            }
            gVar.z(true);
            return gVar;
        }
        gVar.z(false);
        return gVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0027 A[EXC_TOP_SPLITTER, PHI: r0 r1
  0x0027: PHI (r0v3 android.database.Cursor) = (r0v2 android.database.Cursor), (r0v4 android.database.Cursor) binds: [B:13:0x0032, B:6:0x0025] A[DONT_GENERATE, DONT_INLINE]
  0x0027: PHI (r1v3 int) = (r1v0 int), (r1v5 int) binds: [B:13:0x0032, B:6:0x0025] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int gc() {
        /*
            r11 = this;
            r0 = 0
            r1 = 0
            android.content.Context r2 = r11.getContext()     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L32
            java.lang.String r3 = r11.z()     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L32
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L32
            java.lang.String r5 = "count(1)"
            r4[r1] = r5     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L32
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            com.bytedance.sdk.component.gz.z.gc r10 = r11.dl     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L32
            android.database.Cursor r0 = com.bytedance.sdk.component.gz.g.z.z.g.query(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L32
            if (r0 == 0) goto L25
            r0.moveToFirst()     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L32
            int r1 = r0.getInt(r1)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L32
        L25:
            if (r0 == 0) goto L35
        L27:
            r0.close()     // Catch: java.lang.Exception -> L35
            goto L35
        L2b:
            r1 = move-exception
            if (r0 == 0) goto L31
            r0.close()     // Catch: java.lang.Exception -> L31
        L31:
            throw r1
        L32:
            if (r0 == 0) goto L35
            goto L27
        L35:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.gz.g.z.z.g.g.gc():int");
    }

    protected void z(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            Iterator<com.bytedance.sdk.component.gz.z.g> it = this.z.iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.component.gz.z.g next = it.next();
                if (next != null) {
                    String strDl = next.dl();
                    if (!TextUtils.isEmpty(strDl) && list.contains(strDl)) {
                        it.remove();
                    }
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.gz.g.dl.dl.z("DBInsertMemRepo", z() + "deleteMemList: " + th.getMessage(), this.dl.gc());
        }
    }

    public synchronized void g(com.bytedance.sdk.component.gz.z.g gVar) {
        if (z(gVar) && gVar.e() != null && !TextUtils.isEmpty(gVar.dl())) {
            this.z.add(gVar);
            g();
        }
    }

    public Context getContext() {
        return this.g;
    }

    public void g(List<com.bytedance.sdk.component.gz.z.g> list) {
        com.bytedance.sdk.component.gz.g.z.z.g.insert(getContext(), z(), list, this.dl);
        Iterator<com.bytedance.sdk.component.gz.z.g> it = list.iterator();
        while (it.hasNext()) {
            com.bytedance.sdk.component.gz.g.dl.z.z(it.next(), this.dl, "_db");
        }
    }

    @Override // com.bytedance.sdk.component.gz.g.z.z
    public List<com.bytedance.sdk.component.gz.z.g> g(int i, com.bytedance.sdk.component.gz.z.g gVar, boolean z, List<String> list, String str) {
        List<com.bytedance.sdk.component.gz.z.g> listZ = z(ar.d, i, z);
        if (!z(listZ, list)) {
            return null;
        }
        z();
        listZ.size();
        return listZ;
    }

    @Override // com.bytedance.sdk.component.gz.g.z.z
    public boolean z(String str) {
        if (this.f750a == null) {
            return false;
        }
        int iGc = gc();
        com.bytedance.sdk.component.gz.g.dl.dl.z("check flush db " + z() + " count:" + iGc, this.dl);
        return iGc > 0;
    }

    @Override // com.bytedance.sdk.component.gz.g.z.z
    public boolean g(int i, String str, com.bytedance.sdk.component.gz.z.g gVar) {
        if (this.f750a == null) {
            return false;
        }
        int iGc = gc();
        int iZ = this.f750a.z();
        com.bytedance.sdk.component.gz.g.dl.dl.z("check db " + z() + " count:" + iGc + " MaxCacheCount:" + iZ + " message:" + com.bytedance.sdk.component.gz.g.dl.z.g(i), this.dl);
        return iGc >= iZ;
    }

    private boolean z(List<com.bytedance.sdk.component.gz.z.g> list, List<String> list2) {
        if (list != null && !list.isEmpty() && list2 != null && !list2.isEmpty()) {
            try {
                Iterator<com.bytedance.sdk.component.gz.z.g> it = list.iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.component.gz.z.g next = it.next();
                    if (next != null) {
                        String strDl = next.dl();
                        if (!TextUtils.isEmpty(strDl) && list2.contains(strDl)) {
                            it.remove();
                        }
                    }
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.gz.g.dl.dl.z("DBInsertMemRepo", "deleteMemList: " + th.getMessage(), this.dl);
            }
        }
        return (list == null || list.isEmpty()) ? false : true;
    }
}
