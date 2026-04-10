package com.kwad.components.core.l;

import android.app.Dialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.BaseSystemDialogFragment;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.utils.r;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g extends BaseSystemDialogFragment {
    private int a(FragmentTransaction fragmentTransaction, String str) {
        try {
            r.a(this, "mDismissed", Boolean.FALSE);
            r.a(this, "mShownByMe", Boolean.TRUE);
            r.a(this, "mViewDestroyed", Boolean.FALSE);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
        return fragmentTransaction.add(this, str).commitAllowingStateLoss();
    }

    protected abstract View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup);

    @Override // android.app.DialogFragment
    public void dismiss() {
        try {
            if (getActivity() != null && !getActivity().isFinishing()) {
                super.dismissAllowingStateLoss();
            } else if (getActivity() == null) {
                super.dismissAllowingStateLoss();
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
    }

    public final boolean isShowing() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
    }

    @Override // android.app.Fragment
    @Nullable
    public final View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        return a(com.kwad.sdk.i.a.dv(Wrapper.wrapContextIfNeed(layoutInflater.getContext())), viewGroup);
    }

    @Override // android.app.DialogFragment
    public int show(FragmentTransaction fragmentTransaction, String str) {
        try {
            return super.show(fragmentTransaction, str);
        } catch (Throwable unused) {
            return a(fragmentTransaction, str);
        }
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            try {
                super.show(fragmentManager, str);
            } catch (Throwable unused) {
                r.a((Object) this, "showAllowingStateLoss", fragmentManager, str);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            a(fragmentManager.beginTransaction(), str);
        }
    }
}
