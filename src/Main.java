

import services.ApplicationService;

import services.servicesImpl.ApplicationServiceImpl;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
       ApplicationService service = new ApplicationServiceImpl();
        service.start();


    }
}