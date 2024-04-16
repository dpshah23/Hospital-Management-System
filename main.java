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

    void search() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name To Search : ");
        String name = sc.nextLine();
        String file = "patients.csv";
        BufferedReader reader = null;
        String line = "";
        try {
            System.out.println("id        name      age       mobile");
            System.out.println();
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row.length >= 2 && row[1].equalsIgnoreCase(name)) { 
                        for (String index : row) {
                            System.out.printf("%-10s", index);
                    }
                    System.out.println();
                }
            }
        } catch (Exception e) {
            System.out.println("Error Occurred: " + e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
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
        System.out.println("2. Show All Patients Details");
        System.out.println("3. Create New Appointment");
        System.out.println("4. See All Appointments");
        System.out.println("5. Search Patient");
        System.out.println("6. Exit");
        System.out.print("Enter Your choice: ");
        int no=sc.nextInt();

        switch (no) {
            case 1:
                patients addpatients=new patients();
                addpatients.addpatient();
                break;
            case 2:
                patients showtotal=new patients();
                showtotal.showpatients();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                patients seach=new patients();
                seach.search();
                break;
            case 6:
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