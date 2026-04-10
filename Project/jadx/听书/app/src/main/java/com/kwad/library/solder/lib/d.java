package com.kwad.library.solder.lib;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
final class d implements com.kwad.library.solder.lib.a.c {
    private final ConcurrentHashMap<String, com.kwad.library.solder.lib.a.a> aqq = new ConcurrentHashMap<>();
    private final Context mContext;

    d(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @Override // com.kwad.library.solder.lib.a.c
    public final void g(com.kwad.library.solder.lib.a.e eVar) {
        eVar.Ad();
        eVar.bV("Load");
        c(eVar);
        if (eVar.isCanceled()) {
            f(eVar);
            return;
        }
        com.kwad.library.solder.lib.a.a aVar = this.aqq.get(eVar.Ad());
        if (aVar != null && aVar.isLoaded()) {
            eVar.c(aVar);
            eVar.Ad();
            aVar.zX();
            a(eVar, aVar);
            return;
        }
        com.kwad.library.solder.lib.c.b bVarAl = eVar.Al();
        if (bVarAl == null) {
            b(eVar, new PluginError.LoadError("not pluginInfo", 2006));
            return;
        }
        List<com.kwad.library.solder.lib.c.a> listAm = eVar.Am();
        com.kwad.library.solder.lib.c.a aVar2 = null;
        if (listAm != null && !listAm.isEmpty()) {
            for (com.kwad.library.solder.lib.c.a aVar3 : listAm) {
                if (eVar.getVersion().equals(aVar3.version)) {
                    aVar2 = aVar3;
                } else {
                    eVar.zZ().zP().E(eVar.Ad(), aVar3.version);
                }
            }
        }
        if (aVar2 == null) {
            if (!ao.isWifiConnected(this.mContext) && (bVarAl.arB || (bVarAl.arC && eVar.Af() > 0))) {
                b(eVar, new PluginError.NotWifiDownloadError("It can be downloaded only on WiFi", 2007));
                return;
            }
            try {
                if (!eVar.zZ().zO().k(eVar)) {
                    return;
                }
            } catch (Throwable th) {
                b(eVar, new PluginError.UpdateError(th, 2006));
                return;
            }
        } else {
            String strG = eVar.zZ().zP().G(aVar2.arx, aVar2.version);
            eVar.bW(strG);
            eVar.bX(strG);
            eVar.ch(2);
            eVar.bS(aVar2.version);
        }
        if (eVar.getState() == 2 || eVar.getState() == 3 || eVar.getState() == 4) {
            String strAg = eVar.Ag();
            eVar.Ad();
            if (TextUtils.isEmpty(strAg)) {
                b(eVar, new PluginError.LoadError("path not found", PluginError.ERROR_UPD_FILE_NOT_FOUND));
                return;
            }
            if (eVar.isCanceled()) {
                f(eVar);
                return;
            }
            try {
                com.kwad.library.solder.lib.a.a aVarH = h(eVar);
                eVar.c(aVarH);
                new StringBuilder("load plugin success pluginId: ").append(eVar.Ad()).append(", path: ");
                a(eVar, aVarH);
                return;
            } catch (PluginError.InstallError e) {
                e = e;
                b(eVar, e);
                return;
            } catch (PluginError.LoadError e2) {
                e = e2;
                b(eVar, e);
                return;
            } catch (Throwable th2) {
                a.e("PluginLoaderImpl", "load plugin failed, path = " + strAg, th2);
                b(eVar, new PluginError.InstallError("load or install plugin failed:" + th2.getMessage(), 4004));
                return;
            }
        }
        b(eVar, new PluginError.InstallError("state exception", 2002));
    }

    private com.kwad.library.solder.lib.a.a h(com.kwad.library.solder.lib.a.e eVar) throws PluginError.LoadError {
        b(eVar);
        com.kwad.library.solder.lib.a.a aVarA = eVar.bY(eVar.Ag()).a(eVar.Al());
        String strZX = aVarA.zX();
        File file = new File(strZX);
        eVar.Ad();
        com.kwad.library.solder.lib.a.d dVarZZ = eVar.zZ();
        if (!file.exists()) {
            throw new PluginError.LoadError("Apk file not exist.", 3001);
        }
        String strAd = eVar.Ad();
        String version = eVar.getVersion();
        com.kwad.library.solder.lib.a.a aVarBP = bP(strAd);
        if (aVarBP != null) {
            a(eVar);
            return aVarBP;
        }
        aVarA.bT(strAd);
        aVarA.bS(version);
        if (dVarZZ.zP().a(strAd, version, eVar.Ak())) {
            String strG = dVarZZ.zP().G(strAd, version);
            if (w.gQ(strG)) {
                aVarA.bU(strG);
                aVarA.n(this.mContext, strG);
                a(strAd, aVarA);
                a(eVar);
                return aVarA;
            }
        }
        String strB = dVarZZ.zP().b(aVarA);
        aVarA.bU(strB);
        aVarA.n(this.mContext, strB);
        a(strAd, aVarA);
        if (strZX.endsWith(dVarZZ.zM().As())) {
            w.delete(strZX);
        }
        a(eVar);
        return aVarA;
    }

    @Override // com.kwad.library.solder.lib.a.c
    public final synchronized com.kwad.library.solder.lib.a.a bP(String str) {
        com.kwad.library.solder.lib.a.a aVar = this.aqq.get(str);
        if (aVar != null) {
            if (!aVar.isLoaded()) {
                return null;
            }
        }
        return aVar;
    }

    private synchronized void a(String str, com.kwad.library.solder.lib.a.a aVar) {
        if (aVar != null) {
            if (aVar.isLoaded()) {
                this.aqq.put(str, aVar);
            }
        }
    }

    private static void c(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.zZ().zQ().q(eVar);
    }

    private static void b(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.ch(7);
        eVar.zZ().zQ().r(eVar);
    }

    private static void a(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.ch(8);
        eVar.zZ().zQ().a(eVar);
    }

    private static void b(com.kwad.library.solder.lib.a.e eVar, PluginError pluginError) {
        eVar.getState();
        eVar.ch(6);
        eVar.j(pluginError);
        eVar.zZ().zQ().c(eVar, pluginError);
    }

    private static void f(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.ch(0);
        eVar.zZ().zQ().n(eVar);
    }

    private static void a(com.kwad.library.solder.lib.a.e eVar, com.kwad.library.solder.lib.a.a aVar) {
        eVar.getState();
        eVar.ch(5);
        eVar.zZ().zQ().b(eVar, aVar);
    }
}
