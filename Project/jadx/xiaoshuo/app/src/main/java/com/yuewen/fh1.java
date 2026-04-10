package com.yuewen;

import android.net.Uri;
import android.text.TextUtils;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

/* JADX INFO: loaded from: classes2.dex */
public class fh1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f11127a = ".duokan.com";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ boolean f11128b = false;

    public static void a(HttpResponse httpResponse) {
        HttpEntity entity;
        if (httpResponse == null || (entity = httpResponse.getEntity()) == null) {
            return;
        }
        try {
            entity.getContent().close();
        } catch (Exception unused) {
        }
        try {
            entity.consumeContent();
        } catch (Exception unused2) {
        }
    }

    public static String b() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            String string = null;
            String string2 = null;
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress()) {
                        if (inetAddressNextElement instanceof Inet4Address) {
                            string2 = inetAddressNextElement.getHostAddress().toString();
                        } else if (inetAddressNextElement instanceof Inet6Address) {
                            string = inetAddressNextElement.getHostAddress().toString();
                        }
                        if (!TextUtils.isEmpty(string2)) {
                            return string2;
                        }
                    }
                }
            }
            return string;
        } catch (SocketException unused) {
            return null;
        }
    }

    public static String c(String str) {
        int iLastIndexOf;
        if (str != null && (iLastIndexOf = str.lastIndexOf(46)) >= 0 && iLastIndexOf < str.length() - 1) {
            String strSubstring = str.substring(iLastIndexOf + 1);
            if (strSubstring.equalsIgnoreCase("txt")) {
                return "text/plain";
            }
            if (strSubstring.equalsIgnoreCase("epub")) {
                return "application/epub+zip";
            }
            if (strSubstring.equalsIgnoreCase("zip")) {
                return "application/zip";
            }
            if (strSubstring.equalsIgnoreCase("rar")) {
                return "application/x-rar-compressed";
            }
        }
        return null;
    }

    public static String d(HttpResponse httpResponse) {
        String strGroup;
        Header firstHeader = httpResponse.getFirstHeader("Content-Type");
        if (firstHeader != null) {
            Matcher matcher = Pattern.compile(".*charset\\=(.*)", 2).matcher(firstHeader.getValue());
            if (matcher.matches() && matcher.groupCount() > 0 && (strGroup = matcher.group(1)) != null && strGroup.length() > 0) {
                return strGroup;
            }
        }
        return "utf-8";
    }

    public static boolean e(String str) {
        return !Pattern.compile("[a-zA-Z0-9\\-\\.\\_\\~\\[\\:\\/\\?\\#\\[\\]\\@\\!\\$\\&\\'\\(\\)\\*\\+\\,\\;\\=\\%]+").matcher(str).matches();
    }

    public static boolean f(String str) {
        return !Pattern.compile("\\p{ASCII}*").matcher(str).matches();
    }

    public static boolean g(String str) {
        return !TextUtils.isEmpty(str) && str.endsWith(".duokan.com");
    }

    public static String h(HttpResponse httpResponse, String str) {
        if (str != null && !e(str)) {
            return str;
        }
        try {
            return Uri.encode(new String(str.getBytes("ISO-8859-1"), d(httpResponse)), ":/?#[]@!$&'()*+,;=");
        } catch (Exception unused) {
            return str;
        }
    }
}
