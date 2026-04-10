package com.kwad.library.solder.lib;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.library.solder.lib.a.f;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.w;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
final class f implements com.kwad.library.solder.lib.a.f {
    private f.a aqC;
    private final Context mContext;

    f(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @Override // com.kwad.library.solder.lib.a.f
    public final boolean k(com.kwad.library.solder.lib.a.e eVar) {
        eVar.Ad();
        eVar.bV("Update");
        e(eVar);
        if (eVar.Ae()) {
            eVar.zZ().zP().bN(eVar.Ad());
        }
        if (eVar.isCanceled()) {
            f(eVar);
            return false;
        }
        try {
            eVar.zZ().zP().zK();
            if (eVar.Ai()) {
                try {
                    File fileE = eVar.zZ().zP().e(eVar.Aj(), false);
                    if (eVar.isCanceled()) {
                        f(eVar);
                        return false;
                    }
                    try {
                        w.a(this.mContext, eVar.Aj(), fileE);
                        eVar.bW(fileE.getAbsolutePath());
                        eVar.ch(3);
                        l(eVar);
                    } catch (Throwable th) {
                        a.e("PluginUpdaterImpl", th);
                        a(eVar, new PluginError.UpdateError(th, 2004));
                    }
                } catch (Throwable th2) {
                    th2.getLocalizedMessage();
                    a(eVar, new PluginError.UpdateError(th2, 2003));
                    return false;
                }
            } else {
                eVar.Ad();
                eVar.getDownloadUrl();
                try {
                    File fileE2 = eVar.zZ().zP().e(eVar.getDownloadUrl(), eVar.zZ().zM().Av());
                    if (eVar.Ak() != null && fileE2.exists() && TextUtils.equals(al.getFileMD5Digest(fileE2), eVar.Ak())) {
                        eVar.bW(fileE2.getAbsolutePath());
                        eVar.ch(4);
                        l(eVar);
                        return true;
                    }
                    try {
                        a(eVar, fileE2);
                        eVar.bW(fileE2.getAbsolutePath());
                        eVar.ch(4);
                        l(eVar);
                    } catch (PluginError.CancelError unused) {
                        f(eVar);
                        return false;
                    } catch (PluginError.UpdateError e) {
                        a.e("PluginUpdaterImpl", "Download plugin fail, error = " + e.getLocalizedMessage());
                        eVar.j(e);
                        a(eVar, e);
                        return false;
                    }
                } catch (Throwable th3) {
                    a.e("PluginUpdaterImpl", "Can not get temp file, error = " + th3.getLocalizedMessage());
                    a(eVar, new PluginError.UpdateError(th3, 2003));
                    return false;
                }
            }
            return true;
        } catch (Throwable th4) {
            a.e("PluginUpdaterImpl", th4);
            a(eVar, new PluginError.UpdateError(th4, 2005));
            return false;
        }
    }

    @Override // com.kwad.library.solder.lib.a.f
    public final com.kwad.library.solder.lib.a.f a(f.a aVar) {
        this.aqC = aVar;
        return this;
    }

    private static void e(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.zZ().zQ().o(eVar);
    }

    private static void f(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.ch(0);
        eVar.zZ().zQ().n(eVar);
    }

    private static void a(com.kwad.library.solder.lib.a.e eVar, PluginError.UpdateError updateError) {
        eVar.getState();
        eVar.ch(1);
        eVar.j(updateError);
        eVar.zZ().zQ().c(eVar, updateError);
    }

    private static void l(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.zZ().zQ().p(eVar);
    }

    private void a(com.kwad.library.solder.lib.a.e eVar, File file) throws PluginError.UpdateError {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Log.d("PluginUpdaterImpl", "start download pluginId: " + eVar.Ad());
        f.a aVar = this.aqC;
        if (aVar == null) {
            throw new PluginError.UpdateError("update ", 2008);
        }
        aVar.a(eVar, file);
        Log.i("PluginUpdaterImpl", "finish download pluginId: " + eVar.Ad() + " cost:" + (System.currentTimeMillis() - jCurrentTimeMillis));
    }
}
