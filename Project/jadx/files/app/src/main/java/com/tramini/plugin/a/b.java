package com.tramini.plugin.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.List;
import l.c.a.a.a;

/* JADX INFO: loaded from: classes3.dex */
public class b extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        List<String> listD;
        intent.getAction();
        a aVarB = l.c.a.a.b.a(context).b();
        if (aVarB == null) {
            return;
        }
        com.tramini.plugin.a.k.b.a().a(aVarB);
        if (!(com.tramini.plugin.a.k.h.a(context) && aVarB.n() == 0) && (listD = aVarB.d()) != null && listD.size() > 0 && listD.contains(intent.getAction())) {
            try {
                String stringExtra = intent.getStringExtra(aVarB.f());
                String stringExtra2 = intent.getStringExtra(aVarB.g());
                intent.getStringExtra(aVarB.h());
                String stringExtra3 = intent.getStringExtra(aVarB.i());
                com.tramini.plugin.a.k.a.a(aVarB, stringExtra3, intent.getStringExtra(aVarB.l()), intent.getStringExtra(aVarB.j()), new e(this, intent.getIntExtra(aVarB.m(), 0), stringExtra2, aVarB, stringExtra3, stringExtra));
            } catch (Throwable unused) {
            }
        }
    }
}
