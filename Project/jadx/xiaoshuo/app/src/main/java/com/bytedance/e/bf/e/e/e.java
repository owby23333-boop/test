package com.bytedance.e.bf.e.e;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.alipay.sdk.m.w.a;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.dangdang.reader.utils.DangdangFileManager;
import com.fasterxml.jackson.core.JsonPointer;
import com.iflytek.aikit.media.param.MscKeys;
import com.xiaomi.verificationsdk.internal.Constants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private static boolean bf = false;
    private static InterfaceC0071e e;

    /* JADX INFO: renamed from: com.bytedance.e.bf.e.e.e$e, reason: collision with other inner class name */
    public interface InterfaceC0071e {
        boolean bf();

        boolean d();

        boolean e();
    }

    public static String e(String str, List<Pair<String, String>> list) {
        if (TextUtils.isEmpty(str) || e == null || bf) {
            return str;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            Uri uri = Uri.parse(str);
            e(uri, linkedHashMap);
            LinkedList linkedList = new LinkedList();
            e(linkedHashMap, linkedList, Constants.DEVICE_ID);
            e(linkedHashMap, linkedList, "device_type");
            e(linkedHashMap, linkedList, "device_brand");
            e(linkedHashMap, linkedList, com.market.sdk.Constants.EXTRA_UUID);
            e(linkedHashMap, linkedList, "openudid");
            String strE = e((List<Pair<String, List<String>>>) linkedList, false, "UTF-8");
            if (TextUtils.isEmpty(strE)) {
                return str;
            }
            byte[] bytes = strE.getBytes();
            byte[] bArrA = TTEncryptUtils.a(bytes, bytes.length);
            if (bArrA == null) {
                return str;
            }
            String strEncodeToString = Base64.encodeToString(bArrA, 2);
            LinkedList linkedList2 = new LinkedList();
            if (e.e()) {
                LinkedList linkedList3 = new LinkedList();
                linkedList3.add(strEncodeToString);
                linkedList2.add(new Pair("ss_queries", linkedList3));
            }
            if (e.bf() && list != null) {
                list.add(new Pair<>("X-SS-QUERIES", e(strEncodeToString, "UTF-8")));
            }
            if (!linkedHashMap.isEmpty()) {
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    if (entry != null) {
                        linkedList2.add(new Pair(entry.getKey(), entry.getValue()));
                    }
                }
            }
            return e(uri.getScheme(), uri.getHost(), uri.getPort(), uri.getPath(), e((List<Pair<String, List<String>>>) linkedList2, true, "UTF-8"), uri.getFragment()).toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    private static boolean e(Map<String, List<String>> map, List<Pair<String, List<String>>> list, String str) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(str) || list == null || !map.containsKey(str)) {
            return false;
        }
        list.add(new Pair<>(str, map.get(str)));
        if (e.d()) {
            return true;
        }
        map.remove(str);
        return true;
    }

    public static void e(Uri uri, Map<String, List<String>> map) throws IOException {
        if (uri == null) {
            throw new IOException("parseUrl url is null !!!");
        }
        if (map != null) {
            try {
                String query = uri.getQuery();
                if (query != null) {
                    for (String str : query.split(a.p)) {
                        int iIndexOf = str.indexOf(MscKeys.KEY_VAL_SEP);
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

    private static Uri e(String str, String str2, int i, String str3, String str4, String str5) {
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
            sb.append(JsonPointer.SEPARATOR);
        }
        if (str3 != null) {
            sb.append(str3);
        }
        if (str4 != null) {
            sb.append('?');
            sb.append(str4);
        }
        if (str5 != null) {
            sb.append(DangdangFileManager.REPLACE);
            sb.append(str5);
        }
        return Uri.parse(sb.toString());
    }

    private static String e(List<Pair<String, List<String>>> list, boolean z, String str) {
        StringBuilder sb = new StringBuilder();
        for (Pair<String, List<String>> pair : list) {
            Object obj = pair.first;
            String strE = (String) obj;
            if (z) {
                strE = e((String) obj, str);
            }
            List<String> list2 = (List) pair.second;
            if (list2 != null && list2.size() > 0) {
                for (String strE2 : list2) {
                    if (z) {
                        strE2 = strE2 != null ? e(strE2, str) : "";
                    }
                    if (sb.length() > 0) {
                        sb.append(a.p);
                    }
                    sb.append(strE);
                    sb.append(MscKeys.KEY_VAL_SEP);
                    sb.append(strE2);
                }
            }
        }
        return sb.toString();
    }

    private static String e(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}
