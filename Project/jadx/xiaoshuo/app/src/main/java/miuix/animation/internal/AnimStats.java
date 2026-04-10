package miuix.animation.internal;

import miuix.animation.utils.ObjectPool;

/* JADX INFO: loaded from: classes8.dex */
class AnimStats implements ObjectPool.IPoolObject {
    public int animCount;
    public int cancelCount;
    public int endCount;
    public int failCount;
    public int prepareCount;
    public int startedCount;
    public int updateCount;

    public static void add(AnimStats animStats, AnimStats animStats2) {
        animStats.animCount += animStats2.animCount;
        animStats.prepareCount += animStats2.prepareCount;
        animStats.startedCount += animStats2.startedCount;
        animStats.failCount += animStats2.failCount;
        animStats.updateCount += animStats2.updateCount;
        animStats.cancelCount += animStats2.cancelCount;
        animStats.endCount += animStats2.endCount;
    }

    @Override // miuix.animation.utils.ObjectPool.IPoolObject
    public void clear() {
        this.animCount = 0;
        this.prepareCount = 0;
        this.startedCount = 0;
        this.failCount = 0;
        this.updateCount = 0;
        this.cancelCount = 0;
        this.endCount = 0;
    }

    public boolean isNeedSetup() {
        return this.animCount > 0 && !isStarted();
    }

    public boolean isRunning() {
        return !isStarted() || (this.cancelCount + this.endCount) + this.failCount < this.animCount;
    }

    public boolean isStarted() {
        return this.startedCount > 0;
    }

    public void prepareOnFrameStart() {
        this.updateCount = 0;
    }

    public String toString() {
        return "AnimStats{total=" + this.animCount + ", p=" + this.prepareCount + ", s=" + this.startedCount + ", f=" + this.failCount + ", u=" + this.updateCount + ", c=" + this.cancelCount + ", e=" + this.endCount + '}';
    }
}
