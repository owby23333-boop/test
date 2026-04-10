package com.open.hule.library.view;

import android.app.Dialog;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentManager;
import com.open.hule.library.R$style;

/* JADX INFO: compiled from: BaseDialog.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k extends AppCompatDialogFragment {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f17680s;

    private int a(Window window) {
        Display defaultDisplay = window.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.x;
    }

    abstract int a();

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        try {
            super.dismiss();
            this.f17680s = false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, R$style.UpdateAppDialog);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (a() != 0) {
            return layoutInflater.inflate(a(), viewGroup, false);
        }
        throw new NullPointerException("layout is null ");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setGravity(17);
        double dA = a(window);
        Double.isNaN(dA);
        window.setLayout((int) ((dA * 8.5d) / 10.0d), -2);
        window.setBackgroundDrawable(new ColorDrawable(0));
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            if (this.f17680s) {
                return;
            }
            super.show(fragmentManager, str);
            this.f17680s = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
