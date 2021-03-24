package sample;

public class StudentRecord {
    public String stID;
    public float midterm;
    public float assignment;
    public float exam;
    public float mark;
    public char letter;

    public StudentRecord(String ID, String assignmen, String Mid, String Fin) {
        this.stID=ID;
        this.midterm=Float.parseFloat(Mid);
        this.assignment=Float.parseFloat(assignmen);
        this.exam=Float.parseFloat(Fin);
        mark=this.getFinal();
        letter=this.getLetter();
    }

    public String getID() {
        return this.stID;
    }

    public float getMid() {
        return this.midterm;
    }

    public float getAssi() {
        return this.assignment;
    }

    public float getExam() {
        return this.exam;
    }

    public float getFinal() {
        float finalGrade=((this.assignment*0.2f)+(this.midterm*0.3f)+(this.exam*0.5f));
        return finalGrade;
    }

    public char getLetter() {
        if (this.getFinal()>=80) {
            return 'A';
        }
        else if (this.getFinal() >= 70 && this.getFinal() < 80) {
            return 'B';
        }
        else if (this.getFinal() >=60 && this.getFinal() <70) {
            return 'C';
        }
        else if (this.getFinal() >=50 && this.getFinal() <60) {
            return 'D';
        }
        else {
            return 'F';
        }
    }
}
