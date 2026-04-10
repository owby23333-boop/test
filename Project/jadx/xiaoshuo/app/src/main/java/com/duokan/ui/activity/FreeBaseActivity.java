package com.duokan.ui.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivityExt;
import com.duokan.reader.ui.general.HeaderView;
import com.yuewen.f5;
import com.yuewen.wm1;

/* JADX INFO: loaded from: classes5.dex */
public class FreeBaseActivity extends AppCompatActivityExt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6726a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6727b;

    public void A0() {
    }

    public void C0(HeaderView headerView) {
        if (headerView != null) {
            headerView.setTheme(new f5(this));
        }
    }

    public final boolean l0() {
        return this.f6727b;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (v0()) {
            new wm1().a(this);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f6727b = false;
        A0();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f6727b = true;
        w0(this.f6726a);
        if (this.f6726a) {
            this.f6726a = false;
        }
    }

    public boolean v0() {
        return false;
    }

    public void w0(boolean z) {
    }
}
