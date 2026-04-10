package com.kwai.sodler.lib;

import android.content.Context;
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class g extends com.kwai.sodler.lib.a.a {
    public g(String str) {
        super(str);
    }

    private static void ad(File file) throws PluginError.LoadError {
        if (!file.exists()) {
            a.w("Sodler.simple.package", "Apk file not exist.");
            throw new PluginError.LoadError("Apk file not exist.", 4001);
        }
        if (file.getAbsolutePath().trim().startsWith("/data/")) {
            return;
        }
        a.w("Sodler.simple.package", "Apk file seems to locate in external path (not executable), path = " + file.getAbsolutePath());
    }

    @Override // com.kwai.sodler.lib.a.a
    public void at(Context context, String str) throws PluginError.LoadError {
        ad(new File(str));
    }
}
