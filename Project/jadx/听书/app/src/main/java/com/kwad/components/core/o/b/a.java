package com.kwad.components.core.o.b;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.library.solder.lib.i;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a<T extends IOfflineCompo<?>> {
    private long II;
    private String Ry = "";

    protected abstract void a(Context context, boolean z, T t);

    protected abstract String getTag();

    public abstract boolean isEnabled();

    protected abstract String qA();

    protected abstract String qB();

    protected abstract String qC();

    protected abstract String qD();

    protected abstract String qE();

    public abstract String qy();

    protected abstract String qz();

    public final void init(Context context) {
        try {
            if (isEnabled()) {
                this.II = SystemClock.elapsedRealtime();
                com.kwad.components.core.o.c.a.c(qy(), getDuration());
                c.d(getTag(), "init start");
                aw(context);
                return;
            }
            try {
                c.d(getTag(), "del start");
                com.kwad.library.solder.a.a.l(context, qz());
            } catch (Throwable unused) {
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getDuration() {
        return SystemClock.elapsedRealtime() - this.II;
    }

    private void aw(final Context context) {
        if (com.kwad.components.core.a.MX.booleanValue()) {
            c.d(getTag(), "init start disableOffline");
            a(context, false, getClass().getClassLoader());
        } else {
            com.kwad.library.solder.lib.c.b bVarQv = qv();
            c.d(getTag(), "load component start pluginInfo: " + bVarQv);
            com.kwad.library.solder.a.a.a(context, bVarQv, new b.a() { // from class: com.kwad.components.core.o.b.a.1
                long Rz;

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.library.solder.lib.ext.b.C0383b, com.kwad.library.solder.lib.ext.b
                public void a(com.kwad.library.solder.lib.b.a aVar, com.kwad.library.b.a aVar2) {
                    super.a(aVar, aVar2);
                    c.d(a.this.getTag(), "load component resource success");
                    com.kwad.components.core.o.c.a.a(a.this.qy(), a.this.getDuration(), a.this.Ry);
                    a.this.a(context, !"LOCAL".equals(r4.Ry), aVar2.zI());
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.library.solder.lib.ext.b.C0383b, com.kwad.library.solder.lib.ext.b
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void d(com.kwad.library.solder.lib.b.a aVar) {
                    super.d(aVar);
                    c.d(a.this.getTag(), "update component resource success");
                    com.kwad.components.core.o.c.c.a(a.this.qy(), a.this.getDuration(), SystemClock.elapsedRealtime() - this.Rz, a.this.Ry);
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.library.solder.lib.ext.b.C0383b, com.kwad.library.solder.lib.ext.b
                public void a(com.kwad.library.solder.lib.b.a aVar, PluginError pluginError) {
                    super.a(aVar, pluginError);
                    if (aVar.getState() == 1) {
                        com.kwad.components.core.o.c.c.b(a.this.qy(), a.this.getDuration(), pluginError.getCode(), a.this.Ry, pluginError.getMessage());
                    }
                    com.kwad.components.core.o.c.a.a(a.this.qy(), a.this.getDuration(), pluginError.getCode(), "cmp_load_error " + pluginError.getMessage(), a.this.Ry);
                    c.d(a.this.getTag(), "load component resource failed error: " + pluginError);
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.library.solder.lib.ext.b.C0383b, com.kwad.library.solder.lib.ext.b
                public void b(com.kwad.library.solder.lib.b.a aVar) {
                    super.b(aVar);
                    c.d(a.this.getTag(), "install component resource start");
                    com.kwad.components.core.o.c.a.b(a.this.qy(), a.this.getDuration(), a.this.Ry);
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.library.solder.lib.ext.b.C0383b, com.kwad.library.solder.lib.ext.b
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void a(com.kwad.library.solder.lib.b.a aVar) {
                    super.a(aVar);
                    c.d(a.this.getTag(), "install component resource success");
                    com.kwad.components.core.o.c.a.c(a.this.qy(), a.this.getDuration(), a.this.Ry);
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.library.solder.lib.ext.b.C0383b, com.kwad.library.solder.lib.ext.b
                /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
                public void e(com.kwad.library.solder.lib.b.a aVar) {
                    super.e(aVar);
                    this.Rz = SystemClock.elapsedRealtime();
                    a.this.Ry = aVar.Ai() ? "ASSETS" : "NETWORK";
                    c.d(a.this.getTag(), "update component resource start");
                    com.kwad.components.core.o.c.c.d(a.this.qy(), a.this.getDuration(), a.this.Ry);
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.library.solder.lib.ext.b.C0383b, com.kwad.library.solder.lib.ext.b
                /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
                public void c(com.kwad.library.solder.lib.b.a aVar) {
                    super.c(aVar);
                    c.d(a.this.getTag(), "load component resource start");
                    a.this.Ry = "LOCAL";
                    com.kwad.components.core.o.c.a.b(a.this.qy(), a.this.getDuration(), aVar.zZ().zM().An());
                }
            });
        }
    }

    private com.kwad.library.solder.lib.c.b qv() {
        com.kwad.library.solder.lib.c.b bVar = new com.kwad.library.solder.lib.c.b();
        bVar.arx = qz();
        bVar.enable = true;
        bVar.arB = false;
        bVar.ary = com.kwad.sdk.core.network.idc.a.HF().ef(qB());
        bVar.version = qA();
        bVar.arA = qC();
        if (com.kwad.components.core.a.Na.booleanValue()) {
            bVar.ara = qD();
            bVar.arb = true;
        }
        if (TextUtils.isEmpty(qC()) || TextUtils.isEmpty(qz()) || TextUtils.isEmpty(qA()) || TextUtils.isEmpty(qB())) {
            com.kwad.components.core.o.c.a.a(qy(), getDuration(), 6001, "buildRemotePlugInfo error", this.Ry);
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, boolean z, ClassLoader classLoader) {
        qw();
        String strQE = qE();
        try {
            IOfflineCompo iOfflineCompo = (IOfflineCompo) classLoader.loadClass(strQE).newInstance();
            c.d(getTag(), "load component instance success: " + iOfflineCompo.getClass().getName() + ", loadFromNet:" + z + ", classLoader:" + classLoader);
            a(context, z, iOfflineCompo);
        } catch (Throwable th) {
            com.kwad.components.core.o.c.a.a(qy(), getDuration(), 4005, "loadClass error", this.Ry);
            c.e(getTag(), "loadClass or instance failed: " + strQE, th);
        }
    }

    private void qw() {
        c.d(getTag(), "init component start cost: " + getDuration());
        com.kwad.components.core.o.c.a.d(qy(), getDuration());
    }

    public final void qx() {
        c.d(getTag(), "init component success cost: " + getDuration());
        com.kwad.components.core.o.c.a.c(qy(), getDuration(), i.zS().zM().An());
    }

    public final void aJ(int i) {
        c.d(getTag(), "init component error time: " + getDuration());
        com.kwad.components.core.o.c.a.a(qy(), getDuration(), 5001, "cmp_init_error, errorCode:" + i, this.Ry);
    }
}
