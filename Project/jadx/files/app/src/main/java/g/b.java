package g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.repack.bun.lib.sysParamters;
import g.c;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: C0018c.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public Map<String, String> a = new HashMap();

    /* JADX INFO: compiled from: C0018c.java */
    public class a implements c.a {
        public a(b bVar) {
        }
    }

    public final Map<String, String> a() {
        PackageInfo packageInfo;
        String str;
        String str2;
        String str3;
        String str4;
        if (this.a.isEmpty()) {
            Map<String, String> map = this.a;
            sysParamters sysparamtersB = sysParamters.b();
            if (TextUtils.isEmpty(sysparamtersB.a)) {
                Context contextA = v.b.a();
                if (contextA == null) {
                    str = "0.1.100";
                } else {
                    try {
                        packageInfo = contextA.getPackageManager().getPackageInfo(contextA.getPackageName(), 0);
                    } catch (Exception unused) {
                        packageInfo = null;
                    }
                    str = packageInfo == null ? null : packageInfo.versionName;
                }
                sysparamtersB.a = str;
                str2 = str;
            } else {
                str2 = sysparamtersB.a;
            }
            map.put("av", str2);
            this.a.put(com.anythink.expressad.foundation.g.a.Z, sysParamters.b().a());
            Map<String, String> map2 = this.a;
            sysParamters sysparamtersB2 = sysParamters.b();
            if (TextUtils.isEmpty(sysparamtersB2.b)) {
                String str5 = Build.MODEL;
                sysparamtersB2.b = str5;
                String strReplace = str5.replace(" ", "-");
                sysparamtersB2.b = strReplace;
                str3 = strReplace;
            } else {
                str3 = sysparamtersB2.b;
            }
            map2.put("md", str3);
            Map<String, String> map3 = this.a;
            sysParamters sysparamtersB3 = sysParamters.b();
            if (TextUtils.isEmpty(sysparamtersB3.f17842c)) {
                String strEncode = Uri.encode(Build.MANUFACTURER);
                sysparamtersB3.f17842c = strEncode;
                str4 = strEncode;
            } else {
                str4 = sysparamtersB3.f17842c;
            }
            map3.put("mf", str4);
            this.a.put("pn", sysParamters.c());
        }
        this.a.put("tm", String.valueOf(System.currentTimeMillis()));
        return this.a;
    }
}
