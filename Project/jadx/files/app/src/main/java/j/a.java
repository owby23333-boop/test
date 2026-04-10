package j;

import android.content.Context;
import java.io.File;
import y.b;

/* JADX INFO: compiled from: Storage.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static File a(Context context, boolean z2) throws Exception {
        String absolutePath = context.getApplicationContext().getCacheDir().getAbsolutePath();
        StringBuilder sbA = b.a("download_");
        sbA.append(System.currentTimeMillis());
        sbA.append(com.anythink.china.common.a.a.f6395g);
        String string = sbA.toString();
        if (z2) {
            string = "download_cache.apk";
        }
        File file = new File(absolutePath, string);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }
}
