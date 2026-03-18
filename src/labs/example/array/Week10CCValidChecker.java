

package labs.example.array;

public class Week10CCValidChecker 
{
    public boolean isValid(String cardNumber) 
    {

        int sum = 0;
        boolean doubleDigit = false;

        // Loop from right to left
        for (int i = cardNumber.length() - 1; i >= 0; i--) 
            {

            int digit = cardNumber.charAt(i) - '0';

            if (doubleDigit) 
                {
                digit = digit * 2;

                if (digit > 9) 
                {
                    digit = digit - 9;
                }
            }

            sum += digit;
            doubleDigit = !doubleDigit;
        }

        return (sum % 10 == 0);
    }
}
