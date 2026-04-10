package com.duokan.reader.ui.general;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.yuewen.lp2;
import com.yuewen.st2;

/* JADX INFO: loaded from: classes5.dex */
public class MoreActionView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f5491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f5492b;
    public View c;
    public b d;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MoreActionView.this.a();
        }
    }

    public interface b {
        void a();
    }

    public MoreActionView(Context context) {
        this(context, null);
    }

    public void a() {
        if (this.c == null || this.f5492b.getVisibility() == 0) {
            return;
        }
        this.f5491a.setVisibility(8);
        this.f5492b.setVisibility(0);
        b bVar = this.d;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void b() {
        this.f5491a.setVisibility(0);
        this.f5492b.setVisibility(8);
    }

    public ViewGroup getActionsContainer() {
        return this.f5492b;
    }

    public View getMoreView() {
        return this.f5491a;
    }

    public void setActionsView(View view) {
        View view2 = this.c;
        if (view2 != null) {
            this.f5492b.removeView(view2);
        }
        this.c = view;
        if (view != null) {
            this.f5492b.addView(view, -2, -2);
        }
    }

    public void setOnActionsExpandedListener(b bVar) {
        this.d = bVar;
    }

    public void setRightSpaceAfterMoreButton(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f5491a.getLayoutParams();
        layoutParams.rightMargin = i;
        this.f5491a.setLayoutParams(layoutParams);
        this.f5492b.setPadding(i, 0, i, 0);
    }

    public MoreActionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        addView(linearLayout);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -1;
        layoutParams.gravity = 5;
        linearLayout.setLayoutParams(layoutParams);
        ImageView imageView = new ImageView(getContext());
        this.f5491a = imageView;
        imageView.setBackgroundResource(st2.h.Qe);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImageDrawable(getContext().getResources().getDrawable(st2.h.cg));
        linearLayout.addView(imageView);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams2.width = lp2.m(getContext(), 50.0f);
        layoutParams2.height = lp2.m(getContext(), 30.0f);
        layoutParams2.rightMargin = lp2.m(getContext(), 15.0f);
        layoutParams2.gravity = 16;
        imageView.setLayoutParams(layoutParams2);
        imageView.setOnClickListener(new a());
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.f5492b = linearLayout2;
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout2.setPadding(lp2.m(getContext(), 15.0f), 0, lp2.m(getContext(), 15.0f), 0);
        addView(linearLayout2);
        linearLayout2.setVisibility(8);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) linearLayout2.getLayoutParams();
        layoutParams3.gravity = 5;
        layoutParams3.width = -2;
        layoutParams3.height = -1;
        linearLayout2.setLayoutParams(layoutParams3);
    }
}
