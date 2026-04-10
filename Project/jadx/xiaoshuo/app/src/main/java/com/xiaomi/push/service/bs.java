package com.xiaomi.push.service;

import com.xiaomi.push.io;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class bs {
    public static io a(io ioVar) {
        Map<String, String> map;
        if (ioVar != null && (map = ioVar.f606b) != null) {
            map.remove("score_info");
        }
        return ioVar;
    }
}
