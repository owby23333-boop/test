package com.bytedance.msdk.core.z.z.g.z.m;

import android.app.Activity;
import android.util.SparseArray;
import androidx.media3.session.SessionCommand;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.msdk.z.gc.m;
import com.bytedance.sdk.component.utils.wp;
import java.util.HashMap;
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

    @Override // com.bytedance.msdk.g.dl
    public boolean bb() {
        return true;
    }

    public dl(com.bytedance.msdk.core.z.z.g.z zVar, Function<SparseArray<Object>, Object> function) {
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
        int iEn;
        if (this.fo == null) {
            return 0.0d;
        }
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            iEn = mk();
        } else {
            iEn = en();
        }
        return iEn;
    }

    private int mk() {
        try {
            Integer num = (Integer) m.z(new Callable<Integer>() { // from class: com.bytedance.msdk.core.z.z.g.z.m.dl.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return Integer.valueOf(dl.this.en());
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
    public int en() {
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
            String str = (String) m.z(new Callable<String>() { // from class: com.bytedance.msdk.core.z.z.g.z.m.dl.2
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return dl.this.oc();
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

    private void io(int i) {
        if (this.fo != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40007);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50007, Integer.valueOf(i));
            this.fo.apply(sparseArray);
        }
    }

    private void dl(Activity activity) {
        if (this.fo != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40008);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50008, activity);
            this.fo.apply(sparseArray);
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public void z(final Activity activity, Object obj, String str) {
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            m.dl(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.m.dl.3
                @Override // java.lang.Runnable
                public void run() {
                    dl.this.a(activity);
                }
            });
        } else {
            a(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity) {
        uy uyVar = this.uy;
        if (uyVar != null && uyVar.gk()) {
            io(en());
        }
        dl(activity);
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
            Integer num = (Integer) m.z(new Callable<Integer>() { // from class: com.bytedance.msdk.core.z.z.g.z.m.dl.4
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return dl.this.um();
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
                m.a(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.m.dl.5
                    @Override // java.lang.Runnable
                    public void run() {
                        dl.this.uf(iU);
                    }
                });
            } else {
                uf(iU);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uf(int i) {
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
            m.a(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.m.dl.6
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
            return ey();
        }
        return xt();
    }

    private String ey() {
        try {
            return (String) m.z(new Callable<String>() { // from class: com.bytedance.msdk.core.z.z.g.z.m.dl.7
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return dl.this.xt();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            wp.z(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String xt() {
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

    private com.bytedance.msdk.api.a.z.gz.z re() {
        return (com.bytedance.msdk.api.a.z.gz.z) this.e;
    }

    @Override // com.bytedance.msdk.g.dl, com.bytedance.sdk.openadsdk.core.ti.a
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 60002) {
            if (!(this.e instanceof com.bytedance.msdk.api.a.z.gz.z)) {
                return null;
            }
            re().i_();
            return null;
        }
        if (i == 60004) {
            if (!(this.e instanceof com.bytedance.msdk.api.a.z.gz.z)) {
                return null;
            }
            re().j_();
            return null;
        }
        if (i == 60005) {
            if (!(this.e instanceof com.bytedance.msdk.api.a.z.gz.z)) {
                return null;
            }
            re().a();
            return null;
        }
        if (i == 60006) {
            if (!(this.e instanceof com.bytedance.msdk.api.a.z.gz.z)) {
                return null;
            }
            re().dl();
            return null;
        }
        if (i != 60007) {
            return null;
        }
        Map map = (Map) pluginValueSet.objectValue(50010, Map.class);
        if (!(this.e instanceof com.bytedance.msdk.api.a.z.gz.z)) {
            return null;
        }
        final HashMap map2 = new HashMap();
        if (map != null) {
            map2.putAll(map);
        }
        re().z(new com.bytedance.msdk.api.dl.z() { // from class: com.bytedance.msdk.core.z.z.g.z.m.dl.8
            @Override // com.bytedance.msdk.api.dl.z
            public boolean z() {
                return true;
            }

            @Override // com.bytedance.msdk.api.dl.z
            public float g() {
                if (dl.this.wp != null) {
                    return dl.this.wp.gk();
                }
                return 0.0f;
            }

            @Override // com.bytedance.msdk.api.dl.z
            public String dl() {
                return dl.this.wp != null ? dl.this.wp.h() : "";
            }

            @Override // com.bytedance.msdk.api.dl.z
            public Map<String, Object> a() {
                return map2;
            }
        });
        return null;
    }
}
