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

    void addpatient(){
        Scanner sc= new Scanner(System.in);
        try {
            String file="patients.csv";
            FileWriter writer = new FileWriter(file, true); // Open in append mode
            System.out.print("Enter Patient Id : ");
            int id = sc.nextInt();
            sc.nextLine(); // Consume newline character
            System.out.print("Enter Patient Name : ");
            String name = sc.nextLine();
            System.out.print("Enter Patient Age : ");
            int age = sc.nextInt();
            sc.nextLine(); // Consume newline character
            System.out.print("Enter Patient Mobile Number : ");
            String mobile = sc.nextLine();
            
            String str = String.format("%d,%s,%d,%s%n", id, name, age, mobile);
            writer.append(str);
    
            System.out.println("Data Added Successfully");
            writer.close(); // Close the FileWriter
            
        } catch (Exception e) {
            System.out.println("Some Error Occurred : " + e);
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
        System.out.println("7. Exit");
        System.out.print("Enter Your choice: ");
        int no=sc.nextInt();

        switch (no) {
            case 1:
                patients addpatients=new patients();
                addpatients.addpatient();
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
            case 7:
                System.exit(1);
            default:
                System.out.println("Invalid Choice...");
                break;
        }
    }
    catch(Exception e){
        System.out.println("Error Occured...."+e);
    }
    
    }
   

   
}

}