package week11_practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem4_EmployeeDirectoryLookup {

    public record EmployeeRecord(String employeeId, String department) {}

    public static Map<String, String> buildLookup(List<EmployeeRecord> records) {
        if (records == null || records.isEmpty()) {
            return new HashMap<>();
        }

        Map<String, String> lookup = new HashMap<>((int) (records.size() / 0.75f) + 1);

        for (EmployeeRecord record : records) {
            if (record != null && record.employeeId() != null) {
                lookup.put(record.employeeId(), record.department());
            }
        }

        return lookup;
    }

    public static String getDepartment(Map<String, String> lookup, String employeeId) {
        if (lookup == null || employeeId == null) {
            return "Unknown";
        }
        return lookup.getOrDefault(employeeId, "Unknown");
    }

    public static void main(String[] args) {
        List<EmployeeRecord> records = List.of(
            new EmployeeRecord("E245", "Finance"),
            new EmployeeRecord("E110", "Engineering"),
            new EmployeeRecord("E390", "Marketing"),
            new EmployeeRecord("E101", "Engineering")
        );

        Map<String, String> lookup = buildLookup(records);

        System.out.println(getDepartment(lookup, "E390"));
        System.out.println(getDepartment(lookup, "E999"));
    }
}
