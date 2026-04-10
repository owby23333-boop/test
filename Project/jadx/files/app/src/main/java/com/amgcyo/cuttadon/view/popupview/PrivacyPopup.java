package com.amgcyo.cuttadon.view.popupview;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.f.o;
import com.fatcatfat.io.R;
import com.lxj.xpopup.core.CenterPopupView;

/* JADX INFO: loaded from: classes.dex */
public class PrivacyPopup extends CenterPopupView {
    private Context R;
    private TextView S;
    private TextView T;
    private TextView U;
    private com.amgcyo.cuttadon.g.e V;

    public PrivacyPopup(@NonNull Context context) {
        super(context);
        this.R = context;
    }

    private void y() {
        this.U.setText("退出应用");
        this.U.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.popupview.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f5181s.b(view);
            }
        });
        String strD = o.d(R.string.app_name);
        this.S.setText(Html.fromHtml("\u3000\u3000根据相关法律规定，请您同意" + strD + "<a href='" + com.amgcyo.cuttadon.utils.otherutils.g.C() + "'>《隐私政策》</a>和<a href='" + com.amgcyo.cuttadon.utils.otherutils.g.b0() + "'>《用户协议》</a>后再开始使用我们的应用服务。"));
        this.S.setMovementMethod(new com.amgcyo.cuttadon.view.otherview.o(this.R, false));
        o.a(this.S);
        Animation animationA = com.amgcyo.cuttadon.j.g.a.a(5);
        this.S.setAnimation(animationA);
        this.S.startAnimation(animationA);
    }

    public /* synthetic */ void b(View view) {
        com.amgcyo.cuttadon.g.e eVar = this.V;
        if (eVar != null) {
            eVar.a();
            g();
        }
    }

    public /* synthetic */ void c(View view) {
        y();
    }

    public /* synthetic */ void d(View view) {
        com.amgcyo.cuttadon.g.e eVar = this.V;
        if (eVar != null) {
            eVar.b();
            g();
        }
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        return R.layout.popup_privacy;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void r() {
        super.r();
        this.S = (TextView) findViewById(R.id.tv_privacy);
        this.T = (TextView) findViewById(R.id.tv_bottom_tips);
        TextView textView = (TextView) findViewById(R.id.agree);
        this.U = (TextView) findViewById(R.id.not_agree);
        if (com.amgcyo.cuttadon.utils.otherutils.g.o0()) {
            textView.setText(o.d(R.string.agree_xiaomi));
            this.U.setText(o.d(R.string.not_agree_xiaomi));
        }
        this.T.setText(String.format("*若选择%s，我们将无法为您提供看书服务*", this.U.getText()));
        this.U.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.popupview.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f5180s.c(view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.popupview.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f5182s.d(view);
            }
        });
        String strD = o.d(R.string.app_name);
        this.S.setText(Html.fromHtml("欢迎使用" + strD + "！<br/>在您使用" + strD + "前,请您认真阅读并了解完整版<a href='" + com.amgcyo.cuttadon.utils.otherutils.g.C() + "'>隐私政策</a>与<a href='" + com.amgcyo.cuttadon.utils.otherutils.g.b0() + "'>用户协议</a>条款。<br/>1、 为更好的提供注册认证、浏览内容等相关服务，我们会根据您使用服务的具体功能需要，收集必须的用户信息；<br/>2、 未经您同意，我们不会从第三方获取、共享或对外提供您的信息（法律法规规定除外）。"));
        this.S.setMovementMethod(new com.amgcyo.cuttadon.view.otherview.o(this.R, false));
        o.a(this.S);
    }

    public void setListener(com.amgcyo.cuttadon.g.e eVar) {
        this.V = eVar;
    }
}
