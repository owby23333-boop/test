package com.amgcyo.cuttadon.activity.main;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.config.HotBookBean;
import com.amgcyo.cuttadon.api.entity.config.MkAppConfig;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.presenter.ConfigPresenter;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.database.AppDatabase;
import com.amgcyo.cuttadon.utils.otherutils.x0;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class SexModel0guiderActivity extends BaseTitleBarActivity<ConfigPresenter> {

    @BindView(R.id.enter_application)
    TextView enterApplication;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private ValueAnimator f2615n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private String[] f2616o0 = {"     ", ".    ", ". .  ", ". . ."};

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    int f2617p0 = 0;

    private void n() {
        com.amgcyo.cuttadon.utils.otherutils.g.m(this.f2617p0);
        com.amgcyo.cuttadon.utils.otherutils.r0.a((Context) this, (Class<?>) MkMainActivity.class, true);
    }

    private void o() {
        if (this.f2615n0 == null) {
            this.f2615n0 = ValueAnimator.ofInt(0, 4).setDuration(1200L);
            this.f2615n0.setRepeatCount(-1);
            this.f2615n0.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.amgcyo.cuttadon.activity.main.l0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f2653s.a(valueAnimator);
                }
            });
        }
        this.f2615n0.start();
        com.amgcyo.cuttadon.utils.otherutils.g0.a().b(ArticleInfo.USER_SEX, this.f2617p0);
        x0.c().a(this.f2617p0);
        final Message messageA = Message.a(this, new Object[]{true});
        final MkAppConfig appConfig = MkApplication.getAppContext().getAppConfig();
        if (appConfig == null) {
            new ConfigPresenter(me.jessyan.art.f.e.a(this)).c(messageA);
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.activity.main.m0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2655s.a(messageA, appConfig);
                }
            }, com.anythink.expressad.exoplayer.i.a.f9492f);
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        TextView textView = this.enterApplication;
        if (textView != null) {
            textView.setVisibility(0);
            TextView textView2 = this.enterApplication;
            String[] strArr = this.f2616o0;
            textView2.setText(String.format("%s%s", com.amgcyo.cuttadon.f.o.d(R.string.enter_application), strArr[iIntValue % strArr.length]));
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return null;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        String str = "what:" + message.f21197s;
        ValueAnimator valueAnimator = this.f2615n0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
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
        int i3 = this.f2617p0;
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
        return R.layout.sexmodel0_guider_activity;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return false;
    }

    public void onBoyClick(View view) {
        this.f2617p0 = 1;
        o();
    }

    public void onGirlClick(View view) {
        this.f2617p0 = 2;
        o();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2) {
            com.amgcyo.cuttadon.app.o.b.a(this);
        }
    }

    @Override // me.jessyan.art.base.f.h
    @NonNull
    public ConfigPresenter obtainPresenter() {
        if (this.f2276v == 0) {
            this.f2276v = new ConfigPresenter(me.jessyan.art.f.e.a(this));
        }
        return (ConfigPresenter) this.f2276v;
    }

    public /* synthetic */ void a(Message message, MkAppConfig mkAppConfig) {
        message.f21197s = 853;
        message.f21202x = mkAppConfig;
        message.b();
        ValueAnimator valueAnimator = this.f2615n0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}
