package problem_package;
import data_structure_package.Matrix;
import data_structure_package.ParamFunctionInterface;

public class BoundarySolution {

	public double tollerance;
	public Matrix matrix;
	public ParamFunctionInterface f;
	public int iterationNumber = -1;
	public double h_SQR;
	
	
	public BoundarySolution(BoundaryProblem p, int iterationNumber) {
		
		this.tollerance = BoundaryProblem.TOLLERANCE;
		this.matrix = new Matrix(p.getMatrix());
		this.f = p.getBoundaryFunction();
		this.iterationNumber = iterationNumber;
		this.h_SQR = p.get_h_SQR();
	}
	

	public BoundarySolution(int height, int length, 
			ParamFunctionInterface f_generator, ParamFunctionInterface f) {

		this.f = f;
		this.tollerance = BoundaryProblem.TOLLERANCE;
		this.matrix = new Matrix(height, length, f_generator);
	}
	
	
	public double evaluatePrecision(BoundarySolution rightSolution) {
		return Matrix.computeNorm(matrix, rightSolution.matrix);
	}
	
	
	public String toString() {
		String s = new String();
		s = "Matrix (" + matrix.getHeight() + " * " + matrix.getLength();
		s += "), h square: " + this.h_SQR + ", tollerance: " + tollerance;
		s += ", iteration: " + iterationNumber + System.lineSeparator();
		
		return s + matrix;
	}
	
}
