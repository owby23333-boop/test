package com.kuaishou.weapon.p0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.text.TextUtils;
import com.arialyy.aria.core.inf.IOptionConstant;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class am {
    private static final String a = "tun";
    private static final String b = "ppp";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f16557c;

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|2|(6:34|3|42|4|40|5)|(4:6|(2:8|(4:47|12|50|48)(2:49|48))(1:45)|33|30)|13|(2:16|14)|38|18|19|33|30|(1:(0))) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONArray a() {
        /*
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L6c
            java.lang.String r3 = "cat /proc/net/route"
            java.lang.Process r2 = r2.exec(r3)     // Catch: java.lang.Throwable -> L6c
            java.io.DataInputStream r3 = new java.io.DataInputStream     // Catch: java.lang.Throwable -> L6c
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Throwable -> L6c
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L6c
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L6a
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L6a
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L6a
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L6a
            java.util.HashSet r1 = new java.util.HashSet     // Catch: java.lang.Throwable -> L68
            r1.<init>()     // Catch: java.lang.Throwable -> L68
        L28:
            java.lang.String r4 = r2.readLine()     // Catch: java.lang.Throwable -> L68
            if (r4 == 0) goto L4f
            java.lang.String r4 = com.kuaishou.weapon.p0.bn.a(r4)     // Catch: java.lang.Throwable -> L68
            java.lang.String r5 = "tun"
            boolean r5 = r4.contains(r5)     // Catch: java.lang.Throwable -> L68
            if (r5 != 0) goto L42
            java.lang.String r5 = "ppp"
            boolean r5 = r4.contains(r5)     // Catch: java.lang.Throwable -> L68
            if (r5 == 0) goto L28
        L42:
            java.lang.String r5 = "\t"
            java.lang.String[] r4 = r4.split(r5)     // Catch: java.lang.Throwable -> L68
            r5 = 0
            r4 = r4[r5]     // Catch: java.lang.Throwable -> L68
            r1.add(r4)     // Catch: java.lang.Throwable -> L68
            goto L28
        L4f:
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L68
        L53:
            boolean r4 = r1.hasNext()     // Catch: java.lang.Throwable -> L68
            if (r4 == 0) goto L61
            java.lang.Object r4 = r1.next()     // Catch: java.lang.Throwable -> L68
            r0.put(r4)     // Catch: java.lang.Throwable -> L68
            goto L53
        L61:
            r3.close()     // Catch: java.io.IOException -> L64
        L64:
            r2.close()     // Catch: java.io.IOException -> L79
            goto L79
        L68:
            r1 = r2
            goto L6d
        L6a:
            goto L6d
        L6c:
            r3 = r1
        L6d:
            if (r3 == 0) goto L74
            r3.close()     // Catch: java.io.IOException -> L73
            goto L74
        L73:
        L74:
            if (r1 == 0) goto L79
            r1.close()     // Catch: java.io.IOException -> L79
        L79:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.am.a():org.json.JSONArray");
    }

    public static boolean a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT < 21) {
                return connectivityManager.getNetworkInfo(17).isConnectedOrConnecting();
            }
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            return networkCapabilities != null && networkCapabilities.hasTransport(4);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String b() {
        String property = System.getProperty("http.proxyHost");
        return TextUtils.isEmpty(property) ? "" : property;
    }

    public static String b(Context context) {
        JSONArray jSONArrayA;
        try {
            jSONArrayA = a();
        } catch (Throwable unused) {
        }
        return jSONArrayA != null ? jSONArrayA.toString() : a(context) ? "[\"con\"]" : "";
    }

    public static int c() {
        return f16557c;
    }

    public static String d() {
        StringBuilder sb = new StringBuilder();
        try {
            f16557c = 0;
            KeyStore keyStore = KeyStore.getInstance("AndroidCAStore");
            if (keyStore != null) {
                keyStore.load(null, null);
                Enumeration<String> enumerationAliases = keyStore.aliases();
                while (enumerationAliases.hasMoreElements()) {
                    f16557c++;
                    X509Certificate x509Certificate = (X509Certificate) keyStore.getCertificate(enumerationAliases.nextElement());
                    if (x509Certificate.getIssuerDN().getName().contains("2022") || x509Certificate.getIssuerDN().getName().contains("2023") || x509Certificate.getIssuerDN().getName().contains("HttpCanary") || x509Certificate.getIssuerDN().getName().contains("macbook") || x509Certificate.getIssuerDN().getName().contains(IOptionConstant.proxy) || x509Certificate.getIssuerDN().getName().contains("Proxy") || x509Certificate.getIssuerDN().getName().contains("local") || x509Certificate.getIssuerDN().getName().contains("github")) {
                        sb.append(x509Certificate.getIssuerDN().getName());
                        sb.append(com.anythink.expressad.foundation.g.a.bQ);
                    }
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }
}
