package data_structure_package;
import java.text.DecimalFormat;

import problem_package.BoundaryProblem;

public class Matrix {

	public double rows[][];
	private int matrixHeight, matrixLength;
	
	
	public Matrix(int height, int length, 
			ParamFunctionInterface f_generator) {

		if (height <= 0 || length <= 0) 
			throw new IllegalArgumentException("Matrix can't be empty");

		this.matrixHeight = height;
		this.matrixLength = length;
		double[][] rows = new double[height][length];
		double jVal, iVal;
		
		for (int i = 0; i < height; i++) {
			iVal = lengthPosToValue(i, this);
			for (int j = 0; j < length; j++) {
				jVal = heightPosToValue(j, this);
				rows[i][j] = f_generator.evaluateFunction(iVal, jVal);
			}
		}	
		
		this.rows = rows;
	}
	
	
	
	public Matrix(int height, int length) {
		this(height, length, (i, j) -> 0);
	}
	
	
	
	public Matrix(Matrix m) {

		this.matrixHeight = m.matrixHeight;
		this.matrixLength = m.matrixLength;
		this.rows = new double[matrixHeight][matrixLength];
		for (int i = 0; i < this.matrixHeight; i++) {
			for (int j = 0; j < this.matrixLength; j++) {
				this.rows[i][j] = m.rows[i][j];
			}
		}
	}	
	
	
	
	public int getHeight() {
		return this.matrixHeight;
	}
	
	
	
	public int getLength() {
		return this.matrixLength;
	}
	
	

	public static double heightPosToValue(int rowPos, Matrix m) {
		return (double) rowPos / ((double) m.matrixHeight - 1);
	}

	
	
	public static double lengthPosToValue(int colPos, Matrix m) {
		return (double) colPos / ((double) m.matrixLength - 1);
	}
	
	

	public static double computeNorm(Matrix m1, Matrix m2) {
		
		if (m1.getHeight() != m2.getHeight() ||
				m1.getLength() != m2.getLength())
			throw new IllegalArgumentException(
					"To compute the norm both matrices must have the same size");
		
		double diff, maxDiff = 0;
		
		int height = m1.getHeight(), length = m1.getLength();
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < length; j++) {
				diff = Math.abs(m1.rows[i][j] - m2.rows[i][j]);
				if (diff > maxDiff) maxDiff = diff;
			}
		}

		
		return maxDiff;
	}

	
	public static double computeNormOne(Matrix m1, Matrix m2) {
		
		if (m1.getHeight() != m2.getHeight() ||
				m1.getLength() != m2.getLength())
			throw new IllegalArgumentException(
					"To compute the norm both matrices must have the same size");
		
		double partSum, sums = 0;
		for (int i = 0; i < m1.getHeight(); i++) {

			for (int j = 0; j < m1.getLength(); j++) {
				partSum = (m1.rows[i][j] - m2.rows[i][j]);
				sums += partSum * partSum;
			}
			
		}

		return Math.sqrt(sums);
	}
	
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(BoundaryProblem.TOL_FIGURE + 1);
		df.setMinimumFractionDigits(BoundaryProblem.TOL_FIGURE + 1);
		
		for (double[] row : rows) {
			sb.append("[ ");
			sb.append("\t");
			for (double elem : row) {
				sb.append(df.format(elem));
				sb.append(" ");
				sb.append("\t");
			}
			sb.append("]");
			sb.append(System.lineSeparator());
		}
		
		return sb.toString();
	}
}
