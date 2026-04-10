package com.amgcyo.cuttadon.sdk.utils;

import android.text.TextUtils;
import com.amgcyo.cuttadon.api.entity.adbean.AdCodeIdBean;
import com.amgcyo.cuttadon.api.entity.config.AdDataBean;
import com.amgcyo.cuttadon.api.entity.config.MkAppConfig;
import com.amgcyo.cuttadon.utils.otherutils.r;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: AdPlatformUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private static HashMap<String, Object> a;
    private static HashMap<String, AdCodeIdBean> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static HashMap<String, HashMap<String, Object>> f4330c;

    public static String a(String str, String str2) {
        AdDataBean ad_data;
        String str3;
        MkAppConfig mkAppConfigE = com.amgcyo.cuttadon.utils.otherutils.h.e();
        AdCodeIdBean adCodeIdBean = null;
        if (mkAppConfigE == null || (ad_data = mkAppConfigE.getAd_data()) == null) {
            return null;
        }
        String strA = r.a(ad_data);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        if (a == null) {
            a = com.amgcyo.cuttadon.j.c.b.b(strA);
        }
        if (a == null) {
            return null;
        }
        if (b == null) {
            b = new HashMap<>();
        }
        if (b.containsKey(str)) {
            String str4 = "adCodeIdBeanHashMap包含了：" + str + " 数量是：" + b.size();
        } else {
            String str5 = "adCodeIdBeanHashMap不包含：" + str;
            Iterator<Map.Entry<String, Object>> it = a.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, Object> next = it.next();
                if (str.equals(next.getKey())) {
                    Object value = next.getValue();
                    if (value instanceof JsonObject) {
                        adCodeIdBean = (AdCodeIdBean) r.a().fromJson((JsonElement) ((JsonObject) value).getAsJsonObject(), AdCodeIdBean.class);
                        break;
                    }
                }
            }
            b.put(str, adCodeIdBean);
            String str6 = "添加" + str + "到map里面";
        }
        AdCodeIdBean adCodeIdBean2 = b.get(str);
        str3 = "";
        if (adCodeIdBean2 != null) {
            String strA2 = r.a(adCodeIdBean2);
            if (!TextUtils.isEmpty(strA2)) {
                if (f4330c == null) {
                    f4330c = new HashMap<>();
                }
                if (!f4330c.containsKey(str)) {
                    f4330c.put(str, com.amgcyo.cuttadon.j.c.b.b(strA2));
                }
                String str7 = "size:" + f4330c.size();
                HashMap<String, Object> map = f4330c.get(str);
                if (map != null) {
                    Iterator<Map.Entry<String, Object>> it2 = map.entrySet().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Map.Entry<String, Object> next2 = it2.next();
                        String key = next2.getKey();
                        if (key.equals(str2)) {
                            Object value2 = next2.getValue();
                            if (value2 instanceof JsonPrimitive) {
                                JsonPrimitive jsonPrimitive = (JsonPrimitive) value2;
                                String strValueOf = jsonPrimitive.isNumber() ? String.valueOf(jsonPrimitive.getAsNumber()) : jsonPrimitive.isString() ? jsonPrimitive.getAsString() : "";
                                String str8 = "json获取到的值: " + strValueOf;
                                str3 = (TextUtils.isEmpty(strValueOf) || !"0".equals(strValueOf)) ? strValueOf : "";
                                String str9 = "beanType: " + str + " filedType: " + str2 + " key: " + key + " value " + value2;
                            }
                        }
                    }
                }
            }
        }
        return str3;
    }

    public static String b(String str) {
        return a("csj_city", str);
    }

    public static String c(String str) {
        return a("csj_comics_read", str);
    }

    public static String d(String str) {
        return a("csj_lists", str);
    }

    public static String e(String str) {
        return a("csj_new", str);
    }

    public static String f(String str) {
        return a("csj_read", str);
    }

    public static String g(String str) {
        return a("gdt_lists", str);
    }

    public static String h(String str) {
        return a("gdt_new", str);
    }

    public static String i(String str) {
        return a("gdt_read", str);
    }

    public static String j(String str) {
        return a("gm", str);
    }

    public static String k(String str) {
        return a("ks", str);
    }

    public static String l(String str) {
        return a("ks_city", str);
    }

    public static String m(String str) {
        return a("ks_comics_read", str);
    }

    public static String n(String str) {
        return a("ks_lists", str);
    }

    public static String o(String str) {
        return a("ks_read", str);
    }

    public static String p(String str) {
        return a("topon_new", str);
    }

    public static String a(String str) {
        return a(com.anythink.expressad.foundation.g.a.L, str);
    }

    public static void a() {
        try {
            if (a != null && a.size() > 0) {
                a.clear();
                a = null;
            }
            if (b != null && b.size() > 0) {
                b.clear();
                b = null;
            }
            if (f4330c == null || f4330c.size() <= 0) {
                return;
            }
            f4330c.clear();
            f4330c = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
