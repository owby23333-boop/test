package com.bytedance.msdk.core.z.z.g.z.e;

import android.content.Context;
import android.os.SystemClock;
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
            m.a(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.e.z.1
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
        gc();
        dl(context);
        a();
        m();
    }

    private void a() {
        if (this.z.tb() || this.dl == null) {
            return;
        }
        this.dl.apply(a.z().z(40026).z(Void.class).g());
    }

    private void gc() {
        HashMap map = new HashMap();
        fo foVarG = com.bytedance.msdk.core.z.kb().zw().g();
        if (foVarG != null) {
            map.put(d.D, String.valueOf(foVarG.g()));
            map.put(d.C, String.valueOf(foVarG.z()));
            map.put("loc_time", String.valueOf(System.currentTimeMillis() / 1000));
        }
        if (!this.z.js()) {
            map.put("shakable", "0");
        }
        if (map.size() > 0) {
            com.bykv.z.z.z.z.z.z().z(50010, map);
            if (this.dl != null) {
                this.dl.apply(a.z().z(40025).z(Void.class).g());
            }
        }
    }

    private void dl(Context context) {
        if (this.dl != null) {
            int iP = this.z.p();
            if (iP < 0) {
                iP = 3000;
            } else if (iP > 5000) {
                iP = 5000;
            }
            this.dl.apply(a.z().z(40024).z(50000, this.g.fv()).z(50011, Integer.valueOf(iP)).z(10000, context).z(Void.class).g());
        }
    }

    private void m() {
        if (this.dl == null || this.g == null) {
            return;
        }
        int iUy = this.g.uy();
        if (iUy == 2) {
            this.dl.apply(a.z().z(40027).z(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1, new C0080z(this)).z(Void.class).g());
        } else if (iUy == 0 || iUy == 1) {
            this.dl.apply(a.z().z(40028).z(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1, new C0080z(this)).z(Void.class).g());
        }
    }

    /* JADX INFO: renamed from: com.bytedance.msdk.core.z.z.g.z.e.z$z, reason: collision with other inner class name */
    static class C0080z extends com.bytedance.sdk.openadsdk.core.ti.a {
        private g g;
        private com.bytedance.msdk.core.z.z.g.z z;

        public C0080z(com.bytedance.msdk.core.z.z.g.z zVar) {
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
            if (i == 60000) {
                Function<SparseArray<Object>, Object> function = (Function) pluginValueSet.objectValue(SessionCommand.COMMAND_CODE_LIBRARY_SEARCH, Function.class);
                long jLongValue = pluginValueSet.longValue(50012) - SystemClock.elapsedRealtime();
                com.bytedance.msdk.core.z.z.g.z zVar = this.z;
                if (zVar == null || jLongValue <= 1000) {
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
            if (gVar.z() == 4004 || gVar.z() == 4005) {
                g gVar2 = this.g;
                if (gVar2 == null) {
                    return null;
                }
                gVar2.z(gVar);
                return null;
            }
            this.z.z(gVar.z(), gVar.g());
            return null;
        }
    }
}
