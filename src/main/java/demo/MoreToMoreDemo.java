package demo;

class User {
    private String name;
    private int age;

    private Book[] books;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Book {
    private String title;
    private double price;

    private User[] users;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}


public class MoreToMoreDemo {
    public static void main(String[] args) {
        // 实体类
        Book book1 = new Book("《三国演义》", 69.8);
        Book book2 = new Book("《红楼梦》", 76.9);
        Book book3 = new Book("《西游记》", 88.6);

        User user1 = new User("赵小四", 23);
        User user2 = new User("王小六", 26);
        User user3 = new User("刘小七", 27);

        // 数据关系
        book1.setUsers(new User[]{user1, user2});
        book2.setUsers(new User[]{user1, user3});
        book3.setUsers(new User[]{user2, user3});

        user1.setBooks(new Book[]{book1, book2});
        user2.setBooks(new Book[]{book1, book3});
        user3.setBooks(new Book[]{book2, book3});

        // 数据展示
        for (User user : book1.getUsers()) {
            System.out.println(user);
        }

        for (Book book : user1.getBooks()) {
            System.out.println(book);
        }
        /**
         * User{name='赵小四', age=23}
         * User{name='王小六', age=26}
         * Book{title='《三国演义》', price=69.8}
         * Book{title='《红楼梦》', price=76.9}
         */
    }
}
