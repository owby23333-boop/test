package com.bytedance.sdk.openadsdk.core.component.reward.view.lp;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.iq.m;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.oq;

/* JADX INFO: loaded from: classes2.dex */
public class RewardLandingPageAppInfoView extends LinearLayout {
    private DownloadItemView z;

    public RewardLandingPageAppInfoView(Context context) {
        super(context);
    }

    public void z(na naVar, String str) {
        if (naVar == null) {
            return;
        }
        setBackgroundColor(-1);
        setOrientation(1);
        Context context = getContext();
        z(naVar);
        m mVarBw = naVar.bw();
        if (mVarBw == null) {
            return;
        }
        int iDl = oq.dl(context, 12.0f);
        View viewZ = z(context, mVarBw);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = iDl;
        addView(viewZ, layoutParams);
        View viewZ2 = z(context, naVar, mVarBw, str);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = iDl;
        addView(viewZ2, layoutParams2);
        int iDl2 = oq.dl(context, 16.0f);
        setPadding(iDl2, iDl, iDl2, iDl);
    }

    private void z(na naVar) {
        DownloadItemView downloadItemView = new DownloadItemView(getContext());
        this.z = downloadItemView;
        downloadItemView.z(naVar);
        addView(this.z);
    }

    private View z(Context context, m mVar) {
        TextView textView = new TextView(context);
        textView.setText(mVar.e());
        textView.setTextColor(Color.parseColor("#888888"));
        textView.setTextSize(2, 10.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        return textView;
    }

    public void setDownLoadClickListener(View.OnClickListener onClickListener) {
        DownloadItemView downloadItemView = this.z;
        if (downloadItemView == null || onClickListener == null) {
            return;
        }
        downloadItemView.setOnClickListener(onClickListener);
    }

    private View z(final Context context, final na naVar, m mVar, final String str) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        TextView textView = new TextView(context);
        textView.setText(String.format("版本号：%s", mVar.gc()));
        textView.setTextColor(Color.parseColor("#888888"));
        textView.setTextSize(2, 10.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int id = -1;
        layoutParams.addRule(9, -1);
        textView.setId(View.generateViewId());
        relativeLayout.addView(textView, layoutParams);
        if (!TextUtils.isEmpty(mVar.kb())) {
            View viewZ = z(context, relativeLayout);
            id = z(context, relativeLayout, viewZ.getId()).getId();
            viewZ.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLandingPageAppInfoView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.bytedance.sdk.openadsdk.core.un.m.z(naVar, context, str);
                }
            });
        }
        View viewG = g(context, relativeLayout, id);
        viewG.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLandingPageAppInfoView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.bytedance.sdk.openadsdk.core.un.m.g(naVar, context, str);
            }
        });
        View viewA = a(context, relativeLayout, z(context, relativeLayout, viewG.getId()).getId());
        viewA.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLandingPageAppInfoView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.bytedance.sdk.openadsdk.core.un.m.dl(naVar, context, str);
            }
        });
        dl(context, relativeLayout, z(context, relativeLayout, viewA.getId()).getId()).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLandingPageAppInfoView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.bytedance.sdk.openadsdk.core.un.m.z(context, naVar, str);
            }
        });
        return relativeLayout;
    }

    private View z(Context context, RelativeLayout relativeLayout, int i) {
        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#22000000"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(oq.dl(context, 1.5f), oq.dl(context, 8.0f));
        layoutParams.rightMargin = oq.dl(context, 6.0f);
        view.setId(View.generateViewId());
        layoutParams.addRule(0, i);
        layoutParams.addRule(15, -1);
        relativeLayout.addView(view, layoutParams);
        return view;
    }

    private View z(Context context, RelativeLayout relativeLayout) {
        TextView textView = new TextView(context);
        textView.setText("备案");
        textView.setTextColor(Color.parseColor("#262626"));
        textView.setTextSize(2, 10.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        textView.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11, -1);
        relativeLayout.addView(textView, layoutParams);
        int iDl = oq.dl(context, 6.0f);
        oq.z(textView, iDl, iDl, 0, 0);
        return textView;
    }

    private View g(Context context, RelativeLayout relativeLayout, int i) {
        TextView textView = new TextView(context);
        textView.setText("隐私");
        textView.setTextColor(Color.parseColor("#262626"));
        textView.setTextSize(2, 10.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        textView.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (i == -1) {
            layoutParams.addRule(11, -1);
        } else {
            layoutParams.addRule(0, i);
            layoutParams.rightMargin = oq.dl(context, 6.0f);
        }
        relativeLayout.addView(textView, layoutParams);
        int iDl = oq.dl(context, 6.0f);
        oq.z(textView, iDl, iDl, 0, 0);
        return textView;
    }

    private View dl(Context context, RelativeLayout relativeLayout, int i) {
        TextView textView = new TextView(context);
        textView.setText("功能");
        textView.setTextColor(Color.parseColor("#262626"));
        textView.setTextSize(2, 10.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        textView.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(0, i);
        layoutParams.rightMargin = oq.dl(context, 6.0f);
        relativeLayout.addView(textView, layoutParams);
        int iDl = oq.dl(context, 6.0f);
        oq.z(textView, iDl, iDl, 0, 0);
        return textView;
    }

    private View a(Context context, RelativeLayout relativeLayout, int i) {
        TextView textView = new TextView(context);
        textView.setText("权限");
        textView.setTextColor(Color.parseColor("#262626"));
        textView.setTextSize(2, 10.0f);
        textView.setId(View.generateViewId());
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(0, i);
        layoutParams.rightMargin = oq.dl(context, 6.0f);
        relativeLayout.addView(textView, layoutParams);
        int iDl = oq.dl(context, 6.0f);
        oq.z(textView, iDl, iDl, 0, 0);
        return textView;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        super.dispatchTouchEvent(motionEvent);
        return true;
    }
}
