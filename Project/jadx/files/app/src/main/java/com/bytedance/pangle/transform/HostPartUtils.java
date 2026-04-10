package com.bytedance.pangle.transform;

import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class HostPartUtils {
    private Class fragmentActivityClazz;

    static class a {
        private static final HostPartUtils a = new HostPartUtils();
    }

    public HostPartUtils() {
        try {
            this.fragmentActivityClazz = FragmentActivity.class;
        } catch (Throwable unused) {
        }
    }

    public static FragmentActivity getFragmentActivity(Object obj, String str) {
        return (FragmentActivity) ZeusTransformUtils._getActivity(obj, str);
    }

    public static final Class getFragmentActivityClass() {
        return a.a.fragmentActivityClazz;
    }
}
