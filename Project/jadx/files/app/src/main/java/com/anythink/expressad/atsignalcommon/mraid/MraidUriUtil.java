package com.anythink.expressad.atsignalcommon.mraid;

import android.net.Uri;
import android.text.TextUtils;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.atsignalcommon.windvane.a;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.j;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MraidUriUtil {
    private static volatile ConcurrentHashMap<String, String> a = new ConcurrentHashMap<>();
    private static ArrayList<String> b = new ArrayList<>();

    private static Set<String> a(Uri uri) {
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i2 = 0;
        do {
            int iIndexOf = encodedQuery.indexOf(38, i2);
            if (iIndexOf == -1) {
                iIndexOf = encodedQuery.length();
            }
            int iIndexOf2 = encodedQuery.indexOf(61, i2);
            if (iIndexOf2 > iIndexOf || iIndexOf2 == -1) {
                iIndexOf2 = iIndexOf;
            }
            linkedHashSet.add(Uri.decode(encodedQuery.substring(i2, iIndexOf2)));
            i2 = iIndexOf + 1;
        } while (i2 < encodedQuery.length());
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public static void clearUnSupportMraidMethodMap() {
        if (a.size() > 0) {
            a.clear();
        }
    }

    public static a getMraidMethodContext(WindVaneWebView windVaneWebView, String str) {
        Set<String> setUnmodifiableSet;
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.contains(c.f10162m)) {
            return null;
        }
        a aVar = new a();
        aVar.f8311d = j.b("n+ztLkxpVTzBLkxgHN==");
        aVar.f8312e = uri.getHost();
        int i2 = 0;
        if (b.size() == 0) {
            for (Method method : IMraidSignalCommunication.class.getDeclaredMethods()) {
                b.add(method.getName());
            }
        }
        if (!b.contains(aVar.f8312e) && windVaneWebView != null) {
            String campaignId = windVaneWebView.getCampaignId();
            String str2 = aVar.f8312e;
            if (!TextUtils.isEmpty(campaignId)) {
                if (a.containsKey(campaignId)) {
                    String strConcat = a.get(campaignId);
                    if (!TextUtils.isEmpty(str2) && !strConcat.contains(str2)) {
                        if (strConcat.length() > 0) {
                            strConcat = strConcat.concat(",");
                        }
                        a.put(campaignId, strConcat.concat(str2));
                    }
                } else {
                    a.put(campaignId, str2);
                }
            }
            CallMraidJS.getInstance().fireNativeMethodCompleteEvent(windVaneWebView, aVar.f8312e);
            CallMraidJS.getInstance().fireErrorEvent(windVaneWebView, aVar.f8312e, "Specified command is not implemented");
            return null;
        }
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            setUnmodifiableSet = Collections.emptySet();
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            do {
                int iIndexOf = encodedQuery.indexOf(38, i2);
                if (iIndexOf == -1) {
                    iIndexOf = encodedQuery.length();
                }
                int iIndexOf2 = encodedQuery.indexOf(61, i2);
                if (iIndexOf2 > iIndexOf || iIndexOf2 == -1) {
                    iIndexOf2 = iIndexOf;
                }
                linkedHashSet.add(Uri.decode(encodedQuery.substring(i2, iIndexOf2)));
                i2 = iIndexOf + 1;
            } while (i2 < encodedQuery.length());
            setUnmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str3 : setUnmodifiableSet) {
                jSONObject.put(str3, uri.getQueryParameter(str3));
            }
            aVar.f8313f = jSONObject.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return aVar;
    }

    public static String getUnSupportMraidMethodString(String str) {
        if (a.containsKey(str)) {
            return a.get(str);
        }
        return null;
    }

    public static void clearUnSupportMraidMethodMap(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a.remove(str);
    }

    private static void a() {
        for (Method method : IMraidSignalCommunication.class.getDeclaredMethods()) {
            b.add(method.getName());
        }
    }

    private static void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (a.containsKey(str)) {
            String strConcat = a.get(str);
            if (TextUtils.isEmpty(str2) || strConcat.contains(str2)) {
                return;
            }
            if (strConcat.length() > 0) {
                strConcat = strConcat.concat(",");
            }
            a.put(str, strConcat.concat(str2));
            return;
        }
        a.put(str, str2);
    }
}
