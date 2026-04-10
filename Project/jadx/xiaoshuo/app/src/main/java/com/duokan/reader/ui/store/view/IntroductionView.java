package com.duokan.reader.ui.store.view;

import android.content.Context;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.yuewen.yt2;

/* JADX INFO: loaded from: classes5.dex */
public class IntroductionView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f6534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f6535b;
    public boolean c;
    public String d;
    public String e;
    public int f;
    public final int g;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IntroductionView introductionView = IntroductionView.this;
            introductionView.e = introductionView.getPackUpText();
            IntroductionView.this.f6534a.setText(IntroductionView.this.e);
        }
    }

    public IntroductionView(Context context) {
        super(context);
        this.f = 2;
        this.g = Integer.MAX_VALUE;
        h(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPackUpText() {
        int lineEnd;
        if (TextUtils.isEmpty(this.d)) {
            return "";
        }
        String strReplaceAll = this.d.replaceAll("\r|\n", "");
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(strReplaceAll, 0, strReplaceAll.length() - 1, this.f6534a.getPaint(), this.f6534a.getMeasuredWidth());
        builderObtain.setIncludePad(false);
        builderObtain.setLineSpacing(0.02f, 1.6f);
        StaticLayout staticLayoutBuild = builderObtain.build();
        if (this.f6534a.getLineCount() < this.f) {
            return strReplaceAll;
        }
        float lineWidth = staticLayoutBuild.getLineWidth(0) / (staticLayoutBuild.getLineEnd(0) + 1);
        int i = this.f - 1;
        float lineWidth2 = staticLayoutBuild.getLineWidth(i);
        int measuredWidth = this.f6535b.getMeasuredWidth();
        if (lineWidth2 > r1 - measuredWidth) {
            lineEnd = staticLayoutBuild.getLineEnd(i) - ((int) ((measuredWidth / lineWidth) + 1.0f));
        } else {
            lineEnd = staticLayoutBuild.getLineEnd(i);
        }
        if (lineEnd > 1) {
            strReplaceAll = strReplaceAll.substring(0, lineEnd - 1);
        }
        if (strReplaceAll.endsWith("…") || strReplaceAll.endsWith("...")) {
            return strReplaceAll;
        }
        return strReplaceAll + "…";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        this.f6534a.setMaxLines(this.f);
        this.f6534a.setText(this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        this.f6534a.setMaxLines(Integer.MAX_VALUE);
        this.f6534a.setText(this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(Context context, View view) {
        if (this.c) {
            this.c = false;
            this.f6535b.startAnimation(AnimationUtils.loadAnimation(context, yt2.a.b1));
            this.f6534a.postDelayed(new Runnable() { // from class: com.yuewen.ko1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13562a.i();
                }
            }, 100L);
        } else {
            this.c = true;
            this.f6535b.startAnimation(AnimationUtils.loadAnimation(context, yt2.a.c1));
            this.f6534a.postDelayed(new Runnable() { // from class: com.yuewen.lo1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13949a.j();
                }
            }, 100L);
        }
    }

    public final void h(final Context context) {
        LayoutInflater.from(context).inflate(yt2.n.l4, (ViewGroup) this, true);
        this.f6534a = (TextView) findViewById(yt2.k.H9);
        this.f6535b = (ImageView) findViewById(yt2.k.I9);
        int maxLines = this.f6534a.getMaxLines();
        this.f = maxLines;
        this.f6534a.setMaxLines(maxLines);
        this.f6534a.post(new a());
        this.f6535b.setOnClickListener(new View.OnClickListener() { // from class: com.yuewen.jo1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13029a.k(context, view);
            }
        });
    }

    public void setDescription(String str) {
        this.d = str;
        this.f6534a.setText(str);
    }

    public IntroductionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 2;
        this.g = Integer.MAX_VALUE;
        h(context);
    }

    public IntroductionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 2;
        this.g = Integer.MAX_VALUE;
        h(context);
    }
}
