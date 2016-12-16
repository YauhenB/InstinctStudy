package jpa_task;

import jpa_task.dao.impl.AccountDaoImpl;
import jpa_task.dao.impl.ClientDaoImpl;
import jpa_task.model.Account;
import jpa_task.model.Client;
import jpa_task.util.HibernateUtil;

import java.util.Scanner;

public class Main {

    private static ClientDaoImpl clientDao = new ClientDaoImpl();
    private static AccountDaoImpl accountDao = new AccountDaoImpl();
    private static Boolean flag = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (flag) {
            System.out.println("\n\nSelect option:\n1.Show clients" +
                    "\n2.Show accounts\n3.New client\n4.New account" +
                    "\n5.Delete client\n6.Delete account\n0.Exit");

            switch (sc.nextInt()) {
                case 0:
                    flag = false;
                    break;
                case 1:
                    clientDao.getAll().forEach(System.out::println);
                    break;
                case 2:
                    accountDao.getAll().forEach(System.out::println);
                    break;
                case 3:
                    Client client = new Client();
                    System.out.println("Name:\n");
                    client.setName(sc.next());
                    System.out.println("Surname:\n");
                    client.setSurname(sc.next());
                    clientDao.create(client);
                    break;
                case 4:
                    Account account = new Account();
                    System.out.println("Login:\n");
                    account.setLogin(sc.next());
                    System.out.println("Password:\n");
                    account.setPassword(sc.next());
                    System.out.println("Owner id:\n");
                    Client owner = clientDao.getById(sc.nextLong());
                    account.setOwner(owner);
                    accountDao.create(account);
                    break;
                case 5:
                    System.out.println("Id of client to delete:\n");
                    clientDao.delById(sc.nextLong());
                    break;
                case 6:
                    System.out.println("Id of account to delete:\n");
                    accountDao.delById(sc.nextLong());

            }
        }

        HibernateUtil.shutdown();
    }
}