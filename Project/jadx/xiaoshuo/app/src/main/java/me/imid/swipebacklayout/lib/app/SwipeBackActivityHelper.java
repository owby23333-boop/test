package me.imid.swipebacklayout.lib.app;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.dangdang.zframework.R;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.Utils;

/* JADX INFO: loaded from: classes8.dex */
public class SwipeBackActivityHelper {
    private Activity mActivity;
    private SwipeBackLayout mSwipeBackLayout;

    public SwipeBackActivityHelper(Activity activity) {
        this.mActivity = activity;
    }

    public View findViewById(int i) {
        SwipeBackLayout swipeBackLayout = this.mSwipeBackLayout;
        if (swipeBackLayout != null) {
            return swipeBackLayout.findViewById(i);
        }
        return null;
    }

    public SwipeBackLayout getSwipeBackLayout() {
        return this.mSwipeBackLayout;
    }

    public void onActivityCreate() {
        this.mActivity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.mActivity.getWindow().getDecorView().setBackgroundDrawable(null);
        SwipeBackLayout swipeBackLayout = (SwipeBackLayout) LayoutInflater.from(this.mActivity.getApplicationContext()).inflate(R.layout.swipeback_layout, (ViewGroup) null);
        this.mSwipeBackLayout = swipeBackLayout;
        swipeBackLayout.addSwipeListener(new SwipeBackLayout.SwipeListener() { // from class: me.imid.swipebacklayout.lib.app.SwipeBackActivityHelper.1
            @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.SwipeListener
            public void onEdgeTouch(int i) {
                Utils.convertActivityToTranslucent(SwipeBackActivityHelper.this.mActivity);
            }

            @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.SwipeListener
            public void onScrollOverThreshold() {
            }

            @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.SwipeListener
            public void onScrollStateChange(int i, float f) {
            }
        });
    }

    public void onPostCreate() {
        this.mSwipeBackLayout.attachToActivity(this.mActivity);
    }
}
