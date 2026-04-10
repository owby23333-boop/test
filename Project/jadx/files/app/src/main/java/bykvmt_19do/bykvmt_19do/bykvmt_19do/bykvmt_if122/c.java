package bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_if122;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.mtesttools.act.AdnDetailActivity;
import com.example.adtesttool.R$id;
import com.example.adtesttool.R$layout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: AdnListAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends BaseAdapter {
    private Context a;
    private List<bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.c> b = new ArrayList();

    /* JADX INFO: compiled from: AdnListAdapter.java */
    class a {
        public RelativeLayout a;
        public ImageView b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public TextView f2128c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public TextView f2129d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public TextView f2130e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public TextView f2131f;

        /* JADX INFO: renamed from: bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_if122.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AdnListAdapter.java */
        class ViewOnClickListenerC0072a implements View.OnClickListener {
            final /* synthetic */ bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.c a;

            ViewOnClickListenerC0072a(bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.c cVar) {
                this.a = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(c.this.a, (Class<?>) AdnDetailActivity.class);
                intent.putExtra("adn_config", this.a);
                c.this.a.startActivity(intent);
            }
        }

        a() {
        }

        public void a(int i2, bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.c cVar) {
            if (cVar.b() > 0) {
                this.b.setImageResource(cVar.b());
                this.f2128c.setText(cVar.a());
                boolean zH = bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1.d.h(cVar.c());
                if (bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1.d.f(cVar.c())) {
                    this.f2129d.setEnabled(true);
                    this.f2129d.setSelected(false);
                } else {
                    this.f2129d.setEnabled(false);
                }
                if (bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1.d.g(cVar.c())) {
                    this.f2130e.setEnabled(true);
                    this.f2130e.setSelected(false);
                } else {
                    this.f2130e.setEnabled(false);
                }
                if (zH) {
                    this.f2131f.setEnabled(true);
                    this.f2131f.setSelected(true);
                    this.f2131f.setText("不支持检测");
                } else {
                    boolean zA = bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1.d.a(c.this.a, cVar.c());
                    this.f2131f.setText("Manifest");
                    if (zA) {
                        this.f2131f.setEnabled(true);
                        this.f2131f.setSelected(false);
                    } else {
                        this.f2131f.setEnabled(false);
                    }
                }
            }
            this.a.setOnClickListener(new ViewOnClickListenerC0072a(cVar));
        }
    }

    public c(Context context) {
        this.a = context;
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
            view = LayoutInflater.from(this.a).inflate(R$layout.ttt_adn_list_item, viewGroup, false);
            aVar = new a();
            aVar.a = (RelativeLayout) view.findViewById(R$id.adn_layout);
            aVar.b = (ImageView) view.findViewById(R$id.adn_icon);
            aVar.f2128c = (TextView) view.findViewById(R$id.adn_name);
            aVar.f2129d = (TextView) view.findViewById(R$id.adapter_status);
            aVar.f2130e = (TextView) view.findViewById(R$id.sdk_status);
            aVar.f2131f = (TextView) view.findViewById(R$id.manifest_status);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.a(i2, this.b.get(i2));
        return view;
    }

    public void a(List<bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.c> list) {
        this.b.clear();
        this.b.addAll(list);
        notifyDataSetChanged();
    }
}
