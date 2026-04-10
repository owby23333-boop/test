package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.adexpress.dynamic.a.kb;
import com.bytedance.sdk.component.adexpress.dynamic.dl.gz;
import com.bytedance.sdk.component.adexpress.widget.AnimationText;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.component.utils.wp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes3.dex */
public class DynamicTextView extends DynamicBaseWidgetImp {
    public DynamicTextView(Context context, DynamicRootView dynamicRootView, gz gzVar) {
        super(context, dynamicRootView, gzVar);
        this.gz += 6;
        if (this.wp.oq()) {
            this.pf = new AnimationText(context, this.wp.e(), this.wp.gc(), 1, this.wp.gz());
            ((AnimationText) this.pf).setMaxLines(1);
        } else {
            this.pf = new TextView(context);
            ((TextView) this.pf).setIncludeFontPadding(false);
        }
        this.pf.setTag(Integer.valueOf(getClickArea()));
        addView(this.pf, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.a
    public boolean gz() {
        int i;
        double d;
        super.gz();
        if (TextUtils.isEmpty(getText())) {
            this.pf.setVisibility(4);
            return true;
        }
        if (this.wp.oq()) {
            kb();
            return true;
        }
        ((TextView) this.pf).setText(this.wp.m());
        ((TextView) this.pf).setTextDirection(5);
        this.pf.setTextAlignment(this.wp.gz());
        ((TextView) this.pf).setTextColor(this.wp.e());
        ((TextView) this.pf).setTextSize(this.wp.gc());
        if (!this.wp.iq()) {
            ((TextView) this.pf).setMaxLines(1);
            ((TextView) this.pf).setGravity(17);
            ((TextView) this.pf).setEllipsize(TextUtils.TruncateAt.END);
        } else {
            int iZw = this.wp.zw();
            if (iZw > 0) {
                ((TextView) this.pf).setLines(iZw);
                ((TextView) this.pf).setEllipsize(TextUtils.TruncateAt.END);
            }
        }
        if (this.i != null && this.i.uy() != null) {
            if (com.bytedance.sdk.component.adexpress.a.z() && fo() && (TextUtils.equals(this.i.uy().getType(), "text_star") || TextUtils.equals(this.i.uy().getType(), "score-count") || TextUtils.equals(this.i.uy().getType(), "score-count-type-1") || TextUtils.equals(this.i.uy().getType(), "score-count-type-2"))) {
                setVisibility(8);
                return true;
            }
            if (TextUtils.equals(this.i.uy().getType(), "score-count") || TextUtils.equals(this.i.uy().getType(), "score-count-type-2")) {
                try {
                    try {
                        i = Integer.parseInt(getText());
                    } catch (Exception unused) {
                    }
                } catch (NumberFormatException unused2) {
                    i = -1;
                }
                if (i < 0) {
                    if (com.bytedance.sdk.component.adexpress.a.z()) {
                        setVisibility(8);
                        return true;
                    }
                    this.pf.setVisibility(0);
                }
                if (TextUtils.equals(this.i.uy().getType(), "score-count-type-2")) {
                    ((TextView) this.pf).setText(String.format(new DecimalFormat("(###,###,###)").format(i), Integer.valueOf(i)));
                    ((TextView) this.pf).setGravity(17);
                    return true;
                }
                z((TextView) this.pf, i, getContext(), "tt_comment_num");
            } else if (TextUtils.equals(this.i.uy().getType(), "text_star")) {
                try {
                    d = Double.parseDouble(getText());
                } catch (Exception e) {
                    wp.a("DynamicStarView applyNativeStyle", e.toString());
                    d = -1.0d;
                }
                if (d < 0.0d || d > 5.0d) {
                    if (com.bytedance.sdk.component.adexpress.a.z()) {
                        setVisibility(8);
                        return true;
                    }
                    this.pf.setVisibility(0);
                }
                ((TextView) this.pf).setIncludeFontPadding(false);
                ((TextView) this.pf).setText(String.format("%.1f", Double.valueOf(d)));
            } else if (TextUtils.equals("privacy-detail", this.i.uy().getType())) {
                ((TextView) this.pf).setText("功能 | 权限 | 隐私");
            } else if (TextUtils.equals(this.i.uy().getType(), "development-name")) {
                ((TextView) this.pf).setText(tb.z(com.bytedance.sdk.component.adexpress.a.getContext(), "tt_text_privacy_development") + getText());
            } else if (TextUtils.equals(this.i.uy().getType(), "app-version")) {
                ((TextView) this.pf).setText(tb.z(com.bytedance.sdk.component.adexpress.a.getContext(), "tt_text_privacy_app_version") + getText());
            } else {
                ((TextView) this.pf).setText(getText());
            }
            this.pf.setTextAlignment(this.wp.gz());
            ((TextView) this.pf).setGravity(this.wp.fo());
            if (com.bytedance.sdk.component.adexpress.a.z()) {
                uy();
            }
        }
        return true;
    }

    private boolean fo() {
        return (this.v == null || this.v.getRenderRequest() == null || this.v.getRenderRequest().i() == 4) ? false : true;
    }

    private void uy() {
        int iZ;
        if (TextUtils.equals(this.i.uy().getType(), "source") || TextUtils.equals(this.i.uy().getType(), "title") || TextUtils.equals(this.i.uy().getType(), "text_star")) {
            int[] iArrG = kb.g(this.wp.m(), this.wp.gc(), true);
            int iZ2 = (int) com.bytedance.sdk.component.adexpress.a.gz.z(getContext(), this.wp.g());
            int iZ3 = (int) com.bytedance.sdk.component.adexpress.a.gz.z(getContext(), this.wp.dl());
            int iZ4 = (int) com.bytedance.sdk.component.adexpress.a.gz.z(getContext(), this.wp.a());
            int iZ5 = (int) com.bytedance.sdk.component.adexpress.a.gz.z(getContext(), this.wp.z());
            int iMin = Math.min(iZ2, iZ5);
            if (TextUtils.equals(this.i.uy().getType(), "source") && (iZ = ((this.gz - ((int) com.bytedance.sdk.component.adexpress.a.gz.z(getContext(), this.wp.gc()))) - iZ2) - iZ5) > 1 && iZ <= iMin * 2) {
                int i = iZ / 2;
                this.pf.setPadding(iZ3, iZ2 - i, iZ4, iZ5 - (iZ - i));
                return;
            }
            int i2 = (((iArrG[1] + iZ2) + iZ5) - this.gz) - 2;
            if (i2 <= 1) {
                return;
            }
            if (i2 <= iMin * 2) {
                int i3 = i2 / 2;
                this.pf.setPadding(iZ3, iZ2 - i3, iZ4, iZ5 - (i2 - i3));
            } else if (i2 > iZ2 + iZ5) {
                final int i4 = (i2 - iZ2) - iZ5;
                this.pf.setPadding(iZ3, 0, iZ4, 0);
                if (i4 <= ((int) com.bytedance.sdk.component.adexpress.a.gz.z(getContext(), 1.0f)) + 1) {
                    ((TextView) this.pf).setTextSize(this.wp.gc() - 1.0f);
                } else if (i4 <= (((int) com.bytedance.sdk.component.adexpress.a.gz.z(getContext(), 1.0f)) + 1) * 2) {
                    ((TextView) this.pf).setTextSize(this.wp.gc() - 2.0f);
                } else {
                    post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicTextView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                ViewGroup.LayoutParams layoutParams = DynamicTextView.this.pf.getLayoutParams();
                                layoutParams.height = DynamicTextView.this.gz + i4;
                                DynamicTextView.this.pf.setLayoutParams(layoutParams);
                                DynamicTextView.this.pf.setTranslationY(-i4);
                                ViewGroup viewGroup = (ViewGroup) DynamicTextView.this.pf.getParent();
                                viewGroup.setClipChildren(false);
                                ViewGroup viewGroup2 = (ViewGroup) DynamicTextView.this.pf.getParent().getParent();
                                viewGroup2.setClipChildren(false);
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            } else if (iZ2 > iZ5) {
                this.pf.setPadding(iZ3, iZ2 - (i2 - iMin), iZ4, iZ5 - iMin);
            } else {
                this.pf.setPadding(iZ3, iZ2 - iMin, iZ4, iZ5 - (i2 - iMin));
            }
        }
        if (TextUtils.equals(this.i.uy().getType(), "fillButton")) {
            this.pf.setTextAlignment(2);
            ((TextView) this.pf).setGravity(17);
        }
    }

    public String getText() {
        String strM = this.wp.m();
        if (TextUtils.isEmpty(strM)) {
            if (!com.bytedance.sdk.component.adexpress.a.z() && TextUtils.equals(this.i.uy().getType(), "text_star")) {
                strM = "5";
            }
            if (!com.bytedance.sdk.component.adexpress.a.z() && TextUtils.equals(this.i.uy().getType(), "score-count")) {
                strM = "6870";
            }
        }
        return (TextUtils.equals(this.i.uy().getType(), "title") || TextUtils.equals(this.i.uy().getType(), MediaFormat.KEY_SUBTITLE)) ? strM.replace("\n", "") : strM;
    }

    public void z(TextView textView, int i, Context context, String str) {
        textView.setText("(" + String.format(tb.z(context, str), Integer.valueOf(i)) + ")");
        if (i == -1) {
            textView.setVisibility(8);
        }
    }

    private void kb() {
        if (this.pf instanceof AnimationText) {
            String text = getText();
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(text);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.optString(i));
                }
            } catch (JSONException e) {
                wp.z(e);
                arrayList.add(text);
            }
            ((AnimationText) this.pf).setMaxLines(1);
            ((AnimationText) this.pf).setTextColor(this.wp.e());
            ((AnimationText) this.pf).setTextSize(this.wp.gc());
            ((AnimationText) this.pf).setAnimationText(arrayList);
            ((AnimationText) this.pf).setAnimationType(this.wp.na());
            ((AnimationText) this.pf).setAnimationDuration(this.wp.wj() * 1000);
            ((AnimationText) this.pf).z();
        }
    }
}
