import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Testing123 {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String carJson =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";

        try {
            Car car = objectMapper.readValue(carJson, Car.class);

            System.out.println("car brand = " + car.getBrand());
            System.out.println("car doors = " + car.getDoors());

            Car car2 = new Car();
            car2.setBrand("BMW");
            car2.setDoors(4);

            String json = objectMapper.writeValueAsString(car2);
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // main()
} //  class Testing123
