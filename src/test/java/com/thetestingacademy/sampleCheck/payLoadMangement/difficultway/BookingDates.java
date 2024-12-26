package com.thetestingacademy.sampleCheck.payLoadMangement.difficultway;

public class BookingDates {

    private String checkin;

    private String checkout;

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public static class Person {

        private  String name;
        private Integer age;

        public Person(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }
        public void setAge(Integer age) {
            this.age = age;
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
