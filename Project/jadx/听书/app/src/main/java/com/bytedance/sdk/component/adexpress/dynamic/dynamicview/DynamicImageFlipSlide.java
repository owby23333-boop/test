package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.dl.gz;
import com.bytedance.sdk.component.adexpress.dynamic.interact.pf;
import com.bytedance.sdk.component.adexpress.g.kb;
import com.bytedance.sdk.component.adexpress.widget.ImageFlipSlideGroup;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DynamicImageFlipSlide extends DynamicImageView {
    private final g g;
    private final ImageFlipSlideGroup z;

    /* JADX INFO: loaded from: classes2.dex */
    private interface g {
        void z(z zVar);
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface z {
        void z();
    }

    public DynamicImageFlipSlide(Context context, DynamicRootView dynamicRootView, gz gzVar) {
        super(context, dynamicRootView, gzVar);
        this.g = new g() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide.1
            @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide.g
            public void z(z zVar) {
                if (DynamicImageFlipSlide.this.z != null) {
                    DynamicImageFlipSlide.this.z.z(zVar);
                }
            }
        };
        ImageFlipSlideGroup imageFlipSlideGroup = new ImageFlipSlideGroup(getContext(), TextUtils.equals(getDynamicLayoutBrickValue().gm(), "slide"));
        this.z = imageFlipSlideGroup;
        addView(imageFlipSlideGroup, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.z.z();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.z.g();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.a
    public boolean gz() {
        super.gz();
        this.z.z(this.wp.kb(), g(this.wp.kb()));
        this.z.g(this.wp.wn(), g(this.wp.wn()));
        this.z.setFilterColors(this.wp.nb());
        this.z.dl();
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public com.bytedance.sdk.component.adexpress.dynamic.gc.z getDynamicClickListener() {
        com.bytedance.sdk.component.adexpress.dynamic.gc.z dynamicClickListener = this.v.getDynamicClickListener();
        return this.wp.zz() ? new dl(dynamicClickListener, this.g) : dynamicClickListener;
    }

    /* JADX INFO: loaded from: classes2.dex */
    private static class dl implements View.OnClickListener, View.OnTouchListener, com.bytedance.sdk.component.adexpress.dynamic.gc.z {
        g g;
        com.bytedance.sdk.component.adexpress.dynamic.gc.z z;

        public dl(com.bytedance.sdk.component.adexpress.dynamic.gc.z zVar, g gVar) {
            this.z = zVar;
            this.g = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(final View view) {
            g gVar = this.g;
            if (gVar != null) {
                gVar.z(new z() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide.dl.1
                    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide.z
                    public void z() {
                        if (dl.this.z instanceof View.OnClickListener) {
                            ((View.OnClickListener) dl.this.z).onClick(view);
                        }
                    }
                });
                return;
            }
            com.bytedance.sdk.component.adexpress.dynamic.gc.z zVar = this.z;
            if (zVar instanceof View.OnClickListener) {
                ((View.OnClickListener) zVar).onClick(view);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            com.bytedance.sdk.component.adexpress.dynamic.gc.z zVar = this.z;
            if (zVar instanceof View.OnTouchListener) {
                return ((View.OnTouchListener) zVar).onTouch(view, motionEvent);
            }
            return false;
        }

        @Override // com.bytedance.sdk.component.adexpress.dynamic.gc.z
        public void z(View view) {
            com.bytedance.sdk.component.adexpress.dynamic.gc.z zVar = this.z;
            if (zVar != null) {
                zVar.z(view);
            }
        }

        @Override // com.bytedance.sdk.component.adexpress.dynamic.gc.z
        public void g(View view) {
            com.bytedance.sdk.component.adexpress.dynamic.gc.z zVar = this.z;
            if (zVar != null) {
                zVar.g(view);
            }
        }

        @Override // com.bytedance.sdk.component.adexpress.dynamic.gc.z
        public void z(kb kbVar) {
            com.bytedance.sdk.component.adexpress.dynamic.gc.z zVar = this.z;
            if (zVar != null) {
                zVar.z(kbVar);
            }
        }

        @Override // com.bytedance.sdk.component.adexpress.dynamic.gc.z
        public void z(boolean z, pf pfVar) {
            com.bytedance.sdk.component.adexpress.dynamic.gc.z zVar = this.z;
            if (zVar != null) {
                zVar.z(z, pfVar);
            }
        }

        @Override // com.bytedance.sdk.component.adexpress.dynamic.gc.z
        public void z(JSONObject jSONObject) {
            com.bytedance.sdk.component.adexpress.dynamic.gc.z zVar = this.z;
            if (zVar != null) {
                zVar.z(jSONObject);
            }
        }
    }
}
