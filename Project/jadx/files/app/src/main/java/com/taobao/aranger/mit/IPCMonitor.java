package com.taobao.aranger.mit;

import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.taobao.aranger.logs.IPCLog;
import com.taobao.aranger.utils.IPCThreadCaller;

/* JADX INFO: loaded from: classes3.dex */
public class IPCMonitor {
    private static final String MODULE_NAME = "ARanger";
    private static final String TAG = "IPCMonitor";
    private static boolean isAppMonitorValid;

    public static class IpcState {
        private static final String DIMENSION_DEGRADE = "degrade";
        private static final String DIMENSION_METHOD_NAME = "methodName";
        private static final String DIMENSION_RESULT = "result";
        private static final String DIMENSION_SERVICE_NAME = "serviceName";
        private static final String DIMENSION_TYPE = "type";
        private static final String MEASURE_COST_TIME = "costTime";
        private static final String MEASURE_DATA_SIZE = "dataSize";
        private static final String MEASURE_INVOKE_TIME = "invokeTime";
        private static final String MONITOR_POINT = "ipcState";
        private static boolean isRegistered = false;
        private long costTime;
        private long dataSize;
        private int degrade;
        private long invokeTime;
        private String methodName;
        private int result;
        private String serviceName;
        private int type;

        public IpcState(int i2) {
            this.type = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean register() {
            if (!IPCMonitor.isAppMonitorValid) {
                return false;
            }
            synchronized (this) {
                if (isRegistered) {
                    return true;
                }
                try {
                    DimensionSet dimensionSetCreate = DimensionSet.create();
                    dimensionSetCreate.addDimension("type");
                    dimensionSetCreate.addDimension(DIMENSION_DEGRADE);
                    dimensionSetCreate.addDimension("result");
                    dimensionSetCreate.addDimension(DIMENSION_SERVICE_NAME);
                    dimensionSetCreate.addDimension(DIMENSION_METHOD_NAME);
                    MeasureSet measureSetCreate = MeasureSet.create();
                    measureSetCreate.addMeasure(MEASURE_COST_TIME);
                    measureSetCreate.addMeasure(MEASURE_INVOKE_TIME);
                    measureSetCreate.addMeasure(MEASURE_DATA_SIZE);
                    AppMonitor.register(IPCMonitor.MODULE_NAME, MONITOR_POINT, measureSetCreate, dimensionSetCreate, true);
                    isRegistered = true;
                } catch (Exception e2) {
                    IPCLog.e(IPCMonitor.TAG, "[register][AppMonitor register]", e2, new Object[0]);
                }
                return isRegistered;
            }
        }

        public void commit() {
            if (IPCMonitor.isAppMonitorValid) {
                IPCThreadCaller.post(false, new Runnable() { // from class: com.taobao.aranger.mit.IPCMonitor.IpcState.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (IpcState.this.register()) {
                            IPCLog.i(IPCMonitor.TAG, "[commit]", "IpcState", IpcState.this.toString());
                            try {
                                DimensionValueSet dimensionValueSetCreate = DimensionValueSet.create();
                                dimensionValueSetCreate.setValue("type", String.valueOf(IpcState.this.type));
                                dimensionValueSetCreate.setValue(IpcState.DIMENSION_DEGRADE, String.valueOf(IpcState.this.degrade));
                                dimensionValueSetCreate.setValue("result", String.valueOf(IpcState.this.result));
                                dimensionValueSetCreate.setValue(IpcState.DIMENSION_SERVICE_NAME, IpcState.this.serviceName);
                                dimensionValueSetCreate.setValue(IpcState.DIMENSION_METHOD_NAME, IpcState.this.methodName);
                                MeasureValueSet measureValueSetCreate = MeasureValueSet.create();
                                measureValueSetCreate.setValue(IpcState.MEASURE_COST_TIME, IpcState.this.costTime);
                                measureValueSetCreate.setValue(IpcState.MEASURE_INVOKE_TIME, IpcState.this.invokeTime);
                                measureValueSetCreate.setValue(IpcState.MEASURE_DATA_SIZE, IpcState.this.dataSize);
                                AppMonitor.Stat.commit(IPCMonitor.MODULE_NAME, IpcState.MONITOR_POINT, dimensionValueSetCreate, measureValueSetCreate);
                            } catch (Exception e2) {
                                IPCLog.e(IPCMonitor.TAG, "[commit][AppMonitor Stat commit]", e2, new Object[0]);
                            }
                        }
                    }
                });
            }
        }

        public void setCostTime(long j2) {
            this.costTime = j2;
        }

        public void setDataSize(long j2) {
            this.dataSize = j2;
        }

        public void setDegrade(boolean z2) {
            this.degrade = z2 ? 1 : 0;
        }

        public void setInvokeTime(long j2) {
            this.invokeTime = j2;
        }

        public void setMethodName(String str) {
            this.methodName = str;
        }

        public void setResult(int i2) {
            this.result = i2;
        }

        public void setServiceName(String str) {
            this.serviceName = str;
        }

        public String toString() {
            return "IpcState{serviceName='" + this.serviceName + "', methodName='" + this.methodName + "', type=" + this.type + ", result=" + this.result + ", degrade=" + this.degrade + ", costTime=" + this.costTime + ", invokeTime=" + this.invokeTime + ", dataSize=" + this.dataSize + '}';
        }
    }

    static {
        try {
            Class.forName("com.alibaba.mtl.appmonitor.AppMonitor");
            isAppMonitorValid = true;
        } catch (Exception unused) {
            isAppMonitorValid = false;
        }
    }
}
