package com.duokan.reader.ui.store.discover;

import android.text.TextUtils;
import androidx.annotation.LayoutRes;
import com.yuewen.st2;

/* JADX INFO: loaded from: classes5.dex */
public enum DiscoverType {
    NORMAL("base", st2.n.rp),
    BIG(SERVER_BIG, st2.n.pp),
    GROUP(SERVER_GROUP, st2.n.qp);

    private static final String SERVER_BASE = "base";
    private static final String SERVER_BIG = "yuedu-big";
    private static final String SERVER_GROUP = "yuedu-group";
    private final int mLayoutId;
    private final String mType;

    DiscoverType(String str, @LayoutRes int i) {
        this.mType = str;
        this.mLayoutId = i;
    }

    public static DiscoverType findByServerType(String str) {
        for (DiscoverType discoverType : values()) {
            if (TextUtils.equals(discoverType.mType, str)) {
                return discoverType;
            }
        }
        return null;
    }

    public int getLayoutId() {
        return this.mLayoutId;
    }

    public String getType() {
        return this.mType;
    }
}
