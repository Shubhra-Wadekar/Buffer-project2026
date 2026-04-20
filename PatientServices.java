import java.util.Comparator;

class PatientPriorityComparator implements Comparator<Patient> {

    @Override
    public int compare(Patient p1, Patient p2) {

        // Higher urgency should come first
        if (p2.urgency > p1.urgency) {
            return 1;
        } else if (p2.urgency < p1.urgency) {
            return -1;
        } else {
            return 0;
        }
    }
}


class PatientServices{
     
    // Add patient to queue
   static  void addPatient(Patient p) {
        Datastore.patientQueue.add(p);
        System.out.println("Patient added: " + p.PatientName + " (Urgency: " + p.urgency + ")");
    }

    // Get next highest priority patient
    static Patient getNextPatient() {

        if (Datastore.patientQueue.isEmpty()) {
            System.out.println("No patients in queue");
            return null;
        }

        return Datastore.patientQueue.poll();
    }

    // Check if queue is empty
   static boolean hasPatients() {
        return !Datastore.patientQueue.isEmpty();
    }
      



}