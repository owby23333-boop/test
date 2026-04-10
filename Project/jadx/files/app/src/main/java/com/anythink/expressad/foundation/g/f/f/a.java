package com.anythink.expressad.foundation.g.f.f;

import android.os.SystemClock;
import com.anythink.expressad.foundation.g.f.g;
import com.anythink.expressad.foundation.g.f.i;
import com.anythink.expressad.foundation.g.f.l;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.video.module.a.a.m;
import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLProtocolException;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public class a implements g {
    private static final String a = "a";
    private static final int b = 3000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.anythink.expressad.foundation.g.f.e.a f10549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.anythink.expressad.foundation.g.f.c f10550d;

    public a(com.anythink.expressad.foundation.g.f.e.a aVar, com.anythink.expressad.foundation.g.f.c cVar) {
        this.f10549c = aVar;
        this.f10550d = cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.anythink.expressad.foundation.g.f.g
    public final c a(i<?> iVar) throws com.anythink.expressad.foundation.g.f.a.a {
        String str;
        b bVarA;
        byte[] bArrA;
        b bVarA2;
        byte[] bArrA2;
        String str2;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        c cVar = null;
        l lVarL = iVar != null ? iVar.l() : null;
        String str3 = "MalformedURLException ex= ";
        if ((lVarL != null ? lVarL.a() : 0) > 0) {
            while (!iVar.f()) {
                try {
                    try {
                        try {
                            iVar.i();
                            bVarA = this.f10549c.a(iVar);
                            try {
                                int iA = bVarA.a();
                                bArrA = iVar.a(bVarA, this.f10550d);
                                try {
                                    str = str3;
                                    try {
                                        a(SystemClock.elapsedRealtime() - jElapsedRealtime, iVar, bArrA, iA);
                                        if (iA < 200 || iA > 399) {
                                            throw new IOException();
                                        }
                                        return new c(iA, bArrA, bVarA.b());
                                    } catch (MalformedURLException e2) {
                                        e = e2;
                                        a(str + e.getMessage(), SystemClock.elapsedRealtime() - jElapsedRealtime, iVar);
                                        throw new com.anythink.expressad.foundation.g.f.a.a(4, null);
                                    } catch (IOException e3) {
                                        e = e3;
                                        a("IOException ex= " + e.getMessage(), SystemClock.elapsedRealtime() - jElapsedRealtime, iVar);
                                        if (bVarA == 0) {
                                            throw new com.anythink.expressad.foundation.g.f.a.a(14, null);
                                        }
                                        int iA2 = bVarA.a();
                                        if (bArrA != 0) {
                                            c cVar2 = new c(iA2, bArrA, bVarA.b());
                                            if (iA2 >= 400 && iA2 <= 499) {
                                                throw new com.anythink.expressad.foundation.g.f.a.a(6, cVar2);
                                            }
                                            if (iA2 < 500 || iA2 > 599) {
                                                throw new com.anythink.expressad.foundation.g.f.a.a(2, cVar2);
                                            }
                                            throw new com.anythink.expressad.foundation.g.f.a.a(7, cVar2);
                                        }
                                        com.anythink.expressad.foundation.g.f.a.a aVar = new com.anythink.expressad.foundation.g.f.a.a(15, null);
                                        if (!iVar.l().d()) {
                                            throw aVar;
                                        }
                                        this.f10550d.e(iVar);
                                        cVar = null;
                                        str3 = str;
                                    }
                                } catch (IOException e4) {
                                    e = e4;
                                    str = str3;
                                }
                            } catch (IOException e5) {
                                e = e5;
                                str = str3;
                                bArrA = cVar;
                            }
                        } catch (ConnectException e6) {
                            a("ConnectException ex= " + e6.getMessage(), SystemClock.elapsedRealtime() - jElapsedRealtime, iVar);
                            throw new com.anythink.expressad.foundation.g.f.a.a(12, null);
                        } catch (SocketTimeoutException e7) {
                            a("SocketTimeoutException ex= " + e7.getMessage(), SystemClock.elapsedRealtime() - jElapsedRealtime, iVar);
                            throw new com.anythink.expressad.foundation.g.f.a.a(10, null);
                        } catch (UnknownHostException e8) {
                            a("UnknownHostException ex= " + e8.getMessage(), SystemClock.elapsedRealtime() - jElapsedRealtime, iVar);
                            throw new com.anythink.expressad.foundation.g.f.a.a(9, null);
                        } catch (SSLProtocolException e9) {
                            a("SSLProtocolException ex= " + e9.getMessage(), SystemClock.elapsedRealtime() - jElapsedRealtime, iVar);
                            throw new com.anythink.expressad.foundation.g.f.a.a(11, null);
                        } catch (ConnectTimeoutException e10) {
                            a("ConnectTimeoutException ex= " + e10.getMessage(), SystemClock.elapsedRealtime() - jElapsedRealtime, iVar);
                            throw new com.anythink.expressad.foundation.g.f.a.a(3, null);
                        }
                    } catch (MalformedURLException e11) {
                        e = e11;
                        str = str3;
                    }
                } catch (IOException e12) {
                    e = e12;
                    str = str3;
                    bVarA = cVar;
                    bArrA = bVarA;
                }
            }
            iVar.c();
            this.f10550d.b(iVar);
            throw new com.anythink.expressad.foundation.g.f.a.a(-2, cVar);
        }
        if (iVar.f()) {
            iVar.c();
            this.f10550d.b(iVar);
            throw new com.anythink.expressad.foundation.g.f.a.a(-2, null);
        }
        try {
            try {
                try {
                    iVar.i();
                    bVarA2 = this.f10549c.a(iVar);
                    try {
                        int iA3 = bVarA2.a();
                        bArrA2 = iVar.a(bVarA2, this.f10550d);
                        try {
                            str2 = "UnknownHostException ex= ";
                            try {
                                a(SystemClock.elapsedRealtime() - jElapsedRealtime, iVar, bArrA2, iA3);
                                if (iA3 < 200 || iA3 > 399) {
                                    throw new IOException();
                                }
                                return new c(iA3, bArrA2, bVarA2.b());
                            } catch (UnknownHostException e13) {
                                e = e13;
                                a(str2 + e.getMessage(), SystemClock.elapsedRealtime() - jElapsedRealtime, iVar);
                                throw new com.anythink.expressad.foundation.g.f.a.a(9, null);
                            }
                        } catch (IOException e14) {
                            e = e14;
                            a("IOException ex= " + e.getMessage(), SystemClock.elapsedRealtime() - jElapsedRealtime, iVar);
                            if (bVarA2 == null) {
                                throw new com.anythink.expressad.foundation.g.f.a.a(14, null);
                            }
                            int iA4 = bVarA2.a();
                            if (bArrA2 == null) {
                                throw new com.anythink.expressad.foundation.g.f.a.a(15, null);
                            }
                            c cVar3 = new c(iA4, bArrA2, bVarA2.b());
                            if (iA4 >= 400 && iA4 <= 499) {
                                throw new com.anythink.expressad.foundation.g.f.a.a(6, cVar3);
                            }
                            if (iA4 < 500 || iA4 > 599) {
                                throw new com.anythink.expressad.foundation.g.f.a.a(2, cVar3);
                            }
                            throw new com.anythink.expressad.foundation.g.f.a.a(7, cVar3);
                        }
                    } catch (IOException e15) {
                        e = e15;
                        bArrA2 = null;
                    }
                } catch (ConnectException e16) {
                    a("ConnectException ex= " + e16.getMessage(), SystemClock.elapsedRealtime() - jElapsedRealtime, iVar);
                    throw new com.anythink.expressad.foundation.g.f.a.a(12, null);
                } catch (MalformedURLException e17) {
                    a("MalformedURLException ex= " + e17.getMessage(), SystemClock.elapsedRealtime() - jElapsedRealtime, iVar);
                    throw new com.anythink.expressad.foundation.g.f.a.a(4, null);
                } catch (SocketTimeoutException e18) {
                    a("SocketTimeoutException ex= " + e18.getMessage(), SystemClock.elapsedRealtime() - jElapsedRealtime, iVar);
                    throw new com.anythink.expressad.foundation.g.f.a.a(10, null);
                } catch (SSLProtocolException e19) {
                    a("SSLProtocolException ex= " + e19.getMessage(), SystemClock.elapsedRealtime() - jElapsedRealtime, iVar);
                    throw new com.anythink.expressad.foundation.g.f.a.a(11, null);
                } catch (ConnectTimeoutException e20) {
                    a("ConnectTimeoutException ex= " + e20.getMessage(), SystemClock.elapsedRealtime() - jElapsedRealtime, iVar);
                    throw new com.anythink.expressad.foundation.g.f.a.a(3, null);
                }
            } catch (IOException e21) {
                e = e21;
                bVarA2 = null;
                bArrA2 = null;
            }
        } catch (UnknownHostException e22) {
            e = e22;
            str2 = "UnknownHostException ex= ";
        }
    }

    private static void a(long j2, i<?> iVar, byte[] bArr, int i2) {
        if (com.anythink.expressad.a.a) {
            if (j2 > m.ag) {
                try {
                    String str = a;
                    Object[] objArr = new Object[6];
                    objArr[0] = iVar.d();
                    objArr[1] = Integer.valueOf(iVar.a());
                    objArr[2] = Long.valueOf(j2);
                    objArr[3] = bArr != null ? Integer.valueOf(bArr.length) : "null";
                    objArr[4] = Integer.valueOf(i2);
                    objArr[5] = Integer.valueOf(iVar.l().c());
                    o.b(str, String.format("Slow HTTP response for request=<%s> [method=%s] [lifetime=%d], [size=%s], [statusCode=%d], [retryCount=%s]", objArr));
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            try {
                String str2 = a;
                Object[] objArr2 = new Object[6];
                objArr2[0] = iVar.d();
                objArr2[1] = Integer.valueOf(iVar.a());
                objArr2[2] = Long.valueOf(j2);
                objArr2[3] = bArr != null ? Integer.valueOf(bArr.length) : "null";
                objArr2[4] = Integer.valueOf(i2);
                objArr2[5] = Integer.valueOf(iVar.l().c());
                o.b(str2, String.format("Normal HTTP response for request=<%s> [method=%s] [lifetime=%d], [size=%s], [statusCode=%d], [retryCount=%s]", objArr2));
            } catch (Exception unused2) {
            }
        }
    }

    private static void a(String str, long j2, i<?> iVar) {
        if (com.anythink.expressad.a.a) {
            try {
                String str2 = a;
                Object[] objArr = new Object[4];
                objArr[0] = iVar.d();
                objArr[1] = Long.valueOf(j2);
                if (str == null) {
                    str = "null";
                }
                objArr[2] = str;
                objArr[3] = Integer.valueOf(iVar.l().c());
                o.b(str2, String.format("HTTP exception for request=<%s> [lifetime=%d], [size=%s], [retryCount=%s]", objArr));
            } catch (Exception unused) {
            }
        }
    }

    private void a(i<?> iVar, com.anythink.expressad.foundation.g.f.a.a aVar) throws com.anythink.expressad.foundation.g.f.a.a {
        if (iVar.l().d()) {
            this.f10550d.e(iVar);
            return;
        }
        throw aVar;
    }
}
