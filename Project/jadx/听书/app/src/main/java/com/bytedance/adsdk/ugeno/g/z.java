package com.bytedance.adsdk.ugeno.g;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.m.gz;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class z<E extends ViewGroup> extends dl {
    protected List<dl<View>> z;

    public z(Context context) {
        this(context, null);
    }

    public z(Context context, z zVar) {
        super(context, zVar);
        this.z = new ArrayList();
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void g() {
        super.g();
    }

    public void z(dl dlVar) {
        if (dlVar == null) {
            return;
        }
        this.z.add(dlVar);
        View viewFo = dlVar.fo();
        if (viewFo != null) {
            ((ViewGroup) this.gc).addView(viewFo);
        }
    }

    public void z(dl dlVar, ViewGroup.LayoutParams layoutParams) {
        if (dlVar == null) {
            return;
        }
        this.z.add(dlVar);
        View viewFo = dlVar.fo();
        if (viewFo != null) {
            ((ViewGroup) this.gc).addView(viewFo, layoutParams);
        }
    }

    public List<dl<View>> e() {
        return this.z;
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public dl z(String str) {
        dl<T> dlVarA;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.kb)) {
            return this;
        }
        for (dl<View> dlVar : this.z) {
            if (dlVar != null && (dlVarA = dlVar.a(str)) != 0) {
                return dlVarA;
            }
        }
        return null;
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public dl g(String str) {
        dl<T> dlVarGc;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.wp)) {
            return this;
        }
        for (dl<View> dlVar : this.z) {
            if (dlVar != null && (dlVarGc = dlVar.gc(str)) != 0) {
                return dlVarGc;
            }
        }
        return null;
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    protected dl dl(String str) {
        dl<T> dlVarM;
        if (!TextUtils.isEmpty(str) && uy(str) != null) {
            return this;
        }
        for (dl<View> dlVar : this.z) {
            if (dlVar != null && (dlVarM = dlVar.m(str)) != 0) {
                return dlVarM;
            }
        }
        return null;
    }

    public C0045z gz() {
        return new C0045z(this);
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.g.z$z, reason: collision with other inner class name */
    public static class C0045z {
        protected float e;
        protected float fo;
        protected boolean fv;
        protected float gc;
        protected float gz;
        protected float i;
        protected ViewGroup.LayoutParams io;
        protected boolean iq;
        protected boolean js;
        protected float kb;
        protected boolean ls;
        protected float m;
        protected boolean p;
        protected boolean pf;
        protected boolean q;
        protected boolean tb;
        protected z uf;
        protected float uy;
        protected float v;
        protected float wp;
        protected boolean zw;
        protected float z = -2.0f;
        protected float g = -2.0f;
        protected float dl = 0.0f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected float f240a = 0.0f;

        public C0045z(z zVar) {
            this.uf = zVar;
        }

        public void z(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
            }
            str.hashCode();
            switch (str) {
                case "paddingLeft":
                    this.kb = gz.z(context, str2);
                    this.ls = true;
                    break;
                case "minWidth":
                    this.dl = gz.z(context, str2);
                    break;
                case "height":
                    if (TextUtils.equals(str2, "match_parent")) {
                        this.g = -1.0f;
                        break;
                    } else {
                        if (TextUtils.equals(str2, "wrap_content")) {
                            this.g = -2.0f;
                        } else {
                            this.g = gz.z(context, str2);
                        }
                        break;
                    }
                    break;
                case "margin":
                    this.gc = gz.z(context, str2);
                    break;
                case "marginTop":
                    this.gz = gz.z(context, str2);
                    this.iq = true;
                    break;
                case "padding":
                    this.uy = gz.z(context, str2);
                    this.pf = true;
                    break;
                case "marginBottom":
                    this.fo = gz.z(context, str2);
                    this.zw = true;
                    break;
                case "minHeight":
                    this.f240a = gz.z(context, str2);
                    break;
                case "paddingTop":
                    this.wp = gz.z(context, str2);
                    this.fv = true;
                    break;
                case "width":
                    if (TextUtils.equals(str2, "match_parent")) {
                        this.z = -1.0f;
                        break;
                    } else {
                        if (TextUtils.equals(str2, "wrap_content")) {
                            this.z = -2.0f;
                        } else {
                            this.z = gz.z(context, str2);
                        }
                        break;
                    }
                    break;
                case "paddingBottom":
                    this.v = gz.z(context, str2);
                    this.js = true;
                    break;
                case "paddingRight":
                    this.i = gz.z(context, str2);
                    this.p = true;
                    break;
                case "marginRight":
                    this.e = gz.z(context, str2);
                    this.q = true;
                    break;
                case "marginLeft":
                    this.m = gz.z(context, str2);
                    this.tb = true;
                    break;
            }
        }

        public String toString() {
            return "LayoutParams{mWidth=" + this.z + ", mHeight=" + this.g + ", mMargin=" + this.gc + ", mMarginLeft=" + this.m + ", mMarginRight=" + this.e + ", mMarginTop=" + this.gz + ", mMarginBottom=" + this.fo + ", mParams=" + this.io + '}';
        }

        public ViewGroup.LayoutParams z() {
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams((int) this.z, (int) this.g);
            marginLayoutParams.leftMargin = (int) (this.tb ? this.m : this.gc);
            marginLayoutParams.rightMargin = (int) (this.q ? this.e : this.gc);
            marginLayoutParams.topMargin = (int) (this.iq ? this.gz : this.gc);
            marginLayoutParams.bottomMargin = (int) (this.zw ? this.fo : this.gc);
            return marginLayoutParams;
        }
    }
}
