import java.util.ArrayList;

// Donor class
class Donor {
    String name;
    String bloodGroup;
    int x, y;

    int donationbreak;
    boolean isAvailable=true;


    public Donor(String name, String bloodGroup, int x, int y,int donationbreak) {
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.x = x;
        this.y = y;
       
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
}
