package com.anythink.expressad.video.module.a.a;

import com.anythink.expressad.video.module.AnythinkContainerView;
import com.anythink.expressad.video.module.AnythinkVideoView;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends o {
    public static final long ag = 3000;
    private AnythinkVideoView ai;
    private AnythinkContainerView aj;
    private int ak;
    private final com.anythink.core.common.i.a al;
    private boolean am;
    private boolean an;
    private int ao;
    private int ap;
    private final com.anythink.core.common.i.b aq;

    public m(AnythinkVideoView anythinkVideoView, AnythinkContainerView anythinkContainerView, com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.videocommon.c.c cVar2, com.anythink.expressad.videocommon.b.c cVar3, String str, String str2, int i2, int i3, com.anythink.expressad.video.module.a.a aVar, int i4, boolean z2, int i5) {
        super(cVar, cVar2, cVar3, str, str2, aVar, i4, z2);
        this.al = com.anythink.core.common.i.c.a();
        this.am = false;
        this.an = false;
        this.ao = 1;
        this.aq = new com.anythink.core.common.i.b() { // from class: com.anythink.expressad.video.module.a.a.m.1
            @Override // java.lang.Runnable
            public final void run() {
                m.this.aj.showVideoClickView(-1);
                m.this.ai.soundOperate(0, 2);
            }
        };
        this.ai = anythinkVideoView;
        this.aj = anythinkContainerView;
        this.ap = i2;
        this.ak = i3;
        this.ao = i5;
        if (anythinkVideoView != null) {
            this.am = anythinkVideoView.getVideoSkipTime() == 0;
        }
        if (anythinkVideoView == null || anythinkContainerView == null) {
            this.W = false;
        }
    }

    private void g() {
        this.al.a(this.aq);
    }

    private void h() {
        g();
        this.al.a(this.aq, ag);
    }

    private void i() {
        com.anythink.expressad.foundation.d.c cVar = this.X;
        if (cVar == null || cVar.k() != 5) {
            return;
        }
        com.anythink.expressad.foundation.d.c cVar2 = null;
        AnythinkVideoView anythinkVideoView = this.ai;
        if (anythinkVideoView != null && anythinkVideoView.mCampOrderViewData != null) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 < this.ai.mCampOrderViewData.size()) {
                    if (this.ai.mCampOrderViewData.get(i3) != null && this.ai.mCampOrderViewData.get(i3).aZ() == this.X.aZ()) {
                        i2 = i3 - 1;
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            if (i2 >= 0 && this.ai.mCampOrderViewData.get(i2) != null) {
                cVar2 = this.ai.mCampOrderViewData.get(i2);
            }
        }
        if (cVar2 != null) {
            AnythinkVideoView anythinkVideoView2 = this.ai;
            if (anythinkVideoView2 != null) {
                anythinkVideoView2.setCampaign(cVar2);
            }
            AnythinkContainerView anythinkContainerView = this.aj;
            if (anythinkContainerView != null) {
                anythinkContainerView.setCampaign(cVar2);
            }
            a(cVar2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:183:0x02ba  */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:217)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // com.anythink.expressad.video.module.a.a.o, com.anythink.expressad.video.module.a.a.k, com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(int r8, java.lang.Object r9) {
        /*
            Method dump skipped, instruction units count: 830
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.module.a.a.m.a(int, java.lang.Object):void");
    }

    private void a(int i2, int i3) {
        if (this.am || this.ai == null || this.X == null) {
            return;
        }
        int i4 = this.ak;
        char c2 = (i4 < 0 || i2 < i4) ? (char) 1 : (char) 2;
        if (c2 != 2 && (this.X.i() != 0 ? i2 > this.X.i() : this.ai.mCurrPlayNum > 1)) {
            c2 = 2;
        }
        if (c2 != 2 && this.ai.mCurrPlayNum > 1 && i2 == i3) {
            c2 = 2;
        }
        if (c2 == 2) {
            this.ai.closeVideoOperate(0, 2);
            this.am = true;
        }
    }
}
