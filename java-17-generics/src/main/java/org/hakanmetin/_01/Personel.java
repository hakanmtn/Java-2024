package org.hakanmetin._01;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

//Model - Kalio
public class Personel {

    private String firstName;
    private String lastName;
    private String tc;
    private String sicilNo;
    private String department;
    private int birthYear;
    private boolean medeniDurum;
    private int cocukSayisi;

    /*
    public Personel(){

    }

    public Personel(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Personel(String firstName, String lastName, String tc, String sicilNo, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.tc = tc;
        this.sicilNo = sicilNo;
        this.department = department;

    }

    public Personel(String firstName,
                    String lastName,
                    String tc,
                    String sicilNo,
                    String department,
                    int birthYear,
                    boolean medeniDurum,
                    int cocukSayisi) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.tc = tc;
        this.sicilNo = sicilNo;
        this.department = department;
        this.birthYear = birthYear;
        this.medeniDurum = medeniDurum;
        this.cocukSayisi = cocukSayisi;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getSicilNo() {
        return sicilNo;
    }

    public void setSicilNo(String sicilNo) {
        this.sicilNo = sicilNo;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public boolean isMedeniDurum() {
        return medeniDurum;
    }

    public void setMedeniDurum(boolean medeniDurum) {
        this.medeniDurum = medeniDurum;
    }

    public int getCocukSayisi() {
        return cocukSayisi;
    }

    public void setCocukSayisi(int cocukSayisi) {
        this.cocukSayisi = cocukSayisi;
    }

    @Override
    public String toString() {
        return "Personel{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", tc='" + tc + '\'' +
                ", sicilNo='" + sicilNo + '\'' +
                ", department='" + department + '\'' +
                ", birthYear=" + birthYear +
                ", medeniDurum=" + medeniDurum +
                ", cocukSayisi=" + cocukSayisi +
                '}';
    }

     */
}
