package com.kwad.components.core.g;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.WindowManager;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.l.a.d;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.r;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.sdk.commercial.c.a {
    public int Qh;
    public boolean Qi;
    public boolean Qj;
    public boolean Ql;
    public String Qm;
    public boolean Qn;
    public long Qp;
    public double Qq;
    public boolean Qr;
    public List<String> Qs;
    public double Qt;
    public int Qu;
    public int Qv;
    public int Qw;
    public int Qx;
    public int defaultType;
    public int Qk = -1;
    public int Qo = -1;
    private boolean Qy = false;
    private boolean Qz = false;
    private boolean QA = false;
    private Context mContext = ServiceProvider.Pp();

    private b() {
    }

    public static b qi() {
        b bVar = new b();
        bVar.Qh = br.dR(bVar.mContext);
        bVar.Qm = ap(bVar.mContext);
        bVar.Qk = as(bVar.mContext);
        bVar.Qn = qj();
        bVar.Qo = SystemUtil.dQ(bVar.mContext);
        bVar.Qp = br.dS(bVar.mContext);
        bVar.Qq = SystemUtil.dP(bVar.mContext);
        bVar.Qx = aq(bVar.mContext);
        bVar.Qv = getScreenHeight(bVar.mContext);
        bVar.Qw = getScreenWidth(bVar.mContext);
        a(bVar);
        bVar.defaultType = 1;
        return bVar;
    }

    private static void a(b bVar) {
        try {
            String strGs = e.Gs();
            if (TextUtils.isEmpty(strGs)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strGs);
            if (jSONObject.optBoolean("enableSlidingTrajectory", false)) {
                Pair<List<String>, Double> pairEo = com.kwad.sdk.core.e.Eo();
                bVar.Qs = (List) pairEo.first;
                bVar.Qt = ((Double) pairEo.second).doubleValue();
                bVar.Qy = true;
            }
            if (jSONObject.optBoolean("enableAccessibility", false)) {
                bVar.Qi = ((Boolean) br.ee(bVar.mContext).first).booleanValue();
                bVar.Qj = ((Boolean) br.ee(bVar.mContext).second).booleanValue();
                bVar.Qz = true;
            }
            if (jSONObject.optBoolean("enableKeyguardSecure", false)) {
                bVar.Qr = ar(bVar.mContext);
                bVar.QA = true;
            }
        } catch (Throwable th) {
            c.printStackTrace(th);
        }
    }

    private static String ap(Context context) {
        int iD = ao.d(context, bd.dt(context), bc.useNetworkStateDisable());
        return iD != 1 ? iD != 2 ? iD != 3 ? "unknown" : "CUCC" : "CTCC" : "CMCC";
    }

    private static int getScreenWidth(Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    private static int getScreenHeight(Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private static int aq(Context context) {
        if (context == null) {
            return -1;
        }
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    private static boolean ar(Context context) {
        try {
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (keyguardManager != null) {
                return keyguardManager.isKeyguardSecure();
            }
            return false;
        } catch (Throwable th) {
            c.printStackTrace(th);
            return false;
        }
    }

    private static boolean qj() {
        d dVarPQ = r.PQ();
        return dVarPQ != null && dVarPQ.aWI == 1;
    }

    public final b aE(boolean z) {
        this.Ql = z;
        return this;
    }

    public final b aH(int i) {
        this.Qu = i;
        return this;
    }

    private static int as(Context context) {
        if (e.ai(512L)) {
            return -1;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, intentFilter);
            if (intentRegisterReceiver == null) {
                return -1;
            }
            int intExtra = intentRegisterReceiver.getIntExtra("plugged", -1);
            int i = 2;
            if (intExtra != 2) {
                i = 1;
                if (intExtra != 1) {
                    i = 4;
                    if (intExtra != 4) {
                        return intExtra == 0 ? 0 : -1;
                    }
                }
            }
            return i;
        } catch (Exception e) {
            c.printStackTrace(e);
            return -1;
        }
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        return b(this);
    }

    private static JSONObject b(b bVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            aa.putValue(jSONObject, "c_batterylevel", bVar.Qh);
            aa.putValue(jSONObject, "c_charging", bVar.Qk);
            aa.putValue(jSONObject, "is_cheat_user", bVar.Ql);
            aa.putValue(jSONObject, "c_operator", bVar.Qm);
            aa.putValue(jSONObject, "t_root", bVar.Qn);
            aa.putValue(jSONObject, "c_screenlight", bVar.Qo);
            aa.putValue(jSONObject, "c_total_memory", bVar.Qp);
            aa.putValue(jSONObject, "c_volume", bVar.Qq);
            aa.putValue(jSONObject, "c_screen_height", bVar.Qv);
            aa.putValue(jSONObject, "c_screen_width", bVar.Qw);
            aa.putValue(jSONObject, "density_dpi", bVar.Qx);
            aa.putValue(jSONObject, "default_type", bVar.defaultType);
            if (bVar.Qy) {
                if (!bVar.Qs.isEmpty()) {
                    aa.putValue(jSONObject, "s_origin_points", bVar.Qs);
                }
                double d = bVar.Qt;
                if (d != 0.0d) {
                    aa.putValue(jSONObject, "s_swipe_max_curvature", d);
                }
            }
            if (bVar.Qz) {
                aa.putValue(jSONObject, "t_accessibility_enabled", bVar.Qi);
                aa.putValue(jSONObject, "t_accessibility_service_existed", bVar.Qj);
            }
            if (bVar.QA) {
                aa.putValue(jSONObject, "t_is_keyguard_secure", bVar.Qr);
            }
        } catch (Throwable th) {
            c.printStackTrace(th);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        a(this, jSONObject);
    }

    private static void a(b bVar, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                bVar.Qh = jSONObject.optInt("c_batterylevel");
                bVar.Qi = jSONObject.optBoolean("t_accessibility_enabled");
                bVar.Qj = jSONObject.optBoolean("t_accessibility_service_existed");
                bVar.Qk = jSONObject.optInt("c_charging");
                bVar.Ql = jSONObject.optBoolean("is_cheat_user");
                bVar.Qm = jSONObject.optString("c_operator");
                bVar.Qn = jSONObject.optBoolean("t_root");
                bVar.Qo = jSONObject.optInt("c_screenlight");
                bVar.Qp = jSONObject.optLong("c_total_memory");
                bVar.Qq = jSONObject.optDouble("c_volume");
                bVar.Qr = jSONObject.optBoolean("t_is_keyguard_secure");
                bVar.Qs = aa.h(jSONObject.optJSONArray("s_origin_points"));
                bVar.Qt = jSONObject.optDouble("s_swipe_max_curvature");
                bVar.Qx = jSONObject.optInt("density_dpi");
                bVar.Qv = jSONObject.optInt("c_screen_height");
                bVar.Qw = jSONObject.optInt("c_screen_width");
                bVar.defaultType = jSONObject.optInt("default_type");
            } catch (Throwable th) {
                c.printStackTrace(th);
            }
        }
    }
}
