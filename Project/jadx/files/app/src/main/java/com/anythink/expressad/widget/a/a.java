package com.anythink.expressad.widget.a;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.v;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends Dialog {
    private static final String a = "ATAlertDialog";
    private b b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f12283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f12284d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Button f12285e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Button f12286f;

    public a(Context context, final b bVar) {
        super(context);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        requestWindowFeature(1);
        View viewInflate = LayoutInflater.from(context).inflate(i.a(context, "anythink_cm_alertview", "layout"), (ViewGroup) null);
        this.b = bVar;
        if (viewInflate != null) {
            setContentView(viewInflate);
            try {
                this.f12283c = (TextView) viewInflate.findViewById(i.a(context, "anythink_video_common_alertview_titleview", "id"));
            } catch (Exception e2) {
                o.a(a, e2.getMessage());
            }
            try {
                this.f12284d = (TextView) viewInflate.findViewById(i.a(context, "anythink_video_common_alertview_contentview", "id"));
                this.f12285e = (Button) viewInflate.findViewById(i.a(context, "anythink_video_common_alertview_confirm_button", "id"));
                this.f12286f = (Button) viewInflate.findViewById(i.a(context, "anythink_video_common_alertview_cancel_button", "id"));
            } catch (Exception e3) {
                o.a(a, e3.getMessage());
            }
        }
        Button button = this.f12286f;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.widget.a.a.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a();
                    }
                    a.this.cancel();
                    a.this.a();
                }
            });
        }
        Button button2 = this.f12285e;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.widget.a.a.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.b();
                    }
                    a.this.cancel();
                    a.this.a();
                }
            });
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    private void b(String str) {
        TextView textView = this.f12284d;
        if (textView != null) {
            textView.setText(str);
        }
    }

    private void c(String str) {
        Button button = this.f12285e;
        if (button != null) {
            button.setText(str);
        }
    }

    private void d(String str) {
        Button button = this.f12286f;
        if (button != null) {
            button.setText(str);
        }
    }

    private void e() {
        String language = Locale.getDefault().getLanguage();
        if (TextUtils.isEmpty(language) || !language.equals(com.anythink.expressad.video.dynview.a.a.V)) {
            a("Confirm to close? ");
            b("You will not be rewarded after closing the window");
            c("Close it");
            d("Continue");
            return;
        }
        a("确认关闭？");
        b("关闭后您将不会获得任何奖励噢~ ");
        c("确认关闭");
        d("继续试玩");
    }

    public final void a() {
        if (this.b != null) {
            this.b = null;
        }
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

    private void a(String str) {
        TextView textView = this.f12283c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    private void c() {
        String language = Locale.getDefault().getLanguage();
        if (!TextUtils.isEmpty(language) && language.equals(com.anythink.expressad.video.dynview.a.a.V)) {
            a("确认关闭？");
            b("关闭后您将不会获得任何奖励噢~ ");
            c("确认关闭");
            d("继续观看");
            return;
        }
        a("Confirm to close? ");
        b("You will not be rewarded after closing the window");
        c("Close it");
        d("Continue");
    }

    private void d() {
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.foundation.b.a.b().e();
        com.anythink.expressad.d.a aVarB = com.anythink.expressad.d.b.b();
        if (aVarB != null) {
            a(aVarB.C(), aVarB.D(), aVarB.E(), aVarB.F());
            return;
        }
        String language = Locale.getDefault().getLanguage();
        if (!TextUtils.isEmpty(language) && language.equals(com.anythink.expressad.video.dynview.a.a.V)) {
            a("确认关闭？");
            b("关闭后您将不会获得任何奖励噢~ ");
            c("确认关闭");
            d("继续试玩");
            return;
        }
        a("Confirm to close? ");
        b("You will not be rewarded after closing the window");
        c("Close it");
        d("Continue");
    }

    public final void b() {
        try {
            String language = Locale.getDefault().getLanguage();
            if (!TextUtils.isEmpty(language) && language.equals(com.anythink.expressad.video.dynview.a.a.V)) {
                a("确认关闭？");
                b("关闭后您将不会获得任何奖励噢~ ");
                c("确认关闭");
                d("继续观看");
                return;
            }
            a("Confirm to close? ");
            b("You will not be rewarded after closing the window");
            c("Close it");
            d("Continue");
        } catch (Exception e2) {
            o.a(a, e2.getMessage());
        }
    }

    private void a(String str, String str2, String str3, String str4) {
        a(str);
        b(str2);
        c(str3);
        d(str4);
    }

    private void a(int i2) {
        String language = Locale.getDefault().getLanguage();
        if (!TextUtils.isEmpty(language) && language.equals(com.anythink.expressad.video.dynview.a.a.V)) {
            a(i2 == com.anythink.expressad.foundation.g.a.cr ? "确认关闭？" : "提示");
            b(i2 == com.anythink.expressad.foundation.g.a.cr ? "如果你选择继续，结束后将会获得奖励。确认关闭吗？" : "如果你选择继续，结束后将会获得奖励。是否继续？");
            c(i2 == com.anythink.expressad.foundation.g.a.cr ? "确认关闭" : "取消");
            d("继续");
            return;
        }
        a(i2 == com.anythink.expressad.foundation.g.a.cr ? "Confirm" : "Tips");
        b(i2 == com.anythink.expressad.foundation.g.a.cr ? "If you choose to continue, you will receive a reward after the end. Confirm closed?" : "If you choose to continue, you will receive a reward after the end. Whether to continue?");
        c(i2 == com.anythink.expressad.foundation.g.a.cr ? "Close" : "Cancel");
        d("Continue");
    }

    public final void a(int i2, String str) {
        try {
            String string = v.b(getContext(), "Anythink_ConfirmTitle".concat(String.valueOf(str)), "").toString();
            String string2 = v.b(getContext(), "Anythink_ConfirmContent".concat(String.valueOf(str)), "").toString();
            String string3 = v.b(getContext(), "Anythink_CancelText".concat(String.valueOf(str)), "").toString();
            String string4 = v.b(getContext(), "Anythink_ConfirmText".concat(String.valueOf(str)), "").toString();
            if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3) && TextUtils.isEmpty(string4)) {
                String language = Locale.getDefault().getLanguage();
                if (!TextUtils.isEmpty(language) && language.equals(com.anythink.expressad.video.dynview.a.a.V)) {
                    a(i2 == com.anythink.expressad.foundation.g.a.cr ? "确认关闭？" : "提示");
                    b(i2 == com.anythink.expressad.foundation.g.a.cr ? "如果你选择继续，结束后将会获得奖励。确认关闭吗？" : "如果你选择继续，结束后将会获得奖励。是否继续？");
                    c(i2 == com.anythink.expressad.foundation.g.a.cr ? "确认关闭" : "取消");
                    d("继续");
                    return;
                }
                a(i2 == com.anythink.expressad.foundation.g.a.cr ? "Confirm" : "Tips");
                b(i2 == com.anythink.expressad.foundation.g.a.cr ? "If you choose to continue, you will receive a reward after the end. Confirm closed?" : "If you choose to continue, you will receive a reward after the end. Whether to continue?");
                c(i2 == com.anythink.expressad.foundation.g.a.cr ? "Close" : "Cancel");
                d("Continue");
                return;
            }
            a(string, string2, string3, string4);
        } catch (Exception e2) {
            o.a(a, e2.getMessage());
        }
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
}
