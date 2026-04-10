package com.amgcyo.cuttadon.view.popupview;

import android.content.Context;
import android.graphics.Color;
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
public class BindMasterCodeResultPopup extends CenterPopupView implements View.OnClickListener {
    CommonShapeButton R;
    TextView S;
    ImageView T;
    String U;
    private a V;

    public interface a {
        void finishActivity();

        void invaliUser();
    }

    public BindMasterCodeResultPopup(@NonNull Context context, String str) {
        super(context);
        this.U = str;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void g() {
        super.g();
        a aVar = this.V;
        if (aVar != null) {
            aVar.finishActivity();
        }
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        return R.layout.popup_mastercoderesult;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getMaxWidth() {
        return n.c(MkApplication.getAppContext());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        int id = view.getId();
        if (id == R.id.iv_close) {
            g();
        } else {
            if (id != R.id.tv_task_action) {
                return;
            }
            if (this.U != null && (aVar = this.V) != null) {
                aVar.invaliUser();
            }
            g();
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void r() {
        super.r();
        this.R = (CommonShapeButton) findViewById(R.id.tv_task_action);
        this.T = (ImageView) findViewById(R.id.iv_close);
        this.S = (TextView) findViewById(R.id.tv_tips);
        this.T.setOnClickListener(this);
        this.R.setOnClickListener(this);
        if (TextUtils.isEmpty(this.U)) {
            return;
        }
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#F3B324"));
        String str = this.U + "现金红包已入账";
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(foregroundColorSpan, 0, this.U.length(), 17);
        spannableString.setSpan(new ForegroundColorSpan(o.b(R.color.color_0B0B0B)), this.U.length(), str.length(), 17);
        this.S.setText(spannableString);
    }

    public void setListener(a aVar) {
        this.V = aVar;
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
