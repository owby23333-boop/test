package ms.bz.bd.c.Pgl;

import android.content.Context;
import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public final class pblf {
    private static final String z = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "1f8836", new byte[]{46, 101, 5, 79, Ascii.SYN, 45});

    public static int z(Context context) {
        InputStream inputStreamOpen;
        int i;
        String string;
        ByteArrayOutputStream byteArrayOutputStream;
        int i2 = 255;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            i = 0;
            StringBuilder sbAppend = new StringBuilder().append(com.bytedance.sdk.openadsdk.api.plugin.g.z(context).getAbsolutePath()).append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "661864", new byte[]{104}));
            String str = z;
            string = sbAppend.append(str).toString();
            File file = new File(string);
            if (file.exists()) {
                i2 = 2;
                file.delete();
            }
            inputStreamOpen = context.getResources().getAssets().open(str);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            inputStreamOpen = null;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int i3 = inputStreamOpen.read(bArr, 0, 4096);
                if (i3 == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i3);
            }
            FileOutputStream fileOutputStream = new FileOutputStream(string);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.close();
            if (byteArrayOutputStream.size() <= 0) {
                i = 3;
            } else if (!new File(string).exists()) {
                i = i2;
            }
            try {
                inputStreamOpen.close();
            } catch (Throwable unused3) {
            }
            try {
                byteArrayOutputStream.close();
                return i;
            } catch (Throwable unused4) {
                return i;
            }
        } catch (Throwable unused5) {
            byteArrayOutputStream2 = byteArrayOutputStream;
            try {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "db1183", new byte[]{116, 99, 125, 66});
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (Throwable unused6) {
                    }
                }
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Throwable unused7) {
                    }
                }
                return i2;
            } finally {
            }
        }
    }
}
