package cn.bmob.v3.helper;

import cn.bmob.v3.BmobACL;
import cn.bmob.v3.datatype.BmobRelation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class GsonUtil {
    public static <T> String mapToJson(Map<String, T> map) {
        return new Gson().toJson(map);
    }

    public static String toJson(Object obj) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(BmobACL.class, new JsonSerializer<BmobACL>() { // from class: cn.bmob.v3.helper.GsonUtil.1
            @Override // com.google.gson.JsonSerializer
            public JsonElement serialize(BmobACL bmobACL, Type type, JsonSerializationContext jsonSerializationContext) {
                return new Gson().toJsonTree(bmobACL.getAcl());
            }
        });
        gsonBuilder.registerTypeAdapter(BmobRelation.class, new JsonSerializer<BmobRelation>() { // from class: cn.bmob.v3.helper.GsonUtil.2
            @Override // com.google.gson.JsonSerializer
            public JsonElement serialize(BmobRelation bmobRelation, Type type, JsonSerializationContext jsonSerializationContext) {
                if (bmobRelation.getObjects().size() == 0) {
                    return null;
                }
                return new Gson().toJsonTree(bmobRelation);
            }
        });
        return gsonBuilder.create().toJson(obj);
    }

    public static <T> List<T> toList(String str) {
        return (List) new Gson().fromJson(str, (Class) List.class);
    }

    public static Map<String, Object> toMap(String str) {
        return (Map) new Gson().fromJson(str, new TypeToken<Map<String, Object>>() { // from class: cn.bmob.v3.helper.GsonUtil.3
        }.getType());
    }

    public static <T> Object toObject(String str, Class<T> cls) {
        return new Gson().fromJson(str, (Class) cls);
    }

    public static <T> Object toObject(JsonElement jsonElement, Class<T> cls) {
        return new Gson().fromJson(jsonElement, (Class) cls);
    }
}
