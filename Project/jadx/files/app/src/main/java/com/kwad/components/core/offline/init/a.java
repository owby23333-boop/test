package com.kwad.components.core.offline.init;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.n.e;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.utils.x;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, ClassLoader classLoader) {
        boolean zB;
        try {
            zB = b(context, classLoader);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
            zB = false;
        }
        x.b(context, od(), oe(), zB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(Context context) {
        String tag;
        String str;
        com.kwad.sdk.core.d.b.d(getTag(), "initReal");
        if (isEnabled()) {
            com.kwad.sdk.core.d.b.d(getTag(), "initReal disableOfflineComponents: " + com.kwad.components.core.a.Hy + " , isDevelopEnable: " + com.kwad.components.core.a.bI + " , DEBUG: false");
            if (com.kwad.components.core.a.Hy.booleanValue()) {
                a(context, getClass().getClassLoader());
            } else {
                am(context);
            }
            tag = getTag();
            str = "initReal end";
        } else {
            tag = getTag();
            str = "initReal disable";
        }
        com.kwad.sdk.core.d.b.d(tag, str);
    }

    private void am(final Context context) {
        com.kwai.sodler.lib.c.b bVarOc = oc();
        com.kwad.sdk.core.d.b.d(getTag(), "loadComponents pluginInfo: " + bVarOc);
        com.kwai.sodler.kwai.a.a(context, bVarOc, new b.a() { // from class: com.kwad.components.core.offline.init.a.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0473b, com.kwai.sodler.lib.ext.b
            public void a(com.kwai.sodler.lib.b.a aVar, PluginError pluginError) {
                super.a(aVar, pluginError);
                com.kwad.sdk.core.d.b.d(a.this.getTag(), "loadComponents failed error: " + pluginError);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0473b, com.kwai.sodler.lib.ext.b
            public void a(com.kwai.sodler.lib.b.a aVar, com.kwai.sodler.lib.kwai.a aVar2) {
                super.a(aVar, aVar2);
                String tag = a.this.getTag();
                if (aVar2 == null) {
                    com.kwad.sdk.core.d.b.d(tag, "loadComponents failed plugin null");
                } else {
                    com.kwad.sdk.core.d.b.d(tag, "loadComponents success");
                    a.this.a(context, aVar2.Jj());
                }
            }
        });
    }

    private com.kwai.sodler.lib.c.b oc() {
        com.kwai.sodler.lib.c.b bVar = new com.kwai.sodler.lib.c.b();
        bVar.aJy = od();
        bVar.It = true;
        bVar.aJC = false;
        bVar.aJz = com.kwad.sdk.core.network.idc.a.wy().bR(of());
        bVar.version = oe();
        bVar.aJB = og();
        if (com.kwad.components.core.a.HB.booleanValue()) {
            bVar.aJg = oh();
            bVar.aJh = true;
        }
        return bVar;
    }

    public final <T extends IOfflineCompo> T a(ClassLoader classLoader, String str) {
        T t2;
        com.kwad.sdk.core.d.b.d(getTag(), "onOfflineComponentsLoaded classLoader:" + classLoader);
        try {
            t2 = (T) classLoader.loadClass(str).newInstance();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.e(getTag(), "loadClass or instance failed: " + str, th);
            t2 = null;
        }
        com.kwad.sdk.core.d.b.d(getTag(), "onOfflineComponentsLoaded components: " + t2);
        return t2;
    }

    protected abstract boolean b(Context context, ClassLoader classLoader);

    protected abstract String getTag();

    public final void init(final Context context) {
        final boolean zI = x.i(context, od(), oe());
        com.kwad.sdk.core.d.b.d(getTag(), "init isSuccessLoaded: getCompoName()" + od() + zI);
        e.a(new e.a() { // from class: com.kwad.components.core.offline.init.a.1
            @Override // com.kwad.components.core.n.e.a
            public final void a(@NonNull SdkConfigData sdkConfigData) {
                com.kwad.sdk.core.d.b.d(a.this.getTag(), "init onConfigRefresh  isSuccessLoaded:" + zI);
                if (!a.this.ob() || zI) {
                    return;
                }
                a.this.al(context);
            }

            @Override // com.kwad.components.core.n.e.a
            public final void oi() {
                com.kwad.sdk.core.d.b.d(a.this.getTag(), "init onCacheLoaded  isSuccessLoaded:" + zI);
                if (!a.this.ob() || zI) {
                    a.this.al(context);
                }
            }
        });
    }

    public boolean isEnabled() {
        return true;
    }

    protected boolean ob() {
        return true;
    }

    protected abstract String od();

    protected abstract String oe();

    protected abstract String of();

    protected abstract String og();

    protected abstract String oh();
}
