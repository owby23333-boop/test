package com.bytedance.sdk.component.panglearmor;

import android.util.Base64;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.component.utils.wp;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static boolean z;

    @DungeonFlag
    private static PublicKey z() throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKtjHB7PDkflFl5bX4x/25mE9x2/C6kd\n8wVgzXFiC67Jx+meptu1hL54XgnPnI+AvxXhEgN/+DZUmrRPdvB+UZECAwEAAQ==".getBytes(Charset.forName("UTF-8")), 2)));
    }

    @DungeonFlag
    public static boolean z(String str, String str2) throws Exception {
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(z().getEncoded()));
        Signature signature = Signature.getInstance("Sha1withRSA");
        signature.initVerify(publicKeyGeneratePublic);
        signature.update(str.getBytes());
        return signature.verify(Base64.decode(str2.getBytes(Charset.forName("UTF-8")), 2));
    }

    @DungeonFlag
    public static boolean z(final String str) {
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.component.panglearmor.a.1
                @Override // java.lang.Runnable
                public void run() {
                    String hostAddress;
                    try {
                        hostAddress = InetAddress.getByName(str).getHostAddress();
                    } catch (Exception unused) {
                        hostAddress = "";
                    }
                    if (hostAddress.equals("127.0.0.1") || hostAddress.equals("::1")) {
                        boolean unused2 = a.z = true;
                    }
                }
            });
        } catch (UnsatisfiedLinkError e) {
            wp.z(e);
        }
        return z;
    }
}
