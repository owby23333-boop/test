package com.yuewen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.yuewen.ej3;
import com.yuewen.st2;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class fj3 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ej3.a f11142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f11143b;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ej3.b f11144a;

        public a(ej3.b bVar) {
            this.f11144a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (fj3.this.f11142a == null) {
                return;
            }
            fj3.this.f11142a.a(this.f11144a.f10618b);
        }
    }

    public fj3(Context context, ej3.a aVar) {
        super(context);
        LayoutInflater.from(getContext()).inflate(st2.n.a0, this);
        this.f11143b = (LinearLayout) findViewById(st2.k.Q0);
        this.f11142a = aVar;
    }

    public final void b(ej3.b bVar) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(st2.n.Z, (ViewGroup) this.f11143b, false);
        ImageView imageView = (ImageView) linearLayout.findViewById(st2.k.O0);
        TextView textView = (TextView) linearLayout.findViewById(st2.k.P0);
        imageView.setImageResource(bVar.c);
        textView.setText(bVar.f10617a);
        linearLayout.setOnClickListener(new a(bVar));
        this.f11143b.addView(linearLayout);
    }

    public void setSharePlatforms(List<ej3.b> list) {
        this.f11143b.removeAllViews();
        Iterator<ej3.b> it = list.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }
}
