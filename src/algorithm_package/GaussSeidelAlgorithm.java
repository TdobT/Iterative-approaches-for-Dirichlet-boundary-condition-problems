package algorithm_package;

import problem_package.BoundaryProblem;

public class GaussSeidelAlgorithm extends Algorithm {

	@Override
	public BoundaryProblem applyIteration(BoundaryProblem p) {
		
		int height = p.matrix.getHeight() - 1, 
				length = p.matrix.getLength() - 1;
		
		
		// Updates every element inside the boundary
		for (int i = 1; i < height; i++) {
			for (int j = 1; j < length; j++) {
				p.matrix.rows[i][j] = update(i, j, p);
			}
		}	
		
		return p;
	}
}
