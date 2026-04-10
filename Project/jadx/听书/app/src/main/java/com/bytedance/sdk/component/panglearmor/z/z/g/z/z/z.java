package com.bytedance.sdk.component.panglearmor.z.z.g.z.z;

import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.component.panglearmor.z.g.g;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static List<com.bytedance.sdk.component.panglearmor.z.g.z> z(g gVar, com.bytedance.sdk.component.panglearmor.z.z.dl.g gVar2) throws Exception {
        return z(com.bytedance.sdk.component.panglearmor.z.z.g.z.z.z(gVar, gVar2, 1896449818).z);
    }

    public static List<com.bytedance.sdk.component.panglearmor.z.g.z> z(ByteBuffer byteBuffer) {
        try {
            ByteBuffer byteBufferZ = com.bytedance.sdk.component.panglearmor.z.z.g.z.z.z(byteBuffer);
            if (!byteBufferZ.hasRemaining()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            while (byteBufferZ.hasRemaining()) {
                try {
                    arrayList.add(g(com.bytedance.sdk.component.panglearmor.z.z.g.z.z.z(byteBufferZ)));
                } catch (Exception unused) {
                    return null;
                }
            }
            return arrayList;
        } catch (Exception unused2) {
            return null;
        }
    }

    @DungeonFlag
    private static com.bytedance.sdk.component.panglearmor.z.g.z g(ByteBuffer byteBuffer) throws Exception {
        ByteBuffer byteBufferZ = com.bytedance.sdk.component.panglearmor.z.z.g.z.z.z(byteBuffer);
        byteBufferZ.get(new byte[byteBufferZ.remaining()]);
        byteBufferZ.flip();
        byteBufferZ.position(0);
        com.bytedance.sdk.component.panglearmor.z.z.g.z.z.z(byteBufferZ);
        byte[] bArrG = com.bytedance.sdk.component.panglearmor.z.z.g.z.z.g(com.bytedance.sdk.component.panglearmor.z.z.g.z.z.z(byteBufferZ));
        try {
            return new com.bytedance.sdk.component.panglearmor.z.g.z(String.valueOf(((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArrG))).getSubjectDN()), bArrG);
        } catch (Exception unused) {
            return null;
        }
    }
}
