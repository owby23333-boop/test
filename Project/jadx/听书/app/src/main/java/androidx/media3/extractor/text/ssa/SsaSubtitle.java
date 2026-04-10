package androidx.media3.extractor.text.ssa;

import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.Subtitle;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class SsaSubtitle implements Subtitle {
    private final List<Long> cueTimesUs;
    private final List<List<Cue>> cues;

    public SsaSubtitle(List<List<Cue>> list, List<Long> list2) {
        this.cues = list;
        this.cueTimesUs = list2;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        int iBinarySearchCeil = Util.binarySearchCeil((List<? extends Comparable<? super Long>>) this.cueTimesUs, Long.valueOf(j), false, false);
        if (iBinarySearchCeil < this.cueTimesUs.size()) {
            return iBinarySearchCeil;
        }
        return -1;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public int getEventTimeCount() {
        return this.cueTimesUs.size();
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public long getEventTime(int i) {
        Assertions.checkArgument(i >= 0);
        Assertions.checkArgument(i < this.cueTimesUs.size());
        return this.cueTimesUs.get(i).longValue();
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public List<Cue> getCues(long j) {
        int iBinarySearchFloor = Util.binarySearchFloor((List<? extends Comparable<? super Long>>) this.cueTimesUs, Long.valueOf(j), true, false);
        if (iBinarySearchFloor == -1) {
            return Collections.emptyList();
        }
        return this.cues.get(iBinarySearchFloor);
    }
}
