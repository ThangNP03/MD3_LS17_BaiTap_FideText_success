import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Products> products;

    public static void main(String[] args) {
        products =readProduct();
        System.out.println("nhập số sản phẩm muốn thêm:");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Products product = createProduct();
            products.add(product);
        }
        writeProduct();
        showProduct();
        System.out.println("bạn muốn tìm kiếm sản phẩm gì?");
        String searchProduct = scanner.nextLine();
        searchProduct(searchProduct);
    }

    public static void writeProduct() {
        try {
            File file = new File("product.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            fos.close();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Products> readProduct(){
        File file = new File("product.txt");
        try {
            if (file.exists()){
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                List<Products> list = (List<Products>) ois.readObject();
                return list;
            }
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>();
    }

    public static Products createProduct() {
        Products product = new Products();
        if (products.isEmpty()) {
            product.setId(1);
        } else {
            int newId = products.get(products.size() - 1).getId() + 1;
            product.setId(newId);
        }
        System.out.println("nhập tên sản phẩm: ");
        product.setName(scanner.nextLine());
        System.out.println("nhập hãng sản xuất: ");
        product.setManufacturer(scanner.nextLine());
        System.out.println("nhập giá: ");
        product.setPrice(Float.parseFloat(scanner.nextLine()));
        return product;
    }
    public static void showProduct(){
        for (Products product:products) {
            System.out.println(product);
        }
    }
    public static void searchProduct(String name){
        for (Products product:products) {
            if (product.getName().equalsIgnoreCase(name)){
                System.out.println(product);
            }
        }
    }
}