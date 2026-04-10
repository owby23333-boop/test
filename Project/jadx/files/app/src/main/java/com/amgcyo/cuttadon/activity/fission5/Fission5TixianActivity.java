package com.amgcyo.cuttadon.activity.fission5;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.fission5.ScheduleBean;
import com.amgcyo.cuttadon.api.entity.fission5.TxStepBean;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Fission5TixianActivity extends BaseTitleBarActivity<UserPresenter> {

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    TxStepBean f2527n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    b f2528o0;

    @BindView(R.id.rl_plat)
    RelativeLayout rl_plat;

    @BindView(R.id.rv_step)
    RecyclerView rv_step;

    @BindView(R.id.tv_money)
    TextView tv_money;

    @BindView(R.id.tv_time)
    TextView tv_time;

    @BindView(R.id.tv_tx_state)
    TextView tv_tx_state;

    @BindView(R.id.tv_type)
    TextView tv_type;

    @BindView(R.id.tv_yq)
    TextView tv_yq;

    class b extends BaseQuickAdapter<ScheduleBean, com.chad.library.adapter.base.b> {
        private int K;

        private b(@Nullable Fission5TixianActivity fission5TixianActivity, List<ScheduleBean> list, int i2) {
            super(R.layout.item_progress_step, list);
            this.K = i2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public void a(@NonNull com.chad.library.adapter.base.b bVar, ScheduleBean scheduleBean) {
            TextView textView = (TextView) bVar.a(R.id.item_title);
            TextView textView2 = (TextView) bVar.a(R.id.item_time);
            ImageView imageView = (ImageView) bVar.a(R.id.item_shuxian0);
            ImageView imageView2 = (ImageView) bVar.a(R.id.item_shuxian1);
            ImageView imageView3 = (ImageView) bVar.a(R.id.iv_step);
            textView.setText(scheduleBean.getTitle());
            textView2.setText(scheduleBean.getDatetime());
            int adapterPosition = bVar.getAdapterPosition();
            if (adapterPosition == 0) {
                imageView.setVisibility(4);
                imageView.setBackgroundColor(o.b(R.color.colorPrimary));
                imageView2.setVisibility(0);
                imageView3.setImageResource(R.drawable.tx_step1);
                textView.setTextColor(o.b(R.color.color_222222));
                return;
            }
            if (adapterPosition == 1) {
                imageView3.setImageResource(R.drawable.tx_step2);
                imageView.setVisibility(0);
                imageView2.setVisibility(0);
                imageView.setBackgroundColor(o.b(R.color.colorPrimary));
                textView.setTextColor(o.b(R.color.color_222222));
                return;
            }
            if (adapterPosition != 2) {
                return;
            }
            imageView2.setVisibility(4);
            imageView.setVisibility(0);
            if (this.K != 1) {
                imageView.setBackgroundColor(o.b(R.color.dddddd));
                imageView3.setImageResource(R.drawable.tx_step3_n);
                textView.setTextColor(o.b(R.color.text_99));
            } else {
                imageView.setBackgroundColor(o.b(R.color.colorPrimary));
                imageView3.setImageResource(R.drawable.tx_step3);
                textView.setTextColor(o.b(R.color.color_222222));
            }
        }
    }

    private void n() {
        int state = this.f2527n0.getState();
        if (state == -1) {
            this.tv_tx_state.setTextColor(o.b(R.color.color_F85959));
            this.tv_money.setTextColor(o.b(R.color.color_F85959));
            this.tv_tx_state.setText("处理中");
            this.rl_plat.setVisibility(8);
        } else if (state == 0) {
            this.tv_money.setTextColor(o.b(R.color.color_222222));
            this.tv_tx_state.setTextColor(o.b(R.color.accent_orange));
            this.tv_tx_state.setText("审核中");
            this.rl_plat.setVisibility(8);
        } else if (state == 1) {
            this.tv_tx_state.setTextColor(o.b(R.color.text_99));
            this.tv_money.setTextColor(o.b(R.color.color_222222));
            this.tv_tx_state.setText("提现成功");
            this.rl_plat.setVisibility(0);
            this.tv_type.setText(this.f2527n0.getArrive_account());
            this.tv_time.setText(this.f2527n0.getArrive_datetime());
        } else if (state == 2) {
            this.tv_tx_state.setTextColor(o.b(R.color.color_F85959));
            this.tv_money.setTextColor(o.b(R.color.color_F85959));
            this.tv_tx_state.setText("失败，退回");
            this.rl_plat.setVisibility(8);
        } else if (state == 3) {
            this.tv_tx_state.setTextColor(o.b(R.color.color_F85959));
            this.tv_money.setTextColor(o.b(R.color.color_F85959));
            this.tv_tx_state.setText("取消资格");
            this.rl_plat.setVisibility(8);
        }
        String arrive_money = this.f2527n0.getArrive_money();
        SpannableString spannableString = new SpannableString(arrive_money + "  元");
        spannableString.setSpan(new RelativeSizeSpan(2.0f), 0, arrive_money.length(), 33);
        this.tv_money.setText(spannableString);
        String invitation_button = this.f2527n0.getInvitation_button();
        if (TextUtils.isEmpty(invitation_button)) {
            this.tv_yq.setVisibility(4);
            this.tv_yq.setText("");
        } else {
            this.tv_yq.setVisibility(0);
            this.tv_yq.setText(invitation_button);
        }
        this.f2528o0 = new b(this.f2527n0.getSchedule(), this.f2527n0.getState());
        this.rv_step.setLayoutManager(new LinearLayoutManager(this.f2277w));
        this.rv_step.setAdapter(this.f2528o0);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return "";
    }

    public /* synthetic */ void e(View view) {
        r0.startActivity(a(), Fission5TixianListActivity.class);
        finish();
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        this.f2527n0 = (TxStepBean) extras.getSerializable("key_tx");
        if (this.f2527n0 == null) {
            showMessage(o.d(R.string.error_params));
            finish();
            return;
        }
        n();
        this.D.setText(o.d(R.string.txjl));
        this.B.setText("提现进度");
        this.D.setTextColor(o.b(R.color.color_ff403a));
        this.D.setVisibility(0);
        this.D.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.fission5.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2546s.e(view);
            }
        });
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.fission5_step_progress;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public UserPresenter obtainPresenter() {
        return null;
    }

    @OnClick({R.id.tv_yq})
    public void onViewClicked() {
        r0.startActivity(this.f2277w, Fission5InvaliUserActivity.class);
    }
}
