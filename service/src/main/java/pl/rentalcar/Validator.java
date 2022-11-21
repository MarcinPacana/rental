package pl.rentalcar;

import pl.rentalcar.entity.Customer;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {


    public boolean validateCustomerForAdd(Customer customer){
        int counter = 4;
        String email = customer.getEmail();
        String password = customer.getPassword();
        String firstName = customer.getFirstName();
        String lastName = customer.getLastName();
        
        if (email != null && !email.equals("")){
            counter--;
        }
        if (password != null && !password.equals("")){
            counter--;
        }
        if (firstName != null && !firstName.equals("")){
            counter--;
        }
        if (lastName != null && !lastName.equals("")){
            counter--;
        }

        return counter == 0 && checkMail(email) && checkPassword(password);
    }

    public boolean validateCustomerForUpdate(Customer customer){
        int counter = 3;
        String email = customer.getEmail();
        String firstName = customer.getFirstName();
        String lastName = customer.getLastName();

        if (email != null && !email.equals("")){
            counter--;
        }
        if (firstName != null && !firstName.equals("")){
            counter--;
        }
        if (lastName != null && !lastName.equals("")){
            counter--;
        }

        return counter == 0 && checkMail(email);
    }

    public boolean isAllRequiredFieldNotEmptyForCar(HttpServletRequest request){
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry:parameterMap.entrySet()){
            String key = entry.getKey();
            if (key.equals("image")){
                continue;
            }
            String[] value = entry.getValue();
            if (value.length == 0 || value[0].equals("")){
                return false;
            }
        }
        return true;
    }

    public boolean checkMail(String mail) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(mail);
        if (matcher.matches()) return true;
        else return false;
    }

    private boolean checkPassword(String password) {
        Pattern pattern = Pattern.compile("^[A-Za-z1-9]+$");
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) return true;
        else return false;
    }

}
