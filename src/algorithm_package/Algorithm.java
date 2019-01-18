package algorithm_package;

import data_structure_package.Matrix;
import problem_package.BoundaryProblem;
import problem_package.BoundarySolution;

public abstract class Algorithm {

	public static int MAX_ITERATION = 100000;

	public abstract BoundaryProblem applyIteration(BoundaryProblem p);
	

	public BoundarySolution applyAlgorithm(BoundaryProblem p) {

		int iterationNumber = 0;
		
		BoundaryProblem nextMatrix = p.clone();

		nextMatrix = applyIteration(nextMatrix);
		
		while   (
					Matrix.computeNorm(p.matrix, nextMatrix.matrix) > 
					BoundaryProblem.TOLLERANCE &&
					iterationNumber < MAX_ITERATION
				) {

			p = nextMatrix.clone();
			nextMatrix = applyIteration(nextMatrix);

			iterationNumber++;
		}
		
		return new BoundarySolution(nextMatrix, iterationNumber);
	}



	
	protected double update(int iPos, int jPos, BoundaryProblem p) {
		
		// Evaluates the equivalent position in the Unit Square,
		// those values are needed to evaluate the function. 
		double  iVal = Matrix.heightPosToValue(iPos, p.matrix), 
				jVal = Matrix.lengthPosToValue(jPos, p.matrix);
		
		return  (
						p.matrix.rows[iPos-1][jPos] + 
						p.matrix.rows[iPos+1][jPos] +
						p.matrix.rows[iPos][jPos-1] +
						p.matrix.rows[iPos][jPos+1] +
						p.getBoundaryFunction().evaluateFunction(iVal, jVal) *
						p.get_h_SQR()
				) / 4;
	}
}
