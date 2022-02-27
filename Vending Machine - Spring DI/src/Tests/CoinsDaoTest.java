package Tests;

import com.sg.vendingmachine.DAO.CoinsDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinsDaoTest {
    CoinsDao coinDao;

    @BeforeEach
    void setUp() {
        coinDao = new CoinsDao();
    }

    @Test
    @DisplayName("Check getChange method")// checks if one coin is returned if the change is value of one coin
    void testChange(){
        int [] wholeCoins = {1,5,10,20,50,100,200,500,1000};
        for(int i : wholeCoins){
            testGetExactChange(i);
        }
    }
    void testGetExactChange( int i){
        assertEquals(1,coinDao.getChange(i).size());
    }

}