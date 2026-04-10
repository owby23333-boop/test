package bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_if122;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.reward.RewardItem;
import com.example.adtesttool.R$id;
import com.example.adtesttool.R$layout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: TTAdCallbackListAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends BaseAdapter {
    private Context a;
    private List<bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.a> b = new ArrayList();

    /* JADX INFO: compiled from: TTAdCallbackListAdapter.java */
    class a {
        public LinearLayout a;
        public TextView b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ImageView f2133c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RelativeLayout f2134d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public TextView f2135e;

        /* JADX INFO: renamed from: bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_if122.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: TTAdCallbackListAdapter.java */
        class ViewOnClickListenerC0073a implements View.OnClickListener {
            final /* synthetic */ bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.a a;

            ViewOnClickListenerC0073a(bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.a aVar) {
                this.a = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.f2133c.getVisibility() == 0) {
                    a.this.f2133c.setSelected(!r2.isSelected());
                    a aVar = a.this;
                    aVar.f2134d.setVisibility(aVar.f2133c.isSelected() ? 0 : 8);
                    if (a.this.a.getVisibility() == 0) {
                        a.this.a(this.a);
                    }
                }
            }
        }

        a(d dVar) {
        }

        public void a(int i2, bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.a aVar) {
            this.b.setText(aVar.b());
            this.b.setEnabled(aVar.d());
            if (aVar.e()) {
                this.f2134d.setVisibility(0);
                this.f2133c.setVisibility(0);
                this.f2133c.setSelected(true);
                a(aVar);
            } else {
                this.f2134d.setVisibility(8);
                this.f2133c.setVisibility(8);
            }
            this.a.setOnClickListener(new ViewOnClickListenerC0073a(aVar));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.a aVar) {
            this.f2135e.setText("");
            if (aVar == null) {
                return;
            }
            g gVarC = aVar.c();
            AdError adErrorA = aVar.a();
            StringBuffer stringBuffer = new StringBuffer();
            if (adErrorA != null) {
                stringBuffer.append("errorCode:" + adErrorA.code + "\n");
                stringBuffer.append("errorMsg:" + adErrorA.message + "\n");
                stringBuffer.append("thirdErrorCode:" + adErrorA.thirdSdkErrorCode + "\n");
                StringBuilder sb = new StringBuilder();
                sb.append("thirdErrorMsg:");
                sb.append(adErrorA.thirdSdkErrorMessage);
                stringBuffer.append(sb.toString());
            } else if (gVarC != null) {
                stringBuffer.append("广告位id:" + gVarC.f() + "\n");
                stringBuffer.append("代码位id:" + gVarC.a() + "\n");
                stringBuffer.append("adnName:" + gVarC.b() + "\n");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ecpm:");
                sb2.append(gVarC.d());
                stringBuffer.append(sb2.toString());
                if (TextUtils.equals("onRewardVerify", aVar.b())) {
                    String strA = a(gVarC.e());
                    if (!TextUtils.isEmpty(strA)) {
                        stringBuffer.append("\n");
                        stringBuffer.append(strA);
                    }
                }
            }
            this.f2135e.setText(stringBuffer.toString());
        }

        private String a(RewardItem rewardItem) {
            if (rewardItem == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            if (rewardItem.getCustomData() != null) {
                for (Map.Entry<String, Object> entry : rewardItem.getCustomData().entrySet()) {
                    sb.append("key = ");
                    sb.append(entry.getKey());
                    sb.append("\n");
                    sb.append("value = ");
                    sb.append(entry.getValue());
                    sb.append("\n");
                }
            }
            return String.format("激励回调信息 ：\nrewardVerify() = %1$s \ngetAmount() = %2$s \ngetRewardName() = %3$s \ngetCustomData(): \n%4$s ", Boolean.valueOf(rewardItem.rewardVerify()), Float.valueOf(rewardItem.getAmount()), rewardItem.getRewardName(), sb.toString());
        }
    }

    public d(Context context) {
        this.a = context;
    }

    public void a(List<bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.a> list) {
        this.b.clear();
        this.b.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(R$layout.ttt_callback_list_item, viewGroup, false);
            aVar = new a(this);
            aVar.a = (LinearLayout) view.findViewById(R$id.callback_layout);
            aVar.b = (TextView) view.findViewById(R$id.callback_name);
            aVar.f2133c = (ImageView) view.findViewById(R$id.right_arrow);
            aVar.f2134d = (RelativeLayout) view.findViewById(R$id.callback_info_layout);
            aVar.f2135e = (TextView) view.findViewById(R$id.callback_content);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.a(i2, this.b.get(i2));
        return view;
    }

    @Override // android.widget.Adapter
    public bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.a getItem(int i2) {
        return this.b.get(i2);
    }

    public void a(String str) {
        Iterator<bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.a> it = this.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.a next = it.next();
            if (next.b().equals(str)) {
                next.b(false);
                next.a(true);
                break;
            }
        }
        notifyDataSetChanged();
    }

    public void a(String str, AdError adError) {
        Iterator<bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.a> it = this.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.a next = it.next();
            if (next.b().equals(str)) {
                next.b(true);
                next.a(adError);
                next.a(true);
                break;
            }
        }
        notifyDataSetChanged();
    }

    public void a(String str, g gVar) {
        Iterator<bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.a> it = this.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.a next = it.next();
            if (next.b().equals(str)) {
                next.b(true);
                next.a(gVar);
                next.a(true);
                break;
            }
        }
        notifyDataSetChanged();
    }

    public void a() {
        Iterator<bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.a> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().b(false);
        }
        notifyDataSetChanged();
    }
}
