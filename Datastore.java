import java.util.*;

class Datastore {

    // Donor storage (used by other teammates too)
    static Map<String, List<Donor>> donorMap = new HashMap<>();

    // Patient priority queue
    static PriorityQueue<Patient> patientQueue =new PriorityQueue<>(new PatientPriorityComparator());
}