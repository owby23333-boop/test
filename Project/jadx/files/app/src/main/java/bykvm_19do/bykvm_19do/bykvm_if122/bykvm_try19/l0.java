package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.msdk.adapter.util.Logger;

/* JADX INFO: loaded from: classes.dex */
public class l0 {
    private static String a;

    public static String a() {
        if (TextUtils.isEmpty(a)) {
            a = new String(Base64.decode("ZGV2aWNlX2lk", 0));
        }
        return a;
    }

    public static String a(String str) {
        try {
            if (!b()) {
                return str;
            }
            String strA = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().a();
            if (TextUtils.isEmpty(strA)) {
                return str;
            }
            String str2 = "AnyDoorId=" + strA;
            return Uri.parse(str).buildUpon().appendQueryParameter(a(), strA).appendQueryParameter("aid", "5001121").toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public static boolean b() {
        return Logger.isDebug() && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().w() && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().x();
    }
}
