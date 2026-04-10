package ms.bz.bd.c.Pgl;

import android.content.Context;
import com.google.common.base.Ascii;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: classes9.dex */
public class j1 {
    private static final String e;

    static {
        e = (String) pblk.a(16777217, 0, 0L, "8ca462", new byte[]{Base64.padSymbol, 117, 45, 78, Ascii.CR});
    }

    public static synchronized String e(Context context) {
        String strE;
        String str;
        String string;
        String strE2;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getFilesDir().getAbsolutePath());
            sb.append((String) pblk.a(16777217, 0, 0L, "67ee0c", new byte[]{104}));
            str = e;
            sb.append(str);
            string = sb.toString();
        } catch (Throwable unused) {
            strE = (String) pblk.a(16777217, 0, 0L, "73d449", new byte[]{118, 10, 75, 1, 85, 19, 17, 42, Ascii.SYN, 65, Ascii.SYN, 5, 62, 111, 37, Ascii.NAK, 104, 83, 107, 89});
        }
        if (new File(string).exists() && (strE2 = e(string)) != null && strE2.length() > 0) {
            return strE2;
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
        StringBuilder sb2 = new StringBuilder();
        sb2.append((String) pblk.a(16777217, 0, 0L, "3a2709", new byte[]{33, 107, 76, 76, Ascii.VT, 110, 103, Ascii.ETB, 52, 39}));
        sb2.append(string);
        e(sb2.toString());
        strE = e(string);
        if (strE != null && strE.length() != 0) {
            if (strE != null) {
            }
            strE = (String) pblk.a(16777217, 0, 0L, "5586f4", new byte[]{116, Ascii.FF, Ascii.ETB, 3, 7, Ascii.RS, 19, 38, 91, 73, Ascii.SYN, Ascii.FF, Ascii.ETB, 3, 7, Ascii.RS});
            return strE;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(string, (String) pblk.a(16777217, 0, 0L, "f87fb6", new byte[]{101, 45}));
        randomAccessFile.seek(16L);
        randomAccessFile.write(new byte[]{2});
        randomAccessFile.close();
        strE = e(string);
        if (strE != null || strE.length() == 0) {
            strE = (String) pblk.a(16777217, 0, 0L, "5586f4", new byte[]{116, Ascii.FF, Ascii.ETB, 3, 7, Ascii.RS, 19, 38, 91, 73, Ascii.SYN, Ascii.FF, Ascii.ETB, 3, 7, Ascii.RS});
        }
        return strE;
    }

    private static String e(BufferedInputStream bufferedInputStream) {
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
            }
        } while (i >= 4096);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x010a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String e(java.lang.String r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bz.bd.c.Pgl.j1.e(java.lang.String):java.lang.String");
    }
}
