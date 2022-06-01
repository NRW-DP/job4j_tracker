package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Optional<Student> rsl = Optional.empty();
        for (Student s : students.keySet()) {
            if (s.getAccount().equals(account)) {
                rsl = Optional.of(s);
                break;
            }
        }
        return rsl;
    }

    /*
     - реализация метода findByAccount с помощью Stream;

    public Student findByAccount(String account) {
    return students.keySet()
            .stream()
            .filter(s -> s.getAccount().equals(account))
            .findFirst()
            .orElse(null);
}
     */

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Subject> rsl = Optional.empty();
        Optional<Student> a = findByAccount(account);
        if (a.isPresent()) {
            Set<Subject> subjects = students.get(a.get());
            for (Subject subj : subjects) {
                if (name.equals(subj.getName())) {
                    rsl = Optional.of(subj);
                    break;
                }
            }
        }
        return rsl;
    }

    /*
    - реализация метода findByAccount с помощью Stream;

    public Subject findBySubjectName(String account, String name) {
    Student a = findByAccount(account);
    if (a != null) {
        return students.get(a)
                .stream()
                .filter(s -> s.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
    return null;
}
     */

}
