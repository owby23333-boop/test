package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.bytedance.gromore.R;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AppDetailInfoActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ListView f1974a;
    private LinearLayout dl;
    private List<Pair<String, String>> e;
    private TextView g;
    private long gc;
    private long m;
    private ImageView z;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ttdownloader_activity_app_detail_info);
        if (z()) {
            g();
        } else {
            com.ss.android.socialbase.appdownloader.dl.z((Activity) this);
        }
    }

    public static void z(Activity activity, long j) {
        Intent intent = new Intent(activity, (Class<?>) AppDetailInfoActivity.class);
        intent.putExtra("app_info_id", j);
        activity.startActivity(intent);
    }

    private boolean z() {
        this.gc = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.g.g gVarZ = dl.z().z(this.gc);
        if (gVarZ == null) {
            return false;
        }
        this.m = gVarZ.g;
        this.e = gVarZ.gz;
        return true;
    }

    private void g() {
        this.z = (ImageView) findViewById(R.id.iv_detail_back);
        this.g = (TextView) findViewById(R.id.tv_empty);
        this.f1974a = (ListView) findViewById(R.id.permission_list);
        this.dl = (LinearLayout) findViewById(R.id.ll_download);
        if (this.e.isEmpty()) {
            this.f1974a.setVisibility(8);
            this.g.setVisibility(0);
        } else {
            this.f1974a.setAdapter((ListAdapter) new z());
        }
        this.z.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.z("lp_app_detail_click_close", AppDetailInfoActivity.this.m);
                AppDetailInfoActivity.this.finish();
            }
        });
        this.dl.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.z("lp_app_detail_click_download", AppDetailInfoActivity.this.m);
                com.ss.android.downloadlib.addownload.compliance.g.z().g(AppDetailInfoActivity.this.m);
                com.ss.android.socialbase.appdownloader.dl.z((Activity) AppDetailInfoActivity.this);
                com.ss.android.socialbase.appdownloader.dl.z(com.ss.android.downloadlib.addownload.compliance.g.z().g());
            }
        });
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        e.z("lp_app_detail_click_close", this.m);
        super.onBackPressed();
    }

    private class z extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        private z() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return AppDetailInfoActivity.this.e.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return AppDetailInfoActivity.this.e.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            g gVar;
            if (view == null) {
                view = View.inflate(AppDetailInfoActivity.this, R.layout.ttdownloader_item_permission, null);
                gVar = new g();
                gVar.z = (TextView) view.findViewById(R.id.tv_permission_title);
                gVar.g = (TextView) view.findViewById(R.id.tv_permission_description);
                gVar.dl = view.findViewById(R.id.dash_line);
                view.setTag(gVar);
            } else {
                gVar = (g) view.getTag();
            }
            gVar.z.setText((CharSequence) ((Pair) AppDetailInfoActivity.this.e.get(i)).first);
            gVar.g.setText((CharSequence) ((Pair) AppDetailInfoActivity.this.e.get(i)).second);
            if (i == getCount() - 1) {
                gVar.dl.setVisibility(8);
            }
            return view;
        }
    }

    private static class g {
        public View dl;
        public TextView g;
        public TextView z;

        private g() {
        }
    }
}
