package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.yuewen.st2;

/* JADX INFO: loaded from: classes5.dex */
public class LoadingRectangleView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f5486a;

    public LoadingRectangleView(Context context) {
        super(context);
        View viewInflate = LayoutInflater.from(getContext()).inflate(st2.n.l5, (ViewGroup) this, false);
        this.f5486a = viewInflate;
        addView(viewInflate);
        View viewFindViewById = findViewById(st2.k.Sm);
        AnimationDrawable animationDrawable = (AnimationDrawable) getContext().getResources().getDrawable(st2.h.Tf);
        viewFindViewById.setBackground(animationDrawable);
        animationDrawable.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        View viewFindViewById = findViewById(st2.k.Sm);
        if (viewFindViewById != null) {
            viewFindViewById.clearAnimation();
        }
    }
}
