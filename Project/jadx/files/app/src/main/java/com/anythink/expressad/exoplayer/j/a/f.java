package com.anythink.expressad.exoplayer.j.a;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.j.a.a;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.k.v;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static final int a = 131072;

    public static class a {
        public volatile long a;
        public volatile long b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile long f9622c = -1;

        private long a() {
            return this.a + this.b;
        }
    }

    private f() {
    }

    private static String a(Uri uri) {
        return uri.toString();
    }

    public static String a(com.anythink.expressad.exoplayer.j.k kVar) {
        String str = kVar.f9672h;
        return str != null ? str : kVar.f9667c.toString();
    }

    private static void a(com.anythink.expressad.exoplayer.j.k kVar, com.anythink.expressad.exoplayer.j.a.a aVar, a aVar2) {
        String strA = a(kVar);
        long j2 = kVar.f9669e;
        long jB = kVar.f9671g;
        if (jB == -1) {
            jB = aVar.b(strA);
        }
        aVar2.f9622c = jB;
        aVar2.a = 0L;
        aVar2.b = 0L;
        long j3 = j2;
        long j4 = jB;
        while (j4 != 0) {
            long jB2 = aVar.b(strA, j3, j4 != -1 ? j4 : Long.MAX_VALUE);
            if (jB2 > 0) {
                aVar2.a += jB2;
            } else {
                jB2 = -jB2;
                if (jB2 == Long.MAX_VALUE) {
                    return;
                }
            }
            j3 += jB2;
            if (j4 == -1) {
                jB2 = 0;
            }
            j4 -= jB2;
        }
    }

    private static void a(com.anythink.expressad.exoplayer.j.k kVar, com.anythink.expressad.exoplayer.j.a.a aVar, com.anythink.expressad.exoplayer.j.h hVar, @Nullable a aVar2, @Nullable AtomicBoolean atomicBoolean) throws InterruptedException {
        a aVar3;
        String str;
        long j2;
        long j3;
        c cVar = new c(aVar, hVar);
        byte[] bArr = new byte[131072];
        com.anythink.expressad.exoplayer.k.a.a(cVar);
        com.anythink.expressad.exoplayer.k.a.a(bArr);
        long j4 = 0;
        if (aVar2 != null) {
            String strA = a(kVar);
            long j5 = kVar.f9669e;
            long jB = kVar.f9671g;
            if (jB == -1) {
                jB = aVar.b(strA);
            }
            aVar2.f9622c = jB;
            aVar2.a = 0L;
            aVar2.b = 0L;
            long j6 = j5;
            long j7 = jB;
            while (j7 != 0) {
                String str2 = strA;
                long jB2 = aVar.b(strA, j6, j7 != -1 ? j7 : Long.MAX_VALUE);
                if (jB2 <= 0) {
                    jB2 = -jB2;
                    if (jB2 == Long.MAX_VALUE) {
                        break;
                    }
                } else {
                    aVar2.a += jB2;
                }
                j6 += jB2;
                if (j7 == -1) {
                    jB2 = 0;
                }
                j7 -= jB2;
                strA = str2;
            }
            aVar3 = aVar2;
        } else {
            aVar3 = new a();
        }
        String strA2 = a(kVar);
        long j8 = kVar.f9669e;
        long jB3 = kVar.f9671g;
        if (jB3 == -1) {
            jB3 = aVar.b(strA2);
        }
        long j9 = j8;
        long j10 = jB3;
        while (j10 != j4) {
            if (atomicBoolean != null && atomicBoolean.get()) {
                throw new InterruptedException();
            }
            long jB4 = aVar.b(strA2, j9, j10 != -1 ? j10 : Long.MAX_VALUE);
            if (jB4 <= j4) {
                long j11 = -jB4;
                str = strA2;
                j2 = j4;
                if (a(kVar, j9, j11, cVar, bArr, (v) null, aVar3) < j11) {
                    return;
                } else {
                    j3 = j11;
                }
            } else {
                str = strA2;
                j2 = j4;
                j3 = jB4;
            }
            j9 += j3;
            if (j10 == -1) {
                j3 = j2;
            }
            j10 -= j3;
            strA2 = str;
            j4 = j2;
        }
    }

    private static void a(com.anythink.expressad.exoplayer.j.k kVar, com.anythink.expressad.exoplayer.j.a.a aVar, c cVar, byte[] bArr, v vVar, @Nullable a aVar2, @Nullable AtomicBoolean atomicBoolean) throws InterruptedException {
        a aVar3;
        String str;
        long j2;
        long j3;
        com.anythink.expressad.exoplayer.k.a.a(cVar);
        com.anythink.expressad.exoplayer.k.a.a(bArr);
        long j4 = 0;
        if (aVar2 != null) {
            String strA = a(kVar);
            long j5 = kVar.f9669e;
            long jB = kVar.f9671g;
            if (jB == -1) {
                jB = aVar.b(strA);
            }
            aVar2.f9622c = jB;
            aVar2.a = 0L;
            aVar2.b = 0L;
            long j6 = j5;
            long j7 = jB;
            while (j7 != 0) {
                long jB2 = aVar.b(strA, j6, j7 != -1 ? j7 : Long.MAX_VALUE);
                if (jB2 <= 0) {
                    jB2 = -jB2;
                    if (jB2 == Long.MAX_VALUE) {
                        break;
                    }
                } else {
                    aVar2.a += jB2;
                }
                j6 += jB2;
                if (j7 == -1) {
                    jB2 = 0;
                }
                j7 -= jB2;
            }
            aVar3 = aVar2;
        } else {
            aVar3 = new a();
        }
        String strA2 = a(kVar);
        long j8 = kVar.f9669e;
        long jB3 = kVar.f9671g;
        if (jB3 == -1) {
            jB3 = aVar.b(strA2);
        }
        long j9 = j8;
        long j10 = jB3;
        while (j10 != j4) {
            if (atomicBoolean != null && atomicBoolean.get()) {
                throw new InterruptedException();
            }
            long jB4 = aVar.b(strA2, j9, j10 != -1 ? j10 : Long.MAX_VALUE);
            if (jB4 <= j4) {
                long j11 = -jB4;
                str = strA2;
                j2 = j4;
                if (a(kVar, j9, j11, cVar, bArr, vVar, aVar3) < j11) {
                    return;
                } else {
                    j3 = j11;
                }
            } else {
                str = strA2;
                j2 = j4;
                j3 = jB4;
            }
            j9 += j3;
            if (j10 == -1) {
                j3 = j2;
            }
            j10 -= j3;
            strA2 = str;
            j4 = j2;
        }
    }

    private static long a(com.anythink.expressad.exoplayer.j.k kVar, long j2, long j3, com.anythink.expressad.exoplayer.j.h hVar, byte[] bArr, v vVar, a aVar) {
        int length;
        com.anythink.expressad.exoplayer.j.k kVar2 = kVar;
        while (true) {
            if (vVar != null) {
                vVar.b();
            }
            try {
                try {
                    if (!Thread.interrupted()) {
                        com.anythink.expressad.exoplayer.j.k kVar3 = new com.anythink.expressad.exoplayer.j.k(kVar2.f9667c, kVar2.f9668d, j2, (kVar2.f9670f + j2) - kVar2.f9669e, -1L, kVar2.f9672h, kVar2.f9673i | 2);
                        try {
                            long jA = hVar.a(kVar3);
                            if (aVar.f9622c == -1 && jA != -1) {
                                aVar.f9622c = kVar3.f9669e + jA;
                            }
                            long j4 = 0;
                            while (true) {
                                if (j4 == j3) {
                                    break;
                                }
                                if (!Thread.interrupted()) {
                                    if (j3 != -1) {
                                        length = (int) Math.min(bArr.length, j3 - j4);
                                    } else {
                                        length = bArr.length;
                                    }
                                    int iA = hVar.a(bArr, 0, length);
                                    if (iA != -1) {
                                        long j5 = iA;
                                        j4 += j5;
                                        aVar.b += j5;
                                    } else if (aVar.f9622c == -1) {
                                        aVar.f9622c = kVar3.f9669e + j4;
                                    }
                                } else {
                                    throw new InterruptedException();
                                }
                            }
                            return j4;
                        } catch (v.a unused) {
                            kVar2 = kVar3;
                        }
                    } else {
                        throw new InterruptedException();
                    }
                } finally {
                    af.a(hVar);
                }
            } catch (v.a unused2) {
            }
            af.a(hVar);
        }
    }

    private static void a(com.anythink.expressad.exoplayer.j.a.a aVar, String str) {
        Iterator<e> it = aVar.a(str).iterator();
        while (it.hasNext()) {
            try {
                aVar.b(it.next());
            } catch (a.C0200a unused) {
            }
        }
    }
}
