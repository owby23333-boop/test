package com.ss.android.downloadlib.ox;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class ox {
    public void mb(@NonNull final com.ss.android.downloadad.api.mb.ox oxVar, @NonNull final ko koVar, int i2) {
        com.ss.android.downloadlib.hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.ox.ox.1
            @Override // java.lang.Runnable
            public void run() {
                if (lz.mb(oxVar)) {
                    koVar.mb(false);
                } else if (u.mb(oxVar)) {
                    u.mb(oxVar, new ww() { // from class: com.ss.android.downloadlib.ox.ox.1.1
                        @Override // com.ss.android.downloadlib.ox.ww
                        public void mb(boolean z2) {
                            koVar.mb(z2);
                        }
                    });
                } else {
                    koVar.mb(false);
                }
            }
        }, i2);
    }
}
