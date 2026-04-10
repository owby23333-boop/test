package com.bytedance.sdk.openadsdk.core.wp.z;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.interact.pf;
import com.bytedance.sdk.component.adexpress.g.kb;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.g.a;
import com.bytedance.sdk.openadsdk.core.g.dl;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.uy;
import com.bytedance.sdk.openadsdk.core.iq.zw;
import com.bytedance.sdk.openadsdk.core.kb.dl.dl.m;
import com.bytedance.sdk.openadsdk.core.un.mc;
import com.bytedance.sdk.openadsdk.core.un.oq;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z extends a implements com.bytedance.sdk.component.adexpress.dynamic.gc.z, dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<ViewGroup> f1431a;
    private na dl;
    private boolean g;
    private volatile boolean gc;
    private pf kb;
    private View uy;
    private int wp;
    private kb z;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.gc.z
    public void z(kb kbVar) {
        this.z = kbVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.gc.z
    public void z(boolean z, pf pfVar) {
        this.gc = true;
        this.g = z;
        this.kb = pfVar;
        WeakReference<ViewGroup> weakReference = this.f1431a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        mc.z(this.f1431a, this);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.gc.z
    public void z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.wp = jSONObject.optInt("convertActionType", Integer.MIN_VALUE);
    }

    public z(na naVar, WeakReference<ViewGroup> weakReference) {
        super(null);
        this.gc = false;
        this.wp = Integer.MIN_VALUE;
        this.dl = naVar;
        this.f1431a = weakReference;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.gc.z
    public void z(View view) {
        this.e.g(view);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.gc.z
    public void g(View view) {
        this.e.z(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.a
    public void z(View view, uy uyVar) {
        this.uy = view;
        if (this.gc) {
            this.gc = false;
        } else {
            dl(view);
        }
    }

    private void dl(View view) {
        try {
            z(view, ((Integer) view.getTag()).intValue());
        } catch (ArrayIndexOutOfBoundsException e) {
            wp.z(e);
            e.getMessage();
        } catch (Exception e2) {
            wp.a("DynamicClickListener", e2.getMessage());
        }
    }

    private void z(View view, int i) {
        CharSequence text;
        if (this.z != null) {
            if (this.g && this.dl != null) {
                m.f1219a = true;
            }
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            View viewM = this.e.m();
            if (viewM != null) {
                int[] iArrZ = oq.z(viewM);
                if (iArrZ != null) {
                    iArr = iArrZ;
                }
                int[] iArrDl = oq.dl(viewM);
                if (iArrDl != null) {
                    iArr2 = iArrDl;
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if ((view instanceof TextView) && (text = ((TextView) view).getText()) != null && text.toString().contains("下载")) {
                    jSONObject.put("is_compliant_download", true);
                }
                jSONObject.putOpt("convertActionType", Integer.valueOf(this.wp));
            } catch (Throwable unused) {
            }
            this.z.z(view, i, new zw.z().a(this.e.v()).dl(this.e.pf()).g(this.e.ls()).z(this.e.p()).g(this.e.wp()).z(this.e.i()).z(iArr[0]).g(iArr[1]).dl(iArr2[0]).a(iArr2[1]).z(a(view)).dl(String.valueOf(i)).g(String.valueOf(view.getTag(2097610714))).z(String.valueOf(view.getTag(2097610715))).a(String.valueOf(view.getTag(2097610713))).z(this.e.gc()).z(jSONObject).z(this.e.uy()).z());
        }
    }

    private JSONObject a(View view) {
        return new JSONObject();
    }

    private void g() {
        WeakReference<ViewGroup> weakReference = this.f1431a;
        if (weakReference == null || weakReference.get() == null || !mc.z(this.f1431a.get())) {
            return;
        }
        this.wp = 1;
        dl(this.uy);
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.dl
    public void z() {
        g();
        this.gc = false;
        pf pfVar = this.kb;
        if (pfVar != null) {
            pfVar.gc();
        }
    }
}
