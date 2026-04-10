package com.kwad.components.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bg;

/* JADX INFO: loaded from: classes4.dex */
public class ComplianceTextView extends TextView {
    private String aij;
    private String aik;
    private String ail;
    private String aim;
    private String ain;
    private String aio;
    private String aip;
    private int aiq;
    private AdTemplate mAdTemplate;
    private int textColor;

    public ComplianceTextView(Context context) {
        this(context, null);
    }

    public ComplianceTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ComplianceTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aij = "...\n";
        this.aiq = MediaPlayer.MEDIA_PLAYER_OPTION_REUSE_SOCKET;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_ComplianceTextView);
        this.aiq = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.ksad_ComplianceTextView_ksad_width_in_landscape, MediaPlayer.MEDIA_PLAYER_OPTION_REUSE_SOCKET);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_ComplianceTextView_ksad_privacy_color, Color.parseColor("#99FFFFFF"));
        this.textColor = color;
        setTextColor(color);
        if (aq.isOrientationPortrait()) {
            setBackgroundColor(0);
        } else {
            setBackground(ContextCompat.getDrawable(context, R.drawable.ksad_compliance_view_bg));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        final AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        this.aik = "功能";
        this.ail = "权限";
        this.aim = "隐私";
        this.ain = adInfoEl.downloadSafeInfo.appPermissionInfoUrl;
        this.aip = adInfoEl.downloadSafeInfo.appPrivacyUrl;
        this.aio = adInfoEl.downloadSafeInfo.introductionInfoUrl;
        if (this.aiq > 0) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            getContext();
            if (!aq.QW()) {
                layoutParams.width = com.kwad.sdk.c.a.a.a(getContext(), this.aiq);
            } else {
                layoutParams.width = -1;
            }
            setLayoutParams(layoutParams);
        }
        post(new bg() { // from class: com.kwad.components.core.widget.ComplianceTextView.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                ComplianceTextView.this.a(adInfoEl.downloadSafeInfo.appName, TextUtils.isEmpty(adInfoEl.downloadSafeInfo.corporationName) ? "" : adInfoEl.downloadSafeInfo.corporationName, TextUtils.isEmpty(adInfoEl.downloadSafeInfo.recordNumber) ? "" : adInfoEl.downloadSafeInfo.recordNumber, adInfoEl.downloadSafeInfo.appVersion, ComplianceTextView.this.aik, ComplianceTextView.this.ail, ComplianceTextView.this.aim);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int width;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        getContext();
        if (!aq.QW()) {
            width = (this.aiq - getPaddingLeft()) - getPaddingRight();
            z = true;
        } else {
            width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            z = false;
        }
        if (width < 0) {
            return;
        }
        if (!z && !TextUtils.isEmpty(str2)) {
            Paint paint = new Paint();
            paint.setTextSize(getTextSize());
            float fMeasureText = width - paint.measureText(str);
            StringBuilder sb = new StringBuilder();
            if (paint.measureText(sb.append(" ").append(str2).toString()) > fMeasureText && fMeasureText > 0.0f) {
                while (str2.length() > 1) {
                    str2 = str2.substring(0, str2.length() - 1);
                    sb.setLength(0);
                    if (paint.measureText(sb.append(" ").append(str2).append(this.aij).toString()) <= fMeasureText) {
                        break;
                    }
                }
            } else {
                this.aij = "";
            }
        } else {
            this.aij = "";
        }
        b(str, str2 + this.aij, str3, str4, str5, str6, str7);
        requestLayout();
    }

    private void b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(str)) {
            spannableStringBuilder.append((CharSequence) str);
        }
        if (!TextUtils.isEmpty(str2)) {
            spannableStringBuilder.append((CharSequence) " ").append((CharSequence) str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            spannableStringBuilder.append((CharSequence) " ").append((CharSequence) str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            spannableStringBuilder.append((CharSequence) " | 版本 ").append((CharSequence) str4);
        }
        if (!TextUtils.isEmpty(this.aio)) {
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) " | ").append((CharSequence) str5);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.kwad.components.core.widget.ComplianceTextView.2
                @Override // android.text.style.ClickableSpan
                public final void onClick(View view) {
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C0344a().az("功能介绍").aA(ComplianceTextView.this.aio).aF(true).aD(ComplianceTextView.this.mAdTemplate).qW());
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ComplianceTextView.this.textColor);
                    textPaint.setUnderlineText(false);
                }
            }, length, spannableStringBuilder.length(), 33);
        }
        if (!TextUtils.isEmpty(this.ain)) {
            int length2 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) " | ").append((CharSequence) str6);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.kwad.components.core.widget.ComplianceTextView.3
                @Override // android.text.style.ClickableSpan
                public final void onClick(View view) {
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C0344a().az("权限信息").aA(ComplianceTextView.this.ain).aF(true).aD(ComplianceTextView.this.mAdTemplate).qW());
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ComplianceTextView.this.textColor);
                    textPaint.setUnderlineText(false);
                }
            }, length2, spannableStringBuilder.length(), 33);
        }
        if (!TextUtils.isEmpty(this.aip)) {
            int length3 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) " | ").append((CharSequence) str7);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.kwad.components.core.widget.ComplianceTextView.4
                @Override // android.text.style.ClickableSpan
                public final void onClick(View view) {
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C0344a().az("隐私政策").aA(ComplianceTextView.this.aip).aF(true).aD(ComplianceTextView.this.mAdTemplate).qW());
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ComplianceTextView.this.textColor);
                    textPaint.setUnderlineText(false);
                }
            }, length3, spannableStringBuilder.length(), 33);
        }
        spannableStringBuilder.append((CharSequence) " ");
        setMovementMethod(LinkMovementMethod.getInstance());
        setHighlightColor(ContextCompat.getColor(getContext(), R.color.ksad_translucent));
        setText(spannableStringBuilder);
    }
}
