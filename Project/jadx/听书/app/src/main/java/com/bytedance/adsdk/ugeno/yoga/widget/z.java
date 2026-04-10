package com.bytedance.adsdk.ugeno.yoga.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.a;
import com.bytedance.adsdk.ugeno.dl.e;
import com.bytedance.adsdk.ugeno.g.dl;
import com.bytedance.adsdk.ugeno.g.z;
import com.bytedance.adsdk.ugeno.m.gz;
import com.bytedance.adsdk.ugeno.yoga.gc;
import com.bytedance.adsdk.ugeno.yoga.i;
import com.bytedance.adsdk.ugeno.yoga.m;
import com.bytedance.adsdk.ugeno.yoga.uy;
import com.bytedance.adsdk.ugeno.yoga.v;
import com.bytedance.adsdk.ugeno.yoga.widget.YogaLayout;
import com.bytedance.adsdk.ugeno.z;

/* JADX INFO: loaded from: classes2.dex */
public class z extends com.bytedance.adsdk.ugeno.g.z<YogaLayout> {
    private com.bytedance.adsdk.ugeno.yoga.z cb;
    private v k;
    private com.bytedance.adsdk.ugeno.yoga.z o;
    private gc wo;
    private m wx;
    private uy yt;

    public z(Context context) {
        super(context);
        this.wo = gc.ROW;
        this.k = v.NO_WRAP;
        this.wx = m.FLEX_START;
        this.cb = com.bytedance.adsdk.ugeno.yoga.z.STRETCH;
        this.o = com.bytedance.adsdk.ugeno.yoga.z.STRETCH;
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    /* JADX INFO: renamed from: jq, reason: merged with bridge method [inline-methods] */
    public YogaLayout z() {
        YogaLayout yogaLayout = new YogaLayout(this.g);
        yogaLayout.z(this);
        this.yt = yogaLayout.getYogaNode();
        return yogaLayout;
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    protected void sy() {
        if (this.xl) {
            if (this.yw != null) {
                this.yw.z();
            }
            a.z().g().z(this.fo, this.oq, new z.InterfaceC0053z() { // from class: com.bytedance.adsdk.ugeno.yoga.widget.z.1
                @Override // com.bytedance.adsdk.ugeno.z.InterfaceC0053z
                public void z(Bitmap bitmap) {
                    if (bitmap == null) {
                        if (z.this.yw != null) {
                            e eVar = z.this.yw;
                            z zVar = z.this;
                            eVar.g(zVar, zVar.oq);
                            return;
                        }
                        return;
                    }
                    if (z.this.yw != null) {
                        e eVar2 = z.this.yw;
                        z zVar2 = z.this;
                        eVar2.z(zVar2, zVar2.oq);
                    }
                    final Bitmap bitmapZ = gz.z(z.this.g, bitmap, (int) z.this.na);
                    if (bitmapZ != null) {
                        gz.z(new Runnable() { // from class: com.bytedance.adsdk.ugeno.yoga.widget.z.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                z.this.z(new BitmapDrawable(bitmapZ));
                            }
                        });
                    }
                }
            });
            return;
        }
        if (this.yw != null) {
            this.yw.z();
        }
        ImageView imageView = new ImageView(this.g);
        a.z().g().z(this.fo, this.oq, imageView, this.gc.getWidth(), this.gc.getHeight(), new z.InterfaceC0053z() { // from class: com.bytedance.adsdk.ugeno.yoga.widget.z.2
            @Override // com.bytedance.adsdk.ugeno.z.InterfaceC0053z
            public void z(Bitmap bitmap) {
                if (bitmap == null) {
                    if (z.this.yw != null) {
                        e eVar = z.this.yw;
                        z zVar = z.this;
                        eVar.g(zVar, zVar.oq);
                        return;
                    }
                    return;
                }
                if (z.this.yw != null) {
                    e eVar2 = z.this.yw;
                    z zVar2 = z.this;
                    eVar2.z(zVar2, zVar2.oq);
                }
            }
        });
        if (!this.j || this.wj == ImageView.ScaleType.FIT_XY) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            imageView.setScaleType(this.wj);
        }
        YogaLayout.z zVar = new YogaLayout.z(-1, -1);
        zVar.m(i.ABSOLUTE.z());
        if (this.gc instanceof YogaLayout) {
            ((YogaLayout) this.gc).addView(imageView, 0, zVar);
            z(imageView);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    protected void z(Drawable drawable) {
        ImageView imageView = new ImageView(this.g);
        imageView.setImageDrawable(drawable);
        if (!this.j || this.wj == ImageView.ScaleType.FIT_XY) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            imageView.setScaleType(this.wj);
        }
        YogaLayout.z zVar = new YogaLayout.z(-1, -1);
        zVar.m(i.ABSOLUTE.z());
        if (this.gc instanceof YogaLayout) {
            ((YogaLayout) this.gc).addView(imageView, 0, zVar);
            z(imageView);
        }
    }

    private void z(final ImageView imageView) {
        this.gc.post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.yoga.widget.z.3
            @Override // java.lang.Runnable
            public void run() {
                uy uyVarZ;
                if (z.this.gc == null || (uyVarZ = ((YogaLayout) z.this.gc).z(imageView)) == null) {
                    return;
                }
                uyVarZ.a(z.this.gc.getWidth());
                uyVarZ.m(z.this.gc.getHeight());
                z.this.gc.requestLayout();
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.g.z, com.bytedance.adsdk.ugeno.g.dl
    public void g() {
        super.g();
        this.yt.z(this.wo);
        this.yt.z(this.k);
        this.yt.z(this.wx);
        this.yt.z(this.cb);
        this.yt.dl(this.o);
        this.yt.z(true);
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    protected void wp() {
        if (this.x) {
            this.yt.g(com.bytedance.adsdk.ugeno.yoga.a.ALL, this.sy);
        }
        if (this.lq) {
            this.yt.g(com.bytedance.adsdk.ugeno.yoga.a.LEFT, this.hh);
        }
        if (this.mc) {
            this.yt.g(com.bytedance.adsdk.ugeno.yoga.a.RIGHT, this.l);
        }
        if (this.un) {
            this.yt.g(com.bytedance.adsdk.ugeno.yoga.a.TOP, this.h);
        }
        if (this.ti) {
            this.yt.g(com.bytedance.adsdk.ugeno.yoga.a.BOTTOM, this.gk);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.g.z
    public void z(dl dlVar) {
        super.z(dlVar);
    }

    @Override // com.bytedance.adsdk.ugeno.g.z
    public void z(dl dlVar, ViewGroup.LayoutParams layoutParams) {
        if (dlVar == null) {
            return;
        }
        this.z.add(dlVar);
        View viewFo = dlVar.fo();
        if (viewFo != null) {
            ((YogaLayout) this.gc).addView(viewFo, layoutParams);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.g.z
    /* JADX INFO: renamed from: sv, reason: merged with bridge method [inline-methods] */
    public C0052z gz() {
        return new C0052z(this);
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void z(String str, String str2) {
        super.z(str, str2);
        str.hashCode();
        switch (str) {
            case "alignItems":
                this.cb = com.bytedance.adsdk.ugeno.yoga.z.z(str2);
                break;
            case "flexDirection":
                this.wo = gc.z(str2);
                break;
            case "alignContent":
                this.o = com.bytedance.adsdk.ugeno.yoga.z.z(str2);
                break;
            case "flexWrap":
                this.k = v.z(str2);
                break;
            case "justifyContent":
                this.wx = m.z(str2);
                break;
        }
    }

    public gc f() {
        return this.wo;
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.yoga.widget.z$z, reason: collision with other inner class name */
    public static class C0052z extends z.C0045z {
        public float eo;
        public float gk;
        private boolean gp;
        public int h;
        public float hh;
        private boolean j;
        public float l;
        public int lq;
        public int mc;
        private boolean na;
        private boolean oq;
        public int sy;
        public int ti;
        public int un;
        private boolean wj;
        public int x;
        private boolean xl;

        public C0052z(com.bytedance.adsdk.ugeno.g.z zVar) {
            super(zVar);
            this.sy = 1;
            this.hh = 0.0f;
            this.l = 1.0f;
            this.h = com.bytedance.adsdk.ugeno.yoga.z.AUTO.z();
            this.gk = -1.0f;
            this.x = i.RELATIVE.z();
        }

        @Override // com.bytedance.adsdk.ugeno.g.z.C0045z
        public void z(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
            }
            super.z(context, str, str2);
            str.hashCode();
            switch (str) {
                case "flexBasis":
                    this.oq = true;
                    float fZ = com.bytedance.adsdk.ugeno.m.dl.z(str2, -1.0f);
                    this.gk = fZ;
                    this.gk = gz.z(context, fZ);
                    break;
                case "bottom":
                    this.na = true;
                    this.mc = (int) gz.z(context, com.bytedance.adsdk.ugeno.m.dl.z(str2, 0));
                    break;
                case "top":
                    this.wj = true;
                    this.lq = (int) gz.z(context, com.bytedance.adsdk.ugeno.m.dl.z(str2, 0));
                    break;
                case "left":
                    this.xl = true;
                    this.un = (int) gz.z(context, com.bytedance.adsdk.ugeno.m.dl.z(str2, 0));
                    break;
                case "order":
                    this.sy = com.bytedance.adsdk.ugeno.m.dl.z(str2, 1);
                    break;
                case "ratio":
                    this.gp = true;
                    this.eo = com.bytedance.adsdk.ugeno.m.dl.z(str2, 0.0f);
                    break;
                case "right":
                    this.j = true;
                    this.ti = (int) gz.z(context, com.bytedance.adsdk.ugeno.m.dl.z(str2, 0));
                    break;
                case "position":
                    this.x = i.z(str2).z();
                    break;
                case "flexShrink":
                    this.l = com.bytedance.adsdk.ugeno.m.dl.z(str2, 1.0f);
                    break;
                case "flexGrow":
                    this.hh = com.bytedance.adsdk.ugeno.m.dl.z(str2, 0.0f);
                    break;
                case "alignSelf":
                    this.h = com.bytedance.adsdk.ugeno.yoga.z.z(str2).z();
                    break;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.g.z.C0045z
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public YogaLayout.z z() {
            a();
            YogaLayout.z zVar = new YogaLayout.z((int) this.z, (int) this.g);
            zVar.wp((int) (this.tb ? this.m : this.gc));
            zVar.v((int) (this.q ? this.e : this.gc));
            zVar.kb((int) (this.iq ? this.gz : this.gc));
            zVar.i((int) (this.zw ? this.fo : this.gc));
            zVar.z(this.sy);
            zVar.gc(this.h);
            zVar.g(this.hh);
            zVar.dl(this.l);
            zVar.ls(this.dl);
            zVar.p(this.f240a);
            if (this.oq) {
                zVar.a(this.gk);
            }
            zVar.m(this.x);
            if (this.wj) {
                zVar.e(this.lq);
            }
            if (this.na) {
                zVar.fo(this.mc);
            }
            if (this.xl) {
                zVar.gz(this.un);
            }
            if (this.j) {
                zVar.uy(this.ti);
            }
            if (this.gp && dl()) {
                float f = this.eo;
                if (f > 0.0f) {
                    zVar.pf(f);
                    zVar.dl(0.0f);
                    zVar.g(0.0f);
                }
            }
            return zVar;
        }

        public boolean dl() {
            if (this.z == -1.0f && this.g == -1.0f) {
                return false;
            }
            return this.z == -2.0f || this.g == -2.0f;
        }

        private void a() {
            if (this.uf instanceof z) {
                if (((z) this.uf).f() == gc.ROW && this.uf.mc() == -2 && this.z == -1.0f && !this.uf.gp()) {
                    this.z = -2.0f;
                    this.l = 1.0f;
                    this.hh = 1.0f;
                    this.oq = true;
                    this.gk = -1.0f;
                }
                if (((z) this.uf).f() == gc.COLUMN && this.uf.un() == -2 && this.g == -1.0f && !this.uf.gp()) {
                    this.g = -2.0f;
                    this.l = 1.0f;
                    this.hh = 1.0f;
                    this.oq = true;
                    this.gk = -1.0f;
                }
            }
        }

        @Override // com.bytedance.adsdk.ugeno.g.z.C0045z
        public String toString() {
            return "LayoutParams{mOrder=" + this.sy + ", mFlexGrow=" + this.hh + ", mFlexShrink=" + this.l + ", mAlignSelf=" + this.h + ", mFlexBasis=" + this.gk + ", mPosition=" + this.x + ", mTop=" + this.lq + ", mBottom=" + this.mc + ", mLeft=" + this.un + ", mRight=" + this.ti + '}';
        }
    }
}
