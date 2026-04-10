package com.kwad.sdk.core.config;

import android.text.TextUtils;
import java.net.URI;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String[] abn = {"gifshow.com", "kuaishou.com", "static.yximgs.com"};

    public static boolean aO(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String host = new URI(str).getHost();
            if (bj(host)) {
                return true;
            }
            return bk(host);
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean bj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : abn) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean bk(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<String> it = d.ul().iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }
}
