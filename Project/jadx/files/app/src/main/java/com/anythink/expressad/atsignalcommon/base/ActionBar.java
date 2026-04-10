package com.anythink.expressad.atsignalcommon.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes2.dex */
public class ActionBar extends LinearLayout implements View.OnClickListener {
    private WebView a;

    public interface a {
        void a();

        View b();
    }

    public ActionBar(Context context) {
        super(context);
    }

    private View a(a aVar) {
        View viewB = aVar.b();
        if (viewB == null) {
            return null;
        }
        View viewNewActionItem = newActionItem();
        ((ViewGroup) ((ViewGroup) viewNewActionItem).getChildAt(0)).addView(viewB);
        viewB.setTag(aVar);
        viewB.setOnClickListener(this);
        return viewNewActionItem;
    }

    public void addAction(a aVar) {
        addAction(aVar, getChildCount());
    }

    public int getActionCount() {
        return getChildCount();
    }

    public WebView getWebView() {
        return this.a;
    }

    public View newActionItem() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.weight = 1.0f;
        linearLayout.setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        frameLayout.setLayoutParams(layoutParams2);
        linearLayout.addView(frameLayout);
        return linearLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        view.getTag();
    }

    public boolean removeAction(a aVar) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null) {
                Object tag = childAt.getTag();
                if ((tag instanceof a) && tag.equals(aVar)) {
                    removeView(childAt);
                    return true;
                }
            }
        }
        return false;
    }

    public void removeActionAt(int i2) {
        if (i2 < 0 || i2 >= getChildCount()) {
            return;
        }
        removeViewAt(i2);
    }

    public void removeAllActions() {
        removeAllViews();
    }

    public void setWebView(WebView webView) {
        this.a = webView;
    }

    public ActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void addAction(a aVar, int i2) {
        View viewNewActionItem;
        View viewB = aVar.b();
        if (viewB != null) {
            viewNewActionItem = newActionItem();
            ((ViewGroup) ((ViewGroup) viewNewActionItem).getChildAt(0)).addView(viewB);
            viewB.setTag(aVar);
            viewB.setOnClickListener(this);
        } else {
            viewNewActionItem = null;
        }
        addView(viewNewActionItem, i2);
    }
}
