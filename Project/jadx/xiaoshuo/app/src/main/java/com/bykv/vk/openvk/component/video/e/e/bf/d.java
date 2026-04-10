package com.bykv.vk.openvk.component.video.e.e.bf;

import android.content.Context;
import com.bykv.vk.openvk.component.video.api.d.tg;
import com.bykv.vk.openvk.component.video.api.ga.e;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static final ConcurrentHashMap<String, bf> e = new ConcurrentHashMap<>();

    public static synchronized void e(Context context, tg tgVar, e.InterfaceC0053e interfaceC0053e) {
        if (tgVar == null) {
            com.bykv.vk.openvk.component.video.api.vn.d.bf(" url、dir and hash is must property   in VideoInfoModel");
            return;
        }
        ConcurrentHashMap<String, bf> concurrentHashMap = e;
        bf bfVar = concurrentHashMap.get(tgVar.l());
        if (bfVar == null) {
            bfVar = new bf(context, tgVar);
            concurrentHashMap.put(tgVar.l(), bfVar);
            com.bykv.vk.openvk.component.video.api.vn.d.bf("VideoFileManager", "preloadVideo:  cache size = ", Integer.valueOf(tgVar.vn()), tgVar.l());
        }
        bfVar.e(interfaceC0053e);
        com.bykv.vk.openvk.component.video.api.vn.d.bf("VideoFileManager", "preloadVideo:  cache size = ", Integer.valueOf(tgVar.vn()), tgVar.l());
    }

    public static synchronized void e(tg tgVar) {
        bf bfVarRemove = e.remove(tgVar.l());
        if (bfVarRemove != null) {
            bfVarRemove.e(true);
        }
        com.bykv.vk.openvk.component.video.api.vn.d.bf("VideoFileManager", "removePreload:  cache size = ", Integer.valueOf(tgVar.vn()), tgVar.l());
    }
}
