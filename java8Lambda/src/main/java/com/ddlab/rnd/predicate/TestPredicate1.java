package com.ddlab.rnd.predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class TestPredicate1 {

    public static void showSinglePredicate() {
        //Single predicate
        Predicate<Integer> greaterThanTen = (i) -> i > 10;
        System.out.println("Predicate Value : "+greaterThanTen.test(14));//True
    }

    public static void showPredicateChaining() {
        //Predicate chaining
        Predicate<Integer> greaterThanTen = (i) -> i > 10;
        Predicate<Integer> lowerThanTwenty = (i) -> i < 20;

        boolean flag = greaterThanTen.and(lowerThanTwenty).test(15);
        System.out.println(flag);
    }

    //Passing predicates into functions
    public static void process(int number, Predicate<Integer> predicate) {
        if (predicate.test(number)) {
            System.out.println("Number " + number + " was accepted!");
        }
    }

    static class User {
        String name;
        String role;

        public User(String name, String role) {
            this.name = name;
            this.role = role;
        }

        public String getName() {
            return name;
        }

        public String getRole() {
            return role;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", role='" + role + '\'' +
                    '}';
        }
    }

    // Filtering list elements with a predicate
    public static List<User> process(List<User> users, Predicate<User> predicate) {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (predicate.test(user)) {
                result.add(user);
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        showPredicateChaining();

        // Will print "Number 10 was accepted!"
//        process(10, (i) -> i > 7);

        List<User> users = new ArrayList<>();
        users.add(new User("John", "admin"));
        users.add(new User("Peter", "member"));
        List<User> admins = process(users, (u) -> u.getRole().equals("admin"));
        for( User u : admins )
            System.out.println(u);
    }
}
