package com.yuewen;

import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public class ef3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap<String, String> f10582a;

    static {
        HashMap<String, String> map = new HashMap<>();
        f10582a = map;
        map.put("store_male", "_r:92452_1821*pos:1821_0-177741");
        f10582a.put("store_female", "_r:92452_1822*pos:1822_0-177742");
        f10582a.put("store_publish", "_r:92452_1823*pos:1823_0-177743");
        f10582a.put("category", "_r:92452_1824*pos:1824_0-177744");
        f10582a.put("store_comic", "_r:92452_1825*pos:1825_0-177745");
        f10582a.put("store_audio", "_r:92452_1826*pos:1826_0-177746");
        f10582a.put("store_vip", "_r:92452_1827*pos:1827_0-177747");
        f10582a.put("bookshelf", "_r:92452_1828*pos:1828_0-177748");
    }

    public static String a(String str) {
        return f10582a.get(str);
    }
}
