package com.amgcyo.cuttadon.view.otherview;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.amgcyo.cuttadon.utils.otherutils.x0;
import com.fatcatfat.io.R;

/* JADX INFO: compiled from: ShelfMenuPopWindow.java */
/* JADX INFO: loaded from: classes.dex */
public class n extends PopupWindow implements View.OnClickListener {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f5134s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private TextView f5135t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ImageView f5136u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private a f5137v;

    /* JADX INFO: compiled from: ShelfMenuPopWindow.java */
    public interface a {
        void b();

        void b(int i2);

        void c();

        void d();

        void e();
    }

    public n(Context context) {
        super(context);
        this.f5134s = context;
        c();
    }

    private void b() {
        double d2 = this.f5134s.getResources().getDisplayMetrics().widthPixels;
        Double.isNaN(d2);
        setWidth((int) (d2 * 0.4d));
        setHeight(-2);
        setFocusable(true);
        setAnimationStyle(R.style.pop_add);
        setOutsideTouchable(true);
        update();
        setBackgroundDrawable(new ColorDrawable(0));
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.amgcyo.cuttadon.view.otherview.f
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                this.f5108s.a();
            }
        });
    }

    private void c() {
        View viewInflate = LayoutInflater.from(this.f5134s).inflate(R.layout.shelf_popwindow, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ll_switchModel);
        LinearLayout linearLayout2 = (LinearLayout) viewInflate.findViewById(R.id.ll_bookManager);
        LinearLayout linearLayout3 = (LinearLayout) viewInflate.findViewById(R.id.ll_refresh);
        ((LinearLayout) viewInflate.findViewById(R.id.ll_book_clean)).setOnClickListener(this);
        LinearLayout linearLayout4 = (LinearLayout) viewInflate.findViewById(R.id.ll_backup);
        this.f5135t = (TextView) viewInflate.findViewById(R.id.tv_switchText);
        this.f5136u = (ImageView) viewInflate.findViewById(R.id.iv_switchImg);
        if (com.amgcyo.cuttadon.utils.otherutils.g.K() == 1) {
            this.f5135t.setText("列表模式");
            this.f5136u.setImageDrawable(this.f5134s.getResources().getDrawable(R.drawable.ic_pop_list));
        } else {
            this.f5135t.setText("封面模式");
            this.f5136u.setImageDrawable(this.f5134s.getResources().getDrawable(R.drawable.ic_pop_fm));
        }
        linearLayout.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);
        setContentView(viewInflate);
        b();
    }

    public void a(a aVar) {
        this.f5137v = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_backup /* 2131297901 */:
                this.f5137v.b();
                dismiss();
                break;
            case R.id.ll_bookManager /* 2131297906 */:
                this.f5137v.e();
                x0.c().a("[MENU]我要求书");
                dismiss();
                break;
            case R.id.ll_book_clean /* 2131297909 */:
                this.f5137v.c();
                dismiss();
                break;
            case R.id.ll_refresh /* 2131297960 */:
                this.f5137v.d();
                x0.c().a("[MENU]书架排序");
                dismiss();
                break;
            case R.id.ll_switchModel /* 2131297969 */:
                if (com.amgcyo.cuttadon.utils.otherutils.g.K() == 1) {
                    this.f5135t.setText("封面模式");
                    this.f5136u.setImageDrawable(this.f5134s.getResources().getDrawable(R.drawable.ic_pop_fm));
                    this.f5137v.b(0);
                    x0.c().a("[MENU]宫格模式");
                } else {
                    this.f5135t.setText("列表模式");
                    this.f5136u.setImageDrawable(this.f5134s.getResources().getDrawable(R.drawable.ic_pop_list));
                    this.f5137v.b(1);
                    x0.c().a("[MENU]列表模式");
                }
                dismiss();
                break;
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i2, int i3, int i4) {
        super.showAsDropDown(view, i2, i3, i4);
        a((Activity) this.f5134s, 0.7f);
    }

    public /* synthetic */ void a() {
        a((Activity) this.f5134s, 1.0f);
    }

    private void a(Activity activity, float f2) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.alpha = f2;
        activity.getWindow().addFlags(2);
        activity.getWindow().setAttributes(attributes);
    }
}
