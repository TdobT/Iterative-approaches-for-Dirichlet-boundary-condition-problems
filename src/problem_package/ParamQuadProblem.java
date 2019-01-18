package problem_package;

import data_structure_package.ParamFunctionInterface;

public class ParamQuadProblem extends LaplaceProblem {

	
	public ParamQuadProblem(int height, int length) {
		super(height, length, paramQuadFunction());
	}

	
	
	protected ParamQuadProblem(ParamQuadProblem p) {
		super(p);
	}



	public static ParamFunctionInterface paramQuadFunction() {

		return new ParamFunctionInterface() {

			@Override
			public double evaluateFunction(double iPos, double jPos) {
				if (iPos == 0 || 
						jPos == 0 ||
						iPos >= 1 || 
						jPos >= 1) return (iPos*iPos) - (jPos*jPos);
				return 0;
			}
		};
	}
	
	
	
	public static ParamFunctionInterface quadResultFunction() {
		return (i, j) -> i*i - j*j;
	}
	
	
	
	public BoundarySolution generateRightSolution(int height, int length) {
				
		return new BoundarySolution(
						height,
						length,
						quadResultFunction(), 
						(i, j) -> 0);
	}
	
	

	@Override
	public BoundaryProblem clone() {
		return new ParamQuadProblem(this);
	}
}
