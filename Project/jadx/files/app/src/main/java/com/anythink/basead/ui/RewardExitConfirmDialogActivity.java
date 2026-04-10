package com.anythink.basead.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.anythink.core.common.k.h;
import com.anythink.expressad.foundation.h.i;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* JADX INFO: loaded from: classes2.dex */
public class RewardExitConfirmDialogActivity extends Activity {
    private static Runnable a;
    private static String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Dialog f6295c;

    /* JADX INFO: renamed from: com.anythink.basead.ui.RewardExitConfirmDialogActivity$1, reason: invalid class name */
    final class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (RewardExitConfirmDialogActivity.a != null) {
                RewardExitConfirmDialogActivity.a.run();
            }
            RewardExitConfirmDialogActivity.this.finish();
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.RewardExitConfirmDialogActivity$2, reason: invalid class name */
    final class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            RewardExitConfirmDialogActivity.this.finish();
        }
    }

    private void b() {
        try {
            View viewInflate = LayoutInflater.from(this).inflate(h.a(this, "myoffer_confirm_dialog", "layout"), (ViewGroup) null, false);
            TextView textView = (TextView) viewInflate.findViewById(h.a(this, "myoffer_confirm_msg", "id"));
            TextView textView2 = (TextView) viewInflate.findViewById(h.a(this, "myoffer_confirm_give_up", "id"));
            TextView textView3 = (TextView) viewInflate.findViewById(h.a(this, "myoffer_confirm_continue", "id"));
            textView.setText(getResources().getString(h.a(this, "myoffer_reward_exit_confirm_msg", i.f10649g), b));
            textView2.setText(getResources().getString(h.a(this, "myoffer_reward_exit_confirm_give_up", i.f10649g)));
            textView3.setText(getResources().getString(h.a(this, "myoffer_reward_exit_confirm_continue", i.f10649g)));
            textView2.setOnClickListener(new AnonymousClass1());
            textView3.setOnClickListener(new AnonymousClass2());
            this.f6295c = new Dialog(this, h.a(this, "style_full_screen_translucent_dialog", i.f10647e));
            this.f6295c.setContentView(viewInflate);
            this.f6295c.setCancelable(false);
            this.f6295c.show();
        } catch (Throwable unused) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            View viewInflate = LayoutInflater.from(this).inflate(h.a(this, "myoffer_confirm_dialog", "layout"), (ViewGroup) null, false);
            TextView textView = (TextView) viewInflate.findViewById(h.a(this, "myoffer_confirm_msg", "id"));
            TextView textView2 = (TextView) viewInflate.findViewById(h.a(this, "myoffer_confirm_give_up", "id"));
            TextView textView3 = (TextView) viewInflate.findViewById(h.a(this, "myoffer_confirm_continue", "id"));
            textView.setText(getResources().getString(h.a(this, "myoffer_reward_exit_confirm_msg", i.f10649g), b));
            textView2.setText(getResources().getString(h.a(this, "myoffer_reward_exit_confirm_give_up", i.f10649g)));
            textView3.setText(getResources().getString(h.a(this, "myoffer_reward_exit_confirm_continue", i.f10649g)));
            textView2.setOnClickListener(new AnonymousClass1());
            textView3.setOnClickListener(new AnonymousClass2());
            this.f6295c = new Dialog(this, h.a(this, "style_full_screen_translucent_dialog", i.f10647e));
            this.f6295c.setContentView(viewInflate);
            this.f6295c.setCancelable(false);
            this.f6295c.show();
        } catch (Throwable unused) {
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        Dialog dialog = this.f6295c;
        if (dialog != null) {
            dialog.dismiss();
            this.f6295c = null;
        }
        a = null;
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (4 == i2) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public static void a(Context context, String str, Runnable runnable) {
        b = str;
        a = runnable;
        Intent intent = new Intent(context, (Class<?>) RewardExitConfirmDialogActivity.class);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        context.startActivity(intent);
    }
}
