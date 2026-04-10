package com.bykv.vk.openvk.component.video.z.z.g;

import android.content.Context;
import com.bykv.vk.openvk.component.video.api.dl.a;
import com.bykv.vk.openvk.component.video.api.gc.z;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    public static final ConcurrentHashMap<String, g> z = new ConcurrentHashMap<>();

    public static synchronized void z(Context context, a aVar, z.InterfaceC0028z interfaceC0028z) {
        if (aVar == null) {
            com.bykv.vk.openvk.component.video.api.m.dl.z(" url、dir and hash is must property   in VideoInfoModel");
            return;
        }
        ConcurrentHashMap<String, g> concurrentHashMap = z;
        g gVar = concurrentHashMap.get(aVar.p());
        if (gVar == null) {
            gVar = new g(context, aVar);
            concurrentHashMap.put(aVar.p(), gVar);
            Object[] objArr = new Object[3];
            Integer.valueOf(aVar.m());
            aVar.p();
        }
        gVar.z(interfaceC0028z);
        Object[] objArr2 = new Object[3];
        Integer.valueOf(aVar.m());
        aVar.p();
    }

    public static synchronized void z(a aVar) {
        g gVarRemove = z.remove(aVar.p());
        if (gVarRemove != null) {
            gVarRemove.z(true);
        }
        Object[] objArr = new Object[3];
        Integer.valueOf(aVar.m());
        aVar.p();
    }
}
