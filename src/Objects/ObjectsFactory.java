package Objects;





public class ObjectsFactory {

public IObject getFruits(int type){
    
    //   1<=type<=151

        if(1<=type && type<21)
            return new Apple();

        if(21<=type && type<41)
            return new Banana();

        if(41<=type && type<61)
            return new Kiwi();

        if(61<=type && type<81)
                return new Orange();

        if(81<=type && type<101)
            return new Pineapple();

        if(101<=type && type<121)
            return new Watermelon();

        if(121<=type && type<131)
            return new DangerousBomb();
        
        if (131<=type && type<136)
            return new ExtraLife();
        
        if (136<=type&&type<141)
                return new DoubleScore();
        
        if (141<=type && type<146)
                return new HundredPoints();
        else
            return new FatalBomb();
        }






    
}
