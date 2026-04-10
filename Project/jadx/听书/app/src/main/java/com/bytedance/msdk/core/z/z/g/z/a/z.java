package com.bytedance.msdk.core.z.z.g.z.a;

import android.content.Context;
import android.util.SparseArray;
import androidx.media3.session.SessionCommand;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.a.fo;
import com.bytedance.msdk.z.gc.m;
import com.bytedance.sdk.openadsdk.ls.a;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z extends com.bytedance.msdk.core.z.z.g.z {
    @Override // com.bytedance.msdk.core.z.z.g.z
    protected void z(final Context context) {
        if (dl()) {
            m.a(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.a.z.1
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
        gc();
        m();
        e();
        gz();
        fo();
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
            SparseArray<Object> sparseArrayG = a.z().z(40025).z(Void.class).z(50010, map).g();
            if (this.dl != null) {
                this.dl.apply(sparseArrayG);
            }
        }
    }

    private void dl(Context context) {
        if (this.dl != null) {
            this.dl.apply(a.z().z(40017).z(Void.class).z(50000, this.g.fv()).z(10000, context).g());
        }
    }

    private void gc() {
        if (this.dl != null) {
            this.dl.apply(a.z().z(40018).z(Void.class).z(50010, this.z.oq()).g());
        }
    }

    private void m() {
        if (this.dl != null) {
            this.dl.apply(a.z().z(40019).z(Void.class).z(50010, this.z.oq()).g());
        }
    }

    private void e() {
        if (this.dl != null) {
            this.dl.apply(a.z().z(40020).z(Void.class).z(50010, this.z.oq()).g());
        }
    }

    private void gz() {
        if (this.dl != null) {
            a aVarZ = a.z().z(40001).z(Void.class).z(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, this.z.lq());
            Map<String, Object> mapOq = this.z.oq();
            if (mapOq != null && mapOq.get(MediationConstant.ADN_GDT) != null) {
                aVarZ.z(SessionCommand.COMMAND_CODE_LIBRARY_GET_ITEM, String.valueOf(mapOq.get(MediationConstant.ADN_GDT)));
            }
            this.dl.apply(aVarZ.g());
        }
    }

    private void fo() {
        if (this.dl != null) {
            this.dl.apply(a.z().z(40002).z(Void.class).z(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1, new C0078z(this)).g());
        }
    }

    /* JADX INFO: renamed from: com.bytedance.msdk.core.z.z.g.z.a.z$z, reason: collision with other inner class name */
    static class C0078z extends com.bytedance.sdk.openadsdk.core.ti.a {
        private g g;
        private com.bytedance.msdk.core.z.z.g.z z;

        public C0078z(com.bytedance.msdk.core.z.z.g.z zVar) {
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
                if (zVar != null) {
                    if (function != null) {
                        z(function);
                        ArrayList arrayList = new ArrayList(1);
                        arrayList.add(this.g);
                        this.z.z(arrayList);
                    } else {
                        zVar.z(-999, "adn return data is null");
                    }
                }
            } else if (i == 60001) {
                if (this.z != null) {
                    com.bytedance.msdk.core.z.z.g.z.m.g gVar = new com.bytedance.msdk.core.z.z.g.z.m.g((Function) pluginValueSet.objectValue(SessionCommand.COMMAND_CODE_LIBRARY_GET_SEARCH_RESULT, Function.class));
                    this.z.z(gVar.z(), gVar.g());
                }
            } else if (i == 60003) {
                Function<SparseArray<Object>, Object> function2 = (Function) pluginValueSet.objectValue(SessionCommand.COMMAND_CODE_LIBRARY_SEARCH, Function.class);
                com.bytedance.msdk.core.z.z.g.z zVar2 = this.z;
                if (zVar2 != null) {
                    if (function2 != null) {
                        z(function2);
                        this.z.z(this.g, (com.bytedance.msdk.api.z) null);
                    } else {
                        zVar2.z(-999, "adn return data is null");
                    }
                }
            }
            return null;
        }
    }
}
