package me.jessyan.art.f;

import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.zip.DataFormatException;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: ZipHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class k {
    public static byte[] a(byte[] bArr) {
        byte[] bArr2;
        Inflater inflater = new Inflater();
        int length = bArr.length;
        inflater.setInput(bArr, 0, length);
        ArrayList arrayList = new ArrayList();
        while (true) {
            bArr2 = null;
            try {
                if (inflater.needsInput()) {
                    break;
                }
                byte[] bArr3 = new byte[length];
                int iInflate = inflater.inflate(bArr3);
                for (int i2 = 0; i2 < iInflate; i2++) {
                    arrayList.add(Byte.valueOf(bArr3[i2]));
                }
            } catch (DataFormatException e2) {
                e2.printStackTrace();
            }
            inflater.end();
            return bArr2;
        }
        bArr2 = new byte[arrayList.size()];
        for (int i3 = 0; i3 < bArr2.length; i3++) {
            bArr2[i3] = ((Byte) arrayList.get(i3)).byteValue();
        }
        inflater.end();
        return bArr2;
    }

    public static String b(byte[] bArr, String str) {
        byte[] bArrA = a(bArr);
        try {
            return new String(bArrA, 0, bArrA.length, str);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v5 */
    public static String a(byte[] bArr, String str) throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        GZIPInputStream gZIPInputStream;
        int length = bArr.length;
        try {
            try {
                byteArrayInputStream = new ByteArrayInputStream(bArr);
            } catch (IOException e2) {
                e = e2;
                gZIPInputStream = null;
                byteArrayInputStream = null;
            } catch (Throwable th) {
                th = th;
                bArr = 0;
                byteArrayInputStream = null;
            }
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream, length);
            } catch (IOException e3) {
                e = e3;
                gZIPInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                bArr = 0;
                a((Closeable) bArr);
                a(byteArrayInputStream);
                throw th;
            }
            try {
                StringBuilder sb = new StringBuilder();
                byte[] bArr2 = new byte[length];
                while (true) {
                    int i2 = gZIPInputStream.read(bArr2);
                    if (i2 != -1) {
                        sb.append(new String(bArr2, 0, i2, str));
                    } else {
                        String string = sb.toString();
                        a(gZIPInputStream);
                        a(byteArrayInputStream);
                        return string;
                    }
                }
            } catch (IOException e4) {
                e = e4;
                e.printStackTrace();
                a(gZIPInputStream);
                a(byteArrayInputStream);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }
}
