package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.r.h;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ah;
import com.tencent.smtt.sdk.TbsListener;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"AppCompatCustomView"})
public class ComplianceTextView extends TextView {
    private String VL;
    private String VM;
    private String VN;
    private String VO;
    private String VP;
    private int VQ;
    private String VR;

    @ColorInt
    private int VS;
    private boolean VT;
    private AdTemplate mAdTemplate;

    public ComplianceTextView(Context context) {
        this(context, null);
    }

    public ComplianceTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ComplianceTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.VQ = TbsListener.ErrorCode.STARTDOWNLOAD_NEEDDOWNLOAD_KEY_ERROR;
        init(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        StringBuilder sb;
        if (TextUtils.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(this.VO) || !TextUtils.isEmpty(this.VP)) {
            sb2.append("   ");
        }
        if (!TextUtils.isEmpty(this.VO)) {
            sb2.append(str2);
        }
        if (!TextUtils.isEmpty(this.VO) && !TextUtils.isEmpty(this.VP)) {
            sb2.append(" | ");
        }
        if (!TextUtils.isEmpty(this.VP)) {
            sb2.append(str3);
        }
        int width = ((!ah.cu(getContext()) ? this.VQ : getWidth()) - getPaddingLeft()) - getPaddingRight();
        if (width < 0) {
            return;
        }
        if (a(str, sb2.toString(), width)) {
            sb = new StringBuilder();
            sb.append(str);
            sb.append("\n");
        } else {
            sb = new StringBuilder();
            sb.append(str);
            sb.append("   ");
        }
        this.VR = sb.toString();
        l(str2, str3);
        requestLayout();
    }

    private boolean a(String str, String str2, int i2) {
        StaticLayout staticLayout;
        StaticLayout staticLayout2;
        String str3 = str + str2;
        if (Build.VERSION.SDK_INT >= 23) {
            staticLayout = StaticLayout.Builder.obtain(str, 0, str.length(), getPaint(), i2).build();
            staticLayout2 = StaticLayout.Builder.obtain(str3, 0, str3.length(), getPaint(), i2).build();
        } else {
            staticLayout = new StaticLayout(str, getPaint(), i2, Layout.Alignment.ALIGN_NORMAL, 0.0f, 0.0f, true);
            staticLayout2 = new StaticLayout(str3, getPaint(), i2, Layout.Alignment.ALIGN_NORMAL, 0.0f, 0.0f, true);
        }
        return staticLayout2.getLineCount() > staticLayout.getLineCount();
    }

    @SuppressLint({"CustomViewStyleable"})
    private void init(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_ComplianceTextView);
        this.VQ = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.ksad_ComplianceTextView_ksad_width_in_landscape, TbsListener.ErrorCode.STARTDOWNLOAD_NEEDDOWNLOAD_KEY_ERROR);
        this.VS = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_ComplianceTextView_ksad_privacy_color, getResources().getColor(R.color.ksad_default_privacy_link_color));
        this.VT = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_ComplianceTextView_ksad_show_clickable_underline, true);
        if (getBackground() == null) {
            setBackground(ContextCompat.getDrawable(context, R.drawable.ksad_compliance_view_bg));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void l(final String str, final String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.VR);
        if (!TextUtils.isEmpty(this.VO)) {
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) str);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.kwad.components.core.widget.ComplianceTextView.2
                @Override // android.text.style.ClickableSpan
                public final void onClick(@NonNull View view) {
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C0405a().ar(str).as(ComplianceTextView.this.VO).ax(true).M(ComplianceTextView.this.mAdTemplate).ow());
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ComplianceTextView.this.VS);
                    textPaint.setUnderlineText(ComplianceTextView.this.VT);
                }
            }, length, spannableStringBuilder.length(), 33);
        }
        if (!TextUtils.isEmpty(this.VO) && !TextUtils.isEmpty(this.VP)) {
            spannableStringBuilder.append((CharSequence) " | ");
        }
        if (!TextUtils.isEmpty(this.VP)) {
            int length2 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) str2);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.kwad.components.core.widget.ComplianceTextView.3
                @Override // android.text.style.ClickableSpan
                public final void onClick(@NonNull View view) {
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C0405a().ar(str2).as(ComplianceTextView.this.VP).ax(true).M(ComplianceTextView.this.mAdTemplate).ow());
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ComplianceTextView.this.VS);
                    textPaint.setUnderlineText(ComplianceTextView.this.VT);
                }
            }, length2, spannableStringBuilder.length(), 33);
        }
        spannableStringBuilder.append((CharSequence) " ");
        setMovementMethod(LinkMovementMethod.getInstance());
        setHighlightColor(ContextCompat.getColor(getContext(), R.color.ksad_translucent));
        setText(spannableStringBuilder);
    }

    public void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(adInfoCb.downloadSafeInfo.appName)) {
            sb.append("应用名：");
            sb.append(adInfoCb.downloadSafeInfo.appName);
            sb.append("；");
        }
        if (!TextUtils.isEmpty(adInfoCb.downloadSafeInfo.appVersion)) {
            sb.append("版本号：");
            sb.append(adInfoCb.downloadSafeInfo.appVersion);
            sb.append("；");
        }
        if (adInfoCb.downloadSafeInfo.packageSize > 0) {
            sb.append("应用大小：");
            sb.append(h.a(adInfoCb.downloadSafeInfo.packageSize, true));
            sb.append("；");
        }
        if (!TextUtils.isEmpty(adInfoCb.downloadSafeInfo.corporationName)) {
            sb.append("开发者：");
            sb.append(adInfoCb.downloadSafeInfo.corporationName);
            sb.append("；");
        }
        this.VL = sb.toString();
        this.VM = "权限信息";
        this.VN = "隐私政策";
        AdInfo.DownloadSafeInfo downloadSafeInfo = adInfoCb.downloadSafeInfo;
        this.VO = downloadSafeInfo.appPermissionInfoUrl;
        this.VP = downloadSafeInfo.appPrivacyUrl;
        if (this.VQ > 0) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.width = !ah.cu(getContext()) ? com.kwad.sdk.b.kwai.a.a(getContext(), this.VQ) : -1;
            setLayoutParams(layoutParams);
        }
        post(new Runnable() { // from class: com.kwad.components.core.widget.ComplianceTextView.1
            @Override // java.lang.Runnable
            public final void run() {
                ComplianceTextView complianceTextView = ComplianceTextView.this;
                complianceTextView.a(complianceTextView.VL, ComplianceTextView.this.VM, ComplianceTextView.this.VN);
            }
        });
    }
}
