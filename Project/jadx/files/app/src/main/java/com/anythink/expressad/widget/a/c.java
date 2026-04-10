package com.anythink.expressad.widget.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends Dialog {
    private static final String a = "ATFeedBackDialog";
    private b b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f12287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LinearLayout f12288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Button f12289e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Button f12290f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f12291g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f12292h;

    /* JADX INFO: renamed from: com.anythink.expressad.widget.a.c$1, reason: invalid class name */
    final class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (c.this.b != null) {
                c.this.b.a();
            }
            c.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.widget.a.c$2, reason: invalid class name */
    final class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (c.this.b != null) {
                c.this.b.b();
            }
            c.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.widget.a.c$3, reason: invalid class name */
    final class AnonymousClass3 implements DialogInterface.OnCancelListener {
        AnonymousClass3() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            if (c.this.b != null) {
                c.this.b.b();
            }
        }
    }

    public c(Context context, b bVar) {
        super(context);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        requestWindowFeature(1);
        View viewInflate = LayoutInflater.from(context).inflate(i.a(context, "anythink_cm_feedbackview", "layout"), (ViewGroup) null);
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        if (getContext().getResources().getConfiguration().orientation == 1) {
            this.f12292h = displayMetrics.widthPixels;
            this.f12291g = displayMetrics.heightPixels;
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = (int) (this.f12291g * 0.8f);
            attributes.gravity = 80;
            getWindow().setAttributes(attributes);
        } else {
            this.f12292h = displayMetrics.heightPixels;
            this.f12291g = displayMetrics.widthPixels;
            WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
            attributes2.width = (int) (this.f12291g * 0.5f);
            attributes2.height = -1;
            attributes2.gravity = 17;
            getWindow().setAttributes(attributes2);
        }
        this.b = bVar;
        if (viewInflate != null) {
            setContentView(viewInflate);
            try {
                this.f12287c = (TextView) viewInflate.findViewById(i.a(context, "anythink_video_common_alertview_titleview", "id"));
            } catch (Exception e2) {
                o.a(a, e2.getMessage());
            }
            try {
                this.f12288d = (LinearLayout) viewInflate.findViewById(i.a(context, "anythink_video_common_alertview_contentview", "id"));
                this.f12289e = (Button) viewInflate.findViewById(i.a(context, "anythink_video_common_alertview_confirm_button", "id"));
                this.f12290f = (Button) viewInflate.findViewById(i.a(context, "anythink_video_common_alertview_cancel_button", "id"));
            } catch (Exception e3) {
                o.a(a, e3.getMessage());
            }
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        Button button = this.f12290f;
        if (button != null) {
            button.setOnClickListener(new AnonymousClass1());
        }
        Button button2 = this.f12289e;
        if (button2 != null) {
            button2.setOnClickListener(new AnonymousClass2());
        }
        setOnCancelListener(new AnonymousClass3());
    }

    private void b() {
        if (this.b != null) {
            this.b = null;
        }
    }

    private b c() {
        return this.b;
    }

    private void d() {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        if (!(getContext().getResources().getConfiguration().orientation == 1)) {
            this.f12292h = displayMetrics.heightPixels;
            this.f12291g = displayMetrics.widthPixels;
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = (int) (this.f12291g * 0.5f);
            attributes.height = -1;
            attributes.gravity = 17;
            getWindow().setAttributes(attributes);
            return;
        }
        this.f12292h = displayMetrics.widthPixels;
        this.f12291g = displayMetrics.heightPixels;
        WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
        attributes2.width = -1;
        attributes2.height = (int) (this.f12291g * 0.8f);
        attributes2.gravity = 80;
        getWindow().setAttributes(attributes2);
    }

    @Override // android.app.Dialog
    public final void show() {
        super.show();
        try {
            getWindow().setFlags(8, 8);
            super.show();
            Window window = getWindow();
            if (window != null) {
                window.setFlags(1024, 1024);
                if (Build.VERSION.SDK_INT >= 19) {
                    window.addFlags(DownloadExpSwitchCode.BACK_BUGFIX_SIGBUS);
                    window.getDecorView().setSystemUiVisibility(4098);
                } else {
                    window.getDecorView().setSystemUiVisibility(2);
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.layoutInDisplayCutoutMode = 1;
                    window.setAttributes(attributes);
                }
                window.setBackgroundDrawable(new ColorDrawable(0));
                window.setLayout(-1, -1);
                window.setGravity(17);
            }
            getWindow().clearFlags(8);
        } catch (Exception e2) {
            o.d(a, e2.getMessage());
            super.show();
        }
    }

    private void a() {
        Button button = this.f12290f;
        if (button != null) {
            button.setOnClickListener(new AnonymousClass1());
        }
        Button button2 = this.f12289e;
        if (button2 != null) {
            button2.setOnClickListener(new AnonymousClass2());
        }
        setOnCancelListener(new AnonymousClass3());
    }

    public final void c(String str) {
        Button button = this.f12290f;
        if (button != null) {
            button.setText(str);
        }
    }

    public final void b(String str) {
        Button button = this.f12289e;
        if (button != null) {
            button.setText(str);
        }
    }

    public final void a(boolean z2) {
        Button button = this.f12290f;
        if (button != null) {
            button.setClickable(z2);
        }
    }

    public final void a(b bVar) {
        this.b = bVar;
    }

    public final void a(String str) {
        TextView textView = this.f12287c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final void a(ViewGroup viewGroup) {
        LinearLayout linearLayout = this.f12288d;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(viewGroup);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = t.b(n.a().g(), 38.0f);
            layoutParams.rightMargin = t.b(n.a().g(), 38.0f);
            layoutParams.topMargin = t.b(n.a().g(), 20.0f);
            layoutParams.bottomMargin = t.b(n.a().g(), 24.0f);
            this.f12288d.addView(viewGroup, layoutParams);
        }
    }

    private void a(String str, ViewGroup viewGroup, String str2, String str3) {
        a(str);
        a(viewGroup);
        b(str2);
        c(str3);
    }

    private static void a(Window window) {
        if (window != null) {
            window.setFlags(1024, 1024);
            if (Build.VERSION.SDK_INT >= 19) {
                window.addFlags(DownloadExpSwitchCode.BACK_BUGFIX_SIGBUS);
                window.getDecorView().setSystemUiVisibility(4098);
            } else {
                window.getDecorView().setSystemUiVisibility(2);
            }
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
            }
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -1);
            window.setGravity(17);
        }
    }

    private static boolean a(Context context) {
        return context.getResources().getConfiguration().orientation == 1;
    }
}
