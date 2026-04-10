package cn.kuaipan.android.kss.download;

import cn.kuaipan.android.kss.download.LoadMap;

/* JADX INFO: loaded from: classes.dex */
public class LoadRecorder {
    private LoadMap map;
    private final LoadMap.Space space;

    public LoadRecorder(LoadMap loadMap, LoadMap.Space space) {
        this.map = loadMap;
        this.space = space;
    }

    public void add(int i) {
        if (this.map == null) {
            throw new RuntimeException("The recoder has been recycled");
        }
        this.space.remove(i);
        this.map.onSpaceRemoved(i);
    }

    public void finalize() throws Throwable {
        recycle();
        super.finalize();
    }

    public LoadMap.Space getSpace() {
        return this.space;
    }

    public long getStart() {
        return this.space.getStart();
    }

    public boolean isCompleted() {
        return this.space.size() <= 0;
    }

    public void recycle() {
        LoadMap loadMap = this.map;
        if (loadMap != null) {
            loadMap.recycleRecorder(this);
            this.map = null;
        }
    }

    public long size() {
        return this.space.size();
    }
}
