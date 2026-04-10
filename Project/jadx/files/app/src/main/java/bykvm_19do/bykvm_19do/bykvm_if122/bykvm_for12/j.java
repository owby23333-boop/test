package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12;

import android.util.Base64;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.notpluginpro.tmapcloaknotplugin;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets/notplugmapnaveinfoox111.dex
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile j f1719c;
    private Key a;
    private Cipher b;

    private j() {
        try {
            this.a = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().k(), 0)));
            this.b = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0002, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x000c. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x000f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.j a() {
        /*
            java.lang.Class<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.j> r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.j.class
        L2:
            r1 = 73
            r2 = 96
        L6:
            switch(r1) {
                case 72: goto L2b;
                case 73: goto Lc;
                case 74: goto Lf;
                default: goto L9;
            }
        L9:
            r1 = 72
            goto L6
        Lc:
            switch(r2) {
                case 94: goto L2;
                case 95: goto L2b;
                case 96: goto L2b;
                default: goto Lf;
            }
        Lf:
            switch(r2) {
                case 55: goto L13;
                case 56: goto L2;
                case 57: goto L2b;
                default: goto L12;
            }
        L12:
            goto L2
        L13:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.j r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.j.f1719c
            if (r1 != 0) goto L28
            monitor-enter(r0)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.j r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.j.f1719c     // Catch: java.lang.Throwable -> L25
            if (r1 != 0) goto L23
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.j r1 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.j     // Catch: java.lang.Throwable -> L25
            r1.<init>()     // Catch: java.lang.Throwable -> L25
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.j.f1719c = r1     // Catch: java.lang.Throwable -> L25
        L23:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L25
            goto L28
        L25:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L25
            throw r1
        L28:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.j r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.j.f1719c
            return r0
        L2b:
            r1 = 74
            r2 = 55
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.j.a():bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.j");
    }

    String a(TTBaseAd tTBaseAd) {
        return (String) tmapcloaknotplugin.obj_bytedance_call_notplugin(0, 0, this, tTBaseAd);
    }

    public String a(byte[] bArr) throws Exception {
        return (String) tmapcloaknotplugin.obj_bytedance_call_notplugin(1, 0, this, bArr);
    }
}
