package com.dangdang.zframework.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: classes10.dex */
public abstract class LoadingView {
    protected Context mContext;
    protected View mLoadingView;
    protected TextView mMessageTV;
    protected int mMsgId = -1;

    public LoadingView(Context context) {
        this.mContext = context;
        init(context);
    }

    public View getLoadingView() {
        return this.mLoadingView;
    }

    public int getMessageId() {
        return this.mMsgId;
    }

    public abstract void init(Context context);

    public abstract void reset();

    public void setMessage(int i) {
        if (this.mMessageTV == null) {
            return;
        }
        if (i > 0) {
            this.mMsgId = i;
            String string = this.mContext.getResources().getString(i);
            if (!TextUtils.isEmpty(string)) {
                this.mMessageTV.setText(string);
                this.mMessageTV.setVisibility(0);
                return;
            }
        }
        this.mMessageTV.setVisibility(8);
    }
}
