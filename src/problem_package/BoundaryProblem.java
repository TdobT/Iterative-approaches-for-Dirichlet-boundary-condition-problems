package problem_package;
import algorithm_package.Algorithm;
import data_structure_package.Matrix;
import data_structure_package.ParamFunctionInterface;

public abstract class BoundaryProblem {

	public static int TOL_FIGURE = 4;
	public static double TOLLERANCE = Math.pow(0.1, TOL_FIGURE);
	
	public Matrix matrix;
	protected ParamFunctionInterface f;
	protected double h_SQR;
	
	
	public BoundaryProblem(Matrix m, ParamFunctionInterface f) {
		this.f = f;
		this.matrix = m;
		this.h_SQR = (1 / ((double) m.getLength() * (double) m.getHeight()));
	}
	

	protected BoundaryProblem(BoundaryProblem p) {
		this(new Matrix(p.matrix), p.f);
	}
	
	
	public Matrix getMatrix() {
		return new Matrix(matrix);
	}
	
	
	public ParamFunctionInterface getBoundaryFunction() {
		return this.f;
	}
	

	public abstract BoundarySolution generateRightSolution(int height, int length);
	
	
	public double get_h_SQR() {
		return this.h_SQR;
	}
	
	
	public BoundarySolution resolve(Algorithm a) {
		return a.applyAlgorithm(this);
	}
	
	
	public abstract BoundaryProblem clone();

	
	public String toString() {
		String s = new String();
		s = "Problem: Matrix " + matrix.getHeight() + " * ";
		s += matrix.getLength() + ", h square: " + h_SQR;
		s += ", tollerance: " + TOLLERANCE;
		s += System.lineSeparator();
		return s + matrix;
	}
	
	
}
