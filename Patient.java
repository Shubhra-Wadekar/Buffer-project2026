 class Patient{
    String PatientName;
    String BloodGroup;
    //Distance coordinates
    int x;
    int y;
    int urgency;   // higher = more urgent

    public Patient(String name, String bloodGroup, int x, int y, int urgency) {
        this.PatientName = name;
        this.BloodGroup = bloodGroup;
        this.x = x;
        this.y = y;
        this.urgency = urgency;
    }

}