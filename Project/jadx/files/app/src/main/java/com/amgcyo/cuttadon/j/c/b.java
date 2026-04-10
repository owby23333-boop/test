package com.amgcyo.cuttadon.j.c;

import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: GsonUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: compiled from: GsonUtil.java */
    class a extends TypeToken<HashMap<String, Object>> {
        a() {
        }
    }

    /* JADX INFO: renamed from: com.amgcyo.cuttadon.j.c.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GsonUtil.java */
    class C0106b extends TypeToken<HashMap<String, Object>> {
        C0106b() {
        }
    }

    public static void a(String str) {
        Iterator<String> it;
        boolean z2;
        g0 g0VarA = g0.a();
        g0VarA.b("csj_new", false);
        g0VarA.b("gdt_new", false);
        g0VarA.b("ks", false);
        g0VarA.b("gm", false);
        g0VarA.b("self", false);
        g0VarA.b("topon_new", false);
        Iterator<String> it2 = a(str, "\"platform\":\"([0-9a-zA-Z_]+)?\"").iterator();
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        while (it2.hasNext()) {
            String next = it2.next();
            if (z3 || !"csj_new".equals(next)) {
                it = it2;
                z2 = true;
            } else {
                it = it2;
                z2 = true;
                g0VarA.b("csj_new", true);
                z3 = true;
            }
            if (!z4 && "gdt_new".equals(next)) {
                g0VarA.b("gdt_new", z2);
                z4 = true;
            }
            if (!z5 && "ks".equals(next)) {
                g0VarA.b("ks", z2);
                z5 = true;
            }
            if (!z6 && "gm".equals(next)) {
                g0VarA.b("gm", z2);
                z6 = true;
            }
            if (!z7 && "self".equals(next)) {
                g0VarA.b("self", z2);
                z7 = true;
            }
            if (!z8 && "topon_new".equals(next)) {
                g0VarA.b("topon_new", z2);
                z8 = true;
            }
            it2 = it;
        }
        boolean z9 = false;
        boolean zA = g0VarA.a("topon_new", false);
        Boolean.valueOf(zA);
        g0VarA.b("topon_reward_ad_5_key", false);
        if (zA) {
            for (String str2 : a(str, "\"style\":([0-9])*")) {
                String str3 = "正则表达式：" + str2;
                if (!z9 && String.valueOf(5).equals(str2)) {
                    g0VarA.b("topon_reward_ad_5_key", true);
                    z9 = true;
                }
            }
        }
    }

    public static HashMap<String, Object> b(String str) {
        return (HashMap) new GsonBuilder().registerTypeAdapter(new a().getType(), new JsonDeserializer() { // from class: com.amgcyo.cuttadon.j.c.a
            @Override // com.google.gson.JsonDeserializer
            public final Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
                return b.a(jsonElement, type, jsonDeserializationContext);
            }
        }).create().fromJson(str, new C0106b().getType());
    }

    private static List<String> a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile(str2).matcher(str);
        while (matcher.find()) {
            String str3 = "group all: " + matcher.group(0);
            String str4 = "aim index: " + matcher.group(1);
            arrayList.add(matcher.group(1));
        }
        return arrayList;
    }

    static /* synthetic */ HashMap a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        HashMap map = new HashMap();
        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }
}
