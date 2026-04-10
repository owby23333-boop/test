package com.bytedance.msdk.core.z.z.g.z.gc;

import android.app.Activity;
import android.util.SparseArray;
import androidx.media3.session.SessionCommand;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.msdk.g.dl;
import com.bytedance.msdk.z.gc.m;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.ls.a;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g extends dl {
    private Function<SparseArray<Object>, Object> fo;
    private com.bytedance.msdk.core.z.z.g.z kb;
    private uy uy;

    @Override // com.bytedance.msdk.g.dl
    public boolean bb() {
        return true;
    }

    public g(com.bytedance.msdk.core.z.z.g.z zVar, Function<SparseArray<Object>, Object> function) {
        this.fo = function;
        this.kb = zVar;
        this.uy = zVar.g;
        aq();
        uy uyVar = this.uy;
        if (uyVar != null) {
            if (uyVar.x()) {
                z(mk());
            } else if (this.uy.mc()) {
                v(ou());
            }
        }
        if (qz() == 2) {
            kb(5);
        } else {
            kb(3);
        }
    }

    private int qz() {
        Function<SparseArray<Object>, Object> function = this.fo;
        if (function != null) {
            Object objApply = function.apply(a.z().z(40021).z(Integer.class).g());
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
        }
        return 0;
    }

    private void aq() {
        Function<SparseArray<Object>, Object> function = this.fo;
        if (function != null) {
            function.apply(a.z().z(40009).z(50009, this).z(Integer.class).g());
        }
    }

    private double mk() {
        int iEn;
        if (this.fo == null) {
            return 0.0d;
        }
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            iEn = oc();
        } else {
            iEn = en();
        }
        return iEn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int en() {
        Function<SparseArray<Object>, Object> function = this.fo;
        if (function == null) {
            return 0;
        }
        Object objApply = function.apply(a.z().z(40003).z(Integer.class).g());
        if (objApply instanceof Integer) {
            Integer num = (Integer) objApply;
            if (num.intValue() != -1) {
                return num.intValue();
            }
        }
        return 0;
    }

    private int oc() {
        try {
            Integer num = (Integer) m.z(new Callable<Integer>() { // from class: com.bytedance.msdk.core.z.z.g.z.gc.g.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return Integer.valueOf(g.this.en());
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
    public String ou() {
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            return bp();
        }
        return mt();
    }

    private String bp() {
        try {
            String str = (String) m.z(new Callable<String>() { // from class: com.bytedance.msdk.core.z.z.g.z.gc.g.2
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return g.this.ou();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            return str != null ? str : "";
        } catch (Exception e) {
            wp.z(e);
            return "";
        }
    }

    private String mt() {
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
            function.apply(a.z().z(40008).z(50008, activity).z(Void.class).g());
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public void z(final Activity activity, Object obj, String str) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            m.dl(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.gc.g.3
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
            return um();
        }
        return ey();
    }

    private Integer um() {
        try {
            Integer num = (Integer) m.z(new Callable<Integer>() { // from class: com.bytedance.msdk.core.z.z.g.z.gc.g.4
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return g.this.ey();
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
    public Integer ey() {
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
            m.dl(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.gc.g.5
                @Override // java.lang.Runnable
                public void run() {
                    g.this.xt();
                }
            });
        } else {
            xt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt() {
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
                m.a(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.gc.g.6
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
            m.a(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.gc.g.7
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
            return re();
        }
        return jt();
    }

    private String re() {
        try {
            return (String) m.z(new Callable<String>() { // from class: com.bytedance.msdk.core.z.z.g.z.gc.g.8
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return g.this.jt();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            wp.z(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String jt() {
        Object obj;
        if (this.fo == null) {
            return "";
        }
        Object objApply = this.fo.apply(a.z().z(40015).z(Map.class).g());
        return (!(objApply instanceof Map) || (obj = ((Map) objApply).get("request_id")) == null) ? "" : obj.toString();
    }

    private com.bytedance.msdk.api.a.z.gc.z ux() {
        return (com.bytedance.msdk.api.a.z.gc.z) this.e;
    }

    @Override // com.bytedance.msdk.g.dl, com.bytedance.sdk.openadsdk.core.ti.a
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 60011) {
            if (ux() == null) {
                return null;
            }
            ux().a();
            return null;
        }
        if (i == 60009) {
            if (ux() == null) {
                return null;
            }
            ux().z();
            return null;
        }
        if (i == 60004) {
            if (ux() == null) {
                return null;
            }
            ux().g();
            return null;
        }
        if (i == 60012) {
            if (ux() == null) {
                return null;
            }
            ux().gc();
            return null;
        }
        if (i != 60006 || ux() == null) {
            return null;
        }
        ux().dl();
        return null;
    }
}
