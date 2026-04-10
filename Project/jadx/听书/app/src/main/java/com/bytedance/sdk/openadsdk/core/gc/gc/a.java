package com.bytedance.sdk.openadsdk.core.gc.gc;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.openadsdk.core.fo;
import com.bytedance.sdk.openadsdk.core.gc.gc;
import com.bytedance.sdk.openadsdk.core.iq.gz;
import com.bytedance.sdk.openadsdk.core.iq.j;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.sy;
import com.bytedance.sdk.openadsdk.core.zw;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a<T> extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f1092a;

    private interface z {
        void z(boolean z);
    }

    public a(int i) {
        super(i);
        this.f1092a = System.currentTimeMillis();
    }

    public void z(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final j jVar, final int i, final gc<T> gcVar) {
        com.bytedance.sdk.openadsdk.hh.e.a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.gc.gc.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.g(gVar, jVar, i, new m(gcVar));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, j jVar, int i, gc<T> gcVar) {
        if (gVar == null) {
            return;
        }
        if (i == -1) {
            i = g();
        }
        gVar.a();
        if (i == 1) {
            z(gVar, gcVar, jVar);
            return;
        }
        if (i == 2) {
            g(gVar, gcVar, jVar);
            return;
        }
        if (i == 3) {
            dl(gVar, gcVar, jVar);
            return;
        }
        if (i == 4) {
            gc(gVar, gcVar, jVar);
        } else if (i == 5) {
            e(gVar, gcVar, jVar);
        } else {
            a(gVar, gcVar, jVar);
        }
    }

    private void z(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final gc<T> gcVar, final j jVar) {
        final com.bytedance.sdk.openadsdk.core.gc.gc.z.z zVar = new com.bytedance.sdk.openadsdk.core.gc.gc.z.z(this.z) { // from class: com.bytedance.sdk.openadsdk.core.gc.gc.a.6
            @Override // com.bytedance.sdk.openadsdk.core.gc.gc.z.z
            public void z() {
                a.this.z(gVar, gcVar, jVar, this);
            }
        };
        z(gVar, gcVar, jVar.m == 2, zVar, 0L, new z() { // from class: com.bytedance.sdk.openadsdk.core.gc.gc.a.7
            @Override // com.bytedance.sdk.openadsdk.core.gc.gc.a.z
            public void z(boolean z2) {
                if (z2) {
                    return;
                }
                zVar.z(false);
            }
        });
    }

    private void g(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, gc<T> gcVar, j jVar) {
        final com.bytedance.sdk.openadsdk.core.gc.gc.z.a aVar = new com.bytedance.sdk.openadsdk.core.gc.gc.z.a(this.z);
        aVar.z();
        z(gVar, gcVar, jVar, aVar);
        z(gVar, gcVar, jVar.m == 2, aVar, 0L, new z() { // from class: com.bytedance.sdk.openadsdk.core.gc.gc.a.8
            @Override // com.bytedance.sdk.openadsdk.core.gc.gc.a.z
            public void z(boolean z2) {
                aVar.z(true);
            }
        });
    }

    private void dl(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, gc<T> gcVar, j jVar) {
        final com.bytedance.sdk.openadsdk.core.gc.gc.z.dl dlVar = new com.bytedance.sdk.openadsdk.core.gc.gc.z.dl(this.z);
        z(gVar, gcVar, jVar, dlVar);
        z(gVar, gcVar, jVar.m == 2, dlVar, 0L, new z() { // from class: com.bytedance.sdk.openadsdk.core.gc.gc.a.9
            @Override // com.bytedance.sdk.openadsdk.core.gc.gc.a.z
            public void z(boolean z2) {
                if (z2) {
                    return;
                }
                dlVar.z(false);
            }
        });
    }

    private void a(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, gc<T> gcVar, j jVar) {
        z(gVar, gcVar, jVar, (com.bytedance.sdk.openadsdk.core.gc.gc.z.g) null);
    }

    private void gc(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final gc<T> gcVar, j jVar) {
        z(gVar, gcVar, jVar.m == 2, (com.bytedance.sdk.openadsdk.core.gc.gc.z.g) null, 0L, new z() { // from class: com.bytedance.sdk.openadsdk.core.gc.gc.a.10
            @Override // com.bytedance.sdk.openadsdk.core.gc.gc.a.z
            public void z(boolean z2) {
                if (z2) {
                    return;
                }
                gcVar.z(-3, "no cache");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, gc<T> gcVar, j jVar) {
        long jCurrentTimeMillis;
        final gz.dl dlVarUy = this.z.uy();
        final gc.z zVarZ = com.bytedance.sdk.openadsdk.core.gc.gc.z(gVar.a(), dlVarUy);
        final com.bytedance.sdk.openadsdk.core.gc.gc.z.a aVar = new com.bytedance.sdk.openadsdk.core.gc.gc.z.a(this.z);
        aVar.z();
        z(gVar, gcVar, jVar, aVar);
        gVar.a();
        final int iZ = zVarZ.z(dlVarUy.gc(), dlVarUy);
        if (iZ < 0) {
            gVar.a();
            aVar.z(false);
            return;
        }
        if (iZ > 0) {
            jCurrentTimeMillis = System.currentTimeMillis() - ((((long) iZ) * 60) * 1000);
            gVar.a();
        } else {
            jCurrentTimeMillis = 0;
        }
        z(gVar, gcVar, jVar.m == 2, aVar, jCurrentTimeMillis, new z() { // from class: com.bytedance.sdk.openadsdk.core.gc.gc.a.11
            @Override // com.bytedance.sdk.openadsdk.core.gc.gc.a.z
            public void z(boolean z2) {
                gVar.a();
                aVar.z(z2);
                if (z2) {
                    zVarZ.z(a.this.g, gVar, dlVarUy, "backup_cache", new StringBuilder().append(iZ).toString());
                }
            }
        });
    }

    private void e(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, gc<T> gcVar, j jVar) {
        double d;
        gz.dl dlVarUy = this.z.uy();
        gc.z zVarZ = com.bytedance.sdk.openadsdk.core.gc.gc.z(gVar.a(), dlVarUy);
        if (dlVarUy.g() > 0) {
            gVar.a();
            try {
                d = Double.parseDouble(com.bytedance.sdk.openadsdk.core.sy.z.z().z("DeviceRate", "bytebench_value"));
            } catch (Exception unused) {
                d = 0.0d;
            }
            if (d > 0.0d && d < dlVarUy.g()) {
                gVar.a();
                z(gVar, (gc) gcVar, jVar, true, 0L, "device_score", String.valueOf(d));
                return;
            }
        }
        if (dlVarUy.dl() > 0) {
            gVar.a();
            int iDl = v.dl(zw.getContext());
            boolean z2 = true;
            if (iDl == 2 ? (dlVarUy.dl() & 1) == 0 : iDl == 3 ? (2 & dlVarUy.dl()) == 0 : iDl == 4 ? (dlVarUy.dl() & 16) == 0 : iDl == 5 ? (4 & dlVarUy.dl()) == 0 : iDl != 6 || (dlVarUy.dl() & 8) == 0) {
                z2 = false;
            }
            if (z2) {
                gVar.a();
                z(gVar, (gc) gcVar, jVar, true, 0L, "net_type", String.valueOf(iDl));
                return;
            }
        }
        if (dlVarUy.a() > 0) {
            gVar.a();
            zVarZ.z(dlVarUy);
            int iZ = zVarZ.z(dlVarUy.a(), dlVarUy);
            if (iZ > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis() - ((((long) iZ) * 60) * 1000);
                gVar.a();
                z(gVar, (gc) gcVar, jVar, true, jCurrentTimeMillis, "good_cache", String.valueOf(iZ));
                return;
            } else if (iZ == 0) {
                gVar.a();
                z(gVar, (gc) gcVar, jVar, true, 0L, "behavior_score", String.valueOf(iZ));
                return;
            }
        }
        gVar.a();
        z(gVar, (gc) gcVar, jVar, false, 0L, "", "");
    }

    private void z(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final gc<T> gcVar, final j jVar, boolean z2, long j, final String str, final String str2) {
        final gz.dl dlVarUy = this.z.uy();
        final gc.z zVarZ = com.bytedance.sdk.openadsdk.core.gc.gc.z(gVar.a(), dlVarUy);
        if (z2) {
            gVar.a();
            final com.bytedance.sdk.openadsdk.core.gc.gc.z.z zVar = new com.bytedance.sdk.openadsdk.core.gc.gc.z.z(this.z) { // from class: com.bytedance.sdk.openadsdk.core.gc.gc.a.12
                @Override // com.bytedance.sdk.openadsdk.core.gc.gc.z.z
                public void z() {
                    gVar.a();
                    a.this.m(gVar, gcVar, jVar);
                }
            };
            z(gVar, gcVar, jVar.m == 2, zVar, j, new z() { // from class: com.bytedance.sdk.openadsdk.core.gc.gc.a.13
                @Override // com.bytedance.sdk.openadsdk.core.gc.gc.a.z
                public void z(boolean z3) {
                    gVar.a();
                    if (!z3) {
                        zVar.z(false);
                    } else {
                        zVarZ.z(a.this.g, gVar, dlVarUy, str, str2);
                    }
                }
            });
        } else {
            gVar.a();
            m(gVar, gcVar, jVar);
        }
    }

    private void z(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final gc<T> gcVar, final boolean z2, final com.bytedance.sdk.openadsdk.core.gc.gc.z.g gVar2, long j, final z zVar) {
        List<na> listZ;
        gVar.a();
        if (!TextUtils.isEmpty(gVar.q())) {
            zVar.z(false);
            return;
        }
        if (z(z2) == null) {
            zVar.z(false);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iMin = Math.min(gz.z(this.g).kb(), gVar.wp());
        if (this.dl != null) {
            this.dl.g(gVar.a());
            listZ = this.dl.z(gVar.a(), j, iMin);
        } else {
            listZ = null;
        }
        if (listZ == null || listZ.isEmpty()) {
            zVar.z(false);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (na naVar : listZ) {
            if (z(naVar)) {
                arrayList.add(naVar);
            }
        }
        if (arrayList.isEmpty()) {
            zVar.z(false);
            return;
        }
        if (!z(z2).z(gVar, arrayList)) {
            zVar.z(false);
            return;
        }
        gVar.a();
        arrayList.size();
        com.bytedance.sdk.openadsdk.core.gc.g.z zVar2 = new com.bytedance.sdk.openadsdk.core.gc.g.z(this.g);
        zVar2.z(jCurrentTimeMillis);
        zVar2.g(System.currentTimeMillis());
        zVar2.z(arrayList, new com.bytedance.sdk.openadsdk.core.gc.g.gc() { // from class: com.bytedance.sdk.openadsdk.core.gc.gc.a.2
            @Override // com.bytedance.sdk.openadsdk.core.gc.g.gc
            public void z(List<na> list) {
                a.this.z(list, gVar, z2, gVar2, gcVar, zVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.gc.g.gc
            public void g(List<na> list) {
                gVar.a();
                list.size();
                if (!list.isEmpty()) {
                    a.this.z(list, gVar, z2, gVar2, gcVar, zVar);
                } else {
                    zVar.z(false);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.gc.g.gc
            public void dl(List<na> list) {
                Iterator<na> it = list.iterator();
                while (it.hasNext()) {
                    a.this.dl.z(gVar.a(), it.next());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final gc<T> gcVar, final j jVar, final com.bytedance.sdk.openadsdk.core.gc.gc.z.g gVar2) {
        gVar.a();
        zw.z().z(gVar, jVar, this.g, new sy.g() { // from class: com.bytedance.sdk.openadsdk.core.gc.gc.a.3
            @Override // com.bytedance.sdk.openadsdk.core.sy.g
            public void z(int i, String str, com.bytedance.sdk.openadsdk.core.iq.g gVar3) {
                gVar.a();
                if (a.this.z(jVar.m == 2) != null) {
                    a.this.z(jVar.m == 2).z(gVar, i, str, gVar3);
                }
                com.bytedance.sdk.openadsdk.core.gc.gc.z.g gVar4 = gVar2;
                if (gVar4 != null) {
                    gVar4.z(gcVar, i, str);
                    return;
                }
                gc gcVar2 = gcVar;
                if (gcVar2 != null) {
                    gcVar2.z(i, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.sy.g
            public void z(com.bytedance.sdk.openadsdk.core.iq.z zVar, final com.bytedance.sdk.openadsdk.core.iq.g gVar3) {
                gVar.a();
                com.bytedance.sdk.openadsdk.core.gc.z.z zVarZ = a.this.z(jVar.m == 2);
                if (zVarZ == null) {
                    return;
                }
                zVarZ.z(a.this.g, zVar, gVar3, jVar, gVar, gcVar, new e() { // from class: com.bytedance.sdk.openadsdk.core.gc.gc.a.3.1
                    @Override // com.bytedance.sdk.openadsdk.core.gc.gc.e
                    public void z(dl dlVar) {
                        if (dlVar != null) {
                            if (gVar2 == null) {
                                dlVar.z();
                            } else {
                                gVar2.z(dlVar);
                            }
                        }
                        if (gVar2 != null) {
                            gVar2.dl();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.gc.gc.e
                    public void z(int i) {
                        if (gcVar != null) {
                            gcVar.z(i, fo.z(i));
                        }
                        gVar3.z(i);
                        com.bytedance.sdk.openadsdk.core.iq.g.z(gVar3);
                        if (gVar2 != null) {
                            gVar2.dl();
                        }
                    }
                });
            }
        });
    }

    public void z(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final j jVar) {
        if (gVar == null) {
            return;
        }
        gVar.a();
        if (com.bytedance.sdk.openadsdk.core.live.gc.a.z(gVar.iq())) {
            com.bytedance.sdk.openadsdk.hh.e.a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.gc.gc.a.4
                @Override // java.lang.Runnable
                public void run() {
                    if (!TextUtils.isEmpty(gVar.q())) {
                        if (a.this.z(jVar.m == 2) != null) {
                            a.this.z(jVar.m == 2).z(gVar);
                        }
                    } else if (a.this.g() != 0 && a.this.dl.z(gVar.a())) {
                        gVar.a();
                        a.this.z(gVar, (gc) null, jVar, (com.bytedance.sdk.openadsdk.core.gc.gc.z.g) null);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final List<na> list, final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, boolean z2, final com.bytedance.sdk.openadsdk.core.gc.gc.z.g gVar2, gc<T> gcVar, final z zVar) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_playAgain", false);
        bundle.putBoolean("is_cache", true);
        bundle.putLong(d.p, this.f1092a);
        z(z2).z(this.g, list, gVar, gcVar, bundle, new e() { // from class: com.bytedance.sdk.openadsdk.core.gc.gc.a.5
            @Override // com.bytedance.sdk.openadsdk.core.gc.gc.e
            public void z(int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.gc.gc.e
            public void z(dl dlVar) {
                com.bytedance.sdk.openadsdk.core.gc.gc.z.g gVar3 = gVar2;
                if (gVar3 != null) {
                    gVar3.g(dlVar);
                    gVar2.z(true);
                    list.size();
                    gVar.a();
                } else {
                    dlVar.z();
                    list.size();
                    gVar.a();
                }
                zVar.z(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g() {
        return (this.z == null || this.z.gz() == -1) ? com.bytedance.sdk.openadsdk.core.gc.gc.z.z(this.g) : this.z.gz();
    }
}
