package sesacFlix;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class OTT {

	protected OTTArchive otA;
	List<Contents> contentList = new LinkedList<Contents>();
	List<String> cIdList = new LinkedList<String>();
	List<String> mIdList = new LinkedList<String>();
	int contentNum;
	User user;

	public OTT(OTTArchive otA, User user) {
		this.otA = otA;
		this.user = user;
	}

	//��ī�̺꿡�� ������ Id�� ������ ����Ʈ�� ����
	void setcList() {
		cIdList.addAll(otA.contentM.keySet());

	}

	//��ī�̺꿡�� �̵�� Id�� ������ ����Ʈ�� ����
	void setmList() {
		mIdList.addAll(otA.mediaM.keySet());
	}

	//�������� ����, �ٰŸ�, Ÿ���� ������.
	void showContentsList() {
		for (int i = 0; i < contentList.size(); i++) {
			System.out.println(i + 1 + ".---------------------------");
			System.out.println("����: " + contentList.get(i).title);
			System.out.println("�ٰŸ�: " + contentList.get(i).summary);
			System.out.println(contentList.get(i).type);
			System.out.println(contentList.get(i).views);
			System.out.println();
		}
	}

	//������ ���� ���(��ȸ�� ��)
	void rankContents() {
		setcList();

		contentList.clear(); // contentList�� ��� ���������� ���.
		for (int i = 0; i < otA.contentM.size(); i++) {
			String key;
			key = cIdList.get(i);
			Contents c = new Contents(otA, key);

			this.contentList.add(c);

		}

		Collections.sort(contentList);

		System.out.println("������ ����!!");
		showContentsList();

	}
	
	//��ȭ ������ ���
	void movieContents() {
		setcList();

		contentList.clear(); // contentList�� ��� ���������� ���.
		for (int i = 0; i < otA.contentM.size(); i++) {
			String key;
			if (otA.contentM.get(cIdList.get(i)).get("type").equals("��ȭ")) {

				key = cIdList.get(i);
				Contents c = new Contents(otA, key);

				this.contentList.add(c);
			}

		}

		Collections.sort(contentList);

		System.out.println("��ȭ ������");
		showContentsList();
	}

	//�ø��� ������ ���
	void seriesContents() {
		setcList();

		contentList.clear(); // contentList�� ��� ���������� ���.
		for (int i = 0; i < otA.contentM.size(); i++) {
			String key;
			if (otA.contentM.get(cIdList.get(i)).get("type").equals("�ø���")) {

				key = cIdList.get(i);
				Contents c = new Contents(otA, key);

				this.contentList.add(c);
			}

		}

		Collections.sort(contentList);

		System.out.println("�ø��� ������");
		showContentsList();

	}
	
	//���� ������ ��� 
	void favoriteContents() {
		contentList.clear(); // contentList�� ��� ���������� ���.
		for(int i=0; i<user.favorite.size();i++) {
			String key;
			key = user.favorite.get(i); //User Ŭ������ ��� ������Id�� �ϳ��� ������.
			Contents c = new Contents(otA, key); // ������Id�� ���� ������ �ν��Ͻ� ������.
			
			this.contentList.add(c); //����Ʈ�� ������ �ν��Ͻ��� ����
		}
		
		Collections.sort(contentList);
		
		System.out.println("���ɸ�� ������");
		showContentsList();
	}

	//������ ��ȣ �Է� ��, ���γ��� ������. 
	Contents detailContent(int contentNum) {
		this.contentNum = contentNum - 1;
		Contents detailList = contentList.get(this.contentNum);

		System.out.println("����: " + detailList.title);
		System.out.println("�ٰŸ�: " + detailList.summary);
		System.out.println("����: " + detailList.direc);
		System.out.println("����: " + detailList.year);
		System.out.println("�⿬: " + detailList.cast);
		System.out.println(detailList.type);
		System.out.println(0+". ���ϱ�");
		System.out.println();
		
		

		if (detailList.type.equals("��ȭ")) {

			Movie m = new Movie(otA, detailList.cId);
			m.setOnFavorite(user);
			m.movieInfo();
			return m;
		} else if (detailList.type.equals("�ø���")) {
			Series s = new Series(otA, detailList.cId);
			s.setOnFavorite(user);
			s.seriesInfo();

			return s;
		}
		return detailList;

	}

}
