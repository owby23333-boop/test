package com.amgcyo.cuttadon.activity.main;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.config.HotBookBean;
import com.amgcyo.cuttadon.api.entity.config.MkAppConfig;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.presenter.ConfigPresenter;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.database.AppDatabase;
import com.amgcyo.cuttadon.utils.otherutils.x0;
import com.amgcyo.cuttadon.view.otherview.CommonShapeButton;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class SexModel1guiderActivity extends BaseTitleBarActivity<ConfigPresenter> {

    @BindView(R.id.csb_boy)
    CommonShapeButton csbBoy;

    @BindView(R.id.csb_girl)
    CommonShapeButton csbGirl;

    @BindView(R.id.iv_bg)
    ImageView ivBg;

    @BindView(R.id.iv_boy)
    ImageView ivBoy;

    @BindView(R.id.iv_girl)
    ImageView ivGirl;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    int f2618n0 = 0;

    @BindView(R.id.traint_boy)
    ConstraintLayout traintBoy;

    @BindView(R.id.traint_girl)
    ConstraintLayout traintGirl;

    @BindView(R.id.tv_boy_desc)
    TextView tvBoyDesc;

    @BindView(R.id.tv_desc)
    TextView tvDesc;

    @BindView(R.id.tv_girl_desc)
    TextView tvGirlDesc;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ boolean f2619s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ ConstraintLayout f2620t;

        a(boolean z2, ConstraintLayout constraintLayout) {
            this.f2619s = z2;
            this.f2620t = constraintLayout;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            CommonShapeButton commonShapeButton = this.f2619s ? SexModel1guiderActivity.this.csbBoy : SexModel1guiderActivity.this.csbGirl;
            if (commonShapeButton != null) {
                commonShapeButton.setText("进入中…");
                commonShapeButton.setEnabled(false);
                this.f2620t.setEnabled(false);
                SexModel1guiderActivity.this.o();
            }
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            TextView textView = SexModel1guiderActivity.this.tvDesc;
            if (textView != null) {
                textView.setText("正在挑选你喜欢的小说");
            }
        }
    }

    private void c(boolean z2) {
        ConstraintLayout constraintLayout = z2 ? this.traintBoy : this.traintGirl;
        ConstraintLayout constraintLayout2 = z2 ? this.traintGirl : this.traintBoy;
        this.f2618n0 = z2 ? 1 : 2;
        int width = (constraintLayout.getWidth() / 2) + com.amgcyo.cuttadon.utils.otherutils.n.a(8.0f);
        if (!z2) {
            width = -width;
        }
        float f2 = width;
        ObjectAnimator duration = ObjectAnimator.ofFloat(constraintLayout, "translationX", 0.0f, f2, f2, f2).setDuration(1000L);
        duration.setInterpolator(new AccelerateDecelerateInterpolator());
        duration.addListener(new a(z2, constraintLayout));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.tvTitle, "alpha", 1.0f, 0.0f).setDuration(300L);
        duration2.addListener(new b());
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(constraintLayout2, "translationX", 0.0f, width * 2).setDuration(300L);
        duration3.setInterpolator(new AccelerateInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).after(duration3).with(duration2);
        animatorSet.start();
    }

    private void n() {
        com.amgcyo.cuttadon.utils.otherutils.g.m(this.f2618n0);
        com.amgcyo.cuttadon.utils.otherutils.r0.a((Context) this, (Class<?>) MkMainActivity.class, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        com.amgcyo.cuttadon.utils.otherutils.g0.a().b(ArticleInfo.USER_SEX, this.f2618n0);
        x0.c().a(this.f2618n0);
        final Message messageA = Message.a(this, new Object[]{true});
        final MkAppConfig appConfig = MkApplication.getAppContext().getAppConfig();
        if (appConfig == null) {
            new ConfigPresenter(me.jessyan.art.f.e.a(this)).c(messageA);
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.activity.main.n0
                @Override // java.lang.Runnable
                public final void run() {
                    SexModel1guiderActivity.a(messageA, appConfig);
                }
            }, com.anythink.expressad.exoplayer.i.a.f9492f);
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return null;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        int i2 = message.f21197s;
        if (i2 != 853) {
            if (i2 == 612) {
                n();
                return;
            }
            return;
        }
        MkAppConfig mkAppConfig = (MkAppConfig) message.f21202x;
        if (mkAppConfig == null) {
            n();
            return;
        }
        HotBookBean hot_book = mkAppConfig.getHot_book();
        if (hot_book == null) {
            n();
            return;
        }
        HashMap map = new HashMap();
        int i3 = this.f2618n0;
        if (i3 == 1) {
            map.put(1, hot_book.getBook_male());
        } else if (i3 == 2) {
            map.put(1, hot_book.getBook_female());
        } else {
            map.put(1, hot_book.getBook_default());
        }
        ArrayList<Integer> book_comics = hot_book.getBook_comics();
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) book_comics)) {
            map.put(3, book_comics);
        }
        if (map.size() > 0) {
            com.amgcyo.cuttadon.database.f fVarA = AppDatabase.i().a();
            fVarA.a();
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            Set<Map.Entry> setEntrySet = map.entrySet();
            if (setEntrySet.size() > 0) {
                for (Map.Entry entry : setEntrySet) {
                    Integer num = (Integer) entry.getKey();
                    List list = (List) entry.getValue();
                    if (!com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) list)) {
                        for (int i4 = 0; i4 < list.size(); i4++) {
                            jCurrentTimeMillis--;
                            fVarA.insert(new MkBook(jCurrentTimeMillis, ((Integer) list.get(i4)).intValue(), 1, num.intValue()));
                        }
                    }
                }
                com.amgcyo.cuttadon.i.n.a(com.anythink.expressad.d.a.b.ay, com.amgcyo.cuttadon.i.n.a(fVarA.b()));
            }
        }
        n();
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        com.amgcyo.cuttadon.utils.otherutils.g.d((Activity) this);
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.sexmodel1_guider_activity;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return false;
    }

    @OnClick({R.id.csb_boy, R.id.traint_boy, R.id.csb_girl, R.id.traint_girl})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.csb_boy /* 2131296866 */:
            case R.id.traint_boy /* 2131298542 */:
                c(true);
                break;
            case R.id.csb_girl /* 2131296868 */:
            case R.id.traint_girl /* 2131298543 */:
                c(false);
                break;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2) {
            com.amgcyo.cuttadon.app.o.b.a(this);
        }
    }

    static /* synthetic */ void a(Message message, MkAppConfig mkAppConfig) {
        message.f21197s = 853;
        message.f21202x = mkAppConfig;
        message.b();
    }

    @Override // me.jessyan.art.base.f.h
    @NonNull
    public ConfigPresenter obtainPresenter() {
        if (this.f2276v == 0) {
            this.f2276v = new ConfigPresenter(me.jessyan.art.f.e.a(this));
        }
        return (ConfigPresenter) this.f2276v;
    }
}
