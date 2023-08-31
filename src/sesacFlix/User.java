package sesacFlix;

import java.util.*;


public class User implements Contents.OnFavorite{

	int userId;
	String userName;
	List<String>favorite; // 찜한 컨텐츠의 cId를 저장
	
	//생성자
	public User(int userId, String userName) {
		this.userId = userId;
		this.userName = userName;
		favorite = new ArrayList<String>();
	}

	// 찜한 컨텐츠의 컨텐츠Id 리스트에 추가
	@Override
	public void addFavorite(String key) {
		favorite.add(key);
		
	}
	
}

