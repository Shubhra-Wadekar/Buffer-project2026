import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



class BloodCompatibility {

    static Map<String, List<String>> map = new HashMap<>();

// Blood Group chart
    static {
        map.put("A+", Arrays.asList("A+", "A-", "O+", "O-"));
        map.put("A-", Arrays.asList("A-", "O-"));
        map.put("B+", Arrays.asList("B+", "B-", "O+", "O-"));
        map.put("B-", Arrays.asList("B-", "O-"));
        map.put("AB+", Arrays.asList("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"));
        map.put("AB-", Arrays.asList("A-", "B-", "AB-", "O-"));
        map.put("O+", Arrays.asList("O+", "O-"));
        map.put("O-", Arrays.asList("O-"));
    }

    public static List<String> getCompatibleGroups(String bloodGroup) {
        return map.getOrDefault(bloodGroup, new ArrayList<>());
    }
}

//Distance of donor from patient
class DistanceCalculator {
    public static int calculate(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}

