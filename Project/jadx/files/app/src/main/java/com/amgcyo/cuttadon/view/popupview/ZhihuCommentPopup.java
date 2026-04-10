package com.amgcyo.cuttadon.view.popupview;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.view.comic.SimpleRatingBar;
import com.fatcatfat.io.R;
import com.lxj.xpopup.a;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.core.BottomPopupView;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class ZhihuCommentPopup extends BottomPopupView implements View.OnClickListener {
    private int O;
    private TextView P;
    private TextView Q;
    private SimpleRatingBar R;
    private EditText S;
    private int T;
    Context U;
    BasePopupView V;
    b W;

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ZhihuCommentPopup.this.Q.setText(String.format(Locale.getDefault(), "%d/%d", Integer.valueOf(ZhihuCommentPopup.this.S.length()), Integer.valueOf(ZhihuCommentPopup.this.O)));
            if (ZhihuCommentPopup.this.S.length() <= ZhihuCommentPopup.this.O) {
                ZhihuCommentPopup.this.Q.setTextColor(o.b(R.color.text_bottom_comment));
                return;
            }
            ZhihuCommentPopup.this.Q.setTextColor(o.b(R.color.dot_hong));
            ZhihuCommentPopup.this.S.setText(editable.toString().substring(0, ZhihuCommentPopup.this.O));
            ZhihuCommentPopup.this.S.setSelection(ZhihuCommentPopup.this.O);
            o.b("您最多能输入" + ZhihuCommentPopup.this.O + "个字符");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    public interface b {
        void a(int i2, String str);
    }

    public ZhihuCommentPopup(@NonNull Context context) {
        super(context);
        this.O = 200;
        this.T = 0;
        this.U = context;
    }

    private void setRbCommentData(float f2) {
        this.T = (int) f2;
        int i2 = this.T;
        if (i2 == 0) {
            this.P.setText("请评分");
            return;
        }
        if (i2 == 1) {
            this.P.setText("太差了");
            return;
        }
        if (i2 == 2) {
            this.P.setText("不太好");
            return;
        }
        if (i2 == 3) {
            this.P.setText("一般般");
        } else if (i2 == 4) {
            this.P.setText("还不错");
        } else {
            if (i2 != 5) {
                return;
            }
            this.P.setText("超精彩");
        }
    }

    private void x() {
        BasePopupView basePopupView = this.V;
        if (basePopupView != null) {
            basePopupView.u();
            return;
        }
        a.b bVar = new a.b(getContext());
        bVar.e(false);
        this.V = bVar.a((CharSequence) "提示", (CharSequence) "退出编辑后，\n内容将不会保存，是否退出？", (CharSequence) "取消", (CharSequence) "确定", new com.lxj.xpopup.c.c() { // from class: com.amgcyo.cuttadon.view.popupview.h
            @Override // com.lxj.xpopup.c.c
            public final void onConfirm() {
                this.a.g();
            }
        }, (com.lxj.xpopup.c.a) null, false).u();
    }

    @Override // com.lxj.xpopup.core.BottomPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        return R.layout.custom_bottom_comment_popup;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getMaxHeight() {
        return (int) (com.lxj.xpopup.util.b.a(getContext()) * 0.9f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.img_close) {
            if (this.S == null) {
                g();
            }
            if (TextUtils.isEmpty(this.S.getText().toString())) {
                g();
                return;
            } else {
                x();
                return;
            }
        }
        if (id != R.id.tv_submit) {
            return;
        }
        if (this.T <= 0) {
            o.b("请先评分");
            return;
        }
        if (this.W != null) {
            Context context = this.U;
            if (context != null && (context instanceof BaseTitleBarActivity)) {
                ((BaseTitleBarActivity) context).showLoading(o.d(R.string.submiting));
            }
            this.W.a(this.T, this.S.getText().toString());
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void r() {
        super.r();
        ImageView imageView = (ImageView) findViewById(R.id.img_close);
        TextView textView = (TextView) findViewById(R.id.tv_submit);
        this.R = (SimpleRatingBar) findViewById(R.id.rb_comment);
        this.P = (TextView) findViewById(R.id.tv_level);
        this.Q = (TextView) findViewById(R.id.tv_textNum);
        this.S = (EditText) findViewById(R.id.et_input);
        imageView.setOnClickListener(this);
        textView.setOnClickListener(this);
        this.R.setOnRatingBarChangeListener(new SimpleRatingBar.b() { // from class: com.amgcyo.cuttadon.view.popupview.g
            @Override // com.amgcyo.cuttadon.view.comic.SimpleRatingBar.b
            public final void a(SimpleRatingBar simpleRatingBar, float f2, boolean z2) {
                this.a.a(simpleRatingBar, f2, z2);
            }
        });
        com.lxj.xpopup.a.a(getResources().getColor(R.color.colorPrimary));
        this.Q.setText(String.format(Locale.getDefault(), "0/%d", Integer.valueOf(this.O)));
        this.S.addTextChangedListener(new a());
        this.R.setRating(this.T);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void s() {
    }

    public void setListener(b bVar) {
        this.W = bVar;
    }

    public void setScore(int i2) {
        this.T = i2;
        SimpleRatingBar simpleRatingBar = this.R;
        if (simpleRatingBar != null) {
            simpleRatingBar.setRating(i2);
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void t() {
        super.t();
    }

    public /* synthetic */ void a(SimpleRatingBar simpleRatingBar, float f2, boolean z2) {
        if (z2) {
            setRbCommentData(f2);
        }
    }
}
