package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.widget.e;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ar {
    private static Handler aRF = new Handler(Looper.getMainLooper());
    private com.kwad.sdk.core.config.d aZV;

    static final class a {
        private static final ar aZZ = new ar();
    }

    public static ar QX() {
        return a.aZZ;
    }

    public final void cS(final String str) {
        GlobalThreadPools.Jy().execute(new Runnable() { // from class: com.kwad.sdk.utils.ar.1
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.c.d("PackageInstallHelper", "init configStr:" + str);
                if (TextUtils.isEmpty(str)) {
                    com.kwad.sdk.core.d.c.w("PackageInstallHelper", "config is empty");
                } else {
                    ar.this.aZV = ar.hd(str);
                }
            }
        });
    }

    public static com.kwad.sdk.core.config.d hd(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.kwad.sdk.core.config.d dVar = new com.kwad.sdk.core.config.d();
            dVar.parseJson(jSONObject);
            return dVar;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w("PackageInstallHelper", e);
            return null;
        }
    }

    private com.kwad.sdk.core.config.d QY() {
        if (this.aZV == null) {
            this.aZV = new com.kwad.sdk.core.config.d();
        }
        return this.aZV;
    }

    public final void QZ() {
        try {
            com.kwad.sdk.core.c.b.Ho();
            com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.utils.ar.2
                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                /* JADX INFO: renamed from: onActivityStopped */
                public final void e(Activity activity) {
                    super.e(activity);
                    com.kwad.sdk.core.d.c.d("PackageInstallHelper", "onActivityStopped:" + activity);
                    if (ar.aRF != null) {
                        ar.aRF.removeCallbacksAndMessages(null);
                    }
                }

                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                public final void onBackToBackground() {
                    super.onBackToBackground();
                    com.kwad.sdk.core.d.c.d("PackageInstallHelper", "onBackToBackground:");
                    if (ar.aRF != null) {
                        ar.aRF.removeCallbacksAndMessages(null);
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    private static boolean Ra() {
        return j.PK() || j.PL();
    }

    public final void l(final Activity activity) {
        com.kwad.sdk.core.config.d dVarQY = QY();
        if (dVarQY == null || dVarQY.aCc == 0) {
            com.kwad.sdk.core.d.c.d("PackageInstallHelper", "config is null or enableDialog is false");
            return;
        }
        int i = dVarQY.aCd;
        if (i < 0) {
            return;
        }
        if (!Ra()) {
            com.kwad.sdk.core.d.c.d("PackageInstallHelper", "not support");
            return;
        }
        if (a(dVarQY)) {
            return;
        }
        if (Re() >= dVarQY.aCf) {
            com.kwad.sdk.core.d.c.d("PackageInstallHelper", "show times is over max");
            return;
        }
        if (m(activity)) {
            com.kwad.sdk.core.d.c.d("PackageInstallHelper", "has install permission");
            return;
        }
        Handler handler = aRF;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            aRF.postDelayed(new Runnable() { // from class: com.kwad.sdk.utils.ar.3
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        final Activity activity2 = (Activity) com.kwad.sdk.o.m.wrapContextIfNeed(activity);
                        if (activity2.isFinishing() || activity2.isDestroyed()) {
                            return;
                        }
                        com.kwad.sdk.core.d.c.d("PackageInstallHelper", "show dialog");
                        e.a aVar = new e.a(activity2);
                        aVar.hK("去授权").hL("残忍拒绝").hJ("需要授予安装其他应用权限");
                        aVar.a(new e.b() { // from class: com.kwad.sdk.utils.ar.3.1
                            @Override // com.kwad.sdk.widget.e.b
                            public final void a(DialogInterface dialogInterface) {
                                bw.e(dialogInterface);
                                j.cA(activity2);
                            }

                            @Override // com.kwad.sdk.widget.e.b
                            public final void b(DialogInterface dialogInterface) {
                                bw.e(dialogInterface);
                            }

                            @Override // com.kwad.sdk.widget.e.b
                            public final void c(DialogInterface dialogInterface) {
                                bw.e(dialogInterface);
                            }
                        });
                        try {
                            aVar.SO().show();
                            ar arVar = ar.this;
                            ar.Rc();
                            ar arVar2 = ar.this;
                            ar.Rd();
                        } catch (Exception unused) {
                        }
                    } catch (Exception e) {
                        ServiceProvider.reportSdkCaughtException(e);
                    }
                }
            }, i);
        }
    }

    private boolean a(com.kwad.sdk.core.config.d dVar) {
        int iRb = Rb();
        if (iRb <= dVar.aCe) {
            return false;
        }
        com.kwad.sdk.core.d.c.d("PackageInstallHelper", "todayShow:" + iRb + " > showTimesPerDay:" + dVar.aCe);
        return true;
    }

    private static boolean m(Activity activity) {
        return activity.getPackageManager().canRequestPackageInstalls();
    }

    private static int Rb() {
        String strH = ag.h("ksadsdk_perf", "install_permission_times_per_day", "");
        if (TextUtils.isEmpty(strH)) {
            return 0;
        }
        String[] strArrSplit = strH.split("_");
        try {
            if (strArrSplit[0].equals(Rf())) {
                return Integer.parseInt(strArrSplit[1]);
            }
            return 0;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w("PackageInstallHelper", Log.getStackTraceString(e));
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Rc() {
        try {
            String strH = ag.h("ksadsdk_perf", "install_permission_times_per_day", "");
            if (TextUtils.isEmpty(strH)) {
                ag.g("ksadsdk_perf", "install_permission_times_per_day", Rf() + "_1");
                return;
            }
            String[] strArrSplit = strH.split("_");
            if (strArrSplit[0].equals(Rf())) {
                ag.g("ksadsdk_perf", "install_permission_times_per_day", Rf() + "_" + (Integer.parseInt(strArrSplit[1]) + 1));
            } else {
                ag.g("ksadsdk_perf", "install_permission_times_per_day", Rf() + "_1");
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w("PackageInstallHelper", Log.getStackTraceString(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Rd() {
        try {
            ag.b("ksadsdk_perf", "install_permission_times", ag.c("ksadsdk_perf", "install_permission_times", 0) + 1);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w("PackageInstallHelper", Log.getStackTraceString(e));
        }
    }

    private static int Re() {
        try {
            return ag.c("ksadsdk_perf", "install_permission_times", 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    private static String Rf() {
        return new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date());
    }
}
