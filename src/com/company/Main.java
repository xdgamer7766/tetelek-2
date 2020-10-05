package com.company;

        import java.io.File;
        import java.io.FileNotFoundException;
        import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static ArrayList<String> szavak = new ArrayList<String>();
        public static void beolvasas() throws FileNotFoundException {
        File txt = new File("szavak.txt");
        Scanner olvas = new Scanner(txt);
        while (olvas.hasNext()) {
            szavak.add(olvas.nextLine());
        }
        olvas.close();
    }


    public static void osszegzes() {
        int osszeg = 0;
        for (int i = 0; i < szavak.get(0).length(); i++) {
            osszeg += szavak.get(0).charAt(i);
        }
        System.out.println("  első szó ASCII kódja a " + osszeg );
    }


    public static void megszamolas() {
        int betus = 0;
        for (int i = 0; i < szavak.size(); i++) {
            for (int h = 0; h < szavak.get(i).length(); h++) {
                if (szavak.get(i).charAt(h) == 'e') betus++;
            }
        }
        System.out.println(betus + " 'e' betűs szavak szerepelnek.");
    }


    public static void eldontes(String keres) {
        int i=0;
        while(i < szavak.size() && ! szavak.get(i).equals(keres)) i++;
        if (i< szavak.size()) System.out.println("van ilyen");
        else System.out.println("nincs ilyen");
    }


    public static boolean eldontes2(String keres) {
        int i=0;
        while(i < szavak.size() && ! szavak.get(i).equals(keres)) i++;
        if (i< szavak.size()) return true;
        else return  false;
    }


    public static void kivalasztas(String keres) {
        if (eldontes2(keres)){
            int i=0;
            while (i < szavak.size()  &&  ! szavak.get(i).equals(keres))  i++;
            System.out.print("A keresett szó a(z) ");
            System.out.println(i+1+". helyen van");
        }

    }


    public static ArrayList<String> nagySzavak = new ArrayList<String>();


    public static void masolas () {
        for (int i = 0; i < szavak.size(); i++) {
            String szo = szavak.get(i);
            String nagySzo=szo.substring(0,1).toUpperCase()+szo.substring(1);
            nagySzavak.add(nagySzo);

        }
    }


    public static ArrayList<String> e = new ArrayList<String>();


    public static void kivalogatas(){
        for (int i = 0; i < szavak.size(); i++) {
            if(szavak.get(i).contains("e")){
                e.add(szavak.get(i));
            }
        }
    }


    public static ArrayList<String> paros = new ArrayList<String>();
    public static ArrayList<String> paratlan = new ArrayList<String>();


    public static void szetvalogatas(){
        for (int i = 0; i < szavak.size(); i++) {
            if (szavak.get(i).length() % 2 == 0){
                paros.add(szavak.get(i));
            }
            else{
                paratlan.add(szavak.get(i));
            }
        }
    }


    public static ArrayList<String> magyar_szavak = new ArrayList<String>();
    public static void beolvasas2() throws FileNotFoundException{
        
            File f = new File("magyar_szavak.txt");
            Scanner scr = new Scanner(f);
            while (scr.hasNext()) {
                magyar_szavak.add(scr.nextLine().toLowerCase());
            }
            scr.close();
        
    }


    public static ArrayList<String> both = new ArrayList<String>();
    public static void unio(){
        both.addAll(szavak);
        both.removeAll(magyar_szavak);
        both.addAll(magyar_szavak);
        Collections.sort(both);
    }

    
    public static ArrayList<String> intersection = new ArrayList<String>();
    public static void metszet(){
        int j;
        for (int i = 0; i < szavak.size(); i++) {
            j = 0;
            while(j < magyar_szavak.size() && szavak.get(i) != magyar_szavak.get(j)){
                j++; 
            }
            if (j < magyar_szavak.size()){
                intersection.add(szavak.get(i));
            }
        }
        System.out.println(intersection);
    }
    public static void main (String[]args) throws FileNotFoundException {

        beolvasas();
        osszegzes();
        megszamolas();
        eldontes("ostor");
        eldontes("ostoros");
        kivalasztas("ablak");
        kivalasztas("zseb");
        kivalasztas("ostoros");
        masolas();
        kivalogatas();
        szetvalogatas();
        beolvasas2();
        unio();
        metszet();


    }
}
