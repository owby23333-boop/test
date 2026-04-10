package com.sdsmdg.tastytoast;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.two.app.library_toasytoast.R$drawable;
import com.two.app.library_toasytoast.R$id;
import com.two.app.library_toasytoast.R$layout;
import l.a.a.d;
import l.a.a.e;
import l.a.a.f;
import l.a.a.j;

/* JADX INFO: compiled from: TastyToast.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static WarningToastView a;

    /* JADX INFO: renamed from: com.sdsmdg.tastytoast.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TastyToast.java */
    class C0504a extends d {
        C0504a() {
        }

        @Override // l.a.a.h
        public void a(e eVar) {
            float fA = 0.9f - (((float) eVar.a()) * 0.5f);
            a.a.setScaleX(fA);
            a.a.setScaleY(fA);
        }
    }

    /* JADX INFO: compiled from: TastyToast.java */
    class b implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ e f17896s;

        b(e eVar) {
            this.f17896s = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused) {
            }
            this.f17896s.c(0.4000000059604645d);
        }
    }

    public static Toast a(Context context, int i2, String str, int i3, int i4) {
        Toast toast = new Toast(context);
        toast.setGravity(i2, 0, 300);
        switch (i4) {
            case 1:
                View viewInflate = LayoutInflater.from(context).inflate(R$layout.success_toast_layout, (ViewGroup) null, false);
                TextView textView = (TextView) viewInflate.findViewById(R$id.toastMessage);
                textView.setText(str);
                ((SuccessToastView) viewInflate.findViewById(R$id.successView)).a();
                textView.setBackgroundResource(R$drawable.success_toast);
                textView.setTextColor(Color.parseColor("#FFFFFF"));
                toast.setView(viewInflate);
                break;
            case 2:
                View viewInflate2 = LayoutInflater.from(context).inflate(R$layout.warning_toast_layout, (ViewGroup) null, false);
                TextView textView2 = (TextView) viewInflate2.findViewById(R$id.toastMessage);
                textView2.setText(str);
                a = (WarningToastView) viewInflate2.findViewById(R$id.warningView);
                e eVarA = j.c().a();
                eVarA.b(1.8d);
                eVarA.a(new f(40.0d, 5.0d));
                eVarA.a(new C0504a());
                new Thread(new b(eVarA)).start();
                textView2.setBackgroundResource(R$drawable.warning_toast);
                textView2.setTextColor(Color.parseColor("#FFFFFF"));
                toast.setView(viewInflate2);
                break;
            case 3:
                View viewInflate3 = LayoutInflater.from(context).inflate(R$layout.error_toast_layout, (ViewGroup) null, false);
                TextView textView3 = (TextView) viewInflate3.findViewById(R$id.toastMessage);
                textView3.setText(str);
                ((ErrorToastView) viewInflate3.findViewById(R$id.errorView)).a();
                textView3.setBackgroundResource(R$drawable.error_toast);
                textView3.setTextColor(Color.parseColor("#FFFFFF"));
                toast.setView(viewInflate3);
                break;
            case 4:
                View viewInflate4 = LayoutInflater.from(context).inflate(R$layout.info_toast_layout, (ViewGroup) null, false);
                TextView textView4 = (TextView) viewInflate4.findViewById(R$id.toastMessage);
                textView4.setText(str);
                ((InfoToastView) viewInflate4.findViewById(R$id.infoView)).a();
                textView4.setBackgroundResource(R$drawable.info_toast);
                textView4.setTextColor(Color.parseColor("#FFFFFF"));
                toast.setView(viewInflate4);
                break;
            case 5:
                View viewInflate5 = LayoutInflater.from(context).inflate(R$layout.default_toast_layout, (ViewGroup) null, false);
                TextView textView5 = (TextView) viewInflate5.findViewById(R$id.toastMessage);
                textView5.setText(str);
                ((DefaultToastView) viewInflate5.findViewById(R$id.defaultView)).a();
                textView5.setBackgroundResource(R$drawable.default_toast);
                textView5.setTextColor(Color.parseColor("#FFFFFF"));
                toast.setView(viewInflate5);
                break;
            case 6:
                View viewInflate6 = LayoutInflater.from(context).inflate(R$layout.confusing_toast_layout, (ViewGroup) null, false);
                TextView textView6 = (TextView) viewInflate6.findViewById(R$id.toastMessage);
                textView6.setText(str);
                ((ConfusingToastView) viewInflate6.findViewById(R$id.confusingView)).a();
                textView6.setBackgroundResource(R$drawable.confusing_toast);
                textView6.setTextColor(Color.parseColor("#FFFFFF"));
                toast.setView(viewInflate6);
                break;
        }
        toast.setDuration(i3);
        toast.show();
        return toast;
    }
}
