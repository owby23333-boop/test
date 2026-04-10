package com.bytedance.msdk.core.z.z.g.z.z;

import android.util.SparseArray;
import android.view.View;
import androidx.media3.session.SessionCommand;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.msdk.z.gc.m;
import com.bytedance.sdk.component.utils.wp;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g extends com.bytedance.msdk.g.dl {
    private Function<SparseArray<Object>, Object> fo;
    private volatile boolean i = false;
    private com.bytedance.msdk.core.z.z.g.z kb;
    private uy uy;
    private com.bytedance.msdk.api.z.g wp;

    public g(com.bytedance.msdk.core.z.z.g.z zVar, Function<SparseArray<Object>, Object> function) {
        this.fo = function;
        this.kb = zVar;
        this.uy = zVar.g;
        this.wp = zVar.z;
        qz();
        uy uyVar = this.uy;
        if (uyVar != null) {
            if (uyVar.x()) {
                z(aq());
            } else if (this.uy.mc()) {
                v(oc());
            }
        }
    }

    private void qz() {
        if (this.fo != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40009);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50009, this);
            this.fo.apply(sparseArray);
        }
    }

    private double aq() {
        int iMk;
        if (this.fo == null) {
            return 0.0d;
        }
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            iMk = en();
        } else {
            iMk = mk();
        }
        return iMk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int mk() {
        if (this.fo == null) {
            return 0;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40003);
        sparseArray.put(-99999985, Integer.class);
        Object objApply = this.fo.apply(sparseArray);
        int iIntValue = objApply instanceof Integer ? ((Integer) objApply).intValue() : 0;
        if (iIntValue == -1) {
            return 0;
        }
        return iIntValue;
    }

    private int en() {
        try {
            Integer num = (Integer) m.z(new Callable<Integer>() { // from class: com.bytedance.msdk.core.z.z.g.z.z.g.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return Integer.valueOf(g.this.mk());
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
    public String oc() {
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            return ou();
        }
        return bp();
    }

    private String ou() {
        try {
            String str = (String) m.z(new Callable<String>() { // from class: com.bytedance.msdk.core.z.z.g.z.z.g.2
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return g.this.oc();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            return str != null ? str : "";
        } catch (Exception e) {
            wp.z(e);
            return "";
        }
    }

    private String bp() {
        if (this.fo == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40004);
        sparseArray.put(-99999985, String.class);
        Object objApply = this.fo.apply(sparseArray);
        if (objApply instanceof String) {
            return (String) objApply;
        }
        return null;
    }

    @Override // com.bytedance.msdk.g.dl
    public Integer m() {
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            return mt();
        }
        return um();
    }

    private Integer mt() {
        try {
            Integer num = (Integer) m.z(new Callable<Integer>() { // from class: com.bytedance.msdk.core.z.z.g.z.z.g.3
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return g.this.um();
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
    public Integer um() {
        if (this.fo != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, Integer.valueOf(SessionCommand.COMMAND_CODE_SESSION_SET_RATING));
            sparseArray.put(-99999985, Boolean.class);
            if (((Boolean) this.fo.apply(sparseArray)).booleanValue()) {
                return 2;
            }
        }
        return 4;
    }

    @Override // com.bytedance.msdk.g.dl
    public void fv() {
        super.fv();
        this.i = true;
        m.dl(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.z.g.4
            @Override // java.lang.Runnable
            public void run() {
                g.this.ey();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ey() {
        if (this.fo != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40011);
            sparseArray.put(-99999985, Void.class);
            this.fo.apply(sparseArray);
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public boolean gc() {
        return this.i;
    }

    @Override // com.bytedance.msdk.g.dl
    public void g(Map<String, Object> map) {
        uy uyVar = this.uy;
        if (uyVar != null && uyVar.x()) {
            final int iU = (int) u();
            com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
            if (zVar != null && zVar.dl()) {
                m.a(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.z.g.5
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
            m.a(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.z.g.6
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
            return xt();
        }
        return re();
    }

    private String xt() {
        try {
            return (String) m.z(new Callable<String>() { // from class: com.bytedance.msdk.core.z.z.g.z.z.g.7
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return g.this.re();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String re() {
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

    private com.bytedance.msdk.api.a.z.z.z jt() {
        return (com.bytedance.msdk.api.a.z.z.z) this.e;
    }

    @Override // com.bytedance.msdk.g.dl
    public View fo() {
        return ux();
    }

    private View ux() {
        if (this.fo != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40035);
            sparseArray.put(-99999985, View.class);
            Object objApply = this.fo.apply(sparseArray);
            if (objApply instanceof View) {
                return (View) objApply;
            }
        }
        return null;
    }

    @Override // com.bytedance.msdk.g.dl, com.bytedance.sdk.openadsdk.core.ti.a
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 60009) {
            if (this.e instanceof com.bytedance.msdk.api.a.z.z.z) {
                jt().g(null);
            }
        } else if (i == 60006) {
            if (this.e instanceof com.bytedance.msdk.api.a.z.z.z) {
                com.bytedance.msdk.api.z.g gVar = this.wp;
                if (gVar != null) {
                    com.bytedance.msdk.core.g.z.z(gVar.zw());
                }
                jt().f_();
            }
        } else if (i == 60004 && (this.e instanceof com.bytedance.msdk.api.a.z.z.z)) {
            jt().z((View) null);
        }
        return null;
    }
}
