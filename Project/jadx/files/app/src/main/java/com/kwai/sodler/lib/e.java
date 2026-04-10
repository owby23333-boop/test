package com.kwai.sodler.lib;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.p;
import com.kwai.sodler.lib.a.g;
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
final class e implements com.kwai.sodler.lib.a.g {
    private g.a aIs;
    private final Context mContext;

    e(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @TargetApi(11)
    private void a(int i2, @NonNull com.kwai.sodler.lib.a.f fVar) {
        if (i2 == 0) {
            com.kwai.sodler.lib.c.b bVarK = f.k(fVar);
            if (bVarK != null) {
                StringBuilder sb = new StringBuilder("Download new plugin, version = ");
                sb.append(bVarK.version);
                sb.append(", url = ");
                sb.append(bVarK.aJz);
                fVar.dg(3);
                fVar.fF(bVarK.aJz);
                fVar.as(bVarK.aJA);
                fVar.fE(bVarK.aJB);
                fVar.fy(bVarK.version);
                return;
            }
        } else if (i2 != -1) {
            return;
        }
        fVar.dg(-3);
    }

    private static void a(com.kwai.sodler.lib.a.f fVar) {
        new StringBuilder("onCanceled state = ").append(fVar.getState());
        fVar.dg(-7);
        fVar.Jo().Jg().o(fVar);
    }

    private void a(com.kwai.sodler.lib.a.f fVar, PluginError.UpdateError updateError) {
        new StringBuilder("onError state = ").append(fVar.getState());
        fVar.dg(-4);
        fVar.o(updateError);
        fVar.JD();
        b(fVar);
    }

    private void a(com.kwai.sodler.lib.a.f fVar, File file) throws PluginError.UpdateError {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = "start download:" + fVar.getId();
        g.a aVar = this.aIs;
        if (aVar == null) {
            throw new PluginError.UpdateError("update ", PluginError.ERROR_UPD_NO_DOWNLOADER);
        }
        aVar.a(fVar, file);
        String str2 = "finish download:" + fVar.getId() + " cost:" + (System.currentTimeMillis() - jCurrentTimeMillis);
    }

    private static void b(com.kwai.sodler.lib.a.f fVar) {
        new StringBuilder("onPostUpdate state = ").append(fVar.getState());
        fVar.Jo().Jg().q(fVar);
    }

    private static void c(com.kwai.sodler.lib.a.f fVar) {
        new StringBuilder("onPreUpdate state = ").append(fVar.getState());
        fVar.Jo().Jg().p(fVar);
    }

    private com.kwai.sodler.lib.a.f j(com.kwai.sodler.lib.a.f fVar) {
        if (fVar.Js()) {
            fVar.Jo().Je().ft(fVar.getId());
        }
        try {
        } catch (Exception e2) {
            a.w("Sodler.update", "Request remote plugin info fail, error = " + e2.toString());
            a.e("Sodler.update", e2);
            fVar.dg(-2);
            fVar.o(new PluginError.UpdateError(e2, PluginError.ERROR_UPD_REQUEST));
        }
        if (fVar.Jx()) {
            com.kwai.sodler.lib.c.b bVarK = f.k(fVar);
            fVar.dg(2);
            fVar.fy(bVarK.version);
            return fVar;
        }
        if (!fVar.Jx() && fVar.JB() == null) {
            fVar.Jo().Jf().e(fVar);
        }
        if (TextUtils.isEmpty(fVar.getId())) {
            a(-1, fVar);
            return fVar;
        }
        a(0, fVar);
        return fVar;
    }

    @Override // com.kwai.sodler.lib.a.g
    public final com.kwai.sodler.lib.a.g a(g.a aVar) {
        this.aIs = aVar;
        return this;
    }

    @Override // com.kwai.sodler.lib.a.g
    public final com.kwai.sodler.lib.a.f i(@NonNull com.kwai.sodler.lib.a.f fVar) {
        new StringBuilder("Start update, id = ").append(fVar.getId());
        fVar.fB("Update");
        c(fVar);
        j(fVar);
        if (fVar.isCanceled()) {
            a(fVar);
            return fVar;
        }
        if (fVar.getState() == 2) {
            try {
                fVar.Jo().Je().IX();
                try {
                    File fileH = fVar.Jo().Je().h(fVar.Jy(), false);
                    if (fVar.isCanceled()) {
                        a(fVar);
                        return fVar;
                    }
                    try {
                        p.a(this.mContext, fVar.Jy(), fileH);
                        fVar.fC(fileH.getAbsolutePath());
                        fVar.dg(1);
                        b(fVar);
                        return fVar;
                    } catch (Throwable th) {
                        a.e("Sodler.update", th);
                        a(fVar, new PluginError.UpdateError(th, PluginError.ERROR_UPD_EXTRACT));
                        return fVar;
                    }
                } catch (Throwable th2) {
                    new StringBuilder("Can not get temp file, error = ").append(th2.getLocalizedMessage());
                    a.e("Sodler.update", th2);
                    a(fVar, new PluginError.UpdateError(th2, 2003));
                    return fVar;
                }
            } catch (Throwable th3) {
                a.e("Sodler.update", th3);
                a(fVar, new PluginError.UpdateError(th3, PluginError.ERROR_UPD_CAPACITY));
                return fVar;
            }
        }
        if (fVar.getState() != 3) {
            b(fVar);
            return fVar;
        }
        try {
            fVar.Jo().Je().IX();
            try {
                File fileH2 = fVar.Jo().Je().h(fVar.getDownloadUrl(), fVar.Jo().Jb().JL());
                if (fVar.Jz() != null && fileH2.exists() && TextUtils.equals(ac.W(fileH2), fVar.Jz())) {
                    fVar.fC(fileH2.getAbsolutePath());
                    fVar.dg(1);
                    b(fVar);
                    return fVar;
                }
                try {
                    a(fVar, fileH2);
                    fVar.fC(fileH2.getAbsolutePath());
                    fVar.dg(1);
                    b(fVar);
                    return fVar;
                } catch (PluginError.CancelError unused) {
                    a(fVar);
                    return fVar;
                } catch (PluginError.UpdateError e2) {
                    new StringBuilder("Download plugin fail, error = ").append(e2.getLocalizedMessage());
                    a.e("Sodler.update", e2);
                    fVar.o(e2);
                    a(fVar, e2);
                    return fVar;
                }
            } catch (Throwable th4) {
                new StringBuilder("Can not get temp file, error = ").append(th4.getLocalizedMessage());
                a.e("Sodler.update", th4);
                a(fVar, new PluginError.UpdateError(th4, 2003));
                return fVar;
            }
        } catch (Throwable th5) {
            a.e("Sodler.update", th5);
            a(fVar, new PluginError.UpdateError(th5, PluginError.ERROR_UPD_CAPACITY));
            return fVar;
        }
    }
}
