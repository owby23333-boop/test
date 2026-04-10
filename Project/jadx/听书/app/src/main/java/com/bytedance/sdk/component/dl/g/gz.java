package com.bytedance.sdk.component.dl.g;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public final class gz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gz f628a;
    public static final gz dl;
    public static final gz e;
    public static final gz fo;
    private static final Map<String, gz> fv;
    public static final gz g;
    public static final gz gc;
    public static final gz gz;
    public static final gz i;
    public static final gz kb;
    public static final gz ls;
    public static final gz m;
    public static final gz pf;
    public static final gz uy;
    public static final gz v;
    public static final gz wp;
    static final Comparator<String> z;
    final String p;

    static {
        Comparator<String> comparator = new Comparator<String>() { // from class: com.bytedance.sdk.component.dl.g.gz.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public int compare(String str, String str2) {
                int iMin = Math.min(str.length(), str2.length());
                for (int i2 = 4; i2 < iMin; i2++) {
                    char cCharAt = str.charAt(i2);
                    char cCharAt2 = str2.charAt(i2);
                    if (cCharAt != cCharAt2) {
                        return cCharAt < cCharAt2 ? -1 : 1;
                    }
                }
                int length = str.length();
                int length2 = str2.length();
                if (length != length2) {
                    return length < length2 ? -1 : 1;
                }
                return 0;
            }
        };
        z = comparator;
        fv = new TreeMap(comparator);
        g = z("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        dl = z("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        f628a = z("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        gc = z("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        m = z("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        e = z("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        gz = z("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        fo = z("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        uy = z("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        kb = z("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        wp = z("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        i = z("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        v = z("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        pf = z("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        ls = z("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    }

    public static synchronized gz z(String str) {
        gz gzVar;
        Map<String, gz> map = fv;
        gzVar = map.get(str);
        if (gzVar == null) {
            gzVar = new gz(str);
            map.put(str, gzVar);
        }
        return gzVar;
    }

    static List<gz> z(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(z(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private gz(String str) {
        str.getClass();
        this.p = str;
    }

    private static gz z(String str, int i2) {
        return z(str);
    }

    public String z() {
        return this.p;
    }

    public String toString() {
        return this.p;
    }
}
