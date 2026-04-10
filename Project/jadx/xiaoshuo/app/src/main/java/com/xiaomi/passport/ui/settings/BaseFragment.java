package com.xiaomi.passport.ui.settings;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import com.xiaomi.passport.ui.onetrack.Analytics;

/* JADX INFO: loaded from: classes8.dex */
public class BaseFragment extends Fragment {
    public String getName() {
        return getClass().getSimpleName();
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        Analytics.pauseEvent(getName());
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        Analytics.resumeEvent(getName());
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        Analytics.viewEvent(getName());
    }
}
