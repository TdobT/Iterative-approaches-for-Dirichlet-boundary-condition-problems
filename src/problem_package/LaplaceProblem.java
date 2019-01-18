package problem_package;

import data_structure_package.Matrix;
import data_structure_package.ParamFunctionInterface;

public abstract class LaplaceProblem extends BoundaryProblem {

	
	public LaplaceProblem(int height, int length, ParamFunctionInterface f) {

		super(new Matrix(
					height, 
					length, 
					f),
				(i, j) -> 0);
	}

	
	public LaplaceProblem(LaplaceProblem p) {
		super(p);
	}

}
