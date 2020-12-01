package system.utils;

public class IdIncrement {
    public static String increment(String id) {
        byte[] numbers = new byte[id.length()];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Byte.parseByte(
                Character.toString(id.charAt(i))
            );
        }

        boolean normalIncrement = false;

        for (int i = numbers.length - 1; i >= 0; i--) {
            byte oldNumber = numbers[i];

            if (oldNumber + 1 < 10) {
                numbers[i] = (byte) (oldNumber + 1);
                normalIncrement = true;
                break;
            }
            else {
                numbers[i] = (byte) 0;
            }
        }

        String partialId = "";

        for (int i = 0; i < numbers.length; i++) {
            partialId = partialId.concat(Byte.toString(numbers[i]));
        }

        System.gc();

        if (normalIncrement) {
            return partialId;
        }

        return "1".concat(partialId);
    }
}
