package com.bytedance.msdk.core.z.z.g.z.dl;

import android.util.SparseArray;
import android.view.View;
import androidx.media3.session.SessionCommand;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.msdk.z.gc.m;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.ls.a;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends com.bytedance.msdk.g.dl {
    private Function<SparseArray<Object>, Object> fo;
    private com.bytedance.msdk.core.z.z.g.z kb;
    private uy uy;
    private com.bytedance.msdk.api.z.g wp;

    public dl(com.bytedance.msdk.core.z.z.g.z zVar, Function<SparseArray<Object>, Object> function) {
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
        if (this.fo != null) {
            Object objApply = this.fo.apply(a.z().z(40033).z(String.class).g());
            if (objApply instanceof String) {
                return (String) objApply;
            }
        }
        return "";
    }

    private String aq() {
        if (this.fo != null) {
            Object objApply = this.fo.apply(a.z().z(40032).z(String.class).g());
            if (objApply instanceof String) {
                return (String) objApply;
            }
        }
        return "";
    }

    private void mk() {
        if (this.fo != null) {
            this.fo.apply(a.z().z(40022).z(Void.class).g());
        }
    }

    private int en() {
        if (this.fo != null) {
            Object objApply = this.fo.apply(a.z().z(40021).z(Integer.class).g());
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
        }
        return 0;
    }

    private void oc() {
        if (this.fo != null) {
            this.fo.apply(a.z().z(40009).z(Void.class).z(50009, this).g());
        }
    }

    private double ou() {
        int iMt;
        if (this.fo == null) {
            return 0.0d;
        }
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            iMt = bp();
        } else {
            iMt = mt();
        }
        return iMt;
    }

    private int bp() {
        try {
            Integer num = (Integer) m.z(new Callable<Integer>() { // from class: com.bytedance.msdk.core.z.z.g.z.dl.dl.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return Integer.valueOf(dl.this.mt());
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
    public int mt() {
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
            String str = (String) m.z(new Callable<String>() { // from class: com.bytedance.msdk.core.z.z.g.z.dl.dl.2
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return dl.this.um();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            return str != null ? str : "";
        } catch (Exception e) {
            wp.z(e);
            return "";
        }
    }

    private String xt() {
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

    @Override // com.bytedance.msdk.g.dl
    public void fv() {
        super.fv();
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            m.dl(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.dl.dl.3
                @Override // java.lang.Runnable
                public void run() {
                    dl.this.re();
                }
            });
        } else {
            re();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void re() {
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
                m.a(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.dl.dl.4
                    @Override // java.lang.Runnable
                    public void run() {
                        dl.this.io(iU);
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
            m.a(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.dl.dl.5
                @Override // java.lang.Runnable
                public void run() {
                    dl.this.m((Map<String, Object>) map);
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
            return jt();
        }
        return ux();
    }

    private String jt() {
        try {
            return (String) m.z(new Callable<String>() { // from class: com.bytedance.msdk.core.z.z.g.z.dl.dl.6
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return dl.this.ux();
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
        Object objApply = this.fo.apply(a.z().z(40015).z(Map.class).g());
        return (!(objApply instanceof Map) || (obj = ((Map) objApply).get("request_id")) == null) ? "" : obj.toString();
    }

    @Override // com.bytedance.msdk.g.dl
    public boolean bb() {
        return gd();
    }

    private boolean gd() {
        if (this.fo != null) {
            Object objApply = this.fo.apply(a.z().z(40012).z(Boolean.class).g());
            if ((objApply instanceof Boolean) && ((Boolean) objApply).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.msdk.g.dl
    public void kb() {
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            m.dl(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.dl.dl.7
                @Override // java.lang.Runnable
                public void run() {
                    dl.this.zt();
                }
            });
        } else {
            zt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zt() {
        if (this.fo != null) {
            this.fo.apply(a.z().z(40034).z(Void.class).g());
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public View fo() {
        uy uyVar = this.uy;
        if (uyVar != null && uyVar.gk()) {
            uf(mt());
        }
        return to();
    }

    private View to() {
        if (this.fo != null) {
            Object objApply = this.fo.apply(a.z().z(40035).z(View.class).g());
            if (objApply instanceof View) {
                return (View) objApply;
            }
        }
        return null;
    }

    private void uf(int i) {
        if (this.fo != null) {
            this.fo.apply(a.z().z(40007).z(50007, Integer.valueOf(i)).z(Void.class).g());
        }
    }

    @Override // com.bytedance.msdk.g.dl, com.bytedance.sdk.openadsdk.core.ti.a
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 60016) {
            View view = (View) pluginValueSet.objectValue(8042, View.class);
            if (j() == 5) {
                if (this.m instanceof com.bytedance.msdk.api.a.z.dl.a) {
                    ((com.bytedance.msdk.api.a.z.dl.a) this.m).z(view, "渲染失败", MediationConstant.ErrorCode.ADN_AD_RENDER_FAIL);
                }
            } else if (this.z instanceof com.bytedance.msdk.api.a.z.e.m) {
                ((com.bytedance.msdk.api.a.z.e.m) this.z).z(view, "渲染失败", MediationConstant.ErrorCode.ADN_AD_RENDER_FAIL);
            }
        } else if (i == 60017) {
            int iIntValue = pluginValueSet.intValue(50014);
            int iIntValue2 = pluginValueSet.intValue(50016);
            if (j() == 5) {
                if (this.m instanceof com.bytedance.msdk.api.a.z.dl.a) {
                    ((com.bytedance.msdk.api.a.z.dl.a) this.m).z(iIntValue, iIntValue2);
                }
            } else if (this.z instanceof com.bytedance.msdk.api.a.z.e.m) {
                ((com.bytedance.msdk.api.a.z.e.m) this.z).z(iIntValue, iIntValue2);
            }
        } else if (i == 60009) {
            if (j() == 5) {
                if (this.m != null) {
                    this.m.z();
                }
            } else if (this.z != null) {
                this.z.z();
            }
        } else if (i == 60004) {
            if (j() == 5) {
                if (this.m != null) {
                    this.m.z(null);
                }
            } else if (this.z != null) {
                this.z.z(null);
            }
        } else if (i == 60005) {
            if (this.g != null) {
                this.g.gc();
            }
        } else if (i == 60006) {
            com.bytedance.msdk.gc.m.z(this, this.wp, "gdt信息流模板dislike接口无关闭原因");
            com.bytedance.msdk.core.g.z.z(this.wp.zw());
            if (js() != null) {
                js().z(-1, "gdt信息流模板dislike接口无关闭原因", false);
            }
        } else if (i == 60010) {
            com.bytedance.msdk.core.z.z.g.z.m.g gVar = new com.bytedance.msdk.core.z.z.g.z.m.g((Function) pluginValueSet.objectValue(SessionCommand.COMMAND_CODE_LIBRARY_GET_SEARCH_RESULT, Function.class));
            if (this.g != null) {
                this.g.z(new com.bytedance.msdk.api.z(gVar.z(), gVar.g()));
            }
        }
        return null;
    }
}
