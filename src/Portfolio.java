import java.util.ArrayList;
import java.util.Iterator;
public class Portfolio {

    private ArrayList<Stock> stocks;

    public Portfolio(){
	stocks = new ArrayList<Stock>();
    }

    public int getNumberOfStocks(){
	return stocks.size();
    }

    public String getStockInfo(int stockNumber){
		Stock c = stocks.get(stockNumber);
	String text = "";
	text += "Name: " + c.getName() + "\n";
	text += "Funds: " + c.getFunds() + " \n";
	return text;
    }
    
    public String getListOfStockNames(){
	String text = "";
	Iterator<Stock> it = stocks.iterator();
	while (it.hasNext()){
	    Stock c = it.next();
	    text += c.getName() + "\n";
	}
	return text;
    }
    
    public void addStock(Stock c){
	stocks.add(c);
    }

    public boolean deposit(String stockName, int amount){
	Iterator<Stock> it = stocks.iterator();
	boolean found = false;
	while (it.hasNext()){
	    Stock c = it.next();
	    if (c.getName().equals(stockName)){
		found = true;
		c.deposit(amount);
	    }
	}
	return found;
    }

	public boolean withdraw(String stockName, int amount){
		Iterator<Stock> it = stocks.iterator();
		boolean found = false;
		while (it.hasNext()){
			Stock c = it.next();
			if (c.getName().equals(stockName)){
				if(amount <= c.getFunds()){
					found = true;
					c.withdraw(amount);
				}


			}
		}

		return found;
	}
}
