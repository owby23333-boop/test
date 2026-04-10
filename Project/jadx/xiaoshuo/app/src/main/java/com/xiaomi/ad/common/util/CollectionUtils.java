package com.xiaomi.ad.common.util;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class CollectionUtils {
    public static List avoidNull(List list) {
        return list != null ? list : Collections.EMPTY_LIST;
    }

    public static <T> T get(List<T> list, int i) {
        if (list == null || i < 0 || getSize(list) <= i) {
            return null;
        }
        return list.get(i);
    }

    public static int getSize(Collection collection) {
        if (collection != null) {
            return collection.size();
        }
        return 0;
    }

    public static boolean isEmpty(Collection collection) {
        return getSize(collection) == 0;
    }

    public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }

    public static Map avoidNull(Map map) {
        return map != null ? map : Collections.EMPTY_MAP;
    }

    public static <K, V> V get(Map<K, V> map, K k) {
        if (map == null) {
            return null;
        }
        return map.get(k);
    }

    public static int getSize(Map map) {
        if (map != null) {
            return map.size();
        }
        return 0;
    }

    public static boolean isEmpty(Map map) {
        return getSize(map) == 0;
    }

    public static boolean isNotEmpty(Map map) {
        return !isEmpty(map);
    }

    public static Set avoidNull(Set set) {
        return set != null ? set : Collections.EMPTY_SET;
    }

    public static <T> T get(T[] tArr, int i) {
        if (tArr == null || i < 0 || getSize(tArr) <= i) {
            return null;
        }
        return tArr[i];
    }

    public static int getSize(JSONArray jSONArray) {
        if (jSONArray != null) {
            return jSONArray.length();
        }
        return 0;
    }

    public static boolean isEmpty(JSONArray jSONArray) {
        return getSize(jSONArray) == 0;
    }

    public static boolean isNotEmpty(JSONArray jSONArray) {
        return !isEmpty(jSONArray);
    }

    public static int getSize(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.length();
        }
        return 0;
    }

    public static boolean isEmpty(JSONObject jSONObject) {
        return getSize(jSONObject) == 0;
    }

    public static boolean isNotEmpty(JSONObject jSONObject) {
        return !isEmpty(jSONObject);
    }

    public static <T> int getSize(T[] tArr) {
        if (tArr != null) {
            return tArr.length;
        }
        return 0;
    }

    public static <T> boolean isEmpty(T[] tArr) {
        return getSize(tArr) == 0;
    }

    public static <T> boolean isNotEmpty(T[] tArr) {
        return !isEmpty(tArr);
    }
}
