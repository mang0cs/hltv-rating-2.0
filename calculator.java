import java.util.*;
import java.text.*;
/**
 * Calculates rating through formula and input from user
 *
 * @Erantha Arachchi
 * @8/23/21
 */

public class calculator
{
    public static String nearestKey(Map<String, Double> map, double target) {
        double minDiff = Double.MAX_VALUE;
        
        String player = "";
        for(Map.Entry<String,Double> entry : map.entrySet())
        {
            double key = entry.getValue();
            double diff = Math.abs((double) target - (double) key);
            if (diff < minDiff) {
                
                minDiff = diff;
                player = entry.getKey();
            }
        }
        return player;
    }
    public static void main(String[] args)
    {
        Map<String, Double> playerMap = new HashMap<String, Double>();
        Scanner user_input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
            

        // Adding players to compare to user
        // Top players via HLTV
        playerMap.put("s1mple", 1.25);
        playerMap.put("ZywOo", 1.24);
        playerMap.put("m0nesy", 1.15);
        playerMap.put("YEKINDAR", 1.13);
        playerMap.put("frozen", 1.14);
        playerMap.put("sh1ro", 1.25);
        playerMap.put("NiKo", 1.21);
        playerMap.put("Ax1Le", 1.21);
        playerMap.put("blameF", 1.20);
        playerMap.put("stavn", 1.15);
        playerMap.put("electronic", 1.08);
        playerMap.put("Spinx", 1.10);
        playerMap.put("b1t", 1.07);
        playerMap.put("huNter-", 1.11);
        playerMap.put("broky", 1.14);
        playerMap.put("Twistzz", 1.12);
        playerMap.put("ropz", 1.12);
        playerMap.put("HObbit", 1.11);
        playerMap.put("rain", 1.08);
        playerMap.put("syrsoN", 1.08);
        playerMap.put("dycha", 1.08);
        playerMap.put("REZ", 1.07);
        playerMap.put("konfig", 1.06);
        playerMap.put("TeSeS", 1.07);
        playerMap.put("tabseN", 1.03);
        playerMap.put("Magisk", 1.05);
        playerMap.put("sjuush", 1.04);
        playerMap.put("jabbi", 1.03);
        playerMap.put("cadiaN", 1.06);
        playerMap.put("Perfecto", 1.03);
        playerMap.put("dupreeh", 1.01);
        playerMap.put("hampus", 0.99);
        playerMap.put("Maden", 1.00);
        playerMap.put("nafany", 0.98);
        playerMap.put("apEX", 0.90);
        playerMap.put("oSee", 1.04);
        playerMap.put("gla1ve", 0.92);
        playerMap.put("Snappi", 0.93);
        playerMap.put("Xyp9x", 0.94);
        playerMap.put("karrigan", 0.91);
        playerMap.put("es3tag", 0.94);
        playerMap.put("dexter", 0.92);
        playerMap.put("nitr0", .89);
        // Initializing stat variables for calculation
        double kast;
        double kpr;
        double dpr;
        double adr;
        double apr;
        double impact;
        double rating;
        String player = "";
        System.out.println("Welcome to the HLTV Rating 2.0 Calculator!");
        System.out.println("Created by Erantha Arachchi");
        System.out.println("The formula used in this calculator can be found @ https://flashed.gg/posts/reverse-engineering-hltv-rating/");
        System.out.println("There are free CSGO stat websites that allow you to obtain the data needed for this calculator.");
        System.out.println("Let's see if you're as good as s1mple!");
        System.out.println("");

        // Receive data from user for calculation
        System.out.println("Please input your KAST (% of rounds where player had kill, assist, survived or was traded)");
        System.out.print("Enter as a percentage without the symbol: ");
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
        user_input.close();
        //First calculates impact to use in rating calculation.
        impact = (2.13*kpr+(.42*apr)-.41);
        
        rating = ((0.00738764*kast)+(0.35912389*kpr)+(-0.5329508*dpr)+(0.2372603*impact) +(0.0032397*adr)+.1587);
        rating = rating-.01;
        //Finds closes player comparison
        player = nearestKey(playerMap, rating);
        System.out.println("______________________________________________________________________________________________________________________________________");
        System.out.println("");
        //Round off rating and impact to display like hltv website
        //Rating calculation seems to have a error of +.01
        System.out.println("Rating: " + df.format(rating));
        System.out.println("Impact: " + df.format(impact));
        System.out.println("");
        // Prints special message based on rating
        
        if(rating > 1.25)
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
        else if(rating > 1.10 && rating <= 1.25)
        {
            System.out.println("You're the carry! Clicking heads comes naturally to you.");
        }
        
        System.out.println("");
        System.out.println("Your closest pro player comparison is: " + player);
        System.out.println("");
        System.out.println("Keep in mind this calculator has some error, usually in the hundredths.");
        System.out.println("");

        //TODO add a way to calculate multiple ratings
      /*  System.out.println("Would you like to calculate another rating?");
        System.out.print("Type 1 for yes, 0 to exit: ");
        int ans = user_input.nextInt();
        if((ans % 2) == 0)
            */
        System.out.println("Thank you for using this calculator!");
        
    }
}
