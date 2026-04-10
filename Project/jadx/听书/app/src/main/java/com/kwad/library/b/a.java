package com.kwad.library.b;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import com.kwad.library.b.a.b;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.h;
import com.kwad.sdk.utils.w;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends h {
    private b apS;
    private Resources apT;

    public a(String str) {
        super(str);
    }

    public final b zI() {
        return this.apS;
    }

    public final Resources getResources() {
        return this.apT;
    }

    @Override // com.kwad.library.solder.lib.h, com.kwad.library.solder.lib.g, com.kwad.library.solder.lib.a.a
    public final void i(Context context, String str) throws PluginError.LoadError {
        super.i(context, str);
        File file = new File(str);
        try {
            File fileD = d(file);
            try {
                if (Build.VERSION.SDK_INT >= 34 && context != null && context.getApplicationInfo().targetSdkVersion >= 34) {
                    file.setReadOnly();
                    fileD.setReadOnly();
                }
            } catch (Throwable unused) {
            }
            this.apS = a(fileD, file);
            try {
                this.apT = com.kwad.library.b.b.a.a(context, context.getResources(), str);
                new StringBuilder("Install plugin mClassLoader: ").append(this.apS).append(", mResources: ").append(this.apT);
            } catch (Exception e) {
                Log.getStackTraceString(e);
                throw new PluginError.LoadError(e, 4006);
            }
        } catch (IOException e2) {
            throw new PluginError.LoadError(e2, 4002);
        }
    }

    private File d(File file) throws IOException {
        File file2 = new File(file.getParentFile(), this.aqp.Ap());
        w.Y(file2);
        return file2;
    }

    private b a(File file, File file2) {
        return new b(new com.kwad.library.b.a.a((BaseDexClassLoader) getClass().getClassLoader()), file2.getAbsolutePath(), file, this.aqK.getAbsolutePath(), this.aqQ.arF, this.aqQ.arE);
    }
}
