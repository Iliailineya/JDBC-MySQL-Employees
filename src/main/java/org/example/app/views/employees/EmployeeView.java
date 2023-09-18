package org.example.app.views.employees;

import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.views.AppView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeView extends AppView {
    Scanner scanner;
    int option;

    public int chooseOption() {
        scanner = new Scanner(System.in);
        showMenu();
        try {
            option = scanner.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println(Constants.INCORRECT_VALUE_MSG);
            AppStarter.startApp();
        }
        return option;
    }

    private void showMenu() {
        System.out.print(Constants.EMPLOYEE_MENU);
    }
}
