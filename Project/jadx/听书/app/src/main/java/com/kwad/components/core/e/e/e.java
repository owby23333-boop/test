package com.kwad.components.core.e.e;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.proxy.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends j {
    private a.C0333a PT;
    private Activity mActivity;

    public static void a(Activity activity, a.C0333a c0333a) {
        if (activity == null || c0333a == null) {
            return;
        }
        e eVar = new e();
        eVar.PT = c0333a;
        eVar.mActivity = activity;
        eVar.show(activity.getFragmentManager(), "second_confirm_dialog");
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onStart() {
        super.onStart();
    }

    @Override // android.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        g.pY().pZ();
        com.kwad.sdk.core.adlog.c.b(this.PT.getAdTemplate(), 229, (JSONObject) null);
        return super.onCreateDialog(bundle);
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        g.pY().qa();
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
    }

    @Override // com.kwad.components.core.proxy.j
    public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.core.e.e.e.1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return i == 4;
            }
        });
        return new a(this.mActivity, this, this.PT);
    }
}
