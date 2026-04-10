package com.kwad.sdk.core.d;

import android.util.Log;
import com.umeng.message.proguard.ad;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static boolean afA = true;
    private static boolean afB = com.kwad.kwai.kwai.a.bI.booleanValue();
    private static final com.kwad.sdk.core.d.kwai.b afC = new com.kwad.sdk.core.d.a();
    private static final List<com.kwad.sdk.core.d.kwai.b> afD = new CopyOnWriteArrayList();
    private static com.kwad.sdk.core.d.kwai.a afE;

    interface a {
        void b(com.kwad.sdk.core.d.kwai.b bVar);
    }

    private static void a(a aVar) {
        for (com.kwad.sdk.core.d.kwai.b bVar : afD) {
            if (bVar != null) {
                try {
                    aVar.b(bVar);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void a(com.kwad.sdk.core.d.kwai.b bVar) {
        if (afD.contains(bVar)) {
            return;
        }
        afD.add(bVar);
    }

    public static void a(boolean z2, com.kwad.sdk.core.d.kwai.a aVar) {
        afA = z2;
        afD.clear();
        afD.add(afC);
        afE = aVar;
    }

    public static void bL(final String str) {
        a(new a() { // from class: com.kwad.sdk.core.d.b.6
            @Override // com.kwad.sdk.core.d.b.a
            public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                bVar.v(b.wl(), str, true);
            }
        });
    }

    public static void d(String str, String str2) {
        y(wl(), u(str, str2));
    }

    public static void e(String str, String str2) {
        final String strU = u(str, str2);
        a(new a() { // from class: com.kwad.sdk.core.d.b.11
            @Override // com.kwad.sdk.core.d.b.a
            public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                bVar.e(b.wl(), strU);
            }
        });
        com.kwad.sdk.core.d.kwai.a aVar = afE;
        if (aVar != null) {
            aVar.m(str2, str);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        final String strU = u(str, str2 + '\n' + stackTraceString);
        a(new a() { // from class: com.kwad.sdk.core.d.b.2
            @Override // com.kwad.sdk.core.d.b.a
            public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                bVar.e(b.wl(), strU);
            }
        });
        com.kwad.sdk.core.d.kwai.a aVar = afE;
        if (aVar != null) {
            aVar.m(stackTraceString, str);
        }
    }

    public static void i(String str, String str2) {
        final String strU = u(str, str2);
        a(new a() { // from class: com.kwad.sdk.core.d.b.8
            @Override // com.kwad.sdk.core.d.b.a
            public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                bVar.i(b.wl(), strU);
            }
        });
    }

    public static void printStackTrace(final Throwable th) {
        if (th != null) {
            a(new a() { // from class: com.kwad.sdk.core.d.b.3
                @Override // com.kwad.sdk.core.d.b.a
                public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                    bVar.printStackTraceOnly(th);
                }
            });
        }
        if (com.kwad.kwai.kwai.a.bI.booleanValue()) {
            throw new RuntimeException(th);
        }
    }

    public static void printStackTraceOnly(final Throwable th) {
        if (th != null) {
            a(new a() { // from class: com.kwad.sdk.core.d.b.4
                @Override // com.kwad.sdk.core.d.b.a
                public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                    bVar.printStackTraceOnly(th);
                }
            });
        }
    }

    private static String u(String str, String str2) {
        return "[" + str + "]: " + str2 + " " + wm();
    }

    public static void v(String str, String str2) {
        final String strU = u(str, str2);
        a(new a() { // from class: com.kwad.sdk.core.d.b.5
            @Override // com.kwad.sdk.core.d.b.a
            public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                bVar.v(b.wl(), strU);
            }
        });
    }

    public static void w(String str, String str2) {
        final String strU = u(str, str2);
        a(new a() { // from class: com.kwad.sdk.core.d.b.9
            @Override // com.kwad.sdk.core.d.b.a
            public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                bVar.w(b.wl(), strU);
            }
        });
    }

    public static void w(String str, Throwable th) {
        final String strU = u(str, Log.getStackTraceString(th));
        a(new a() { // from class: com.kwad.sdk.core.d.b.10
            @Override // com.kwad.sdk.core.d.b.a
            public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                bVar.w(b.wl(), strU, com.kwad.kwai.kwai.a.bI.booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String wl() {
        return "KSAdSDK";
    }

    private static String wm() {
        String fileName;
        int lineNumber;
        if (!afB) {
            return "";
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length > 3) {
            fileName = stackTrace[3].getFileName();
            lineNumber = stackTrace[3].getLineNumber();
        } else {
            fileName = "unknown";
            lineNumber = -1;
        }
        return ad.f20405r + fileName + ':' + lineNumber + ')';
    }

    private static void x(final String str, final String str2) {
        a(new a() { // from class: com.kwad.sdk.core.d.b.1
            @Override // com.kwad.sdk.core.d.b.a
            public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                bVar.d(str, str2);
            }
        });
    }

    private static void y(String str, String str2) {
        if (str2.length() <= 4000) {
            x(str, str2);
        } else {
            x(str, str2.substring(0, 4000));
            y(str, str2.substring(4000));
        }
    }

    public static void z(String str, String str2) {
        final String strU = u(str, str2);
        a(new a() { // from class: com.kwad.sdk.core.d.b.7
            @Override // com.kwad.sdk.core.d.b.a
            public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                bVar.v(b.wl(), strU, true);
            }
        });
    }
}
