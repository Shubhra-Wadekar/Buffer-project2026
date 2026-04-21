import java.util.ArrayList;

// Donor class
class Donor {
    String name;
    String bloodGroup;
    int x, y;

    int donationbreak;
    boolean isAvailable=true;
    String mobileno;

    public Donor(String name, String bloodGroup, int x, int y,int donationbreak, String mobileno) {
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.x = x;
        this.y = y;
        this.mobileno=mobileno;
       
        this.donationbreak=donationbreak;
        if(donationbreak<90){
           isAvailable=false;
        }
    }
}

//Donor Services

class DonorService {
   static void registerDonor(Donor d) {
        Datastore.donorMap.putIfAbsent(d.bloodGroup, new ArrayList<>());
        Datastore.donorMap.get(d.bloodGroup).add(d);
        System.out.println("Registered Donor Successfully");

 
    }
    static boolean isValid(String mobile) {
        // Remove spaces
        mobile = mobile.replaceAll("\\s", "");

        // Regex for Indian numbers
        String regex = "^(\\+91|91)?[6-9][0-9]{9}$";

        return mobile.matches(regex);
       }
}
