package com.amgcyo.cuttadon.view.popupview;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.amgcyo.cuttadon.api.entity.fission5.Fuli5SignInDataBean;
import com.amgcyo.cuttadon.api.entity.fission5.Fuli5SignIndex;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.amgcyo.cuttadon.view.otherview.DrawTextImageView;
import com.fatcatfat.io.R;
import com.lxj.xpopup.core.CenterPopupView;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class Sign5PopupView extends CenterPopupView implements Runnable {
    private Unbinder R;
    private Fuli5SignIndex S;
    Context T;
    private int U;
    private a V;

    @BindView(R.id.bt_lxqd)
    TextView bt_lxqd;

    @BindView(R.id.csb_login)
    TextView csb_login;

    @BindView(R.id.dti_day1)
    DrawTextImageView dti_day1;

    @BindView(R.id.dti_day14)
    DrawTextImageView dti_day14;

    @BindView(R.id.dti_day2)
    DrawTextImageView dti_day2;

    @BindView(R.id.dti_day21)
    DrawTextImageView dti_day21;

    @BindView(R.id.dti_day3)
    DrawTextImageView dti_day3;

    @BindView(R.id.dti_day30)
    DrawTextImageView dti_day30;

    @BindView(R.id.dti_day4)
    DrawTextImageView dti_day4;

    @BindView(R.id.dti_day5)
    DrawTextImageView dti_day5;

    @BindView(R.id.dti_day6)
    DrawTextImageView dti_day6;

    @BindView(R.id.dti_day7)
    DrawTextImageView dti_day7;

    @BindView(R.id.iv_bg)
    ImageView iv_bg;

    @BindView(R.id.iv_close)
    ImageView iv_close;

    @BindView(R.id.ll_bottom)
    LinearLayout ll_bottom;

    @BindView(R.id.ll_coin_tips)
    LinearLayout ll_coin_tips;

    @BindView(R.id.ll_top_img)
    LinearLayout ll_top_img;

    @BindView(R.id.ll_top_text)
    LinearLayout ll_top_text;

    @BindView(R.id.ph_bottom)
    ProgressBar ph_bottom;

    @BindView(R.id.ph_top)
    ProgressBar ph_top;

    @BindView(R.id.rl_sign)
    RelativeLayout rl_sign;

    @BindView(R.id.tv_day1)
    TextView tv_day1;

    @BindView(R.id.tv_day14)
    TextView tv_day14;

    @BindView(R.id.tv_day2)
    TextView tv_day2;

    @BindView(R.id.tv_day21)
    TextView tv_day21;

    @BindView(R.id.tv_day3)
    TextView tv_day3;

    @BindView(R.id.tv_day30)
    TextView tv_day30;

    @BindView(R.id.tv_day4)
    TextView tv_day4;

    @BindView(R.id.tv_day5)
    TextView tv_day5;

    @BindView(R.id.tv_day6)
    TextView tv_day6;

    @BindView(R.id.tv_day7)
    TextView tv_day7;

    @BindView(R.id.tv_sign_tips)
    TextView tv_sign_tips;

    @BindView(R.id.vpb_right)
    ProgressBar vpb_right;

    public interface a {
        void a(int i2);
    }

    public Sign5PopupView(@NonNull Context context, Fuli5SignIndex fuli5SignIndex) {
        super(context);
        this.T = context;
        this.S = fuli5SignIndex;
    }

    public /* synthetic */ void a(DrawTextImageView[] drawTextImageViewArr, int i2) {
        o.a(this.ll_coin_tips, drawTextImageViewArr[i2].getLeft() + (this.T.getResources().getDimensionPixelSize(R.dimen.dimen6dp) / 2), ((RelativeLayout.LayoutParams) this.ll_coin_tips.getLayoutParams()).topMargin, 0, 2);
        this.ll_coin_tips.setVisibility(0);
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        return R.layout.popupview_sign5;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getMaxWidth() {
        return n.c(MkApplication.getAppContext());
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void onDestroy() {
        super.onDestroy();
        Unbinder unbinder = this.R;
        if (unbinder == null || unbinder == Unbinder.EMPTY) {
            return;
        }
        unbinder.unbind();
    }

    @OnClick({R.id.csb_login, R.id.iv_close})
    public void onViewClicked(View view) {
        a aVar;
        int i2;
        g();
        if (view.getId() != R.id.csb_login || (aVar = this.V) == null || (i2 = this.U) == 0) {
            return;
        }
        aVar.a(i2);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void r() {
        super.r();
        this.R = ButterKnife.bind(this);
        Fuli5SignIndex fuli5SignIndex = this.S;
        if (fuli5SignIndex == null) {
            return;
        }
        if (fuli5SignIndex.getSignin_state() == 0) {
            this.tv_sign_tips.setText(this.S.getSignin_tips());
        } else {
            this.tv_sign_tips.setText(this.S.getSignin_tips2());
        }
        int signin_total = this.S.getSignin_total();
        this.bt_lxqd.setText(String.format(Locale.getDefault(), "已经连续签到%d天", Integer.valueOf(signin_total)));
        List<Fuli5SignInDataBean> signin_data = this.S.getSignin_data();
        int i2 = 9;
        final DrawTextImageView[] drawTextImageViewArr = {this.dti_day1, this.dti_day2, this.dti_day3, this.dti_day4, this.dti_day5, this.dti_day6, this.dti_day7, this.dti_day14, this.dti_day21, this.dti_day30};
        TextView[] textViewArr = {this.tv_day1, this.tv_day2, this.tv_day3, this.tv_day4, this.tv_day5, this.tv_day6, this.tv_day7, this.tv_day14, this.tv_day21, this.tv_day30};
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(signin_data) && signin_data.size() >= drawTextImageViewArr.length) {
            final int i3 = 0;
            while (i3 < signin_data.size()) {
                Fuli5SignInDataBean fuli5SignInDataBean = signin_data.get(i3);
                int day = fuli5SignInDataBean.getDay();
                drawTextImageViewArr[i3].setText(String.valueOf(fuli5SignInDataBean.getAmount()));
                if (i3 != i2) {
                    if (fuli5SignInDataBean.getIs_gold() == 1) {
                        drawTextImageViewArr[i3].setDrawable(this.T.getResources().getDrawable(R.drawable.sign_gold_icon));
                    } else {
                        drawTextImageViewArr[i3].setDrawable(this.T.getResources().getDrawable(R.drawable.lw));
                    }
                }
                drawTextImageViewArr[i3].setSignStates(day <= signin_total);
                if (fuli5SignInDataBean.getToday() > 0) {
                    textViewArr[i3].setText("今日已签");
                    textViewArr[i3].setTextColor(o.b(R.color.color_FE711C));
                } else {
                    textViewArr[i3].setText(String.format(Locale.getDefault(), "%d天", Integer.valueOf(day)));
                    textViewArr[i3].setTextColor(o.b(R.color.text_99));
                }
                int max = this.ph_top.getMax();
                if (signin_total > 6) {
                    this.ph_top.setProgress(max);
                    ProgressBar progressBar = this.vpb_right;
                    progressBar.setProgress(progressBar.getMax());
                    this.ph_bottom.setProgress(signin_total);
                } else if (signin_total == 6) {
                    this.ph_top.setProgress(max);
                    this.vpb_right.setProgress(4);
                } else {
                    this.ph_top.setProgress(signin_total);
                }
                if (fuli5SignInDataBean.getTomorrow() != 1 || signin_total > 6) {
                    this.ll_coin_tips.setVisibility(8);
                } else {
                    drawTextImageViewArr[i3].post(new Runnable() { // from class: com.amgcyo.cuttadon.view.popupview.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f5183s.a(drawTextImageViewArr, i3);
                        }
                    });
                }
                i3++;
                i2 = 9;
            }
        }
        int video_amount = this.S.getVideo_amount();
        this.U = this.S.getSigin_log_id();
        if (video_amount == 0 || this.U == 0) {
            this.csb_login.setText(o.d(R.string.good));
        } else {
            this.csb_login.setText(String.format(Locale.getDefault(), "看视频再领%d金币", Integer.valueOf(video_amount)));
        }
        this.ph_top.setIndeterminate(false);
    }

    @Override // java.lang.Runnable
    public void run() {
        int max = this.ph_top.getMax();
        while (this.ph_top.getProgress() < max) {
            this.ph_top.setProgress(this.ph_top.getProgress() + 1);
            while (this.ph_top.getProgress() >= max - 1) {
                this.ph_top.setProgress(max);
                this.vpb_right.setProgress(this.vpb_right.getProgress() + 1);
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            try {
                Thread.sleep(200L);
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void s() {
        Fuli5SignIndex fuli5SignIndex;
        super.s();
        TextView textView = this.tv_sign_tips;
        if (textView == null || (fuli5SignIndex = this.S) == null) {
            return;
        }
        textView.setText(fuli5SignIndex.getSignin_tips2());
    }

    public void setListener(a aVar) {
        this.V = aVar;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void t() {
        super.t();
    }
}
