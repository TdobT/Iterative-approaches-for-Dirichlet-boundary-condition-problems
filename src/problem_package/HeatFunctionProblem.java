package problem_package;

import data_structure_package.ParamFunctionInterface;

public class HeatFunctionProblem extends LaplaceProblem {

	private double east, north, west, south;
	
	
	public HeatFunctionProblem(int height, int length, double east,
			double north, double west, double south) {
		
		super(height, length, 
					heatFunction(east, north, west, south));
		
		this.east = east;
		this.north = north;
		this.west = west;
		this.south = south;
	}
	
	
	
	protected HeatFunctionProblem(HeatFunctionProblem p) {
		super(p);

		this.east = p.east;
		this.north = p.north;
		this.west = p.west;
		this.south = p.south;
	}
	
	
	
	public static ParamFunctionInterface heatFunction(
			double east, double north, double west,	double south) {

		return new ParamFunctionInterface() {

			@Override
			public double evaluateFunction(double iPos, double jPos) {
				if (iPos == 0)
					if (jPos == 0) return (north + west)/2;
					else if (jPos == 1) return (north + east)/2;
					else return north;
				else if (iPos == 1)
					if (jPos == 0) return (south + west)/2;
					else if (jPos == 1) return (south + east)/2; 
					else return south;
				else if (jPos == 0) return west;
				else if (jPos == 1) return east;
				else return 0;
			}
		};
	}

	
	public BoundarySolution generateRightSolution(int height, int length) {
		return null;
	}

	@Override
	public BoundaryProblem clone() {
		return new HeatFunctionProblem(this);
	}

}
