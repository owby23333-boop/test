package ms.bz.bd.c.Pgl;

import android.content.Context;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import okio.Utf8;

/* JADX INFO: loaded from: classes4.dex */
public final class pblm {
    private static final String z;

    static {
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c20335", new byte[]{73, 108, 2, Ascii.EM, 49});
        z = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fdcd86", new byte[]{99, 114, 47, Ascii.RS, 3});
    }

    public static synchronized String z(Context context) {
        String strZ;
        String strZ2;
        try {
            StringBuilder sbAppend = new StringBuilder().append(com.bytedance.sdk.openadsdk.api.plugin.g.z(context).getAbsolutePath()).append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a92395", new byte[]{Utf8.REPLACEMENT_BYTE}));
            String str = z;
            String string = sbAppend.append(str).toString();
            if (new File(string).exists() && (strZ2 = z(string)) != null && strZ2.length() > 0) {
                return strZ2;
            }
            InputStream inputStreamOpen = context.getResources().getAssets().open(str);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStreamOpen.read(bArr, 0, 4096);
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
            FileOutputStream fileOutputStream = new FileOutputStream(string);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.close();
            z(((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "11bcdb", new byte[]{35, 59, Ascii.FS, Ascii.CAN, 95, 53, 101, 71, 100, 115})) + string);
            strZ = z(string);
            if (strZ == null || strZ.length() == 0) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(string, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "929bda", new byte[]{58, 39}));
                randomAccessFile.seek(16L);
                randomAccessFile.write(new byte[]{2});
                randomAccessFile.close();
                strZ = z(string);
            }
        } catch (Throwable unused) {
            strZ = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f7511c", new byte[]{39, 14, Ascii.SUB, 4, 80, 73, SignedBytes.MAX_POWER_OF_TWO, 46, 71, 68, 71, 1, 111, 106, 32, 79, 57, 87, 58, 92});
        }
        if (strZ == null || strZ.length() == 0) {
            strZ = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "64e5b8", new byte[]{119, 13, 74, 0, 3, Ascii.DC2, 16, 39, 6, 74, Ascii.NAK, 13, 74, 0, 3, Ascii.DC2});
        }
        return strZ;
    }

    private static String z(BufferedInputStream bufferedInputStream) {
        int i;
        byte[] bArr = new byte[4096];
        StringBuilder sb = new StringBuilder();
        do {
            try {
                i = bufferedInputStream.read(bArr);
                if (i > 0) {
                    sb.append(new String(bArr, 0, i));
                }
            } catch (Exception unused) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "89a04e", new byte[]{44, 50, 17});
            }
        } while (i >= 4096);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String z(java.lang.String r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bz.bd.c.Pgl.pblm.z(java.lang.String):java.lang.String");
    }
}
