package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.a.m;
import com.bytedance.sdk.component.adexpress.a.uy;
import com.bytedance.sdk.component.adexpress.dynamic.a.fo;
import com.bytedance.sdk.component.adexpress.dynamic.dl.e;
import com.bytedance.sdk.component.adexpress.dynamic.dl.gz;
import com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer;
import com.bytedance.sdk.component.adexpress.g.i;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.m.io;
import com.bytedance.sdk.component.m.ls;
import com.bytedance.sdk.component.m.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicBaseWidgetImp extends DynamicBaseWidget {
    private static String tb = "";
    private Runnable g;
    private ImageView iq;
    protected InteractViewContainer js;
    private volatile boolean q;
    private Runnable z;

    public DynamicBaseWidgetImp(Context context, DynamicRootView dynamicRootView, gz gzVar) {
        super(context, dynamicRootView, gzVar);
        this.q = true;
        setTag(Integer.valueOf(getClickArea()));
        String type = gzVar.uy().getType();
        if ("logo-union".equals(type)) {
            dynamicRootView.setLogoUnionHeight(this.gz - ((int) com.bytedance.sdk.component.adexpress.a.gz.z(context, this.wp.g() + this.wp.z())));
        } else if ("scoreCountWithIcon".equals(type)) {
            dynamicRootView.setScoreCountWithIcon(this.gz - ((int) com.bytedance.sdk.component.adexpress.a.gz.z(context, this.wp.g() + this.wp.z())));
        }
    }

    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.e, this.gz);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.a
    public boolean gz() {
        Drawable backgroundDrawable;
        JSONObject jSONObjectOptJSONObject;
        final View view = this.pf == null ? this : this.pf;
        setContentDescription(this.i.z(this.wp.hh()));
        String strJa = this.wp.ja();
        String strHh = null;
        String strZ = (TextUtils.isEmpty(strJa) || this.v == null || this.v.getRenderRequest() == null || this.v.getRenderRequest().gc() == null || (jSONObjectOptJSONObject = this.v.getRenderRequest().gc().optJSONObject("creative")) == null) ? null : z(jSONObjectOptJSONObject.opt(strJa));
        if (TextUtils.isEmpty(strZ)) {
            strZ = this.wp.q();
        }
        if (this.wp.tb()) {
            com.bytedance.sdk.component.adexpress.z.z.z.z().gc().from(this.wp.g).type(2).converter(new dl(this.kb, this.wp.js())).to(new g(view, this));
        } else if (!TextUtils.isEmpty(strZ)) {
            if (!strZ.startsWith("http:") && !strZ.startsWith("https:")) {
                if (this.v != null && this.v.getRenderRequest() != null) {
                    strHh = this.v.getRenderRequest().hh();
                }
                strZ = fo.g(strZ, strHh);
            }
            v vVarType = com.bytedance.sdk.component.adexpress.z.z.z.z().gc().from(strZ).type(2);
            z(vVarType);
            if (!com.bytedance.sdk.component.adexpress.a.z()) {
                if ((view instanceof FrameLayout) && TextUtils.equals(this.i.uy().getType(), "vessel")) {
                    if (uy.g(strZ)) {
                        this.iq = new GifView(this.kb);
                    } else {
                        this.iq = new ImageView(this.kb);
                    }
                    ((FrameLayout) view).addView(this.iq, new FrameLayout.LayoutParams(-1, -1));
                    vVarType.type(3).to(new io() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.1
                        @Override // com.bytedance.sdk.component.m.io
                        public void onFailed(int i, String str, Throwable th) {
                        }

                        @Override // com.bytedance.sdk.component.m.io
                        public void onSuccess(ls lsVar) {
                            Object result = lsVar.getResult();
                            if (result instanceof byte[]) {
                                m.g(DynamicBaseWidgetImp.this.iq, (byte[]) result, DynamicBaseWidgetImp.this.e, DynamicBaseWidgetImp.this.gz);
                            }
                        }
                    }, 4);
                } else {
                    z(vVarType, view);
                }
            } else {
                vVarType.to(new z(view, this.v, this.i));
            }
        }
        if (getBackground() == null && (backgroundDrawable = getBackgroundDrawable()) != null) {
            view.setBackground(backgroundDrawable);
        }
        if (this.wp.h() > 0.0d) {
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (DynamicBaseWidgetImp.this.wp.un() > 0) {
                            DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                            Drawable drawableG = dynamicBaseWidgetImp.g(dynamicBaseWidgetImp.v.getBgMaterialCenterCalcColor().get(Integer.valueOf(DynamicBaseWidgetImp.this.wp.un())));
                            if (drawableG == null) {
                                DynamicBaseWidgetImp dynamicBaseWidgetImp2 = DynamicBaseWidgetImp.this;
                                drawableG = dynamicBaseWidgetImp2.z(true, dynamicBaseWidgetImp2.v.getBgMaterialCenterCalcColor().get(Integer.valueOf(DynamicBaseWidgetImp.this.wp.un())));
                            }
                            if (drawableG != null) {
                                view.setBackground(drawableG);
                                return;
                            }
                            View view2 = view;
                            DynamicBaseWidgetImp dynamicBaseWidgetImp3 = DynamicBaseWidgetImp.this;
                            view2.setBackground(dynamicBaseWidgetImp3.z(true, dynamicBaseWidgetImp3.v.getBgColor()));
                        }
                    } catch (Exception unused) {
                    }
                }
            }, (long) (this.wp.h() * 1000.0d));
        }
        if (this.pf != null) {
            this.pf.setPadding((int) com.bytedance.sdk.component.adexpress.a.gz.z(this.kb, this.wp.dl()), (int) com.bytedance.sdk.component.adexpress.a.gz.z(this.kb, this.wp.g()), (int) com.bytedance.sdk.component.adexpress.a.gz.z(this.kb, this.wp.a()), (int) com.bytedance.sdk.component.adexpress.a.gz.z(this.kb, this.wp.z()));
        }
        if (this.ls || this.wp.v() > 0.0d) {
            setShouldInvisible(true);
            view.setVisibility(4);
            setVisibility(4);
        }
        return true;
    }

    private static class dl implements com.bytedance.sdk.component.m.uy {
        private final int g;
        private final WeakReference<Context> z;

        public dl(Context context, int i) {
            this.z = new WeakReference<>(context);
            this.g = i;
        }

        @Override // com.bytedance.sdk.component.m.uy
        public Bitmap coverterTo(Bitmap bitmap) {
            Context context = this.z.get();
            if (context != null) {
                return com.bytedance.sdk.component.adexpress.a.g.z(context, bitmap, this.g);
            }
            return null;
        }
    }

    private static class g implements io<Bitmap> {
        private final WeakReference<DynamicBaseWidget> g;
        private final WeakReference<View> z;

        @Override // com.bytedance.sdk.component.m.io
        public void onFailed(int i, String str, Throwable th) {
        }

        public g(View view, DynamicBaseWidget dynamicBaseWidget) {
            this.z = new WeakReference<>(view);
            this.g = new WeakReference<>(dynamicBaseWidget);
        }

        @Override // com.bytedance.sdk.component.m.io
        public void onSuccess(ls<Bitmap> lsVar) {
            Bitmap result;
            DynamicBaseWidget dynamicBaseWidget;
            View view = this.z.get();
            if (view == null || (result = lsVar.getResult()) == null || lsVar.getOriginResult() == null || (dynamicBaseWidget = this.g.get()) == null) {
                return;
            }
            view.setBackground(dynamicBaseWidget.z(result));
        }
    }

    private static class z implements io<Bitmap> {
        private final gz dl;
        private final WeakReference<DynamicRootView> g;
        private final WeakReference<View> z;

        @Override // com.bytedance.sdk.component.m.io
        public void onFailed(int i, String str, Throwable th) {
        }

        public z(View view, DynamicRootView dynamicRootView, gz gzVar) {
            this.z = new WeakReference<>(view);
            this.g = new WeakReference<>(dynamicRootView);
            this.dl = gzVar;
        }

        @Override // com.bytedance.sdk.component.m.io
        public void onSuccess(ls<Bitmap> lsVar) {
            View view = this.z.get();
            if (!com.bytedance.sdk.component.adexpress.a.z()) {
                DynamicRootView dynamicRootView = this.g.get();
                if (dynamicRootView == null) {
                    return;
                }
                if (!"open_ad".equals(dynamicRootView.getRenderRequest().m()) && !"splash_ad".equals(dynamicRootView.getRenderRequest().m())) {
                    view.setBackground(new BitmapDrawable(lsVar.getResult()));
                    return;
                } else {
                    view.setBackground(new BitmapDrawable(lsVar.getResult()));
                    return;
                }
            }
            if (view == null) {
                return;
            }
            view.setBackground(new BitmapDrawable(lsVar.getResult()));
            gz gzVar = this.dl;
            if (gzVar == null || gzVar.uy() == null || 6 != this.dl.uy().z() || view.getBackground() == null) {
                return;
            }
            view.getBackground().setAutoMirrored(true);
        }
    }

    private String z(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof JSONArray) {
            return z(((JSONArray) obj).opt(0));
        }
        if (obj instanceof JSONObject) {
            return z((Object) ((JSONObject) obj).optString("url"));
        }
        return null;
    }

    private void z(v vVar, final View view) {
        vVar.to(new io<Bitmap>() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.3
            @Override // com.bytedance.sdk.component.m.io
            public void onFailed(int i, String str, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.m.io
            public void onSuccess(ls<Bitmap> lsVar) {
                if (DynamicBaseWidgetImp.this.v == null) {
                    return;
                }
                if (!"open_ad".equals(DynamicBaseWidgetImp.this.v.getRenderRequest().m()) && !"splash_ad".equals(DynamicBaseWidgetImp.this.v.getRenderRequest().m())) {
                    view.setBackground(new BitmapDrawable(lsVar.getResult()));
                } else {
                    if (com.bytedance.sdk.component.adexpress.a.z()) {
                        view.setBackground(new com.bytedance.sdk.component.adexpress.dynamic.dynamicview.z(lsVar.getResult(), ((DynamicRoot) DynamicBaseWidgetImp.this.v.getChildAt(0)).z));
                        return;
                    }
                    view.setBackground(new BitmapDrawable(lsVar.getResult()));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable g(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            String string = "";
            for (int i = 0; i < jSONArray.length(); i++) {
                if (jSONArray.getString(i).startsWith("#")) {
                    arrayList.add(jSONArray.getString(i));
                } else if (jSONArray.getString(i).endsWith("deg")) {
                    string = jSONArray.getString(i);
                }
            }
            if (arrayList.size() <= 0) {
                return null;
            }
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = e.z(((String) arrayList.get(i2)).substring(0, 7));
            }
            GradientDrawable gradientDrawableZ = z(z(string), iArr);
            gradientDrawableZ.setShape(0);
            gradientDrawableZ.setCornerRadius(com.bytedance.sdk.component.adexpress.a.gz.z(this.kb, this.wp.pf()));
            return gradientDrawableZ;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void z(v vVar) {
        if ("SMARTISAN".equals(Build.BRAND) && "SM901".equals(getBuildModel())) {
            vVar.config(Bitmap.Config.ARGB_8888);
        }
    }

    private static String getBuildModel() {
        try {
            tb = com.bytedance.sdk.component.utils.io.z();
        } catch (Throwable unused) {
            tb = Build.MODEL;
        }
        if (TextUtils.isEmpty(tb)) {
            tb = Build.MODEL;
        }
        return tb;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        View view = this.pf == null ? this : this.pf;
        double dTb = this.i.uy().gc().tb();
        if (dTb < 90.0d && dTb > 0.0d) {
            com.bytedance.sdk.component.utils.gz.g().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.4
                @Override // java.lang.Runnable
                public void run() {
                    DynamicBaseWidgetImp.this.setVisibility(8);
                }
            }, (long) (dTb * 1000.0d));
        }
        z(this.i.uy().gc().js(), view);
        if (!TextUtils.isEmpty(this.wp.xl())) {
            fo();
        }
        super.onAttachedToWindow();
    }

    private void z(double d, final View view) {
        if (d > 0.0d) {
            com.bytedance.sdk.component.utils.gz.g().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.5
                @Override // java.lang.Runnable
                public void run() {
                    if (DynamicBaseWidgetImp.this.i.uy().gc().cb() != null) {
                        return;
                    }
                    view.setVisibility(0);
                    DynamicBaseWidgetImp.this.setVisibility(0);
                }
            }, (long) (d * 1000.0d));
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            removeCallbacks(this.z);
            removeCallbacks(this.g);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            if (viewGroup.getChildAt(i) instanceof InteractViewContainer) {
                viewGroup.removeViewAt(i);
            }
        }
    }

    private void fo() {
        if (this.q) {
            int iY = this.wp.y();
            int iEc = this.wp.ec();
            Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.6
                @Override // java.lang.Runnable
                public void run() {
                    if (DynamicBaseWidgetImp.this.v != null && DynamicBaseWidgetImp.this.v.getRenderRequest() != null) {
                        i renderRequest = DynamicBaseWidgetImp.this.v.getRenderRequest();
                        com.bytedance.sdk.component.adexpress.dynamic.dl.uy uyVar = new com.bytedance.sdk.component.adexpress.dynamic.dl.uy();
                        uyVar.z(renderRequest.fv());
                        uyVar.g(renderRequest.js());
                        uyVar.dl(renderRequest.tb());
                        uyVar.z(renderRequest.q());
                        uyVar.g(renderRequest.iq());
                        uyVar.dl(renderRequest.zw());
                        uyVar.a(renderRequest.io());
                        uyVar.gc(renderRequest.uf());
                        DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                        Context context = DynamicBaseWidgetImp.this.kb;
                        DynamicBaseWidgetImp dynamicBaseWidgetImp2 = DynamicBaseWidgetImp.this;
                        dynamicBaseWidgetImp.js = new InteractViewContainer(context, dynamicBaseWidgetImp2, dynamicBaseWidgetImp2.wp, uyVar, renderRequest);
                    } else {
                        DynamicBaseWidgetImp dynamicBaseWidgetImp3 = DynamicBaseWidgetImp.this;
                        Context context2 = DynamicBaseWidgetImp.this.kb;
                        DynamicBaseWidgetImp dynamicBaseWidgetImp4 = DynamicBaseWidgetImp.this;
                        dynamicBaseWidgetImp3.js = new InteractViewContainer(context2, dynamicBaseWidgetImp4, dynamicBaseWidgetImp4.wp);
                    }
                    DynamicBaseWidgetImp dynamicBaseWidgetImp5 = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp5.g(dynamicBaseWidgetImp5.js);
                    if (DynamicBaseWidgetImp.this.getParent() instanceof ViewGroup) {
                        ((ViewGroup) DynamicBaseWidgetImp.this.getParent()).setClipChildren(false);
                    }
                    DynamicBaseWidgetImp.this.setClipChildren(false);
                    DynamicBaseWidgetImp.this.js.setTag(2);
                    DynamicBaseWidgetImp dynamicBaseWidgetImp6 = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp6.z((ViewGroup) dynamicBaseWidgetImp6);
                    DynamicBaseWidgetImp dynamicBaseWidgetImp7 = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp7.addView(dynamicBaseWidgetImp7.js, new FrameLayout.LayoutParams(-1, -1));
                    DynamicBaseWidgetImp.this.js.dl();
                }
            };
            this.z = runnable;
            postDelayed(runnable, ((long) iY) * 1000);
            if (this.wp.bv() || iEc >= Integer.MAX_VALUE || iY >= iEc) {
                return;
            }
            Runnable runnable2 = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.7
                @Override // java.lang.Runnable
                public void run() {
                    if (DynamicBaseWidgetImp.this.js != null) {
                        DynamicBaseWidgetImp.this.q = false;
                        DynamicBaseWidgetImp.this.js.a();
                        DynamicBaseWidgetImp.this.js.setVisibility(4);
                        DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                        dynamicBaseWidgetImp.removeView(dynamicBaseWidgetImp.js);
                    }
                }
            };
            this.g = runnable2;
            postDelayed(runnable2, ((long) iEc) * 1000);
        }
    }
}
