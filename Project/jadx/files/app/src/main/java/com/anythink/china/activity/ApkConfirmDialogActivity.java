package com.anythink.china.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.i;
import com.anythink.core.common.f.a;
import com.anythink.core.common.k.h;
import com.anythink.core.common.k.l;
import com.anythink.core.common.k.u;
import com.anythink.core.common.res.b;
import com.anythink.core.common.res.e;
import com.anythink.core.common.ui.component.RoundImageView;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* JADX INFO: loaded from: classes2.dex */
public class ApkConfirmDialogActivity extends Activity {
    public static i a;
    private static a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Dialog f6348c;

    /* JADX INFO: renamed from: com.anythink.china.activity.ApkConfirmDialogActivity$2, reason: invalid class name */
    final class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.china.activity.ApkConfirmDialogActivity.2.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (ApkConfirmDialogActivity.b != null) {
                        ApkConfirmDialogActivity.b.a(false);
                    }
                }
            });
            ApkConfirmDialogActivity.this.finish();
        }
    }

    /* JADX INFO: renamed from: com.anythink.china.activity.ApkConfirmDialogActivity$3, reason: invalid class name */
    final class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.china.activity.ApkConfirmDialogActivity.3.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (ApkConfirmDialogActivity.b != null) {
                        ApkConfirmDialogActivity.b.a(true);
                    }
                }
            });
            ApkConfirmDialogActivity.this.finish();
        }
    }

    /* JADX INFO: renamed from: com.anythink.china.activity.ApkConfirmDialogActivity$4, reason: invalid class name */
    final class AnonymousClass4 implements b.a {
        final /* synthetic */ String a;
        final /* synthetic */ RoundImageView b;

        AnonymousClass4(String str, RoundImageView roundImageView) {
            this.a = str;
            this.b = roundImageView;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            if (TextUtils.equals(str, this.a)) {
                this.b.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.china.activity.ApkConfirmDialogActivity$5, reason: invalid class name */
    final class AnonymousClass5 implements View.OnClickListener {
        final /* synthetic */ i a;

        AnonymousClass5(i iVar) {
            this.a = iVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            l.b(ApkConfirmDialogActivity.this, this.a.I());
        }
    }

    /* JADX INFO: renamed from: com.anythink.china.activity.ApkConfirmDialogActivity$6, reason: invalid class name */
    final class AnonymousClass6 implements View.OnClickListener {
        final /* synthetic */ i a;

        AnonymousClass6(i iVar) {
            this.a = iVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            l.b(ApkConfirmDialogActivity.this, this.a.H());
        }
    }

    /* JADX INFO: renamed from: com.anythink.china.activity.ApkConfirmDialogActivity$7, reason: invalid class name */
    final class AnonymousClass7 implements View.OnClickListener {
        AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.china.activity.ApkConfirmDialogActivity.7.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (ApkConfirmDialogActivity.b != null) {
                        ApkConfirmDialogActivity.b.a(true);
                    }
                }
            });
            ApkConfirmDialogActivity.this.finish();
        }
    }

    /* JADX INFO: renamed from: com.anythink.china.activity.ApkConfirmDialogActivity$8, reason: invalid class name */
    final class AnonymousClass8 implements View.OnClickListener {
        AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.china.activity.ApkConfirmDialogActivity.8.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (ApkConfirmDialogActivity.b != null) {
                        ApkConfirmDialogActivity.b.a(false);
                    }
                }
            });
            ApkConfirmDialogActivity.this.finish();
        }
    }

    private void b() {
        try {
            String strAa = a instanceof aa ? ((aa) a).aa() : "";
            if (TextUtils.isEmpty(strAa)) {
                strAa = a.r();
            }
            View viewInflate = LayoutInflater.from(this).inflate(h.a(this, "myoffer_confirm_dialog", "layout"), (ViewGroup) null, false);
            TextView textView = (TextView) viewInflate.findViewById(h.a(this, "myoffer_confirm_msg", "id"));
            TextView textView2 = (TextView) viewInflate.findViewById(h.a(this, "myoffer_confirm_give_up", "id"));
            TextView textView3 = (TextView) viewInflate.findViewById(h.a(this, "myoffer_confirm_continue", "id"));
            textView.setText("立即下载\"" + strAa + "\"?");
            textView2.setText("取 消");
            textView3.setText("确 定");
            textView2.setOnClickListener(new AnonymousClass2());
            textView3.setOnClickListener(new AnonymousClass3());
            this.f6348c = new Dialog(this, h.a(this, "style_full_screen_translucent_dialog", com.anythink.expressad.foundation.h.i.f10647e));
            this.f6348c.setContentView(viewInflate);
            this.f6348c.setCancelable(false);
            this.f6348c.show();
        } catch (Throwable unused) {
            finish();
        }
    }

    private void c() {
        TextView textView;
        View view;
        TextView textView2;
        try {
            i iVar = a;
            View viewInflate = LayoutInflater.from(this).inflate(h.a(this, "confirm", "layout"), (ViewGroup) null, false);
            RoundImageView roundImageView = (RoundImageView) viewInflate.findViewById(h.a(this, "confirm_dialog_icon", "id"));
            TextView textView3 = (TextView) viewInflate.findViewById(h.a(this, "confirm_dialog_title", "id"));
            TextView textView4 = (TextView) viewInflate.findViewById(h.a(this, "confirm_dialog_version_name", "id"));
            TextView textView5 = (TextView) viewInflate.findViewById(h.a(this, "confirm_dialog_publisher_name", "id"));
            TextView textView6 = (TextView) viewInflate.findViewById(h.a(this, "confirm_dialog_permission_manage", "id"));
            TextView textView7 = (TextView) viewInflate.findViewById(h.a(this, "confirm_dialog_privacy_agreement", "id"));
            TextView textView8 = (TextView) viewInflate.findViewById(h.a(this, "confirm_dialog_download_now", "id"));
            TextView textView9 = (TextView) viewInflate.findViewById(h.a(this, "confirm_dialog_give_up", "id"));
            String strT = iVar.t();
            if (TextUtils.isEmpty(strT)) {
                textView = textView9;
                view = viewInflate;
                textView2 = textView8;
                ViewGroup.LayoutParams layoutParams = roundImageView.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.height = 0;
                roundImageView.setLayoutParams(layoutParams);
            } else {
                roundImageView.setNeedRadiu(true);
                roundImageView.setRadiusInDip(4);
                ViewGroup.LayoutParams layoutParams2 = roundImageView.getLayoutParams();
                view = viewInflate;
                textView = textView9;
                textView2 = textView8;
                b.a(this).a(new e(1, strT), layoutParams2.width, layoutParams2.height, new AnonymousClass4(strT, roundImageView));
            }
            String strAa = iVar instanceof aa ? ((aa) iVar).aa() : "";
            if (TextUtils.isEmpty(strAa)) {
                strAa = iVar.r();
            }
            textView3.setText(strAa);
            textView4.setText(getResources().getString(h.a(this, "confirm_dialog_version", com.anythink.expressad.foundation.h.i.f10649g), iVar.G()));
            textView5.setText(getResources().getString(h.a(this, "confirm_dialog_publisher", com.anythink.expressad.foundation.h.i.f10649g), iVar.F()));
            String string = getResources().getString(h.a(this, "confirm_dialog_privacy_agreement", com.anythink.expressad.foundation.h.i.f10649g));
            String string2 = getResources().getString(h.a(this, "confirm_dialog_application_permission", com.anythink.expressad.foundation.h.i.f10649g));
            int length = string.length();
            int length2 = string2.length();
            if (length != length2) {
                int iAbs = Math.abs(length2 - length);
                StringBuilder sb = new StringBuilder(string);
                for (int i2 = 0; i2 < iAbs; i2++) {
                    sb.append(" ");
                }
                string = sb.toString();
            }
            textView7.setText(string);
            textView6.setOnClickListener(new AnonymousClass5(iVar));
            textView7.setOnClickListener(new AnonymousClass6(iVar));
            textView2.setOnClickListener(new AnonymousClass7());
            textView.setOnClickListener(new AnonymousClass8());
            this.f6348c = new Dialog(this, h.a(this, "style_full_screen_translucent_dialog", com.anythink.expressad.foundation.h.i.f10647e));
            this.f6348c.setContentView(view);
            this.f6348c.setCancelable(false);
            Window window = this.f6348c.getWindow();
            if (window != null) {
                int dimensionPixelSize = getResources().getDimensionPixelSize(h.a(this, "confirm_dialog_margin", "dimen"));
                int i3 = getResources().getDisplayMetrics().widthPixels;
                int i4 = getResources().getDisplayMetrics().heightPixels;
                if (i3 > i4) {
                    window.setLayout((int) Math.ceil(r4 * 0.98859316f), i4 - (dimensionPixelSize * 2));
                } else {
                    window.setLayout(i3 - (dimensionPixelSize * 2), (int) Math.ceil(r3 / 0.98859316f));
                }
            }
            this.f6348c.show();
        } catch (Throwable unused) {
            finish();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r23) {
        /*
            Method dump skipped, instruction units count: 765
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.china.activity.ApkConfirmDialogActivity.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        u.a(false);
        Dialog dialog = this.f6348c;
        if (dialog != null) {
            dialog.dismiss();
            this.f6348c = null;
        }
        a = null;
        b = null;
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (4 == i2) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        u.a(true);
    }

    public static void a(final Context context, final i iVar, final a aVar) {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.china.activity.ApkConfirmDialogActivity.1
            @Override // java.lang.Runnable
            public final void run() {
                if (com.anythink.china.common.a.a(context).a(iVar)) {
                    aVar.a(true);
                } else if (com.anythink.china.common.c.a.a(context, iVar.B())) {
                    aVar.a(true);
                } else {
                    n.a().a(new Runnable() { // from class: com.anythink.china.activity.ApkConfirmDialogActivity.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            ApkConfirmDialogActivity.a = iVar;
                            a unused = ApkConfirmDialogActivity.b = aVar;
                            Intent intent = new Intent(context, (Class<?>) ApkConfirmDialogActivity.class);
                            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                            context.startActivity(intent);
                        }
                    });
                }
            }
        });
    }
}
