package com.mibi.sdk.mvp;

import android.content.Context;
import java.util.UUID;

/* JADX INFO: loaded from: classes14.dex */
public abstract class Model implements IModel {
    private Context mContext;
    private String mId = UUID.randomUUID().toString();

    public Model(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public Context getContext() {
        Context context = this.mContext;
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Do not call this before onInit()");
    }

    public String getId() {
        return this.mId;
    }
}
