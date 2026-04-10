package com.bytedance.pangle.transform;

import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: classes2.dex */
public class HostPartUtils {
    private Class fragmentActivityClazz;

    private static class SingletonHolder {
        private static final HostPartUtils INSTANCE = new HostPartUtils();

        private SingletonHolder() {
        }
    }

    public HostPartUtils() {
        try {
            this.fragmentActivityClazz = FragmentActivity.class;
        } catch (Throwable unused) {
        }
    }

    public static final Class getFragmentActivityClass() {
        return SingletonHolder.INSTANCE.fragmentActivityClazz;
    }

    public static FragmentActivity getFragmentActivity(Object obj, String str) {
        return (FragmentActivity) ZeusTransformUtils._getActivity(obj, str);
    }
}
