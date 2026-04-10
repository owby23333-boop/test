package com.yuewen;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public interface fl1 {
    public static final int e = 90001;
    public static final int f = 1002;
    public static final int g = 30012;

    eg4<JSONObject> a(String str, int i) throws Exception;

    <T> eg4<Map<String, T>> e(String str, String... strArr) throws Exception;

    eg4<ob4> f() throws Exception;

    eg4<JSONObject> g(String str, String str2, int i, int i2, String str3) throws Exception;

    eg4<Map<String, Object>> h(String... strArr) throws Exception;

    eg4 i(String str, String str2) throws Exception;

    eg4 k(String str, String str2, String str3) throws Exception;

    <T> eg4<T> l(String str, String str2) throws Exception;

    eg4<JSONObject> m(String str, double d, String str2) throws Exception;

    eg4<JSONObject> o(String str, String str2, int i, int i2) throws Exception;
}
