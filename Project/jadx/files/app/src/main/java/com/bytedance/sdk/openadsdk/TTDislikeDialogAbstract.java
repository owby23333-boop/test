package com.bytedance.sdk.openadsdk;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeListView;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TTDislikeDialogAbstract extends Dialog {
    private View mb;
    private TTDislikeController ox;

    public TTDislikeDialogAbstract(Context context) {
        super(context);
    }

    public abstract int getLayoutId();

    public abstract ViewGroup.LayoutParams getLayoutParams();

    public abstract int[] getTTDislikeListViewIds();

    protected void mb() {
        if (this.ox == null || this.mb == null) {
            return;
        }
        int[] tTDislikeListViewIds = getTTDislikeListViewIds();
        if (tTDislikeListViewIds == null || tTDislikeListViewIds.length <= 0) {
            throw new IllegalArgumentException("dislike选项列表为空，请设置TTDislikeListView");
        }
        for (int i2 : tTDislikeListViewIds) {
            View viewFindViewById = this.mb.findViewById(i2);
            if (viewFindViewById == null) {
                throw new IllegalArgumentException("getTTDislikeListViewIds提供的id找不到view，请检查");
            }
            if (!(viewFindViewById instanceof TTDislikeListView)) {
                throw new IllegalArgumentException("getTTDislikeListViewIds找到的view类型异常，请检查");
            }
            ((TTDislikeListView) viewFindViewById).setDislikeInfo(this.ox);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.mb = LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) null);
            if (this.mb == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            View view = this.mb;
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            }
            setContentView(view, layoutParams);
            mb();
        } catch (Exception unused) {
        }
    }

    public void setDislikeModel(TTDislikeController tTDislikeController) {
        this.ox = tTDislikeController;
        mb();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }

    @Deprecated
    public void startPersonalizePromptActivity() {
    }

    public TTDislikeDialogAbstract(Context context, int i2) {
        super(context, i2);
    }
}
