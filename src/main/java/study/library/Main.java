package study.library;

import study.library.dao.BookDao;
import study.library.dao.UserDao;
import study.library.dao.nosql.impl.BookDaoNoSqlImpl;
import study.library.dao.nosql.impl.UserDaoNoSqlImpl;
import study.library.dao.sql.impl.BookDaoSqlImpl;
import study.library.dao.sql.impl.UserDaoSqlImpl;
import study.library.model.Book;
import study.library.model.User;

import java.util.Scanner;

/**
 * Created by yauhen on 19.12.16.
 */
public class Main {
    private static final String HELLOSTRING = "\n\nSelect option:"
            + "\n1.Show users"
            + "\n2.Show books"
            + "\n3.New user"
            + "\n4.New book"
            + "\n5.Delete user"
            + "\n6.Delete book"
            + "\n7.Show free books"
            + "\n8.Show books assigned to user"
            + "\n9.Assign book to user"
            + "\n10.Unassign book from user"
            + "\n0.Exit";
    private static UserDao userDao;
    private static BookDao bookDao;
    private static Boolean flag = true;

    public static void main(String[] args) {
        args = new String[]{"NoSQL"};
        switch (args[0]) {
            case "SQL": {
                userDao = new UserDaoSqlImpl();
                bookDao = new BookDaoSqlImpl();
                System.out.println("Running in SQL mode\n");
                break;
            }
            case "NoSQL": {
                userDao = new UserDaoNoSqlImpl();
                bookDao = new BookDaoNoSqlImpl();
                System.out.println("Running in NoSQL mode\n");
                break;
            }
            default: {
                System.err.println("WRONG PARAM");
                flag = false;
                break;
            }

        }

        Scanner sc = new Scanner(System.in);
        while (flag) {
            System.out.println(HELLOSTRING);

            switch (sc.nextInt()) {
                case 1: {
                    userDao.load().forEach(System.out::println);
                    break;
                }
                case 2: {
                    bookDao.load().forEach(System.out::println);
                    break;
                }
                case 3: {
                    try {
                        User user = new User();
                        System.out.println("Login:");
                        user.setLogin(sc.next());
                        System.out.println("Password:");
                        user.setPassword(sc.next());
                        userDao.create(user);
                    } catch (Exception e) {
                        System.err.println("WRONG INPUT");
                        break;
                    }
                    break;
                }
                case 4: {
                    try {
                        Book toSave = new Book();
                        System.out.println("Book name:");
                        toSave.setName(sc.next());
                        System.out.println("Book author:");
                        toSave.setAuthor(sc.next());
                        bookDao.create(toSave);
                    } catch (Exception e) {
                        System.err.println("WRONG INPUT");
                        break;
                    }
                    break;
                }
                case 5: {
                    System.out.println("Username to delete:");
                    User toDel;
                    try {
                        toDel = userDao.load(sc.next());
                    } catch (Exception e) {
                        System.err.println("USER NOT FOUND");
                        break;
                    }
                    userDao.delete(toDel);
                    break;
                }
                case 6: {
                    System.out.println("Book id to delete:");
                    Book toDel;
                    try {
                        toDel = bookDao.load(sc.nextLong());
                    } catch (Exception e) {
                        System.err.println("WRONG ID");
                        break;
                    }
                    bookDao.delete(toDel);
                    break;
                }
                case 7: {
                    try {
                        for (Book book : bookDao.load()) {
                            if (book.getAuthor() != null)
                                System.out.println(book.toString());
                        }
                    } catch (Exception e) {
                        System.err.println("WRONG INPUT");
                        break;
                    }
                    break;
                }
                case 8: {
                    System.out.println("Username:");
                    User user;
                    try {
                        user = userDao.load(sc.next());
                    } catch (Exception e) {
                        System.err.println("WRONG LOGIN");
                        break;

                    }
                    for (Book book : userDao.getAssignedBooks(user)) {
                        System.out.println(book.toString());
                    }
                    break;
                }
                case 9: {
                    try {
                        System.out.println("Username:");
                        User user = userDao.load(sc.next());
                        System.out.println("Book name:");
                        Book book = bookDao.load(sc.next());
                        book.setOwner(user);
                        bookDao.create(book);
                    } catch (Exception e) {
                        System.err.println("WRONG INPUT");
                        break;
                    }
                    break;
                }
                case 10: {
                    try {
                        System.out.println("Book name:");
                        Book book = bookDao.load(sc.next());
                        book.setOwner(null);
                        bookDao.create(book);
                    } catch (Exception e) {
                        System.err.println("WRONG INPUT");
                        break;
                    }
                    break;
                }
                case 0: {
                    flag = false;
                    break;

                }
                default: {
                    System.err.println("WRONG INPUT");
                    break;
                }
            }
        }
    }
}
