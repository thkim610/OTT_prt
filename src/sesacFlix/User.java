package sesacFlix;

import java.util.*;


public class User implements Contents.OnFavorite{

	int userId;
	String userName;
	List<String>favorite; // ���� �������� cId�� ����
	
	//������
	public User(int userId, String userName) {
		this.userId = userId;
		this.userName = userName;
		favorite = new ArrayList<String>();
	}

	// ���� �������� ������Id ����Ʈ�� �߰�
	@Override
	public void addFavorite(String key) {
		favorite.add(key);
		
	}
	
}

