import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class CheckValueAnnotationValidator {
    public static boolean isValid(Object object) throws Exception{
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(CheckValue.class)) {
                field.setAccessible(true);
                CheckValue annotation = field.getAnnotation(CheckValue.class);
                String regex = annotation.regex();
                Object value = field.get(object);
                if (value == null) {
                    return false;
                }
                if (value != null && !Pattern.matches(regex, value.toString())) {
                    return false;
                }
            }
        }

        return true;
    }


}
