package com.amgcyo.cuttadon.view.comic;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.activity.comic.MkComicsBaseReaderActivity;
import com.amgcyo.cuttadon.activity.feedback.MkFeedBackActivity;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.fatcatfat.io.R;
import com.lxj.xpopup.core.AttachPopupView;

/* JADX INFO: loaded from: classes.dex */
public class ComicReadMorePopupView extends AttachPopupView implements View.OnClickListener {

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    TextView f4448a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    TextView f4449b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    TextView f4450c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    TextView f4451d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    MkComicsBaseReaderActivity f4452e0;

    public ComicReadMorePopupView(@NonNull Context context) {
        super(context);
        this.f4452e0 = (MkComicsBaseReaderActivity) context;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        return R.layout.read_more_comic;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g();
        switch (view.getId()) {
            case R.id.btn_go_feedback /* 2131296740 */:
                MkComicsBaseReaderActivity mkComicsBaseReaderActivity = this.f4452e0;
                if (mkComicsBaseReaderActivity != null) {
                    r0.startActivity(mkComicsBaseReaderActivity, MkFeedBackActivity.class);
                    break;
                }
                break;
            case R.id.btn_go_help /* 2131296741 */:
                this.f4452e0.showGuiderByModelHelp();
                break;
            case R.id.btn_go_main /* 2131296742 */:
                this.f4452e0.gotoBookDetailActivity();
                break;
            case R.id.btn_go_share /* 2131296743 */:
                MkComicsBaseReaderActivity mkComicsBaseReaderActivity2 = this.f4452e0;
                if (mkComicsBaseReaderActivity2 != null && !mkComicsBaseReaderActivity2.isFinishing()) {
                    o.a((Activity) this.f4452e0);
                    break;
                }
                break;
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void r() {
        super.r();
        this.f4448a0 = (TextView) findViewById(R.id.btn_go_main);
        this.f4449b0 = (TextView) findViewById(R.id.btn_go_share);
        this.f4450c0 = (TextView) findViewById(R.id.btn_go_feedback);
        this.f4451d0 = (TextView) findViewById(R.id.btn_go_help);
        this.f4448a0.setOnClickListener(this);
        this.f4449b0.setOnClickListener(this);
        this.f4450c0.setOnClickListener(this);
        this.f4451d0.setOnClickListener(this);
    }
}
