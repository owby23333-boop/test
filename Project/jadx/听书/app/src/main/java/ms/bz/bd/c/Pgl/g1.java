package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.util.Log;
import com.funny.audio.core.utils.FileUtils;
import java.io.File;
import java.util.HashSet;
import java.util.Locale;
import ms.bz.bd.c.Pgl.e1;

/* JADX INFO: loaded from: classes4.dex */
public final class g1 {
    protected final e1.pgla dl;
    protected final e1.pblb g;
    protected final HashSet z = new HashSet();

    protected g1(e1.pblb pblbVar, pbld pbldVar) {
        this.g = pblbVar;
        this.dl = pbldVar;
    }

    public final void z(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        String.format(Locale.US, "Beginning load of %s...", "Pglbizssdk_ml");
        z(context, "Pglbizssdk_ml", null);
    }

    private void z(Context context, String str, String str2) {
        File file;
        File file2;
        if (this.z.contains(str)) {
            String.format(Locale.US, "%s already loaded previously!", str);
            return;
        }
        try {
            ((s1) this.g).getClass();
            com.bytedance.sdk.openadsdk.hh.m.z(str);
            this.z.add(str);
            String.format(Locale.US, "%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e) {
            Object[] objArr = {Log.getStackTraceString(e)};
            Locale locale = Locale.US;
            String.format(locale, "Loading the library normally failed: %s", objArr);
            String.format(locale, "%s (%s) was not loaded normally, re-linking...", str, str2);
            ((s1) this.g).getClass();
            String strMapLibraryName = (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
            boolean z = true;
            if (str2 == null || str2.length() == 0) {
                file = new File(com.bytedance.sdk.openadsdk.api.plugin.g.z(context, "lib", 0), strMapLibraryName);
            } else {
                file = new File(com.bytedance.sdk.openadsdk.api.plugin.g.z(context, "lib", 0), strMapLibraryName + FileUtils.FILE_EXTENSION_SEPARATOR + str2);
            }
            File file3 = file;
            if (!file3.exists()) {
                File fileZ = com.bytedance.sdk.openadsdk.api.plugin.g.z(context, "lib", 0);
                ((s1) this.g).getClass();
                String strMapLibraryName2 = (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
                if (str2 != null && str2.length() != 0) {
                    z = false;
                }
                if (z) {
                    file2 = new File(com.bytedance.sdk.openadsdk.api.plugin.g.z(context, "lib", 0), strMapLibraryName2);
                } else {
                    file2 = new File(com.bytedance.sdk.openadsdk.api.plugin.g.z(context, "lib", 0), strMapLibraryName2 + FileUtils.FILE_EXTENSION_SEPARATOR + str2);
                }
                ((s1) this.g).getClass();
                File[] fileArrListFiles = fileZ.listFiles(new f1((str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str)));
                if (fileArrListFiles != null) {
                    for (File file4 : fileArrListFiles) {
                        if (!file4.getAbsolutePath().equals(file2.getAbsolutePath())) {
                            file4.delete();
                        }
                    }
                }
                e1.pgla pglaVar = this.dl;
                String[] strArrZ = ((s1) this.g).z();
                ((s1) this.g).getClass();
                ((pbld) pglaVar).z(context, strArrZ, (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str), file3, this);
            }
            e1.pblb pblbVar = this.g;
            String absolutePath = file3.getAbsolutePath();
            ((s1) pblbVar).getClass();
            System.load(absolutePath);
            this.z.add(str);
            String.format(Locale.US, "%s (%s) was re-linked!", str, str2);
        }
    }
}
