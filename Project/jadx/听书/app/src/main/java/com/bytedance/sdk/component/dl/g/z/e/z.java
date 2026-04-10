package com.bytedance.sdk.component.dl.g.z.e;

import android.net.ssl.SSLSockets;
import android.os.Build;
import android.util.Log;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.sdk.component.dl.g.io;
import com.bytedance.sdk.component.dl.g.z.fo.m;
import com.bytedance.sdk.component.utils.wp;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes2.dex */
class z extends gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a<Socket> f657a;
    private final a<Socket> dl;
    private final a<Socket> g;
    private final a<Socket> gc;
    private final dl m = dl.z();
    private final Class<?> z;

    z(Class<?> cls, a<Socket> aVar, a<Socket> aVar2, a<Socket> aVar3, a<Socket> aVar4) {
        this.z = cls;
        this.g = aVar;
        this.dl = aVar2;
        this.f657a = aVar3;
        this.gc = aVar4;
    }

    @Override // com.bytedance.sdk.component.dl.g.z.e.gc
    public void z(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (!com.bytedance.sdk.component.dl.g.z.dl.z(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (ClassCastException e2) {
            if (Build.VERSION.SDK_INT == 26) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause(e2);
                throw iOException;
            }
            throw e2;
        } catch (SecurityException e3) {
            IOException iOException2 = new IOException("Exception in connect");
            iOException2.initCause(e3);
            throw iOException2;
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.dl.g.z.e.gc
    public void z(SSLSocket sSLSocket, String str, List<io> list) {
        if (str != null) {
            if (Build.VERSION.SDK_INT >= 30) {
                try {
                    SSLSockets.setUseSessionTickets(sSLSocket, true);
                    SNIHostName sNIHostName = new SNIHostName(str);
                    SSLParameters sSLParameters = sSLSocket.getSSLParameters();
                    sSLParameters.setServerNames(Collections.singletonList(sNIHostName));
                    sSLSocket.setSSLParameters(sSLParameters);
                } catch (Throwable unused) {
                }
            } else {
                this.g.g(sSLSocket, Boolean.TRUE);
                this.dl.g(sSLSocket, str);
            }
        }
        a<Socket> aVar = this.gc;
        if (aVar == null || !aVar.z(sSLSocket)) {
            return;
        }
        this.gc.a(sSLSocket, g(list));
    }

    @Override // com.bytedance.sdk.component.dl.g.z.e.gc
    public String z(SSLSocket sSLSocket) {
        byte[] bArr;
        a<Socket> aVar = this.f657a;
        if (aVar == null || !aVar.z(sSLSocket) || (bArr = (byte[]) this.f657a.a(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, com.bytedance.sdk.component.dl.g.z.dl.gc);
    }

    @Override // com.bytedance.sdk.component.dl.g.z.e.gc
    public void z(int i, String str, Throwable th) {
        int iMin;
        int i2 = i != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int iIndexOf = str.indexOf(10, i3);
            if (iIndexOf == -1) {
                iIndexOf = length;
            }
            while (true) {
                iMin = Math.min(iIndexOf, i3 + 4000);
                wp.z(i2, "OkHttp", str.substring(i3, iMin));
                if (iMin >= iIndexOf) {
                    break;
                } else {
                    i3 = iMin;
                }
            }
            i3 = iMin + 1;
        }
    }

    @Override // com.bytedance.sdk.component.dl.g.z.e.gc
    public Object z(String str) {
        return this.m.z(str);
    }

    @Override // com.bytedance.sdk.component.dl.g.z.e.gc
    public void z(String str, Object obj) {
        if (this.m.z(obj)) {
            return;
        }
        z(5, str, (Throwable) null);
    }

    @Override // com.bytedance.sdk.component.dl.g.z.e.gc
    public boolean g(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return z(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.g(str);
        } catch (IllegalAccessException e) {
            e = e;
            throw com.bytedance.sdk.component.dl.g.z.dl.z("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e2) {
            e = e2;
            throw com.bytedance.sdk.component.dl.g.z.dl.z("unable to determine cleartext support", e);
        } catch (NoClassDefFoundError unused2) {
            return false;
        } catch (InvocationTargetException e3) {
            e = e3;
            throw com.bytedance.sdk.component.dl.g.z.dl.z("unable to determine cleartext support", e);
        }
    }

    private boolean z(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return g(str, cls, obj);
        }
    }

    private boolean g(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.g(str);
        }
    }

    private static boolean a() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.component.dl.g.z.e.gc
    public com.bytedance.sdk.component.dl.g.z.fo.dl z(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0128z(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.z(x509TrustManager);
        }
    }

    public static gc z() {
        Class<?> cls;
        a aVar;
        a aVar2;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            a aVar3 = new a(null, "setUseSessionTickets", Boolean.TYPE);
            a aVar4 = new a(null, "setHostname", String.class);
            if (a()) {
                a aVar5 = new a(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                aVar2 = new a(null, "setAlpnProtocols", byte[].class);
                aVar = aVar5;
            } else {
                aVar = null;
                aVar2 = null;
            }
            return new z(cls2, aVar3, aVar4, aVar, aVar2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.dl.g.z.e.gc
    public m g(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new g(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.g(x509TrustManager);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.dl.g.z.e.z$z, reason: collision with other inner class name */
    static final class C0128z extends com.bytedance.sdk.component.dl.g.z.fo.dl {
        private final Method g;
        private final Object z;

        public int hashCode() {
            return 0;
        }

        C0128z(Object obj, Method method) {
            this.z = obj;
            this.g = method;
        }

        @Override // com.bytedance.sdk.component.dl.g.z.fo.dl
        public List<Certificate> z(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.g.invoke(this.z, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C0128z;
        }
    }

    static final class dl {
        private final Method dl;
        private final Method g;
        private final Method z;

        dl(Method method, Method method2, Method method3) {
            this.z = method;
            this.g = method2;
            this.dl = method3;
        }

        Object z(String str) {
            Method method = this.z;
            if (method != null) {
                try {
                    Object objInvoke = method.invoke(null, new Object[0]);
                    this.g.invoke(objInvoke, str);
                    return objInvoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        boolean z(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.dl.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        static dl z() {
            Method method;
            Method method2;
            Method method3;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                method = cls.getMethod("get", new Class[0]);
                method3 = cls.getMethod(TtmlNode.TEXT_EMPHASIS_MARK_OPEN, String.class);
                method2 = cls.getMethod("warnIfOpen", new Class[0]);
            } catch (Exception unused) {
                method = null;
                method2 = null;
                method3 = null;
            }
            return new dl(method, method3, method2);
        }
    }

    static final class g implements m {
        private final Method g;
        private final X509TrustManager z;

        g(X509TrustManager x509TrustManager, Method method) {
            this.g = method;
            this.z = x509TrustManager;
        }

        @Override // com.bytedance.sdk.component.dl.g.z.fo.m
        public X509Certificate z(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.g.invoke(this.z, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
            } catch (IllegalAccessException e) {
                throw com.bytedance.sdk.component.dl.g.z.dl.z("unable to get issues and signature", (Exception) e);
            } catch (InvocationTargetException unused) {
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return this.z.equals(gVar.z) && this.g.equals(gVar.g);
        }

        public int hashCode() {
            return this.z.hashCode() + (this.g.hashCode() * 31);
        }
    }
}
