package com.kwad.library.solder.lib;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
final class c implements com.kwad.library.solder.lib.a.b {
    private final File aqn;
    private final File aqo;
    private final com.kwad.library.solder.lib.ext.c aqp;
    private final Context mContext;

    c(Context context, com.kwad.library.solder.lib.ext.c cVar) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.aqp = cVar;
        this.aqn = applicationContext.getDir(cVar.Ao(), 0);
        this.aqo = applicationContext.getCacheDir();
    }

    private boolean i(String str, String str2, boolean z) {
        if (!w.gR(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str2) || TextUtils.equals(str2, al.getFileMD5Digest(str))) {
            return true;
        }
        delete(str);
        return false;
    }

    private static void delete(String str) {
        w.delete(str);
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final void bN(String str) {
        File file = new File(bO(str));
        if (file.exists()) {
            w.T(file);
        }
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final void E(String str, String str2) {
        File file = new File(F(str, str2));
        if (file.exists()) {
            w.T(file);
        }
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final void zK() throws IOException {
        if (this.aqn.getFreeSpace() < 10000000) {
            throw new IOException("No enough capacity.");
        }
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final File e(String str, boolean z) {
        String md5;
        if (str == null || (md5 = com.kwad.library.solder.lib.d.b.getMD5(str)) == null) {
            return null;
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append(md5);
            if (this.aqp.As() != null) {
                sb.append(this.aqp.As());
            }
            File file = new File(this.aqo, sb.toString());
            if (file.exists() || file.createNewFile()) {
                return file;
            }
            return null;
        }
        return File.createTempFile(md5 + System.currentTimeMillis(), this.aqp.As(), this.aqo);
    }

    private String zL() {
        return this.aqn.getAbsolutePath();
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final String bO(String str) {
        return zL() + File.separator + str;
    }

    private String F(String str, String str2) {
        return zL() + File.separator + str + File.separator + str2;
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final String G(String str, String str2) {
        return zL() + File.separator + str + File.separator + str2 + File.separator + this.aqp.At();
    }

    private String a(com.kwad.library.solder.lib.a.a aVar) {
        return G(aVar.getId(), aVar.getVersion());
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final boolean a(String str, String str2, String str3) {
        if (this.aqp.Au()) {
            return false;
        }
        return i(G(str, str2), str3, true);
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final String b(com.kwad.library.solder.lib.a.a aVar) throws PluginError.InstallError {
        String strA = a(aVar);
        if (TextUtils.isEmpty(strA)) {
            throw new PluginError.InstallError("Can not get install path.", PluginError.ERROR_INS_INSTALL_PATH);
        }
        aVar.getId();
        File file = new File(strA);
        if (file.exists() && !this.aqp.Au() && i(file.getAbsolutePath(), aVar.zY(), true)) {
            return strA;
        }
        String strZX = aVar.zX();
        aVar.getId();
        File file2 = new File(strZX);
        if (!file2.exists()) {
            throw new PluginError.InstallError("Plugin file not exist.", 3001);
        }
        aVar.getId();
        if (!i(strZX, aVar.zY(), true)) {
            aVar.zY();
            throw new PluginError.InstallError("check plugin md5 fail:" + aVar.zY() + " " + strZX, 3003);
        }
        if (file2.renameTo(file)) {
            aVar.getId();
            return strA;
        }
        try {
            zK();
            try {
                w.f(file2, file);
                w.T(file2);
                return strA;
            } catch (Throwable th) {
                a.e("PluginInstallerImpl", th);
                throw new PluginError.InstallError(th, 3004);
            }
        } catch (Throwable th2) {
            a.e("PluginInstallerImpl", th2);
            throw new PluginError.InstallError(th2, 3005);
        }
    }
}
