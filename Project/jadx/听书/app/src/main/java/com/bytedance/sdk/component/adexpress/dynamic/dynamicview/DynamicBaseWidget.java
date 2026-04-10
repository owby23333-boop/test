package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.adexpress.dynamic.dl.e;
import com.bytedance.sdk.component.adexpress.dynamic.dl.gz;
import com.bytedance.sdk.component.adexpress.dynamic.dl.m;
import com.bytedance.sdk.component.adexpress.g.i;
import com.bytedance.sdk.component.utils.iq;
import com.bytedance.sdk.component.utils.wp;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DynamicBaseWidget extends FrameLayout implements com.bytedance.sdk.component.adexpress.dynamic.animation.view.g, a, gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected float f558a;
    protected float dl;
    protected int e;
    protected int fo;
    com.bytedance.sdk.component.adexpress.dynamic.animation.view.z fv;
    private float g;
    protected float gc;
    protected int gz;
    protected gz i;
    private boolean iq;
    private float js;
    protected Context kb;
    protected boolean ls;
    protected float m;
    protected com.bytedance.sdk.component.adexpress.dynamic.animation.z.g p;
    protected View pf;
    private iq q;
    private float tb;
    protected int uy;
    protected DynamicRootView v;
    protected e wp;
    private float z;
    private static final View.OnTouchListener zw = new View.OnTouchListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget.1
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };
    private static final View.OnClickListener io = new View.OnClickListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    };

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.g
    public float getShineValue() {
        return this.g;
    }

    public void setShineValue(float f) {
        this.g = f;
        postInvalidate();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.g
    public float getRippleValue() {
        return this.z;
    }

    public void setRippleValue(float f) {
        this.z = f;
        postInvalidate();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.g
    public float getMarqueeValue() {
        return this.js;
    }

    public void setMarqueeValue(float f) {
        this.js = f;
        postInvalidate();
    }

    public float getStretchValue() {
        return this.tb;
    }

    public void setStretchValue(float f) {
        this.tb = f;
        this.fv.z(this, f);
    }

    public DynamicBaseWidget(Context context, DynamicRootView dynamicRootView, gz gzVar) {
        super(context);
        this.iq = true;
        this.kb = context;
        this.v = dynamicRootView;
        this.i = gzVar;
        this.dl = gzVar.m();
        this.f558a = gzVar.e();
        this.gc = gzVar.gz();
        this.m = gzVar.fo();
        this.fo = (int) com.bytedance.sdk.component.adexpress.a.gz.z(this.kb, this.dl);
        this.uy = (int) com.bytedance.sdk.component.adexpress.a.gz.z(this.kb, this.f558a);
        this.e = (int) com.bytedance.sdk.component.adexpress.a.gz.z(this.kb, this.gc);
        this.gz = (int) com.bytedance.sdk.component.adexpress.a.gz.z(this.kb, this.m);
        e eVar = new e(gzVar.uy());
        this.wp = eVar;
        if (eVar.fv() > 0) {
            this.e += this.wp.fv() * 2;
            this.gz += this.wp.fv() * 2;
            this.fo -= this.wp.fv();
            this.uy -= this.wp.fv();
            List<gz> listKb = gzVar.kb();
            if (listKb != null) {
                for (gz gzVar2 : listKb) {
                    gzVar2.dl(gzVar2.m() + com.bytedance.sdk.component.adexpress.a.gz.g(this.kb, this.wp.fv()));
                    gzVar2.a(gzVar2.e() + com.bytedance.sdk.component.adexpress.a.gz.g(this.kb, this.wp.fv()));
                    gzVar2.z(com.bytedance.sdk.component.adexpress.a.gz.g(this.kb, this.wp.fv()));
                    gzVar2.g(com.bytedance.sdk.component.adexpress.a.gz.g(this.kb, this.wp.fv()));
                }
            }
        }
        this.ls = this.wp.v() > 0.0d;
        this.fv = new com.bytedance.sdk.component.adexpress.dynamic.animation.view.z();
    }

    public void setShouldInvisible(boolean z) {
        this.ls = z;
    }

    public boolean getBeginInvisibleAndShow() {
        return this.ls;
    }

    public boolean z() {
        gz();
        gc();
        dl();
        return true;
    }

    public void z(int i) {
        e eVar = this.wp;
        if (eVar != null && eVar.z(i)) {
            gz();
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (getChildAt(i2) instanceof DynamicBaseWidget)) {
                    ((DynamicBaseWidget) childAt).z(i);
                }
            }
        }
    }

    protected boolean dl() {
        View.OnTouchListener onTouchListener;
        View.OnClickListener onClickListener;
        View view = this.pf;
        View view2 = view;
        if (view == null) {
            view2 = this;
        }
        if (a()) {
            onTouchListener = (View.OnTouchListener) getDynamicClickListener();
            onClickListener = (View.OnClickListener) getDynamicClickListener();
        } else {
            onTouchListener = zw;
            onClickListener = io;
        }
        if (onTouchListener != null && onClickListener != null) {
            view2.setOnTouchListener(onTouchListener);
            view2.setOnClickListener(onClickListener);
            int iZ = com.bytedance.sdk.component.adexpress.dynamic.g.z.z(this.wp);
            if (iZ == 2 || iZ == 3) {
                view2.setOnClickListener(io);
            } else {
                view2.setOnClickListener(onClickListener);
            }
        }
        z(view2);
        g(view2);
        return true;
    }

    protected void z(View view) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MediaFormat.KEY_WIDTH, this.i.gz());
            jSONObject.put(MediaFormat.KEY_HEIGHT, this.i.fo());
            if (com.bytedance.sdk.component.adexpress.a.z()) {
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.z.tb, this.wp.eo());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.z.q, this.i.uy().getType());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.z.iq, this.i.dl());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.z.zw, jSONObject.toString());
                return;
            }
            view.setTag(2097610717, this.wp.eo());
            view.setTag(2097610715, this.i.uy().getType());
            view.setTag(2097610714, this.i.dl());
            view.setTag(2097610713, jSONObject.toString());
            int iZ = com.bytedance.sdk.component.adexpress.dynamic.g.z.z(this.wp);
            if (iZ == 1) {
                view.setTag(2097610707, new Pair(this.wp.uf(), Long.valueOf(this.wp.sy())));
                view.setTag(2097610708, Integer.valueOf(iZ));
            }
        } catch (JSONException e) {
            wp.z(e);
        }
    }

    protected void g(View view) {
        m mVarGc;
        gz gzVar = this.i;
        if (gzVar == null || (mVarGc = gzVar.uy().gc()) == null) {
            return;
        }
        view.setTag(2097610716, Boolean.valueOf(mVarGc.te()));
    }

    public boolean a() {
        e eVar = this.wp;
        return (eVar == null || eVar.hh() == 0) ? false : true;
    }

    public void gc() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.e, this.gz);
        layoutParams.topMargin = this.uy;
        layoutParams.leftMargin = this.fo;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    public int getClickArea() {
        return this.wp.hh();
    }

    public String getImageObjectFit() {
        return this.wp.jq();
    }

    public com.bytedance.sdk.component.adexpress.dynamic.gc.z getDynamicClickListener() {
        return this.v.getDynamicClickListener();
    }

    protected Drawable getBackgroundDrawable() {
        return z(false, "");
    }

    protected Drawable z(boolean z, String str) {
        String[] strArrSplit;
        int[] iArr;
        int iL;
        if (!TextUtils.isEmpty(this.wp.ti())) {
            try {
                String strTi = this.wp.ti();
                String strSubstring = strTi.substring(strTi.indexOf("(") + 1, strTi.length() - 1);
                if (strSubstring.contains("rgba") && strSubstring.contains("%")) {
                    strArrSplit = new String[]{strSubstring.substring(0, strSubstring.indexOf(",")).trim(), strSubstring.substring(strSubstring.indexOf(",") + 1, strSubstring.indexOf("%") + 1).trim(), strSubstring.substring(strSubstring.indexOf("%") + 2).trim()};
                    iArr = new int[]{e.z(strArrSplit[1]), e.z(strArrSplit[2])};
                } else {
                    strArrSplit = strSubstring.split(", ");
                    iArr = new int[]{e.z(strArrSplit[1].substring(0, 7)), e.z(strArrSplit[2].substring(0, 7))};
                }
                try {
                    double d = Double.parseDouble(strSubstring.substring(strSubstring.indexOf("linear-gradient(") + 1, strSubstring.indexOf("deg")));
                    if (d > 225.0d && d < 315.0d) {
                        int i = iArr[1];
                        iArr[1] = iArr[0];
                        iArr[0] = i;
                    }
                } catch (Exception unused) {
                }
                GradientDrawable gradientDrawableZ = z(z(strArrSplit[0]), iArr);
                gradientDrawableZ.setShape(0);
                gradientDrawableZ.setCornerRadius(com.bytedance.sdk.component.adexpress.a.gz.z(this.kb, this.wp.pf()));
                return gradientDrawableZ;
            } catch (Exception unused2) {
                Drawable mutilBackgroundDrawable = getMutilBackgroundDrawable();
                if (mutilBackgroundDrawable != null) {
                    return mutilBackgroundDrawable;
                }
            }
        }
        GradientDrawable drawable = getDrawable();
        drawable.setShape(0);
        float fZ = com.bytedance.sdk.component.adexpress.a.gz.z(this.kb, this.wp.pf());
        drawable.setCornerRadius(fZ);
        if (fZ < 1.0f) {
            float fZ2 = com.bytedance.sdk.component.adexpress.a.gz.z(this.kb, this.wp.gk());
            float fZ3 = com.bytedance.sdk.component.adexpress.a.gz.z(this.kb, this.wp.x());
            float fZ4 = com.bytedance.sdk.component.adexpress.a.gz.z(this.kb, this.wp.lq());
            float fZ5 = com.bytedance.sdk.component.adexpress.a.gz.z(this.kb, this.wp.mc());
            float[] fArr = new float[8];
            if (fZ2 > 0.0f) {
                fArr[0] = fZ2;
                fArr[1] = fZ2;
            }
            if (fZ3 > 0.0f) {
                fArr[2] = fZ3;
                fArr[3] = fZ3;
            }
            if (fZ4 > 0.0f) {
                fArr[4] = fZ4;
                fArr[5] = fZ4;
            }
            if (fZ5 > 0.0f) {
                fArr[6] = fZ5;
                fArr[7] = fZ5;
            }
            drawable.setCornerRadii(fArr);
        }
        if (z) {
            iL = Color.parseColor(str);
        } else {
            iL = this.wp.l();
        }
        drawable.setColor(iL);
        if (this.wp.p() > 0.0f) {
            drawable.setStroke((int) com.bytedance.sdk.component.adexpress.a.gz.z(this.kb, this.wp.p()), this.wp.ls());
            return drawable;
        }
        if (this.wp.fv() <= 0) {
            return drawable;
        }
        drawable.setStroke(this.wp.fv(), this.wp.ls());
        drawable.setAlpha(50);
        if (!TextUtils.equals(this.i.uy().getType(), "video-vd")) {
            return drawable;
        }
        setLayerType(1, null);
        return new dl((int) fZ, this.wp.fv());
    }

    protected g z(Bitmap bitmap) {
        return new z(bitmap, null);
    }

    protected Drawable getMutilBackgroundDrawable() {
        try {
            return new LayerDrawable(z(g(this.wp.ti().replaceAll("/\\*.*\\*/", ""))));
        } catch (Exception unused) {
            return null;
        }
    }

    private Drawable[] z(List<String> list) {
        Drawable[] drawableArr = new Drawable[list.size()];
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (str.contains("linear-gradient")) {
                String[] strArrSplit = str.substring(str.indexOf("(") + 1, str.length() - 1).split(", ");
                int length = strArrSplit.length - 1;
                int[] iArr = new int[length];
                int i2 = 0;
                while (i2 < length) {
                    int i3 = i2 + 1;
                    iArr[i2] = e.z(strArrSplit[i3].substring(0, 7));
                    i2 = i3;
                }
                GradientDrawable gradientDrawableZ = z(z(strArrSplit[0]), iArr);
                gradientDrawableZ.setShape(0);
                gradientDrawableZ.setCornerRadius(com.bytedance.sdk.component.adexpress.a.gz.z(this.kb, this.wp.pf()));
                drawableArr[(list.size() - 1) - i] = gradientDrawableZ;
            }
        }
        return drawableArr;
    }

    private List<String> g(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z = false;
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (str.charAt(i3) == '(') {
                i++;
                z = true;
            } else if (str.charAt(i3) == ')' && i - 1 == 0 && z) {
                int i4 = i3 + 1;
                arrayList.add(str.substring(i2, i4));
                i2 = i4;
                z = false;
            }
        }
        return arrayList;
    }

    protected GradientDrawable getDrawable() {
        return new GradientDrawable();
    }

    protected GradientDrawable z(GradientDrawable.Orientation orientation, int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return new GradientDrawable();
        }
        if (iArr.length == 1) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(iArr[0]);
            return gradientDrawable;
        }
        return new GradientDrawable(orientation, iArr);
    }

    protected GradientDrawable.Orientation z(String str) {
        try {
            int i = (int) Float.parseFloat(str.substring(0, str.length() - 3));
            if (i <= 90) {
                return GradientDrawable.Orientation.LEFT_RIGHT;
            }
            if (i <= 180) {
                return GradientDrawable.Orientation.TOP_BOTTOM;
            }
            if (i <= 270) {
                return GradientDrawable.Orientation.RIGHT_LEFT;
            }
            return GradientDrawable.Orientation.BOTTOM_TOP;
        } catch (Exception unused) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.fv.z(canvas, this, this);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.bytedance.sdk.component.adexpress.dynamic.animation.view.z zVar = this.fv;
        View view = this.pf;
        if (view == null) {
            view = this;
        }
        zVar.z(view, i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m();
        fo();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (this.q != null) {
            DynamicRootView dynamicRootView = this.v;
            if (dynamicRootView == null || dynamicRootView.getRenderRequest() == null) {
                if (z) {
                    this.q.z(0);
                    return;
                } else {
                    this.q.g(0);
                    return;
                }
            }
            if (z) {
                this.q.z(this.v.getRenderRequest().h());
            } else {
                this.q.g(this.v.getRenderRequest().h());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        g();
        super.onDetachedFromWindow();
        if (this.q != null) {
            DynamicRootView dynamicRootView = this.v;
            if (dynamicRootView != null && dynamicRootView.getRenderRequest() != null) {
                this.q.g(this.v.getRenderRequest().h());
            } else {
                this.q.g(0);
            }
        }
    }

    public void m() {
        if (e()) {
            return;
        }
        View view = this.pf;
        if (view == null) {
            view = this;
        }
        com.bytedance.sdk.component.adexpress.dynamic.animation.z.g gVar = new com.bytedance.sdk.component.adexpress.dynamic.animation.z.g(view, this.i.uy().gc().cb());
        this.p = gVar;
        gVar.z();
    }

    public void g() {
        com.bytedance.sdk.component.adexpress.dynamic.animation.z.g gVar = this.p;
        if (gVar != null) {
            gVar.g();
        }
    }

    protected boolean e() {
        gz gzVar = this.i;
        return gzVar == null || gzVar.uy() == null || this.i.uy().gc() == null || this.i.uy().gc().cb() == null;
    }

    public int getDynamicWidth() {
        return this.e;
    }

    public int getDynamicHeight() {
        return this.gz;
    }

    public m getDynamicLayoutBrickValue() {
        com.bytedance.sdk.component.adexpress.dynamic.dl.gc gcVarUy;
        gz gzVar = this.i;
        if (gzVar == null || (gcVarUy = gzVar.uy()) == null) {
            return null;
        }
        return gcVarUy.gc();
    }

    private void fo() {
        if (isShown()) {
            int iZ = com.bytedance.sdk.component.adexpress.dynamic.g.z.z(this.wp);
            if (iZ == 2) {
                if (this.q == null) {
                    this.q = new iq(getContext().getApplicationContext(), 1, this.iq);
                }
                this.q.z(new iq.z() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget.3
                    @Override // com.bytedance.sdk.component.utils.iq.z
                    public void z(int i) {
                        if (i == 1 && DynamicBaseWidget.this.isShown()) {
                            DynamicBaseWidget.this.uy();
                        }
                    }
                });
                i renderRequest = this.v.getRenderRequest();
                if (renderRequest != null) {
                    this.q.z(renderRequest.fv());
                    this.q.gc(renderRequest.io());
                    this.q.dl(renderRequest.iq());
                    this.q.g(renderRequest.tb());
                    this.q.m(renderRequest.uf());
                    this.q.z(renderRequest.q());
                    this.q.g(renderRequest.zw());
                }
            } else if (iZ == 3) {
                if (this.q == null) {
                    this.q = new iq(getContext().getApplicationContext(), 2, this.iq);
                }
                this.q.z(new iq.z() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget.4
                    @Override // com.bytedance.sdk.component.utils.iq.z
                    public void z(int i) {
                        if (i == 2 && DynamicBaseWidget.this.isShown()) {
                            DynamicBaseWidget.this.uy();
                        }
                    }
                });
                i renderRequest2 = this.v.getRenderRequest();
                if (renderRequest2 != null) {
                    this.q.g(renderRequest2.tb());
                    this.q.m(renderRequest2.uf());
                    this.q.z(renderRequest2.q());
                    this.q.g(renderRequest2.zw());
                }
            }
            iq iqVar = this.q;
            if (iqVar != null) {
                DynamicRootView dynamicRootView = this.v;
                if (dynamicRootView != null) {
                    i renderRequest3 = dynamicRootView.getRenderRequest();
                    if (renderRequest3 != null) {
                        this.q.z(renderRequest3.h());
                        return;
                    }
                    return;
                }
                iqVar.z(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uy() {
        try {
            View view = this.pf;
            if (view == null) {
                view = this;
            }
            view.setOnClickListener((View.OnClickListener) getDynamicClickListener());
            view.performClick();
            view.setOnClickListener(io);
        } catch (Exception unused) {
        }
    }

    public void setCanUseSensor(boolean z) {
        this.iq = z;
    }
}
