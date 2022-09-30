import java.util.*;
import java.text.*;
/**
 * Calculates rating through formula and input from user
 *
 * @Erantha Arachchi
 * @8/23/21
 */
// TODO : add sound functionality for rating special messages
public class calculator
{
    public static void main(String[] args)
    {
        Scanner user_input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        // Initializing stat variables for calculation
        double kast;
        double kpr;
        double dpr;
        double adr;
        double apr;
        double impact;
        double rating;
        System.out.println("Welcome to the HLTV Rating 2.0 Calculator!");
        System.out.println("Created by Erantha Arachchi");
        System.out.println("The formula used in this calculator can be found @ https://flashed.gg/posts/reverse-engineering-hltv-rating/");
        System.out.println("There are free CSGO stat websites that allow you to obtain the data needed for this calculator.");
        System.out.println("Let's see if you're as good as s1mple!");
        System.out.println("");

        // Receive data from user for calculation
        System.out.println("Please input your KAST (% of rounds where player had kill, assist, survived or was traded)");
        System.out.print("Enter as a percentage without symbol: ");
        kast = user_input.nextDouble();
        System.out.println("");

        System.out.print("Please input your KPR (Kills per Round): ");
        kpr = user_input.nextDouble();
        System.out.println("");

        System.out.print("Please input your DPR (Deaths per Round): ");
        dpr = user_input.nextDouble();
        System.out.println("");

        System.out.print("Please input your ADR (Average Damage per Round): ");
        adr = user_input.nextDouble();
        System.out.println("");

        System.out.print("Please input your APR (Assists per Round): ");
        apr = user_input.nextDouble();
        System.out.println("");

        //First calculates impact to use in rating calculation.
        impact = (2.13*kpr+(.42*apr)-.41);
        
        rating = ((0.00738764*kast)+(0.35912389*kpr)+(-0.5329508*dpr)+(0.2372603*impact) +(0.0032397*adr)+.1587);
        
        //Round off rating and impact to display like hltv website
        //Rating calculation seems to have a error of +.01
        System.out.println("Rating: " + df.format(rating-.01));
        
        // Prints special message based on rating
        
        if(rating > 1.32)
        {
            System.out.println("Wow, you're even better than s1mple!");
        }
        else if(rating < 1.00)
        {
            System.out.println("Not looking so great, better hit some aim_botz asap.\nor just uninstall...");
        }
        else if(rating >= 1.00 && rating <= 1.05)
        {
            System.out.println("Pretty average, keep grinding!");
        }
        else if(rating > 1.05 && rating <= 1.10)
        {
            System.out.println("You're above average! Nice work!");
        }
        else if(rating > 1.10 && rating <= 1.32)
        {
            System.out.println("You're the carry! Clicking heads comes naturally to you.");
        }
        System.out.println("");
        System.out.println("Impact: " + df.format(impact));
        System.out.println("");
        System.out.print("Keep in mind this calculator has some error, usually in hundredths.");
        System.out.println("");
        System.out.println("Thank you for using this calculator!");
        user_input.close();
    }
}
