
import java.util.ArrayList;
import java.util.List;
class MatchingServices {

   
    public static void match() {

        while (PatientServices.hasPatients()) {

            Patient p = PatientServices.getNextPatient();

            List<String> groups = BloodCompatibility.getCompatibleGroups(p.BloodGroup);

            Donor best = null;
            int minDist = Integer.MAX_VALUE;

            for (String g : groups) {

                List<Donor> donors = Datastore.donorMap.getOrDefault(g, new ArrayList<>());

                for (Donor d : donors) {

                    if (d.isAvailable) {

                        int dist = DistanceCalculator.calculate(p.x, p.y, d.x, d.y);

                        if (dist < minDist) {
                            minDist = dist;
                            best = d;
                        }
                    }
                }
            }

            if (best != null) {
                best.isAvailable = false;
                System.out.println("Assigned " + best.name + " to " + p.PatientName + " Distance: " + minDist);
            } 
            else {
                System.out.println("No donor found for " + p.PatientName);
            }
        }
    }
}

