package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bytedance.sdk.component.adexpress.dynamic.dl.gz;
import com.bytedance.sdk.component.adexpress.dynamic.dl.m;
import com.bytedance.sdk.component.adexpress.g.i;
import com.bytedance.sdk.component.adexpress.g.kb;
import com.bytedance.sdk.component.adexpress.g.v;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicRootView extends FrameLayout implements com.bytedance.sdk.component.adexpress.dynamic.a, com.bytedance.sdk.component.adexpress.theme.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private kb f559a;
    public View dl;
    private ThemeStatusBroadcastReceiver e;
    private ViewGroup fo;
    private Map<Integer, String> fv;
    boolean g;
    private DynamicBaseWidget gc;
    private com.bytedance.sdk.component.adexpress.dynamic.g gz;
    private int i;
    private List<com.bytedance.sdk.component.adexpress.dynamic.dl> kb;
    private Context ls;
    private com.bytedance.sdk.component.adexpress.dynamic.gc.z m;
    private String p;
    private i pf;
    private int uy;
    private int v;
    private com.bytedance.sdk.component.adexpress.dynamic.gc wp;
    protected final v z;

    public DynamicRootView(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, i iVar, com.bytedance.sdk.component.adexpress.dynamic.gc.z zVar) {
        super(context);
        this.fo = null;
        this.uy = 0;
        this.kb = new ArrayList();
        this.i = 0;
        this.v = 0;
        this.ls = context;
        v vVar = new v();
        this.z = vVar;
        vVar.z(2);
        this.m = zVar;
        zVar.z(this);
        this.e = themeStatusBroadcastReceiver;
        themeStatusBroadcastReceiver.z(this);
        this.g = z;
        this.pf = iVar;
    }

    public String getBgColor() {
        return this.p;
    }

    public void setBgColor(String str) {
        this.p = str;
    }

    public void setRenderListener(kb kbVar) {
        this.f559a = kbVar;
        this.m.z(kbVar);
    }

    public void z(gz gzVar, int i) {
        this.gc = z(gzVar, this, i);
        this.z.z(true);
        this.z.z(this.gc.gc);
        this.z.g(this.gc.m);
        this.z.z(this.dl);
        this.f559a.z(this.z);
    }

    public DynamicBaseWidget z(gz gzVar, ViewGroup viewGroup, int i) {
        if (gzVar == null) {
            return null;
        }
        List<gz> listKb = gzVar.kb();
        DynamicBaseWidget dynamicBaseWidgetZ = com.bytedance.sdk.component.adexpress.dynamic.z.g.z(this.ls, this, gzVar);
        if (dynamicBaseWidgetZ instanceof DynamicUnKnowView) {
            z(i == 3 ? 128 : TTVideoEngine.PLAYER_BUFFERING_DATA_OF_MILLISECONDS, "unknow widget");
            return null;
        }
        z(gzVar);
        dynamicBaseWidgetZ.z();
        if (viewGroup != null) {
            viewGroup.addView(dynamicBaseWidgetZ);
            z(viewGroup, gzVar);
        }
        if (listKb == null || listKb.size() <= 0) {
            return null;
        }
        Iterator<gz> it = listKb.iterator();
        while (it.hasNext()) {
            z(it.next(), dynamicBaseWidgetZ, i);
        }
        return dynamicBaseWidgetZ;
    }

    private void z(gz gzVar) {
        m mVarGc;
        com.bytedance.sdk.component.adexpress.dynamic.dl.gc gcVarUy = gzVar.uy();
        if (gcVarUy == null || (mVarGc = gcVarUy.gc()) == null) {
            return;
        }
        this.z.g(mVarGc.te());
    }

    public Map<Integer, String> getBgMaterialCenterCalcColor() {
        return this.fv;
    }

    public void setBgMaterialCenterCalcColor(Map<Integer, String> map) {
        this.fv = map;
    }

    private void z(ViewGroup viewGroup, gz gzVar) {
        ViewGroup viewGroup2;
        if (viewGroup == null || (viewGroup2 = (ViewGroup) viewGroup.getParent()) == null || !gzVar.io()) {
            return;
        }
        viewGroup2.setClipChildren(false);
        viewGroup2.setClipToPadding(false);
        ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
        if (viewGroup3 != null) {
            viewGroup3.setClipChildren(false);
            viewGroup3.setClipToPadding(false);
        }
    }

    public void z(double d, double d2, double d3, double d4, float f) {
        this.z.dl(d);
        this.z.a(d2);
        this.z.gc(d3);
        this.z.m(d4);
        this.z.z(f);
        this.z.g(f);
        this.z.dl(f);
        this.z.a(f);
    }

    public void z(int i, String str) {
        this.z.z(false);
        this.z.g(i);
        this.z.z(str);
        this.f559a.z(this.z);
    }

    public void setMuteListener(com.bytedance.sdk.component.adexpress.dynamic.g gVar) {
        this.gz = gVar;
    }

    public void setDislikeView(View view) {
        this.m.g(view);
    }

    public kb getRenderListener() {
        return this.f559a;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.gc.z getDynamicClickListener() {
        return this.m;
    }

    @Override // com.bytedance.sdk.component.adexpress.theme.z
    public void b_(int i) {
        DynamicBaseWidget dynamicBaseWidget = this.gc;
        if (dynamicBaseWidget == null) {
            return;
        }
        dynamicBaseWidget.z(i);
    }

    public void z() {
        z(this.gc, 0);
    }

    public void g() {
        z(this.gc, 4);
    }

    public void z(DynamicBaseWidget dynamicBaseWidget, int i) {
        if (dynamicBaseWidget == null) {
            return;
        }
        if (dynamicBaseWidget.getBeginInvisibleAndShow()) {
            dynamicBaseWidget.setVisibility(i);
            if (dynamicBaseWidget.pf != null) {
                dynamicBaseWidget.pf.setVisibility(i);
            }
        }
        int childCount = dynamicBaseWidget.getChildCount();
        if (childCount <= 0) {
            return;
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            if (dynamicBaseWidget.getChildAt(i2) instanceof DynamicBaseWidget) {
                z((DynamicBaseWidget) dynamicBaseWidget.getChildAt(i2), i);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.a
    public void z(CharSequence charSequence, int i, int i2, boolean z) {
        for (int i3 = 0; i3 < this.kb.size(); i3++) {
            if (this.kb.get(i3) != null) {
                this.kb.get(i3).z(charSequence, i == 1, i2, z);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.a
    public void setSoundMute(boolean z) {
        com.bytedance.sdk.component.adexpress.dynamic.g gVar = this.gz;
        if (gVar != null) {
            gVar.setSoundMute(z);
        }
    }

    public void setTimeUpdate(int i) {
        this.wp.setTimeUpdate(i);
    }

    public ViewGroup getTimeOut() {
        return this.fo;
    }

    public void setTimeOut(ViewGroup viewGroup) {
        this.fo = viewGroup;
    }

    public int getTimedown() {
        return this.uy;
    }

    public void setTimedown(int i) {
        this.uy = i;
    }

    public List<com.bytedance.sdk.component.adexpress.dynamic.dl> getTimeOutListener() {
        return this.kb;
    }

    public void setTimeOutListener(com.bytedance.sdk.component.adexpress.dynamic.dl dlVar) {
        this.kb.add(dlVar);
    }

    public void setVideoListener(com.bytedance.sdk.component.adexpress.dynamic.gc gcVar) {
        this.wp = gcVar;
    }

    public int getScoreCountWithIcon() {
        return this.v;
    }

    public void setScoreCountWithIcon(int i) {
        this.v = i;
    }

    public int getLogoUnionHeight() {
        return this.i;
    }

    public void setLogoUnionHeight(int i) {
        this.i = i;
    }

    public i getRenderRequest() {
        return this.pf;
    }
}
