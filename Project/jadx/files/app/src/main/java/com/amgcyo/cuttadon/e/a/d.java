package com.amgcyo.cuttadon.e.a;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.fatcatfat.io.R;
import com.mardous.discreteseekbar.DiscreteSeekBar;

/* JADX INFO: compiled from: SliderDialogFragment.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends DialogFragment implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private DiscreteSeekBar f3671s;

    public static d a(int i2, int i3, int i4, int i5, int i6) {
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putInt("cimoc.intent.extra.EXTRA_DIALOG_TITLE", i2);
        bundle.putIntArray("cimoc.intent.extra.EXTRA_DIALOG_ITEMS", new int[]{i3, i4, i5});
        bundle.putInt("cimoc.intent.extra.EXTRA_DIALOG_REQUEST_CODE", i6);
        dVar.setArguments(bundle);
        return dVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        int i3 = getArguments().getInt("cimoc.intent.extra.EXTRA_DIALOG_REQUEST_CODE");
        Bundle bundle = new Bundle();
        bundle.putInt("cimoc.intent.extra.EXTRA_DIALOG_RESULT_VALUE", this.f3671s.getProgress());
        ((com.amgcyo.cuttadon.view.comic.m.b) (getTargetFragment() != null ? getTargetFragment() : getActivity())).onDialogResult(i3, bundle);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        View viewInflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_slider, (ViewGroup) null);
        int[] intArray = getArguments().getIntArray("cimoc.intent.extra.EXTRA_DIALOG_ITEMS");
        this.f3671s = (DiscreteSeekBar) viewInflate.findViewById(R.id.dialog_slider_bar);
        this.f3671s.setMin(intArray[0]);
        this.f3671s.setMax(intArray[1]);
        this.f3671s.setProgress(intArray[1]);
        this.f3671s.setProgress(intArray[2]);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getArguments().getInt("cimoc.intent.extra.EXTRA_DIALOG_TITLE")).setView(viewInflate).setPositiveButton(R.string.confirm, this);
        return builder.create();
    }
}
