package week1;

public class Functions {
    public static int max(int num1, int num2) {
        int result;
        
        if (num1 > num2) {
            result = num1;
        }
        else {
            result = num2;
        }
        
        return result;
    }
    
    public static int max_a(int num1, int num2) {
        if (num1 > num2) {
            return num1;
        }
        else {
            return num2;
        }
    }

    public static char grade(double score) {
        char grade;
        if (score >= 90.0) {
            grade = 'A';
        }
        else if (score >= 80.0) {
            grade = 'B';
        }
        else if (score >= 70.0) {
            grade = 'C';
        }
        else if (score >= 60.0) {
            grade = 'D';
        }
        else {
            grade = 'F';
        }
        return grade;
    }
    
    public static char grade_v2(double score) {
        if (score >= 90.0) {
            return 'A';
        }
        else if (score >= 80.0) {
            return 'B';
        }
        else if (score >= 70.0) {
            return 'C';
        }
        else if (score >= 60.0) {
            return 'D';
        }
        else {
            return 'F';
        }
    }
    
    public static char grade_v3(double score) {
        char grade;
        if (score >= 90.0) {
            grade = 'A';
        }
        if (score >= 80.0) {
            grade = 'B';
        }
        if (score >= 70.0) {
            grade = 'C';
        }
        if (score >= 60.0) {
            grade = 'D';
        }
        else {
            grade = 'F';
        }
        
        return grade;
    }// stack over flow error
    
    public static char grade_v4(double score) {
        return (score >= 90.0) ? 'A' ://":" means continue to the next line while ";" means the end
            	(score >= 80.0) ? 'B' :
                (score >= 70.0) ? 'C' :
                (score >= 60.0) ? 'D' :
                    'F';
    }
    
    public static void main(String[] args) {
        System.out.println(max(3, 5));
        System.out.println(max_a(3, 5));

        System.out.println(max(8, 0));
        System.out.println(max_a(8, 0));
        
        System.out.println(grade(70.0));
        System.out.println(grade(52.0));
    }
}
