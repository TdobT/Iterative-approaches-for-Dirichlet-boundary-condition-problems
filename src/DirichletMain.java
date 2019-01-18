import test_package.Test;

public class DirichletMain {

	
	public static void main(String args[]) {

		int dim;
		
		Test t = new Test();

		t.setPrecisionFigure(8);

		t.runTest(5);
		
		for (int i = 1; i < 6; i++) {
			dim = i * 20;
			t.runTest(dim);	
		}

		t.runTest(150);
		t.runTest(200);
	}
	
	
	
}
