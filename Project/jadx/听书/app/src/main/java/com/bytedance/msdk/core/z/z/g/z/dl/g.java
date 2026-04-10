package com.bytedance.msdk.core.z.z.g.z.dl;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.media3.session.SessionCommand;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.gromore.R;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.msdk.z.gc.m;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.ls.a;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g extends com.bytedance.msdk.g.dl {
    private Function<SparseArray<Object>, Object> fo;
    private Context i;
    private com.bytedance.msdk.core.z.z.g.z kb;
    private uy uy;
    private com.bytedance.msdk.api.z.g wp;

    @Override // com.bytedance.msdk.g.dl
    public boolean bb() {
        return true;
    }

    public g(Context context, com.bytedance.msdk.core.z.z.g.z zVar, Function<SparseArray<Object>, Object> function) {
        this.i = context;
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
            Integer num = (Integer) m.z(new Callable<Integer>() { // from class: com.bytedance.msdk.core.z.z.g.z.dl.g.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return Integer.valueOf(g.this.aq());
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
            Object objApply = this.fo.apply(a.z().z(40053).z(Void.class).g());
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
        Function<SparseArray<Object>, Object> function = this.fo;
        if (function != null) {
            Object objApply = function.apply(a.z().z(40052).z(Boolean.class).g());
            if ((objApply instanceof Boolean) && ((Boolean) objApply).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    private double en() {
        Function<SparseArray<Object>, Object> function = this.fo;
        if (function != null) {
            Object objApply = function.apply(a.z().z(40051).z(Integer.class).g());
            if (objApply instanceof Integer) {
                return ((Double) objApply).doubleValue();
            }
        }
        return 0.0d;
    }

    private List<String> oc() {
        Function<SparseArray<Object>, Object> function = this.fo;
        if (function != null) {
            Object objApply = function.apply(a.z().z(40050).z(List.class).g());
            if (objApply instanceof List) {
                return (List) objApply;
            }
        }
        return null;
    }

    private int ou() {
        Function<SparseArray<Object>, Object> function = this.fo;
        if (function != null) {
            Object objApply = function.apply(a.z().z(40049).z(Integer.class).g());
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
        }
        return 0;
    }

    private int bp() {
        Function<SparseArray<Object>, Object> function = this.fo;
        if (function != null) {
            Object objApply = function.apply(a.z().z(40048).z(Integer.class).g());
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
        }
        return 0;
    }

    private String mt() {
        Function<SparseArray<Object>, Object> function = this.fo;
        if (function == null) {
            return "";
        }
        Object objApply = function.apply(a.z().z(40047).z(String.class).g());
        if (objApply instanceof String) {
            return (String) objApply;
        }
        return null;
    }

    private String um() {
        Function<SparseArray<Object>, Object> function = this.fo;
        if (function == null) {
            return "";
        }
        Object objApply = function.apply(a.z().z(40046).z(String.class).g());
        if (objApply instanceof String) {
            return (String) objApply;
        }
        return null;
    }

    private String ey() {
        Function<SparseArray<Object>, Object> function = this.fo;
        if (function == null) {
            return "";
        }
        Object objApply = function.apply(a.z().z(40045).z(String.class).g());
        if (objApply instanceof String) {
            return (String) objApply;
        }
        return null;
    }

    private String xt() {
        Function<SparseArray<Object>, Object> function = this.fo;
        if (function == null) {
            return "";
        }
        Object objApply = function.apply(a.z().z(40033).z(String.class).g());
        if (objApply instanceof String) {
            return (String) objApply;
        }
        return null;
    }

    private String re() {
        Function<SparseArray<Object>, Object> function = this.fo;
        if (function == null) {
            return "";
        }
        Object objApply = function.apply(a.z().z(40032).z(String.class).g());
        if (objApply instanceof String) {
            return (String) objApply;
        }
        return null;
    }

    private String jt() {
        Function<SparseArray<Object>, Object> function = this.fo;
        if (function == null) {
            return "";
        }
        Object objApply = function.apply(a.z().z(40044).z(String.class).g());
        if (objApply instanceof String) {
            return (String) objApply;
        }
        return null;
    }

    private String ux() {
        Function<SparseArray<Object>, Object> function = this.fo;
        if (function == null) {
            return "";
        }
        Object objApply = function.apply(a.z().z(40043).z(String.class).g());
        if (objApply instanceof String) {
            return (String) objApply;
        }
        return null;
    }

    private String gd() {
        Function<SparseArray<Object>, Object> function = this.fo;
        if (function == null) {
            return "";
        }
        Object objApply = function.apply(a.z().z(40042).z(String.class).g());
        if (objApply instanceof String) {
            return (String) objApply;
        }
        return null;
    }

    private String zt() {
        Function<SparseArray<Object>, Object> function = this.fo;
        if (function == null) {
            return "";
        }
        Object objApply = function.apply(a.z().z(40041).z(String.class).g());
        if (objApply instanceof String) {
            return (String) objApply;
        }
        return null;
    }

    private long to() {
        Function<SparseArray<Object>, Object> function = this.fo;
        if (function != null) {
            Object objApply = function.apply(a.z().z(40040).z(Long.class).g());
            if (objApply instanceof Long) {
                return ((Long) objApply).longValue();
            }
        }
        return 0L;
    }

    private String lz() {
        Function<SparseArray<Object>, Object> function = this.fo;
        if (function == null) {
            return "";
        }
        Object objApply = function.apply(a.z().z(40039).z(Long.class).g());
        if (objApply instanceof String) {
            return (String) objApply;
        }
        return null;
    }

    private String jh() {
        Function<SparseArray<Object>, Object> function = this.fo;
        if (function == null) {
            return "";
        }
        Object objApply = function.apply(a.z().z(40038).z(Long.class).g());
        if (objApply instanceof String) {
            return (String) objApply;
        }
        return null;
    }

    private int fq() {
        Function<SparseArray<Object>, Object> function = this.fo;
        if (function != null) {
            Object objApply = function.apply(a.z().z(40021).z(Integer.class).g());
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
        }
        return 0;
    }

    private void rw() {
        Function<SparseArray<Object>, Object> function = this.fo;
        if (function != null) {
            function.apply(a.z().z(40009).z(50009, this).z(Integer.class).g());
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

    private int rg() {
        try {
            Integer num = (Integer) m.z(new Callable<Integer>() { // from class: com.bytedance.msdk.core.z.z.g.z.dl.g.7
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return Integer.valueOf(g.this.po());
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
            String str = (String) m.z(new Callable<String>() { // from class: com.bytedance.msdk.core.z.z.g.z.dl.g.8
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return g.this.fs();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            return str != null ? str : "";
        } catch (Exception e) {
            wp.z(e);
            return "";
        }
    }

    private String ep() {
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
    public void z(final Activity activity, final ViewGroup viewGroup, final List<View> list, final List<View> list2, final List<View> list3, final com.bytedance.msdk.api.a.z.e.uy uyVar, List<View> list4) {
        super.z(activity, viewGroup, list, list2, list3, uyVar, list4);
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            m.dl(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.dl.g.9
                @Override // java.lang.Runnable
                public void run() {
                    g.this.z(activity, viewGroup, (List<View>) list, (List<View>) list2, (List<View>) list3, uyVar);
                }
            });
        } else {
            z(activity, viewGroup, list, list2, list3, uyVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.a.z.e.uy uyVar) {
        ViewGroup viewGroupG;
        Object tag;
        if (list3 != null) {
            if (list2 == null) {
                list2 = new ArrayList<>();
            }
            list2.addAll(list3);
        }
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
        z(context, viewGroupG, ct(), list, list2);
        if (uyVar != null) {
            z(context, viewGroup, uyVar);
        } else {
            g(list2);
        }
        ry();
    }

    private void z(Context context, ViewGroup viewGroup, com.bytedance.msdk.api.a.z.e.uy uyVar) {
        FrameLayout frameLayoutZ;
        if (viewGroup == null || uyVar == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(uyVar.e);
        if (frameLayout != null && nh() == 5 && (frameLayoutZ = z(context)) != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(frameLayoutZ, -1, -1);
            z(frameLayoutZ);
        }
        if (TextUtils.isEmpty(ey())) {
            return;
        }
        View viewFindViewById = viewGroup.findViewById(uyVar.f358a);
        ArrayList arrayList = new ArrayList();
        arrayList.add(viewFindViewById);
        dl(arrayList);
    }

    private void g(List<View> list) {
        if (TextUtils.isEmpty(ey())) {
            return;
        }
        dl(list);
    }

    @Override // com.bytedance.msdk.g.dl
    public View uy() {
        if (!(com.bytedance.msdk.z.gc.z.z(this.i) instanceof Context)) {
            return null;
        }
        final FrameLayout frameLayoutZ = z(this.i);
        if (frameLayoutZ != null) {
            frameLayoutZ.removeAllViews();
            frameLayoutZ.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            if (frameLayoutZ.getViewTreeObserver() != null) {
                frameLayoutZ.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.msdk.core.z.z.g.z.dl.g.10
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        if (frameLayoutZ.getVisibility() == 0) {
                            g.this.z(frameLayoutZ);
                            if (frameLayoutZ.getViewTreeObserver() != null) {
                                frameLayoutZ.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                        }
                    }
                });
            }
        }
        return frameLayoutZ;
    }

    private void ry() {
        Function<SparseArray<Object>, Object> function = this.fo;
        if (function != null) {
            function.apply(a.z().z(40060).z(Void.class).g());
        }
    }

    private void dl(List<View> list) {
        Function<SparseArray<Object>, Object> function = this.fo;
        if (function != null) {
            function.apply(a.z().z(40059).z(50021, list).z(Void.class).g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(FrameLayout frameLayout) {
        Object obj;
        if (this.fo != null) {
            a aVarZ = a.z().z(40058).z(50013, frameLayout).z(Void.class);
            com.bytedance.msdk.api.z.g gVar = this.wp;
            if (gVar != null && gVar.oq() != null && (obj = this.wp.oq().get(MediationConstant.KEY_GDT_VIDEO_OPTION)) != null) {
                aVarZ.z(50020, obj);
            }
            this.fo.apply(aVarZ.g());
        }
    }

    private FrameLayout z(Context context) {
        Function<SparseArray<Object>, Object> function = this.fo;
        if (function != null && context != null) {
            Object objApply = function.apply(a.z().z(40057).z(10000, context).z(FrameLayout.class).g());
            if (objApply instanceof FrameLayout) {
                return (FrameLayout) objApply;
            }
        }
        return null;
    }

    private void z(Context context, ViewGroup viewGroup, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        if (this.fo == null || context == null) {
            return;
        }
        a.z().z(40056).z(Void.class).z(10000, context).z(50013, viewGroup).z(50017, layoutParams).z(50018, list).z(50019, list2);
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
        if (this.fo != null && context != null) {
            Object objApply = this.fo.apply(a.z().z(40055).z(10000, context).z(ViewGroup.class).g());
            if (objApply instanceof ViewGroup) {
                return (ViewGroup) objApply;
            }
        }
        return null;
    }

    private boolean dl(View view) {
        if (this.fo != null) {
            Object objApply = this.fo.apply(a.z().z(40054).z(50013, view).z(Boolean.class).g());
            if ((objApply instanceof Boolean) && ((Boolean) objApply).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    private void io(int i) {
        if (this.fo != null) {
            this.fo.apply(a.z().z(40007).z(50007, Integer.valueOf(i)).z(Void.class).g());
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
            Integer num = (Integer) m.z(new Callable<Integer>() { // from class: com.bytedance.msdk.core.z.z.g.z.dl.g.11
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return g.this.cn();
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
        m.dl(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.dl.g.12
            @Override // java.lang.Runnable
            public void run() {
                g.this.ka();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ka() {
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
                m.a(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.dl.g.13
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.uf(iU);
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
            m.a(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.dl.g.14
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
            return rh();
        }
        return tp();
    }

    private String rh() {
        try {
            return (String) m.z(new Callable<String>() { // from class: com.bytedance.msdk.core.z.z.g.z.dl.g.2
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return g.this.tp();
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
        Object objApply = this.fo.apply(a.z().z(40015).z(Map.class).g());
        return (!(objApply instanceof Map) || (obj = ((Map) objApply).get("request_id")) == null) ? "" : obj.toString();
    }

    @Override // com.bytedance.msdk.g.dl
    public void p() {
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            m.dl(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.dl.g.3
                @Override // java.lang.Runnable
                public void run() {
                    g.this.nv();
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
            m.dl(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.dl.g.4
                @Override // java.lang.Runnable
                public void run() {
                    g.this.zr();
                }
            });
        } else {
            zr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nv() {
        if (this.fo != null) {
            this.fo.apply(a.z().z(40061).z(Void.class).g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zr() {
        if (this.fo != null) {
            this.fo.apply(a.z().z(40062).z(Void.class).g());
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public void z() {
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            m.dl(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.dl.g.5
                @Override // java.lang.Runnable
                public void run() {
                    g.this.tk();
                }
            });
        } else {
            tk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tk() {
        if (this.fo != null) {
            this.fo.apply(a.z().z(40063).z(Void.class).g());
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public void g() {
        com.bytedance.msdk.core.z.z.g.z zVar = this.kb;
        if (zVar != null && zVar.dl()) {
            m.dl(new Runnable() { // from class: com.bytedance.msdk.core.z.z.g.z.dl.g.6
                @Override // java.lang.Runnable
                public void run() {
                    g.this.st();
                }
            });
        } else {
            st();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void st() {
        if (this.fo != null) {
            this.fo.apply(a.z().z(40064).z(Void.class).g());
        }
    }

    @Override // com.bytedance.msdk.g.dl, com.bytedance.sdk.openadsdk.core.ti.a
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 60018) {
            if (this.g != null) {
                this.g.g();
            }
        } else if (i == 60019) {
            if (this.g != null) {
                this.g.dl();
            }
        } else if (i == 60020) {
            if (this.g != null) {
                this.g.a();
            }
        } else if (i == 60005) {
            if (this.g != null) {
                this.g.gc();
            }
        } else if (i == 60010) {
            com.bytedance.msdk.core.z.z.g.z.m.g gVar = new com.bytedance.msdk.core.z.z.g.z.m.g((Function) pluginValueSet.objectValue(SessionCommand.COMMAND_CODE_LIBRARY_GET_SEARCH_RESULT, Function.class));
            if (this.g != null) {
                this.g.z(new com.bytedance.msdk.api.z(gVar.z(), gVar.g()));
            }
        } else if (i == 60004) {
            if (j() == 5) {
                if (this.m != null) {
                    this.m.z(null);
                }
            } else if (this.z != null) {
                this.z.z(null);
            }
        } else if (i == 60009) {
            if (j() == 5) {
                if (this.m != null) {
                    this.m.z();
                }
            } else if (this.z != null) {
                this.z.z();
            }
        }
        return null;
    }
}
