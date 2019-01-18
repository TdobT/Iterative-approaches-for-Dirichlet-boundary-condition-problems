package algorithm_package;

import problem_package.BoundaryProblem;

public class JacobiAlgorithm extends Algorithm {

	@Override
	public BoundaryProblem applyIteration(BoundaryProblem p) {

		int height = p.matrix.getHeight() - 1, 
				length = p.matrix.getLength() - 1;
		
		BoundaryProblem nextMatrix = p.clone();
		// Updates every element inside the boundary
		for (int i = 1; i < height; i++) {
			for (int j = 1; j < length; j++) {
				nextMatrix.matrix.rows[i][j] = update(i, j, p);
			}
		}
		
		return nextMatrix;
	}
}
