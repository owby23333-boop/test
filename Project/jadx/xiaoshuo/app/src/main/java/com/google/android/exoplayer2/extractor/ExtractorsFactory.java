package com.google.android.exoplayer2.extractor;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public interface ExtractorsFactory {
    public static final ExtractorsFactory EMPTY = new ExtractorsFactory() { // from class: com.yuewen.q01
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] createExtractors() {
            return ExtractorsFactory.lambda$static$0();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[0];
    }

    Extractor[] createExtractors();

    default Extractor[] createExtractors(Uri uri, Map<String, List<String>> map) {
        return createExtractors();
    }
}
