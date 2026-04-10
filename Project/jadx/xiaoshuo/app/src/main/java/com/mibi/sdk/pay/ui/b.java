package com.mibi.sdk.pay.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.mibi.sdk.component.recharge.RechargeType;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public class b extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<RechargeType> f7159b;

    public b(Context context, List<RechargeType> list) {
        this.f7158a = context;
        this.f7159b = list;
    }

    public View a(int i, ViewGroup viewGroup) {
        PayListItem payListItem = (PayListItem) LayoutInflater.from(this.f7158a).inflate(R.layout.mibi_pay_type_list_item, viewGroup, false);
        if (i == 0) {
            payListItem.findViewById(R.id.divider).setVisibility(8);
        }
        payListItem.a();
        return payListItem;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<RechargeType> list = this.f7159b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f7159b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.f7159b == null) {
            return 0L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = a(i, viewGroup);
        }
        ((PayListItem) view).a(this.f7159b.get(i));
        return view;
    }

    public int a(RechargeType rechargeType) {
        return this.f7159b.indexOf(rechargeType);
    }

    public void a(ArrayList<RechargeType> arrayList) {
        if (arrayList != null) {
            this.f7159b = arrayList;
            notifyDataSetChanged();
        } else {
            this.f7159b = null;
            notifyDataSetInvalidated();
        }
    }
}
