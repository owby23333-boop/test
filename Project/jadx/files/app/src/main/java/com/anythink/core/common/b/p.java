package com.anythink.core.common.b;

import android.content.Context;
import android.content.Intent;
import com.anythink.core.activity.AnyThinkGdprAuthActivity;
import com.anythink.core.api.ATGDPRAuthCallback;
import com.anythink.core.api.AdError;
import com.anythink.core.api.NetTrafficeCallback;
import com.anythink.core.common.b.g;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile p f6995d;
    Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f6996c;
    final int a = -100;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<Integer, Boolean> f6997e = new ConcurrentHashMap<>(5);

    private p(Context context) {
        this.f6996c = 2;
        if (context != null) {
            this.b = context.getApplicationContext();
        }
        this.f6996c = com.anythink.core.common.k.p.b(this.b, g.f6799o, g.o.f6912d, 2);
    }

    public final boolean b() {
        com.anythink.core.c.a aVarB = com.anythink.core.c.b.a(this.b).b(n.a().p());
        if (aVarB == null || aVarB.G()) {
            return this.f6996c != 1;
        }
        if (aVarB.U() == 0) {
            return true;
        }
        int iR = this.f6996c;
        if (aVarB.S() == 1) {
            iR = aVarB.R();
        }
        return iR == 0;
    }

    public final boolean c() {
        com.anythink.core.c.a aVarB = com.anythink.core.c.b.a(this.b).b(n.a().p());
        return (aVarB == null || aVarB.G()) ? this.f6996c != 1 : this.f6996c == 2 ? aVarB.U() == 0 : aVarB.S() == 1 ? aVarB.R() == 0 : this.f6996c == 0 || aVarB.U() == 0;
    }

    public final boolean d() {
        return com.anythink.core.common.k.p.b(this.b, g.f6799o, g.o.f6918j, -100) == 1;
    }

    public static p a(Context context) {
        if (f6995d == null) {
            synchronized (p.class) {
                if (f6995d == null) {
                    f6995d = new p(context);
                }
            }
        }
        return f6995d;
    }

    public final void a(int i2) {
        this.f6996c = i2;
        com.anythink.core.common.k.p.a(this.b, g.f6799o, g.o.f6912d, i2);
    }

    public final void b(final int i2) {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.p.3
            @Override // java.lang.Runnable
            public final void run() {
                if (p.this.c(i2)) {
                    return;
                }
                p pVarA = p.a(n.a().g());
                com.anythink.core.c.a aVarB = com.anythink.core.c.b.a(n.a().g()).b(n.a().p());
                if (pVarA.f6996c == 2 && aVarB.U() == 1 && aVarB.I() == 0) {
                    com.anythink.core.common.j.c.a(1, pVarA.f6996c, aVarB.U(), i2);
                }
                if (pVarA.f6996c == 1 && aVarB.S() == 0 && aVarB.U() == 0) {
                    com.anythink.core.common.j.c.a(2, pVarA.f6996c, aVarB.U(), i2);
                }
                p.this.f6997e.put(Integer.valueOf(i2), Boolean.TRUE);
            }
        });
    }

    public final int a() {
        return this.f6996c;
    }

    public final boolean c(int i2) {
        return this.f6997e.get(Integer.valueOf(i2)) != null && this.f6997e.get(Integer.valueOf(i2)).booleanValue();
    }

    public final void a(final Context context, final ATGDPRAuthCallback aTGDPRAuthCallback) {
        n.a().a(new Runnable() { // from class: com.anythink.core.common.b.p.1
            @Override // java.lang.Runnable
            public final void run() {
                AnyThinkGdprAuthActivity.mCallback = aTGDPRAuthCallback;
                Intent intent = new Intent(context, (Class<?>) AnyThinkGdprAuthActivity.class);
                intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                context.startActivity(intent);
            }
        });
    }

    public final void a(final NetTrafficeCallback netTrafficeCallback) {
        int iB = com.anythink.core.common.k.p.b(this.b, g.f6799o, g.o.f6918j, -100);
        if (iB == -100) {
            new com.anythink.core.common.g.h().a(0, new com.anythink.core.common.g.i() { // from class: com.anythink.core.common.b.p.2
                @Override // com.anythink.core.common.g.i
                public final void onLoadCanceled(int i2) {
                }

                @Override // com.anythink.core.common.g.i
                public final void onLoadError(int i2, String str, AdError adError) {
                    NetTrafficeCallback netTrafficeCallback2 = netTrafficeCallback;
                    if (netTrafficeCallback2 != null) {
                        netTrafficeCallback2.onErrorCallback(adError.printStackTrace());
                    }
                }

                @Override // com.anythink.core.common.g.i
                public final void onLoadFinish(int i2, Object obj) {
                    try {
                        if (obj == null) {
                            if (netTrafficeCallback != null) {
                                netTrafficeCallback.onErrorCallback("There is no result.");
                            }
                        } else if (!((JSONObject) obj).has("is_eu")) {
                            if (netTrafficeCallback != null) {
                                netTrafficeCallback.onErrorCallback("There is no result.");
                            }
                        } else if (((JSONObject) obj).optInt("is_eu") == 1) {
                            if (netTrafficeCallback != null) {
                                netTrafficeCallback.onResultCallback(true);
                            }
                        } else if (netTrafficeCallback != null) {
                            netTrafficeCallback.onResultCallback(false);
                        }
                    } catch (Throwable unused) {
                        NetTrafficeCallback netTrafficeCallback2 = netTrafficeCallback;
                        if (netTrafficeCallback2 != null) {
                            netTrafficeCallback2.onErrorCallback("Internal error");
                        }
                    }
                }

                @Override // com.anythink.core.common.g.i
                public final void onLoadStart(int i2) {
                }
            });
            return;
        }
        if (iB == 1) {
            if (netTrafficeCallback != null) {
                netTrafficeCallback.onResultCallback(true);
            }
        } else if (netTrafficeCallback != null) {
            netTrafficeCallback.onResultCallback(false);
        }
    }
}
