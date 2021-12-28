import java.util.Calendar;

import com.linkedoil.dao.TodayOilPriceDAO;

public class Test {
	public static void main(String[] args) {
		TodayOilPriceDAO dao = new TodayOilPriceDAO();
		dao.listTodayOil();
	}
}
