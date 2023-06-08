package ro.mycode.models;

public class Admin extends User {

    private int level;
    private String skills;
    private String duty;

    public Admin(int id, String email, String password, String fullName, int phone,
                 int level, String skills, String duty) {
            super(id, email, password, fullName, phone, "admin");
        this.level = level;
        this.skills = skills;
        this.duty = duty;
    }

    public Admin(){
        super();

    }

    public Admin(String text){
        super(text);
        this.level= Integer.parseInt(text.split(",")[6]);
        this.skills=text.split(",")[7];
        this.duty=text.split(",")[8];
    }

    @Override
    public String toString() {
        String text = "";
        text += "id " + super.getId() + "\n";
        text += "email " + super.getEmail() + "\n";
        text += "password " + super.getPassword() + "\n";
        text += "fullName" + super.getFullName() + "\n";
        text += "phone " + super.getPhone() + "\n";
        text += "type " + super.getType() + "\n";
        text += "level " + this.level + "\n";
        text += "skills " + this.skills + "\n";
        text += "duty " + this.duty + "\n";
        return text;
    }

    @Override
    public boolean equals(Object object) {
        Admin admin = (Admin) object;
        return this.level == admin.level && this.skills.equals(admin.skills) && this.duty.equals(duty);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    @Override
    public int compareTo(User o){
        if (this.level>0){
            return -1;
        } else if (this.level<0) {
            return 1;
        }
        return 0;
    }
}
