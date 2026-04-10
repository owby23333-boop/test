package com.amgcyo.cuttadon.fragment.books;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.main.MkMainActivity;
import com.amgcyo.cuttadon.activity.user.MkRequireActivity;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.widget.ui.SmoothCheckBox;
import com.fatcatfat.io.R;
import com.tencent.smtt.sdk.TbsListener;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class MkRequestBookFragment extends com.amgcyo.cuttadon.fragment.base.a<UserPresenter> implements View.OnTouchListener {
    private int G = 1;
    private String H;
    private String I;
    private String J;

    @BindView(R.id.book_author)
    EditText bookAuthor;

    @BindView(R.id.book_name)
    EditText bookName;

    @BindView(R.id.book_mian_name)
    EditText book_mian_name;

    @BindView(R.id.book_website)
    EditText book_website;

    @BindView(R.id.btn_request)
    Button btn_request;

    @BindView(R.id.container)
    ScrollView container;

    @BindView(R.id.ll_qiushu_type)
    LinearLayout ll_qiushu_type;

    @BindView(R.id.scb_comic3)
    SmoothCheckBox scb_comic3;

    @BindView(R.id.scb_novel1)
    SmoothCheckBox scb_novel1;

    @BindView(R.id.tv_comic3)
    TextView tv_comic3;

    @BindView(R.id.tv_desc)
    TextView tv_desc;

    @BindView(R.id.tv_notice)
    TextView tv_notice;

    @BindView(R.id.tv_novel1)
    TextView tv_novel1;

    class a extends ClickableSpan {
        a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            com.amgcyo.cuttadon.utils.otherutils.r0.c(((com.amgcyo.cuttadon.fragment.base.a) MkRequestBookFragment.this).f3725t, MkRequestBookFragment.this.G);
            com.amgcyo.cuttadon.utils.otherutils.x0.c().a("[QIUSHU]搜索");
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    @Override // me.jessyan.art.base.f.i
    public int a() {
        return R.layout.request_add_book_activity;
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        if (message.f21197s != 825 || getActivity() == null || getActivity().isFinishing() || this.bookName == null) {
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof MkMainActivity) {
            ((MkMainActivity) activity).selectedQiushuHistoryFragment();
        } else if (activity instanceof MkRequireActivity) {
            ((MkRequireActivity) activity).selectedHistoryFragment();
        }
        this.bookName.setText("");
        this.bookAuthor.setText("");
        this.book_website.setText("");
        this.book_mian_name.setText("");
    }

    @Override // me.jessyan.art.base.f.i
    @SuppressLint({"ClickableViewAccessibility"})
    public void initData(@Nullable Bundle bundle) {
        String str;
        if (com.amgcyo.cuttadon.utils.otherutils.g.j0()) {
            this.G = 1;
            str = "如果搜索 不到你想看的书籍，可以提交以下信息进行求书。";
        } else {
            str = "如果搜索 不到你想看的书籍或者漫画，可以提交以下信息进行求书。";
        }
        this.tv_notice.setSelected(true);
        SpannableString spannableString = new SpannableString(str);
        a aVar = new a();
        this.tv_novel1.setTextColor(com.amgcyo.cuttadon.f.o.b(R.color.colorPrimary));
        this.scb_novel1.setChecked(true);
        this.tv_comic3.setTextColor(com.amgcyo.cuttadon.f.o.b(R.color.text_33));
        this.scb_comic3.setChecked(false);
        this.scb_novel1.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.fragment.books.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f3822s.a(view);
            }
        });
        this.scb_comic3.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.fragment.books.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f3824s.b(view);
            }
        });
        Drawable drawable = getResources().getDrawable(R.drawable.search_small);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        spannableString.setSpan(new com.amgcyo.cuttadon.utils.otherutils.i(drawable), 4, 5, 1);
        spannableString.setSpan(aVar, 2, 5, 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.color_EC5C07)), 2, 5, 33);
        this.tv_desc.setText(spannableString);
        this.tv_desc.setMovementMethod(LinkMovementMethod.getInstance());
        this.container.setOnTouchListener(this);
        this.container.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.amgcyo.cuttadon.fragment.books.m0
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.f3823s.l();
            }
        });
        if (com.amgcyo.cuttadon.utils.otherutils.g.j0()) {
            this.ll_qiushu_type.setVisibility(8);
        } else {
            this.ll_qiushu_type.setVisibility(0);
        }
    }

    public /* synthetic */ void l() {
        Rect rect = new Rect();
        ((Activity) this.f3725t).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int height = ((Activity) this.f3725t).getWindow().getDecorView().getHeight();
        int bottom = (height - rect.bottom) - (height - this.btn_request.getBottom());
        if (bottom > 0) {
            this.container.scrollTo(0, bottom + TbsListener.ErrorCode.INFO_CODE_BASE);
        } else {
            this.container.scrollTo(0, 0);
        }
    }

    public void m() {
        if (TextUtils.isEmpty(this.J) || TextUtils.isEmpty(this.I) || TextUtils.isEmpty(this.H)) {
            showMessage("参数异常，请重新提交数据！");
        } else {
            obtainPresenter().q(Message.a(this, new Object[]{this.J, this.I, this.H, Integer.valueOf(this.G)}));
        }
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View currentFocus;
        if (view.getId() == R.id.container) {
            try {
                InputMethodManager inputMethodManager = (InputMethodManager) this.f3725t.getSystemService("input_method");
                if (inputMethodManager == null || this.f3725t == null || (currentFocus = ((Activity) this.f3725t).getCurrentFocus()) == null) {
                    return false;
                }
                return inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            } catch (Exception unused) {
            }
        }
        return false;
    }

    @OnClick({R.id.btn_request})
    public void onViewClicked() {
        if (com.amgcyo.cuttadon.fragment.base.a.n()) {
            return;
        }
        if (!me.jessyan.art.f.f.a(this.f3725t) || !me.jessyan.art.f.f.b(this.f3725t)) {
            showMessage("网络连接不可用，请检查网络设置！");
            return;
        }
        this.I = this.bookName.getText().toString();
        this.J = this.bookAuthor.getText().toString();
        String string = this.book_website.getText().toString();
        String string2 = this.book_mian_name.getText().toString();
        if (TextUtils.isEmpty(this.I)) {
            showMessage("请输入书名");
            a(this.bookName);
            return;
        }
        if (TextUtils.isEmpty(this.J)) {
            showMessage("请输入作者名");
            a(this.bookAuthor);
            return;
        }
        if (TextUtils.isEmpty(string)) {
            showMessage("请输入书籍原网址");
            a(this.book_website);
            return;
        }
        if (TextUtils.isEmpty(string2)) {
            showMessage("请输入小说主角名");
            a(this.book_mian_name);
            return;
        }
        this.H = "原网址:" + string + "\n主角名:" + string2;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (activity instanceof MkRequireActivity) {
                ((MkRequireActivity) activity).loadRewardVideoAd();
            } else if (activity instanceof MkMainActivity) {
                ((MkMainActivity) activity).loadRewardVideoAd();
            }
        }
    }

    public /* synthetic */ void a(View view) {
        this.tv_novel1.setTextColor(com.amgcyo.cuttadon.f.o.b(R.color.colorPrimary));
        this.scb_novel1.a(true, true);
        this.G = 1;
        this.scb_novel1.setEnabled(false);
        this.scb_comic3.setEnabled(true);
        this.tv_comic3.setTextColor(com.amgcyo.cuttadon.f.o.b(R.color.text_33));
        this.scb_comic3.a(false, false);
    }

    public /* synthetic */ void b(View view) {
        this.tv_novel1.setTextColor(com.amgcyo.cuttadon.f.o.b(R.color.text_33));
        this.scb_novel1.a(false, false);
        this.G = 3;
        this.scb_novel1.setEnabled(true);
        this.scb_comic3.setEnabled(false);
        this.tv_comic3.setTextColor(com.amgcyo.cuttadon.f.o.b(R.color.colorPrimary));
        this.scb_comic3.a(true, true);
    }

    @Override // me.jessyan.art.base.f.i
    @NonNull
    public UserPresenter obtainPresenter() {
        if (this.f3726u == 0) {
            this.f3726u = new UserPresenter(me.jessyan.art.f.e.a(this.f3725t));
        }
        return (UserPresenter) this.f3726u;
    }

    private void a(EditText editText) {
        if (editText != null) {
            editText.startAnimation(com.amgcyo.cuttadon.utils.otherutils.g.s(5));
            editText.setFocusable(true);
            editText.requestFocus();
        }
    }
}
