package com.bytedance.sdk.component.d.bf.e.zk;

import androidx.webkit.ProxyConfig;
import com.alibaba.android.arouter.utils.Consts;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes.dex */
public final class ga implements HostnameVerifier {
    public static final ga e = new ga();

    private ga() {
    }

    private boolean bf(String str, X509Certificate x509Certificate) {
        List<String> listE = e(x509Certificate, 7);
        int size = listE.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(listE.get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean d(String str, X509Certificate x509Certificate) {
        String strE;
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> listE = e(x509Certificate, 2);
        int size = listE.size();
        int i = 0;
        boolean z = false;
        while (i < size) {
            if (e(lowerCase, listE.get(i))) {
                return true;
            }
            i++;
            z = true;
        }
        if (z || (strE = new tg(x509Certificate.getSubjectX500Principal()).e("cn")) == null) {
            return false;
        }
        return e(lowerCase, strE);
    }

    public boolean e(String str, X509Certificate x509Certificate) {
        return com.bytedance.sdk.component.d.bf.e.d.d(str) ? bf(str, x509Certificate) : d(str, x509Certificate);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return e(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    public static List<String> e(X509Certificate x509Certificate) {
        List<String> listE = e(x509Certificate, 7);
        List<String> listE2 = e(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(listE.size() + listE2.size());
        arrayList.addAll(listE);
        arrayList.addAll(listE2);
        return arrayList;
    }

    private static List<String> e(X509Certificate x509Certificate, int i) {
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

    public boolean e(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(Consts.DOT) && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(Consts.DOT) && !str2.endsWith("..")) {
            if (!str.endsWith(Consts.DOT)) {
                str = str + '.';
            }
            if (!str2.endsWith(Consts.DOT)) {
                str2 = str2 + '.';
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (!lowerCase.contains(ProxyConfig.MATCH_ALL_SCHEMES)) {
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
