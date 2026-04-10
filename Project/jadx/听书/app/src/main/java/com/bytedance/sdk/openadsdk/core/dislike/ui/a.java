package com.bytedance.sdk.openadsdk.core.dislike.ui;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.ls.dl.g.m;
import com.bytedance.sdk.openadsdk.widget.FlowLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a extends BaseAdapter {
    private z dl;
    private final Context g;
    private final List<m> z;

    public interface z {
        void z(int i, m mVar);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public a(Context context, List<m> list) {
        this.z = list == null ? new ArrayList(0) : new ArrayList(list);
        this.g = context != null ? context.getApplicationContext() : context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<m> list = this.z;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.z.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View viewG;
        g gVar;
        if (view == null) {
            gVar = new g();
            viewG = com.bytedance.sdk.openadsdk.res.a.g(this.g);
            gVar.z = (TextView) viewG.findViewById(2047279094);
            gVar.g = (FlowLayout) viewG.findViewById(2047279093);
            viewG.setTag(gVar);
        } else {
            viewG = view;
            gVar = (g) view.getTag();
        }
        m mVar = this.z.get(i);
        gVar.z.setText(mVar.g());
        if (mVar.m()) {
            gVar.g.removeAllViews();
            List<m> listA = mVar.a();
            for (int i2 = 0; i2 < listA.size(); i2++) {
                final m mVar2 = listA.get(i2);
                TextView textViewG = g();
                textViewG.setText(mVar2.g());
                textViewG.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.dl != null) {
                            a.this.dl.z(i, mVar2);
                        }
                    }
                });
                gVar.g.addView(textViewG);
            }
            gVar.g.setVisibility(0);
        } else {
            gVar.z.setBackground(z());
            gVar.g.setVisibility(8);
        }
        return viewG;
    }

    private StateListDrawable z() {
        Drawable drawableZ = z(Color.parseColor("#FDE6E6E6"));
        Drawable drawableZ2 = z(Color.parseColor("#FDFFFFFF"));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, drawableZ);
        stateListDrawable.addState(new int[0], drawableZ2);
        return stateListDrawable;
    }

    private Drawable z(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    private TextView g() {
        TextView textView = new TextView(this.g);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        com.bytedance.sdk.openadsdk.core.dislike.z.a aVarG = com.bytedance.sdk.openadsdk.core.dislike.z.z.g();
        marginLayoutParams.setMargins(0, 0, aVarG.z(this.g, 8.0f), aVarG.z(this.g, 8.0f));
        textView.setLayoutParams(marginLayoutParams);
        int iZ = aVarG.z(this.g, 21.0f);
        int iZ2 = aVarG.z(this.g, 6.0f);
        textView.setPadding(iZ, iZ2, iZ, iZ2);
        Drawable drawableZ = z(Color.parseColor("#0A161823"));
        ((GradientDrawable) drawableZ).setCornerRadius(aVarG.z(this.g, 4.0f));
        textView.setBackground(drawableZ);
        textView.setTextColor(Color.parseColor("#BF161823"));
        textView.setTextSize(14.0f);
        textView.setAlpha(0.75f);
        return textView;
    }

    public void z(z zVar) {
        this.dl = zVar;
    }

    public void z(List<m> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.z.clear();
        this.z.addAll(list);
        notifyDataSetChanged();
    }

    private class g {
        FlowLayout g;
        TextView z;

        private g() {
        }
    }
}
