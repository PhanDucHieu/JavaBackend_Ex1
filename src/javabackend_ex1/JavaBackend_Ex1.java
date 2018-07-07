/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabackend_ex1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DatPT
 */
public class JavaBackend_Ex1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        KhachHang khachHang01, khachHang02;
        khachHang01 = new KhachHang();
        khachHang02 = new KhachHang();
        boolean check = false;
        String stNgaySinh;
        int maKhachHang;
        SimpleDateFormat formatdate = new SimpleDateFormat("dd/MM/yyyy");

        //Nhap du lieu
        Scanner scanner = new Scanner(System.in);

        //
        System.out.println("Nhap thong tin khach hang 1: ");
        do {
            try {
                System.out.print("\t Nhap ma khach hang la so nguyen: ");
                maKhachHang = Integer.parseInt(scanner.nextLine());
                khachHang01.maKhachHang = maKhachHang;
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("Ma khach hang nhap khong dung! Nhap lai");
                check = true;
            }
        } while (check);

        System.out.print("\t Nhap ten khach hang: ");

        khachHang01.tenKhachHang = scanner.nextLine();

        do {
            try {

                System.out.print("\t Nhap ngay sinh (dd/MM/yyyy): ");
                stNgaySinh = scanner.nextLine();
                Calendar calendar = Calendar.getInstance();
//                Date date = formatdate.parse(stNgaySinh);
//                System.out.println(formatdate.format(date));
                calendar.setTime(formatdate.parse(stNgaySinh));
                khachHang01.ngaySinh = calendar;
                check = false;
            } catch (ParseException ex) {
                System.out.println("\t Nhap dinh dang sai ngay thang! Nhap lai");
                check = true;
            }
        } while (check);

        // khách hàng 2
        System.out.println("Nhap thong tin khach hang 2: ");
        do {
            try {
                System.out.print("\t Nhap ma khach hang la so nguyen: ");
                int maKhachHang2 = Integer.parseInt(scanner.nextLine());
                if (khachHang01.maKhachHang == maKhachHang2) {
                    System.out.println("Trung ma khach hang 1! nhap lai");
                    check = true;
                } else {
                    khachHang02.maKhachHang = maKhachHang2;
                    check = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ma khach hang nhap khong dung! Nhap lai");
                check = true;
            }
        } while (check);

        System.out.print("\t Nhap ten khach hang: ");
        khachHang02.tenKhachHang = scanner.nextLine();

        do {
            try {

                System.out.print("\t Nhap ngay sinh (dd/MM/yyyy): ");
                stNgaySinh = scanner.nextLine();
                Calendar calendar = Calendar.getInstance();
//                Date date = formatdate.parse(stNgaySinh);
//                System.out.println(formatdate.format(date));
                calendar.setTime(formatdate.parse(stNgaySinh));
                khachHang02.ngaySinh = calendar;
                check = false;
            } catch (ParseException ex) {
                System.out.println("\t Nhap dinh dang sai ngay thang! Nhap lai");
                check = true;
            }
        } while (check);

        int tuoiKH1 = khachHang01.ngaySinh.get(Calendar.YEAR);
        int tuoiKH2 = khachHang02.ngaySinh.get(Calendar.YEAR);
        if (tuoiKH1 > tuoiKH2) {
            System.out.println("Khach hang 1 nhieu hơn khach hang 2: " + (tuoiKH1 - tuoiKH2) + " tuoi");
        } else {
            if (tuoiKH1 < tuoiKH2) {
                System.out.println("Khach hang 2 nhieu hơn khach hang 1: " + (tuoiKH2 - tuoiKH1) + " tuoi");
            } else {
                System.out.println("Hai khach hang bang tuoi nhau");
            }
        }

        System.out.println("Thong tin khach hang 1: ");
        System.out.println("\t Ma: " + khachHang01.maKhachHang);
        System.out.println("\t Ten : " + khachHang01.tenKhachHang);
        System.out.println("\t Ngay sinh: " + formatdate.format(khachHang01.ngaySinh.getTime()));

        System.out.println("Thong tin khach hang 2: ");
        System.out.println("\t Ma: " + khachHang02.maKhachHang);
        System.out.println("\t Ten : " + khachHang02.tenKhachHang);
        System.out.println("\t Ngay sinh: " + formatdate.format(khachHang02.ngaySinh.getTime()));
    }

}
