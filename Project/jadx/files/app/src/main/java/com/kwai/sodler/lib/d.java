package com.kwai.sodler.lib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.p;
import com.kwai.sodler.lib.ext.PluginError;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
final class d implements com.kwai.sodler.lib.a.d {
    private final ConcurrentHashMap<String, com.kwai.sodler.lib.a.a> aIr = new ConcurrentHashMap<>();
    private final Context mContext;

    d(Context context) {
        this.mContext = context.getApplicationContext();
        try {
            ClassLoader classLoader = context.getClassLoader();
            if (classLoader instanceof BaseDexClassLoader) {
                com.kwai.sodler.lib.kwai.kwai.a.a((BaseDexClassLoader) classLoader);
            }
        } catch (Exception e2) {
            a.e("Sodler.loader", "DvaPathClassLoader.inject failed", e2);
        }
    }

    private static void a(com.kwai.sodler.lib.a.f fVar) {
        new StringBuilder("onCanceled state = ").append(fVar.getState());
        fVar.dg(-7);
        fVar.Jo().Jg().o(fVar);
    }

    private com.kwai.sodler.lib.a.a b(com.kwai.sodler.lib.a.f fVar, com.kwai.sodler.lib.a.a aVar) throws PluginError.LoadError {
        String strJl = aVar.Jl();
        File file = new File(strJl);
        new StringBuilder("Loading plugin, path = ").append(strJl);
        com.kwai.sodler.lib.a.e eVarJo = fVar.Jo();
        if (!file.exists()) {
            throw new PluginError.LoadError("Apk file not exist.", 3001);
        }
        String id = fVar.getId();
        String version = fVar.getVersion();
        com.kwai.sodler.lib.a.a aVarFv = fv(id);
        if (aVarFv != null) {
            new StringBuilder("The current plugin has been loaded, id = ").append(version);
            return aVarFv;
        }
        aVar.fz(id);
        aVar.fy(version);
        if (eVarJo.Je().as(id, version)) {
            String strAr = eVarJo.Je().ar(id, version);
            if (p.ed(strAr)) {
                aVar.fA(strAr);
                aVar.av(this.mContext, strAr);
                b(id, aVar);
                return aVar;
            }
        }
        String strB = eVarJo.Je().b(aVar);
        aVar.fA(strB);
        new StringBuilder("installed .").append(strB);
        aVar.av(this.mContext, strB);
        b(id, aVar);
        if (strJl.endsWith(eVarJo.Jb().JI())) {
            p.delete(strJl);
        }
        return aVar;
    }

    private void b(com.kwai.sodler.lib.a.f fVar, PluginError pluginError) {
        new StringBuilder("onError state = ").append(fVar.getState());
        fVar.dg(-5);
        fVar.o(pluginError);
        h(fVar);
    }

    private synchronized void b(String str, com.kwai.sodler.lib.a.a aVar) {
        if (aVar != null) {
            if (aVar.isLoaded()) {
                this.aIr.put(str, aVar);
            }
        }
    }

    private static void g(com.kwai.sodler.lib.a.f fVar) {
        new StringBuilder("onPreLoad state = ").append(fVar.getState());
        fVar.Jo().Jg();
    }

    private static void h(com.kwai.sodler.lib.a.f fVar) {
        PluginError loadError;
        new StringBuilder("onPostLoad state = ").append(fVar.getState());
        if (fVar.getState() == 0) {
            com.kwai.sodler.lib.a.a aVarJv = fVar.Jv();
            if (aVarJv != null) {
                fVar.Jo().Jg().c(fVar, aVarJv);
                return;
            }
            fVar.dg(-1);
        }
        if (fVar.Jq() != null) {
            loadError = fVar.Jq() instanceof PluginError ? (PluginError) fVar.Jq() : new PluginError.LoadError(fVar.Jq(), 4011);
        } else {
            loadError = new PluginError.LoadError("Can not get plugin instance " + fVar.getState(), 4011);
        }
        fVar.Jo().Jg().c(fVar, loadError);
    }

    @Override // com.kwai.sodler.lib.a.d
    public final com.kwai.sodler.lib.a.f f(@NonNull com.kwai.sodler.lib.a.f fVar) {
        new StringBuilder("Loading plugin, id = ").append(fVar.getId());
        fVar.fB("Load");
        g(fVar);
        if (fVar.isCanceled()) {
            a(fVar);
            return fVar;
        }
        fVar.JC();
        com.kwai.sodler.lib.a.a aVar = this.aIr.get(fVar.getId());
        if (aVar != null && aVar.isLoaded()) {
            fVar.c(aVar);
            new StringBuilder("Load plugin success, path = ").append(aVar.Jl());
            fVar.dg(0);
            h(fVar);
            return fVar;
        }
        List<com.kwai.sodler.lib.c.a> listJA = fVar.JA();
        com.kwai.sodler.lib.c.b bVarK = f.k(fVar);
        if (bVarK == null) {
            fVar.dg(-1);
            h(fVar);
            return fVar;
        }
        com.kwai.sodler.lib.c.a aVar2 = null;
        if (listJA != null && !listJA.isEmpty()) {
            for (com.kwai.sodler.lib.c.a aVar3 : listJA) {
                if (bVarK.version.equals(aVar3.version)) {
                    aVar2 = aVar3;
                } else {
                    fVar.Jo().Je().ap(fVar.getId(), aVar3.version);
                }
            }
        }
        if (aVar2 != null) {
            String strAr = fVar.Jo().Je().ar(aVar2.aJy, aVar2.version);
            new StringBuilder("-------本地已存在--------").append(strAr);
            fVar.fC(strAr);
            fVar.fD(strAr);
            fVar.dg(1);
            fVar.fy(aVar2.version);
        } else {
            if (!af.isWifiConnected(this.mContext) && (bVarK.aJC || (bVarK.aJD && fVar.Jt() > 0))) {
                b(fVar, new PluginError.NotWifiDownloadError("It can be downloaded only on WiFi", PluginError.ERROR_UPD_NOT_WIFI_DOWNLOAD));
                return fVar;
            }
            fVar.Jo().Jd().i(fVar);
        }
        if (fVar.getState() != 1) {
            h(fVar);
            return fVar;
        }
        String strJu = fVar.Ju();
        new StringBuilder("-------更新成功或者获取到本地成功------------").append(strJu);
        if (TextUtils.isEmpty(strJu)) {
            fVar.dg(-1);
            h(fVar);
            return fVar;
        }
        com.kwai.sodler.lib.a.a aVarA = fVar.fG(strJu).a(bVarK);
        if (fVar.isCanceled()) {
            a(fVar);
            return fVar;
        }
        try {
            fVar.c(b(fVar, aVarA));
            new StringBuilder("Load plugin success, path = ").append(strJu);
            fVar.dg(0);
            h(fVar);
            return fVar;
        } catch (PluginError.InstallError e2) {
            e = e2;
            b(fVar, e);
            return fVar;
        } catch (PluginError.LoadError e3) {
            e = e3;
            b(fVar, e);
            return fVar;
        } catch (Throwable th) {
            a.e("Sodler.loader", "Load plugin failed, path = " + strJu, th);
            b(fVar, new PluginError.InstallError("Load or install plugin failed", 4004));
            return fVar;
        }
    }

    @Override // com.kwai.sodler.lib.a.d
    public final synchronized com.kwai.sodler.lib.a.a fv(String str) {
        com.kwai.sodler.lib.a.a aVar = this.aIr.get(str);
        if (aVar != null) {
            if (!aVar.isLoaded()) {
                return null;
            }
        }
        return aVar;
    }
}
