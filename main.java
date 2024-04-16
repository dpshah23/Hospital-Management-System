import java.util.*;
import java.io.*;

class patients{
    void showpatients(){
        String file="patients.csv";
        BufferedReader reader=null;
        String line="";
        try {
            reader=new BufferedReader(new FileReader(file));
            while((line=reader.readLine()) !=null){
                String[] row=line.split(",");
                for (String index : row) {
                    System.out.printf("%-10s",index);
                }
                System.out.println();
            }
            
        } catch (Exception e) {
            System.out.println("Error Occured...");
        }
       finally{
        try {
            reader.close();
        } catch (IOException e) {
           
            e.printStackTrace();
        }
       }
    }
}
class hospitalmanagement{

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        while(true){
        try{
        System.out.println("1. Add New Patient Details");
        System.out.println("2. Update Patient Details");
        System.out.println("3. Show All Patients Details");
        System.out.println("4. Create New Appointment");
        System.out.println("5. See All Appointments");
        System.out.println("6. Search Patient");
        System.out.print("Enter Your choice: ");
        int no=sc.nextInt();

        switch (no) {
            case 1:
                
                break;
            case 2:
                break;
            case 3:
                patients showtotal=new patients();
                showtotal.showpatients();
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        
            default:
                break;
        }
    }
    catch(Exception e){
        System.out.println("Error Occured....");
    }
    }
}
}