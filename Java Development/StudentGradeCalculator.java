import java.util.Scanner;

public class StudentGradeCalculator {
    public static String calculateGrade(double percentage) {
        if (percentage >= 90)
            return "A+";
        else if (percentage >= 80)
            return "A";
        else if (percentage >= 70)
            return "B";
        else if (percentage >= 60)
            return "C";
        else if (percentage >= 50)
            return "D";
        else if (percentage >= 40)
            return "E";
        else
            return "F";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = sc.nextInt();

        double marks[] = new double[numSubjects];

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            marks[i] = sc.nextDouble();
        }

        double totalMarks = 0;
        for (double mark: marks)
            totalMarks += mark;

        double averagePercentage = totalMarks / numSubjects;
        String grade = calculateGrade(averagePercentage);

        System.out.println("\n--- Report Card ---");
        for (int i = 0; i < numSubjects; i++)
            System.out.println("Subject " + (i + 1) + ": " + marks[i] + " / 100");

        System.out.println("--------------------");
        System.out.println("Total Marks: " + totalMarks + " / " + (numSubjects * 100));
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);

        sc.close();

    }

}
