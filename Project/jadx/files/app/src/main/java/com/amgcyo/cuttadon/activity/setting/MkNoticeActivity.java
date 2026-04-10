package com.amgcyo.cuttadon.activity.setting;

import android.app.NotificationManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.activity.feedback.MkFeedBackActivity;
import com.amgcyo.cuttadon.activity.user.MkMsgNoticeActivity;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.fatcatfat.io.R;
import com.umeng.message.entity.UMessage;

/* JADX INFO: loaded from: classes.dex */
public class MkNoticeActivity extends BaseTitleBarActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private String f2849n0;

    @BindView(R.id.notic_view)
    View notic_view;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private int f2850o0 = 1;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private int f2851p0 = 0;

    @BindView(R.id.tv_cancel)
    TextView tvCancel;

    @BindView(R.id.tv_msg)
    TextView tvMsg;

    @BindView(R.id.tv_submit)
    TextView tvSubmit;

    @BindView(R.id.tv_title)
    TextView tv_title;

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return null;
    }

    public /* synthetic */ void e(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("tip_number", 1);
        r0.startActivity(this.f2277w, bundle, MkFeedBackActivity.class);
        finish();
    }

    public /* synthetic */ void f(View view) {
        finish();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        try {
            ((NotificationManager) getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION)).cancelAll();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public /* synthetic */ void g(View view) {
        r0.startActivity(this.f2277w, MkMsgNoticeActivity.class);
        finish();
    }

    public /* synthetic */ void h(View view) {
        com.amgcyo.cuttadon.f.o.a(this.f2277w, this.f2850o0, this.f2849n0);
        finish();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0084  */
    @Override // me.jessyan.art.base.f.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void initData(@androidx.annotation.Nullable android.os.Bundle r11) {
        /*
            Method dump skipped, instruction units count: 406
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.activity.setting.MkNoticeActivity.initData(android.os.Bundle):void");
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.dialog_activity;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return false;
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public me.jessyan.art.mvp.c obtainPresenter() {
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.tv_cancel) {
            finish();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (1 == this.f2851p0 && (i2 == 4 || i2 == 3)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }
}
