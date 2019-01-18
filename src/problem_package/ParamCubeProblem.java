package problem_package;

import data_structure_package.Matrix;
import data_structure_package.ParamFunctionInterface;

public class ParamCubeProblem extends BoundaryProblem {

	public ParamCubeProblem(int height, int length) {
		super(new Matrix(
					height, 
					length,
					paramCubeFunction()), 
				cubeTargetFunction());
	}
	
	
	public ParamCubeProblem(ParamCubeProblem p) {
		super(p);
	}


	public static ParamFunctionInterface paramCubeFunction() {

		return new ParamFunctionInterface() {

			@Override
			public double evaluateFunction(double iPos, double jPos) {
				if (iPos == 0 || jPos == 0 || jPos == 1) return 0;
				else if (iPos == 1) return jPos * (1 - jPos);
				return 0;
			}
		};
	}
	

	public static ParamFunctionInterface cubeTargetFunction() {
		return (i, j) -> 6*i*j * (1-j) - 2*i*i*i;
	}
	
	
	public static ParamFunctionInterface cubeResultFunction() {
		return (i, j) -> j * (1-j) * i*i*i;
	}
	
	
	@Override
	public BoundarySolution generateRightSolution(int height, int length) {
		
		return new BoundarySolution(
				height,
				length,
				cubeResultFunction(), 
				(i, j) -> 0);
	}
	
	
	@Override
	public BoundaryProblem clone() {
		return new ParamCubeProblem(this);
	}
	
}
