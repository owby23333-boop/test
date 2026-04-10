package com.anythink.expressad.foundation.g.f.g;

import android.text.TextUtils;
import com.anythink.expressad.foundation.h.w;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.umeng.message.utils.HttpRequest;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    private static final String a = "e";

    public static String a(List<com.anythink.expressad.foundation.g.f.c.c> list) {
        com.anythink.expressad.foundation.g.f.c.c cVarB = b(list, "Content-Type");
        if (cVarB != null) {
            String strB = cVarB.b();
            if (!TextUtils.isEmpty(strB)) {
                String[] strArrSplit = strB.split(";");
                for (int i2 = 1; i2 < strArrSplit.length; i2++) {
                    String[] strArrSplit2 = strArrSplit[i2].trim().split("=");
                    if (strArrSplit2.length == 2 && strArrSplit2[0].equals(HttpRequest.PARAM_CHARSET)) {
                        return strArrSplit2[1];
                    }
                }
            }
        }
        return "UTF-8";
    }

    private static com.anythink.expressad.foundation.g.f.c.c b(List<com.anythink.expressad.foundation.g.f.c.c> list, String str) {
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                com.anythink.expressad.foundation.g.f.c.c cVar = list.get(i2);
                if (cVar != null && str.equals(cVar.a())) {
                    return cVar;
                }
            }
        }
        return null;
    }

    private static boolean c(List<com.anythink.expressad.foundation.g.f.c.c> list) {
        if (TextUtils.equals(a(list, DownloadUtils.ACCEPT_RANGES), "bytes")) {
            return true;
        }
        String strA = a(list, "Content-Range");
        return strA != null && strA.startsWith("bytes");
    }

    public static boolean b(List<com.anythink.expressad.foundation.g.f.c.c> list) {
        return TextUtils.equals(a(list, "Content-Encoding"), "gzip");
    }

    public static String a(List<com.anythink.expressad.foundation.g.f.c.c> list, String str) {
        com.anythink.expressad.foundation.g.f.c.c cVarB = b(list, str);
        return cVarB != null ? cVarB.b() : "";
    }

    private static void a(com.anythink.expressad.foundation.g.f.h.b bVar, String str, String str2) {
        if (bVar != null) {
            try {
                if (!w.a(str) && !w.a(str2)) {
                    bVar.a(str, str2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
