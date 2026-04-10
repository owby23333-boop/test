package com.yuewen;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.duokan.advertisement.i;

/* JADX INFO: loaded from: classes12.dex */
public class lx2 implements mx2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f14222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f14223b;

    public lx2(ViewGroup viewGroup, View view) {
        this.f14222a = (TextView) view.findViewById(i.k.eg);
        this.f14223b = viewGroup;
    }

    @Override // com.yuewen.mx2
    public void a(int i) {
        TextView textView = this.f14222a;
        if (textView != null) {
            textView.setTextColor(ColorUtils.setAlphaComponent(i, 53));
        }
    }

    @Override // com.yuewen.mx2
    public View getAdView() {
        return null;
    }

    @Override // com.yuewen.mx2
    public void setVisible(boolean z) {
        TextView textView = this.f14222a;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
        this.f14223b.setVisibility(z ? 8 : 0);
    }
}
