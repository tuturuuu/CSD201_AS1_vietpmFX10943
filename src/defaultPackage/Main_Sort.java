package defaultPackage;

import java.io.IOException;
import java.util.Scanner;

public class Main_Sort {
    long start;
    long end;
    Scanner sc = new Scanner(System.in);
    int x=0;
    public void menu() throws IOException {
        //Chuong trinh se dung lai khi nguoi dung chon 8
        while(x!=8) {
            //In ra menu
            System.out.println("Hay lua chon tu 1 - 8: ");
            System.out.println("1. Nhap so thuc vao file input.txt ");
            System.out.println("2. Doc du lieu tu tep input.txt ");
            System.out.println("3. Sap xep mang vua doc duoc tu buoc 2 theo thu tu tang dan bang thuat toan bubble sort va luu vao file output1.txt");
            System.out.println("4. Sap xep mang vua doc duoc tu buoc 2 theo thu tu tang dan bang thuat toan selection sort va luu vao file output2.txt");
            System.out.println("5. Sap xep mang vua doc duoc tu buoc 2 theo thu tu tang dan bang thuat toan insertion sort va luu vao file output3.txt");
            System.out.println("6. In ra vi tri cua tat ca cac phan tu co gia tri lon hon value bang phuong phap tim kiem tuyen tinh trong mang chua duoc sap xep");
            System.out.println("7. In ra man hinh vi tri cua phan tu dau tien co gia tri bang value trong mang da sap xep");
            System.out.println("8. Thoat chuong trinh ");
            System.out.print("\nHay nhap lua chon cua ban: ");
            //Nhan input tu nguoi dung va so sanh voi tung case
            switch(x=sc.nextInt()){
                case 1:
                    System.out.println("Lua chon 1:");
                    Algorithm.getInput();
                    break;
                case 2:
                    System.out.println("Lua chon 2: ");
                    Algorithm.readFile();

                    break;
                case 3:
                    System.out.println("Lua chon 3: ");
                    start = System.nanoTime();
                    Algorithm.bubbleSort();
                    end = System.nanoTime();
                    System.out.println("Execution time: "+(end-start)+" nanoseconds");
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Lua chon 4: ");
                    start = System.nanoTime();
                    Algorithm.selectionSort();
                    end = System.nanoTime();
                    System.out.println("Execution time: "+(end-start)+" nanoseconds");
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Lua chon 5: ");
                    start = System.nanoTime();
                    Algorithm.insertionSort();
                    end = System.nanoTime();
                    System.out.println("Execution time: "+(end - start)+" nanoseconds");
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Lua chon 6: ");
                    Algorithm.linearSearch();
                    break;
                case 7:
                    System.out.println("Lua chon 7: ");
                    System.out.println(Algorithm.binarySearch());
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Lua chon khong co trong chuong trinh");
                    break;
            }
        }
        //In ra dong thong bao khi thoat chuong trinh
        System.out.println("Ban da thoat chuong trinh");
    }


}
