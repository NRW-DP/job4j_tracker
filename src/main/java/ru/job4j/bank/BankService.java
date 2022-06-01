package ru.job4j.bank;

import java.util.*;

/**
 * Класс позволяет работать с пользователем:
 * -добавлять пользователя;
 * -добавлять cчет пользователю;
 * -искать счёт по реквизитам;
 * -искать пользователя по паспорту;
 * -переводить деньги по счета на счет.
 *
 * @author Ivan H.
 * @version 1.0
 */
public class BankService {
    /**
     * Поле содержит всех пользователей системы с привязанными к ним счетами.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод позволяет добавить в систему нового пользователя
     *
     * @param user  новый добавляемый пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод позволяет найти пользователя по паспорту.
     *
     * @param passport  паспорт пользователя;
     * @return          возвращает пользователя или null;

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }
*/
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод позволяет добавить новый счет пользователю.
     *
     * @param passport  паспорт пользователя;
     * @param account   новый счет пользователя;
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод позволяет найти счет по реквизитам.
     *
     * @param passport  паспорт пользователя;
     * @param requisite реквизиты;
     * @return -        возвращает счет пользователя или null;

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        return findByPassport(passport)
                .flatMap(u -> users.get(u)
                        .stream()
                        .filter(v -> v.getRequisite().equals(requisite))
                        .findFirst());
    }

    /**
     * Метод позволяет перечислить деньги с одного счета на другой
     *
     * @param srcPassport   паспорт пользователя, который переводит деньги
     * @param srcRequisite  реквизиты счета пользователя, с которого переводятся деньги
     * @param destPassport  паспорт пользователя, который получает деньги
     * @param destRequisite реквизиты счета пользователя, с которого получает деньги
     * @param amount        суммы перевода
     * @return              возвращает true, если счета найдены и баланс счета позволяет выполнить перевод
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> src = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> dest = findByRequisite(destPassport, destRequisite);
        if (src.isPresent() && dest.isPresent() && src.get().getBalance() >= amount) {
            src.get().setBalance(src.get().getBalance() - amount);
            dest.get().setBalance(dest.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}

