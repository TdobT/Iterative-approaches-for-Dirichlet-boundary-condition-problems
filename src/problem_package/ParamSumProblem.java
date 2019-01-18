package problem_package;

import data_structure_package.ParamFunctionInterface;

public class ParamSumProblem extends LaplaceProblem {

	
	public ParamSumProblem(int height, int length) {
		super(height, length, paramSumFunction());
	}
	
	
	
	protected ParamSumProblem(ParamSumProblem p) {
		super(p);
	}



	public static ParamFunctionInterface paramSumFunction() {

		return new ParamFunctionInterface() {

			@Override
			public double evaluateFunction(double iPos, double jPos) {
				if (iPos == 0 || 
						jPos == 0 ||
						iPos >= 1 || 
						jPos >= 1) return iPos + jPos;
				return 0;
			}
		};
	}
	
	
	
	public static ParamFunctionInterface sumResultFunction() {
		return (i, j) -> i + j;
	}
	
	
	
	public BoundarySolution generateRightSolution(int height, int length) {
				
		return new BoundarySolution(
						height,
						length,
						sumResultFunction(), 
						(i, j) -> 0);
	}
	
	

	@Override
	public BoundaryProblem clone() {
		return new ParamSumProblem(this);
	}

}
