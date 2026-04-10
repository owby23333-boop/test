package bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_if122;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.e;
import com.bytedance.mtesttools.act.AdSlotDetailActivity;
import com.example.adtesttool.R$id;
import com.example.adtesttool.R$layout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AdSlotIdListAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends BaseAdapter {
    private Activity a;
    private List<e> b = new ArrayList();

    /* JADX INFO: compiled from: AdSlotIdListAdapter.java */
    class a {
        public RelativeLayout a;
        public ImageView b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public TextView f2124c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public TextView f2125d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public TextView f2126e;

        /* JADX INFO: renamed from: bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_if122.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AdSlotIdListAdapter.java */
        class ViewOnClickListenerC0071a implements View.OnClickListener {
            final /* synthetic */ e a;

            ViewOnClickListenerC0071a(e eVar) {
                this.a = eVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(b.this.a, (Class<?>) AdSlotDetailActivity.class);
                intent.putExtra("water_fall_config", this.a);
                b.this.a.startActivityForResult(intent, 22);
            }
        }

        a() {
        }

        public void a(int i2, e eVar) {
            if (eVar.b() > 0) {
                this.b.setImageResource(eVar.b());
            }
            this.f2124c.setText(eVar.c());
            if (eVar.k()) {
                this.f2125d.setVisibility(0);
            } else {
                this.f2125d.setVisibility(8);
            }
            if (eVar.f() == 0) {
                this.f2126e.setText("未测试");
                this.f2126e.setEnabled(true);
                this.f2126e.setSelected(true);
            } else if (eVar.f() == 1) {
                this.f2126e.setText("测试完成");
                this.f2126e.setEnabled(true);
                this.f2126e.setSelected(false);
            } else {
                this.f2126e.setText("测试失败");
                this.f2126e.setEnabled(false);
            }
            this.a.setOnClickListener(new ViewOnClickListenerC0071a(eVar));
        }
    }

    public b(Activity activity) {
        this.a = activity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.b.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(R$layout.ttt_slot_list_item, viewGroup, false);
            aVar = new a();
            aVar.a = (RelativeLayout) view.findViewById(R$id.slot_layout);
            aVar.b = (ImageView) view.findViewById(R$id.adn_icon);
            aVar.f2124c = (TextView) view.findViewById(R$id.slot_id);
            aVar.f2125d = (TextView) view.findViewById(R$id.bidding_ad);
            aVar.f2126e = (TextView) view.findViewById(R$id.slot_load_status);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.a(i2, this.b.get(i2));
        return view;
    }

    public void a(List<e> list) {
        this.b.clear();
        this.b.addAll(list);
        notifyDataSetChanged();
    }

    public void a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<e> it = this.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            e next = it.next();
            if (str.equals(next.c())) {
                next.d(i2);
                break;
            }
        }
        notifyDataSetChanged();
    }

    public int a() {
        int i2 = 1;
        for (e eVar : this.b) {
            if (eVar.f() == 0) {
                return 0;
            }
            if (eVar.f() == 2) {
                i2 = 2;
            }
        }
        return i2;
    }
}
