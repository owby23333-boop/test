package com.bytedance.sdk.openadsdk.core.dislike.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.dt;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.widget.FlowLayout;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class tg extends BaseAdapter {
    private final Context bf;
    private e d;
    private final List<FilterWord> e;

    public class bf {
        FlowLayout bf;
        TextView e;

        private bf() {
        }
    }

    public interface e {
        void e(int i, FilterWord filterWord);
    }

    public tg(Context context, List<FilterWord> list) {
        this.e = list;
        this.bf = context != null ? context.getApplicationContext() : context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<FilterWord> list = this.e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.e.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View viewInflate;
        bf bfVar;
        if (view == null) {
            bfVar = new bf();
            viewInflate = LayoutInflater.from(this.bf).inflate(dt.vn(this.bf, "tt_dialog_listview_item"), viewGroup, false);
            bfVar.e = (TextView) viewInflate.findViewById(dt.ga(this.bf, "tt_item_tv"));
            bfVar.bf = (FlowLayout) viewInflate.findViewById(dt.ga(this.bf, "tt_item_tv_son"));
            viewInflate.setTag(bfVar);
        } else {
            viewInflate = view;
            bfVar = (bf) view.getTag();
        }
        FilterWord filterWord = this.e.get(i);
        bfVar.e.setText(filterWord.getName());
        if (!filterWord.hasSecondOptions()) {
            if (i != this.e.size() - 1) {
                bfVar.e.setBackgroundResource(dt.tg(this.bf, "tt_dislike_middle_seletor"));
            } else {
                bfVar.e.setBackgroundResource(dt.tg(this.bf, "tt_dislike_bottom_seletor"));
            }
        }
        if (i == 0) {
            bfVar.e.setBackgroundResource(dt.tg(this.bf, "tt_dislike_top_seletor"));
        }
        if (filterWord.hasSecondOptions()) {
            bfVar.bf.removeAllViews();
            List<FilterWord> options = filterWord.getOptions();
            for (int i2 = 0; i2 < options.size(); i2++) {
                final FilterWord filterWord2 = options.get(i2);
                TextView textViewE = e();
                textViewE.setText(filterWord2.getName());
                textViewE.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.tg.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (tg.this.d != null) {
                            tg.this.d.e(i, filterWord2);
                        }
                    }
                });
                bfVar.bf.addView(textViewE);
            }
            bfVar.bf.setVisibility(0);
        } else {
            bfVar.bf.setVisibility(8);
        }
        return viewInflate;
    }

    private TextView e() {
        TextView textView = new TextView(this.bf);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.setMargins(0, 0, com.bytedance.sdk.openadsdk.core.dislike.e.e.bf().e(this.bf, 8.0f), com.bytedance.sdk.openadsdk.core.dislike.e.e.bf().e(this.bf, 8.0f));
        textView.setLayoutParams(marginLayoutParams);
        textView.setPadding(com.bytedance.sdk.openadsdk.core.dislike.e.e.bf().e(this.bf, 21.0f), com.bytedance.sdk.openadsdk.core.dislike.e.e.bf().e(this.bf, 6.0f), com.bytedance.sdk.openadsdk.core.dislike.e.e.bf().e(this.bf, 21.0f), com.bytedance.sdk.openadsdk.core.dislike.e.e.bf().e(this.bf, 6.0f));
        textView.setBackgroundResource(dt.tg(this.bf, "tt_dislike_flowlayout_tv_bg"));
        textView.setTextColor(Color.parseColor("#BF161823"));
        textView.setTextSize(14.0f);
        textView.setAlpha(0.75f);
        return textView;
    }

    public void e(e eVar) {
        this.d = eVar;
    }

    public void e(List<FilterWord> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.e.clear();
        this.e.addAll(list);
        notifyDataSetChanged();
    }
}
