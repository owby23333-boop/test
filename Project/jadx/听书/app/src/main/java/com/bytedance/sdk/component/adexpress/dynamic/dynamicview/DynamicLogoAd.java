package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.a.kb;
import com.bytedance.sdk.component.adexpress.dynamic.dl.gz;
import com.bytedance.sdk.component.utils.tb;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicLogoAd extends DynamicBaseWidgetImp {
    public DynamicLogoAd(Context context, DynamicRootView dynamicRootView, gz gzVar) {
        super(context, dynamicRootView, gzVar);
        this.pf = new TextView(context);
        this.pf.setTag(Integer.valueOf(getClickArea()));
        addView(this.pf, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.a
    public boolean gz() {
        super.gz();
        this.pf.setTextAlignment(this.wp.gz());
        ((TextView) this.pf).setTextColor(this.wp.e());
        ((TextView) this.pf).setTextSize(this.wp.gc());
        if (com.bytedance.sdk.component.adexpress.a.z()) {
            ((TextView) this.pf).setIncludeFontPadding(false);
            ((TextView) this.pf).setTextSize(Math.min(((com.bytedance.sdk.component.adexpress.a.gz.g(com.bytedance.sdk.component.adexpress.a.getContext(), this.gz) - this.wp.g()) - this.wp.z()) - 0.5f, this.wp.gc()));
            ((TextView) this.pf).setText(tb.z(getContext(), "tt_logo_en"));
            return true;
        }
        if (fo()) {
            if (kb.g()) {
                ((TextView) this.pf).setText(kb.z());
                return true;
            }
            ((TextView) this.pf).setText(kb.z(this.wp.g));
            return true;
        }
        ((TextView) this.pf).setText(tb.g(getContext(), "tt_logo_cn"));
        return true;
    }

    private boolean fo() {
        if (com.bytedance.sdk.component.adexpress.a.z()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.wp.g) && this.wp.g.contains("adx:")) || kb.g();
    }
}
