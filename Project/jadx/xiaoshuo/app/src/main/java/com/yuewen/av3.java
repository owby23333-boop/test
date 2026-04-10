package com.yuewen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.yuewen.ls2;

/* JADX INFO: loaded from: classes14.dex */
public class av3 extends ad1 {
    public TextView l;
    public final int m;
    public View n;
    public ImageView o;

    public av3(String str, int i) {
        this.f8473a = str;
        this.m = i;
    }

    @Override // com.yuewen.bd1
    public View a(View view, ViewGroup viewGroup, String str) {
        View viewB = b(view);
        if (viewB == null) {
            viewB = LayoutInflater.from(viewGroup.getContext()).inflate(ls2.n.Ho, viewGroup, false);
            this.l = (TextView) viewB.findViewById(ls2.k.oc0);
            this.o = (ImageView) viewB.findViewById(ls2.k.nc0);
            this.n = viewB.findViewById(ls2.k.mc0);
        } else {
            av3 av3Var = (av3) viewB.getTag();
            this.l = av3Var.l;
            this.o = av3Var.o;
            this.n = av3Var.n;
        }
        this.l.setText(this.f8473a);
        this.o.setImageResource(getType() == 2 ? ls2.h.j80 : ls2.h.i80);
        k(viewB);
        return viewB;
    }

    @Override // com.yuewen.bd1
    public int getType() {
        return this.m;
    }

    public View m() {
        return this.n;
    }
}
