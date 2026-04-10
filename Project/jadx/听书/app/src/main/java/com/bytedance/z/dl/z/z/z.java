package com.bytedance.z.dl.z.z;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.bytedance.sdk.component.utils.wp;
import com.umeng.analytics.pro.an;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static boolean g;
    private static InterfaceC0228z z;

    /* JADX INFO: renamed from: com.bytedance.z.dl.z.z.z$z, reason: collision with other inner class name */
    public interface InterfaceC0228z {
        boolean dl();

        boolean g();

        boolean z();
    }

    public static String z(String str, List<Pair<String, String>> list) {
        if (TextUtils.isEmpty(str) || z == null || g) {
            return str;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            Uri uri = Uri.parse(str);
            z(uri, linkedHashMap);
            LinkedList linkedList = new LinkedList();
            z(linkedHashMap, linkedList, "device_id");
            z(linkedHashMap, linkedList, an.ai);
            z(linkedHashMap, linkedList, an.F);
            z(linkedHashMap, linkedList, "uuid");
            z(linkedHashMap, linkedList, "openudid");
            String strZ = z((List<Pair<String, List<String>>>) linkedList, false, "UTF-8");
            if (TextUtils.isEmpty(strZ)) {
                return str;
            }
            byte[] bytes = strZ.getBytes();
            byte[] bArrA = TTEncryptUtils.a(bytes, bytes.length);
            if (bArrA == null) {
                return str;
            }
            String strEncodeToString = Base64.encodeToString(bArrA, 2);
            LinkedList linkedList2 = new LinkedList();
            if (z.z()) {
                LinkedList linkedList3 = new LinkedList();
                linkedList3.add(strEncodeToString);
                linkedList2.add(new Pair("ss_queries", linkedList3));
            }
            if (z.g() && list != null) {
                list.add(new Pair<>("X-SS-QUERIES", z(strEncodeToString, "UTF-8")));
            }
            if (!linkedHashMap.isEmpty()) {
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    if (entry != null) {
                        linkedList2.add(new Pair(entry.getKey(), entry.getValue()));
                    }
                }
            }
            return z(uri.getScheme(), uri.getHost(), uri.getPort(), uri.getPath(), z((List<Pair<String, List<String>>>) linkedList2, true, "UTF-8"), uri.getFragment()).toString();
        } catch (Throwable th) {
            wp.z(th);
            return str;
        }
    }

    private static boolean z(Map<String, List<String>> map, List<Pair<String, List<String>>> list, String str) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(str) || list == null || !map.containsKey(str)) {
            return false;
        }
        list.add(new Pair<>(str, map.get(str)));
        if (z.dl()) {
            return true;
        }
        map.remove(str);
        return true;
    }

    public static void z(Uri uri, Map<String, List<String>> map) throws IOException {
        if (uri == null) {
            throw new IOException("parseUrl url is null !!!");
        }
        if (map != null) {
            try {
                String query = uri.getQuery();
                if (query != null) {
                    for (String str : query.split("&")) {
                        int iIndexOf = str.indexOf("=");
                        if (iIndexOf >= 0) {
                            String strDecode = URLDecoder.decode(str.substring(0, iIndexOf), "UTF-8");
                            List<String> linkedList = map.get(strDecode);
                            if (linkedList == null) {
                                linkedList = new LinkedList<>();
                            }
                            linkedList.add(URLDecoder.decode(str.substring(iIndexOf + 1), "UTF-8"));
                            map.put(strDecode, linkedList);
                        } else {
                            String strDecode2 = URLDecoder.decode(str, "UTF-8");
                            List<String> linkedList2 = map.get(strDecode2);
                            if (linkedList2 == null) {
                                linkedList2 = new LinkedList<>();
                            }
                            linkedList2.add("");
                            map.put(strDecode2, linkedList2);
                        }
                    }
                }
            } catch (Throwable th) {
                wp.z(th);
                throw new IOException("parseUrl url is null !!!");
            }
        }
    }

    private static Uri z(String str, String str2, int i, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        if (str2 != null) {
            if (str != null) {
                sb.append(str);
                sb.append("://");
            }
            sb.append(str2);
            if (i > 0) {
                sb.append(':');
                sb.append(i);
            }
        }
        if (str3 == null || !str3.startsWith("/")) {
            sb.append('/');
        }
        if (str3 != null) {
            sb.append(str3);
        }
        if (str4 != null) {
            sb.append('?');
            sb.append(str4);
        }
        if (str5 != null) {
            sb.append('#');
            sb.append(str5);
        }
        return Uri.parse(sb.toString());
    }

    private static String z(List<Pair<String, List<String>>> list, boolean z2, String str) {
        StringBuilder sb = new StringBuilder();
        for (Pair<String, List<String>> pair : list) {
            String strZ = (String) pair.first;
            if (z2) {
                strZ = z((String) pair.first, str);
            }
            List<String> list2 = (List) pair.second;
            if (list2 != null && list2.size() > 0) {
                for (String strZ2 : list2) {
                    if (z2) {
                        strZ2 = strZ2 != null ? z(strZ2, str) : "";
                    }
                    if (sb.length() > 0) {
                        sb.append("&");
                    }
                    sb.append(strZ);
                    sb.append("=");
                    sb.append(strZ2);
                }
            }
        }
        return sb.toString();
    }

    private static String z(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
