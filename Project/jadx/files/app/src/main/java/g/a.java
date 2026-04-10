package g;

import android.text.TextUtils;
import com.repack.bun.lib.sysParamters;
import com.umeng.message.proguard.ad;

/* JADX INFO: compiled from: C0013a.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String a;

    public static String a() {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        StringBuilder sbA = y.b.a("miitmdid(sdkv_");
        sbA.append(sysParamters.b().a());
        sbA.append(ad.f20406s);
        String string = sbA.toString();
        a = string;
        return string;
    }
}
