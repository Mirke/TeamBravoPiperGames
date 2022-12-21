package teambravo.pipergames.Nicolina;

import teambravo.pipergames.Controllers.StaffController;

import java.util.List;
import java.util.Scanner;

import static teambravo.pipergames.Controllers.StaffController.getAllStaffsPrinted;

public class StaffMenu {

    StaffController staffController = new StaffController();

    public StaffMenu(StaffController theStaffController) {
        this.staffController = theStaffController;
    }

    public static void main(String[] args) {

        getAllStaffsPrinted();

            System.out.println("--------------------");
            System.out.println("--Select An Option--");
            System.out.println("--------------------");
            Scanner scanner = new Scanner(System.in);
            int input;

            while (true) {
                System.out.println("(0) List all staff members  (1) Add staff member  (2) Delete staff member  (3) Update staff member");
                input = scanner.nextInt();

                switch (input) {
                    case 0:
                        showAllStaff();
                        break;
                    case 1:
                        System.out.println("Add staff members");
                        break;
                    case 2:
                        System.out.println("Delete staff member");
                        break;
                    case 3:
                        System.out.println("Update staff member");
                        break;
                    default:
                        System.out.println("Invalid input. Try again.");
                        break;
                }
            }

            }
    private static void showAllStaff() {
        List<Staff> staffs = StaffController.getAllStaffsPrinted();
        System.out.println("------ Showing All Staff -------");
        for(Staff staff : staffs) {
            System.out.println(staff);
        }
    }


    }
