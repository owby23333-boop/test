package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.openadsdk.R;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AppDetailInfoActivity extends Activity {
    private LinearLayout b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f17979h;
    private RecyclerView hj;
    private List<Pair<String, String>> ko;
    private ImageView mb;
    private TextView ox;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f17980u;

    private class mb extends RecyclerView.Adapter<Object> {
        private mb() {
        }
    }

    private void ox() {
        this.mb = (ImageView) findViewById(R.id.iv_detail_back);
        this.ox = (TextView) findViewById(R.id.tv_empty);
        this.hj = (RecyclerView) findViewById(R.id.permission_list);
        this.b = (LinearLayout) findViewById(R.id.ll_download);
        if (this.ko.isEmpty()) {
            this.hj.setVisibility(8);
            this.ox.setVisibility(0);
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(1);
            this.hj.setLayoutManager(linearLayoutManager);
            this.hj.setAdapter(new mb());
        }
        this.mb.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.mb(EventConstants.Refer.LP_APP_DETAIL_CLICK_CLOSE, AppDetailInfoActivity.this.f17980u);
                AppDetailInfoActivity.this.finish();
            }
        });
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.mb(EventConstants.Refer.LP_APP_DETAIL_CLICK_DOWNLOAD, AppDetailInfoActivity.this.f17980u);
                ox.mb().ox(AppDetailInfoActivity.this.f17980u);
                com.ss.android.socialbase.appdownloader.b.mb((Activity) AppDetailInfoActivity.this);
                com.ss.android.socialbase.appdownloader.b.mb(ox.mb().ox());
            }
        });
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        h.mb(EventConstants.Refer.LP_APP_DETAIL_CLICK_CLOSE, this.f17980u);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ttdownloader_activity_app_detail_info);
        if (mb()) {
            ox();
        } else {
            com.ss.android.socialbase.appdownloader.b.mb((Activity) this);
        }
    }

    public static void mb(Activity activity, long j2) {
        Intent intent = new Intent(activity, (Class<?>) AppDetailInfoActivity.class);
        intent.putExtra("app_info_id", j2);
        activity.startActivity(intent);
    }

    private boolean mb() {
        this.f17979h = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.model.ox oxVarMb = b.mb().mb(this.f17979h);
        if (oxVarMb == null) {
            return false;
        }
        this.f17980u = oxVarMb.ox;
        this.ko = oxVarMb.ww;
        return true;
    }
}
