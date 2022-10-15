package pl.rentalcar;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class Validator {
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
}
