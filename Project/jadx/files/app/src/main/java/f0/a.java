package f0;

import android.text.TextUtils;
import android.util.Base64;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Iterator;
import javax.crypto.Cipher;

/* JADX INFO: compiled from: C0048b.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static final byte[] a = "#PART#".getBytes();

    public static String a(String str) throws GeneralSecurityException {
        byte[] bArrA;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] bytes = str.getBytes();
        int i2 = 0;
        byte[] bArrDecode = Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC6ZetPcgLCvLsvDWzA3TYpRhEO\nfncquhfl9utVX+VApfrknKvYInYzmxjhdAEay+Nn6NPJKGPkCt1D7VWbf0YPiLmo\noCTIsuc7czZOu9pBJYjOrqCZhhJsJucc3+T/un8KioD2CjkXy0EhNMJSuvo+tHJg\nTbiR4QuPcIU1YBLX4wIDAQAB".getBytes(), 0);
        int length = bytes.length;
        if (length <= 117) {
            bArrA = a(bytes, bArrDecode);
        } else {
            ArrayList arrayList = new ArrayList(2048);
            byte[] bArr = new byte[117];
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < length) {
                bArr[i4] = bytes[i3];
                i4++;
                if (i4 == 117 || i3 == length - 1) {
                    i5++;
                    if (i5 != 1) {
                        for (byte b : a) {
                            arrayList.add(Byte.valueOf(b));
                        }
                    }
                    for (byte b2 : a(bArr, bArrDecode)) {
                        arrayList.add(Byte.valueOf(b2));
                    }
                    bArr = i3 == length + (-1) ? null : new byte[Math.min(117, (length - i3) - 1)];
                    i4 = 0;
                }
                i3++;
            }
            bArrA = new byte[arrayList.size()];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                bArrA[i2] = ((Byte) it.next()).byteValue();
                i2++;
            }
        }
        return new String(Base64.encode(bArrA, 2));
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr2));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, publicKeyGeneratePublic);
        return cipher.doFinal(bArr);
    }
}
