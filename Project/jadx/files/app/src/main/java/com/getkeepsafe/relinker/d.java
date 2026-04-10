package com.getkeepsafe.relinker;

import android.annotation.SuppressLint;
import android.os.Build;
import com.getkeepsafe.relinker.b;

/* JADX INFO: compiled from: SystemLibraryLoader.java */
/* JADX INFO: loaded from: classes2.dex */
final class d implements b.InterfaceC0314b {
    d() {
    }

    @Override // com.getkeepsafe.relinker.b.InterfaceC0314b
    public String a(String str) {
        return (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
    }

    @Override // com.getkeepsafe.relinker.b.InterfaceC0314b
    public String b(String str) {
        return str.substring(3, str.length() - 3);
    }

    @Override // com.getkeepsafe.relinker.b.InterfaceC0314b
    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public void c(String str) {
        System.load(str);
    }

    @Override // com.getkeepsafe.relinker.b.InterfaceC0314b
    public void loadLibrary(String str) {
        System.loadLibrary(str);
    }

    @Override // com.getkeepsafe.relinker.b.InterfaceC0314b
    public String[] a() {
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = Build.SUPPORTED_ABIS;
            if (strArr.length > 0) {
                return strArr;
            }
        }
        return !e.a(Build.CPU_ABI2) ? new String[]{Build.CPU_ABI, Build.CPU_ABI2} : new String[]{Build.CPU_ABI};
    }
}
