package com.xiaomi.httpdns.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.alibaba.android.arouter.utils.Consts;
import com.xiaomi.httpdns.cache.DnsCacheManager;
import com.xiaomi.httpdns.data.MiDns;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import okhttp3.Dns;

/* JADX INFO: loaded from: classes8.dex */
public class IpUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f7387a = Pattern.compile("^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])$");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f7388b = new ConcurrentHashMap<>();

    public static String a(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            sb.append(strArr[i]);
            if (i != strArr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    @WorkerThread
    public static int b(String str) {
        try {
            int i = 0;
            for (InetAddress inetAddress : InetAddress.getAllByName(str)) {
                if (inetAddress instanceof Inet4Address) {
                    i |= 1;
                } else if (inetAddress instanceof Inet6Address) {
                    i |= 2;
                }
            }
            return i;
        } catch (UnknownHostException e) {
            e.getMessage();
            return 0;
        }
    }

    public static boolean c(String str) {
        Boolean boolValueOf;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        ConcurrentHashMap<String, Boolean> concurrentHashMap = f7388b;
        Boolean bool = concurrentHashMap.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        if (str.contains(":")) {
            boolValueOf = Boolean.FALSE;
        } else {
            z = str.contains(Consts.DOT) ? !f7387a.matcher(str).matches() : false;
            boolValueOf = Boolean.valueOf(z);
        }
        concurrentHashMap.put(str, boolValueOf);
        return z;
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return f7387a.matcher(str).matches();
    }

    public static String a(@NonNull String[] strArr, @NonNull String[] strArr2) {
        StringBuilder sb = new StringBuilder();
        sb.append("MiIps:[");
        int length = strArr.length;
        int i = 0;
        while (true) {
            String str = ",";
            if (i >= length) {
                break;
            }
            if (i == length - 1) {
                str = strArr[i];
            } else {
                sb.append(strArr[i]);
            }
            sb.append(str);
            i++;
        }
        sb.append("]");
        sb.append("   LocalIps:[");
        int length2 = strArr2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            if (i2 == length2 - 1) {
                sb.append(strArr2[i2]);
            } else {
                sb.append(strArr2[i2]);
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static List<InetAddress> a(String str, String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : strArr) {
                if (!TextUtils.isEmpty(str2)) {
                    arrayList.add(InetAddress.getByAddress(str, InetAddress.getByName(str2).getAddress()));
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
        }
        return Dns.SYSTEM.lookup(str);
    }

    public static String a(@NonNull String str) {
        boolean z;
        DnsCacheManager dnsCacheManager = DnsCacheManager.Holder.f7340a;
        MiDns miDnsC = dnsCacheManager.c(str);
        String[] strArrA = miDnsC != null ? miDnsC.a() : null;
        if (strArrA != null && strArrA.length != 0) {
            MiDns miDnsA = dnsCacheManager.a(str);
            String[] strArrA2 = miDnsA != null ? miDnsA.a() : null;
            if (strArrA2 != null && strArrA2.length != 0) {
                if (strArrA2.length > strArrA.length) {
                    return a(strArrA, strArrA2);
                }
                for (String str2 : strArrA2) {
                    int length = strArrA.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            z = false;
                            break;
                        }
                        if (strArrA[i].equals(str2)) {
                            z = true;
                            break;
                        }
                        i++;
                    }
                    if (!z) {
                        return a(strArrA, strArrA2);
                    }
                }
            }
        }
        return null;
    }

    public static int a() throws SocketException {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        int i = 0;
        while (networkInterfaces.hasMoreElements()) {
            Iterator<InterfaceAddress> it = networkInterfaces.nextElement().getInterfaceAddresses().iterator();
            while (it.hasNext()) {
                InetAddress address = it.next().getAddress();
                if (address.isLoopbackAddress() || address.isLinkLocalAddress() || address.isAnyLocalAddress()) {
                    if (address instanceof Inet4Address) {
                        i |= 1;
                    } else if (address instanceof Inet6Address) {
                        i |= 2;
                    }
                }
            }
        }
        return i;
    }
}
