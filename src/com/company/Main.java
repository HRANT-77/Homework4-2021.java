package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("     Exercise 1          Exercise 1     Exercise 1     Exercise 1");
        List<String> stringCollection = Arrays.asList("My", "name", "is", "John", "Doe");
        List<String> stringCollection1 = convertCollectionElementsToUpperCase(stringCollection);
        System.out.println(stringCollection1 + " Collections elements in Upper Case");

        System.out.println();
        System.out.println("     Exercise 2          Exercise 2     Exercise 2     Exercise 2");
        List<String> stringCollection2 = filterCollectionWithLength(stringCollection);
        System.out.println(stringCollection2 + " Collections elements with length under 4");

        System.out.println();
        System.out.println("     Exercise 3          Exercise 3     Exercise 3     Exercise 3");
        List<List<String>> listStringCollection = Arrays.asList(Arrays.asList("Viktor", "Farcic"), Arrays.asList("John", "Doe", "Third"));
        List<String> stringCollection3 = flatMapCollection(listStringCollection);
        System.out.println(stringCollection3 + " collection after flatMap");

        System.out.println();
        System.out.println("     Exercise 4          Exercise 4     Exercise 4     Exercise 4");
        Person person1 = new Person("Obama", 49, "American");
        Person person2 = new Person("Arman", 20, "Armenian");
        Person person3 = new Person("Vanya", 10, "Russian");
        Person person4 = new Person("Anna", 28, "Armenian");
        Person person5 = new Person("Tokio", 50, "Japan");
        Person person6 = new Person("Tramp", 73, "American");
        List<Person> people = Arrays.asList(person1, person2, person3, person4, person5, person6);
        System.out.println(getOldestPerson(people).getName() + " is oldest person from our collection");

        System.out.println();
        System.out.println("     Exercise 5          Exercise 5     Exercise 5     Exercise 5");
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(sumOfCollection1(integers) + " sum of integers collection1");
        System.out.println(sumOfCollection2(integers) + " sum of integers collection2");

        System.out.println();
        System.out.println("     Exercise 6          Exercise 6     Exercise 6     Exercise 6");
        Person Sara = new Person("Sara", 4);
        Person Viktor = new Person("Viktor", 40);
        Person Eva = new Person("Eva", 42);
        Person Anna = new Person("Anna", 5);
        List<Person> kidsCollection = Arrays.asList(Sara, Viktor, Eva, Anna);

        System.out.println(getKidsNames(kidsCollection) + " kids under 18");

        System.out.println();
        System.out.println("     Exercise 7          Exercise 7     Exercise 7     Exercise 7");
        Map<Boolean, List<Person>> result = partitionAdults(kidsCollection);
        System.out.print("Persons upper 18: ");
        result.get(true).forEach(adult -> System.out.print(adult.getName() + " "));
        System.out.println();
        System.out.print("Persons under 18: ");
        result.get(false).forEach(adult -> System.out.print(adult.getName() + " "));

        System.out.println();
        System.out.println();
        System.out.println("     Exercise 8          Exercise 8     Exercise 8     Exercise 8");
        System.out.print("Armenians : ");
        groupingByNationality(people).get("Armenian").forEach(each -> System.out.print(each.getName() + " "));
        System.out.println();
        System.out.print("Americans : ");
        groupingByNationality(people).get("American").forEach(each -> System.out.print(each.getName() + " "));
        System.out.println();
        System.out.print("Russians : ");
        groupingByNationality(people).get("Russian").forEach(each -> System.out.print(each.getName() + " "));
        System.out.println();
        System.out.print("Japans : ");
        groupingByNationality(people).get("Japan").forEach(each -> System.out.print(each.getName() + " "));
        System.out.println();

        System.out.println();
        System.out.println("     Exercise 9          Exercise 9     Exercise 9     Exercise 9");
        System.out.println(peoplesNamesToString(people));


    }

    //ex1
    public static List<String> convertCollectionElementsToUpperCase(List<String> stringList) {

        return stringList.stream()
                .map(each -> {
                    String string = each.toUpperCase();
                    return string;
                })
                .collect(Collectors.toList());
    }

    //ex2
    public static List<String> filterCollectionWithLength(List<String> stringList) {

        return stringList.stream()
                .filter(each -> each.length() < 4)
                .collect(Collectors.toList());
    }

    //ex3
    public static List<String> flatMapCollection(List<List<String>> collection) {

        return collection.stream()
                .flatMap(each -> each.stream()).collect(Collectors.toList());
    }

    //ex4
    public static Person getOldestPerson(List<Person> personsCollection) {
        return (personsCollection.stream().sorted().collect(Collectors.toList())).get(personsCollection.size() - 1);
    }

    //ex5
    public static Optional<Integer> sumOfCollection1(List<Integer> integersList) {
        Optional<Integer> result = integersList.stream().reduce((x, y) -> (x + y));
        return result;
    }

    //ex5_2
    public static int sumOfCollection2(List<Integer> integersList) {
        int result = integersList.stream().reduce(0, (x, y) -> (x + y));
        return result;
    }

    //ex6
    public static List<String> getKidsNames(List<Person> people) {
        return people.stream()
                .filter(person -> person.getAge() < 18)
                .map(kids -> kids.getName())
                .collect(Collectors.toList());
    }

    //ex7
    public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {
        return people.stream().collect(Collectors.partitioningBy(each -> each.getAge() > 18));
    }

    //ex8
    public static Map<String, List<Person>> groupingByNationality(List<Person> people) {
        return people.stream().collect(Collectors.groupingBy(each -> each.getNationality()));
    }

    //ex9
    public static String peoplesNamesToString(List<Person> people) {
        String names = "Names : ";
        names += people.stream().map(each -> each.getName()).collect(Collectors.joining(", "));
        return names;
    }
}

