import java.util.*;

abstract class Question {
    protected final String text;
    protected final String correctAnswer;
    protected final String studentAnswer;
    protected final int points;

    Question(String text, String correctAnswer, String studentAnswer, int points) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract String getType();

    abstract double score();
}

class McqQuestion extends Question {
    McqQuestion(String text, String correct, String student, int points) {
        super(text, correct, student, points);
    }

    String getType() { return "MCQ"; }

    double score() { return studentAnswer.equals(correctAnswer) ? points : 0; }
}

class TrueFalseQuestion extends Question {
    TrueFalseQuestion(String text, String correct, String student, int points) {
        super(text, correct, student, points);
    }

    String getType() { return "TF"; }

    double score() { return studentAnswer.equals(correctAnswer) ? points : 0; }
}

class EssayQuestion extends Question {
    EssayQuestion(String text, String correct, String student, int points) {
        super(text, correct, student, points);
    }

    String getType() { return "ESSAY"; }

    double score() {
        String answer = studentAnswer.toLowerCase();
        int matched = 0;
        for (String keyword : correctAnswer.split(",")) {
            String k = keyword.trim().toLowerCase();
            if (!k.isEmpty() && answer.contains(k)) matched++;
        }
        if (matched >= 2) return points * 0.75;
        if (matched == 1) return points * 0.50;
        return 0;
    }
}

public class ExamGrader {
    // Splits a line into tokens, keeping "quoted strings" together (quotes removed).
    static List<String> tokenize(String line) {
        List<String> tokens = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        boolean inQuotes = false;
        for (char c : line.toCharArray()) {
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (Character.isWhitespace(c) && !inQuotes) {
                if (cur.length() > 0) {
                    tokens.add(cur.toString());
                    cur.setLength(0);
                }
            } else {
                cur.append(c);
            }
        }
        if (cur.length() > 0) tokens.add(cur.toString());
        return tokens;
    }

    static Question create(String type, String text, String correct, String student, int points) {
        switch (type.toUpperCase()) {
            case "MCQ": return new McqQuestion(text, correct, student, points);
            case "TF": return new TrueFalseQuestion(text, correct, student, points);
            case "ESSAY": return new EssayQuestion(text, correct, student, points);
            default: throw new IllegalArgumentException("Unknown question type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Question> questions = new ArrayList<>();
        while (questions.size() < n && sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            List<String> t = tokenize(line);
            questions.add(create(t.get(0), t.get(1), t.get(2), t.get(3), Integer.parseInt(t.get(4))));
        }

        double total = 0;
        for (Question q : questions) {
            double s = q.score();
            System.out.printf("%s: %.2f%n", q.getType(), s);
            total += s;
        }
        System.out.printf("Total Score: %.2f%n", total);
    }
}
