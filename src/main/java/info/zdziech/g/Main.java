package info.zdziech.g;

import info.zdziech.g.Repository.ProductsRepository;
import info.zdziech.g.Repository.UsersRepository;
import info.zdziech.g.ShopProducts.Basket;
import info.zdziech.g.ShopProducts.Product;
import info.zdziech.g.Users.User;
import info.zdziech.g.Users.UserFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main  {


    public static void main(String[] args)  {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        UsersRepository usersRepository = context.getBean("usersRepository", UsersRepository.class);
        ProductsRepository productsRepository = context.getBean("productsRepository", ProductsRepository.class);

        Basket basket = new Basket();
        UserFactory userFactory = new UserFactory();

        Scanner sc = new Scanner(System.in);
        String password;
        String name;
        int phone;
        int selection;

        do {
            System.out.println("");
            System.out.println("Rejestracja --- wybierz 1 ");
            System.out.println("Logowanie ----- wybierz 2");
            System.out.println("Wyjście ------- wybierz 0 ");
            System.out.println("");
            selection = sc.nextInt();
            switch (selection) {
                case 1:
                    System.out.println("Wprowadź nazwę użutkownika:");
                    name = sc.next();
                    System.out.println(usersRepository.getuserDataName(name));
                        System.out.println("Wprowadź hasło: ");
                        password = sc.next();
                        System.out.println("Wprowadź numer telefonu: ");
                        phone = sc.nextInt();
                        try {
                             phone = sc.nextInt();
                        }
                        catch (Exception e)
                        {
                            System.out.println("Numer telefonu niepoprawny");
                        }
                    User client = userFactory.createUser("Client", name, password, phone );
                    System.out.println(client);
                    System.out.println(usersRepository.getuserDataName(name));
                    usersRepository.addUser(client);
                    System.out.println("Dziękujemy za rejestrację");
                    break;
                case 2:
                    System.out.println("Aby się zalogowac wprowadź nazwę użytkownika: ");
                    name = sc.next();
                    System.out.println("Wprowadź hasło: ");
                    password = sc.next();
                    System.out.println("Logowanie...");
//                    if (users.loginToStore(users.checkUser(name,usersRepository.getuserDataName(name) )
//                            ,users.checkPassword(password,usersRepository.getpassword(name))))
                   {
                        System.out.println("Witamy w sklepie online");
                        System.out.println("Dodej produkt do koszyka ---- wybierz 1");
                        System.out.println("Usuń produkt z koszyka ------ wybierz 2");
                        System.out.println("Sprawdź zawartośc koszyka --- wybierz 3");
                        System.out.println("Kup produkty z koszyka ------ wybierz 4");
                        System.out.println("Wyjście --------------------- wybierz 5");
                        int choose = sc.nextInt();
                        do {
                            if (choose == 1) {
                                System.out.println("Wprowadź kod produktu; ");
                                String idOfProduct = sc.next();
                                Product product = new Product(productsRepository.nameOfProduktu(idOfProduct),productsRepository.priceOfProduct(idOfProduct));
                                System.out.println(product + " Ilość ");
                                int quantity = sc.nextInt();
                                basket.add(product, quantity );
                                System.out.println("Cena: " + basket.getOrderValue());
                                System.out.println("Dodaj produkt: 1, Usuń produkt: 2, Pokaż listę: 3, Kup: 4, Wyjście; 5 ");
                                choose = sc.nextInt();
                            }
                             if (choose == 2) {
                                 System.out.println("Wprowadź kod produktu; ");
                                 String idOfProduct;
                                 idOfProduct = sc.next();
                                 System.out.println("Wprowadź ilość ");
                                 int quantity = sc.nextInt();
                                 Product product = new Product(productsRepository.nameOfProduktu(idOfProduct),productsRepository.priceOfProduct(idOfProduct));
                                 basket.remove(product, quantity );
                                 System.out.println(basket.toString());
                                 System.out.println("Dodaj produkt: 1, Usuń produkt: 2, Pokaż listę: 3, Kup: 4, Wyjście; 5 ");
                                 choose = sc.nextInt();
                            }
                             if (choose == 3) {
                                 System.out.println(basket.toString());
                                 System.out.println("całkowita cena za zamówienie " +basket.getOrderValue() + " PLN");
                                 System.out.println("Dodaj produkt: 1, Usuń produkt: 2, Kup: 4, Wyjście; 5 ");
                                choose =sc.nextInt();
                            }
                             if (choose == 4) {
                                System.out.println("Dzęukujemy za zakupy;");
                                System.out.println("Rachunek");
                                System.out.println(basket.toString());
                                System.out.println("Razem do zapłaty " + basket.getOrderValue()+ "  PLN ");
                                basket.clearBasket();
                                System.out.println("Aby sie wylogować wciśnij 5");
                                choose =sc.nextInt();
                            }
                        }

                            while (choose != 5) ;

                    }
//                     else {
//                        System.out.println("Zła nazwa użytkownika lub hasło");
//                    }

                    break;
                case 0:
                    System.out.println("Koniec");
                    break;
                default:
                    System.out.println("Wybór nieprawidłowy spróbuj jeszcze raz");
                    break;

            }
        }
        while (selection != 0 && selection != 2 );


    }
}

