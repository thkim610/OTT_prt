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

	//아카이브에서 컨텐츠 Id를 가져와 리스트로 저장
	void setcList() {
		cIdList.addAll(otA.contentM.keySet());

	}

	//아카이브에서 미디어 Id를 가져와 리스트로 저장
	void setmList() {
		mIdList.addAll(otA.mediaM.keySet());
	}

	//컨텐츠의 제목, 줄거리, 타입을 보여줌.
	void showContentsList() {
		for (int i = 0; i < contentList.size(); i++) {
			System.out.println(i + 1 + ".---------------------------");
			System.out.println("제목: " + contentList.get(i).title);
			System.out.println("줄거리: " + contentList.get(i).summary);
			System.out.println(contentList.get(i).type);
			System.out.println(contentList.get(i).views);
			System.out.println();
		}
	}

	//컨텐츠 순위 목록(조회수 순)
	void rankContents() {
		setcList();

		contentList.clear(); // contentList에 담긴 콘텐츠들을 비움.
		for (int i = 0; i < otA.contentM.size(); i++) {
			String key;
			key = cIdList.get(i);
			Contents c = new Contents(otA, key);

			this.contentList.add(c);

		}

		Collections.sort(contentList);

		System.out.println("컨텐츠 순위!!");
		showContentsList();

	}
	
	//영화 컨텐츠 목록
	void movieContents() {
		setcList();

		contentList.clear(); // contentList에 담긴 콘텐츠들을 비움.
		for (int i = 0; i < otA.contentM.size(); i++) {
			String key;
			if (otA.contentM.get(cIdList.get(i)).get("type").equals("영화")) {

				key = cIdList.get(i);
				Contents c = new Contents(otA, key);

				this.contentList.add(c);
			}

		}

		Collections.sort(contentList);

		System.out.println("영화 컨텐츠");
		showContentsList();
	}

	//시리즈 컨텐츠 목록
	void seriesContents() {
		setcList();

		contentList.clear(); // contentList에 담긴 콘텐츠들을 비움.
		for (int i = 0; i < otA.contentM.size(); i++) {
			String key;
			if (otA.contentM.get(cIdList.get(i)).get("type").equals("시리즈")) {

				key = cIdList.get(i);
				Contents c = new Contents(otA, key);

				this.contentList.add(c);
			}

		}

		Collections.sort(contentList);

		System.out.println("시리즈 컨텐츠");
		showContentsList();

	}
	
	//관심 컨텐츠 목록 
	void favoriteContents() {
		contentList.clear(); // contentList에 담긴 콘텐츠들을 비움.
		for(int i=0; i<user.favorite.size();i++) {
			String key;
			key = user.favorite.get(i); //User 클래스에 담긴 콘텐츠Id를 하나씩 가져옴.
			Contents c = new Contents(otA, key); // 콘텐츠Id를 통해 콘텐츠 인스턴스 가져옴.
			
			this.contentList.add(c); //리스트에 콘텐츠 인스턴스를 저장
		}
		
		Collections.sort(contentList);
		
		System.out.println("관심목록 컨텐츠");
		showContentsList();
	}

	//컨텐츠 번호 입력 시, 세부내용 보여줌. 
	Contents detailContent(int contentNum) {
		this.contentNum = contentNum - 1;
		Contents detailList = contentList.get(this.contentNum);

		System.out.println("제목: " + detailList.title);
		System.out.println("줄거리: " + detailList.summary);
		System.out.println("감독: " + detailList.direc);
		System.out.println("연도: " + detailList.year);
		System.out.println("출연: " + detailList.cast);
		System.out.println(detailList.type);
		System.out.println(0+". 찜하기");
		System.out.println();
		
		

		if (detailList.type.equals("영화")) {

			Movie m = new Movie(otA, detailList.cId);
			m.setOnFavorite(user);
			m.movieInfo();
			return m;
		} else if (detailList.type.equals("시리즈")) {
			Series s = new Series(otA, detailList.cId);
			s.setOnFavorite(user);
			s.seriesInfo();

			return s;
		}
		return detailList;

	}

}
