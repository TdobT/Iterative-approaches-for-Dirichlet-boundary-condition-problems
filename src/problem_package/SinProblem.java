package problem_package;

import data_structure_package.ParamFunctionInterface;

public class SinProblem extends PoissonProblem {

	public SinProblem(int height, int length) {
		
		super(height, length, sinTargetFunction());
	}

	
	public SinProblem(SinProblem p) {
		super(p);
	}
	
	

	public static ParamFunctionInterface sinTargetFunction() {

		return (i, j) -> 
			2 * Math.PI * Math.PI *
			Math.sin(Math.PI * i) *
			Math.sin(Math.PI * j);
	}

	
	
	public static ParamFunctionInterface sinResultFunction() {
		return (i, j) -> Math.sin(Math.PI * i) * Math.sin(Math.PI * j);
	}
	
	
	
	public BoundarySolution generateRightSolution(int height, int length) {
				
		return new BoundarySolution(
						height,
						length,
						sinResultFunction(), 
						(i, j) -> 0);
	}
	
	

	@Override
	public BoundaryProblem clone() {
		return new SinProblem(this);
	}
	
}
