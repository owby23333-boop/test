package bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_if122;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.example.adtesttool.R$id;
import com.example.adtesttool.R$layout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AdExpandableAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends BaseExpandableListAdapter {
    private Context a;
    private List<bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.b> b = new ArrayList();

    /* JADX INFO: renamed from: bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_if122.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdExpandableAdapter.java */
    class C0070a {
        public TextView a;
        public TextView b;

        C0070a(a aVar) {
        }
    }

    /* JADX INFO: compiled from: AdExpandableAdapter.java */
    class b {
        public TextView a;

        b(a aVar) {
        }
    }

    public a(Context context) {
        this.a = context;
    }

    public void a(List<bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.b> list) {
        if (list == null) {
            return;
        }
        this.b.clear();
        this.b.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i2, int i3) {
        return 0L;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildType(int i2, int i3) {
        return super.getChildType(i2, i3);
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildTypeCount() {
        return 1;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i2, int i3, boolean z2, View view, ViewGroup viewGroup) {
        C0070a c0070a;
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(R$layout.ttt_ad_list_child_item, viewGroup, false);
            c0070a = new C0070a(this);
            c0070a.a = (TextView) view.findViewById(R$id.ad_id);
            c0070a.b = (TextView) view.findViewById(R$id.ad_load_status);
            view.setTag(c0070a);
        } else {
            c0070a = (C0070a) view.getTag();
        }
        bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.d dVar = this.b.get(i2).a().get(i3);
        c0070a.a.setText(dVar.b());
        if (dVar.a() == 0) {
            c0070a.b.setText("未测试");
            c0070a.b.setEnabled(true);
            c0070a.b.setSelected(true);
        } else if (dVar.a() == 1) {
            c0070a.b.setText("测试完成");
            c0070a.b.setEnabled(true);
            c0070a.b.setSelected(false);
        } else {
            c0070a.b.setText("测试失败");
            c0070a.b.setEnabled(false);
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i2) {
        bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.b bVar;
        if (i2 >= this.b.size() || (bVar = this.b.get(i2)) == null || bVar.a() == null) {
            return 0;
        }
        return bVar.a().size();
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.b.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i2) {
        return 0L;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getGroupType(int i2) {
        return super.getGroupType(i2);
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getGroupTypeCount() {
        return super.getGroupTypeCount();
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i2, boolean z2, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(R$layout.ttt_ad_list_group_item, viewGroup, false);
            bVar = new b(this);
            bVar.a = (TextView) view.findViewById(R$id.ad_type);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.a.setText(this.b.get(i2).b());
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i2, int i3) {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.d getChild(int i2, int i3) {
        bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.b bVar;
        if (i2 < this.b.size() && (bVar = this.b.get(i2)) != null && bVar.a() != null && bVar.a().size() > i3) {
            return bVar.a().get(i3);
        }
        return null;
    }

    @Override // android.widget.ExpandableListAdapter
    public bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.b getGroup(int i2) {
        if (i2 >= this.b.size()) {
            return null;
        }
        return this.b.get(i2);
    }

    public void a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.b> it = this.b.iterator();
        loop0: while (true) {
            if (!it.hasNext()) {
                break;
            }
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.b next = it.next();
            if (next != null && next.a() != null) {
                for (bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.d dVar : next.a()) {
                    if (str.equals(dVar.b())) {
                        dVar.a(i2);
                        break loop0;
                    }
                }
            }
        }
        notifyDataSetChanged();
    }
}
