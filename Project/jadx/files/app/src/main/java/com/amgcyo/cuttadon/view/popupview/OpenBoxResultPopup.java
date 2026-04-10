package com.amgcyo.cuttadon.view.popupview;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.api.entity.fission5.OpenBoxBean;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.amgcyo.cuttadon.view.numbertextview.NumberRunningTextView;
import com.fatcatfat.io.R;
import com.lxj.xpopup.core.CenterPopupView;

/* JADX INFO: loaded from: classes.dex */
public class OpenBoxResultPopup extends CenterPopupView implements View.OnClickListener {
    NumberRunningTextView R;
    TextView S;
    Button T;
    ImageView U;
    OpenBoxBean V;
    private a W;

    public interface a {
        void a(int i2);
    }

    public OpenBoxResultPopup(@NonNull Context context, OpenBoxBean openBoxBean) {
        super(context);
        this.V = openBoxBean;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        return R.layout.popup_boxresult;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getMaxWidth() {
        return n.c(MkApplication.getAppContext());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        int id = view.getId();
        if (id != R.id.btn_video) {
            if (id != R.id.iv_close) {
                return;
            }
            g();
        } else {
            OpenBoxBean openBoxBean = this.V;
            if (openBoxBean != null && openBoxBean.getVideo_amount() > 0 && (aVar = this.W) != null) {
                aVar.a(this.V.getLog_id());
            }
            g();
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void r() {
        super.r();
        this.R = (NumberRunningTextView) findViewById(R.id.tv_money);
        this.T = (Button) findViewById(R.id.btn_video);
        this.U = (ImageView) findViewById(R.id.iv_close);
        this.S = (TextView) findViewById(R.id.tv_tips);
        this.U.setOnClickListener(this);
        this.T.setOnClickListener(this);
        OpenBoxBean openBoxBean = this.V;
        if (openBoxBean != null) {
            this.S.setText(openBoxBean.getLog_tips());
            this.R.setContent(String.valueOf(this.V.getBalance_gold()));
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#3F2000"));
            ViewGroup.LayoutParams layoutParams = this.T.getLayoutParams();
            if (this.V.getVideo_amount() <= 0) {
                SpannableString spannableString = new SpannableString("我知道了");
                layoutParams.height = -2;
                layoutParams.width = getResources().getDimensionPixelOffset(R.dimen.dimen150dp);
                this.T.setLayoutParams(layoutParams);
                spannableString.setSpan(foregroundColorSpan, 0, 4, 17);
                spannableString.setSpan(new RelativeSizeSpan(1.2f), 0, 4, 33);
                this.T.setText(spannableString);
                return;
            }
            layoutParams.width = -2;
            layoutParams.height = getResources().getDimensionPixelOffset(R.dimen.dimen58dp);
            this.T.setLayoutParams(layoutParams);
            String str = "看视频领取最高" + this.V.getVideo_amount() + "金币";
            SpannableString spannableString2 = new SpannableString(str);
            spannableString2.setSpan(foregroundColorSpan, 0, 5, 17);
            spannableString2.setSpan(new RelativeSizeSpan(1.2f), 0, 5, 33);
            int length = str.length();
            spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#FF383C")), 5, length, 17);
            spannableString2.setSpan(new StyleSpan(1), 5, length, 33);
            spannableString2.setSpan(new RelativeSizeSpan(1.4f), 5, length, 17);
            this.T.setText(spannableString2);
        }
    }

    public void setListener(a aVar) {
        this.W = aVar;
    }

    public void setMsg(String str) {
        NumberRunningTextView numberRunningTextView = this.R;
        if (numberRunningTextView != null) {
            numberRunningTextView.setText(str);
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void t() {
        super.t();
    }
}
