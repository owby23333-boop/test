package com.anythink.expressad.advanced.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.anythink.expressad.advanced.d.c;

/* JADX INFO: loaded from: classes2.dex */
public class ATOutNativeAdvancedViewGroup extends RelativeLayout {
    private c a;

    public ATOutNativeAdvancedViewGroup(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.a != null) {
            a(1);
            if (getVisibility() == 0) {
                a(2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.a;
        if (cVar != null) {
            cVar.e(1);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (i2 == 0) {
            a(2);
            if (getParent() != null) {
                a(1);
                return;
            }
            return;
        }
        c cVar = this.a;
        if (cVar != null) {
            cVar.e(2);
        }
    }

    public void setProvider(c cVar) {
        this.a = cVar;
    }

    public ATOutNativeAdvancedViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(final int i2) {
        postDelayed(new Runnable() { // from class: com.anythink.expressad.advanced.view.ATOutNativeAdvancedViewGroup.1
            @Override // java.lang.Runnable
            public final void run() {
                if (ATOutNativeAdvancedViewGroup.this.a != null) {
                    ATOutNativeAdvancedViewGroup.this.a.d(i2);
                }
            }
        }, 200L);
    }

    public ATOutNativeAdvancedViewGroup(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
