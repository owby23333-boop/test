package com.bytedance.msdk.core.z.z.g.z.g;

import android.content.Context;
import androidx.media3.session.SessionCommand;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.a.fo;
import com.bytedance.msdk.z.gc.m;
import com.bytedance.sdk.openadsdk.ls.a;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z extends com.bytedance.msdk.core.z.z.g.z {
    @Override // com.bytedance.msdk.core.z.z.g.z
    protected void z(final Context context) {
        if (dl()) {
            m.a(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.g.z.1
                @Override // java.lang.Runnable
                public void run() {
                    z.this.g(context);
                }
            });
        } else {
            g(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Context context) {
        a();
        a(context);
        gc();
        m();
        dl(context);
    }

    private void a() {
        HashMap map = new HashMap();
        fo foVarG = com.bytedance.msdk.core.z.kb().zw().g();
        if (foVarG != null) {
            map.put(d.D, String.valueOf(foVarG.g()));
            map.put(d.C, String.valueOf(foVarG.z()));
            map.put("loc_time", String.valueOf(System.currentTimeMillis() / 1000));
        }
        if (map.size() > 0) {
            com.bykv.z.z.z.z.z.z().z(50010, map);
            if (this.dl != null) {
                this.dl.apply(a.z().z(40025).z(50010, map).z(Void.class).g());
            }
        }
    }

    private void dl(Context context) {
        if (this.dl == null || this.z == null) {
            return;
        }
        C0081z c0081z = new C0081z(this);
        c0081z.z(context);
        this.dl.apply(a.z().z(40037).z(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1, c0081z).z(10013, Integer.valueOf(this.z.hh())).z(Void.class).g());
    }

    private void a(Context context) {
        if (this.dl != null) {
            this.dl.apply(a.z().z(40036).z(50000, this.g.fv()).z(10000, context).z(Void.class).g());
        }
    }

    private void gc() {
        if (this.dl != null) {
            this.dl.apply(a.z().z(40019).z(50010, this.z.oq()).z(Void.class).g());
        }
    }

    private void m() {
        if (this.dl != null) {
            this.dl.apply(a.z().z(40020).z(50010, this.z.oq()).z(Void.class).g());
        }
    }

    /* JADX INFO: renamed from: com.bytedance.msdk.core.z.z.g.z.g.z$z, reason: collision with other inner class name */
    static class C0081z extends com.bytedance.sdk.openadsdk.core.ti.a {
        private Context g;
        private com.bytedance.msdk.core.z.z.g.z z;

        public void z(Context context) {
            this.g = context;
        }

        public C0081z(com.bytedance.msdk.core.z.z.g.z zVar) {
            this.z = zVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.ti.a
        public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
            if (i == 60000) {
                List list = (List) pluginValueSet.objectValue(50015, List.class);
                if (this.z == null) {
                    return null;
                }
                if (list != null && list.size() > 0) {
                    ArrayList arrayList = new ArrayList(list.size());
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new g(this.g, this.z, (Function) it.next()));
                    }
                    this.z.z(arrayList);
                    return null;
                }
                this.z.z(-999, "adn return data is null");
                return null;
            }
            if (i != 60001 || this.z == null) {
                return null;
            }
            com.bytedance.msdk.core.z.z.g.z.m.g gVar = new com.bytedance.msdk.core.z.z.g.z.m.g((Function) pluginValueSet.objectValue(SessionCommand.COMMAND_CODE_LIBRARY_GET_SEARCH_RESULT, Function.class));
            this.z.z(gVar.z(), gVar.g());
            return null;
        }
    }
}
