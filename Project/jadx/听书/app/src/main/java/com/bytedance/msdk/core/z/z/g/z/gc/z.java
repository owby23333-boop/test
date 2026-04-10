package com.bytedance.msdk.core.z.z.g.z.gc;

import android.content.Context;
import android.util.SparseArray;
import androidx.media3.session.SessionCommand;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.a.fo;
import com.bytedance.msdk.z.gc.m;
import com.bytedance.sdk.openadsdk.ls.a;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z extends com.bytedance.msdk.core.z.z.g.z {
    @Override // com.bytedance.msdk.core.z.z.g.z
    protected void z(final Context context) {
        if (dl()) {
            m.a(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.gc.z.1
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
        dl(context);
        e();
        gc();
        m();
        gz();
    }

    private void a() {
        HashMap map = new HashMap();
        fo foVarG = com.bytedance.msdk.core.z.kb().zw().g();
        if (foVarG != null) {
            map.put(d.D, String.valueOf(foVarG.g()));
            map.put(d.C, String.valueOf(foVarG.z()));
            map.put("loc_time", String.valueOf(System.currentTimeMillis() / 1000));
        }
        if (map.size() <= 0 || this.dl == null) {
            return;
        }
        this.dl.apply(a.z().z(40025).z(Void.class).z(50010, map).g());
    }

    private void gc() {
        if (this.dl != null) {
            this.dl.apply(a.z().z(40019).z(Void.class).z(50010, this.z.oq()).g());
        }
    }

    private void m() {
        if (this.dl != null) {
            this.dl.apply(a.z().z(40020).z(Void.class).z(50010, this.z.oq()).g());
        }
    }

    private void dl(Context context) {
        if (this.dl != null) {
            this.dl.apply(a.z().z(40017).z(Void.class).z(50000, this.g.fv()).z(10000, context).g());
        }
    }

    private void e() {
        if (this.dl != null) {
            this.dl.apply(a.z().z(40018).z(Void.class).z(50010, this.z.oq()).g());
        }
    }

    private void gz() {
        if (this.dl != null) {
            this.dl.apply(a.z().z(40002).z(Void.class).z(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1, new C0082z(this)).g());
        }
    }

    /* JADX INFO: renamed from: com.bytedance.msdk.core.z.z.g.z.gc.z$z, reason: collision with other inner class name */
    static class C0082z extends com.bytedance.sdk.openadsdk.core.ti.a {
        private g g;
        private com.bytedance.msdk.core.z.z.g.z z;

        public C0082z(com.bytedance.msdk.core.z.z.g.z zVar) {
            this.z = zVar;
        }

        private void z(Function<SparseArray<Object>, Object> function) {
            if (this.g != null || function == null) {
                return;
            }
            this.g = new g(this.z, function);
        }

        @Override // com.bytedance.sdk.openadsdk.core.ti.a
        public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
            if (i == 60008) {
                Function<SparseArray<Object>, Object> function = (Function) pluginValueSet.objectValue(SessionCommand.COMMAND_CODE_LIBRARY_SEARCH, Function.class);
                com.bytedance.msdk.core.z.z.g.z zVar = this.z;
                if (zVar == null) {
                    return null;
                }
                if (function != null) {
                    z(function);
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(this.g);
                    this.z.z(arrayList);
                    return null;
                }
                zVar.z(-999, "adn return data is null");
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
