package com.bytedance.msdk.core.z.z.g.z.a;

import android.app.Activity;
import android.util.SparseArray;
import androidx.media3.session.SessionCommand;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.msdk.g.dl;
import com.bytedance.msdk.z.gc.m;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.ls.a;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g extends dl {
    private Function<SparseArray<Object>, Object> fo;
    private com.bytedance.msdk.core.z.z.g.z kb;
    private uy uy;
    private com.bytedance.msdk.api.z.g wp;

    @Override // com.bytedance.msdk.g.dl
    public boolean bb() {
        return true;
    }

    public g(com.bytedance.msdk.core.z.z.g.z zVar, Function<SparseArray<Object>, Object> function) {
        this.fo = function;
        this.kb = zVar;
        this.uy = zVar.g;
        this.wp = zVar.z;
        en();
        uy uyVar = this.uy;
        if (uyVar != null) {
            if (uyVar.x()) {
                z(oc());
            } else if (this.uy.mc()) {
                v(mt());
            }
        }
        if (mk() == 2) {
            kb(5);
            aq();
            qz();
        }
    }

    private void qz() {
        if (this.fo != null) {
            this.fo.apply(a.z().z(40023).z(Void.class).g());
        }
    }

    private void aq() {
        if (this.fo != null) {
            this.fo.apply(a.z().z(40022).z(Void.class).g());
        }
    }

    private int mk() {
        if (this.fo != null) {
            Object objApply = this.fo.apply(a.z().z(40021).z(Void.class).g());
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
        }
        return 0;
    }

    private void en() {
        if (this.fo != null) {
            this.fo.apply(a.z().z(40009).z(50009, this).z(Void.class).g());
        }
    }

    private double oc() {
        int iOu;
        if (this.fo == null) {
            return 0.0d;
        }
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            iOu = bp();
        } else {
            iOu = ou();
        }
        return iOu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ou() {
        Function<SparseArray<Object>, Object> function = this.fo;
        if (function == null) {
            return 0;
        }
        Object objApply = function.apply(a.z().z(40003).z(Integer.class).g());
        int iIntValue = objApply instanceof Integer ? ((Integer) objApply).intValue() : 0;
        if (iIntValue == -1) {
            return 0;
        }
        return iIntValue;
    }

    private int bp() {
        try {
            Integer num = (Integer) m.z(new Callable<Integer>() { // from class: com.bytedance.msdk.core.z.z.g.z.a.g.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return Integer.valueOf(g.this.ou());
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            if (num != null) {
                return num.intValue();
            }
            return 0;
        } catch (Exception e) {
            wp.z(e);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String mt() {
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            return um();
        }
        return ey();
    }

    private String um() {
        try {
            String str = (String) m.z(new Callable<String>() { // from class: com.bytedance.msdk.core.z.z.g.z.a.g.2
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return g.this.mt();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            return str != null ? str : "";
        } catch (Exception e) {
            wp.z(e);
            return "";
        }
    }

    private String ey() {
        Function<SparseArray<Object>, Object> function = this.fo;
        if (function == null) {
            return "";
        }
        Object objApply = function.apply(a.z().z(40004).z(String.class).g());
        if (objApply instanceof String) {
            return objApply.toString();
        }
        return null;
    }

    private void dl(Activity activity) {
        Function<SparseArray<Object>, Object> function = this.fo;
        if (function != null) {
            function.apply(a.z().z(40008).z(50008, activity).z(String.class).g());
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public void z(final Activity activity, Object obj, String str) {
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            m.dl(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.a.g.3
                @Override // java.lang.Runnable
                public void run() {
                    g.this.a(activity);
                }
            });
        } else {
            a(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity) {
        dl(activity);
    }

    @Override // com.bytedance.msdk.g.dl
    public Integer m() {
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            return xt();
        }
        return re();
    }

    private Integer xt() {
        try {
            Integer num = (Integer) m.z(new Callable<Integer>() { // from class: com.bytedance.msdk.core.z.z.g.z.a.g.4
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return g.this.re();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            if (num != null) {
                return num;
            }
            return 4;
        } catch (Exception e) {
            wp.z(e);
            return 4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Integer re() {
        if (this.fo != null) {
            Object objApply = this.fo.apply(a.z().z(SessionCommand.COMMAND_CODE_SESSION_SET_RATING).z(Boolean.class).g());
            if ((objApply instanceof Boolean) && ((Boolean) objApply).booleanValue()) {
                return 2;
            }
        }
        return 4;
    }

    @Override // com.bytedance.msdk.g.dl
    public void fv() {
        super.fv();
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            m.dl(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.a.g.5
                @Override // java.lang.Runnable
                public void run() {
                    g.this.jt();
                }
            });
        } else {
            jt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jt() {
        if (this.fo != null) {
            this.fo.apply(a.z().z(40011).z(Void.class).g());
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public boolean gc() {
        if (this.fo != null) {
            Object objApply = this.fo.apply(a.z().z(40012).z(Boolean.class).g());
            if ((objApply instanceof Boolean) && ((Boolean) objApply).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.msdk.g.dl
    public void g(Map<String, Object> map) {
        uy uyVar = this.uy;
        if (uyVar != null && uyVar.x()) {
            final int iU = (int) u();
            com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
            if (zVar != null && zVar.dl()) {
                m.a(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.a.g.6
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.io(iU);
                    }
                });
            } else {
                io(iU);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void io(int i) {
        if (this.fo != null) {
            this.fo.apply(a.z().z(40013).z(Void.class).z(50007, Integer.valueOf(i)).g());
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public void z(final Map<String, Object> map) {
        uy uyVar = this.uy;
        if (uyVar == null || !uyVar.x() || map == null) {
            return;
        }
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            m.a(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.a.g.7
                @Override // java.lang.Runnable
                public void run() {
                    g.this.m((Map<String, Object>) map);
                }
            });
        } else {
            m(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Map<String, Object> map) {
        if (this.fo != null) {
            this.fo.apply(a.z().z(40014).z(Void.class).z(50010, map).g());
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public String mn() {
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            return ux();
        }
        return gd();
    }

    private String ux() {
        try {
            return (String) m.z(new Callable<String>() { // from class: com.bytedance.msdk.core.z.z.g.z.a.g.8
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return g.this.gd();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            wp.z(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String gd() {
        Object obj;
        if (this.fo == null) {
            return "";
        }
        Object objApply = this.fo.apply(a.z().z(40015).z(Map.class).g());
        return (!(objApply instanceof Map) || (obj = ((Map) objApply).get("request_id")) == null) ? "" : obj.toString();
    }

    private com.bytedance.msdk.api.a.z.a.z zt() {
        return (com.bytedance.msdk.api.a.z.a.z) this.e;
    }

    @Override // com.bytedance.msdk.g.dl, com.bytedance.sdk.openadsdk.core.ti.a
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        return (T) call(i, pluginValueSet, cls);
    }

    public <T> T call(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 60009) {
            if (zt() == null) {
                return null;
            }
            zt().g_();
            return null;
        }
        if (i == 60004) {
            if (zt() == null) {
                return null;
            }
            zt().h_();
            return null;
        }
        if (i == 60005) {
            if (zt() == null) {
                return null;
            }
            zt().a();
            return null;
        }
        if (i == 60006) {
            if (zt() == null) {
                return null;
            }
            zt().dl();
            return null;
        }
        if (i == 60010) {
            if (zt() == null) {
                return null;
            }
            zt().gc();
            return null;
        }
        if (i != 60007) {
            return null;
        }
        Map map = (Map) pluginValueSet.objectValue(50010, Map.class);
        if (zt() == null) {
            return null;
        }
        final HashMap map2 = new HashMap();
        if (map != null) {
            map2.putAll(map);
        }
        zt().z(new com.bytedance.msdk.api.dl.z() { // from class: com.bytedance.msdk.core.z.z.g.z.a.g.9
            @Override // com.bytedance.msdk.api.dl.z
            public boolean z() {
                return true;
            }

            @Override // com.bytedance.msdk.api.dl.z
            public float g() {
                if (g.this.wp != null) {
                    return g.this.wp.gk();
                }
                return 0.0f;
            }

            @Override // com.bytedance.msdk.api.dl.z
            public String dl() {
                return g.this.wp != null ? g.this.wp.h() : "";
            }

            @Override // com.bytedance.msdk.api.dl.z
            public Map<String, Object> a() {
                return map2;
            }
        });
        return null;
    }
}
