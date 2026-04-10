package com.amgcyo.cuttadon.adapter.other;

import android.content.Context;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.amgcyo.cuttadon.api.entity.fission5.TipsInfo;
import com.fatcatfat.io.R;
import com.gongwen.marqueen.XMarqueeView;
import java.util.List;

/* JADX INFO: compiled from: MarqueeReadAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends com.gongwen.marqueen.c<TipsInfo> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f3084e;

    public d(List<TipsInfo> list, Context context, int i2) {
        super(list);
        this.f3083d = i2;
    }

    public void a(int i2) {
        this.f3082c = i2;
        b();
    }

    public void a(String str) {
        this.f3084e = str;
        b();
    }

    @Override // com.gongwen.marqueen.c
    public View a(XMarqueeView xMarqueeView) {
        return LayoutInflater.from(xMarqueeView.getContext()).inflate(this.f3083d, (ViewGroup) null);
    }

    @Override // com.gongwen.marqueen.c
    public void a(View view, View view2, int i2) {
        ImageView imageView = (ImageView) view2.findViewById(R.id.img_coin);
        TextView textView = (TextView) view2.findViewById(R.id.tv_tip);
        if (com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) this.a)) {
            return;
        }
        if (((TipsInfo) this.a.get(i2)).type == 1) {
            textView.setText(this.f3084e);
            int i3 = this.f3082c;
            if (i3 != 0) {
                textView.setTextColor(i3);
            }
            textView.getPaint().setFakeBoldText(false);
            imageView.setVisibility(8);
            textView.setVisibility(0);
            return;
        }
        if (((TipsInfo) this.a.get(i2)).type == 2) {
            imageView.setVisibility(0);
            textView.setVisibility(8);
            return;
        }
        if (((TipsInfo) this.a.get(i2)).type == 0) {
            textView.setTextSize(12.0f);
            textView.setText(((TipsInfo) this.a.get(i2)).mesg);
            TextPaint paint = textView.getPaint();
            int i4 = this.f3082c;
            if (i4 != 0) {
                textView.setTextColor(i4);
            }
            paint.setFakeBoldText(true);
            imageView.setVisibility(8);
            textView.setVisibility(0);
        }
    }
}
