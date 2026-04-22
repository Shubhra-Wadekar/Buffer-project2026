
import java.util.ArrayList;
import java.util.List;
class MatchingServices {

   
    public static void match() {
  System.out.printf("%-15s %-15s %-15s %-10s\n", "Patient", "Donor", "Blood Group", "Distance");
  System.out.println("---------------------------------------------------------------");
        while (PatientServices.hasPatients()) {

            Patient p = PatientServices.getNextPatient();

            List<String> groups = BloodCompatibility.getCompatibleGroups(p.BloodGroup);

            Donor best = null;
        
            int bestPriority = Integer.MAX_VALUE;

            int minDist = Integer.MAX_VALUE;
           
            for (String g : groups) {
                int priority = BloodCompatibility.getPriority(g);
                List<Donor> donors = Datastore.donorMap.getOrDefault(g, new ArrayList<>());

                for (Donor d : donors) {

           
             if (d.isAvailable) {
             int  dist = DistanceCalculator.calculate(p.x, p.y, d.x, d.y);

                  if (priority < bestPriority || 
               (priority == bestPriority && dist < minDist)) {

                bestPriority = priority;
                minDist = dist;
                best = d;
            }

             }
                }
            }
          
            if (best != null) {
                best.isAvailable = false;
                Datastore.archive.add(new ArchiveRecord(best.name,p.PatientName,best.bloodGroup));
               System.out.printf("%-15s %-15s %-15s %-10d\n", p.PatientName,best.name, best.bloodGroup, minDist);
            } 
            else {
               System.out.printf("%-15s %-15s %-15s %-10s\n",p.PatientName, "Not Found", p.BloodGroup, "-");
            }
        }
    }
}

