package defaultPackage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Algorithm {
    private static int n=0;
    private static float[] a;
    private static float[] b;
    private static String fileName  = "src/input";

    //1. Nhap so thuc vao file input.txt
    public static void getInput() throws IOException {
        Scanner sc = new Scanner(System.in);
        do {
            //Nhap input tu nguoi dung
            System.out.print("Hay nhap so input ma ban muon tu 0-20: ");
            n = sc.nextInt();
            //Neu 0 <= input < 20 -> thoat khoi vong lap
            if(n<=20&&n>=0) break;
            else System.out.println("Hay nhap lai so input tu 0-20");
        }while(true);
        float[] array = new float[n];
        //Dung vong lap luu tung gia tri nguoi dung nhap vao 1 mang
        for(int i = 0; i < n;i++) {
            System.out.println("Hay nhap gia tri " + (i + 1));
            array[i] = sc.nextFloat();
        }
        //Lua mang do vao input.txt
        writeFile(fileName,array, n);
    }

    //2. Doc du lieu tu tep input.txt va luu vao mang a
    public static void readFile() throws IOException {
        float[] array = new float[n];
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        float data;
        //Dung scanner scan tung phan tu cua file
        for(int i =0;sc.hasNextFloat();i++){
            data = sc.nextFloat();
            array[i]=data;
        }
        //Luu mang a = mang array va hien thi cac phan tu trong mang
        a = array;
        displayArray(a);
        System.out.println();
    }

    //3.Sap xep mang vua doc duoc tu buoc 2 theo thu tu tang dan bang thuat toan bubble sort va luu vao file output1.txt
    public static float[] bubbleSort() throws IOException {
        boolean swapped = true;
        b=a;
        try {
            if (b != null) {
        while(swapped) {
            swapped = false;
            //Di qua tung phan tu cua mang
                for (int i = 0; i + 1 < n; i++) {
                    //Neu phan tu sau < phan tu truoc -> swap vi tri 2 phan tu
                    if (b[i] > b[i + 1]) {
                        swap(b,i, i + 1);
                        swapped = true;
                    }
                }
                //Hien thi tung phan tu trong mang qua moi vong lap
                displayArray(b);
                System.out.println();
                }
            }
            else {
                //Neu a==null -> nguoi dung chua chay lua chon 2 -> chay lua chon 2
                System.out.print("Chuong trinh tu dong chay lua chon 2 truoc 3: ");
                readFile();
                System.out.println();
                return bubbleSort();
            }
        }catch(ArrayIndexOutOfBoundsException e){
            //Neu file input chua co phan tu nao -> thong bao cho nguoi dung
            float[] x = {0};
            System.out.println("Hay chon lua chon 1 truoc lua chon 3");
            return x;
        }
        //Ghi vao file output1
        writeFile("src/output1",b,n);
        return b;
    }

    //4. Sap xep mang vua doc duoc tu buoc 2 theo thu tu tang dan bang thuat toan selection sort va luu vao file output2.txt
    public static float[] selectionSort() throws IOException{
        b=a;
        try {
            if(b!=null) {
                //Di qua tung phan tu trong mang
                for (int i = 0; i < n-1; i++) {
                    //Tim phan tu nho nhat -> thay vao vi tri i
                    for (int j = i + 1; j < n; j++) {
                        if (b[i] > b[j]) {
                            swap(b,i, j);
                        }
                    }
                    displayArray(b);
                    System.out.println();
                }
            } else{
                //Neu a==null -> nguoi dung chua chay lua chon 2 -> chay lua chon 2
                System.out.print("Chuong trinh tu dong chay lua chon 2 truoc 4: ");
                readFile();
                System.out.println();
                return selectionSort();
            }
        }catch(ArrayIndexOutOfBoundsException e){
            float[] x = {0};
            System.out.println("Hay chon lua chon 1 truoc lua chon 4");
            return x;
        }
        //Ghi vao file output2
        writeFile("src/output2",b,n);
        return b;
    }

    //5. Sap xep mang vua doc duoc tu buoc 2 theo thu tu tang dan bang thuat toan insertion sort va luu vao file output3.txt
    public static float[] insertionSort() throws IOException{
        b=a;
        try {
            if(b!=null){
                //Di qua tung phan tu
                for(int i =1;i<n;i++){
                    int j = i;
                    //So sanh phan tu j voi nhung phan tu truoc j -> sap xep vao dung vi tri
                    while(j>0&&b[j]<b[j-1]){
                        swap(b,j,j-1);
                        j--;
                    }
                    displayArray(b);
                    System.out.println();
                }
            } else{
                //Neu a==null -> nguoi dung chua chay lua chon 2 -> chay lua chon 2
                System.out.print("Chuong trinh tu dong chay lua chon 2 truoc 5: ");
                readFile();
                System.out.println();
                return insertionSort();
            }
        }catch(ArrayIndexOutOfBoundsException e){
            float[] x = {0};
            System.out.println("Hay chon lua chon 1 truoc lua chon 4");
            return x;
        }
        //Ghi vao file output3
        writeFile("src/output3",b,n);
        return b;
    }

    //6. In vi tri cac phan tu co gia tri > value -phuong phap tim kiem tuyen tinh- trong mang chua duoc sap xep luu vao output 4
    public static void linearSearch() throws IOException {
        File file = new File("src/output4");
        FileOutputStream outputStream = new FileOutputStream(file);
        String tempString = "";
        System.out.print("Mang truoc khi sap xep: ");
        readFile();
        Scanner sc = new Scanner(System.in);
        System.out.print("Hay nhap gia tri value: ");
        float value = sc.nextFloat();
        //Luu nhung phan tu lon hon value vao 1 String
        for(int i =0;i<n;i++){
            if(a[i]>value){
                tempString += ""+i+" ";
                System.out.println(i);
            }
        }
        //Luu string do vao file output4
        byte[] buff = tempString.getBytes(StandardCharsets.UTF_8);
        outputStream.write(buff,0,buff.length);
        outputStream.close();
    }

    //7. In ra man hinh vi tri cua phan tu dau tien co gia tri bang value trong mang da sap xep luu vao output 5
    public static int binarySearch() throws IOException {
        if(b!=null){
            File file = new File("src/output5");
            FileOutputStream outputStream = new FileOutputStream(file);
            Scanner sc = new Scanner(System.in);
            System.out.print("Hay nhap gia tri value: ");
            float value = sc.nextFloat();
            int start = 0;
            int end =n;
            while(start<=end){
                //Tim vi tri giua cua phan dang xet
                int middle = (start+end)/2;

                //Tim xem value nam o phan nao trong mang
                if(b[middle]<value){
                    start = middle+1;
                }
                if(b[middle]>value){
                    end = middle-1;
                }
                if(b[middle]==value){
                    //Neu tim thay vi tri cua value -> luu vao file output 5 + return vi tri can tim
                    String tempString = ""+middle+" ";
                    outputStream.write(tempString.getBytes(StandardCharsets.UTF_8));
                    return middle;
                }
            }
            outputStream.close();
        }
        else{
            //Neu nguoi dung chua sap xep hoac mang == null -> thong bao cho nguoi dung
            System.out.println("Hay dung lua chon 1,2,3,4,5 truoc lua chon 7");
            return -2;
        }
        //Neu value khong co trong mang -> return -1
        return -1;
    }

    //Ham hien thi tung phan tu cua mang
    public static void displayArray(float[] b){
        for(int i =0;i < b.length;i++) {
            System.out.print(b[i] + " ");
        }
    }

    //Ham trao doi vi tri cua 2 gia tri trong 1 mang
    private  static void swap(float[] a,int i,int j ){
        float temp;
        temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    //Ham viet 1 mang vao trong 1 file (n la so phan tu trong mang)
    private static void writeFile(String address, float[] array, int n) throws IOException {
        File file = new File(address);
        FileOutputStream outputStream = new FileOutputStream(file,false);
        String tempString="";
        for(int i = 0;i<n;i++){
            tempString += "" + array[i] +" ";
        }
        byte buff[] = tempString.getBytes(StandardCharsets.UTF_8);
        outputStream.write(buff,0,tempString.length());
        outputStream.close();
    }
}


