package com.bytedance.msdk.dl.dl.g.z.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class a extends g {
    public a(String str, com.bytedance.msdk.dl.z.g gVar) {
        super(str, gVar);
    }

    public void g(List<Function<SparseArray<Object>, Object>> list) {
        if (list != null) {
            if (!g()) {
                ArrayList arrayList = new ArrayList(list.size());
                Iterator<Function<SparseArray<Object>, Object>> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new com.bytedance.msdk.dl.z.z.gc(this, it.next()));
                }
                z(arrayList);
                return;
            }
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "自定义Adapter 加载成功或者失败回调只能调用一次");
            return;
        }
        z(new com.bytedance.msdk.api.a.z.g.z(49010, "list is null"));
    }

    public void z(com.bytedance.msdk.api.a.z.g.z zVar) {
        if (!z()) {
            z(new com.bytedance.msdk.api.z(49010, com.bytedance.msdk.api.z.z(49010), zVar == null ? -1 : zVar.z(), zVar == null ? "" : zVar.g()));
        } else {
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "自定义Adapter 加载成功或者失败回调只能调用一次");
        }
    }

    public boolean dl() {
        return this.g != null && this.g.g() == 1;
    }

    public boolean a() {
        return this.g != null && this.g.g() == 2;
    }

    @Override // com.bytedance.msdk.dl.dl.g.z.z.g
    public <T> T z(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8222) {
            boolean zDl = dl();
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom feed loader : isExpressRender: " + zDl);
            return (T) Boolean.valueOf(zDl);
        }
        if (i == 8223) {
            boolean zA = a();
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom feed loader : isNativeAd: " + zA);
            return (T) Boolean.valueOf(zA);
        }
        if (i == 8123) {
            int iIntValue = pluginValueSet.intValue(8014);
            String strStringValue = pluginValueSet.stringValue(8015);
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom feed loader : callLoaderFail  code:" + iIntValue + " msg:" + strStringValue);
            z(iIntValue, strStringValue);
            return null;
        }
        if (i != 8107) {
            return null;
        }
        List<Function<SparseArray<Object>, Object>> list = (List) pluginValueSet.objectValue(8303, List.class);
        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom feed loader : callLoadSucceed  list size:" + (list != null ? list.size() : 0));
        g(list);
        return null;
    }
}
