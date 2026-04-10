package com.kwai.sodler.lib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.p;
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
final class c implements com.kwai.sodler.lib.a.c {
    private final File aIo;
    private final File aIp;
    private final com.kwai.sodler.lib.ext.c aIq;
    private final Context mContext;

    c(Context context, com.kwai.sodler.lib.ext.c cVar) {
        this.mContext = context.getApplicationContext();
        this.aIq = cVar;
        this.aIo = this.mContext.getDir(this.aIq.JE(), 0);
        this.aIp = this.mContext.getCacheDir();
    }

    private String IY() {
        return this.aIo.getAbsolutePath();
    }

    @Nullable
    private String a(com.kwai.sodler.lib.a.a aVar) {
        return ar(aVar.getId(), aVar.getVersion());
    }

    private static boolean a(String str, com.kwai.sodler.lib.a.a aVar) {
        if (!p.ee(str)) {
            a.w("Sodler.installer", "Plugin not found, path = " + str);
            return false;
        }
        if (aVar != null && !TextUtils.isEmpty(aVar.Jm()) && !TextUtils.equals(ac.W(new File(str)), aVar.Jm())) {
            return false;
        }
        new StringBuilder("Check plugin's signatures success, path = ").append(str);
        return true;
    }

    private boolean a(String str, com.kwai.sodler.lib.a.a aVar, boolean z2) {
        if (a(str, aVar)) {
            return true;
        }
        delete(str);
        return false;
    }

    private void ao(String str, String str2) {
        p.delete(ar(str, str2));
    }

    private String aq(String str, String str2) {
        return IY() + File.separator + str + File.separator + str2;
    }

    private static void delete(String str) {
        p.delete(str);
    }

    private boolean m(String str, String str2, boolean z2) {
        if (a(ar(str, str2), null)) {
            return true;
        }
        ao(str, str2);
        return false;
    }

    @Override // com.kwai.sodler.lib.a.c
    public final void IX() throws IOException {
        if (this.aIo.getFreeSpace() < 10000000) {
            throw new IOException("No enough capacity.");
        }
    }

    @Override // com.kwai.sodler.lib.a.c
    public final void ap(String str, String str2) {
        File file = new File(aq(str, str2));
        if (file.exists()) {
            p.M(file);
        }
    }

    @Override // com.kwai.sodler.lib.a.c
    public final String ar(String str, String str2) {
        return IY() + File.separator + str + File.separator + str2 + File.separator + this.aIq.JJ();
    }

    @Override // com.kwai.sodler.lib.a.c
    public final boolean as(String str, String str2) {
        if (this.aIq.JK()) {
            return false;
        }
        return m(str, str2, true);
    }

    @Override // com.kwai.sodler.lib.a.c
    public final String b(com.kwai.sodler.lib.a.a aVar) throws PluginError.InstallError {
        String strA = a(aVar);
        if (TextUtils.isEmpty(strA)) {
            throw new PluginError.InstallError("Can not get install path.", PluginError.ERROR_INS_INSTALL_PATH);
        }
        new StringBuilder("Install path = ").append(strA);
        File file = new File(strA);
        if (file.exists() && !this.aIq.JK() && a(file.getAbsolutePath(), aVar, true)) {
            return strA;
        }
        String strJl = aVar.Jl();
        new StringBuilder("Install plugin, path = ").append(strJl);
        File file2 = new File(strJl);
        if (!file2.exists()) {
            a.w("Sodler.installer", "Plugin path not exist");
            throw new PluginError.InstallError("Plugin file not exist.", 3001);
        }
        if (!a(strJl, aVar, true)) {
            a.w("Sodler.installer", "Check plugin's signatures fail.");
            throw new PluginError.InstallError("Check plugin's signatures fail.", 3003);
        }
        StringBuilder sb = new StringBuilder("Install plugin, from = ");
        sb.append(strJl);
        sb.append(", to = ");
        sb.append(strA);
        if (file2.renameTo(file)) {
            return strA;
        }
        try {
            IX();
            try {
                p.d(file2, file);
                p.M(file2);
                return strA;
            } catch (Throwable th) {
                a.e("Sodler.installer", th);
                throw new PluginError.InstallError(th, 3004);
            }
        } catch (Throwable th2) {
            a.e("Sodler.installer", th2);
            throw new PluginError.InstallError(th2, 3005);
        }
    }

    @Override // com.kwai.sodler.lib.a.c
    public final void ft(String str) {
        File file = new File(fu(str));
        if (file.exists()) {
            p.M(file);
        }
    }

    @Override // com.kwai.sodler.lib.a.c
    public final String fu(@NonNull String str) {
        return IY() + File.separator + str;
    }

    @Override // com.kwai.sodler.lib.a.c
    public final File h(String str, boolean z2) {
        String md5;
        if (str == null || (md5 = com.kwai.sodler.lib.d.b.getMD5(str)) == null) {
            return null;
        }
        if (!z2) {
            return File.createTempFile(md5 + System.currentTimeMillis(), this.aIq.JI(), this.aIp);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(md5);
        if (this.aIq.JI() != null) {
            sb.append(this.aIq.JI());
        }
        File file = new File(this.aIp, sb.toString());
        if (file.exists() || file.createNewFile()) {
            return file;
        }
        return null;
    }
}
