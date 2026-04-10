package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_if122.bykvm_19do.bykvm_19do;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.util.HttpConstant;
import com.bytedance.mapplog.util.TTEncryptUtils;
import com.umeng.analytics.pro.am;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static InterfaceC0064a a;
    private static boolean b;

    /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_new1.bykvm_if122.bykvm_19do.bykvm_19do.a$a, reason: collision with other inner class name */
    public interface InterfaceC0064a {
        boolean a();

        boolean b();

        boolean c();
    }

    private static Uri a(String str, String str2, int i2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        if (str2 != null) {
            if (str != null) {
                sb.append(str);
                sb.append(HttpConstant.SCHEME_SPLIT);
            }
            sb.append(str2);
            if (i2 > 0) {
                sb.append(':');
                sb.append(i2);
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

    private static String a(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static String a(String str, List<Pair<String, String>> list) {
        if (TextUtils.isEmpty(str) || a == null || b) {
            return str;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            Uri uri = Uri.parse(str);
            a(uri, linkedHashMap);
            LinkedList linkedList = new LinkedList();
            a(linkedHashMap, linkedList, "device_id");
            a(linkedHashMap, linkedList, am.ai);
            a(linkedHashMap, linkedList, "device_brand");
            a(linkedHashMap, linkedList, "uuid");
            a(linkedHashMap, linkedList, "openudid");
            String strA = a((List<Pair<String, List<String>>>) linkedList, false, "UTF-8");
            if (TextUtils.isEmpty(strA)) {
                return str;
            }
            byte[] bytes = strA.getBytes();
            byte[] bArrA = TTEncryptUtils.a(bytes, bytes.length);
            if (bArrA == null) {
                return str;
            }
            String strEncodeToString = Base64.encodeToString(bArrA, 2);
            LinkedList linkedList2 = new LinkedList();
            if (a.b()) {
                LinkedList linkedList3 = new LinkedList();
                linkedList3.add(strEncodeToString);
                linkedList2.add(new Pair("ss_queries", linkedList3));
            }
            if (a.c() && list != null) {
                list.add(new Pair<>("X-SS-QUERIES", a(strEncodeToString, "UTF-8")));
            }
            if (!linkedHashMap.isEmpty()) {
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    if (entry != null) {
                        linkedList2.add(new Pair(entry.getKey(), entry.getValue()));
                    }
                }
            }
            return a(uri.getScheme(), uri.getHost(), uri.getPort(), uri.getPath(), a((List<Pair<String, List<String>>>) linkedList2, true, "UTF-8"), uri.getFragment()).toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    private static String a(List<Pair<String, List<String>>> list, boolean z2, String str) {
        StringBuilder sb = new StringBuilder();
        for (Pair<String, List<String>> pair : list) {
            String strA = (String) pair.first;
            if (z2) {
                strA = a(strA, str);
            }
            List<String> list2 = (List) pair.second;
            if (list2 != null && list2.size() > 0) {
                for (String strA2 : list2) {
                    if (z2) {
                        strA2 = strA2 != null ? a(strA2, str) : "";
                    }
                    if (sb.length() > 0) {
                        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
                    }
                    sb.append(strA);
                    sb.append("=");
                    sb.append(strA2);
                }
            }
        }
        return sb.toString();
    }

    public static void a(Uri uri, Map<String, List<String>> map) throws IOException {
        if (uri == null) {
            throw new IOException("parseUrl url is null !!!");
        }
        if (map != null) {
            try {
                String query = uri.getQuery();
                if (query != null) {
                    for (String str : query.split(DispatchConstants.SIGN_SPLIT_SYMBOL)) {
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
                th.printStackTrace();
                throw new IOException("parseUrl url is null !!!");
            }
        }
    }

    private static boolean a(Map<String, List<String>> map, List<Pair<String, List<String>>> list, String str) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(str) || list == null || !map.containsKey(str)) {
            return false;
        }
        list.add(new Pair<>(str, map.get(str)));
        if (!a.a()) {
            map.remove(str);
        }
        return true;
    }
}
