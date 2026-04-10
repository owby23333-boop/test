package q;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static String a(String str) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(str);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = fileInputStream.read(bArr);
                if (i2 == -1) {
                    String str2 = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    fileInputStream.close();
                    return str2;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
