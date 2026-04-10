package com.kuaishou.weapon.p0;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.receiver.WeaponRECE;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class WeaponHI {
    public static boolean as = false;
    public static String cookieData = "";
    public static String encryENV = "";
    public static String hostVersionName = "";
    public static int ii = 0;
    public static List<Integer> isList = null;
    public static Context mContext = null;
    public static IWeaponInitParams mParams = null;
    public static String sChannel = "";
    public static String sKDeviceId = "";
    public static String sKSAppkey = "";
    public static String sKSSdkver = "";
    public static String sKSSecKey = "";
    public static String sUserId = "";
    public static String skProductName = "";

    public static void iD() {
        try {
            iP(mContext);
            WeaponRECE weaponRECE = new WeaponRECE();
            Application application = mContext instanceof Application ? (Application) mContext : null;
            if (application != null) {
                IntentFilter intentFilter = new IntentFilter(bp.f16592f);
                intentFilter.addDataScheme("env");
                application.registerReceiver(weaponRECE, intentFilter);
            }
        } catch (Throwable unused) {
        }
        try {
            da.a(mContext).a(100);
            cw.a(mContext).a(100);
            db.a(mContext).a(100);
            cz.a(mContext).a(100, 0);
            cx.a(mContext).a(100);
            cy.a(mContext).a();
            dc.a(mContext).a();
        } catch (Exception unused2) {
        }
    }

    public static void iP(Context context) {
        try {
            long jB = de.a(context).b();
            long jCurrentTimeMillis = (System.currentTimeMillis() - jB) - (((long) h.a(context, "re_po_rt").c(de.f16687h, 12)) * 3600000);
            if (jB < 1 || jCurrentTimeMillis > 0) {
                n.a().a(new cv(context));
            }
        } catch (Throwable unused) {
        }
    }

    public static void init(Context context, final IWeaponInitParams iWeaponInitParams) {
        try {
            Context applicationContext = context.getApplicationContext();
            mContext = applicationContext;
            if (applicationContext instanceof Application) {
                n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.WeaponHI.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            WeaponHI.mParams = iWeaponInitParams;
                            WeaponHI.sKSAppkey = iWeaponInitParams.getAppKey();
                            WeaponHI.sKSSecKey = iWeaponInitParams.getSecKey();
                            WeaponHI.sKSSdkver = "5.0.7";
                            WeaponHI.hostVersionName = bg.q(WeaponHI.mContext);
                            WeaponHI.sKDeviceId = iWeaponInitParams.getDeviceId();
                            WeaponHI.skProductName = iWeaponInitParams.getProductName();
                            WeaponHI.sUserId = iWeaponInitParams.getUserId();
                            WeaponHI.sChannel = iWeaponInitParams.getChannel();
                            WeaponHI.as = iWeaponInitParams.getAPPLISTSwitch();
                            WeaponHI.cookieData = bg.B(WeaponHI.mContext);
                            try {
                                h hVarA = h.a(WeaponHI.mContext, "re_po_rt");
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("k", cl.m());
                                jSONObject.put("d", cl.b(WeaponHI.mContext));
                                jSONObject.put("a", bg.q(WeaponHI.mContext));
                                jSONObject.put("p", bg.s(WeaponHI.mContext));
                                jSONObject.put("s", "5.0.7");
                                jSONObject.put("n", TextUtils.isEmpty(hVarA.a(de.f16686g)) ? 1 : 0);
                                WeaponHI.encryENV = new bm(WeaponHI.mContext).c(jSONObject.toString());
                                String strA = hVarA.a(de.f16698s);
                                if (!TextUtils.isEmpty(strA)) {
                                    WeaponHI.isList = Arrays.asList(strA.split("\\|"));
                                    WeaponHI.ii = hVarA.c(de.f16699t, 5);
                                }
                            } catch (Throwable unused) {
                            }
                            WeaponHI.init(WeaponHI.sKSAppkey, WeaponHI.sKSSecKey, iWeaponInitParams.getPrivacySwitch());
                        } catch (Throwable unused2) {
                        }
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void init(String str, String str2, boolean z2) {
        try {
            h.a(mContext, "re_po_rt").a("a1_p_s_p_s", Boolean.valueOf(z2));
            n.a();
            bs.a(mContext);
            br.a(mContext);
        } catch (Exception unused) {
        }
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.WeaponHI.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    q qVarA = q.a(WeaponHI.mContext);
                    if (qVarA == null) {
                        return;
                    }
                    qVarA.a();
                } catch (Exception unused2) {
                }
            }
        });
    }

    public static void setPS(final boolean z2) {
        try {
            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.WeaponHI.1
                @Override // java.lang.Runnable
                public final void run() {
                    Context context = WeaponHI.mContext;
                    if (context != null) {
                        h hVarA = h.a(context, "re_po_rt");
                        boolean z3 = z2;
                        if (!z3) {
                            hVarA.a("a1_p_s_p_s_c_b", Boolean.valueOf(z3));
                            return;
                        }
                        if (hVarA.e("a1_p_s_p_s_c_b")) {
                            return;
                        }
                        hVarA.a("a1_p_s_p_s_c_b", Boolean.valueOf(z2));
                        try {
                            if (hVarA.c(de.bi, 1) == 1) {
                                da.a(WeaponHI.mContext).a(103);
                                db.a(WeaponHI.mContext).a(103);
                                cz.a(WeaponHI.mContext).a(103, 0);
                                cx.a(WeaponHI.mContext).a(103);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        } catch (Exception unused) {
        }
    }
}
