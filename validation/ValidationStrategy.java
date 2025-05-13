package validation;

import pickupLocation.Location;

public interface ValidationStrategy {

    boolean validate(Location location);

    <T> boolean validate(T genericParameter);



}
