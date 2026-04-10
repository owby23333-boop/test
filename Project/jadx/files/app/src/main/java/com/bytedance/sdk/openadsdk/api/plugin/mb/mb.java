package com.bytedance.sdk.openadsdk.api.plugin.mb;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes2.dex */
public final class mb implements HostnameVerifier {
    public static final mb mb = new mb();
    private static final Pattern ox = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    private mb() {
    }

    private boolean b(String str, X509Certificate x509Certificate) {
        String strMb;
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> listMb = mb(x509Certificate, 2);
        int size = listMb.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            if (mb(lowerCase, listMb.get(i2))) {
                return true;
            }
            i2++;
            z2 = true;
        }
        if (z2 || (strMb = new ox(x509Certificate.getSubjectX500Principal()).mb("cn")) == null) {
            return false;
        }
        return mb(lowerCase, strMb);
    }

    private boolean mb(String str, X509Certificate x509Certificate) {
        return mb(str) ? ox(str, x509Certificate) : b(str, x509Certificate);
    }

    private boolean ox(String str, X509Certificate x509Certificate) {
        List<String> listMb = mb(x509Certificate, 7);
        int size = listMb.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (str.equalsIgnoreCase(listMb.get(i2))) {
                return true;
            }
        }
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return mb(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    private static boolean mb(String str) {
        return ox.matcher(str).matches();
    }

    private static List<String> mb(X509Certificate x509Certificate, int i2) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i2 && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    private boolean mb(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(".") && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(".") && !str2.endsWith("..")) {
            if (!str.endsWith(".")) {
                str = str + '.';
            }
            if (!str2.endsWith(".")) {
                str2 = str2 + '.';
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (!lowerCase.contains("*")) {
                return str.equals(lowerCase);
            }
            if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                return false;
            }
            String strSubstring = lowerCase.substring(1);
            if (!str.endsWith(strSubstring)) {
                return false;
            }
            int length = str.length() - strSubstring.length();
            return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
        }
        return false;
    }
}
