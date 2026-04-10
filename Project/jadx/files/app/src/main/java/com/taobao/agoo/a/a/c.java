package com.taobao.agoo.a.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.j;
import com.taobao.accs.utl.p;
import com.taobao.accs.utl.q;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class c extends b {
    public static final String JSON_CMD_REGISTER = "register";
    public String a;
    public String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f18348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f18349d = String.valueOf(221);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f18350f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f18351g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f18352h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f18353i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f18354j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f18355k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f18356l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f18357m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f18358n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f18359o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f18360p;

    public byte[] a() {
        try {
            String string = new q.a().a(b.JSON_CMD, this.f18347e).a(Constants.KEY_APP_KEY, this.a).a("utdid", this.b).a("appVersion", this.f18348c).a(Constants.KEY_SDK_VERSION, this.f18349d).a(Constants.KEY_TTID, this.f18350f).a("packageName", this.f18351g).a("notifyEnable", this.f18352h).a("romInfo", this.f18353i).a("c0", this.f18354j).a("c1", this.f18355k).a("c2", this.f18356l).a("c3", this.f18357m).a("c4", this.f18358n).a("c5", this.f18359o).a("c6", this.f18360p).a().toString();
            ALog.i("RegisterDO", "buildData", "data", string);
            return string.getBytes(com.anythink.expressad.foundation.g.a.bN);
        } catch (Throwable th) {
            ALog.e("RegisterDO", "buildData", th, new Object[0]);
            return null;
        }
    }

    public static byte[] a(Context context, String str, String str2) {
        c cVar;
        String strK;
        String packageName;
        String str3;
        try {
            strK = UtilityImpl.k(context);
            packageName = context.getPackageName();
            str3 = GlobalClientInfo.getInstance(context).getPackageInfo().versionName;
        } catch (Throwable th) {
            th = th;
            cVar = null;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(strK) && !TextUtils.isEmpty(str3)) {
            cVar = new c();
            try {
                cVar.f18347e = JSON_CMD_REGISTER;
                cVar.a = str;
                cVar.b = strK;
                cVar.f18348c = str3;
                cVar.f18350f = str2;
                cVar.f18351g = packageName;
                cVar.f18354j = Build.BRAND;
                cVar.f18355k = Build.MODEL;
                cVar.f18352h = j.d(context);
                UtilityImpl.a(context, Constants.SP_CHANNEL_FILE_NAME, cVar.f18352h);
                cVar.f18353i = new p().a();
            } catch (Throwable th2) {
                th = th2;
                try {
                    ALog.w("RegisterDO", "buildRegister", th.getMessage());
                    if (cVar == null) {
                        return null;
                    }
                } finally {
                    if (cVar != null) {
                        cVar.a();
                    }
                }
            }
            return cVar.a();
        }
        ALog.e("RegisterDO", "buildRegister param null", Constants.KEY_APP_KEY, str, "utdid", strK, "appVersion", str3);
        return null;
    }
}
