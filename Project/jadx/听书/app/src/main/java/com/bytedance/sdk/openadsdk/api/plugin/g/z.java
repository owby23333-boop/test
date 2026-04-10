package com.bytedance.sdk.openadsdk.api.plugin.g;

import com.funny.audio.core.utils.FileUtils;
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
public final class z implements HostnameVerifier {
    public static final z z = new z();
    private static final Pattern g = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    private z() {
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return z(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    private boolean z(String str, X509Certificate x509Certificate) {
        if (z(str)) {
            return g(str, x509Certificate);
        }
        return dl(str, x509Certificate);
    }

    private boolean g(String str, X509Certificate x509Certificate) {
        List<String> listZ = z(x509Certificate, 7);
        int size = listZ.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(listZ.get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean dl(String str, X509Certificate x509Certificate) {
        String strZ;
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> listZ = z(x509Certificate, 2);
        int size = listZ.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            if (z(lowerCase, listZ.get(i))) {
                return true;
            }
            i++;
            z2 = true;
        }
        if (z2 || (strZ = new g(x509Certificate.getSubjectX500Principal()).z("cn")) == null) {
            return false;
        }
        return z(lowerCase, strZ);
    }

    private static boolean z(String str) {
        return g.matcher(str).matches();
    }

    private static List<String> z(X509Certificate x509Certificate, int i) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    private boolean z(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(FileUtils.FILE_EXTENSION_SEPARATOR) && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(FileUtils.FILE_EXTENSION_SEPARATOR) && !str2.endsWith("..")) {
            if (!str.endsWith(FileUtils.FILE_EXTENSION_SEPARATOR)) {
                str = str + '.';
            }
            if (!str2.endsWith(FileUtils.FILE_EXTENSION_SEPARATOR)) {
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
