package com.yuewen;

import com.duokan.statistics.base.tool.ReportField;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class q73 {
    public static JSONObject b(Object obj) {
        return c(new JSONObject(), obj);
    }

    public static JSONObject c(final JSONObject jSONObject, Object obj) {
        f(obj, new sd() { // from class: com.yuewen.o73
            @Override // com.yuewen.sd
            public final void a(String str, Object obj2) {
                o01.a(jSONObject, str, obj2);
            }
        });
        return jSONObject;
    }

    public static Map<String, Object> d(Object obj) {
        return e(new HashMap(), obj);
    }

    public static Map<String, Object> e(final Map<String, Object> map, Object obj) {
        Objects.requireNonNull(map);
        f(obj, new sd() { // from class: com.yuewen.p73
            @Override // com.yuewen.sd
            public final void a(String str, Object obj2) {
                map.put(str, obj2);
            }
        });
        return map;
    }

    public static void f(Object obj, sd sdVar) {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            for (Field field : superclass.getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    ReportField reportField = (ReportField) field.getAnnotation(ReportField.class);
                    String strName = reportField != null ? reportField.name() : null;
                    Object obj2 = field.get(obj);
                    if (strName != null && obj2 != null) {
                        sdVar.a(strName, obj2);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
