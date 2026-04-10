package com.kwad.components.ad.reward.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.a.a;
import com.kwad.components.ad.reward.k.v;
import com.kwad.components.core.l.g;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends g implements a.b {
    private AdTemplate mAdTemplate;
    private com.kwad.components.ad.reward.a.a rE;
    private a rF;
    private int[] ro;

    public interface a {
        void hg();
    }

    public static void a(Activity activity, AdTemplate adTemplate, a aVar, int[] iArr) {
        if (adTemplate == null || activity == null) {
            return;
        }
        String string = adTemplate.toJson().toString();
        Bundle bundle = new Bundle();
        bundle.putString("key_template_json", string);
        bundle.putIntArray("key_end_location", iArr);
        b bVar = new b();
        bVar.a(aVar);
        bVar.setArguments(bundle);
        bVar.show(activity.getFragmentManager(), "rewardCoupon");
    }

    private void a(a aVar) {
        this.rF = aVar;
    }

    @Override // com.kwad.components.core.l.g
    public final View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        getDialog().requestWindowFeature(1);
        this.rE = new com.kwad.components.ad.reward.a.a(layoutInflater.getContext(), viewGroup, this.ro);
        this.rE.a(this);
        Window window = getDialog().getWindow();
        if (window != null) {
            window.getDecorView().setPadding(0, 0, 0, 0);
            getDialog().setCanceledOnTouchOutside(false);
            window.setLayout(-1, -1);
            window.setDimAmount(0.0f);
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        this.rE.b(v.C(this.mAdTemplate));
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.ad.reward.a.b.1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                return i2 == 4 && keyEvent.getAction() == 0;
            }
        });
        return this.rE.hc();
    }

    @Override // com.kwad.components.ad.reward.a.a.b
    public final void hg() {
        dismiss();
        a aVar = this.rF;
        if (aVar != null) {
            aVar.hg();
        }
    }

    @Override // com.kwad.components.ad.reward.a.a.b
    public final void hh() {
        dismiss();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.containsKey("key_template_json")) {
                try {
                    String string = arguments.getString("key_template_json");
                    this.mAdTemplate = new AdTemplate();
                    this.mAdTemplate.parseJson(new JSONObject(string));
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                }
            }
            if (arguments.containsKey("key_end_location")) {
                this.ro = arguments.getIntArray("key_end_location");
            }
        }
    }
}
