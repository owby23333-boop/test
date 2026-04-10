package miuix.container;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes7.dex */
public interface ExtraPaddingProcessor {
    void addExtraPaddingObserver(ExtraPaddingObserver extraPaddingObserver);

    @Nullable
    ExtraPaddingPolicy getExtraPaddingPolicy();

    boolean isExtraHorizontalPaddingEnable();

    void removeExtraPaddingObserver(ExtraPaddingObserver extraPaddingObserver);

    void setExtraHorizontalPaddingEnable(boolean z);

    void setExtraHorizontalPaddingInitEnable(boolean z);

    void setExtraPaddingPolicy(ExtraPaddingPolicy extraPaddingPolicy);
}
