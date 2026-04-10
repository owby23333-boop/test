package com.mibi.sdk.channel.wxpay;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.component.MarketUtils;
import com.mibi.sdk.widget.AlertDialog;

/* JADX INFO: loaded from: classes13.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7080a = "WxUtils";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f7081b = "com.tencent.mm";

    public class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f7082a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ InterfaceC0466c f7083b;

        public a(Activity activity, InterfaceC0466c interfaceC0466c) {
            this.f7082a = activity;
            this.f7083b = interfaceC0466c;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MibiLog.d(c.f7080a, "onConfirm");
            MarketUtils.openDetailInMarket(this.f7082a.getApplicationContext(), "com.tencent.mm");
            InterfaceC0466c interfaceC0466c = this.f7083b;
            if (interfaceC0466c != null) {
                interfaceC0466c.b();
            }
            dialogInterface.dismiss();
        }
    }

    public class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC0466c f7084a;

        public b(InterfaceC0466c interfaceC0466c) {
            this.f7084a = interfaceC0466c;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MibiLog.d(c.f7080a, "onCancel");
            InterfaceC0466c interfaceC0466c = this.f7084a;
            if (interfaceC0466c != null) {
                interfaceC0466c.a();
            }
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.mibi.sdk.channel.wxpay.c$c, reason: collision with other inner class name */
    public interface InterfaceC0466c {
        void a();

        void b();
    }

    public static boolean a(Context context) {
        return MarketUtils.isAppInstalled(context, "com.tencent.mm");
    }

    public static void a(Activity activity, InterfaceC0466c interfaceC0466c) {
        MibiLog.d(f7080a, "showInstallPromptDialog");
        AlertDialog alertDialogCreate = new AlertDialog.Builder(activity).setMessage(activity.getResources().getString(R.string.mibi_paytool_wxpay_not_installed)).setClickable(true).setNegativeButton(android.R.string.cancel, new b(interfaceC0466c)).setPositiveButton(R.string.mibi_button_confirm, new a(activity, interfaceC0466c)).create();
        alertDialogCreate.setCancelable(false);
        alertDialogCreate.show();
    }
}
