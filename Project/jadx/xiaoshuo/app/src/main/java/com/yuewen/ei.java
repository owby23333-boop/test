package com.yuewen;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.duokan.adbridge.bean.CommonAdInfo;

/* JADX INFO: loaded from: classes12.dex */
public interface ei extends qi1 {
    int A();

    void B(String str);

    @Override // com.yuewen.qi1
    void c(View view);

    void d(String str);

    void i(String str);

    void j(String str);

    View k(Context context, ViewGroup viewGroup, String[] strArr, int i);

    int m();

    int n();

    void o(boolean z);

    int p();

    CommonAdInfo r(Context context, ViewGroup viewGroup, String[] strArr, int i);

    void s(Context context, ViewGroup viewGroup, String[] strArr, int i, View view);

    void t(mb2 mb2Var);

    int u();

    int v();

    View x(int i);

    View y(Context context, ViewGroup viewGroup, String[] strArr, int i);
}
