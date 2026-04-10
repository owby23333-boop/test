package com.yuewen;

import android.content.Context;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.TextView;
import com.duokan.advertisement.i;
import com.duokan.core.ui.CancelableDialogBox;

/* JADX INFO: loaded from: classes12.dex */
public class h6 extends CancelableDialogBox {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f11946b;
    public final a c;

    public interface a {
        void a();

        default void b() {
        }
    }

    public h6(Context context, String str, a aVar) {
        super(context);
        this.f11946b = context;
        this.f11945a = str;
        this.c = aVar;
        setContentView(i.n.R);
        setFloatNavigation(true);
        setCancelOnBack(true);
        setCancelOnTouchOutside(true);
        setGravity(80);
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(View view) {
        dismiss();
        this.c.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(View view) {
        dismiss();
        this.c.a();
    }

    public final String q() {
        PackageManager packageManager = this.f11946b.getPackageManager();
        String string = this.f11946b.getString(i.r.C6);
        if (packageManager == null) {
            return string;
        }
        try {
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.f11945a, 128)).toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return string;
        }
    }

    public final void r() {
        ((TextView) findViewById(i.k.Ro)).setText(this.f11946b.getString(i.r.H6, q()));
        TextView textView = (TextView) findViewById(i.k.ni);
        TextView textView2 = (TextView) findViewById(i.k.c1);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.yuewen.f6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11060a.s(view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.yuewen.g6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11448a.t(view);
            }
        });
    }
}
