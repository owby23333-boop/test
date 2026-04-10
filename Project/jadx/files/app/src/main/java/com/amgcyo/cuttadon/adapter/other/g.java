package com.amgcyo.cuttadon.adapter.other;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.fatcatfat.io.R;
import java.util.List;

/* JADX INFO: compiled from: MkDonationAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends ArrayAdapter<String> {

    /* JADX INFO: compiled from: MkDonationAdapter.java */
    private static final class a {
        TextView a;

        public a(View view) {
            this.a = (TextView) view.findViewById(R.id.tv_tab_title);
        }
    }

    public g(Context context, List<String> list) {
        super(context, 0, list);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    @NonNull
    public View getView(int i2, View view, @NonNull ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.item_title, viewGroup, false);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        String item = getItem(i2);
        if (item != null) {
            aVar.a.setText(item);
        }
        return view;
    }
}
