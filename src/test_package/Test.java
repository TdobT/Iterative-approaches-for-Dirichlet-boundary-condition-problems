package test_package;

import java.text.DecimalFormat;

import algorithm_package.Algorithm;
import algorithm_package.GaussSeidelAlgorithm;
import algorithm_package.JacobiAlgorithm;
import problem_package.BoundaryProblem;
import problem_package.BoundarySolution;
import problem_package.HeatFunctionProblem;
import problem_package.ParamCubeProblem;
import problem_package.ParamQuadProblem;
import problem_package.ParamSumProblem;
import problem_package.SinProblem;

public class Test {

	private int east, north, west, south;

	DecimalFormat df = new DecimalFormat();
	
	public Test() {
		set_default();
		df.setMaximumFractionDigits(BoundaryProblem.TOL_FIGURE + 1);
		df.setMinimumFractionDigits(BoundaryProblem.TOL_FIGURE + 1);
		System.out.println(BoundaryProblem.TOL_FIGURE);
	}
	
	private void set_default() {
		 this.east = 30;
		 this.north = 100;
		 this.west = -5;
		 this.south = 70;
	}
	
	public void runTest(int dim) {
		
		String res = "	";
		
//		res = dim + "*" + dim + " & " + testSin(dim) +
//				" \\\\ \\hline";
//		System.out.println(res);
//
//
//		res = dim + "*" + dim + " & " + testSum(dim) +
//				" \\\\ \\hline";
//
//		System.out.println(res);
//		
//		res = dim + "*" + dim + " & " + testQuad(dim) +
//				" \\\\ \\hline";
//
//		System.out.println(res);
//		
//		res = dim + "*" + dim + " & " + testCube(dim) +
//				" \\\\ \\hline";
//
//		System.out.println(res);
				
				
		System.out.println(testSin(dim));
		System.out.println(testSum(dim));
		System.out.println(testQuad(dim));
		System.out.println(testCube(dim));
	}
	
	
	public void setPrecisionFigure(int figure) {

		BoundaryProblem.TOL_FIGURE = figure;
		BoundaryProblem.TOLLERANCE = Math.pow(0.1, figure);
	}
	
	
	public void setMaxIteration(int maxIteration) {
		
		Algorithm.MAX_ITERATION = maxIteration;
	}
	
	
	private String testRightSolution(BoundaryProblem p, int dim) {
		
		String stringResult = new String();
		
		// Compare with right solution	
		BoundarySolution sol = p.generateRightSolution(dim, dim);
		
		if (sol == null) return "Can't evaluate precision" + System.lineSeparator();

		stringResult += dim + "*" + dim + System.lineSeparator();
		stringResult += "precision figures: " + BoundaryProblem.TOL_FIGURE;
		stringResult += System.lineSeparator();
		
		// Resolve with Gauss-Seidel
		stringResult += solveToGauss(p, sol);
		
		// Resolve with Jacobi
		stringResult += solveToJacobi(p, sol);

//		System.out.println("SOL");
//		System.out.println(sol);
//		System.out.println("PROB");
//		System.out.println(p);
		return stringResult;
	}
	
	
	private String solveToGauss(BoundaryProblem p, BoundarySolution s) {

		String stringResult = new String();
		
		// Resolve with Gauss-Seidel
		BoundarySolution result_gauss = p.resolve(new GaussSeidelAlgorithm());

		stringResult += "Iteration to Gauss: ";
		stringResult += result_gauss.iterationNumber;
		stringResult += System.lineSeparator();
		stringResult += "Precision to Gauss: ";
		stringResult += df.format(s.evaluatePrecision(result_gauss));
		stringResult += System.lineSeparator();

		return stringResult;
	}
	
	
	private String solveToJacobi(BoundaryProblem p, BoundarySolution s) {

		String stringResult = new String();

		// Resolve with Jacobi
		BoundarySolution result_jacobi = p.resolve(new JacobiAlgorithm());
		
		stringResult += "Iteration to Jacobi: ";
		stringResult += result_jacobi.iterationNumber;
		stringResult += System.lineSeparator(); 
		stringResult += "Precision to Jacobi: ";
		stringResult += df.format(s.evaluatePrecision(result_jacobi));
		stringResult += System.lineSeparator();
		
		return stringResult;
	}
	
	
	private String testHeat(int dim) {

		String stringResult = "";
		
		// Create Heat problem
		HeatFunctionProblem p_heat = 
				new HeatFunctionProblem(dim, dim, east, north, west, south);
		
		
		return stringResult + testRightSolution(p_heat, dim);
	}
	
	
	private String testSin(int dim) {

		String stringResult = "";
		
		// Create Sin problem
		SinProblem p_sin = 
				new SinProblem(dim, dim);
		
		
		return stringResult + testRightSolution(p_sin, dim);
	}
	

	private String testSum(int dim) {

		String stringResult = "";
		
		// Create Sum problem
		ParamSumProblem p_sum = 
				new ParamSumProblem(dim, dim);
		
		return stringResult + testRightSolution(p_sum, dim);
	}

	
	private String testQuad(int dim) {

		String stringResult = "";
		
		// Create Sum problem
		ParamQuadProblem p_quad = 
				new ParamQuadProblem(dim, dim);
		
		return stringResult + testRightSolution(p_quad, dim);
	}
	

	private String testCube(int dim) {

		String stringResult = "";
		
		// Create Cube problem
		ParamCubeProblem p_cube = 
				new ParamCubeProblem(dim, dim);
		
		return stringResult + testRightSolution(p_cube, dim);
	}
}
