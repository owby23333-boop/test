package com.kwai.sodler.lib.kwai;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import com.kwad.sdk.utils.p;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.h;
import com.kwai.sodler.lib.kwai.kwai.b;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends h {
    private b aIG;
    private Resources aIH;

    public a(String str) {
        super(str);
    }

    private File af(File file) throws IOException {
        File file2 = new File(file.getParentFile(), this.aIq.JF());
        p.S(file2);
        return file2;
    }

    private b g(File file, File file2) {
        if (Build.VERSION.SDK_INT < 26) {
            if (!file.canRead()) {
                file.setReadable(true);
            }
            if (!file.canWrite()) {
                file.setWritable(true);
            }
            if (!file.canRead() || !file.canWrite()) {
                file = null;
            }
        }
        com.kwai.sodler.lib.kwai.kwai.a aVar = com.kwai.sodler.lib.kwai.kwai.a.aIJ;
        String absolutePath = file2.getAbsolutePath();
        String absolutePath2 = this.aIQ.getAbsolutePath();
        com.kwai.sodler.lib.c.b bVar = this.aIW;
        return new b(aVar, absolutePath, file, absolutePath2, bVar.aJG, bVar.aJF);
    }

    public final b Jj() {
        return this.aIG;
    }

    @Override // com.kwai.sodler.lib.h, com.kwai.sodler.lib.g, com.kwai.sodler.lib.a.a
    public final void at(Context context, String str) throws PluginError.LoadError {
        super.at(context, str);
        File file = new File(str);
        try {
            this.aIG = g(af(file), file);
            try {
                this.aIH = com.kwai.sodler.lib.kwai.a.a.a(context, context.getResources(), str);
                StringBuilder sb = new StringBuilder("Install plugin mClassLoader: ");
                sb.append(this.aIG);
                sb.append(", mResources: ");
                sb.append(this.aIH);
            } catch (Exception e2) {
                Log.getStackTraceString(e2);
                throw new PluginError.LoadError(e2, 4006);
            }
        } catch (IOException e3) {
            throw new PluginError.LoadError(e3, 4002);
        }
    }

    public final Resources getResources() {
        return this.aIH;
    }
}
