public class temp {
    public static void main(String[] args)
    {
        String str = "abc ";
        System.out.println(str.substring(str.indexOf(" ") +1));
    }

    public static int getWinningPlayer(int n)
    {
        int max = 0;
        int winner = 0;

        for(int i = 1; i <= n; i++)
        {
            int score = getScoreForOnePlayer();
            if(score >= max)
            {
                max = score;
                winner = i;
            }
        }
        return winner;
    }

    public static int getScoreForOnePlayer()
    {
        int a = rollDie(6);
        int b = rollDie(6);

        if(a == b)
        {
            return 0;
        }

        int sum = 0;

        while(a != b)
        {
            sum += a+b;
            a = rollDie(6);
            b = rollDie(6);
        }
        
        return sum;
    }

    public static int rollDie(int n )
    {
        return (int) ((Math.random()) *n+1);
    }

}
