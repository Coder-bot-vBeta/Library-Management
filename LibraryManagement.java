import java.util.Scanner;

class LibraryManagement {

    static class Book {
        String name;
        String author;
        int id;
        Book next;
    }

    static class Student {
        String name;
        String email;
        String book;
        String a;
        int id;
        Student next;
    }

    static Book startLib = null;
    static Student start = null;

    public static void main(String[] args) {
        startLib = initializeLib(startLib);
        greetings();
        mainMenu();
    }

    static void greetings() {
        System.out.println("\n\n");
        System.out.println("\t\t\t     ****************************************");
        System.out.println("\t\t\t     *                                      *");
        System.out.println("\t\t\t     *                                      *");
        System.out.println("\t\t\t     *     ----------------------------     *");
        System.out.println("\t\t\t     *      WELCOME TO CENTRAL LIBRARY      *");
        System.out.println("\t\t\t     *     ----------------------------     *");
        System.out.println("\t\t\t     *                                      *");
        System.out.println("\t\t\t     *                                      *");
        System.out.println("\t\t\t     ****************************************");
        System.out.println("\n\n");
        System.out.println("\t\t\t     ****************************************");
        System.out.println("\t\t\t     *                                      *");
        System.out.println("\t\t\t     *       ------------------------       *");
        System.out.println("\t\t\t     *           CENTRAL LIBRARY            *");
        System.out.println("\t\t\t     *       ------------------------       *");
        System.out.println("\t\t\t     *                                      *");
        System.out.println("\t\t\t     *                                      *");
        System.out.println("\t\t\t     *        IIT Delhi,Delhi,India         *");
        System.out.println("\t\t\t     *     Email: mt1221277@iitd.ac.in      *");
        System.out.println("\t\t\t     *     Contact:   7013974844            *");
        System.out.println("\t\t\t     *                                      *");
        System.out.println("\t\t\t     ****************************************");
        System.out.println("\n\n\t\t\t             Press any key to continue: ");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

    static void mainMenu() {
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n\n");
            System.out.println("\n\t\t\t*************************************************");
            System.out.println("\n\t\t\t\t      MAIN MENU: ");
            System.out.println("\n\t\t\t\t     1.ISSUE OF BOOKS ");
            System.out.println("\n\t\t\t\t     2.RETURN OF BOOKS ");
            System.out.println("\n\t\t\t\t     3.DISPLAY STUDENT DETAILS ");
            System.out.println("\n\t\t\t\t     4.EXIT\n ");
            System.out.println("\n\t\t\t*************************************************");
            System.out.print("\n\t\t\t\t      Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    start = bookIssue(start);
                    break;
                case 2:
                    start = bookReturn(start);
                    break;
                case 3:
                    display(start);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("\n\t\t\t\t      ...Invalid Option!...\n");
                    System.out.println("\n\t\t\t\t      Press any key to try again: ");
                    try {
                        System.in.read();
                    } catch (Exception e) {
                    }
            }
        } while (choice != 4);
    }

    static Book initializeLib(Book start) {
        Book newBook1 = new Book();
        newBook1.name = "The Kite Runner";
        newBook1.author = "Khaled Hosseini";
        newBook1.id = 101;
        startLib = newBook1;

        Book newBook2 = new Book();
        newBook2.name = "To Kill A Mockingbird";
        newBook2.author = "Harper Lee";
        newBook2.id = 102;
        newBook1.next = newBook2;

        Book newBook3 = new Book();
        newBook3.name = "The Alchemist";
        newBook3.author = "Paulo Coelho";
        newBook3.id = 103;
        newBook2.next = newBook3;

        Book newBook4 = new Book();
        newBook4.name = "Pride And Prejudice";
        newBook4.author = "Jane Austen";
        newBook4.id = 104;
        newBook3.next = newBook4;

        Book newBook5 = new Book();
        newBook5.name = "A Tale Of Two Cities";
        newBook5.author = "Charles Dickens";
        newBook5.id = 105;
        newBook4.next = newBook5;

        return startLib;
    }

    static Student bookIssue(Student start) {
        Scanner sc = new Scanner(System.in);
        if (startLib == null) {
            System.out.println("\n\t\t\t\t No books left in the library to issue!\n\t\t\t\t Sorry for the inconvenience!\n");
        } else {
            Book ptr = startLib;
            System.out.println("\n\t*************** Books Available: ****************");
            int i = 1;
            while (ptr != null) {
                System.out.println("\n\t_________________________________________________");
                System.out.println("\n\t Book " + i);
                System.out.println("\n\t Book Title: " + ptr.name);
                System.out.println("\n\t Name of Author: " + ptr.author);
                System.out.println("\n\t Book ID: " + ptr.id);
                System.out.println("\n\t_________________________________________________");
                ptr = ptr.next;
                i++;
            }
            System.out.print("\n\n\t Enter the Book ID: ");
            int id = sc.nextInt();
            ptr = startLib;
            boolean flag = false;
            while (ptr != null) {
                if (ptr.id == id) {
                    flag = true;
                    break;
                }
                ptr = ptr.next;
            }
            if (flag) {
                ptr = startLib;
                while (ptr.id != id) {
                    ptr = ptr.next;
                }
                Student newStudent = new Student();
                System.out.println("\n\t Enter Student Details:\n ");
                System.out.print("\n\t Enter your Name: ");
                newStudent.name = sc.next();
                System.out.print("\n\t Enter your Email: ");
                newStudent.email = sc.next();
                newStudent.book = ptr.name;
                newStudent.a = ptr.author;
                newStudent.id = ptr.id;
                newStudent.next = null;
                System.out.println("\n\t Issue of Book ID " + newStudent.id + " done successfully!\n");
                System.out.println("\n\n\t*************************************************");
                if (start == null) {
                    start = newStudent;
                } else {
                    Student ptr2 = start;
                    while (ptr2.next != null) {
                        ptr2 = ptr2.next;
                    }
                    ptr2.next = newStudent;
                }
                startLib = deleteBook(newStudent.id);
                System.out.println("\n\n\t Press any key to go to the main menu: ");
                try {
                    System.in.read();
                } catch (Exception e) {
                }
            } else {
                System.out.println("\n\t\t      ...Invalid Option!...\n");
                System.out.println("\n\t\t      Press any key to try again: ");
                try {
                    System.in.read();
                } catch (Exception e) {
                }
            }
        }
        return start;
    }

    static Student bookReturn(Student start) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n\t*************** Books Submission: ****************");
        System.out.print("\n\n\t Enter your Book ID: ");
        int identity = sc.nextInt();
        Student ptr = start;
        boolean flag = false;
        while (ptr != null) {
            if (ptr.id == identity) {
                flag = true;
                break;
            }
            ptr = ptr.next;
        }
        if (flag) {
            int c = 0;
            ptr = start;
            while (ptr != null) {
                c++;
                ptr = ptr.next;
            }
            int d = 1;
            ptr = start;
            while (ptr.id != identity) {
                d++;
                ptr = ptr.next;
            }
            ptr = start;
            if (d == 1) {
                System.out.println("\n\t_________________________________________________");
                System.out.println("\n\t Student Name: " + start.name);
                System.out.println("\n\t Student Email: " + start.email);
                System.out.println("\n\t Name of Book Issued: " + start.book);
                System.out.println("\n\t_________________________________________________");
                System.out.println("\n\n\t Return of Book ID " + identity + " done successfully!\n");
                System.out.println("\n\n\t*************************************************");
                String bookname = start.book;
                String authorname = start.a;
                int id = start.id;
                start = start.next;
                addBook(bookname, authorname, id);
            } else {
                Student preptr = null;
                while (ptr.id != identity) {
                    preptr = ptr;
                    ptr = ptr.next;
                }
                System.out.println("\n\t_________________________________________________");
                System.out.println("\n\t Student Name: " + ptr.name);
                System.out.println("\n\t Student Email: " + ptr.email);
                System.out.println("\n\t Name of Book Issued: " + ptr.book);
                System.out.println("\n\t Book ID: " + ptr.id);
                System.out.println("\n\t_________________________________________________");
                String bookname = ptr.book;
                String authorname = ptr.a;
                int id = ptr.id;
                preptr.next = ptr.next;
                addBook(bookname, authorname, id);
            }
            System.out.println("\n\t Thank you! \n\t Do visit again! ");
            System.out.println("\n\n\t Press any key to go to the main menu: ");
            try {
                System.in.read();
            } catch (Exception e) {
            }
        } else {
            System.out.println("\n\tSorry the book doesn't exist! Please recheck the entered ID");
            System.out.println("\n\t\t\t\t      Press any key to try again: ");
            try {
                System.in.read();
            } catch (Exception e) {
            }
        }
        return start;
    }

    static void display(Student start) {
        Student ptr = start;
        while (ptr != null) {
            System.out.println("\n\t************* Details of Students: **************");
            System.out.println("\n\t_________________________________________________");
            System.out.println("\n\t\t Student Name: " + ptr.name);
            System.out.println("\n\t\t Student Email: " + ptr.email);
            System.out.println("\n\t\t Name of Book Issued: " + ptr.book);
            System.out.println("\n\t\t Book ID: " + ptr.id);
            System.out.println("\n\t_________________________________________________");
            System.out.println("\n\n\t*************************************************");
            ptr = ptr.next;
        }
        System.out.println("\n\n\t Press any key to go to the main menu: ");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

    static Book deleteBook(int id) {
        Book ptr = startLib, preptr = null;
        if (startLib.id == id) {
            startLib = startLib.next;
        } else {
            while (ptr != null && ptr.id != id) {
                preptr = ptr;
                ptr = ptr.next;
            }
            if (ptr != null) {
                preptr.next = ptr.next;
            }
        }
        return startLib;
    }

    static Book addBook(String bookname, String authorname, int id) {
        Book newBook = new Book();
        newBook.name = bookname;
        newBook.author = authorname;
        newBook.id = id;
        newBook.next = null;
        if (startLib == null) {
            startLib = newBook;
        } else {
            Book ptr = startLib;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = newBook;
        }
        return startLib;
    }
}
