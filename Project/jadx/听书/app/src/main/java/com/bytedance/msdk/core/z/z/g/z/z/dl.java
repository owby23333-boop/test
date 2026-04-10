package com.bytedance.msdk.core.z.z.g.z.z;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.media3.session.SessionCommand;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.gromore.R;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.msdk.z.gc.m;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
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
        rw();
        iq(jh());
        zw(lz());
        g(to());
        tb((int) to());
        io(zt());
        uf(gd());
        sy(ux());
        wp(jt());
        x(re());
        lq(xt());
        h(ey());
        hh(um());
        l(mt());
        fv(bp());
        fv(ou());
        z(oc());
        a(en());
        mc(re());
        gz(mk());
        uy uyVar = this.uy;
        if (uyVar != null) {
            if (uyVar.x()) {
                z(gl());
            } else if (this.uy.mc()) {
                v(fs());
            }
        }
        if (fq() == 2) {
            kb(5);
        } else if (fq() != 1 && fq() != 4 && fq() == 3) {
            kb(4);
        } else {
            kb(3);
        }
        if (mk()) {
            wp(4);
        } else {
            wp(3);
        }
        e(false);
    }

    @Override // com.bytedance.msdk.g.dl
    public int a() {
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            return qz();
        }
        return aq();
    }

    private int qz() {
        try {
            Integer num = (Integer) m.z(new Callable<Integer>() { // from class: com.bytedance.msdk.core.z.z.g.z.z.dl.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return Integer.valueOf(dl.this.aq());
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            if (num != null) {
                return num.intValue();
            }
            return 1;
        } catch (Exception e) {
            wp.z(e);
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aq() {
        if (this.fo != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40053);
            sparseArray.put(-99999985, Integer.class);
            Object objApply = this.fo.apply(sparseArray);
            int iIntValue = objApply instanceof Integer ? ((Integer) objApply).intValue() : -1;
            if (iIntValue == 0) {
                return 0;
            }
            if (iIntValue == 1) {
                return 6;
            }
            if (iIntValue == 2) {
                return 8;
            }
            if (iIntValue == 4) {
                return 2;
            }
            if (iIntValue == 8) {
                return 5;
            }
            if (iIntValue == 16) {
                return 4;
            }
            if (iIntValue == 32) {
                return 3;
            }
            if (iIntValue == 64) {
                return 7;
            }
        }
        return 1;
    }

    private boolean mk() {
        if (this.fo == null) {
            return false;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40052);
        sparseArray.put(-99999985, Boolean.class);
        return ((Boolean) this.fo.apply(sparseArray)).booleanValue();
    }

    private double en() {
        if (this.fo != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40051);
            sparseArray.put(-99999985, Integer.class);
            Object objApply = this.fo.apply(sparseArray);
            if (objApply instanceof Integer) {
                return ((Double) objApply).doubleValue();
            }
        }
        return 0.0d;
    }

    private List<String> oc() {
        if (this.fo != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40050);
            sparseArray.put(-99999985, List.class);
            Object objApply = this.fo.apply(sparseArray);
            if (objApply instanceof List) {
                return (List) objApply;
            }
        }
        return null;
    }

    private int ou() {
        if (this.fo != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40049);
            sparseArray.put(-99999985, Integer.class);
            Object objApply = this.fo.apply(sparseArray);
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
        }
        return 0;
    }

    private int bp() {
        if (this.fo != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40048);
            sparseArray.put(-99999985, Integer.class);
            Object objApply = this.fo.apply(sparseArray);
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
        }
        return 0;
    }

    private String mt() {
        if (this.fo == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40047);
        sparseArray.put(-99999985, String.class);
        return (String) this.fo.apply(sparseArray);
    }

    private String um() {
        if (this.fo == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40046);
        sparseArray.put(-99999985, String.class);
        return (String) this.fo.apply(sparseArray);
    }

    private String ey() {
        if (this.fo == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40045);
        sparseArray.put(-99999985, String.class);
        return (String) this.fo.apply(sparseArray);
    }

    private String xt() {
        if (this.fo == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40033);
        sparseArray.put(-99999985, String.class);
        return (String) this.fo.apply(sparseArray);
    }

    private String re() {
        if (this.fo == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40032);
        sparseArray.put(-99999985, String.class);
        return (String) this.fo.apply(sparseArray);
    }

    private String jt() {
        if (this.fo == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40044);
        sparseArray.put(-99999985, String.class);
        return (String) this.fo.apply(sparseArray);
    }

    private String ux() {
        if (this.fo == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40043);
        sparseArray.put(-99999985, String.class);
        return (String) this.fo.apply(sparseArray);
    }

    private String gd() {
        if (this.fo == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40042);
        sparseArray.put(-99999985, String.class);
        return (String) this.fo.apply(sparseArray);
    }

    private String zt() {
        if (this.fo == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40041);
        sparseArray.put(-99999985, String.class);
        return (String) this.fo.apply(sparseArray);
    }

    private long to() {
        if (this.fo == null) {
            return 0L;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40040);
        sparseArray.put(-99999985, Long.class);
        return ((Long) this.fo.apply(sparseArray)).longValue();
    }

    private String lz() {
        if (this.fo == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40039);
        sparseArray.put(-99999985, String.class);
        return (String) this.fo.apply(sparseArray);
    }

    private String jh() {
        if (this.fo == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40038);
        sparseArray.put(-99999985, String.class);
        return (String) this.fo.apply(sparseArray);
    }

    private int fq() {
        if (this.fo == null) {
            return 0;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40021);
        sparseArray.put(-99999985, Integer.class);
        return ((Integer) this.fo.apply(sparseArray)).intValue();
    }

    private void rw() {
        if (this.fo != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40009);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50009, this);
            this.fo.apply(sparseArray);
        }
    }

    private double gl() {
        int iPo;
        if (this.fo == null) {
            return 0.0d;
        }
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            iPo = rg();
        } else {
            iPo = po();
        }
        return iPo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int po() {
        if (this.fo == null) {
            return 0;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40003);
        sparseArray.put(-99999985, Integer.class);
        int iIntValue = ((Integer) this.fo.apply(sparseArray)).intValue();
        if (iIntValue == -1) {
            return 0;
        }
        return iIntValue;
    }

    private int rg() {
        try {
            Integer num = (Integer) m.z(new Callable<Integer>() { // from class: com.bytedance.msdk.core.z.z.g.z.z.dl.6
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return Integer.valueOf(dl.this.po());
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
    public String fs() {
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            return ib();
        }
        return ep();
    }

    private String ib() {
        try {
            String str = (String) m.z(new Callable<String>() { // from class: com.bytedance.msdk.core.z.z.g.z.z.dl.7
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return dl.this.fs();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            return str != null ? str : "";
        } catch (Exception e) {
            wp.z(e);
            return "";
        }
    }

    private String ep() {
        if (this.fo == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40004);
        sparseArray.put(-99999985, String.class);
        return (String) this.fo.apply(sparseArray);
    }

    @Override // com.bytedance.msdk.g.dl
    public void z(final Activity activity, final ViewGroup viewGroup, final List<View> list, final List<View> list2, final List<View> list3, final com.bytedance.msdk.api.a.z.e.uy uyVar, List<View> list4) {
        super.z(activity, viewGroup, list, list2, list3, uyVar, list4);
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            m.dl(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.z.dl.8
                @Override // java.lang.Runnable
                public void run() {
                    dl.this.z(activity, viewGroup, (List<View>) list, (List<View>) list2, (List<View>) list3, uyVar);
                }
            });
        } else {
            z(activity, viewGroup, list, list2, list3, uyVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.a.z.e.uy uyVar) {
        ViewGroup viewGroupG;
        FrameLayout frameLayoutZ;
        Object tag;
        if (list3 != null) {
            if (list2 == null) {
                list2 = new ArrayList<>();
            }
            list2.addAll(list3);
        }
        List<View> list4 = list2;
        uy uyVar2 = this.uy;
        if (uyVar2 != null && uyVar2.gk()) {
            io(po());
        }
        if (context == null) {
            context = viewGroup.getContext();
        }
        int i = 0;
        if (viewGroup.getChildCount() != 0 && dl(viewGroup.getChildAt(0))) {
            viewGroupG = (ViewGroup) viewGroup.getChildAt(0);
            while (i < viewGroupG.getChildCount()) {
                View childAt = viewGroupG.getChildAt(i);
                if (childAt == null || ((tag = childAt.getTag(R.id.tt_mediation_gdt_developer_view_tag_key)) != null && (tag instanceof String) && ((String) tag).equals(MediationConstant.TT_GDT_NATIVE_VIEW_TAG))) {
                    i++;
                } else {
                    viewGroupG.removeView(childAt);
                }
            }
        } else {
            viewGroupG = g(context);
            if (viewGroupG != null) {
                viewGroupG.setTag(R.id.tt_mediation_gdt_developer_view_root_tag_key, MediationConstant.TT_GDT_NATIVE_ROOT_VIEW_TAG);
                while (viewGroup.getChildCount() > 0) {
                    View childAt2 = viewGroup.getChildAt(0);
                    childAt2.setTag(R.id.tt_mediation_gdt_developer_view_tag_key, MediationConstant.TT_GDT_NATIVE_VIEW_TAG);
                    viewGroup.removeViewInLayout(childAt2);
                    if (childAt2 != null) {
                        viewGroupG.addView(childAt2, childAt2.getLayoutParams());
                    }
                }
                viewGroup.removeAllViews();
                viewGroup.addView(viewGroupG, -1, -1);
            }
        }
        ViewGroup viewGroup2 = viewGroupG;
        FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(uyVar.e);
        z(context, viewGroup2, ct(), list, list4);
        if (frameLayout != null && nh() == 5 && (frameLayoutZ = z(context)) != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(frameLayoutZ, -1, -1);
            z(frameLayoutZ);
        }
        if (!TextUtils.isEmpty(ey())) {
            View viewFindViewById = viewGroup.findViewById(uyVar.f358a);
            ArrayList arrayList = new ArrayList();
            arrayList.add(viewFindViewById);
            g(arrayList);
        }
        ry();
    }

    private void ry() {
        if (this.fo != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40060);
            sparseArray.put(-99999985, Void.class);
            this.fo.apply(sparseArray);
        }
    }

    private void g(List<View> list) {
        if (this.fo != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40059);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50021, list);
            this.fo.apply(sparseArray);
        }
    }

    private void z(FrameLayout frameLayout) {
        Object obj;
        if (this.fo != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40058);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50013, frameLayout);
            com.bytedance.msdk.api.z.g gVar = this.wp;
            if (gVar != null && gVar.oq() != null && (obj = this.wp.oq().get(MediationConstant.KEY_GDT_VIDEO_OPTION)) != null) {
                sparseArray.put(50020, obj);
            }
            this.fo.apply(sparseArray);
        }
    }

    private FrameLayout z(Context context) {
        if (this.fo == null || context == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40057);
        sparseArray.put(-99999985, FrameLayout.class);
        sparseArray.put(10000, context);
        return (FrameLayout) this.fo.apply(sparseArray);
    }

    private void z(Context context, ViewGroup viewGroup, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        if (this.fo == null || context == null) {
            return;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40056);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(10000, context);
        sparseArray.put(50013, viewGroup);
        sparseArray.put(50017, layoutParams);
        sparseArray.put(50018, list);
        sparseArray.put(50019, list2);
        this.fo.apply(sparseArray);
    }

    private FrameLayout.LayoutParams ct() {
        com.bytedance.msdk.api.z.g gVar = this.wp;
        if (gVar == null || gVar.oq() == null) {
            return null;
        }
        Object obj = this.wp.oq().get(MediationConstant.KEY_GDT_NATIVE_LOGO_PARAMS);
        if (obj instanceof FrameLayout.LayoutParams) {
            return (FrameLayout.LayoutParams) obj;
        }
        return null;
    }

    private ViewGroup g(Context context) {
        if (this.fo == null || context == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40055);
        sparseArray.put(-99999985, ViewGroup.class);
        sparseArray.put(10000, context);
        return (ViewGroup) this.fo.apply(sparseArray);
    }

    private boolean dl(View view) {
        if (this.fo == null) {
            return false;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40055);
        sparseArray.put(-99999985, Boolean.class);
        sparseArray.put(50013, view);
        return ((Boolean) this.fo.apply(sparseArray)).booleanValue();
    }

    private void io(int i) {
        if (this.fo != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40007);
            sparseArray.put(-99999985, Boolean.class);
            sparseArray.put(50007, Integer.valueOf(i));
            this.fo.apply(sparseArray);
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public Integer m() {
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            return w();
        }
        return cn();
    }

    private Integer w() {
        try {
            Integer num = (Integer) m.z(new Callable<Integer>() { // from class: com.bytedance.msdk.core.z.z.g.z.z.dl.9
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return dl.this.cn();
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
    public Integer cn() {
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
        m.dl(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.z.dl.10
            @Override // java.lang.Runnable
            public void run() {
                dl.this.ka();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ka() {
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
                m.a(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.z.dl.11
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
            m.a(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.z.dl.12
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
            return rh();
        }
        return tp();
    }

    private String rh() {
        try {
            return (String) m.z(new Callable<String>() { // from class: com.bytedance.msdk.core.z.z.g.z.z.dl.13
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return dl.this.tp();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            wp.z(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String tp() {
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
    public void p() {
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            m.dl(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.z.dl.2
                @Override // java.lang.Runnable
                public void run() {
                    dl.this.nv();
                }
            });
        } else {
            nv();
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public void ls() {
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            m.dl(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.z.dl.3
                @Override // java.lang.Runnable
                public void run() {
                    dl.this.zr();
                }
            });
        } else {
            zr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nv() {
        if (this.fo != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40061);
            sparseArray.put(-99999985, Void.class);
            this.fo.apply(sparseArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zr() {
        if (this.fo != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40062);
            sparseArray.put(-99999985, Void.class);
            this.fo.apply(sparseArray);
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public void z() {
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            m.a(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.z.dl.4
                @Override // java.lang.Runnable
                public void run() {
                    dl.this.tk();
                }
            });
        } else {
            tk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tk() {
        if (this.fo != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40063);
            sparseArray.put(-99999985, Void.class);
            this.fo.apply(sparseArray);
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public void g() {
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            m.a(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.z.dl.5
                @Override // java.lang.Runnable
                public void run() {
                    dl.this.st();
                }
            });
        } else {
            st();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void st() {
        if (this.fo != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40064);
            sparseArray.put(-99999985, Void.class);
            this.fo.apply(sparseArray);
        }
    }

    private com.bytedance.msdk.api.a.z.z.z mz() {
        return (com.bytedance.msdk.api.a.z.z.z) this.e;
    }

    @Override // com.bytedance.msdk.g.dl, com.bytedance.sdk.openadsdk.core.ti.a
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 60004) {
            if (this.e instanceof com.bytedance.msdk.api.a.z.z.z) {
                mz().z((View) null);
            }
        } else if (i == 60009 && (this.e instanceof com.bytedance.msdk.api.a.z.z.z)) {
            mz().g(null);
        }
        return null;
    }
}
