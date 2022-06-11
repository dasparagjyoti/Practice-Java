// Java code for calculating number of ways
// to distribute m mangoes amongst n people
// where all mangoes and people are identical

import java.util.*;

class GFG {

        public static int power(int x, int n) {
            if(n==0)
                return 1;
            if(x==0)
                return 0;



            return x*power(x,n-1);

        }
    }
