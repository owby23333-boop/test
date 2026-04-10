package com.bytedance.pangle.gz;

import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    public static boolean z(String str, String str2, StringBuilder sb) throws Throwable {
        pf pfVarZ;
        if (TextUtils.isEmpty(str)) {
            sb.append("apkPath null");
            return false;
        }
        try {
            if (com.bytedance.pangle.util.fo.z()) {
                pfVarZ = a.z(str, 1);
            } else {
                pfVarZ = z.z(str, true);
            }
            Signature[] signatureArr = pfVarZ != null ? pfVarZ.g : null;
            String str3 = Zeus.getPlugin(str2).mSignature;
            byte[] bArrDecode = Base64.decode(str3, 0);
            if (bArrDecode == null || bArrDecode.length == 0) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify get hostSignature error : ".concat(String.valueOf(str)));
                sb.append("hostSignature null ");
                if (TextUtils.isEmpty(str3)) {
                    sb.append("origin sign is null");
                }
                return false;
            }
            int length = 0;
            for (Signature signature : signatureArr) {
                length += signature.toByteArray().length;
            }
            byte[] bArr = new byte[length];
            int length2 = 0;
            for (Signature signature2 : signatureArr) {
                System.arraycopy(signature2.toByteArray(), 0, bArr, length2, signature2.toByteArray().length);
                length2 += signature2.toByteArray().length;
            }
            boolean z = pf.z(bArr, bArrDecode);
            if (!z) {
                sb.append("signature error");
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify verify plugin signature error : ".concat(String.valueOf(str)));
            }
            return z;
        } catch (p e) {
            sb.append("verify e");
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify verify plugin signature error : ".concat(String.valueOf(str)), e);
            return false;
        }
    }
}
