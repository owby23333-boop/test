package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class LinearSystem {
    public static long ARRAY_ROW_CREATION = 0;
    public static final boolean DEBUG = false;
    private static final boolean DEBUG_CONSTRAINTS = false;
    public static final boolean FULL_DEBUG = false;
    public static final boolean MEASURE = false;
    public static long OPTIMIZED_ARRAY_ROW_CREATION = 0;
    public static boolean OPTIMIZED_ENGINE = true;
    private static int POOL_SIZE = 1000;
    static final boolean SIMPLIFY_SYNONYMS = false;
    private static final boolean USE_SYNONYMS = true;
    public static Metrics sMetrics;
    public boolean graphOptimizer;
    private boolean[] mAlreadyTestedCandidates;
    final Cache mCache;
    private Row mGoal;
    private int mMaxColumns;
    private int mMaxRows;
    int mNumColumns;
    int mNumRows;
    private SolverVariable[] mPoolVariables;
    private int mPoolVariablesCount;
    ArrayRow[] mRows;
    private Row mTempGoal;
    public boolean newgraphOptimizer;
    int mVariablesID = 0;
    private HashMap<String, SolverVariable> mVariables = null;
    private int TABLE_SIZE = 32;

    interface Row {
        void addError(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr);

        void initFromRow(Row row);

        boolean isEmpty();

        void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z2);

        void updateFromRow(ArrayRow arrayRow, boolean z2);

        void updateFromSystem(LinearSystem linearSystem);
    }

    class ValuesRow extends ArrayRow {
        public ValuesRow(Cache cache) {
            this.variables = new SolverVariableValues(this, cache);
        }
    }

    public LinearSystem() {
        int i2 = this.TABLE_SIZE;
        this.mMaxColumns = i2;
        this.mRows = null;
        this.graphOptimizer = false;
        this.newgraphOptimizer = false;
        this.mAlreadyTestedCandidates = new boolean[i2];
        this.mNumColumns = 1;
        this.mNumRows = 0;
        this.mMaxRows = i2;
        this.mPoolVariables = new SolverVariable[POOL_SIZE];
        this.mPoolVariablesCount = 0;
        this.mRows = new ArrayRow[i2];
        releaseRows();
        this.mCache = new Cache();
        this.mGoal = new PriorityGoalRow(this.mCache);
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(this.mCache);
        } else {
            this.mTempGoal = new ArrayRow(this.mCache);
        }
    }

    private SolverVariable acquireSolverVariable(SolverVariable.Type type, String str) {
        SolverVariable solverVariableAcquire = this.mCache.solverVariablePool.acquire();
        if (solverVariableAcquire == null) {
            solverVariableAcquire = new SolverVariable(type, str);
            solverVariableAcquire.setType(type, str);
        } else {
            solverVariableAcquire.reset();
            solverVariableAcquire.setType(type, str);
        }
        int i2 = this.mPoolVariablesCount;
        int i3 = POOL_SIZE;
        if (i2 >= i3) {
            POOL_SIZE = i3 * 2;
            this.mPoolVariables = (SolverVariable[]) Arrays.copyOf(this.mPoolVariables, POOL_SIZE);
        }
        SolverVariable[] solverVariableArr = this.mPoolVariables;
        int i4 = this.mPoolVariablesCount;
        this.mPoolVariablesCount = i4 + 1;
        solverVariableArr[i4] = solverVariableAcquire;
        return solverVariableAcquire;
    }

    private void addError(ArrayRow arrayRow) {
        arrayRow.addError(this, 0);
    }

    private final void addRow(ArrayRow arrayRow) {
        if (OPTIMIZED_ENGINE) {
            ArrayRow[] arrayRowArr = this.mRows;
            int i2 = this.mNumRows;
            if (arrayRowArr[i2] != null) {
                this.mCache.optimizedArrayRowPool.release(arrayRowArr[i2]);
            }
        } else {
            ArrayRow[] arrayRowArr2 = this.mRows;
            int i3 = this.mNumRows;
            if (arrayRowArr2[i3] != null) {
                this.mCache.arrayRowPool.release(arrayRowArr2[i3]);
            }
        }
        ArrayRow[] arrayRowArr3 = this.mRows;
        int i4 = this.mNumRows;
        arrayRowArr3[i4] = arrayRow;
        SolverVariable solverVariable = arrayRow.variable;
        solverVariable.definitionId = i4;
        this.mNumRows = i4 + 1;
        solverVariable.updateReferencesWithNewDefinition(arrayRow);
    }

    private void addSingleError(ArrayRow arrayRow, int i2) {
        addSingleError(arrayRow, i2, 0);
    }

    private void computeValues() {
        for (int i2 = 0; i2 < this.mNumRows; i2++) {
            ArrayRow arrayRow = this.mRows[i2];
            arrayRow.variable.computedValue = arrayRow.constantValue;
        }
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, float f2) {
        return linearSystem.createRow().createRowDimensionPercent(solverVariable, solverVariable2, f2);
    }

    private SolverVariable createVariable(String str, SolverVariable.Type type) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.variables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable solverVariableAcquireSolverVariable = acquireSolverVariable(type, null);
        solverVariableAcquireSolverVariable.setName(str);
        this.mVariablesID++;
        this.mNumColumns++;
        solverVariableAcquireSolverVariable.id = this.mVariablesID;
        if (this.mVariables == null) {
            this.mVariables = new HashMap<>();
        }
        this.mVariables.put(str, solverVariableAcquireSolverVariable);
        this.mCache.mIndexedVariables[this.mVariablesID] = solverVariableAcquireSolverVariable;
        return solverVariableAcquireSolverVariable;
    }

    private void displayRows() {
        displaySolverVariables();
        String str = "";
        for (int i2 = 0; i2 < this.mNumRows; i2++) {
            str = (str + this.mRows[i2]) + "\n";
        }
        System.out.println(str + this.mGoal + "\n");
    }

    private void displaySolverVariables() {
        System.out.println("Display Rows (" + this.mNumRows + "x" + this.mNumColumns + ")\n");
    }

    private int enforceBFS(Row row) throws Exception {
        float f2;
        boolean z2;
        int i2 = 0;
        while (true) {
            f2 = 0.0f;
            if (i2 >= this.mNumRows) {
                z2 = false;
                break;
            }
            ArrayRow[] arrayRowArr = this.mRows;
            if (arrayRowArr[i2].variable.mType != SolverVariable.Type.UNRESTRICTED && arrayRowArr[i2].constantValue < 0.0f) {
                z2 = true;
                break;
            }
            i2++;
        }
        if (!z2) {
            return 0;
        }
        boolean z3 = false;
        int i3 = 0;
        while (!z3) {
            Metrics metrics = sMetrics;
            if (metrics != null) {
                metrics.bfs++;
            }
            i3++;
            int i4 = 0;
            int i5 = -1;
            int i6 = -1;
            float f3 = Float.MAX_VALUE;
            int i7 = 0;
            while (i4 < this.mNumRows) {
                ArrayRow arrayRow = this.mRows[i4];
                if (arrayRow.variable.mType != SolverVariable.Type.UNRESTRICTED && !arrayRow.isSimpleDefinition && arrayRow.constantValue < f2) {
                    int i8 = 1;
                    while (i8 < this.mNumColumns) {
                        SolverVariable solverVariable = this.mCache.mIndexedVariables[i8];
                        float f4 = arrayRow.variables.get(solverVariable);
                        if (f4 > f2) {
                            int i9 = i7;
                            float f5 = f3;
                            int i10 = i6;
                            int i11 = i5;
                            for (int i12 = 0; i12 < 9; i12++) {
                                float f6 = solverVariable.strengthVector[i12] / f4;
                                if ((f6 < f5 && i12 == i9) || i12 > i9) {
                                    i10 = i8;
                                    i11 = i4;
                                    f5 = f6;
                                    i9 = i12;
                                }
                            }
                            i5 = i11;
                            i6 = i10;
                            f3 = f5;
                            i7 = i9;
                        }
                        i8++;
                        f2 = 0.0f;
                    }
                }
                i4++;
                f2 = 0.0f;
            }
            if (i5 != -1) {
                ArrayRow arrayRow2 = this.mRows[i5];
                arrayRow2.variable.definitionId = -1;
                Metrics metrics2 = sMetrics;
                if (metrics2 != null) {
                    metrics2.pivots++;
                }
                arrayRow2.pivot(this.mCache.mIndexedVariables[i6]);
                SolverVariable solverVariable2 = arrayRow2.variable;
                solverVariable2.definitionId = i5;
                solverVariable2.updateReferencesWithNewDefinition(arrayRow2);
            } else {
                z3 = true;
            }
            if (i3 > this.mNumColumns / 2) {
                z3 = true;
            }
            f2 = 0.0f;
        }
        return i3;
    }

    private String getDisplaySize(int i2) {
        int i3 = i2 * 4;
        int i4 = i3 / 1024;
        int i5 = i4 / 1024;
        if (i5 > 0) {
            return "" + i5 + " Mb";
        }
        if (i4 > 0) {
            return "" + i4 + " Kb";
        }
        return "" + i3 + " bytes";
    }

    private String getDisplayStrength(int i2) {
        return i2 == 1 ? "LOW" : i2 == 2 ? "MEDIUM" : i2 == 3 ? "HIGH" : i2 == 4 ? "HIGHEST" : i2 == 5 ? "EQUALITY" : i2 == 8 ? "FIXED" : i2 == 6 ? "BARRIER" : "NONE";
    }

    public static Metrics getMetrics() {
        return sMetrics;
    }

    private void increaseTableSize() {
        this.TABLE_SIZE *= 2;
        this.mRows = (ArrayRow[]) Arrays.copyOf(this.mRows, this.TABLE_SIZE);
        Cache cache = this.mCache;
        cache.mIndexedVariables = (SolverVariable[]) Arrays.copyOf(cache.mIndexedVariables, this.TABLE_SIZE);
        int i2 = this.TABLE_SIZE;
        this.mAlreadyTestedCandidates = new boolean[i2];
        this.mMaxColumns = i2;
        this.mMaxRows = i2;
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.tableSizeIncrease++;
            metrics.maxTableSize = Math.max(metrics.maxTableSize, i2);
            Metrics metrics2 = sMetrics;
            metrics2.lastTableSize = metrics2.maxTableSize;
        }
    }

    private final int optimize(Row row, boolean z2) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.optimize++;
        }
        for (int i2 = 0; i2 < this.mNumColumns; i2++) {
            this.mAlreadyTestedCandidates[i2] = false;
        }
        boolean z3 = false;
        int i3 = 0;
        while (!z3) {
            Metrics metrics2 = sMetrics;
            if (metrics2 != null) {
                metrics2.iterations++;
            }
            i3++;
            if (i3 >= this.mNumColumns * 2) {
                return i3;
            }
            if (row.getKey() != null) {
                this.mAlreadyTestedCandidates[row.getKey().id] = true;
            }
            SolverVariable pivotCandidate = row.getPivotCandidate(this, this.mAlreadyTestedCandidates);
            if (pivotCandidate != null) {
                boolean[] zArr = this.mAlreadyTestedCandidates;
                int i4 = pivotCandidate.id;
                if (zArr[i4]) {
                    return i3;
                }
                zArr[i4] = true;
            }
            if (pivotCandidate != null) {
                int i5 = -1;
                float f2 = Float.MAX_VALUE;
                for (int i6 = 0; i6 < this.mNumRows; i6++) {
                    ArrayRow arrayRow = this.mRows[i6];
                    if (arrayRow.variable.mType != SolverVariable.Type.UNRESTRICTED && !arrayRow.isSimpleDefinition && arrayRow.hasVariable(pivotCandidate)) {
                        float f3 = arrayRow.variables.get(pivotCandidate);
                        if (f3 < 0.0f) {
                            float f4 = (-arrayRow.constantValue) / f3;
                            if (f4 < f2) {
                                i5 = i6;
                                f2 = f4;
                            }
                        }
                    }
                }
                if (i5 > -1) {
                    ArrayRow arrayRow2 = this.mRows[i5];
                    arrayRow2.variable.definitionId = -1;
                    Metrics metrics3 = sMetrics;
                    if (metrics3 != null) {
                        metrics3.pivots++;
                    }
                    arrayRow2.pivot(pivotCandidate);
                    SolverVariable solverVariable = arrayRow2.variable;
                    solverVariable.definitionId = i5;
                    solverVariable.updateReferencesWithNewDefinition(arrayRow2);
                }
            } else {
                z3 = true;
            }
        }
        return i3;
    }

    private void releaseRows() {
        int i2 = 0;
        if (OPTIMIZED_ENGINE) {
            while (true) {
                ArrayRow[] arrayRowArr = this.mRows;
                if (i2 >= arrayRowArr.length) {
                    return;
                }
                ArrayRow arrayRow = arrayRowArr[i2];
                if (arrayRow != null) {
                    this.mCache.optimizedArrayRowPool.release(arrayRow);
                }
                this.mRows[i2] = null;
                i2++;
            }
        } else {
            while (true) {
                ArrayRow[] arrayRowArr2 = this.mRows;
                if (i2 >= arrayRowArr2.length) {
                    return;
                }
                ArrayRow arrayRow2 = arrayRowArr2[i2];
                if (arrayRow2 != null) {
                    this.mCache.arrayRowPool.release(arrayRow2);
                }
                this.mRows[i2] = null;
                i2++;
            }
        }
    }

    public void addCenterPoint(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f2, int i2) {
        SolverVariable solverVariableCreateObjectVariable = createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT));
        SolverVariable solverVariableCreateObjectVariable2 = createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.TOP));
        SolverVariable solverVariableCreateObjectVariable3 = createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT));
        SolverVariable solverVariableCreateObjectVariable4 = createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM));
        SolverVariable solverVariableCreateObjectVariable5 = createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT));
        SolverVariable solverVariableCreateObjectVariable6 = createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP));
        SolverVariable solverVariableCreateObjectVariable7 = createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT));
        SolverVariable solverVariableCreateObjectVariable8 = createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM));
        ArrayRow arrayRowCreateRow = createRow();
        double d2 = f2;
        double dSin = Math.sin(d2);
        double d3 = i2;
        Double.isNaN(d3);
        arrayRowCreateRow.createRowWithAngle(solverVariableCreateObjectVariable2, solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable6, solverVariableCreateObjectVariable8, (float) (dSin * d3));
        addConstraint(arrayRowCreateRow);
        ArrayRow arrayRowCreateRow2 = createRow();
        double dCos = Math.cos(d2);
        Double.isNaN(d3);
        arrayRowCreateRow2.createRowWithAngle(solverVariableCreateObjectVariable, solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, solverVariableCreateObjectVariable7, (float) (dCos * d3));
        addConstraint(arrayRowCreateRow2);
    }

    public void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, float f2, SolverVariable solverVariable3, SolverVariable solverVariable4, int i3, int i4) {
        ArrayRow arrayRowCreateRow = createRow();
        arrayRowCreateRow.createRowCentering(solverVariable, solverVariable2, i2, f2, solverVariable3, solverVariable4, i3);
        if (i4 != 8) {
            arrayRowCreateRow.addError(this, i4);
        }
        addConstraint(arrayRowCreateRow);
    }

    public void addConstraint(ArrayRow arrayRow) {
        SolverVariable solverVariablePickPivot;
        if (arrayRow == null) {
            return;
        }
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.constraints++;
            if (arrayRow.isSimpleDefinition) {
                metrics.simpleconstraints++;
            }
        }
        if (this.mNumRows + 1 >= this.mMaxRows || this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        boolean z2 = false;
        if (!arrayRow.isSimpleDefinition) {
            arrayRow.updateFromSystem(this);
            if (arrayRow.isEmpty()) {
                return;
            }
            arrayRow.ensurePositiveConstant();
            if (arrayRow.chooseSubject(this)) {
                SolverVariable solverVariableCreateExtraVariable = createExtraVariable();
                arrayRow.variable = solverVariableCreateExtraVariable;
                addRow(arrayRow);
                this.mTempGoal.initFromRow(arrayRow);
                optimize(this.mTempGoal, true);
                if (solverVariableCreateExtraVariable.definitionId == -1) {
                    if (arrayRow.variable == solverVariableCreateExtraVariable && (solverVariablePickPivot = arrayRow.pickPivot(solverVariableCreateExtraVariable)) != null) {
                        Metrics metrics2 = sMetrics;
                        if (metrics2 != null) {
                            metrics2.pivots++;
                        }
                        arrayRow.pivot(solverVariablePickPivot);
                    }
                    if (!arrayRow.isSimpleDefinition) {
                        arrayRow.variable.updateReferencesWithNewDefinition(arrayRow);
                    }
                    this.mNumRows--;
                }
                z2 = true;
            }
            if (!arrayRow.hasKeyVariable()) {
                return;
            }
        }
        if (z2) {
            return;
        }
        addRow(arrayRow);
    }

    public ArrayRow addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        if (i3 == 8 && solverVariable2.isFinalValue && solverVariable.definitionId == -1) {
            solverVariable.setFinalValue(this, solverVariable2.computedValue + i2);
            return null;
        }
        ArrayRow arrayRowCreateRow = createRow();
        arrayRowCreateRow.createRowEquals(solverVariable, solverVariable2, i2);
        if (i3 != 8) {
            arrayRowCreateRow.addError(this, i3);
        }
        addConstraint(arrayRowCreateRow);
        return arrayRowCreateRow;
    }

    public void addGreaterBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, boolean z2) {
        ArrayRow arrayRowCreateRow = createRow();
        SolverVariable solverVariableCreateSlackVariable = createSlackVariable();
        solverVariableCreateSlackVariable.strength = 0;
        arrayRowCreateRow.createRowGreaterThan(solverVariable, solverVariable2, solverVariableCreateSlackVariable, i2);
        addConstraint(arrayRowCreateRow);
    }

    public void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        ArrayRow arrayRowCreateRow = createRow();
        SolverVariable solverVariableCreateSlackVariable = createSlackVariable();
        solverVariableCreateSlackVariable.strength = 0;
        arrayRowCreateRow.createRowGreaterThan(solverVariable, solverVariable2, solverVariableCreateSlackVariable, i2);
        if (i3 != 8) {
            addSingleError(arrayRowCreateRow, (int) (arrayRowCreateRow.variables.get(solverVariableCreateSlackVariable) * (-1.0f)), i3);
        }
        addConstraint(arrayRowCreateRow);
    }

    public void addLowerBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, boolean z2) {
        ArrayRow arrayRowCreateRow = createRow();
        SolverVariable solverVariableCreateSlackVariable = createSlackVariable();
        solverVariableCreateSlackVariable.strength = 0;
        arrayRowCreateRow.createRowLowerThan(solverVariable, solverVariable2, solverVariableCreateSlackVariable, i2);
        addConstraint(arrayRowCreateRow);
    }

    public void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        ArrayRow arrayRowCreateRow = createRow();
        SolverVariable solverVariableCreateSlackVariable = createSlackVariable();
        solverVariableCreateSlackVariable.strength = 0;
        arrayRowCreateRow.createRowLowerThan(solverVariable, solverVariable2, solverVariableCreateSlackVariable, i2);
        if (i3 != 8) {
            addSingleError(arrayRowCreateRow, (int) (arrayRowCreateRow.variables.get(solverVariableCreateSlackVariable) * (-1.0f)), i3);
        }
        addConstraint(arrayRowCreateRow);
    }

    public void addRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2, int i2) {
        ArrayRow arrayRowCreateRow = createRow();
        arrayRowCreateRow.createRowDimensionRatio(solverVariable, solverVariable2, solverVariable3, solverVariable4, f2);
        if (i2 != 8) {
            arrayRowCreateRow.addError(this, i2);
        }
        addConstraint(arrayRowCreateRow);
    }

    final void cleanupRows() {
        int i2;
        int i3 = 0;
        while (i3 < this.mNumRows) {
            ArrayRow arrayRow = this.mRows[i3];
            if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.isSimpleDefinition = true;
            }
            if (arrayRow.isSimpleDefinition) {
                SolverVariable solverVariable = arrayRow.variable;
                solverVariable.computedValue = arrayRow.constantValue;
                solverVariable.removeFromRow(arrayRow);
                int i4 = i3;
                while (true) {
                    i2 = this.mNumRows;
                    if (i4 >= i2 - 1) {
                        break;
                    }
                    ArrayRow[] arrayRowArr = this.mRows;
                    int i5 = i4 + 1;
                    arrayRowArr[i4] = arrayRowArr[i5];
                    i4 = i5;
                }
                this.mRows[i2 - 1] = null;
                this.mNumRows = i2 - 1;
                i3--;
            }
            i3++;
        }
    }

    public SolverVariable createErrorVariable(int i2, String str) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.errors++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable solverVariableAcquireSolverVariable = acquireSolverVariable(SolverVariable.Type.ERROR, str);
        this.mVariablesID++;
        this.mNumColumns++;
        int i3 = this.mVariablesID;
        solverVariableAcquireSolverVariable.id = i3;
        solverVariableAcquireSolverVariable.strength = i2;
        this.mCache.mIndexedVariables[i3] = solverVariableAcquireSolverVariable;
        this.mGoal.addError(solverVariableAcquireSolverVariable);
        return solverVariableAcquireSolverVariable;
    }

    public SolverVariable createExtraVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.extravariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable solverVariableAcquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        this.mVariablesID++;
        this.mNumColumns++;
        int i2 = this.mVariablesID;
        solverVariableAcquireSolverVariable.id = i2;
        this.mCache.mIndexedVariables[i2] = solverVariableAcquireSolverVariable;
        return solverVariableAcquireSolverVariable;
    }

    public SolverVariable createObjectVariable(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.getSolverVariable();
            if (solverVariable == null) {
                constraintAnchor.resetSolverVariable(this.mCache);
                solverVariable = constraintAnchor.getSolverVariable();
            }
            int i2 = solverVariable.id;
            if (i2 == -1 || i2 > this.mVariablesID || this.mCache.mIndexedVariables[i2] == null) {
                if (solverVariable.id != -1) {
                    solverVariable.reset();
                }
                this.mVariablesID++;
                this.mNumColumns++;
                int i3 = this.mVariablesID;
                solverVariable.id = i3;
                solverVariable.mType = SolverVariable.Type.UNRESTRICTED;
                this.mCache.mIndexedVariables[i3] = solverVariable;
            }
        }
        return solverVariable;
    }

    public ArrayRow createRow() {
        ArrayRow arrayRowAcquire;
        if (OPTIMIZED_ENGINE) {
            arrayRowAcquire = this.mCache.optimizedArrayRowPool.acquire();
            if (arrayRowAcquire == null) {
                arrayRowAcquire = new ValuesRow(this.mCache);
                OPTIMIZED_ARRAY_ROW_CREATION++;
            } else {
                arrayRowAcquire.reset();
            }
        } else {
            arrayRowAcquire = this.mCache.arrayRowPool.acquire();
            if (arrayRowAcquire == null) {
                arrayRowAcquire = new ArrayRow(this.mCache);
                ARRAY_ROW_CREATION++;
            } else {
                arrayRowAcquire.reset();
            }
        }
        SolverVariable.increaseErrorId();
        return arrayRowAcquire;
    }

    public SolverVariable createSlackVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.slackvariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable solverVariableAcquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        this.mVariablesID++;
        this.mNumColumns++;
        int i2 = this.mVariablesID;
        solverVariableAcquireSolverVariable.id = i2;
        this.mCache.mIndexedVariables[i2] = solverVariableAcquireSolverVariable;
        return solverVariableAcquireSolverVariable;
    }

    public void displayReadableRows() {
        displaySolverVariables();
        String str = "";
        for (int i2 = 0; i2 < this.mVariablesID; i2++) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[i2];
            if (solverVariable != null && solverVariable.isFinalValue) {
                str = str + " $[" + i2 + "] => " + solverVariable + " = " + solverVariable.computedValue + "\n";
            }
        }
        String str2 = str + "\n\n #  ";
        for (int i3 = 0; i3 < this.mNumRows; i3++) {
            str2 = (str2 + this.mRows[i3].toReadableString()) + "\n #  ";
        }
        if (this.mGoal != null) {
            str2 = str2 + "Goal: " + this.mGoal + "\n";
        }
        System.out.println(str2);
    }

    void displaySystemInformations() {
        int iSizeInBytes = 0;
        for (int i2 = 0; i2 < this.TABLE_SIZE; i2++) {
            ArrayRow[] arrayRowArr = this.mRows;
            if (arrayRowArr[i2] != null) {
                iSizeInBytes += arrayRowArr[i2].sizeInBytes();
            }
        }
        int iSizeInBytes2 = 0;
        for (int i3 = 0; i3 < this.mNumRows; i3++) {
            ArrayRow[] arrayRowArr2 = this.mRows;
            if (arrayRowArr2[i3] != null) {
                iSizeInBytes2 += arrayRowArr2[i3].sizeInBytes();
            }
        }
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder();
        sb.append("Linear System -> Table size: ");
        sb.append(this.TABLE_SIZE);
        sb.append(" (");
        int i4 = this.TABLE_SIZE;
        sb.append(getDisplaySize(i4 * i4));
        sb.append(") -- row sizes: ");
        sb.append(getDisplaySize(iSizeInBytes));
        sb.append(", actual size: ");
        sb.append(getDisplaySize(iSizeInBytes2));
        sb.append(" rows: ");
        sb.append(this.mNumRows);
        sb.append("/");
        sb.append(this.mMaxRows);
        sb.append(" cols: ");
        sb.append(this.mNumColumns);
        sb.append("/");
        sb.append(this.mMaxColumns);
        sb.append(" ");
        sb.append(0);
        sb.append(" occupied cells, ");
        sb.append(getDisplaySize(0));
        printStream.println(sb.toString());
    }

    public void displayVariablesReadableRows() {
        displaySolverVariables();
        String str = "";
        for (int i2 = 0; i2 < this.mNumRows; i2++) {
            if (this.mRows[i2].variable.mType == SolverVariable.Type.UNRESTRICTED) {
                str = (str + this.mRows[i2].toReadableString()) + "\n";
            }
        }
        System.out.println(str + this.mGoal + "\n");
    }

    public void fillMetrics(Metrics metrics) {
        sMetrics = metrics;
    }

    public Cache getCache() {
        return this.mCache;
    }

    Row getGoal() {
        return this.mGoal;
    }

    public int getMemoryUsed() {
        int iSizeInBytes = 0;
        for (int i2 = 0; i2 < this.mNumRows; i2++) {
            ArrayRow[] arrayRowArr = this.mRows;
            if (arrayRowArr[i2] != null) {
                iSizeInBytes += arrayRowArr[i2].sizeInBytes();
            }
        }
        return iSizeInBytes;
    }

    public int getNumEquations() {
        return this.mNumRows;
    }

    public int getNumVariables() {
        return this.mVariablesID;
    }

    public int getObjectVariableValue(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).getSolverVariable();
        if (solverVariable != null) {
            return (int) (solverVariable.computedValue + 0.5f);
        }
        return 0;
    }

    ArrayRow getRow(int i2) {
        return this.mRows[i2];
    }

    float getValueFor(String str) {
        SolverVariable variable = getVariable(str, SolverVariable.Type.UNRESTRICTED);
        if (variable == null) {
            return 0.0f;
        }
        return variable.computedValue;
    }

    SolverVariable getVariable(String str, SolverVariable.Type type) {
        if (this.mVariables == null) {
            this.mVariables = new HashMap<>();
        }
        SolverVariable solverVariable = this.mVariables.get(str);
        return solverVariable == null ? createVariable(str, type) : solverVariable;
    }

    public void minimize() throws Exception {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimize++;
        }
        if (!this.graphOptimizer && !this.newgraphOptimizer) {
            minimizeGoal(this.mGoal);
            return;
        }
        Metrics metrics2 = sMetrics;
        if (metrics2 != null) {
            metrics2.graphOptimizer++;
        }
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= this.mNumRows) {
                z2 = true;
                break;
            } else if (!this.mRows[i2].isSimpleDefinition) {
                break;
            } else {
                i2++;
            }
        }
        if (!z2) {
            minimizeGoal(this.mGoal);
            return;
        }
        Metrics metrics3 = sMetrics;
        if (metrics3 != null) {
            metrics3.fullySolved++;
        }
        computeValues();
    }

    void minimizeGoal(Row row) throws Exception {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimizeGoal++;
            metrics.maxVariables = Math.max(metrics.maxVariables, this.mNumColumns);
            Metrics metrics2 = sMetrics;
            metrics2.maxRows = Math.max(metrics2.maxRows, this.mNumRows);
        }
        enforceBFS(row);
        optimize(row, false);
        computeValues();
    }

    public void removeRow(ArrayRow arrayRow) {
        SolverVariable solverVariable;
        int i2;
        if (!arrayRow.isSimpleDefinition || (solverVariable = arrayRow.variable) == null) {
            return;
        }
        int i3 = solverVariable.definitionId;
        if (i3 != -1) {
            while (true) {
                i2 = this.mNumRows;
                if (i3 >= i2 - 1) {
                    break;
                }
                ArrayRow[] arrayRowArr = this.mRows;
                int i4 = i3 + 1;
                arrayRowArr[i3] = arrayRowArr[i4];
                i3 = i4;
            }
            this.mNumRows = i2 - 1;
        }
        arrayRow.variable.setFinalValue(this, arrayRow.constantValue);
    }

    public void reset() {
        Cache cache;
        int i2 = 0;
        while (true) {
            cache = this.mCache;
            SolverVariable[] solverVariableArr = cache.mIndexedVariables;
            if (i2 >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i2];
            if (solverVariable != null) {
                solverVariable.reset();
            }
            i2++;
        }
        cache.solverVariablePool.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
        this.mPoolVariablesCount = 0;
        Arrays.fill(this.mCache.mIndexedVariables, (Object) null);
        HashMap<String, SolverVariable> map = this.mVariables;
        if (map != null) {
            map.clear();
        }
        this.mVariablesID = 0;
        this.mGoal.clear();
        this.mNumColumns = 1;
        for (int i3 = 0; i3 < this.mNumRows; i3++) {
            this.mRows[i3].used = false;
        }
        releaseRows();
        this.mNumRows = 0;
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(this.mCache);
        } else {
            this.mTempGoal = new ArrayRow(this.mCache);
        }
    }

    void addSingleError(ArrayRow arrayRow, int i2, int i3) {
        arrayRow.addSingleError(createErrorVariable(i3, null), i2);
    }

    public void addEquality(SolverVariable solverVariable, int i2) {
        int i3 = solverVariable.definitionId;
        if (i3 == -1) {
            solverVariable.setFinalValue(this, i2);
            return;
        }
        if (i3 != -1) {
            ArrayRow arrayRow = this.mRows[i3];
            if (arrayRow.isSimpleDefinition) {
                arrayRow.constantValue = i2;
                return;
            }
            if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.isSimpleDefinition = true;
                arrayRow.constantValue = i2;
                return;
            } else {
                ArrayRow arrayRowCreateRow = createRow();
                arrayRowCreateRow.createRowEquals(solverVariable, i2);
                addConstraint(arrayRowCreateRow);
                return;
            }
        }
        ArrayRow arrayRowCreateRow2 = createRow();
        arrayRowCreateRow2.createRowDefinition(solverVariable, i2);
        addConstraint(arrayRowCreateRow2);
    }
}
