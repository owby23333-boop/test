package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.adexpress.a.m;
import com.bytedance.sdk.component.adexpress.a.uy;
import com.bytedance.sdk.component.adexpress.dynamic.a.fo;
import com.bytedance.sdk.component.adexpress.dynamic.animation.view.AnimationImageView;
import com.bytedance.sdk.component.adexpress.dynamic.dl.gz;
import com.bytedance.sdk.component.adexpress.g.i;
import com.bytedance.sdk.component.adexpress.widget.DynamicLottieView;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.adexpress.widget.TTRoundRectImageView;
import com.bytedance.sdk.component.m.io;
import com.bytedance.sdk.component.m.iq;
import com.bytedance.sdk.component.m.ls;
import com.bytedance.sdk.component.m.v;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicImageView extends DynamicBaseWidgetImp {
    private String z;

    public DynamicImageView(Context context, DynamicRootView dynamicRootView, gz gzVar) {
        super(context, dynamicRootView, gzVar);
        if (!TextUtils.isEmpty(this.wp.nh()) && gzVar.js()) {
            DynamicLottieView dynamicLottieView = new DynamicLottieView(context);
            dynamicLottieView.setAnimationsLoop(this.wp.r());
            dynamicLottieView.setImageLottieTosPath(this.wp.nh());
            dynamicLottieView.setLottieAppNameMaxLength(this.wp.sd());
            dynamicLottieView.setLottieAdTitleMaxLength(this.wp.bm());
            dynamicLottieView.setLottieAdDescMaxLength(this.wp.yz());
            dynamicLottieView.setData(gzVar.tb());
            this.pf = dynamicLottieView;
        } else if (this.wp.pf() > 0.0f) {
            this.pf = new TTRoundRectImageView(context);
            ((TTRoundRectImageView) this.pf).setXRound((int) com.bytedance.sdk.component.adexpress.a.gz.z(context, this.wp.pf()));
            ((TTRoundRectImageView) this.pf).setYRound((int) com.bytedance.sdk.component.adexpress.a.gz.z(context, this.wp.pf()));
        } else if (!e() && "arrowButton".equals(gzVar.uy().getType())) {
            AnimationImageView animationImageView = new AnimationImageView(context);
            animationImageView.setBrickNativeValue(this.wp);
            this.pf = animationImageView;
        } else if (uy.g(this.wp.kb())) {
            this.pf = new GifView(context);
        } else {
            String strKb = this.wp.kb();
            i renderRequest = dynamicRootView.getRenderRequest();
            if (renderRequest != null && renderRequest.g() != null && TextUtils.equals(strKb, renderRequest.z())) {
                this.pf = renderRequest.g();
            } else {
                this.pf = new ImageView(context);
            }
        }
        this.z = g(this.wp.kb());
        this.pf.setTag(Integer.valueOf(getClickArea()));
        if ("arrowButton".equals(gzVar.uy().getType())) {
            if (this.wp.g() > 0 || this.wp.z() > 0) {
                this.e = Math.min(this.e, this.gz);
                this.gz = Math.min(this.e, this.gz);
                this.fo = (int) (this.fo + com.bytedance.sdk.component.adexpress.a.gz.z(context, this.wp.g() + (this.wp.z() / 2) + 0.5f));
            } else {
                this.e = Math.max(this.e, this.gz);
                this.gz = Math.max(this.e, this.gz);
            }
            this.wp.z(this.e / 2);
        }
        addView(this.pf, new FrameLayout.LayoutParams(this.e, this.gz));
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.pf instanceof ImageView) {
            Drawable drawable = ((ImageView) this.pf).getDrawable();
            if (Build.VERSION.SDK_INT < 28 || !(drawable instanceof AnimatedImageDrawable)) {
                return;
            }
            ((AnimatedImageDrawable) drawable).start();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.pf instanceof ImageView) {
            Drawable drawable = ((ImageView) this.pf).getDrawable();
            if (Build.VERSION.SDK_INT < 28 || !(drawable instanceof AnimatedImageDrawable)) {
                return;
            }
            ((AnimatedImageDrawable) drawable).stop();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.a
    public boolean gz() {
        super.gz();
        try {
            if (this.pf instanceof UpieImageView) {
                this.pf.setBackgroundColor(this.wp.l());
                if (fo()) {
                    ((UpieImageView) this.pf).setScaleType(ImageView.ScaleType.FIT_CENTER);
                } else {
                    ((UpieImageView) this.pf).setScaleType(ImageView.ScaleType.FIT_XY);
                }
                if ("cover".equals(getImageObjectFit())) {
                    ((UpieImageView) this.pf).setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                return true;
            }
        } catch (Throwable th) {
            wp.z(th);
        }
        if (!TextUtils.isEmpty(this.wp.nh())) {
            ((ImageView) this.pf).setScaleType(ImageView.ScaleType.CENTER_CROP);
            return true;
        }
        if ("arrowButton".equals(this.i.uy().getType())) {
            ((ImageView) this.pf).setImageResource(tb.gc(this.kb, "tt_white_righterbackicon_titlebar"));
            if (((ImageView) this.pf).getDrawable() != null) {
                ((ImageView) this.pf).getDrawable().setAutoMirrored(true);
            }
            this.pf.setPadding(0, 0, 0, 0);
            ((ImageView) this.pf).setScaleType(ImageView.ScaleType.FIT_XY);
            return true;
        }
        this.pf.setBackgroundColor(this.wp.l());
        String strG = this.i.uy().g();
        if (com.umeng.analytics.pro.z.m.equals(strG)) {
            ((ImageView) this.pf).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ((ImageView) this.pf).setColorFilter(this.wp.e());
            tb.z(getContext(), "tt_user", (ImageView) this.pf);
            ((ImageView) this.pf).setPadding(this.e / 10, this.gz / 5, this.e / 10, 0);
        } else if (strG != null && strG.startsWith("@")) {
            try {
                ((ImageView) this.pf).setImageResource(Integer.parseInt(strG.substring(1)));
            } catch (Exception e) {
                wp.z(e);
            }
        }
        iq iqVarGc = com.bytedance.sdk.component.adexpress.z.z.z.z().gc();
        String strKb = this.wp.kb();
        if (!TextUtils.isEmpty(strKb) && !strKb.startsWith("http:") && !strKb.startsWith("https:")) {
            strKb = fo.g(strKb, (this.v == null || this.v.getRenderRequest() == null) ? null : this.v.getRenderRequest().hh());
        }
        v vVarKey = iqVarGc.from(strKb).key(this.z);
        String strP = this.v.getRenderRequest().p();
        if (!TextUtils.isEmpty(strP)) {
            vVarKey.cacheDir(strP);
        }
        if (fo()) {
            ((ImageView) this.pf).setScaleType(ImageView.ScaleType.FIT_CENTER);
            vVarKey.config(Bitmap.Config.ARGB_4444).type(2).converter(new z(this.kb)).to(new g(this.pf, getResources()));
        } else {
            if (com.bytedance.sdk.component.adexpress.a.z()) {
                vVarKey.to((ImageView) this.pf);
            }
            ((ImageView) this.pf).setScaleType(ImageView.ScaleType.FIT_XY);
        }
        if ((this.pf instanceof ImageView) && "cover".equals(getImageObjectFit())) {
            ((ImageView) this.pf).setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        if (!com.bytedance.sdk.component.adexpress.a.z()) {
            z(vVarKey);
        }
        return true;
    }

    private static class z implements com.bytedance.sdk.component.m.uy {
        private final WeakReference<Context> z;

        public z(Context context) {
            this.z = new WeakReference<>(context);
        }

        @Override // com.bytedance.sdk.component.m.uy
        public Bitmap coverterTo(Bitmap bitmap) {
            Context context = this.z.get();
            if (context != null) {
                return com.bytedance.sdk.component.adexpress.a.g.z(context, bitmap, 25);
            }
            return null;
        }
    }

    private static class g implements io<Bitmap> {
        private Resources g;
        private WeakReference<View> z;

        @Override // com.bytedance.sdk.component.m.io
        public void onFailed(int i, String str, Throwable th) {
        }

        public g(View view, Resources resources) {
            this.z = new WeakReference<>(view);
            this.g = resources;
        }

        @Override // com.bytedance.sdk.component.m.io
        public void onSuccess(ls<Bitmap> lsVar) {
            Bitmap result;
            View view = this.z.get();
            if (view == null || (result = lsVar.getResult()) == null || lsVar.getOriginResult() == null) {
                return;
            }
            view.setBackground(new BitmapDrawable(this.g, result));
        }
    }

    private boolean fo() {
        String strWp = this.wp.wp();
        if (this.wp.tb()) {
            return true;
        }
        if (TextUtils.isEmpty(strWp)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(strWp);
            return Math.abs((((float) this.e) / (((float) this.gz) * 1.0f)) - (((float) jSONObject.optInt(MediaFormat.KEY_WIDTH)) / (((float) jSONObject.optInt(MediaFormat.KEY_HEIGHT)) * 1.0f))) > 0.01f;
        } catch (JSONException e) {
            wp.z(e);
            return false;
        }
    }

    protected String g(String str) {
        Map<String, String> mapV = this.v.getRenderRequest().v();
        if (mapV == null || mapV.size() <= 0) {
            return null;
        }
        return mapV.get(str);
    }

    private void z(v vVar) {
        vVar.type(3).to(new io() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView.1
            @Override // com.bytedance.sdk.component.m.io
            public void onFailed(int i, String str, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.m.io
            public void onSuccess(ls lsVar) {
                Object result = lsVar.getResult();
                if ((result instanceof byte[]) && (DynamicImageView.this.pf instanceof ImageView)) {
                    m.g((ImageView) DynamicImageView.this.pf, (byte[]) result, DynamicImageView.this.e, DynamicImageView.this.gz);
                }
            }
        }, 4);
    }
}
