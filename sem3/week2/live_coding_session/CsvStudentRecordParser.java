/**
 * Program Name  : CsvStudentRecordParser
 * Class Name    : CsvStudentRecordParser
 * Description   : Day 2 Live-Coding Session - Problem 2: CSV Student Record Parser.
 *                 Splits CSV lines into 3 fields and produces formatted records.
 * Author        : Akula Srikar
 * Date          : 2026-09-10
 */

public class CsvStudentRecordParser {

    public static void parseStudentRecord(String csvLine) {
        if (csvLine == null || csvLine.trim().isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = fields[0].trim();
        String rollNumber = fields[1].trim();
        String department = fields[2].trim();

        if (name.isEmpty() || rollNumber.isEmpty() || department.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.printf("Name: %s | Roll No: %s | Dept: %s%n", name, rollNumber, department);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("        CSV STUDENT RECORD PARSER              ");
        System.out.println("===================================================\n");

        String[] testLines = {
            "Ananya Verma,RA2211003010123,CSE",
            "Ananya Verma,CSE",
            "Rohit Sharma,RA2211003010456,ECS",
            "Vikram,RA2211003010789,Mechanical,ExtraField",
            ",,"
        };

        for (String line : testLines) {
            System.out.println("Input: \"" + line + "\"");
            System.out.print("Output: ");
            parseStudentRecord(line);
            System.out.println("-------------------------------------------------");
        }
    }
}