import java.time.LocalDate;
import java.util.*;

class Datastore {

    // Donor storage (used by other teammates too)
    static Map<String, List<Donor>> donorMap = new HashMap<>();

    // Patient priority queue
    static PriorityQueue<Patient> patientQueue =new PriorityQueue<>(new PatientPriorityComparator());
      
   // Donation Archive
    static ArrayList<ArchiveRecord> archive=new ArrayList<>();
    
}
    
class ArchiveRecord {
    String donorName;
    String patientName;
    String bloodGroup;
    String date = LocalDate.now().toString();
    ArchiveRecord(String donorName, String patientName, String bloodGroup) {
        this.donorName = donorName;
        this.patientName = patientName;
        this.bloodGroup = bloodGroup;
        
    }

    public static void displayArchive() {

    if (Datastore.archive.isEmpty()) {
        System.out.println("No donation history available.");
        return;
    }

    System.out.println("\n================ Donation History ================\n");

    // Header
    System.out.printf("%-5s %-12s %-12s %-15s %-20s\n",
            "No", "Donor", "Patient", "Donated Blood Group", "Date");

    System.out.println("---------------------------------------------------------------");

    // Data rows
    for (int i = 0; i < Datastore.archive.size(); i++) {
        ArchiveRecord r = Datastore.archive.get(i);

        System.out.printf("%-5d %-12s %-12s %-15s %-20s\n",
                (i + 1),
                r.donorName,
                r.patientName,
                r.bloodGroup,
                r.date);
    }

    System.out.println("---------------------------------------------------------------");
}
    
}