package com.bytedance.msdk.core.z.z.g.z.z;

import android.content.Context;
import androidx.media3.session.SessionCommand;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.a.fo;
import com.bytedance.msdk.z.gc.m;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z extends com.bytedance.msdk.core.z.z.g.z {
    @Override // com.bytedance.msdk.core.z.z.g.z
    protected void z(final Context context) {
        if (dl()) {
            m.a(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.z.z.1
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
        if (this.g != null) {
            if (this.g.m() == 4) {
                int iUy = this.g.uy();
                if (iUy == 1) {
                    gc(context);
                    return;
                } else if (iUy == 2) {
                    dl(context);
                    return;
                } else {
                    e(context);
                    return;
                }
            }
            e(context);
        }
    }

    private void a() {
        HashMap map = new HashMap();
        fo foVarG = com.bytedance.msdk.core.z.kb().zw().g();
        if (foVarG != null) {
            map.put(d.D, String.valueOf(foVarG.g()));
            map.put(d.C, String.valueOf(foVarG.z()));
            map.put("loc_time", String.valueOf(System.currentTimeMillis() / 1000));
        }
        if (map.isEmpty() || this.dl == null) {
            return;
        }
        this.dl.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(40025).z(50010, map).z(Void.class).g());
    }

    private void dl(Context context) {
        if (this.g != null) {
            a(context);
            fo();
            uy();
            gc();
        }
    }

    private void gc() {
        if (this.dl == null || this.z == null) {
            return;
        }
        this.dl.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(40037).z(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1, new C0084z(this)).z(10013, 1).z(Void.class).g());
    }

    private void a(Context context) {
        if (this.dl != null) {
            this.dl.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(40036).z(50000, this.g.fv()).z(10000, context).z(SessionCommand.COMMAND_CODE_LIBRARY_UNSUBSCRIBE, g()).z(Void.class).g());
        }
    }

    private void gc(Context context) {
        if (this.g != null) {
            e();
            m(context);
            fo();
            uy();
            gz();
            m();
        }
    }

    private void m() {
        if (this.dl == null || this.z == null) {
            return;
        }
        this.dl.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(40068).z(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1, new C0084z(this)).z(10013, 1).z(Void.class).g());
    }

    private void e() {
        if (this.dl != null) {
            this.dl.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(40031).z(50014, Integer.valueOf((int) this.z.v())).z(Void.class).g());
        }
    }

    private void m(Context context) {
        if (this.dl != null) {
            this.dl.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(40030).z(50000, this.g.fv()).z(10000, context).z(SessionCommand.COMMAND_CODE_LIBRARY_UNSUBSCRIBE, g()).z(Void.class).g());
        }
    }

    private void gz() {
        if (this.dl != null) {
            this.dl.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(40018).z(50010, this.z.oq()).z(Void.class).g());
        }
    }

    private void fo() {
        if (this.dl != null) {
            this.dl.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(40019).z(50010, this.z.oq()).z(Void.class).g());
        }
    }

    private void uy() {
        if (this.dl != null) {
            this.dl.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(40020).z(50010, this.z.oq()).z(Void.class).g());
        }
    }

    private void e(Context context) {
        gz(context);
        kb();
        wp();
    }

    private void kb() {
        if (this.dl != null) {
            this.dl.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(40067).z(50022, 0).z(Void.class).g());
        }
    }

    private void gz(Context context) {
        if (this.dl != null) {
            this.dl.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(40066).z(50000, this.g.fv()).z(10000, context).z(Void.class).g());
        }
    }

    private void wp() {
        if (this.dl == null || this.g == null) {
            return;
        }
        this.dl.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(40002).z(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1, new C0084z(this)).z(Void.class).g());
    }

    /* JADX INFO: renamed from: com.bytedance.msdk.core.z.z.g.z.z.z$z, reason: collision with other inner class name */
    static class C0084z extends com.bytedance.sdk.openadsdk.core.ti.a {
        private a dl;
        private volatile boolean g = false;
        private com.bytedance.msdk.core.z.z.g.z z;

        public C0084z(com.bytedance.msdk.core.z.z.g.z zVar) {
            this.z = zVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.ti.a
        public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
            com.bytedance.msdk.core.z.z.g.z zVar;
            if (i == 60008) {
                if (this.g) {
                    return null;
                }
                this.g = true;
                Function function = (Function) pluginValueSet.objectValue(SessionCommand.COMMAND_CODE_LIBRARY_SEARCH, Function.class);
                com.bytedance.msdk.core.z.z.g.z zVar2 = this.z;
                if (zVar2 == null) {
                    return null;
                }
                if (function != null) {
                    g gVar = new g(this.z, function);
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(gVar);
                    this.z.z(arrayList);
                    return null;
                }
                zVar2.z(-999, "adn return data is null");
                return null;
            }
            if (i == 60001) {
                if (this.g) {
                    return null;
                }
                this.g = true;
                if (this.z == null) {
                    return null;
                }
                com.bytedance.msdk.core.z.z.g.z.m.g gVar2 = new com.bytedance.msdk.core.z.z.g.z.m.g((Function) pluginValueSet.objectValue(SessionCommand.COMMAND_CODE_LIBRARY_GET_SEARCH_RESULT, Function.class));
                this.z.z(gVar2.z(), gVar2.g());
                return null;
            }
            if (i != 60000) {
                if (i != 60017 || (zVar = this.z) == null) {
                    return null;
                }
                if (this.dl != null) {
                    ArrayList arrayList2 = new ArrayList(1);
                    arrayList2.add(this.dl);
                    this.z.z(arrayList2);
                    return null;
                }
                zVar.z(-999, "adn return data is null");
                return null;
            }
            Function function2 = (Function) pluginValueSet.objectValue(SessionCommand.COMMAND_CODE_LIBRARY_SEARCH, Function.class);
            if (function2 != null) {
                if (this.z.z()) {
                    a aVar = new a(this.z, function2);
                    this.dl = aVar;
                    aVar.kb();
                    return null;
                }
                if (this.z == null) {
                    return null;
                }
                dl dlVar = new dl(this.z, function2);
                ArrayList arrayList3 = new ArrayList(1);
                arrayList3.add(dlVar);
                this.z.z(arrayList3);
                return null;
            }
            com.bytedance.msdk.core.z.z.g.z zVar3 = this.z;
            if (zVar3 == null) {
                return null;
            }
            zVar3.z(-999, "adn return data is null");
            return null;
        }
    }
}
