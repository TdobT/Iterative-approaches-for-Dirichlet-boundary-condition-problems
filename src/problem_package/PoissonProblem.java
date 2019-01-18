package problem_package;

import data_structure_package.Matrix;
import data_structure_package.ParamFunctionInterface;

public abstract class PoissonProblem extends BoundaryProblem {

	
	public PoissonProblem(int height, int length, ParamFunctionInterface f) {

		super(new Matrix(height, length), f);
	}

	
	public PoissonProblem(PoissonProblem p) {
		super(p);
	}

}
