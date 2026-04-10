package com.bytedance.msdk.core.z.z.g.z.z;

import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.msdk.z.gc.m;
import com.bytedance.sdk.component.utils.wp;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.bytedance.msdk.g.dl {
    private Function<SparseArray<Object>, Object> fo;
    private com.bytedance.msdk.core.z.z.g.z kb;
    private uy uy;
    private com.bytedance.msdk.api.z.g wp;

    public a(com.bytedance.msdk.core.z.z.g.z zVar, Function<SparseArray<Object>, Object> function) {
        this.fo = function;
        this.kb = zVar;
        this.uy = zVar.g;
        this.wp = zVar.z;
        oc();
        if (en() == 2) {
            kb(5);
            mk();
        } else if (en() != 1 && en() != 4 && en() == 3) {
            kb(4);
        } else {
            kb(3);
        }
        e(true);
        x(aq());
        lq(qz());
        wp(3);
        uy uyVar = this.uy;
        if (uyVar != null) {
            if (uyVar.x()) {
                z(ou());
            } else if (this.uy.mc()) {
                v(um());
            }
        }
    }

    private String qz() {
        if (this.fo == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40033);
        sparseArray.put(-99999985, String.class);
        return (String) this.fo.apply(sparseArray);
    }

    private String aq() {
        if (this.fo == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40032);
        sparseArray.put(-99999985, String.class);
        return (String) this.fo.apply(sparseArray);
    }

    private void mk() {
        if (this.fo != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40022);
            sparseArray.put(-99999985, Void.class);
            this.fo.apply(sparseArray);
        }
    }

    private int en() {
        if (this.fo == null) {
            return 0;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40021);
        sparseArray.put(-99999985, Integer.class);
        return ((Integer) this.fo.apply(sparseArray)).intValue();
    }

    private void oc() {
        if (this.fo != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40009);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50009, this);
            this.fo.apply(sparseArray);
        }
    }

    private double ou() {
        int iBp;
        if (this.fo == null) {
            return 0.0d;
        }
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            iBp = mt();
        } else {
            iBp = bp();
        }
        return iBp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bp() {
        if (this.fo == null) {
            return 0;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40003);
        sparseArray.put(-99999985, Integer.class);
        Object objApply = this.fo.apply(sparseArray);
        if (objApply instanceof Integer) {
            Integer num = (Integer) objApply;
            if (num.intValue() != -1) {
                return num.intValue();
            }
        }
        return 0;
    }

    private int mt() {
        try {
            Integer num = (Integer) m.z(new Callable<Integer>() { // from class: com.bytedance.msdk.core.z.z.g.z.z.a.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return Integer.valueOf(a.this.bp());
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
    public String um() {
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            return ey();
        }
        return xt();
    }

    private String ey() {
        try {
            String str = (String) m.z(new Callable<String>() { // from class: com.bytedance.msdk.core.z.z.g.z.z.a.2
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return a.this.um();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            return str != null ? str : "";
        } catch (Exception e) {
            wp.z(e);
            return "";
        }
    }

    private String xt() {
        if (this.fo == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40004);
        sparseArray.put(-99999985, String.class);
        return (String) this.fo.apply(sparseArray);
    }

    @Override // com.bytedance.msdk.g.dl
    public void fv() {
        super.fv();
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            m.dl(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.z.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.re();
                }
            });
        } else {
            re();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void re() {
        if (this.fo != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40011);
            sparseArray.put(-99999985, Void.class);
            this.fo.apply(sparseArray);
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public boolean gc() {
        if (this.fo == null) {
            return false;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40012);
        sparseArray.put(-99999985, Boolean.class);
        return ((Boolean) this.fo.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.msdk.g.dl
    public void g(Map<String, Object> map) {
        uy uyVar = this.uy;
        if (uyVar != null && uyVar.x()) {
            final int iU = (int) u();
            com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
            if (zVar != null && zVar.dl()) {
                m.a(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.z.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.io(iU);
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
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40013);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50007, Integer.valueOf(i));
            this.fo.apply(sparseArray);
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
            m.a(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.z.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.m((Map<String, Object>) map);
                }
            });
        } else {
            m(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Map<String, Object> map) {
        if (this.fo != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40014);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50010, map);
            this.fo.apply(sparseArray);
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public String mn() {
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            return jt();
        }
        return ux();
    }

    private String jt() {
        try {
            return (String) m.z(new Callable<String>() { // from class: com.bytedance.msdk.core.z.z.g.z.z.a.6
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return a.this.ux();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            wp.z(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ux() {
        Object obj;
        if (this.fo == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40015);
        sparseArray.put(-99999985, Map.class);
        Object objApply = this.fo.apply(sparseArray);
        return (!(objApply instanceof Map) || (obj = ((Map) objApply).get("request_id")) == null) ? "" : obj.toString();
    }

    @Override // com.bytedance.msdk.g.dl
    public boolean bb() {
        return gd();
    }

    private boolean gd() {
        if (this.fo == null) {
            return false;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40012);
        sparseArray.put(-99999985, Boolean.class);
        return ((Boolean) this.fo.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.msdk.g.dl
    public void kb() {
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            m.dl(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.z.a.7
                @Override // java.lang.Runnable
                public void run() {
                    a.this.zt();
                }
            });
        } else {
            zt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zt() {
        if (this.fo != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40034);
            sparseArray.put(-99999985, Boolean.class);
            this.fo.apply(sparseArray);
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public View fo() {
        uy uyVar = this.uy;
        if (uyVar != null && uyVar.gk()) {
            uf(bp());
        }
        return to();
    }

    private View to() {
        if (this.fo != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40035);
            sparseArray.put(-99999985, View.class);
            Object objApply = this.fo.apply(sparseArray);
            if (objApply != null) {
                return (View) objApply;
            }
        }
        return null;
    }

    private void uf(int i) {
        if (this.fo != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40007);
            sparseArray.put(-99999985, Boolean.class);
            sparseArray.put(50007, Integer.valueOf(i));
            this.fo.apply(sparseArray);
        }
    }

    private com.bytedance.msdk.api.a.z.z.z lz() {
        return (com.bytedance.msdk.api.a.z.z.z) this.e;
    }

    @Override // com.bytedance.msdk.g.dl, com.bytedance.sdk.openadsdk.core.ti.a
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 60009) {
            if (this.e instanceof com.bytedance.msdk.api.a.z.z.z) {
                lz().g(null);
            }
        } else if (i == 60004) {
            if (this.e instanceof com.bytedance.msdk.api.a.z.z.z) {
                lz().z((View) null);
            }
        } else if (i == 60006 && (this.e instanceof com.bytedance.msdk.api.a.z.z.z)) {
            com.bytedance.msdk.api.z.g gVar = this.wp;
            if (gVar != null) {
                com.bytedance.msdk.core.g.z.z(gVar.zw());
            }
            lz().f_();
        }
        return null;
    }
}
