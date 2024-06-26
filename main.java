import java.util.*;
import java.io.*;

class patients {
    void showpatients() {
        String file = "patients.csv";
        BufferedReader reader = null;
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                for (String index : row) {
                    System.out.printf("%-10s", index);
                }
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("Error Occured...");
        }

        finally {
            try {
                reader.close();
            }

            catch (IOException e) {

                e.printStackTrace();
            }

        }

    }

    void addpatient() {
        Scanner sc = new Scanner(System.in);
        try {
            String file = "patients.csv";
            FileWriter writer = new FileWriter(file, true); 
            System.out.println();
            System.out.print("Enter Patient Id: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Patient Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Patient Age: ");
            int age = sc.nextInt();
            sc.nextLine(); 
            System.out.print("Enter Patient Mobile Number: ");
            String mobile = sc.nextLine();

            String str = String.format("%d,%s,%d,%s%n", id, name, age, mobile);
            writer.append(str);

            System.out.println("Data Added Successfully !");
            writer.close(); 

        } catch (Exception e) {
            System.out.println("Some Error Occurred: " + e);
        } finally {
            sc.close();
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
            System.out.println("Error Occurred ! " + e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                    sc.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

class appointments {
    void addappointment() {
        Scanner sc = new Scanner(System.in);
        try {
            String file = "appointments.csv";
            FileWriter writer = new FileWriter(file, true);
            System.out.print("Enter Patient Id: ");
            String id = sc.nextLine();
            sc.nextLine(); 
            System.out.print("Enter Patient Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Patient Age: ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Appointment Type: ");
            String type = sc.nextLine();

            String str = String.format("%s,%s,%d,%s%n", id, name, age, type);
            writer.append(str);

            System.out.println("Appointment Created Successfully !");
            writer.close();

        } catch (Exception e) {
            System.out.println("Some Error Occurred: " + e);
        } finally {
            sc.close();
        }

    }

    void seeallappointments() {

        String file = "appointments.csv";
        BufferedReader reader = null;
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                for (String index : row) {
                    System.out.printf("%-10s", index);
                }
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("Error Occured...!");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }

    }
}

class searchappointments {
    void redirect() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Search Appointments");
            System.out.println("1. Search By Name ");
            System.out.println("2. Search By ID");
            System.out.println("3. Search By Appointment Type");
            System.out.print("Enter Choice: ");
            int choice = sc.nextInt(); 
            sc.nextLine();         

            switch (choice) {
                case 1:
                    this.searchbyname();
                    break;
                case 2:
                    this.searchbyid();
                    break;
                case 3:
                    this.searchbytype();
                    break;
                default:
                    System.out.println("Invalid Choice...!");
                    break;
            }
        } catch (Exception e) {

        } finally {
            sc.close();
        }

    }

    void searchbyname() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name To Search : ");
        String name = sc.nextLine();
       
        String file = "appointments.csv";
        BufferedReader reader = null;
        String line = "";
        try {
            System.out.println("id        name      age       type");
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
                    sc.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    void searchbyid() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID To Search : ");
        String no = sc.nextLine();
       
        String file = "appointments.csv";
        BufferedReader reader = null;
        String line = "";
        try {
            System.out.println("id        name      age       type");
            System.out.println();
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");

                if (row.length >= 2 && row[0].equals(no)) {
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
                    sc.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    void searchbytype() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Appointment Type To Search: ");
        String type = sc.nextLine();
        String file = "appointments.csv";
        BufferedReader reader = null;
        String line = "";
        try {
            System.out.println("id        name      age       type");
            System.out.println();
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");

                if (row.length >= 2 && row[3].equalsIgnoreCase(type)) {
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
                    sc.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}

class hospitalmanagement {

    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        try {
            int i=0;
           
            while (i<1000) {
                System.out.println("<------- Welcome to Hospital Management System ------->");
                System.out.println();
                System.out.println("1. Add New Patient Details");
                System.out.println("2. Show All Patients Details");
                System.out.println("3. Create New Appointment");
                System.out.println("4. See All Appointments");
                System.out.println("5. Search Patient");
                System.out.println("6. Search Appointments");
                System.out.println("7. Exit");
                System.out.println();
                System.out.print("Enter Your choice: ");
                int no = sc1.nextInt();
                sc1.nextLine();
                
                switch (no) {
                    case 1:
                        patients addpatients = new patients();
                        addpatients.addpatient();
                        break;
                    case 2:
                        patients showtotal = new patients();
                        showtotal.showpatients();
                        break;
                    case 3:
                        appointments addAppointments = new appointments();
                        addAppointments.addappointment();
                        break;
                    case 4:
                        appointments seeall = new appointments();
                        seeall.seeallappointments();
                        break;
                    case 5:
                        patients seach = new patients();
                        seach.search();
                        break;
                    case 6:
                        searchappointments sa = new searchappointments();
                        sa.redirect();
                        break;
                    case 7:
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice...");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error Occurred....!" + e);
        } finally {
            sc1.close(); 
        }
    }
    
    }

   
