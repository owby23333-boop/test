package com.alipay.sdk.m.l;

import android.text.TextUtils;
import com.alipay.sdk.m.o.b;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f1848a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b.C0032b f1849b;
    public static final b.C0032b c;
    public static List<b.C0032b> d;

    static {
        b.C0032b c0032b = new b.C0032b("com.eg.android.AlipayGphone", 73, com.alipay.sdk.m.n.a.m);
        f1849b = c0032b;
        c = new b.C0032b("hk.alipay.wallet", 40, "e6b1bdcb890370f2f2419fe06d0fdf7628ad0083d52da1ecfe991164711bbf9297e75353de96f1740695d07610567b1240549af9cbd87d06919ac31c859ad37ab6907c311b4756e1e208775989a4f691bff4bbbc58174d2a96b1d0d970a05114d7ee57dfc33b1bafaf6e0d820e838427018b6435f903df04ba7fd34d73f843df9434b164e0220baabb10c8978c3f4c6b7da79d8220a968356d15090dea07df9606f665cbec14d218dd3d691cce2866a58840971b6a57b76af88b1a65fdffd2c080281a6ab20be5879e0330eb7ff70871ce684e7174ada5dc3159c461375a0796b17ce7beca83cf34f65976d237aee993db48d34a4e344f4d8b7e99119168bdd7");
        d = Collections.singletonList(c0032b);
    }

    public static void a(String str) {
        f1848a = str;
        str.hashCode();
        if (str.equals("hk")) {
            d = Collections.singletonList(c);
        } else {
            d = Collections.singletonList(f1849b);
        }
    }

    public static boolean b() {
        return TextUtils.isEmpty(f1848a) || TextUtils.equals("cn", f1848a);
    }

    public static String a() {
        return f1848a;
    }
}
