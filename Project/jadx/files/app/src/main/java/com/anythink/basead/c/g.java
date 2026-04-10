package com.anythink.basead.c;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.y;

/* JADX INFO: loaded from: classes.dex */
public final class g extends y {
    String a;
    String b;

    public g(com.anythink.core.common.e.i iVar, String str, String str2) {
        this.a = str;
        this.b = str2;
        this.f7391c = iVar;
    }

    @Override // com.anythink.core.common.e.y
    public final void a(Activity activity) {
        try {
            String strAa = this.f7391c instanceof aa ? ((aa) this.f7391c).aa() : "";
            if (TextUtils.isEmpty(strAa)) {
                strAa = this.f7391c.r();
            }
            final Context contextG = n.a().g();
            View viewInflate = LayoutInflater.from(activity).inflate(com.anythink.core.common.k.h.a(contextG, "myoffer_confirm_dialog", "layout"), (ViewGroup) null, false);
            TextView textView = (TextView) viewInflate.findViewById(com.anythink.core.common.k.h.a(contextG, "myoffer_confirm_msg", "id"));
            TextView textView2 = (TextView) viewInflate.findViewById(com.anythink.core.common.k.h.a(contextG, "myoffer_confirm_give_up", "id"));
            TextView textView3 = (TextView) viewInflate.findViewById(com.anythink.core.common.k.h.a(contextG, "myoffer_confirm_continue", "id"));
            textView.setText("立即打开\"" + strAa + "\"?");
            textView2.setText("取 消");
            textView3.setText("确 定");
            final Dialog dialog = new Dialog(activity, com.anythink.core.common.k.h.a(contextG, "style_full_screen_translucent_dialog", com.anythink.expressad.foundation.h.i.f10647e));
            dialog.setContentView(viewInflate);
            dialog.setCancelable(false);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.c.g.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g gVar = g.this;
                    com.anythink.core.common.j.c.a(gVar.b, ((y) gVar).f7391c.p(), g.this.a, 7, (String) null, 0L, 0L);
                    try {
                        dialog.dismiss();
                    } catch (Throwable unused) {
                    }
                }
            });
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.c.g.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    try {
                        com.anythink.core.common.j.c.a(g.this.b, ((y) g.this).f7391c.p(), g.this.a, 8, (String) null, 0L, 0L);
                        if (com.anythink.basead.a.b.a(contextG, ((y) g.this).f7391c)) {
                            com.anythink.core.common.j.c.a(g.this.b, ((y) g.this).f7391c.p(), g.this.a, 9, (String) null, 0L, 0L);
                        }
                        dialog.dismiss();
                    } catch (Throwable unused) {
                    }
                }
            });
            dialog.show();
        } catch (Throwable unused) {
        }
    }
}
