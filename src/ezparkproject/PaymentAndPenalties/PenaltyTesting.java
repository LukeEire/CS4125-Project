package ezparkproject;

public class PenaltyTesting{
	//Testing class for penalty methods
    public static void main(String[] args) {
		
		Penalty p = new Penalty();
		PenaltyBackend pb = new PenaltyBackend();
		Users u = new Users(true, 1111111, "Penalty", "Testing", "Password123", "N/A", "Student", 1, 0, "2000-12-15", "12D1111");

		System.out.println("Testing Penalty Class...");
		System.out.println();  

		System.out.println("Test 1: addInfraction()");  
		p.addInfraction(u.getID());
		System.out.println(); 
		
		System.out.println("Test 2: addInfraction()");  
		p.addInfraction(u.getID());
		System.out.println(); 

		System.out.println("Test 3: getInfractions()");  
		int test = p.getInfractions(u.getID());
		System.out.println("Returned: " + test);
		System.out.println();  

		System.out.println("Testing Penalty Backend Class...");
		System.out.println();  

		System.out.println("Test 1: PenaltyBackendAddInfraction()");  
		pb.PenaltyBackendAddInfraction(u.getID());
		System.out.println();  

		System.out.println("Test 2: PenaltyBackendAddInfraction()");  
		int test2 = pb.PenaltyBackendGetInfractions(u.getID());
		System.out.println("Returned: " + test2);
		System.out.println();  

		System.out.println("All Systems Tested!");  
		System.out.println(); 

    }
}