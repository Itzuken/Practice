package ShareHouse;
import java.util.HashMap;
import java.util.Scanner;

class Singleton{
    private static Singleton INSTANCE;
    HashMap<Integer, String> mapa;
    private Singleton(){
        mapa = new HashMap<>();
        for(int i = 0; i <= 9; i++)
            mapa.put(i, null);
    }
    public static Singleton getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }
    public void addResident(int i, String str){
        mapa.put(i, str);
        System.out.println("Resident " + str + " moved in " + i+1 + " appartment" + "\n");
    }
    public void removeResident(int ap){
        mapa.put(ap, null);
        System.out.println("From " + (ap+1) + " appartment was evicted resident");
    }
    public void addAllResidents(String[] residAll){
        for(int key: mapa.keySet()){
            mapa.put(key, residAll[key]);
        }
        for(int key: mapa.keySet()){
            if(mapa.get(key) == null) System.out.println("List is not full");
        }
    }
    public void printAllResidents(){
        for( int key: mapa.keySet()){
            String value = mapa.get(key);
            System.out.println(key+1 + " --> " + value);
        }
    }
}
class ScannerTry{
    int valueInt;
    String valueString;
    int valueFromInputInt(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Write apratment number: ");
        valueInt = sc.nextInt();
        return valueInt-1;
    }
    String valueFromInputString(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Write the Name of resident: ");
        valueString = sc.nextLine();
        return valueString;
    }
}
public class ShareHouseOne {
    public static void main(String[] args){
        ScannerTry tryScan = new ScannerTry();
        Singleton sing = Singleton.getInstance();
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("5 commands: 1. Move-in, 2.Move-out, 3.All appartments,4.Move-in all, 5.Break");
            int numb;
            String str;
            int inputK = scan.nextInt();
            switch(inputK){
                case 1:{
                    numb = tryScan.valueFromInputInt();
                    str = tryScan.valueFromInputString();
                    sing.addResident(numb,str);
                    break;
                }
                case 2:
                    numb = tryScan.valueFromInputInt();
                    if(numb > 10) System.out.println("There is only 10 apartments in the house");
                    else sing.removeResident(numb);
                    break;
                case 3:
                    sing.printAllResidents();
                    break;
                case 4:
                    String[] strAll = new String[10];
                    for(int i = 0; i <= 9; i++) strAll[i] = tryScan.valueFromInputString();
                    sing.addAllResidents(strAll);
                    break;
                case 5:{
                    System.exit(0);}
            }
        } while(true);
    }
}
