package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import java.net.Proxy;

/* JADX INFO: loaded from: classes.dex */
public final class i {
    public static String a(s sVar) {
        String strC = sVar.c();
        String strE = sVar.e();
        if (strE == null) {
            return strC;
        }
        return strC + '?' + strE;
    }

    public static String a(y yVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(yVar.e());
        sb.append(' ');
        boolean zB = b(yVar, type);
        s sVarG = yVar.g();
        if (zB) {
            sb.append(sVarG);
        } else {
            sb.append(a(sVarG));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean b(y yVar, Proxy.Type type) {
        return !yVar.d() && type == Proxy.Type.HTTP;
    }
}
