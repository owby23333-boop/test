package com.bytedance.sdk.component.dl.g.z.e;

import com.bytedance.sdk.component.dl.g.io;
import com.bytedance.sdk.component.dl.g.z.fo.m;
import com.bytedance.sdk.component.dl.g.zw;
import com.bytedance.sdk.component.utils.wp;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    private static final gc z = z();
    private static final Logger g = Logger.getLogger(zw.class.getName());

    public String dl() {
        return "OkHttp";
    }

    public void g(SSLSocket sSLSocket) {
    }

    public boolean g(String str) {
        return true;
    }

    public String z(SSLSocket sSLSocket) {
        return null;
    }

    public void z(SSLSocket sSLSocket, String str, List<io> list) {
    }

    public static gc g() {
        return z;
    }

    public void z(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public void z(int i, String str, Throwable th) {
        g.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public Object z(String str) {
        if (g.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void z(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        z(5, str, (Throwable) obj);
    }

    public static List<String> z(List<io> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            io ioVar = list.get(i);
            if (ioVar != io.HTTP_1_0) {
                arrayList.add(ioVar.toString());
            }
        }
        return arrayList;
    }

    public com.bytedance.sdk.component.dl.g.z.fo.dl z(X509TrustManager x509TrustManager) {
        return new com.bytedance.sdk.component.dl.g.z.fo.z(g(x509TrustManager));
    }

    private static gc z() {
        gc gcVarZ = z.z();
        if (gcVarZ != null) {
            return gcVarZ;
        }
        g gVarZ = g.z();
        if (gVarZ != null) {
            return gVarZ;
        }
        gc gcVarZ2 = dl.z();
        return gcVarZ2 != null ? gcVarZ2 : new gc();
    }

    static byte[] g(List<io> list) {
        com.bytedance.sdk.component.dl.z.dl dlVar = new com.bytedance.sdk.component.dl.z.dl();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            io ioVar = list.get(i);
            if (ioVar != io.HTTP_1_0) {
                dlVar.fo(ioVar.toString().length());
                dlVar.g(ioVar.toString());
            }
        }
        try {
            return dlVar.p();
        } catch (IOException e) {
            wp.z(e);
            return null;
        }
    }

    public m g(X509TrustManager x509TrustManager) {
        return new com.bytedance.sdk.component.dl.g.z.fo.g(x509TrustManager.getAcceptedIssuers());
    }
}
