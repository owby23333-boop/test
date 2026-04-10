package ms.bz.bd.c.Pgl;

import android.content.res.AssetManager;
import com.google.common.base.Ascii;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import ms.bz.bd.c.Pgl.pblb;

/* JADX INFO: loaded from: classes9.dex */
final class pblg extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object e(int i, long j, String str, Object obj) throws Throwable {
        InputStream inputStreamOpen;
        IOException e;
        FileOutputStream fileOutputStream;
        AssetManager assets = pgla.e().bf().getAssets();
        if (!str.startsWith((String) pblk.a(16777217, 0, 0L, "c98119", new byte[]{60}))) {
            str = ((String) pblk.a(16777217, 0, 0L, "3c50fd", new byte[]{108})) + str;
        }
        String[] list = assets.list("");
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.length; i2++) {
            if (list[i2].endsWith(str)) {
                String str2 = list[i2];
                String absolutePath = File.createTempFile((String) pblk.a(16777217, 0, 0L, "e62926", new byte[]{121, 39, 68, 85, Ascii.EM}), "").getAbsolutePath();
                FileOutputStream fileOutputStream2 = null;
                try {
                    inputStreamOpen = assets.open(str2);
                } catch (IOException e2) {
                    e = e2;
                    inputStreamOpen = null;
                } catch (Throwable th) {
                    th = th;
                    inputStreamOpen = null;
                }
                try {
                    try {
                        fileOutputStream = new FileOutputStream(absolutePath);
                        try {
                            if (pbly.e(inputStreamOpen, fileOutputStream) > 0) {
                                arrayList.add(absolutePath);
                            }
                        } catch (IOException e3) {
                            e = e3;
                            fileOutputStream2 = fileOutputStream;
                            e.printStackTrace();
                            fileOutputStream = fileOutputStream2;
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream2 = fileOutputStream;
                            pbly.e(inputStreamOpen);
                            pbly.e(fileOutputStream2);
                            throw th;
                        }
                    } catch (IOException e4) {
                        e = e4;
                    }
                    pbly.e(inputStreamOpen);
                    pbly.e(fileOutputStream);
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        }
        return arrayList.toArray(new String[0]);
    }
}
