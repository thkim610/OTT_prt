package sesacFlix;

import java.util.*;


public class User implements Contents.OnFavorite{

	int userId;
	String userName;
	List<String>favorite; // ÂòÇÑ ÄÁÅÙÃ÷ÀÇ cId¸¦ ÀúÀå
	
	//»ı¼ºÀÚ
	public User(int userId, String userName) {
		this.userId = userId;
		this.userName = userName;
		favorite = new ArrayList<String>();
	}

	// ÂòÇÑ ÄÁÅÙÃ÷ÀÇ ÄÁÅÙÃ÷Id ¸®½ºÆ®¿¡ Ãß°¡
	@Override
	public void addFavorite(String key) {
		favorite.add(key);
		
	}
	
}

