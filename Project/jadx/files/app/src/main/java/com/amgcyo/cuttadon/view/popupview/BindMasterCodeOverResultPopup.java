package com.amgcyo.cuttadon.view.popupview;

import android.content.Context;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.amgcyo.cuttadon.view.otherview.CommonShapeButton;
import com.fatcatfat.io.R;
import com.lxj.xpopup.core.CenterPopupView;

/* JADX INFO: loaded from: classes.dex */
public class BindMasterCodeOverResultPopup extends CenterPopupView implements View.OnClickListener {
    CommonShapeButton R;
    TextView S;
    TextView T;
    ImageView U;
    String V;
    private String W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private Context f5138a0;

    public BindMasterCodeOverResultPopup(@NonNull Context context, String str, String str2) {
        super(context);
        this.V = str;
        this.W = str2;
        this.f5138a0 = context;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        return R.layout.popup_mastercoder_overtime_esult;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getMaxWidth() {
        return n.c(MkApplication.getAppContext());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_close || id == R.id.tv_task_action) {
            g();
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void r() {
        super.r();
        this.R = (CommonShapeButton) findViewById(R.id.tv_task_action);
        this.U = (ImageView) findViewById(R.id.iv_close);
        this.S = (TextView) findViewById(R.id.tv_tips);
        this.T = (TextView) findViewById(R.id.tv_desc);
        this.U.setOnClickListener(this);
        this.R.setOnClickListener(this);
        if (TextUtils.isEmpty(this.V)) {
            return;
        }
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(o.b(R.color.color_0B0B0B));
        String str = "恭喜您获得" + this.V;
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(foregroundColorSpan, 0, 4, 17);
        spannableString.setSpan(new ForegroundColorSpan(o.b(R.color.color_1A84EE)), 5, str.length(), 17);
        this.S.setText(spannableString);
        this.T.setText(Html.fromHtml("只有新用户可以填写邀请码哦~<br/>在此补偿您" + this.V + "，详细规则可查看<a href='" + this.W + "'>《邀请规则》</a> "));
        this.T.setMovementMethod(new com.amgcyo.cuttadon.view.otherview.o(this.f5138a0, false));
        o.a(this.T);
    }

    public void setMsg(String str) {
        CommonShapeButton commonShapeButton = this.R;
        if (commonShapeButton != null) {
            commonShapeButton.setText(str);
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void t() {
        super.t();
    }
}
