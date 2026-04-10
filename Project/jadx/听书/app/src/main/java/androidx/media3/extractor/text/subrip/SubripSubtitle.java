package androidx.media3.extractor.text.subrip;

import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.Subtitle;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class SubripSubtitle implements Subtitle {
    private final long[] cueTimesUs;
    private final Cue[] cues;

    public SubripSubtitle(Cue[] cueArr, long[] jArr) {
        this.cues = cueArr;
        this.cueTimesUs = jArr;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        int iBinarySearchCeil = Util.binarySearchCeil(this.cueTimesUs, j, false, false);
        if (iBinarySearchCeil < this.cueTimesUs.length) {
            return iBinarySearchCeil;
        }
        return -1;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public int getEventTimeCount() {
        return this.cueTimesUs.length;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public long getEventTime(int i) {
        Assertions.checkArgument(i >= 0);
        Assertions.checkArgument(i < this.cueTimesUs.length);
        return this.cueTimesUs[i];
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public List<Cue> getCues(long j) {
        int iBinarySearchFloor = Util.binarySearchFloor(this.cueTimesUs, j, true, false);
        if (iBinarySearchFloor == -1 || this.cues[iBinarySearchFloor] == Cue.EMPTY) {
            return Collections.emptyList();
        }
        return Collections.singletonList(this.cues[iBinarySearchFloor]);
    }
}
