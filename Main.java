import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        System.out.printf("%100S","Welcome to Blood Donor Matching and Urgency System\n");
       int exit;
        do{
        System.out.println("Menu:\n Enter 1 to register donor\n Enter 2 to add new patient \n Enter 3 to get the patient-Donor match list \n Enter 4 to get Donation history");
        Scanner sc=new Scanner(System.in);
        int inp=sc.nextInt();
         sc.nextLine();
        switch(inp){
            case 1 -> { System.out.println("Enter name:");
                String name=sc.nextLine();
                System.out.println("Enter bloodgroup(A+,A-,B+,B-,O+,O-,AB+,AB-)");
                String bg=sc.next();
                bg=bg.toUpperCase();
                System.out.println("Enter location latitude(in degrees)");
                int x=sc.nextInt();
                System.out.println("Enter location longitude(in degrees)");
                 int y=sc.nextInt();
                 System.out.println("Enter no of days since you have donated blood last time(If never donated enter 90)");
                 int dbreak=sc.nextInt();
                 sc.nextLine();
                 System.out.println("Enter Mobile no");
                  String mobileno=sc.next(); 
                if(DonorService.isValid(mobileno)){
                                      Donor d=new Donor(name,bg,x,y,dbreak,mobileno);
                                DonorService.registerDonor(d);
                }
               else{
                System.out.println("Invalid mobile no entered:Registration failed");
               }
               }
            
            case 2 -> {System.out.println("Enter name:");
                String name=sc.nextLine();
                 System.out.println("Enter bloodgroup(A+,A-,B+,B-,O+,O-,AB+,AB-)");
                String bg=sc.next();
                bg=bg.toUpperCase();
                System.out.println("Enter location latitude(in degrees)");
                int x=sc.nextInt();
                System.out.println("Enter location longitude(in degrees)");
                 int y=sc.nextInt();
                 System.out.println("Enter urgency of need on a scale of 10");
                 int urgency=sc.nextInt();
                Patient p=new Patient(name,bg,x,y,urgency);
                PatientServices.addPatient(p);
                 }

              case 3 -> MatchingServices.match();
              
              case 4 ->ArchiveRecord.displayArchive();
            
        }
        System.out.println("Enter 0 to exit and 1 to continue");
        exit=sc.nextInt();
                }
        while(exit!=0);

        System.out.println("Exiting Program........\n Program Ended");


    }
} 