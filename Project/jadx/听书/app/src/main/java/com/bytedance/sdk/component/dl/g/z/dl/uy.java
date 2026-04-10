package com.bytedance.sdk.component.dl.g.z.dl;

import com.bytedance.sdk.component.dl.g.gk;
import com.bytedance.sdk.component.dl.g.h;
import com.bytedance.sdk.component.dl.g.hh;
import com.bytedance.sdk.component.dl.g.io;
import com.bytedance.sdk.component.dl.g.js;
import com.bytedance.sdk.component.dl.g.ls;
import com.bytedance.sdk.component.dl.g.sy;
import com.bytedance.sdk.component.dl.g.tb;
import com.bytedance.sdk.component.dl.g.x;
import com.bytedance.sdk.component.dl.g.zw;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class uy implements tb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f655a;
    private com.bytedance.sdk.component.dl.g.z.g.e dl;
    private final boolean g;
    private volatile boolean gc;
    private final zw z;

    public uy(zw zwVar, boolean z) {
        this.z = zwVar;
        this.g = z;
    }

    public void z() {
        this.gc = true;
        com.bytedance.sdk.component.dl.g.z.g.e eVar = this.dl;
        if (eVar != null) {
            eVar.gc();
        }
    }

    public boolean g() {
        return this.gc;
    }

    public void z(Object obj) {
        this.f655a = obj;
    }

    @Override // com.bytedance.sdk.component.dl.g.tb
    public h z(tb.z zVar) throws Throwable {
        String strZ;
        String str;
        int i;
        IOException iOException;
        int i2;
        ArrayList arrayList;
        h hVarZ;
        int i3;
        int i4;
        int i5;
        sy syVarZ = zVar.z();
        e eVar = (e) zVar;
        com.bytedance.sdk.component.dl.g.gc gcVarCall = eVar.call();
        ls lsVarGz = eVar.gz();
        this.dl = new com.bytedance.sdk.component.dl.g.z.g.e(this.z.pf(), z(syVarZ.z()), gcVarCall, lsVarGz, this.f655a);
        try {
            i5 = Integer.parseInt(syVarZ.dl().z("csj_client_source_from"));
            strZ = syVarZ.dl().z("csj_extra_info");
        } catch (Exception unused) {
            strZ = "";
        }
        try {
            syVarZ = syVarZ.m().g("csj_client_source_from").g("csj_extra_info").z();
            i = i5;
            str = strZ;
        } catch (Exception unused2) {
            str = strZ;
            i = 0;
        }
        String string = syVarZ.z().toString();
        ArrayList arrayList2 = new ArrayList();
        h hVar = null;
        int i6 = 0;
        while (!this.gc) {
            if (this.z.gk != null && syVarZ.z() != null) {
                Iterator<String> it = this.z.gk.iterator();
                while (it.hasNext()) {
                    Iterator<String> it2 = it;
                    String[] strArrSplit = it.next().split("@");
                    ls lsVar = lsVarGz;
                    if (strArrSplit.length >= 2) {
                        String str2 = strArrSplit[0];
                        try {
                            i4 = Integer.parseInt(strArrSplit[1]);
                        } catch (Exception unused3) {
                            i4 = 0;
                        }
                        if ((i4 & i) != 0 && Pattern.compile(str2).matcher(syVarZ.z().toString()).find()) {
                            h.z zVar2 = new h.z();
                            zVar2.z(8848);
                            zVar2.z(syVarZ.z().toString());
                            zVar2.z(syVarZ);
                            zVar2.z(io.HTTP_1_1);
                            zVar2.z(com.bytedance.sdk.component.dl.g.z.dl.dl);
                            if (arrayList2.size() > 0) {
                                arrayList2.add(0, string);
                                return zVar2.z("csj-location-record", arrayList2.toString()).z("csj-source-from", String.valueOf(i)).z("csj-extra-info", String.valueOf(str)).z();
                            }
                            return zVar2.z();
                        }
                    }
                    it = it2;
                    lsVarGz = lsVar;
                }
            }
            ls lsVar2 = lsVarGz;
            try {
                try {
                    hVarZ = eVar.z(syVarZ, this.dl, null, null);
                    if (hVar != null) {
                        hVarZ = hVarZ.fo().dl(hVar.fo().z((gk) null).z()).z();
                    }
                    syVarZ = z(hVarZ);
                } catch (com.bytedance.sdk.component.dl.g.z.g.gc e) {
                    e = e;
                    i2 = i;
                    arrayList = arrayList2;
                    if (!z(e.z(), false, syVarZ)) {
                        throw e.z();
                    }
                    i = i2;
                } catch (IOException e2) {
                    e = e2;
                    i2 = i;
                    arrayList = arrayList2;
                    iOException = null;
                    try {
                        if (!z(e, !(e instanceof com.bytedance.sdk.component.dl.g.z.gc.z), syVarZ)) {
                            throw e;
                        }
                        i = i2;
                    } catch (Throwable th) {
                        th = th;
                        this.dl.z(iOException);
                        this.dl.dl();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    iOException = null;
                    this.dl.z(iOException);
                    this.dl.dl();
                    throw th;
                }
            } catch (com.bytedance.sdk.component.dl.g.z.g.gc e3) {
                e = e3;
                i2 = i;
                arrayList = arrayList2;
            } catch (IOException e4) {
                e = e4;
                i2 = i;
                arrayList = arrayList2;
                iOException = null;
            } catch (Throwable th3) {
                th = th3;
                iOException = null;
            }
            if (syVarZ == null) {
                if (!this.g) {
                    this.dl.dl();
                }
                if (arrayList2.size() <= 0) {
                    return hVarZ;
                }
                arrayList2.add(0, string);
                return hVarZ.fo().z("csj-location-record", arrayList2.toString()).z("csj-source-from", String.valueOf(i)).z("csj-extra-info", String.valueOf(str)).z();
            }
            arrayList2.add(syVarZ.z().toString());
            com.bytedance.sdk.component.dl.g.z.dl.z(hVarZ.gz());
            int i7 = i6 + 1;
            if (i7 > 20) {
                this.dl.dl();
                throw new ProtocolException("Too many follow-up requests: ".concat(String.valueOf(i7)));
            }
            if (syVarZ.a() instanceof wp) {
                this.dl.dl();
                throw new HttpRetryException("Cannot retry streamed HTTP body", hVarZ.dl());
            }
            if (!z(hVarZ, syVarZ.z())) {
                this.dl.dl();
                i3 = i;
                arrayList = arrayList2;
                this.dl = new com.bytedance.sdk.component.dl.g.z.g.e(this.z.pf(), z(syVarZ.z()), gcVarCall, lsVar2, this.f655a);
            } else {
                i3 = i;
                arrayList = arrayList2;
                if (this.dl.z() != null) {
                    throw new IllegalStateException("Closing the body of " + hVarZ + " didn't close its backing stream. Bad interceptor?");
                }
            }
            i = i3;
            hVar = hVarZ;
            i6 = i7;
            arrayList2 = arrayList;
            lsVarGz = lsVar2;
        }
        this.dl.dl();
        throw new IOException("Canceled");
    }

    private com.bytedance.sdk.component.dl.g.z z(js jsVar) {
        SSLSocketFactory sSLSocketFactoryUy;
        HostnameVerifier hostnameVerifierKb;
        com.bytedance.sdk.component.dl.g.e eVarWp;
        if (jsVar.a()) {
            sSLSocketFactoryUy = this.z.uy();
            hostnameVerifierKb = this.z.kb();
            eVarWp = this.z.wp();
        } else {
            sSLSocketFactoryUy = null;
            hostnameVerifierKb = null;
            eVarWp = null;
        }
        return new com.bytedance.sdk.component.dl.g.z(jsVar.e(), jsVar.gz(), this.z.gz(), this.z.fo(), sSLSocketFactoryUy, hostnameVerifierKb, eVarWp, this.z.v(), this.z.a(), this.z.tb(), this.z.q(), this.z.gc());
    }

    private boolean z(IOException iOException, boolean z, sy syVar) {
        this.dl.z(iOException);
        if (this.z.fv()) {
            return !(z && (syVar.a() instanceof wp)) && z(iOException, z) && this.dl.m();
        }
        return false;
    }

    private boolean z(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private sy z(h hVar) throws IOException {
        String strZ;
        js jsVarDl;
        Proxy proxyA;
        if (hVar == null) {
            throw new IllegalStateException();
        }
        com.bytedance.sdk.component.dl.g.z.g.dl dlVarG = this.dl.g();
        x xVarZ = dlVarG != null ? dlVarG.z() : null;
        int iDl = hVar.dl();
        String strG = hVar.z().g();
        if (iDl == 307 || iDl == 308) {
            if (!strG.equals("GET") && !strG.equals("HEAD")) {
                return null;
            }
        } else {
            if (iDl == 401) {
                return this.z.i().z(xVarZ, hVar);
            }
            if (iDl == 407) {
                if (xVarZ != null) {
                    proxyA = xVarZ.g();
                } else {
                    proxyA = this.z.a();
                }
                if (proxyA.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                return this.z.v().z(xVarZ, hVar);
            }
            if (iDl == 408) {
                if (!this.z.fv() || (hVar.z().a() instanceof wp)) {
                    return null;
                }
                if (hVar.kb() == null || hVar.kb().dl() != 408) {
                    return hVar.z();
                }
                return null;
            }
            switch (iDl) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        if (!this.z.p() || (strZ = hVar.z(HttpHeaders.LOCATION)) == null || (jsVarDl = hVar.z().z().dl(strZ)) == null) {
            return null;
        }
        if (!jsVarDl.dl().equals(hVar.z().z().dl()) && !this.z.ls()) {
            return null;
        }
        sy.z zVarM = hVar.z().m();
        if (m.dl(strG)) {
            boolean zA = m.a(strG);
            if (m.gc(strG)) {
                zVarM.z("GET", (hh) null);
            } else {
                zVarM.z(strG, zA ? hVar.z().a() : null);
            }
            if (!zA) {
                zVarM.g(HttpHeaders.TRANSFER_ENCODING);
                zVarM.g(HttpHeaders.CONTENT_LENGTH);
                zVarM.g(HttpHeaders.CONTENT_TYPE);
            }
        }
        if (!z(hVar, jsVarDl)) {
            zVarM.g(HttpHeaders.AUTHORIZATION);
        }
        return zVarM.z(jsVarDl).z();
    }

    private boolean z(h hVar, js jsVar) {
        js jsVarZ = hVar.z().z();
        return jsVarZ.e().equals(jsVar.e()) && jsVarZ.gz() == jsVar.gz() && jsVarZ.dl().equals(jsVar.dl());
    }
}
